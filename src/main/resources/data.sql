INSERT INTO `sys_menu` VALUES ('0e6c8d4cf09511e78a57201a068c6482', '删除', 'cff61424dfb311e7b555201a068c6482', null, '3', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-03 22:47:44', null, null, 'role:del', '1');
INSERT INTO `sys_menu` VALUES ('18bf8d5df09511e78a57201a068c6482', '新增', '3873ccc2dfda11e7b555201a068c6482', null, '1', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-03 22:48:01', null, null, 'nemu:add', '1');
INSERT INTO `sys_menu` VALUES ('2b56410cf09411e78a57201a068c6482', '新增', 'cff61424dfb311e7b555201a068c6482', null, '1', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-03 22:41:23', null, null, 'role:add', '1');
INSERT INTO `sys_menu` VALUES ('3873ccc2dfda11e7b555201a068c6482', '菜单管理', 'cfda8029dfb311e7b555201a068c6482', '/menu/showMenu', '1', '&#xe62a;', null, '2017-12-14 14:02:50', null, '2017-12-14 14:02:50', 'menu:show', '0');
INSERT INTO `sys_menu` VALUES ('433089a6eb0111e782d5201a068c6482', '编辑', 'cfe54921dfb311e7b555201a068c6482', '', null, '1', 'acfc0e9232f54732a5d9ffe9071bf572', '2017-12-27 20:27:11', null, null, 'user:update', '1');
INSERT INTO `sys_menu` VALUES ('88b8e5d1f38911e7aca0201a068c6482', '查看', 'cff61424dfb311e7b555201a068c6482', null, '4', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-07 17:03:00', null, null, 'role:select', '1');
INSERT INTO `sys_menu` VALUES ('cfda8029dfb311e7b555201a068c6482', '系统管理', null, null, '1', '&#xe614;', null, '2018-01-03 10:56:13', null, '2018-01-03 10:56:13', null, '0');
INSERT INTO `sys_menu` VALUES ('cfe54921dfb311e7b555201a068c6482', '用户管理', 'cfda8029dfb311e7b555201a068c6482', '/user/showUser', '2', '&#xe6af;', null, '2017-12-29 14:40:34', null, '2017-12-29 14:40:34', 'user:show', '0');
INSERT INTO `sys_menu` VALUES ('cfe54921dfb311e7b555201a068c6483', '增加', 'cfe54921dfb311e7b555201a068c6482', null, '1', null, null, null, null, null, 'user:select', '1');
INSERT INTO `sys_menu` VALUES ('cff61424dfb311e7b555201a068c6482', '角色管理', 'cfda8029dfb311e7b555201a068c6482', '/role/showRole', '3', '&#xe613;', null, '2017-12-29 14:40:36', null, '2017-12-29 14:40:36', 'role:show', '0');
INSERT INTO `sys_menu` VALUES ('e3b11497eb9e11e7928d201a068c6482', '删除', 'cfe54921dfb311e7b555201a068c6482', '', null, '', 'acfc0e9232f54732a5d9ffe9071bf572', '2017-12-28 15:17:07', null, '2017-12-28 15:17:07', 'user:del', '1');
INSERT INTO `sys_menu` VALUES ('f23f6a6bf09511e78a57201a068c6482', '修改密码', 'cfe54921dfb311e7b555201a068c6482', null, '4', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-03 22:54:06', null, null, 'user:repass', '1');
INSERT INTO `sys_menu` VALUES ('ff015ea5f09411e78a57201a068c6482', '编辑', 'cff61424dfb311e7b555201a068c6482', null, '2', '', 'acfc0e9232f54732a5d9ffe9071bf572', '2018-01-03 22:47:18', null, null, 'role:update', '1');


INSERT INTO `sys_role` VALUES ('0ea934e5e55411e7b983201a068c6482', 'group1', '一组', 'acfc0e9232f54732a5d9ffe9071bf572', '2017-12-20 15:04:44', null, '2018-01-02 11:41:43');
INSERT INTO `sys_role` VALUES ('2619a672e53811e7b983201a068c6482', 'admin', '管理员', 'acfc0e9232f54732a5d9ffe9071bf572', '2017-12-20 11:44:57', null, '2018-01-02 11:38:37');

INSERT INTO `sys_role_menu` VALUES ('0ea934e5e55411e7b983201a068c6482', '433089a6eb0111e782d5201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('0ea934e5e55411e7b983201a068c6482', 'cfda8029dfb311e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('0ea934e5e55411e7b983201a068c6482', 'cfe54921dfb311e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '0e6c8d4cf09511e78a57201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '18bf8d5df09511e78a57201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '2b56410cf09411e78a57201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '3873ccc2dfda11e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '433089a6eb0111e782d5201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', '88b8e5d1f38911e7aca0201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'cfda8029dfb311e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'cfe54921dfb311e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'cfe54921dfb311e7b555201a068c6483');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'cff61424dfb311e7b555201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'e3b11497eb9e11e7928d201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'f23f6a6bf09511e78a57201a068c6482');
INSERT INTO `sys_role_menu` VALUES ('2619a672e53811e7b983201a068c6482', 'ff015ea5f09411e78a57201a068c6482');

INSERT INTO `sys_role_user` VALUES ('acfc0e9232f54732a5d9ffe9071bf572', '0ea934e5e55411e7b983201a068c6482');
INSERT INTO `sys_role_user` VALUES ('acfc0e9232f54732a5d9ffe9071bf572', '2619a672e53811e7b983201a068c6482');

INSERT INTO `sys_user` VALUES ('acfc0e9232f54732a5d9ffe9071bf572', 'admin', '$2a$10$NhM6ZszixLwo9x6igGpsiOyA73ABKyVTgIoUpj8GdDkUoCYc.pEWi', '24', 'test@qq.com', null, '管理员', null, null, null, '2018-02-27 20:41:11', null);
