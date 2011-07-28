/************************
 This file contains database schema changes required for deployment

 USAGE:

 1) Create whatever scripts are required for your changes and save into this
    file (release/sql/current.sql)

 2) Update the `releases` table with information specific to your change.

 3) After your release, copy the contents of this file into a new file
    (release/sql/historic/release-N.sql) for reference
 ************************/

START TRANSACTION;

/************************/
/* ADD YOUR EDITS BELOW */
/************************/

/* Create release table */
CREATE TABLE `releases` (
  `id` int(11) NOT NULL auto_increment,
  `revision` int(11) NOT NULL unique,
  `release_date` datetime NOT NULL,
  `description` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

/* Release 1000: Changes to feed in support of new Uncle Bob's feed type */
/* alter table feed add column  `ubcompany_name` varchar(255) default NULL; */
/* alter table storage_site add is_twenty_four_hour bit(1) null; */
alter table rental_transaction add xid varchar(255) null;

/* insert into service_map (service_handler,service_name) values ('storitz.UncleBobsStorageFeedService','BOB'); */

/* update the releases table last */
insert into releases (revision, release_date,description)
            values (1000,curdate(),'V2 UI Merge');

/************************/
/* ADD YOUR EDITS ABOVE */
/************************/

COMMIT;
