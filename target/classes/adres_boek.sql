-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema adres_boek
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema adres_boek
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `adres_boek` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `adres_boek` ;

-- -----------------------------------------------------
-- Table `adres_boek`.`geslacht`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adres_boek`.`geslacht` (
  `id` INT NOT NULL,
  `geslacht` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `naam` (`geslacht` ASC) INVISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `adres_boek`.`land`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adres_boek`.`land` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `naam` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `naam_uk` (`naam` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `adres_boek`.`persoon`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adres_boek`.`persoon` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `naam` VARCHAR(50) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `naam` (`naam` ASC) VISIBLE)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `adres_boek`.`kantoor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adres_boek`.`kantoor` (
  `id` INT NOT NULL,
  `afdeling` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `naam` (`afdeling` ASC) VISIBLE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `adres_boek`.`werkplaats_informatie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adres_boek`.`werkplaats_informatie` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `persoon_id` INT NOT NULL,
  `kantoor_id` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `persoon_fk_idx` (`persoon_id` ASC) VISIBLE,
  INDEX `kantoor_fk_idx` (`kantoor_id` ASC) VISIBLE,
  CONSTRAINT `kantoor_fk`
    FOREIGN KEY (`kantoor_id`)
    REFERENCES `adres_boek`.`kantoor` (`id`),
  CONSTRAINT `persoon_fk2`
    FOREIGN KEY (`persoon_id`)
    REFERENCES `adres_boek`.`persoon` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `adres_boek`.`contact_informatie`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `adres_boek`.`contact_informatie` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `adres` VARCHAR(50) NOT NULL,
  `telefoon_nummer` INT NOT NULL,
  `persoon_id` INT NOT NULL,
  `land_id` INT NOT NULL DEFAULT '1',
  `geslacht_id` INT NOT NULL,
  `werkplaats_id` INT NOT NULL DEFAULT '2',
  PRIMARY KEY (`id`),
  INDEX `land_fk_idx` (`land_id` ASC) VISIBLE,
  INDEX `persoon_fk_idx` (`persoon_id` ASC) VISIBLE,
  INDEX `geslacht_fk_idx` (`geslacht_id` ASC) INVISIBLE,
  INDEX `werkplaats_fk_idx` (`werkplaats_id` ASC) VISIBLE,
  CONSTRAINT `geslacht_fk`
    FOREIGN KEY (`geslacht_id`)
    REFERENCES `adres_boek`.`geslacht` (`id`),
  CONSTRAINT `land_fk`
    FOREIGN KEY (`land_id`)
    REFERENCES `adres_boek`.`land` (`id`),
  CONSTRAINT `persoon_fk`
    FOREIGN KEY (`persoon_id`)
    REFERENCES `adres_boek`.`persoon` (`id`),
  CONSTRAINT `werkplaats_fk`
    FOREIGN KEY (`werkplaats_id`)
    REFERENCES `adres_boek`.`werkplaats_informatie` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;