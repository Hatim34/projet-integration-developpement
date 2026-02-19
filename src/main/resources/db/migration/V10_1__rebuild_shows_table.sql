DROP TABLE IF EXISTS `shows`;
CREATE TABLE `shows` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `slug` VARCHAR(60) NOT NULL UNIQUE,
  `title` VARCHAR(255) NOT NULL,
  `description` LONGTEXT,
  `poster_url` VARCHAR(255) DEFAULT NULL,
  `bookable` TINYINT(1) NOT NULL,
  `price` DECIMAL(10,2) DEFAULT NULL,
  `created_at` DATETIME(6) NOT NULL,
  `updated_at` DATETIME(6) DEFAULT NULL,
  `location_id` BIGINT DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
ALTER TABLE `shows`
  ADD KEY `shows_location_id_fk_locations_id` (`location_id`);
ALTER TABLE `shows`
  ADD CONSTRAINT `shows_location_id_fk_locations_id` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`);
