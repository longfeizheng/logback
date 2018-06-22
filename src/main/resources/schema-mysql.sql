drop table if exists UserConnection;
create table UserConnection (userId varchar(255) not null,
                             providerId varchar(255) not null,
                             providerUserId varchar(255),
                             rank int not null,
                             displayName varchar(255),
                             profileUrl varchar(512),
                             imageUrl varchar(512),
                             accessToken varchar(512) not null,
                             secret varchar(512),
                             refreshToken varchar(512),
                             expireTime bigint,
  primary key (userId, providerId, providerUserId))
  ENGINE=InnoDB DEFAULT CHARSET=utf8;
create unique index UserConnectionRank on UserConnection(userId, providerId, rank);

DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
PRIMARY KEY (`series`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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

DROP TABLE IF EXISTS `sys_role_menu`;
CREATE TABLE `sys_role_menu` (
  `role_id` varchar(64) NOT NULL,
  `menu_id` varchar(64) NOT NULL,
KEY `fk_sysrolemenu_menu_idx` (`menu_id`),
KEY `fk_sysrolemenu_role` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


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
  `mobile` varchar(20) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `sys_role_user`;
CREATE TABLE `sys_role_user` (
  `user_id` varchar(64) NOT NULL,
  `role_id` varchar(64) NOT NULL,
PRIMARY KEY (`user_id`,`role_id`),
KEY `fk_sysroleuser_role_idx` (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
