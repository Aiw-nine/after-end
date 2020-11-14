/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50517
Source Host           : localhost:3306
Source Database       : buscard

Target Server Type    : MYSQL
Target Server Version : 50517
File Encoding         : 65001

Date: 2019-12-31 17:41:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for commoncard
-- ----------------------------
DROP TABLE IF EXISTS `commoncard`;
CREATE TABLE `commoncard` (
  `id` varchar(20) NOT NULL,
  `money` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of commoncard
-- ----------------------------
INSERT INTO `commoncard` VALUES ('001', '96.00');
INSERT INTO `commoncard` VALUES ('002', '80.00');
