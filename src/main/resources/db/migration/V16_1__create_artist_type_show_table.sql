CREATE TABLE `artist_type_show` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `artist_type_id` BIGINT NOT NULL,
  `show_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `artist_type_show`
  ADD KEY `artist_type_show_artist_type_id_idx` (`artist_type_id`),
  ADD KEY `artist_type_show_show_id_idx` (`show_id`);

ALTER TABLE `artist_type_show`
  ADD CONSTRAINT `artist_type_show_artist_type_id_fk_artist_type_id`
    FOREIGN KEY (`artist_type_id`) REFERENCES `artist_type` (`id`)
    ON UPDATE CASCADE ON DELETE RESTRICT,
  ADD CONSTRAINT `artist_type_show_show_id_fk_shows_id`
    FOREIGN KEY (`show_id`) REFERENCES `shows` (`id`)
    ON UPDATE CASCADE ON DELETE RESTRICT;
