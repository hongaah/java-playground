CREATE TABLE `user` (
  `id` int unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(60) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '用户名',
  `age` int DEFAULT NULL COMMENT '年龄',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

INSERT INTO `user` (`id`, `name`, `age`) VALUES  (1, 'user1', 11);
INSERT INTO `user` (`id`, `name`, `age`) VALUES  (2, 'user2', 19);
INSERT INTO `user` (`id`, `name`, `age`) VALUES  (3, 'user3', 16);

select * from user;
