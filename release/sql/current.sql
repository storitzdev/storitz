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

/* JM: This merge will cause conflicts. Make sure you get everything from both versions. */
alter table storage_site add is_twenty_four_hour bit(1) null;
alter table rental_transaction add xid varchar(255) null;


/************************/
/* ADD YOUR EDITS ABOVE */
/************************/

COMMIT;
