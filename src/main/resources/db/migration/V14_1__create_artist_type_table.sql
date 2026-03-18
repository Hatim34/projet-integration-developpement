CREATE TABLE `artist_type` (
  `artist_id` BIGINT NOT NULL,
  `type_id` BIGINT NOT NULL,
  PRIMARY KEY (`artist_id`, `type_id`),
  CONSTRAINT `fk_artist_type_artist`
    FOREIGN KEY (`artist_id`) REFERENCES `artists` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_artist_type_type`
    FOREIGN KEY (`type_id`) REFERENCES `types` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
