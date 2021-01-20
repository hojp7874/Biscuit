CREATE TABLE `board` (
  `bId` int NOT NULL AUTO_INCREMENT,
  `email` varchar(30) NOT NULL,
  `title` varchar(50) NOT NULL,
  `contents` varchar(500),
  `noticeFlag` bool NOT NULL DEFAULT FALSE,
  `date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `category` int NOT NULL DEFAULT 0,
  PRIMARY KEY (`bId`),
  UNIQUE KEY `bId_UNIQUE` (`bId`),
  KEY `fk_board_email_idx` (`email`),
  CONSTRAINT `fk_board_email` FOREIGN KEY (`email`) REFERENCES `user` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;