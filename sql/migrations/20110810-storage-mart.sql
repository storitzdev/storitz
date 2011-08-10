/* Support for Storage Mart */

START TRANSACTION;

insert into service_map (service_handler,service_name) values ('storitz.StorageMartStorageFeedService','STM');
insert into releases (revision, release_date,description) values (1001,curdate(),'Storage Mart');
alter table feed add stm_user varchar(255) null;
alter table feed add stm_pass varchar(255) null;

COMMIT;

