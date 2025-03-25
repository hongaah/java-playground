
CREATE TABLE `shiro_test`.`t_role` (
   `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
   `rolename` varchar(20) DEFAULT NULL COMMENT '角色名称',
   PRIMARY KEY (`id`)
) CHARSET=utf8mb4;

CREATE TABLE `shiro_test`.`t_user` (
   `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户主键',
   `username` varchar(20) NOT NULL COMMENT '用户名',
   `password` varchar(20) NOT NULL COMMENT '密码',
   `role_id` int(11) DEFAULT NULL COMMENT '外键关联role表',
   PRIMARY KEY (`id`),
   KEY `role_id` (`role_id`),
   CONSTRAINT `t_user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) CHARSET=utf8mb4;

CREATE TABLE `shiro_test`.`t_permission` (
     `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
     `permissionname` varchar(50) NOT NULL COMMENT '权限名',
     `role_id` int(11) DEFAULT NULL COMMENT '外键关联role',
     PRIMARY KEY (`id`),
     KEY `role_id` (`role_id`),
     CONSTRAINT `t_permission_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) CHARSET=utf8mb4;

INSERT INTO `shiro_test`.`t_role` (`id`, `rolename`) VALUES ('1', 'admin');
INSERT INTO `shiro_test`.`t_role` (`id`, `rolename`) VALUES ('2', 'teacher');
INSERT INTO `shiro_test`.`t_role` (`id`, `rolename`) VALUES ('3', 'student');
INSERT INTO `shiro_test`.`t_user` (`id`, `username`, `password`, `role_id`) VALUES ('1', 'csdn1', '123456', '1');
INSERT INTO `shiro_test`.`t_user` (`id`, `username`, `password`, `role_id`) VALUES ('2', 'csdn2', '123456', '2');
INSERT INTO `shiro_test`.`t_user` (`id`, `username`, `password`, `role_id`) VALUES ('3', 'csdn3', '123456', '3');
INSERT INTO `shiro_test`.`t_permission` (`id`, `permissionname`, `role_id`) VALUES ('1', 'user:*', '1');
INSERT INTO `shiro_test`.`t_permission` (`id`, `permissionname`, `role_id`) VALUES ('2', 'student:*', '2');
