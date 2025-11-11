CREATE TABLE IF NOT EXISTS reservation (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nom_client VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    nombre_personnes INT NOT NULL,
    date_reservation DATE NOT NULL,
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
