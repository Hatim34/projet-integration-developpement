CREATE TABLE `localities` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `postal_code` VARCHAR(10) COLLATE utf8mb4_unicode_ci NOT NULL,
  `locality` VARCHAR(60) COLLATE utf8mb4_unicode_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
