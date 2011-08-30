#!/bin/bash
# feed-copy.sh
# 
# Given a feed id, extract the feed and all of its corresponding data (sites, units, discounts, etc) into text
# files suitable to loading into a new database.
# 

function sqlfmtcols {
    oldIFS=$IFS
    export IFS='	'
    ret=""
    for f in $@
    do
	ret+=$f
	ret+=","
    done
    echo $ret | sed 's/,$//g'
    export IFS=$oldIFS
}

function sqlfmtvals {
    oldIFS=$IFS
    export IFS='	'
    ret=""
    for f in $@
    do
	ret+="'"
	ret+=$f
	ret+="',"
    done
    echo $ret | sed 's/,$//g'
    export IFS=$oldIFS
}

feedid="$1"
dbuser="$2"
dbname="$3"
dbserv="$4"
dbserv=
dbpass=
mysql="/usr/bin/mysql"

if test "$dbname" = ""; then
    echo "usage: feed-copy.sh id dbuser dbname [dbserver]" 1>&2
    exit 1
fi

if test "$dbserver" = ""; then
    dbserv="localhost"
fi

echo -n "database password: " 1>&2
read dbpass

# SQL queries

# FEED
sqlfeed="select feed_type,operator_name,class,corp_code,password,user_name,cshift_version,location,org_id,pin,url,address1,address2,city,state,zipcode,commission_schedule_id,transaction_box_body,transaction_box_link,date_created,last_updated,edomico_clientid,edomico_web_services_key,reservation_move_in_description,ubcompany_name,stm_user,stm_pass from feed where id=$feedid"

# MANAGER
sqlmanager="select account_expired,account_locked,description,email,if(enabled,true,false) as enabled,password,password_expired,user_real_name,username from user where id=(select manager_id from feed where id=$feedid)"

# STORAGE_SITE
sqlsites="select address,address2,admin_fee,if(boxes_available,true,false) as boxes_available,city,description,end_saturday,end_sunday,end_weekday,free_truck,if(is_camera,true,false) as is_camera,if(is_gate,true,false) as is_camera,if(is_keypad,true,false) as is_keypad,if(is_unit_alarmed,true,false) as is_unit_alarmed,last_update,lat,lng,lock_fee,logo_id,if(open_saturday,true,false) as open_saturday,if(open_sunday,true,false) as open_sunday,if(open_weekday,true,false) as open_weekday,phone,if(requires_insurance,true,false) as requires_insurance,source,source_id,source_loc,start_saturday,start_sunday,start_weekday,state,title,url,zipcode,bank_account_id,rental_agreement_id,if(is_manager_onsite,true,false) as is_manager_onsite,end_gate,if(extended_hours,true,false) as extended_hours,if(has_elevator,true,false) as has_elevator,start_gate,end_sunday_gate,start_sunday_gate,tax_rate_insurance,tax_rate_rental,deposit,if(no_insurance_waiver,true,false) as no_insurance_waiver,if(use_prorating,true,false) as use_prorating,if(disabled,true,false) as disabled,last_change,prorate_cutoff,if(prorate_second_month,true,false) as prorate_second_month,prorate_start,end_friday,end_friday_gate,end_monday,end_monday_gate,end_saturday_gate,end_thursday,end_thursday_gate,end_tuesday,end_tuesday_gate,end_wednesday,end_wednesday_gate,net_commission,if(open_friday,true,false) as open_friday,if(open_monday,true,false) as open_monday,if(open_thursday,true,false) as open_thursday,if(open_tuesday,true,false) as open_tuesday,if(open_wednesday,true,false) as open_wednesday,start_friday,start_friday_gate,start_monday,start_monday_gate,start_saturday_gate,start_thursday,start_thursday_gate,start_tuesday,start_tuesday_gate,start_wednesday,start_wednesday_gate,tax_rate_merchandise,if(allow_push_price,true,false) as allow_push_price,transaction_type,min_inventory,rental_fee,max_reserve_days,date_created,seo_city,if(is_twenty_four_hour,true,false) as is_twenty_four_hour from storage_site where feed_id=$feedid"

