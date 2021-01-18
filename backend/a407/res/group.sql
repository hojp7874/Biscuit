CREATE TABLE `a407`.`group` (
  `gid` INT NOT NULL AUTO_INCREMENT,
  `max` INT NOT NULL,
  `sdate` DATETIME NOT NULL,
  `edate` DATETIME NOT NULL,
  `groupname` VARCHAR(20) NOT NULL,
  `groupdesc` VARCHAR(300) NULL,
  `category` VARCHAR(10) NOT NULL,
  `onoff` INT NOT NULL,
  `region` VARCHAR(10) NULL,
  `img` VARCHAR(100) NULL,
  `email` VARCHAR(30) NOT NULL,
  PRIMARY KEY (`gid`),
  UNIQUE INDEX `gid_UNIQUE` (`gid` ASC) VISIBLE,
  CONSTRAINT `email`
    FOREIGN KEY (`email`)
    REFERENCES `a407`.`user` (`email`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin
COMMENT = 'group info';


