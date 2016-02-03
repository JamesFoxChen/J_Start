/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50710
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50710
File Encoding         : 65001

Date: 2016-02-03 18:10:53
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adminright
-- ----------------------------
DROP TABLE IF EXISTS `adminright`;
CREATE TABLE `adminright` (
  `AdminId` int(11) NOT NULL,
  `RightId` int(11) NOT NULL,
  `Created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`AdminId`,`RightId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adminright
-- ----------------------------
INSERT INTO `adminright` VALUES ('1', '1', '2016-02-03 17:56:42');
INSERT INTO `adminright` VALUES ('1', '2', '2016-02-03 17:57:00');