# STORAGE_UNIT
sqlunits="select su.description,su.display_size,if(su.is_alarm,true,false) as is_alarm,if(su.is_available,true,false) as is_available,if(su.is_powered,true,false) as is_powered,if(su.is_secure,true,false) as is_secure,if(su.is_temp_controlled,true,false) as is_temp_controlled,su.price,su.start_avail,su.unit_number,su.unitsize_id,su.unit_type,su.push_rate,su.unit_name,su.unit_count,su.tax_rate,su.is_irregular,su.unit_info,su.total_units,su.unit_size_info,su.unit_type_info,su.deposit,su.date_created,su.last_updated,su.best_unit_price,su.max_reserve_days,su.site_id,su.cs4version from storage_unit su join storage_site ss on ss.id = su.site_id where ss.feed_id=$feedid"

# SPECIAL_OFFER
sqloffers="select if(so.active,true,false) as active,so.code,so.concession_id,so.description,so.expire_month,if(so.featured,true,false) as featured,so.in_month,if(so.prepay,true,false) as prepay,so.prepay_months,so.promo_name,so.promo_qty,so.promo_type,if(so.waive_admin,true,false) as waive_admin,so.end_date,so.promo_size_id,so.unit_type,so.start_date,so.site_id from special_offer so join storage_site ss on ss.id = so.site_id where ss.feed_id=$feedid"

# SPECIAL_OFFER RESTRICTION
sqlrestrict="select description sr.end_date,sr.occupancy_percentage,sr.occupancy_units,sr.restriction_info,sr.size_type,sr.start_date,sr.type,sr.max_range,sr.min_range,sr.restrictive,sr.special_offer_id from special_offer_restriction sr where sr.special_offer_id=$?"

# IMAGES

# SITE USERS
sqlsiteuser="select site_id,user_id from site_user where site_id=$"
sqlusers="select account_expired,account_locked,description,email,enabled,manager_id,password,password_expired,user_real_name,username from user where id=$"

# INSURANCES
sqlsiteinsurance="select storage_site_insurances_id,insurance_id from storage_site_insurance where id=$"
sqlinsurance="select insurance_id,percent_theft,premium,provider,total_coverage,active from insurance where id=$"

# BULLETS (SECURITY, CONVENIENCE, AMENITY)
sqlsitebullet="select bullet_id,storage_site_amenity_items_id,storage_site_convenience_items_id,storage_site_security_items_id where bullet_id=$"
sqlbulletamenity="select bullet from bullet where id=$"
sqlbulletconvenience="select bullet from bullet where id=$"
sqlbulletsecurity="select bullet from bullet where id=$"


# BUILD THE SQL TO LOAD INTO THE NEW DB

# FEED SQL
first=1
columns=
values=
$mysql -u$dbuser -p$dbpass $dbname -e "$sqlfeed;" | while read line
do
    if test $first -eq 1; then
	columns=`sqlfmtcols "$line"`
    fi
    if test $first -eq 0; then
	values=`sqlfmtvals "$line"`
	echo "insert into feed ($columns) values ($values);"
    fi
    first=0
done

# MANAGER SQL
first=1
columns=
values=
$mysql -u$dbuser -p$dbpass $dbname -e "$sqlmanager;" | while read line
do
    if test $first -eq 1; then
	columns=`sqlfmtcols "$line"`
    fi
    if test $first -eq 0; then
	values=`sqlfmtvals "$line"`
	echo "insert into user ($columns) values ($values);"
    fi
    first=0
done

# FEED <-> MANAGER SQL
#echo "update feed set manager_id=(select max(id) from user) where id=(select max(id) from feed);"

# STORAGE SITE SQL
first=1
columns=
values=
$mysql -u$dbuser -p$dbpass $dbname -e "$sqlsites;" | while read line
do
    if test $first -eq 1; then
	columns=`sqlfmtcols "$line"`
    fi
    if test $first -eq 0; then
	values=`sqlfmtvals "$line"`
	echo "insert into storage_site (feed_id,$columns) values ((select max(id) from feed),$values);"
    fi
    first=0
done
