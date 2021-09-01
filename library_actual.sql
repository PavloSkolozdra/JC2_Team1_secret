
-- MySQL Script generated by MySQL Workbench
-- Tue Aug 31 22:23:46 2021
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema library_v2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema library_v2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `library_v2` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `library_v2` ;

-- -----------------------------------------------------
-- Table `library_v2`.`author`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_v2`.`author` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `library_v2`.`book_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_v2`.`book_status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `status` ENUM('available', 'unavailable', 'deprecated') NOT NULL DEFAULT 'available',
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library_v2`.`book`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_v2`.`book` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(45) NOT NULL,
  `initial_amount` INT NOT NULL,
  `actual_amount` INT NOT NULL DEFAULT 0,
  `year` VARCHAR(4) NOT NULL,
  `status_id` INT NOT NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`id`, `status_id`),
  INDEX `status_idx` (`status_id` ASC) VISIBLE,
  CONSTRAINT `status_id`
    FOREIGN KEY (`status_id`)
    REFERENCES `library_v2`.`book_status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `library_v2`.`author_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_v2`.`author_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` ENUM('author', 'co-author') NOT NULL DEFAULT 'author',
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library_v2`.`book_author`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_v2`.`book_author` (
  `book_id` INT NOT NULL,
  `author_id` INT NOT NULL,
  `author_role_id` INT NOT NULL,
  INDEX `fk_book_authors_author1_idx` (`author_id` ASC) VISIBLE,
  INDEX `fk_book_authors_role1_idx` (`author_role_id` ASC) VISIBLE,
  PRIMARY KEY (`book_id`, `author_id`, `author_role_id`),
  CONSTRAINT `fk_book_authors_author1`
    FOREIGN KEY (`author_id`)
    REFERENCES `library_v2`.`author` (`id`),
  CONSTRAINT `fk_book_authors_book1`
    FOREIGN KEY (`book_id`)
    REFERENCES `library_v2`.`book` (`id`),
  CONSTRAINT `author_role_id`
    FOREIGN KEY (`author_role_id`)
    REFERENCES `library_v2`.`author_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `library_v2`.`user_role`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_v2`.`user_role` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `role` ENUM('manager', 'reader') NOT NULL DEFAULT 'reader',
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library_v2`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_v2`.`user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(10) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `registration_date` DATE NOT NULL,
  `age` INT NULL DEFAULT NULL,
  `user_role_id` INT NOT NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`id`, `user_role_id`),
  INDEX `user_role_id_idx` (`user_role_id` ASC) VISIBLE,
  CONSTRAINT `user_role_id`
    FOREIGN KEY (`user_role_id`)
    REFERENCES `library_v2`.`user_role` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `library_v2`.`order_status`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_v2`.`order_status` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `status` ENUM('pending', 'processed', 'closed') NOT NULL DEFAULT 'pending',
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `library_v2`.`order`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_v2`.`order` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `user_id` INT NOT NULL,
  `book_id` INT NOT NULL,
  `order_date` DATE NOT NULL,
  `processed_date` DATE NULL,
  `due_date` DATE NULL DEFAULT NULL,
  `return_date` DATE NULL DEFAULT NULL,
  `order_status_id` INT NOT NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`id`, `order_status_id`),
  INDEX `user_id_idx` (`user_id` ASC) VISIBLE,
  INDEX `order_status_id_idx` (`order_status_id` ASC) VISIBLE,
  CONSTRAINT `user_id`
    FOREIGN KEY (`user_id`)
    REFERENCES `library_v2`.`user` (`id`),
  CONSTRAINT `order_status_id`
    FOREIGN KEY (`order_status_id`)
    REFERENCES `library_v2`.`order_status` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 1
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `library_v2`.`book_copy`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `library_v2`.`book_copy` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `book_id` INT NOT NULL,
  `orders_id` INT NOT NULL,
  `description` VARCHAR(255) NULL,
  PRIMARY KEY (`id`, `book_id`),
  INDEX `fk_book_copies_book1_idx` (`book_id` ASC) VISIBLE,
  INDEX `fk_book_copies_orders1_idx` (`orders_id` ASC) VISIBLE,
  CONSTRAINT `fk_book_copies_book1`
    FOREIGN KEY (`book_id`)
    REFERENCES `library_v2`.`book` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_book_copies_orders1`
    FOREIGN KEY (`orders_id`)
    REFERENCES `library_v2`.`order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
