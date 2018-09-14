import requests
from urllib.parse import urlencode
import json
from bs4 import BeautifulSoup
import re
import json
import pymongo
import os
from config import *
from hashlib import md5
# 多进程
from multiprocessing import Pool
# MongoDB对象
client = pymongo.MongoClient(MONGO_URL)
# 数据库名称
db = client[MONGO_DB]


def get_page_index(offset, keyword):
    '''
    获取索引页的数据信息也就是json数据
    '''
    # 索引页请求的参数,抽出可变的部分：offset页面,keyword搜索内容
    data = {
        'offset': offset,
        'format': 'json',
        'keyword': keyword,
        'autoload': 'true',
        'count': 20,
        'cur_tab': 3,
        'from': 'gallery'
    }
    # 请求头
    headers = {
        "user-agent": "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.81 Safari/537.36"
    }
    # 构造请求链接
    url = "https://www.toutiao.com/search_content/?" + urlencode(data)
    # print(url)
    try:
        response = requests.get(url, headers=headers)
        # 请求成功返回数据
        if response.status_code == 200:
            return response.text
        return None
    except requests.RequestException:
        print("请求索引页出错")
        return None


def get_page_detail(url):
    '''
    获取详情页
    '''
    # 请求头
    headers = {
        "user-agent": "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.81 Safari/537.36"
    }
    try:
        response = requests.get(url, headers=headers)
        # 请求成功返回数据
        if response.status_code == 200:
            return response.text
        return None
    except requests.RequestException:
        print("请求详情页出错", url)
        return None


def parse_page_index(html):
    '''
    解析索引页，提取包含的详细页
    '''
    # 将字符创转化为json对象
    data = json.loads(html)
    # 因为是json对象，先提取key为data
    # 之后在对提取出来的json解析
    if data and 'data' in data.keys():
        for item in data.get('data'):
            yield item.get("article_url")


def parse_page_detail(html, url):
    '''
    解析详情页
    '''
    # 获取组图网页的title,用css选择器
    soup = BeautifulSoup(html, 'lxml')
    title = soup.select('title')[0].get_text()
    print(title, url)
    # image_pattern = re.compile('gallery: JSON.parse(.*?)\),', re.S)
    # ( )都需要转义、\( \)
    # 提取出来的内容
    # image_pattern = re.compile('gallery: JSON.parse\((.*?)\)', re.S)
    # 改进版本
    image_pattern = re.compile('gallery: JSON.parse\((.*?)\n', re.S)
    # 注意类型是 <class '_sre.SRE_Match'>
    result = re.search(image_pattern, html)
    if result:
        # 获取提取的内容
        content = result.group(1)
        # 剔除前后的" "),，(通过站点分析得到的处理方式)
        content = content[1:-3]
        # 消除转义带来的困扰
        content = eval("'{}'".format(content))

        # 转化为json对象
        data = json.loads(content)
        # print(data)
        # 获取链接

        if data and 'sub_images' in data.keys():
            sub_images = data.get("sub_images")
            # print(sub_images)
            images = [item.get('url') for item in sub_images]
            # 下载图片
            for image in images:
                download_image(image)
            return {
                "title": title,
                "url": url,
                "images": images
            }

    return None


def save_to_mongo(result):
    '''
    保存信息到MongDB中
    '''
    if db[MONGO_TABLE].insert(result):
        print("存储到MongDB成功", result)
        return True
    return False


def download_image(url):
    '''
    下载图片
    '''
    print("正在下载", url)
    headers = {
        "user-agent": "Mozilla/5.0 (Windows NT 6.2; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.81 Safari/537.36"
    }
    try:
        response = requests.get(url, headers=headers)
        if response.status_code == 200:
            save_image(response.content)
        return None
    except requests.RequestException:
        print("请求图片出错", url)
        return None


def save_image(content):
    '''
    保存到本地机上
    '''
    # 涉及到路径+文件名+后缀名
    # md5防止图片重复
    file_path = "{0}/{1}.{2}".format(os.getcwd() + "\\pictures", md5(content).hexdigest(), 'jpg')
    if not os.path.exists(file_path):
        with open(file_path, "wb") as f:
            f.write(content)
            f.close()


def main(offset):
    html = get_page_index(offset, KEYWORD)
    # 提取出所有的article_url
    '''
    for url in parse_page_index(html):
        print(url)
    '''
    # 处理每个索引页中的详情页
    for url in parse_page_index(html):
        html = get_page_detail(url)
        # print(url)
        if html:
            result = parse_page_detail(html, url)
            if result:
                save_to_mongo(result)
        # input("处理下一个")


if __name__ == '__main__':
    # main(0)
    # 设置offset
    groups = [x * 20 for x in range(GROUP_START, GROUP_END + 1)]
    pool = Pool()
    pool.map(main, groups)
