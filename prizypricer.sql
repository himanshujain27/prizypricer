/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.5.17 : Database - prizypricer
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`prizypricer` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `prizypricer`;

/*Table structure for table `ideal_price_formula` */

DROP TABLE IF EXISTS `ideal_price_formula`;

CREATE TABLE `ideal_price_formula` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `addition` int(11) NOT NULL,
  `rhighest` int(11) NOT NULL,
  `rlowest` int(11) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;

/*Data for the table `ideal_price_formula` */

insert  into `ideal_price_formula`(`ID`,`created`,`updated`,`addition`,`rhighest`,`rlowest`) values (1,'2015-04-10 17:12:19','2015-04-10 21:23:04',20,2,2);

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `avg_price` double NOT NULL,
  `barcode` varchar(55) NOT NULL,
  `description` varchar(55) NOT NULL,
  `productname` varchar(55) NOT NULL,
  `cat_id` bigint(20) DEFAULT NULL,
  `highPrice` double NOT NULL,
  `lowPrice` double NOT NULL,
  `idealPrice` double NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `barcode` (`barcode`),
  KEY `FKED8DCCEF74F09CD7` (`cat_id`),
  CONSTRAINT `FKED8DCCEF74F09CD7` FOREIGN KEY (`cat_id`) REFERENCES `product_cat` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

/*Data for the table `product` */

insert  into `product`(`ID`,`created`,`updated`,`avg_price`,`barcode`,`description`,`productname`,`cat_id`,`highPrice`,`lowPrice`,`idealPrice`) values (1,'2015-04-10 15:55:56','2015-04-10 15:55:56',0,'1234234','sadfasdf','fair lovely',1,0,0,0),(2,'2015-04-10 21:12:42','2015-04-10 21:12:42',0,'34251345','deanim jeans','jeans',2,0,0,0);

/*Table structure for table `product_cat` */

DROP TABLE IF EXISTS `product_cat`;

CREATE TABLE `product_cat` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `category` varchar(55) NOT NULL,
  PRIMARY KEY (`ID`),
  UNIQUE KEY `category` (`category`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

/*Data for the table `product_cat` */

insert  into `product_cat`(`ID`,`created`,`updated`,`category`) values (1,'2015-04-10 14:41:17','2015-04-10 14:41:17','fashion '),(2,'2015-04-10 14:41:17','2015-04-10 14:41:17','Clothes'),(3,'2015-04-10 14:41:17','2015-04-10 14:41:17','grocery'),(4,'2015-04-10 14:41:17','2015-04-10 14:41:17','food'),(5,'2015-04-10 14:41:17','2015-04-10 14:41:17','Gernral Store');

/*Table structure for table `product_log` */

DROP TABLE IF EXISTS `product_log`;

CREATE TABLE `product_log` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `created` datetime NOT NULL,
  `updated` datetime NOT NULL,
  `price` double NOT NULL,
  `product_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `FKA71C8FF4E9A4D100` (`product_id`),
  CONSTRAINT `FKA71C8FF4E9A4D100` FOREIGN KEY (`product_id`) REFERENCES `product` (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

/*Data for the table `product_log` */

insert  into `product_log`(`ID`,`created`,`updated`,`price`,`product_id`) values (1,'2015-04-10 16:32:07','2015-04-10 16:32:07',12,1),(2,'2015-04-10 16:33:12','2015-04-10 16:33:12',15,1),(3,'2015-04-10 16:34:24','2015-04-10 16:34:24',13,1),(4,'2015-04-10 18:20:10','2015-04-10 18:20:10',17,1),(5,'2015-04-10 18:20:13','2015-04-10 18:20:13',14,1),(6,'2015-04-10 18:20:20','2015-04-10 18:20:20',18,1),(7,'2015-04-10 21:11:50','2015-04-10 21:11:50',12.34,1),(8,'2015-04-10 21:18:57','2015-04-10 21:18:57',1200,2),(9,'2015-04-10 21:19:33','2015-04-10 21:19:33',1300,2),(10,'2015-04-10 21:19:57','2015-04-10 21:19:57',1400,2),(11,'2015-04-10 21:20:01','2015-04-10 21:20:01',1250,2),(12,'2015-04-10 21:20:06','2015-04-10 21:20:06',1100,2),(13,'2015-04-10 21:20:09','2015-04-10 21:20:09',1000,2);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
