/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.1.49-community : Database - evaluationsystem
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`evaluationsystem` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `evaluationsystem`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `adm_id` int(11) NOT NULL AUTO_INCREMENT,
  `adm_username` varchar(64) NOT NULL,
  `adm_password` varchar(64) NOT NULL,
  `adm_info` varchar(128) DEFAULT NULL,
  PRIMARY KEY (`adm_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`adm_id`,`adm_username`,`adm_password`,`adm_info`) values (1,'admin','654321','这是一些管理员的信息');

/*Table structure for table `evaluate` */

DROP TABLE IF EXISTS `evaluate`;

CREATE TABLE `evaluate` (
  `eva_id` int(11) NOT NULL AUTO_INCREMENT,
  `eva_name` varchar(64) NOT NULL,
  `eva_score` int(11) NOT NULL,
  `eva_content` varchar(256) NOT NULL,
  `eva_date` varchar(24) NOT NULL,
  PRIMARY KEY (`eva_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `evaluate` */

insert  into `evaluate`(`eva_id`,`eva_name`,`eva_score`,`eva_content`,`eva_date`) values (6,'120706000',2432343,'saf sdfsdgdfgsdfdsgdsdsgdff','2015年03月26日23:41:01');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `stu_id` int(11) NOT NULL AUTO_INCREMENT,
  `stu_username` varchar(32) NOT NULL,
  `stu_password` varchar(64) NOT NULL,
  `stu_name` varchar(64) DEFAULT NULL,
  `stu_sex` varchar(8) DEFAULT NULL,
  `stu_class` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`stu_id`,`stu_username`,`stu_password`,`stu_name`,`stu_sex`,`stu_class`) values (19,'120706000','111111 ','测试1','男','12计本');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
