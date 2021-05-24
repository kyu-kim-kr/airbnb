SET foreign_key_checks = 0;

DROP TABLE IF EXISTS `airbnb`.`location`;
DROP TABLE IF EXISTS `airbnb`.`user`;
DROP TABLE IF EXISTS `airbnb`.`reservation`;
DROP TABLE IF EXISTS `airbnb`.`host`;
DROP TABLE IF EXISTS `airbnb`.`hotel`;
DROP TABLE IF EXISTS `airbnb`.`coordinate`;
-- -----------------------------------------------------
-- Table `airbnb`.`location`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airbnb`.`location`
(
    `name`       VARCHAR(255) NOT NULL,
    `avatar_url` VARCHAR(255) NULL DEFAULT NULL,
    `distance`   INT(11)      NULL DEFAULT NULL,
    PRIMARY KEY (`name`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `airbnb`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airbnb`.`user`
(
    `id`               INT(11)      NOT NULL,
    `login`            VARCHAR(255)  NULL DEFAULT NULL,
    `avatar_url`       VARCHAR(255) NULL DEFAULT NULL,
    `wish_list`        VARCHAR(255) NULL DEFAULT NULL,
    `reservation_list` VARCHAR(255) NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `airbnb`.`reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airbnb`.`reservation`
(
    `id`               INT(11)      NOT NULL AUTO_INCREMENT,
    `total_price`      INT(11)      NULL DEFAULT NULL,
    `check_in`         VARCHAR(255) NULL DEFAULT NULL,
    `check_out`        VARCHAR(255) NULL DEFAULT NULL,
    `number_of_guests` INT(11)      NULL DEFAULT NULL,
    `location_name`    VARCHAR(255) NOT NULL,
    `user_id`          INT(11)      NOT NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_Hotel_Location_idx` (`location_name` ASC),
    INDEX `fk_reservation_user1_idx` (`user_id` ASC),
    CONSTRAINT `fk_Hotel_Location`
        FOREIGN KEY (`location_name`)
            REFERENCES `airbnb`.`location` (`name`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_reservation_user1`
        FOREIGN KEY (`user_id`)
            REFERENCES `airbnb`.`user` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB
    AUTO_INCREMENT = 11
    DEFAULT CHARACTER SET = utf8mb4;


-- -----------------------------------------------------
-- Table `airbnb`.`host`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airbnb`.`host`
(
    `id`         INT         NOT NULL AUTO_INCREMENT,
    `name`       VARCHAR(45) NULL,
    `avatar_url` VARCHAR(45) NULL,
    PRIMARY KEY (`id`)
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airbnb`.`hotel`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airbnb`.`hotel`
(
    `id`                  INT          NOT NULL AUTO_INCREMENT,
    `image_url`           TEXT         NULL,
    `title`               VARCHAR(255) NULL,
    `review_star_point`   DOUBLE       NULL,
    `review_number`       INT          NULL,
    `location_name`       VARCHAR(255) NOT NULL DEFAULT '서울',
    `host_id`             INT          NOT NULL,
    `maximum_occupancy`   INT          NULL,
    `number_of_beds`      INT          NULL DEFAULT 1,
    `number_of_bathrooms` INT          NULL,
    `is_oneroom`          TINYINT      NULL,
    `description`         TEXT         NULL,
    `price`               INT          NULL,
    PRIMARY KEY (`id`),
    INDEX `fk_hotels_locations1_idx` (`location_name` ASC),
    INDEX `fk_hotels_hosts1_idx` (`host_id` ASC),
    CONSTRAINT `fk_hotels_locations1`
        FOREIGN KEY (`location_name`)
            REFERENCES `airbnb`.`location` (`name`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_hotels_hosts1`
        FOREIGN KEY (`host_id`)
            REFERENCES `airbnb`.`host` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `airbnb`.`coordinate`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `airbnb`.`coordinate`
(
    `hotel_id` INT    NOT NULL,
    `x`        DOUBLE NULL,
    `y`        DOUBLE NULL,
    PRIMARY KEY (`hotel_id`),
    INDEX `fk_coordinates_hotels1_idx` (`hotel_id` ASC),
    CONSTRAINT `fk_coordinates_hotels1`
        FOREIGN KEY (`hotel_id`)
            REFERENCES `airbnb`.`hotel` (`id`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
)
    ENGINE = InnoDB;



SET foreign_key_checks = 1;
