CREATE TABLE `shows` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `description` TEXT NOT NULL,
  `price` INT NOT NULL,
  `date` DATE NOT NULL,
  `location` VARCHAR(100) NOT NULL,
  PRIMARY KEY (`id`)
);
