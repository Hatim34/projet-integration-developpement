DROP TABLE IF EXISTS `locations`;
CREATE TABLE `locations` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `slug` VARCHAR(60) NOT NULL UNIQUE,
  `designation` VARCHAR(60) NOT NULL,
  `address` VARCHAR(255) NOT NULL,
  `locality_id` BIGINT NOT NULL,
  `website` VARCHAR(255) DEFAULT NULL,
  `phone` VARCHAR(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
ALTER TABLE `locations`
  ADD KEY `locations_locality_id_fk_localities_id` (`locality_id`);
ALTER TABLE `locations`
  ADD CONSTRAINT `locations_locality_id_fk_localities_id` FOREIGN KEY (`locality_id`) REFERENCES `localities` (`id`);
