drop table service_map;

insert into releases (revision, release_date,description)
            values (1004,curdate(),'Dropped service_map');
