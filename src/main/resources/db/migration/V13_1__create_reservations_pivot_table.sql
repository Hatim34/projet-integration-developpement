CREATE TABLE `reservations` (
  `user_id` BIGINT NOT NULL,
  `representation_id` BIGINT NOT NULL,
  PRIMARY KEY (`user_id`, `representation_id`),
  CONSTRAINT `fk_reservations_user`
    FOREIGN KEY (`user_id`) REFERENCES `users` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_reservations_representation`
    FOREIGN KEY (`representation_id`) REFERENCES `representations` (`id`)
    ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
