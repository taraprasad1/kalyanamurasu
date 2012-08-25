-- MySQL dump 10.13  Distrib 5.1.48, for Win32 (ia32)
--
-- Host: localhost    Database: matrimony
-- ------------------------------------------------------
-- Server version	5.1.48-community

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
-- Table structure for table `matrimony_key`
--

DROP TABLE IF EXISTS `matrimony_key`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matrimony_key` (
  `keyId` bigint(20) NOT NULL AUTO_INCREMENT,
  `name` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`keyId`),
  KEY `IX_48F621A9` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matrimony_key`
--

LOCK TABLES `matrimony_key` WRITE;
/*!40000 ALTER TABLE `matrimony_key` DISABLE KEYS */;
INSERT INTO `matrimony_key` VALUES (14,'annualIncome'),(10,'children'),(6,'complexion'),(19,'createdForMy'),(13,'currency'),(3,'dosam'),(11,'education'),(18,'familyStatus'),(17,'familyType'),(16,'familyValue'),(7,'height'),(15,'hobbies'),(8,'language'),(9,'maritalStatus'),(12,'profession'),(1,'rasi'),(2,'star'),(4,'weight');
/*!40000 ALTER TABLE `matrimony_key` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-08-25 17:38:53
