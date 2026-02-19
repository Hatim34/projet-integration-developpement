CREATE TABLE `representations` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `show_id` BIGINT NOT NULL,
  `location_id` BIGINT DEFAULT NULL,
  `when` DATETIME(6) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
ALTER TABLE `representations`
  ADD KEY `representations_location_id_fk_locations_id` (`location_id`);
ALTER TABLE `representations`
  ADD KEY `representations_show_id_fk_shows_id` (`show_id`);
ALTER TABLE `representations`
  ADD CONSTRAINT `representations_location_id_fk_locations_id` FOREIGN KEY (`location_id`) REFERENCES `locations` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT;
ALTER TABLE `representations`
  ADD CONSTRAINT `representations_show_id_fk_shows_id` FOREIGN KEY (`show_id`) REFERENCES `shows` (`id`) ON UPDATE CASCADE ON DELETE RESTRICT;
