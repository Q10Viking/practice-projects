/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2018-09-25 19:45:59
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `newslabel`
-- ----------------------------
DROP TABLE IF EXISTS `newslabel`;
CREATE TABLE `newslabel` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of newslabel
-- ----------------------------
INSERT INTO Newslabel VALUES ('1', '娱乐新闻', '0');
INSERT INTO Newslabel VALUES ('2', '体育新闻', '0');
INSERT INTO Newslabel VALUES ('3', 'NBA', '2');
INSERT INTO Newslabel VALUES ('4', 'CBN', '2');
INSERT INTO Newslabel VALUES ('5', '火箭', '3');
INSERT INTO Newslabel VALUES ('6', '湖人', '3');
INSERT INTO Newslabel VALUES ('7', '北京金隅', '4');
INSERT INTO Newslabel VALUES ('8', '浙江广厦', '4');
INSERT INTO Newslabel VALUES ('9', '青岛双星', '4');
INSERT INTO Newslabel VALUES ('10', '港台明星', '1');
INSERT INTO Newslabel VALUES ('11', '内地影视', '1');
