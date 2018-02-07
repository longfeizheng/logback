/*
Navicat MySQL Data Transfer

Source Server         : localhost-mysql
Source Server Version : 80000
Source Host           : localhost:3306
Source Database       : dbperson

Target Server Type    : MYSQL
Target Server Version : 80000
File Encoding         : 65001

Date: 2018-02-07 16:01:12
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `persistent_logins`
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
`username` varchar(64) NOT NULL,
`series` varchar(64) NOT NULL,
`token` varchar(64) NOT NULL,
`last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`address` varchar(255) DEFAULT NULL,
`age` int(11) DEFAULT NULL,
`name` varchar(255) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', 'city', '22', 'admin');

-- ----------------------------
-- Table structure for `sys_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_menu`;
CREATE TABLE `sys_menu` (
`id` varchar(64) NOT NULL,
`name` varchar(255) NOT NULL,
`p_id` varchar(36) DEFAULT NULL,
`url` varchar(255) DEFAULT NULL,
`order_num` int(4) DEFAULT NULL COMMENT '排序字段',
`icon` varchar(255) DEFAULT NULL COMMENT '图标',
`create_by` varchar(32) DEFAULT NULL,
`create_date` datetime DEFAULT NULL,
`update_by` varchar(32) DEFAULT NULL,
`update_date` datetime DEFAULT NULL,
`permission` varchar(255) DEFAULT NULL COMMENT '权限',
`menu_type` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1栏目2菜单',
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_menu
-- ----------------------------
INSERT INTO `sys_menu` VALUES ('0e6c8d4cf09511e78a57201a068c6482', '删除', 'cff61424dfb311e7b555201a068c6482', null, '3', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-03 22:47:44', null, null, 'role:del', '1');
INSERT INTO `sys_menu` VALUES ('18bf8d5df09511e78a57201a068c6482', '新增', '3873ccc2dfda11e7b555201a068c6482', null, '1', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-03 22:48:01', null, null, 'nemu:add', '1');
INSERT INTO `sys_menu` VALUES ('2b56410cf09411e78a57201a068c6482', '新增', 'cff61424dfb311e7b555201a068c6482', null, '1', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-03 22:41:23', null, null, 'role:add', '1');
INSERT INTO `sys_menu` VALUES ('3873ccc2dfda11e7b555201a068c6482', '菜单管理', 'cfda8029dfb311e7b555201a068c6482', 'menu/showMenu', '1', '&#xe62a;', null, '2017-12-14 14:02:50', null, '2017-12-14 14:02:50', 'menu:show', '0');
INSERT INTO `sys_menu` VALUES ('433089a6eb0111e782d5201a068c6482', '编辑', 'cfe54921dfb311e7b555201a068c6482', '', null, '1', 'acfc0e9232f54732a5d9ffe9071bf572', '2017-12-27 20:27:11', null, null, 'user:update', '1');
INSERT INTO `sys_menu` VALUES ('5ae3d4e9f38e11e7aca0201a068c6482', '新增', 'e9a13e55f35911e7aca0201a068c6482', null, '1', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-07 17:37:30', null, null, 'job:add', '1');
INSERT INTO `sys_menu` VALUES ('6315968bf37111e7aca0201a068c6482', '停止', 'e9a13e55f35911e7aca0201a068c6482', null, '4', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-07 14:10:09', null, null, 'job:end', '1');
INSERT INTO `sys_menu` VALUES ('6931fd22f09611e78a57201a068c6482', '删除', 'b441914cee0811e7a60d201a068c6482', null, '1', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-03 22:57:26', null, null, 'control:del', '1');
INSERT INTO `sys_menu` VALUES ('69f3f59cf38e11e7aca0201a068c6482', '编辑', 'e9a13e55f35911e7aca0201a068c6482', null, '2', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-07 17:37:56', null, null, 'job:update', '1');
INSERT INTO `sys_menu` VALUES ('6dc13c6eec5f11e7a472201a068c6482', '系统日志', 'a1ca6642ec5e11e7a472201a068c6482', 'log/showLog', '1', '&#xe60a;', 'acfc0e9232f54732a5d9ffe9071bf572', '2017-12-29 14:43:46', null, '2017-12-29 14:43:46', 'log:show', '0');
INSERT INTO `sys_menu` VALUES ('788d8e34f38e11e7aca0201a068c6482', '删除', 'e9a13e55f35911e7aca0201a068c6482', null, '5', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-07 17:38:20', null, null, 'job:del', '1');
INSERT INTO `sys_menu` VALUES ('7967e098ee0611e7a60d201a068c6482', '接口api', 'a1ca6642ec5e11e7a472201a068c6482', 'swagger-ui.html', '2', '&#xe64e;', 'acfc0e9232f54732a5d9ffe9071bf572', '2017-12-31 16:42:04', null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('873f30b0f38e11e7aca0201a068c6482', '查看', 'e9a13e55f35911e7aca0201a068c6482', null, '6', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-07 17:38:45', null, null, 'job:select', '1');
INSERT INTO `sys_menu` VALUES ('88b8e5d1f38911e7aca0201a068c6482', '查看', 'cff61424dfb311e7b555201a068c6482', null, '4', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-07 17:03:00', null, null, 'role:select', '1');
INSERT INTO `sys_menu` VALUES ('a1ca6642ec5e11e7a472201a068c6482', '系统监控', null, null, '2', '&#xe62c;', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-03 10:56:14', null, '2018-01-03 10:56:14', null, '0');
INSERT INTO `sys_menu` VALUES ('b441914cee0811e7a60d201a068c6482', '系统监控', 'a1ca6642ec5e11e7a472201a068c6482', 'druid/index.html', '3', '&#xe628;', 'acfc0e9232f54732a5d9ffe9071bf572', '2017-12-31 16:58:01', null, null, null, '0');
INSERT INTO `sys_menu` VALUES ('cfda8029dfb311e7b555201a068c6482', '系统管理', null, null, '1', '&#xe614;', null, '2018-01-03 10:56:13', null, '2018-01-03 10:56:13', null, '0');
INSERT INTO `sys_menu` VALUES ('cfe54921dfb311e7b555201a068c6482', '用户管理', 'cfda8029dfb311e7b555201a068c6482', '/user/showUser', '2', '&#xe6af;', null, '2017-12-29 14:40:34', null, '2017-12-29 14:40:34', 'user:show', '0');
INSERT INTO `sys_menu` VALUES ('cfe54921dfb311e7b555201a068c6483', '增加', 'cfe54921dfb311e7b555201a068c6482', null, '1', null, null, null, null, null, 'user:select', '1');
INSERT INTO `sys_menu` VALUES ('cff61424dfb311e7b555201a068c6482', '角色管理', 'cfda8029dfb311e7b555201a068c6482', '/role/showRole', '3', '&#xe613;', null, '2017-12-29 14:40:36', null, '2017-12-29 14:40:36', 'role:show', '0');
INSERT INTO `sys_menu` VALUES ('e3b11497eb9e11e7928d201a068c6482', '删除', 'cfe54921dfb311e7b555201a068c6482', '', null, '', 'acfc0e9232f54732a5d9ffe9071bf572', '2017-12-28 15:17:07', null, '2017-12-28 15:17:07', 'user:del', '1');
INSERT INTO `sys_menu` VALUES ('e9a13e55f35911e7aca0201a068c6482', '定时任务', 'a1ca6642ec5e11e7a472201a068c6482', '/job/showJob', '3', '&#xe756;', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-07 11:22:06', null, null, 'job:show', '0');
INSERT INTO `sys_menu` VALUES ('ecda560cf36f11e7aca0201a068c6482', '启动', 'e9a13e55f35911e7aca0201a068c6482', null, '3', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-07 13:59:41', null, null, 'job:start', '1');
INSERT INTO `sys_menu` VALUES ('f23f6a6bf09511e78a57201a068c6482', '修改密码', 'cfe54921dfb311e7b555201a068c6482', null, '4', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-03 22:54:06', null, null, 'user:repass', '1');
INSERT INTO `sys_menu` VALUES ('ff015ea5f09411e78a57201a068c6482', '编辑', 'cff61424dfb311e7b555201a068c6482', null, '2', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-03 22:47:18', null, null, 'role:update', '1');

-- ----------------------------
-- Table structure for `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
`id` varchar(64) NOT NULL,
`role_name` varchar(128) DEFAULT NULL,
`remark` varchar(255) DEFAULT NULL,
`create_by` varchar(32) DEFAULT NULL,
`create_date` datetime DEFAULT NULL,
`update_by` varchar(32) DEFAULT NULL,
`update_date` datetime DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role
-- ----------------------------
INSERT INTO `sys_role` VALUES ('0ea934e5e55411e7b983201a068c6482', 'group1', '一组', 'acfc0e9232f54732a5d9ffe9071bf572', '2017-12-20 15:04:44', null, '2018-01-02 11:41:43');
INSERT INTO `sys_role` VALUES ('2619a672e53811e7b983201a068c6482', 'admin', '管理员', 'acfc0e9232f54732a5d9ffe9071bf572', '2017-12-20 11:44:57', null, '2018-01-02 11:38:37');

-- ----------------------------
-- Table structure for `sys_role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
`role_id` varchar(64) NOT NULL,
`menu_id` varchar(64) NOT NULL,
KEY `fk_sysrolemenu_menu_idx` (`menu_id`),
KEY `fk_sysrolemenu_role` (`role_id`),
CONSTRAINT `fk_sysrolemenu_menu` FOREIGN KEY (`menu_id`) REFERENCES `sys_menu` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT `fk_sysrolemenu_role` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_menu
-- ----------------------------
INSERT INTO `sys_role_menu` VALUES ('0ea934e5e55411e7b983201a068c6482', '433089a6eb0111e782d5201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('0ea934e5e55411e7b983201a068c6482', '6931fd22f09611e78a57201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('0ea934e5e55411e7b983201a068c6482', '6dc13c6eec5f11e7a472201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('0ea934e5e55411e7b983201a068c6482', 'a1ca6642ec5e11e7a472201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('0ea934e5e55411e7b983201a068c6482', 'cfda8029dfb311e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('0ea934e5e55411e7b983201a068c6482', 'cfe54921dfb311e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '0e6c8d4cf09511e78a57201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '18bf8d5df09511e78a57201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '2b56410cf09411e78a57201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '3873ccc2dfda11e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '433089a6eb0111e782d5201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '5ae3d4e9f38e11e7aca0201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '6315968bf37111e7aca0201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '6931fd22f09611e78a57201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '69f3f59cf38e11e7aca0201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '6dc13c6eec5f11e7a472201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '788d8e34f38e11e7aca0201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '7967e098ee0611e7a60d201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '873f30b0f38e11e7aca0201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '88b8e5d1f38911e7aca0201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'a1ca6642ec5e11e7a472201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'b441914cee0811e7a60d201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'cfda8029dfb311e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'cfe54921dfb311e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'cfe54921dfb311e7b555201a068c6483');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'cff61424dfb311e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'e3b11497eb9e11e7928d201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'e9a13e55f35911e7aca0201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'ecda560cf36f11e7aca0201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'f23f6a6bf09511e78a57201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'ff015ea5f09411e78a57201a068c6482');

-- ----------------------------
-- Table structure for `sys_role_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
`user_id` varchar(64) NOT NULL,
`role_id` varchar(64) NOT NULL,
PRIMARY KEY (`user_id`,`role_id`),
KEY `fk_sysroleuser_role_idx` (`role_id`),
CONSTRAINT `fk_sysroleuser_role` FOREIGN KEY (`role_id`) REFERENCES `sys_role` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
CONSTRAINT `fk_sysroleuser_user` FOREIGN KEY (`user_id`) REFERENCES `sys_user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_role_user
-- ----------------------------
INSERT INTO `sys_role_user` VALUES ('7970d8a4-ca43-41bc-af32-5961f870e5bd', '0ea934e5e55411e7b983201a068c6482');
INSERT INTO `sys_role_user` VALUES ('acfc0e9232f54732a5d9ffe9071bf572', '0ea934e5e55411e7b983201a068c6482');
INSERT INTO `sys_role_user` VALUES ('7970d8a4-ca43-41bc-af32-5961f870e5bd', '2619a672e53811e7b983201a068c6482');
INSERT INTO `sys_role_user` VALUES ('acfc0e9232f54732a5d9ffe9071bf572', '2619a672e53811e7b983201a068c6482');

-- ----------------------------
-- Table structure for `sys_user`
-- ----------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
`id` varchar(64) NOT NULL,
`username` varchar(64) NOT NULL,
`password` varchar(128) NOT NULL,
`age` int(4) DEFAULT NULL,
`email` varchar(128) DEFAULT NULL,
`photo` varchar(255) DEFAULT NULL,
`real_name` varchar(18) DEFAULT NULL,
`create_by` varchar(32) DEFAULT NULL,
`update_by` varchar(32) DEFAULT NULL,
`create_date` datetime DEFAULT NULL,
`update_date` datetime DEFAULT NULL,
`del_flag` varchar(4) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('7970d8a4-ca43-41bc-af32-5961f870e5bd', 'test', '$2a$10$XL8Mz8X07xgDwK1iF6Lz6OiZdZuhKbJIV.o7.Tn8YcSUppIYDJ82.', null, null, null, null, null, null, null, '2018-02-07 15:59:25', '0');
INSERT INTO `sys_user` VALUES ('acfc0e9232f54732a5d9ffe9071bf572', 'admin', '$2a$10$GySB750NJDS8xJCdMfhULuBzlNtAYU8Eafkug4d9Yxd1IsrF9dj2y', '24', '', '', '', null, 'acfc0e9232f54732a5d9ffe9071bf572', '2017-12-20 16:34:06', '2018-01-14 14:49:21', '0');

-- ----------------------------
-- Table structure for `userconnection`
-- ----------------------------
DROP TABLE IF EXISTS `userconnection`;
CREATE TABLE `userconnection` (
`userId` varchar(255) NOT NULL,
`providerId` varchar(255) NOT NULL,
`providerUserId` varchar(255) NOT NULL,
`rank` int(11) NOT NULL,
`displayName` varchar(255) DEFAULT NULL,
`profileUrl` varchar(512) DEFAULT NULL,
`imageUrl` varchar(512) DEFAULT NULL,
`accessToken` varchar(512) NOT NULL,
`secret` varchar(512) DEFAULT NULL,
`refreshToken` varchar(512) DEFAULT NULL,
`expireTime` bigint(20) DEFAULT NULL,
PRIMARY KEY (`userId`,`providerId`,`providerUserId`),
UNIQUE KEY `UserConnectionRank` (`userId`,`providerId`,`rank`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of userconnection
-- ----------------------------
