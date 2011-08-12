/* Correction to Simply SS inventory */
update unit_type_lookup set temp_controlled = false where description like 'Drive Up Access';


insert into releases (revision, release_date, description) values (1002, curdate(), 'Simply Self Storage Unit Corrections');