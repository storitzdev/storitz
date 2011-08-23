alter table storage_unit add column site_id bigint(20) not null;
update storage_unit su, storage_site_storage_unit sssu set su.site_id = sssu.storage_site_units_id where sssu.storage_unit_id = su.id;
create index storage_unit_site_id_idx on storage_unit(site_id);
alter table special_offer add column site_id bigint(20) not null;
update special_offer so, storage_site_special_offer ssso set so.site_id = ssso.storage_site_special_offers_id where ssso.special_offer_id = so.id;
create index special_offer_site_id_idx on special_offer(site_id);
alter table special_offer_restriction add column special_offer_id bigint(20) not null;
update special_offer_restriction sor, special_offer_special_offer_restriction sosor set sor.special_offer_id = sosor.special_offer_restrictions_id where sosor.special_offer_restriction_id = sor.id;
create index special_offer_restriction_special_offer_id_idx on special_offer_restriction(special_offer_id);

/* Document our progress */
insert into releases (revision, release_date,description)
            values (1003,curdate(),'Dropped M-to-M join tables');
