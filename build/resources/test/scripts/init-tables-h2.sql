create schema IF NOT EXISTS liligo;

create table IF NOT EXISTS `liligo`.`city`
(
    `id`                bigint auto_increment primary key,
    `name`              varchar(100) not null,
    `all_airports_code` varchar(3) null,
    `capital`           enum ('PRIMARY', 'ADMIN', 'MINOR') null,
    constraint city_all_airports_code_unique
        unique (`all_airports_code`)
);

create table IF NOT EXISTS `liligo`.`airport`
(
    `id`      bigint auto_increment primary key,
    `code`    varchar(10) not null,
    `city_id` bigint      not null,
    `name`    varchar(150) null,
    constraint fk_airport_city
        foreign key (`city_id`) references city (`id`)
);

create table IF NOT EXISTS `liligo`.`user`
(
    `id`           bigint auto_increment primary key,
    `full_name`    varchar(256) not null,
    `email`        varchar(320) not null,
    `phone_number` varchar(17)  not null
);

create table IF NOT EXISTS `liligo`.`shuttle`
(
    `id`                            bigint auto_increment primary key,
    `vehicle_identification_number` varchar(17) not null,
    `number_of_seats`               int         not null,
    `active`                        boolean     not null default false
);

create table IF NOT EXISTS `liligo`.`shuttle_ride`
(
    `id`                 bigint auto_increment primary key,
    `shuttle_id`         bigint   not null,
    `airport_id`         bigint   not null,
    `departure_datetime` datetime not null,
    constraint fk_shuttle_ride_shuttle
        foreign key (`shuttle_id`) references shuttle (`id`),
    constraint fk_shuttle_ride_airport
        foreign key (`airport_id`) references airport (`id`)
);

create table IF NOT EXISTS `liligo`.`shuttle_ride_booking`
(
    `id`                   bigint auto_increment primary key,
    `shuttle_ride_id`      bigint  not null,
    `user_id`              bigint  not null,
    `number_of_passengers` int     not null default 1,
    `cancelled`            boolean not null default false,
    constraint fk_shuttle_ride_booking_shuttle_ride
        foreign key (`shuttle_ride_id`) references liligo.shuttle_ride (`id`),
    constraint fk_shuttle_ride_booking_user
        foreign key (`user_id`) references `user` (`id`)
);