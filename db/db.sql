DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
`id` int(11) NOT NULL AUTO_INCREMENT,
`address` varchar(255) DEFAULT NULL,
`age` int(11) DEFAULT NULL,
`name` varchar(255) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

create table persistent_logins (username varchar(64) not null, series varchar(64) primary key, token varchar(64) not null, last_used timestamp not null);

DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
  `id` varchar(36) NOT NULL,
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
  `del_flag` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0可用1封禁',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO `sys_user` VALUES ('acfc0e9232f54732a5d9ffe9071bf572', 'admin', '$2a$10$GySB750NJDS8xJCdMfhULuBzlNtAYU8Eafkug4d9Yxd1IsrF9dj2y', '24', '', '', '', null, 'acfc0e9232f54732a5d9ffe9071bf572', '2017-12-20 16:34:06', '2018-01-14 14:49:21', '0');
