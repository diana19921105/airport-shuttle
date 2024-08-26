create table `liligo`.`city`
(
    `id`                bigint auto_increment primary key,
    `name`              varchar(100)                       not null,
    `all_airports_code` varchar(3)                         null,
    `capital`           enum ('PRIMARY', 'ADMIN', 'MINOR') null,
    constraint city_all_airports_code_unique
        unique (`all_airports_code`)
) collate = utf8mb4_0900_ai_ci;

create table `liligo`.`airport`
(
    `id`      bigint auto_increment primary key,
    `code`    varchar(10)  not null,
    `city_id` bigint       not null,
    `name`    varchar(150) null,
    index `airport_city` (`city_id`),
    constraint fk_airport_city
        foreign key (`city_id`) references `liligo`.`city` (`id`)
) collate = utf8mb4_0900_ai_ci;

create table `liligo`.`user`
(
    `id`           bigint auto_increment primary key,
    `full_name`    varchar(256) not null,
    `email`        varchar(320) not null,
    `phone_number` varchar(17)  not null
) collate = utf8mb4_0900_ai_ci;

create table `liligo`.`shuttle`
(
    `id`                            bigint auto_increment primary key,
    `vehicle_identification_number` varchar(17) not null,
    `number_of_seats`               int         not null,
    `active`                        boolean     not null default false
) collate = utf8mb4_0900_ai_ci;

create table `liligo`.`shuttle_ride`
(
    `id`                 bigint auto_increment primary key,
    `shuttle_id`         bigint   not null,
    `airport_id`         bigint   not null,
    `departure_datetime` datetime not null,
    index `shuttle_ride_shuttle` (`shuttle_id`),
    index `shuttle_ride_airport` (`airport_id`),
    constraint fk_shuttle_ride_shuttle
        foreign key (`shuttle_id`) references `liligo`.`shuttle` (`id`),
    constraint fk_shuttle_ride_airport
        foreign key (`airport_id`) references `liligo`.`airport` (`id`)
) collate = utf8mb4_0900_ai_ci;

create table `liligo`.`shuttle_ride_booking`
(
    `id`                   bigint auto_increment primary key,
    `shuttle_ride_id`      bigint      not null,
    `user_id`              bigint      not null,
    `number_of_passengers` int         not null default 1,
    `cancelled`            boolean     not null default false,
    index `shuttle_ride_booking_shuttle_ride` (`shuttle_ride_id`),
    index `shuttle_ride_booking_user` (`user_id`),
    constraint fk_shuttle_ride_booking_shuttle_ride
        foreign key (`shuttle_ride_id`) references `liligo`.`shuttle_ride` (`id`),
    constraint fk_shuttle_ride_booking_user
        foreign key (`user_id`) references `liligo`.`user` (`id`)
) collate = utf8mb4_0900_ai_ci;