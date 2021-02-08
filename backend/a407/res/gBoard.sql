CREATE TABLE `a407`.`gBoard` (
  `bId` INT NOT NULL AUTO_INCREMENT,
  `gId` INT NOT NULL,
  `email` VARCHAR(30) NOT NULL,
  `nickname` VARCHAR(20) NOT NULL,
  `title` VARCHAR(50) NOT NULL,
  `contents` VARCHAR(500) NOT NULL,
  `noticeFlag` TINYINT(1) NOT NULL,
  `date` DATETIME NOT NULL,
  `category` INT NOT NULL,
  PRIMARY KEY (`bId`),
  UNIQUE INDEX `bId_UNIQUE` (`bId` ASC) VISIBLE,
  INDEX `fk_gboard_gId_idx` (`gId` ASC) VISIBLE,
  INDEX `fk_gboard_email_idx` (`email` ASC) VISIBLE,
  INDEX `fk_gboard_nickname_idx` (`nickname` ASC) VISIBLE,
  CONSTRAINT `fk_gboard_gId`
    FOREIGN KEY (`gId`)
    REFERENCES `a407`.`group` (`gId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_gboard_email`
    FOREIGN KEY (`email`)
    REFERENCES `a407`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_gboard_nickname`
    FOREIGN KEY (`nickname`)
    REFERENCES `a407`.`user` (`nickname`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
COMMENT = 'Group Baord';
