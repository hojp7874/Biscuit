CREATE TABLE `a407`.`schedule` (
  `sId` INT NOT NULL AUTO_INCREMENT,
  `pgFlag` INT NOT NULL,
  `email` VARCHAR(30) NULL,
  `gId` INT NULL,
  `sdate` DATETIME NOT NULL,
  `edate` DATETIME NOT NULL,
  `title` VARCHAR(50) NOT NULL,
  `contents` VARCHAR(300) NULL,
  PRIMARY KEY (`sId`),
  UNIQUE INDEX `sId_UNIQUE` (`sId` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_cs_0900_ai_ci
COMMENT = 'schedule table';
