-- MySQL dump 10.13  Distrib 5.1.48, for Win32 (ia32)
--
-- Host: localhost    Database: kalyanamurasu
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
-- Table structure for table `matrimony_caste`
--

DROP TABLE IF EXISTS `matrimony_caste`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `matrimony_caste` (
  `casteId` bigint(20) NOT NULL,
  `religionId` bigint(20) DEFAULT NULL,
  `name` varchar(75) DEFAULT NULL,
  PRIMARY KEY (`casteId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `matrimony_caste`
--

LOCK TABLES `matrimony_caste` WRITE;
/*!40000 ALTER TABLE `matrimony_caste` DISABLE KEYS */;
INSERT INTO `matrimony_caste` VALUES (2,1,'Vanniar'),(1,1,'vannia Kula Kshatriya'),(3,1,'Adaviyar'),(4,1,'Ambalakarar'),(5,1,'Aruntathiar'),(6,1,'Bania-Gujarathi'),(7,1,'Bhavasar'),(8,1,'Biharian'),(9,1,'Boyar'),(10,1,'Brahmin'),(11,1,'Chettiar'),(12,1,'Desigar'),(13,1,'Ezuthachan'),(14,1,'Gounder'),(15,1,'Gowda'),(16,1,'Inter-Caste'),(17,1,'Jangam'),(18,1,'Kallar'),(19,1,'Kannadiya Naicker'),(20,1,'Keralites'),(21,2,'Dhakni'),(22,2,'Inter-Caste'),(23,2,'Lebbai'),(24,2,'Maraicar'),(25,2,'Pathan'),(26,2,'Rowther'),(27,2,'Sheik'),(28,2,'Sunni'),(29,2,'Syed'),(30,2,'Urudu'),(31,3,'Adi Dravidar'),(32,3,'Atheist'),(33,3,'Bendagoste'),(34,3,'Born again'),(35,3,'Chettiar'),(36,3,'CSI'),(37,3,'Devendrakula Vellalar'),(38,3,'Evangelist'),(39,3,'Inter - Caste'),(40,3,'Kulalar'),(41,3,'Marthomice'),(42,3,'Maruthuvar'),(43,3,'Mudailiar'),(44,3,'Nadar'),(45,3,'Naicker'),(46,3,'Naidu'),(47,3,'Protestant'),(48,3,'Reddiar'),(49,3,'Roman Catholic'),(50,3,'Thevar'),(51,3,'Udiyar'),(52,3,'Vanniar'),(53,3,'Vellalar'),(54,3,'Viswakarma-Achari'),(55,3,'yadavar'),(56,1,'kokani'),(57,1,'kshatriya/raja'),(58,1,'kulalar'),(59,1,'kuravan'),(60,1,'lohana'),(61,1,'Madiwaldru'),(62,1,'Maharastrian'),(63,1,'Malayalee'),(64,1,'Maratha-Non Brahmin'),(65,1,'Marauthuvar'),(66,1,'Moopanar'),(67,1,'Mudaliyar'),(68,1,'Muthuraja'),(69,1,'Muthuraja Ambalakarar'),(70,1,'Nadar'),(71,1,'Naicker'),(72,1,'Naidu'),(73,1,'Nair'),(74,1,'Namakkar Naidu(SC)'),(75,1,'Namdev'),(76,1,'Nepali'),(77,1,'Nesavallar'),(78,1,'Oriya-Brahimn'),(79,1,'Ottar(MBC)'),(80,1,'Pallar(Devendra Kula Vellalar)'),(81,1,'Pandaram'),(82,1,'Panniyar'),(83,1,'Pillai'),(84,1,'Rajakula Agamudayar'),(85,1,'Pattariyar'),(86,1,'Rajput'),(87,1,'Rao'),(88,1,'Reddiar'),(89,1,'Sathatha Srivaishnava'),(90,1,'SC'),(91,1,'SC (Keralites)'),(92,1,'Schedule Tribes'),(93,1,'Senai Thalaivar'),(94,1,'Sindhi'),(95,1,'Sindhi-Brahimn'),(96,1,'Singh'),(97,1,'Sowrashtra'),(98,1,'Thevar'),(99,1,'Udayar'),(100,1,'Uppara'),(101,1,'Uppillia Naicker'),(102,1,'Vallambar'),(103,1,'Valluvan'),(104,1,'Valluvar'),(105,1,'Vannan'),(106,1,'Vannar'),(107,1,'Veera Saiva Lingayath'),(108,1,'Vishwakarma-Achari'),(109,1,'Yadava'),(110,1,'Other');
/*!40000 ALTER TABLE `matrimony_caste` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2012-08-25 11:29:26
