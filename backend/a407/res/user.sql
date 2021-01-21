CREATE TABLE `user` (
  `email` varchar(30) NOT NULL,
  `nickname` varchar(20) NOT NULL,
  `password` varchar(256) NOT NULL,
  `picture` varchar(256) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `region` varchar(30) DEFAULT NULL,
  `admin` INT NOT NULL,
  PRIMARY KEY (`email`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='    ';