/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50540
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50540
File Encoding         : 65001

Date: 2018-09-22 01:29:47
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `mybatis`
-- ----------------------------
DROP TABLE IF EXISTS `mybatis`;
CREATE TABLE `mybatis` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `username` varchar(30) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sex` int(2) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of mybatis
-- ----------------------------
INSERT INTO mybatis VALUES ('1', '王五', null, '2', null);
INSERT INTO mybatis VALUES ('10', '张三', '2014-07-10', '1', '北京市');
INSERT INTO mybatis VALUES ('16', '张小明', null, '1', '河南郑州');
