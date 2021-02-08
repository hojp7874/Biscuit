CREATE TABLE `a407`.`gBoard` (
  `gId` INT NOT NULL,
  `bId` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(30) NOT NULL,
  `nickname` VARCHAR(20) NOT NULL,
  `title` VARCHAR(50) NOT NULL,
  `contents` VARCHAR(500) NOT NULL,
  `noticeFlag` TINYINT(1) NOT NULL,
  `date` DATETIME NOT NULL,
  `category` INT NOT NULL,
  UNIQUE INDEX `gId_UNIQUE` (`gId` ASC) VISIBLE,
  PRIMARY KEY (`bId`),
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `nickname_UNIQUE` (`nickname` ASC) VISIBLE,
  CONSTRAINT `fk_gBoard_email`
    FOREIGN KEY (`email`)
    REFERENCES `a407`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_gboard_nickname`
    FOREIGN KEY (`nickname`)
    REFERENCES `a407`.`user` (`nickname`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_gboard_gId`
    FOREIGN KEY (`gId`)
    REFERENCES `a407`.`group` (`gId`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci
COMMENT = 'group board';
