insert into `film`(`name`, `duration`)
values ('Film1', '01:00:00');
insert into `film`(`name`, `duration`)
values ('Film2', '01:30:00');
insert into `film`(`name`, `duration`)
values ('Film3', '02:00:00');
insert into `film`(`name`, `duration`)
values ('Film4', '01:30:00');
insert into `film`(`name`, `duration`)
values ('Film5', '02:00:00');

insert into `price_category`(`name`, `price`)
values ('09->15', 150);
insert into `price_category`(`name`, `price`)
values ('15->18', 250);
insert into `price_category`(`name`, `price`)
values ('18->21', 350);
insert into `price_category`(`name`, `price`)
values ('21->00', 200);

insert into `schedule`(`film_id`, `start_time`, `price_category_id`)
values (1, '2021-01-01 09:00:00', 1);
insert into `schedule`(`film_id`, `start_time`, `price_category_id`)
values (2, '2021-01-01 09:30:00', 1);
insert into `schedule`(`film_id`, `start_time`, `price_category_id`)
values (3, '2021-01-01 10:45:00', 1);
insert into `schedule`(`film_id`, `start_time`, `price_category_id`)
values (4, '2021-01-01 12:40:00', 1);
insert into `schedule`(`film_id`, `start_time`, `price_category_id`)
values (5, '2021-01-01 14:50:00', 1);
insert into `schedule`(`film_id`, `start_time`, `price_category_id`)
values (1, '2021-01-01 17:50:00', 2);
insert into `schedule`(`film_id`, `start_time`, `price_category_id`)
values (2, '2021-01-01 19:30:00', 3);
insert into `schedule`(`film_id`, `start_time`, `price_category_id`)
values (3, '2021-01-01 21:30:00', 4);
insert into `schedule`(`film_id`, `start_time`, `price_category_id`)
values (4, '2021-01-01 23:40:00', 4);

insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (1, 1, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (1, 1, 2);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (1, 2, 3);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (1, 3, 4);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (1, 3, 5);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (1, 3, 6);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (1, 3, 7);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (2, 1, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (2, 2, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (2, 2, 2);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (2, 2, 3);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (3, 1, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (3, 2, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (3, 3, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (3, 3, 2);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (3, 3, 3);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (3, 4, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (4, 1, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (4, 1, 2);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (4, 1, 3);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (4, 1, 4);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (5, 1, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (5, 2, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (5, 2, 2);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (5, 3, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (5, 3, 2);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (5, 4, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (5, 4, 2);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (5, 4, 3);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (5, 4, 4);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (5, 4, 5);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (5, 4, 6);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (5, 5, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (5, 5, 2);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (6, 1, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (6, 1, 2);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (6, 1, 3);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (6, 1, 4);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (6, 1, 5);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (6, 2, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (6, 2, 2);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (7, 1, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (7, 1, 2);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (7, 1, 3);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (8, 2, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (8, 3, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (8, 4, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (8, 5, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (8, 6, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (8, 7, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (8, 7, 2);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (8, 7, 3);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (8, 7, 4);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (8, 8, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (8, 8, 2);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (8, 8, 3);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (8, 8, 4);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (8, 8, 5);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (8, 8, 6);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (9, 1, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (9, 2, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (9, 3, 1);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (9, 3, 2);
insert into `ticket`(`schedule_id`, `row_number`, `seat_number`)
values (9, 4, 1);