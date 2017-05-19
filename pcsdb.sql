/*
SQLyog Enterprise - MySQL GUI v7.02 
MySQL - 5.5.15 : Database - pcsdb
*********************************************************************
*/


/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`pcsdb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `pcsdb`;

/*Table structure for table `designation_master` */

DROP TABLE IF EXISTS `designation_master`;

CREATE TABLE `designation_master` (
  `Designation` varchar(24) DEFAULT NULL,
  `Des_No` varchar(24) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/*Data for the table `designation_master` */

insert  into `designation_master`(`Designation`,`Des_No`) values ('Database Administrator','1'),('Project Manager','1'),('Team Leader','2'),('Senior Software Engineer','3'),('Software Engineer','4');

/*Table structure for table `document_master` */

DROP TABLE IF EXISTS `document_master`;

CREATE TABLE `document_master` (
  `Document_ID` varchar(20) DEFAULT NULL,
  `Sent_From` varchar(20) DEFAULT NULL,
  `Sent_To` varchar(20) DEFAULT NULL,
  `Document_Status` varchar(20) DEFAULT NULL,
  `Project_ID` varchar(20) DEFAULT NULL,
  `Description` varchar(20) DEFAULT NULL,
  `Date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE INDEX doc_index
ON document_master (Document_ID);

/*Data for the table `document_master` */

insert  into `document_master`(`Document_ID`,`Sent_From`,`Sent_To`,`Document_Status`,`Project_ID`,`Description`,`Date`) values ('DOC_1','PCSHiren23','PCSKrupa22','In Process','Project1','hi..','2012-06-08'),('DOC_1A','PCSKrupa22','PCSKartik08','In Process','Project1','hi..','2012-06-09'),('DOC_1B','PCSKrupa22','PCSRaju14','In Process','Project1','hi..','2012-06-09'),('DOC_1A','PCSKartik08','PCSKrupa22','Done','Project1','hi..','2012-06-09'),('DOC_1B','PCSRaju14','PCSKrupa22','Done','Project1','hi..','2012-06-09'),('DOC_1A','PCSKrupa22','PCSKartik08','Approved','Project1','NULL','2012-06-09'),('DOC_1B','PCSKrupa22','PCSRaju14','Approved','Project1','NULL','2012-06-09'),('DOC_1','PCSKrupa22','PCSHiren23','Done','Project1','hi..','2012-06-09'),('DOC_1','PCSHiren23','PCSKrupa22','Approved','Project1','NULL','2012-06-09'),('DOC_admin','PCSHiren23','Admin','In Process','Project1','hi..','2012-06-09');

/*Table structure for table `emp_project` */

DROP TABLE IF EXISTS `emp_project`;

CREATE TABLE `emp_project` (
  `Project_ID` varchar(20) DEFAULT NULL,
  `Emp_ID` varchar(20) DEFAULT NULL,
  `Designation` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `emp_project` */

insert  into `emp_project`(`Project_ID`,`Emp_ID`,`Designation`) values ('Project1','PCSHiren23','Project Manager'),('Project1','PCSKrupa22','Team Leader'),('Project1','PCSKartik08','Software Engineer'),('Project1','PCSRaju14','Software Engineer');

/*Table structure for table `employee_master` */

DROP TABLE IF EXISTS `employee_master`;

CREATE TABLE `employee_master` (
  `Emp_ID` varchar(24) NOT NULL,
  `Emp_Name` varchar(24) DEFAULT NULL,
  `Password` varchar(24) DEFAULT NULL,
  `Designation` varchar(24) DEFAULT NULL,
  `Address` varchar(24) DEFAULT NULL,
  `Salary` varchar(24) DEFAULT NULL,
  `Status` varchar(24) DEFAULT NULL,
  `Experience` varchar(24) DEFAULT NULL,
  `Current_Project` varchar(24) DEFAULT NULL,
  PRIMARY KEY (`Emp_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `employee_master` */

insert  into `employee_master`(`Emp_ID`,`Emp_Name`,`Password`,`Designation`,`Address`,`Salary`,`Status`,`Experience`,`Current_Project`) values ('Admin','Gautam Y. Joshi','gautam','Database Administrator','Ahmedabad','50000','Selected','14',NULL),('PCSHiren23','Hiren B. Pandya','hiren','Project Manager','Ahmedabad','50000','Selected','14','Project1'),('PCSKartik08','Kartik G. Shah','kartik','Software Engineer','Ahmedabad','30000','Selected','3','Project1'),('PCSKrupa22','Krupa J. Joshi','krupa','Team Leader','Ahmedabad','40000','Selected','8','Project1'),('PCSRaju14','Raju P. Patel','raju','Software Engineer','Ahmedabad','30000','Selected','4','Project1');

/*Table structure for table `project_master` */

DROP TABLE IF EXISTS `project_master`;

CREATE TABLE `project_master` (
  `Project_ID` varchar(24) NOT NULL,
  `Project_Name` varchar(24) DEFAULT NULL,
  `Emp_ID` varchar(24) DEFAULT NULL,
  `Project_Status` varchar(24) DEFAULT NULL,
  `Started_Date` date DEFAULT NULL,
  `Completed_Date` date DEFAULT NULL,
  PRIMARY KEY (`Project_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `project_master` */

insert  into `project_master`(`Project_ID`,`Project_Name`,`Emp_ID`,`Project_Status`,`Started_Date`,`Completed_Date`) values ('Project1','Nero2012','PCSHiren23','In Process','2012-06-08','2012-06-08');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
