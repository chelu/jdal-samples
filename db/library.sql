-- MySQL dump 10.11
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	5.0.67-1-log

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
-- Table structure for table `authors`
--

DROP TABLE IF EXISTS `authors`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `authors` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(100) character set latin1 default NULL,
  `surname` varchar(100) character set latin1 default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `authors`
--

LOCK TABLES `authors` WRITE;
/*!40000 ALTER TABLE `authors` DISABLE KEYS */;
INSERT INTO `authors` VALUES (1,'Rod','Johnson'),(2,'Martin','Fowler'),(3,'Eric','Evans'),(4,'Erich','Gamma'),(5,'Frank','Buschmann'),(6,'Douglas ','Schmidt'),(7,'Michael','Kircher'),(8,'Kent','Beck'),(9,'Craig','Walls'),(10,'Gary','Mak'),(11,'Chris','Richardson');
/*!40000 ALTER TABLE `authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books`
--

DROP TABLE IF EXISTS `books`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `books` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(250) character set latin1 default NULL,
  `ISBN` varchar(32) character set latin1 default NULL,
  `authorid` int(11) default NULL,
  `categoryid` int(11) default NULL,
  `publishedDate` date default NULL,
  PRIMARY KEY  (`id`),
  KEY `category_fk` (`categoryid`),
  KEY `author_fk` (`authorid`),
  CONSTRAINT `author_fk` FOREIGN KEY (`authorid`) REFERENCES `authors` (`id`),
  CONSTRAINT `category_fk` FOREIGN KEY (`categoryid`) REFERENCES `categories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `books`
--

LOCK TABLES `books` WRITE;
/*!40000 ALTER TABLE `books` DISABLE KEYS */;
INSERT INTO `books` VALUES (7,'Domain-driven design: tackling complexity in the heart of software  ','978-0-3211-2521-7',3,1,'2003-08-30'),(8,'Expert One-on-One J2EE Development without EJB','978-0-7645-5831-3',1,1,'2004-01-01'),(9,'Domain-Specific Languages ','978-0-3217.1294-3',2,4,'2010-10-03'),(10,'Refactoring: Improving the Design of Existing Code','978-0-2014-8567-7',2,4,'1999-07-08'),(11,'UML Distilled: A Brief Guide to the Standard Object Modeling Language','978-0-3211-9368-1',2,4,'2003-09-25'),(12,'Analysis Patterns: Reusable Object Models','978-0-2018-9542-1',2,3,'1996-10-19'),(13,'Design Patterns: Elements of Reusable Object-Oriented Software','978-0-2016-3361-0',4,3,'1994-11-10'),(14,'Contributing to Eclipse: Principles, Patterns, and Plug-Ins (The eclipse Series)','978-0-3212-4641-7',4,1,'2004-01-01'),(15,'Pattern-Oriented Software Architecture Volume 1: A System of Patterns','978-0-4719-5869-7',5,1,'1996-08-08'),(16,'Pattern-Oriented Software Architecture Volume 2: Patterns for Concurrent and Networked Objects','978-0-4716-0695-6',6,1,'2000-09-14'),(17,'Pattern-Oriented Software Architecture Volume 4: A Pattern Language for Distributed Computing ','978-0-4700-5902-9',5,3,'2007-05-15'),(18,'Pattern Oriented Software Architecture Volume 5: On Patterns and Pattern ','978-0-4714-8648-0',5,3,'2007-06-11'),(19,'Pattern-Oriented Software Architecture Volume 3: Patterns for Resource Management ','978-0-4708-4525-7',7,3,'2004-06-28'),(20,'Implementation Patterns','978-0-3214-1309-3',8,3,'2007-11-02'),(21,'Test Driven Development: By Example ','978-0-3211-4653-3',8,3,'2002-11-18'),(22,'Extreme Programming Explained: Embrace Change ','978-0-3212-7865-4',8,4,'2004-11-26'),(23,'JUnit Pocket Guide','978-0-5960-0743-0',8,1,'2004-09-23'),(25,'Spring in Action','978-1-9351-8235-1',9,1,'2010-04-28'),(26,'Spring Recipes: A Problem-Solution Approach ','978-1-5905-9979-2',10,1,'2008-06-23'),(27,'Professional Java Development with the Spring Framework','978-0-7645-7483-2',1,1,'2005-07-08'),(28,'POJOs in Action: Developing Enterprise Applications with Lightweight Frameworks','978-1-9323-9458-0',11,1,'2006-01-30'),(29,'COBOL and Visual Basic on .NET: A Guide for the Reformed Mainframe Programmer ','978-1-5905-9048-5',11,5,'2003-04-10');
/*!40000 ALTER TABLE `books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `books_authors`
--

DROP TABLE IF EXISTS `books_authors`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `books_authors` (
  `id` int(11) NOT NULL default '0',
  `books_id` int(11) default NULL,
  `authors_id` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `books_authors`
--

LOCK TABLES `books_authors` WRITE;
/*!40000 ALTER TABLE `books_authors` DISABLE KEYS */;
INSERT INTO `books_authors` VALUES (0,8,1);
/*!40000 ALTER TABLE `books_authors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `categories`
--

DROP TABLE IF EXISTS `categories`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `categories` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(100) character set latin1 default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `categories`
--

LOCK TABLES `categories` WRITE;
/*!40000 ALTER TABLE `categories` DISABLE KEYS */;
INSERT INTO `categories` VALUES (1,'Java'),(2,'C++'),(3,'Patterns'),(4,'Sofware Design, Architecture'),(5,'C#');
/*!40000 ALTER TABLE `categories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `readers`
--

DROP TABLE IF EXISTS `readers`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `readers` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(100) default NULL,
  `surname` varchar(100) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `readers`
--

LOCK TABLES `readers` WRITE;
/*!40000 ALTER TABLE `readers` DISABLE KEYS */;
INSERT INTO `readers` VALUES (2,'Groucho ','Marx'),(3,'Chico','Marx'),(4,'Harpo','Marx'),(5,'Gummo','Marx'),(6,'Zeppo','Marx');
/*!40000 ALTER TABLE `readers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `readers_books`
--

DROP TABLE IF EXISTS `readers_books`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `readers_books` (
  `id` int(11) NOT NULL auto_increment,
  `books_id` int(11) NOT NULL,
  `readers_id` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `readers_fk` (`readers_id`),
  KEY `books_fk` (`books_id`),
  CONSTRAINT `readers_books_ibfk_2` FOREIGN KEY (`books_id`) REFERENCES `books` (`id`),
  CONSTRAINT `readers_books_ibfk_1` FOREIGN KEY (`readers_id`) REFERENCES `readers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=217 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `readers_books`
--

LOCK TABLES `readers_books` WRITE;
/*!40000 ALTER TABLE `readers_books` DISABLE KEYS */;
INSERT INTO `readers_books` VALUES (14,20,3),(15,21,3),(16,22,3),(17,23,3),(18,10,4),(19,11,4),(20,12,4),(21,13,4),(22,14,4),(23,15,4),(24,16,4),(31,25,6),(32,26,6),(33,27,6),(192,11,5),(193,12,5),(194,13,5),(195,8,2),(196,9,2),(197,10,2),(198,11,2),(199,12,2),(200,13,2),(201,14,2),(202,15,2),(203,16,2),(204,17,2),(205,18,2),(206,19,2),(207,20,2),(208,21,2),(209,22,2),(210,23,2),(211,25,2),(212,26,2),(213,27,2),(214,28,2),(215,29,2),(216,7,2);
/*!40000 ALTER TABLE `readers_books` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `surname` varchar(255) default NULL,
  `username` varchar(255) default NULL,
  `registerDate` datetime default NULL,
  `password` varchar(32) default NULL,
  `name` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'Default','user','2012-12-02 18:17:42','','User','');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_preference`
--

DROP TABLE IF EXISTS `user_preference`;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
CREATE TABLE `user_preference` (
  `id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `name` varchar(255) NOT NULL,
  `value` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `user_preference_user_fk` (`user_id`),
  CONSTRAINT `user_preference_user_fk` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
SET character_set_client = @saved_cs_client;

--
-- Dumping data for table `user_preference`
--

LOCK TABLES `user_preference` WRITE;
/*!40000 ALTER TABLE `user_preference` DISABLE KEYS */;
INSERT INTO `user_preference` VALUES (1,1,'bookPageableTable.visible_columns','name,author,category,isbn'),(2,1,'bookPageableTable.page_size','2147483647');
/*!40000 ALTER TABLE `user_preference` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-12-02 18:28:02
