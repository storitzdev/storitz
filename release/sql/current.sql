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

/* update the releases table last */
insert into releases (revision, release_date,description)
            values (1001,curdate(),'');

/************************/
/* ADD YOUR EDITS ABOVE */
/************************/

COMMIT;
