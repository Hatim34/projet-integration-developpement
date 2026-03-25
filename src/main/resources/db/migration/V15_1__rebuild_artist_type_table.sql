DROP TABLE IF EXISTS `artist_type`;

CREATE TABLE `artist_type` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `artist_id` BIGINT NOT NULL,
  `type_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

ALTER TABLE `artist_type`
  ADD KEY `artist_type_artist_id_idx` (`artist_id`),
  ADD KEY `artist_type_type_id_idx` (`type_id`);

ALTER TABLE `artist_type`
  ADD CONSTRAINT `artist_type_artist_id_fk_artists_id`
    FOREIGN KEY (`artist_id`) REFERENCES `artists` (`id`)
    ON UPDATE CASCADE ON DELETE RESTRICT,
  ADD CONSTRAINT `artist_type_type_id_fk_types_id`
    FOREIGN KEY (`type_id`) REFERENCES `types` (`id`)
    ON UPDATE CASCADE ON DELETE RESTRICT;
