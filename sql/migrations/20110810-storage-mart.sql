/* Support for Storage Mart */

START TRANSACTION;

insert into service_map (service_handler,service_name) values ('storitz.StorageMartStorageFeedService','STM');
insert into releases (revision, release_date,description) values (1001,curdate(),'Storage Mart');
alter table feed add stm_user varchar(255) null;
alter table feed add stm_pass varchar(255) null;

-- MySQL dump 10.11
--
-- Host: localhost    Database: storitz_prod
-- ------------------------------------------------------
-- Server version	5.0.51a-3ubuntu5.8

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `special_offer_lookup`
--

DROP TABLE IF EXISTS `special_offer_lookup`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `special_offer_lookup` (
  `id` bigint(20) NOT NULL auto_increment,
  `version` bigint(20) NOT NULL,
  `amount` double default NULL,
  `expire_month` int(11) default NULL,
  `name` varchar(255) NOT NULL,
  `prepay_months` int(11) default NULL,
  `start_month` int(11) default NULL,
  `type` varchar(255) default NULL,
  `class` varchar(255) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `special_offer_lookup`
--

LOCK TABLES `special_offer_lookup` WRITE;
/*!40000 ALTER TABLE `special_offer_lookup` DISABLE KEYS */;
INSERT INTO `special_offer_lookup` VALUES (1,0,0,1,'Limited Availability.  Reserve Today!',1,1,'AMOUNT_OFF','com.storitz.StorageMartSpecialOfferLookup'),(2,0,99,1,'99% Off First Month\'s Rent',1,1,'PERCENT_OFF','com.storitz.StorageMartSpecialOfferLookup'),(3,0,20,1,'20% Off First Month\'s Rent',1,1,'PERCENT_OFF','com.storitz.StorageMartSpecialOfferLookup'),(4,0,50,1,'50% Off First Month\'s Rent',1,1,'PERCENT_OFF','com.storitz.StorageMartSpecialOfferLookup'),(5,0,99,1,'99% Off First 2 Month\'s Rent',2,1,'PERCENT_OFF','com.storitz.StorageMartSpecialOfferLookup');
/*!40000 ALTER TABLE `special_offer_lookup` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-08-20  0:09:52


COMMIT;

