CREATE TABLE `film`
(
    `id`       int(11)     NOT NULL AUTO_INCREMENT,
    `name`     varchar(45) NOT NULL,
    `duration` time        NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id_UNIQUE` (`id`)
);

CREATE TABLE `price_category`
(
    `id`    int(11)       NOT NULL AUTO_INCREMENT,
    `name`  varchar(100)  NOT NULL,
    `price` decimal(5, 2) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id_UNIQUE` (`id`)
);

CREATE TABLE `schedule`
(
    `id`                int(10)   NOT NULL AUTO_INCREMENT,
    `film_id`           int(11)   NOT NULL,
    `start_time`        timestamp NOT NULL,
    `price_category_id` int(11)   NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id_UNIQUE` (`id`),
    KEY `fk_film_id_idx` (`film_id`),
    KEY `fk_price_category_id_idx` (`price_category_id`),
    CONSTRAINT `fk_film_id` FOREIGN KEY (`film_id`) REFERENCES `film` (`id`),
    CONSTRAINT `fk_price_category_id` FOREIGN KEY (`price_category_id`) REFERENCES `price_category` (`id`)
);

CREATE TABLE `ticket`
(
    `id`          int(11) NOT NULL AUTO_INCREMENT,
    `schedule_id` int(11) NOT NULL,
    `row_number`  int(11) NOT NULL,
    `seat_number` int(11) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id_UNIQUE` (`id`),
    KEY `fk_schedule_id_idx` (`schedule_id`),
    CONSTRAINT `fk_schedule_id` FOREIGN KEY (`schedule_id`) REFERENCES `schedule` (`id`)
);
