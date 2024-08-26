SET REFERENTIAL_INTEGRITY FALSE;

TRUNCATE TABLE `liligo`.`shuttle`;
TRUNCATE TABLE `liligo`.`shuttle_ride_booking`;
TRUNCATE TABLE `liligo`.`shuttle_ride`;
TRUNCATE TABLE `liligo`.`city`;
TRUNCATE TABLE `liligo`.`user`;
TRUNCATE TABLE `liligo`.`airport`;

SET REFERENTIAL_INTEGRITY TRUE;