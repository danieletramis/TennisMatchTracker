SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `tmt` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;
USE `tmt` ;

-- -----------------------------------------------------
-- Table `tmt`.`player`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `tmt`.`player` (
  `playerId` INT NOT NULL ,
  `name` VARCHAR(45) NOT NULL ,
  PRIMARY KEY (`playerId`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `tmt`.`match`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `tmt`.`match` (
  `matchId` INT NOT NULL ,
  `firstPlayerId` INT NOT NULL ,
  `secondPlayerId` INT NOT NULL ,
  PRIMARY KEY (`matchId`) ,
  INDEX `fk_firstPlayer` (`firstPlayerId` ASC) ,
  INDEX `fk_secondPlayer` (`secondPlayerId` ASC) ,
  CONSTRAINT `fk_firstPlayer`
    FOREIGN KEY (`firstPlayerId` )
    REFERENCES `tmt`.`player` (`playerId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_secondPlayer`
    FOREIGN KEY (`secondPlayerId` )
    REFERENCES `tmt`.`player` (`playerId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;


-- -----------------------------------------------------
-- Table `tmt`.`point`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `tmt`.`point` (
  `poitId` BIGINT NOT NULL ,
  `match` INT NOT NULL ,
  `player` INT NOT NULL ,
  `pointType` VARCHAR(45) NULL ,
  `timestamp` TIMESTAMP NULL ,
  PRIMARY KEY (`poitId`) ,
  INDEX `fk_match` (`match` ASC) ,
  INDEX `fk_player` (`player` ASC) ,
  CONSTRAINT `fk_match`
    FOREIGN KEY (`match` )
    REFERENCES `tmt`.`match` (`matchId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_player`
    FOREIGN KEY (`player` )
    REFERENCES `tmt`.`player` (`playerId` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
