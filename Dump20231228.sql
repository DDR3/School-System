-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: schooldb
-- ------------------------------------------------------
-- Server version	8.0.35

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin_info`
--

DROP TABLE IF EXISTS `admin_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin_info` (
  `admin_id` varchar(50) NOT NULL,
  `passwords` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`admin_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_info`
--

LOCK TABLES `admin_info` WRITE;
/*!40000 ALTER TABLE `admin_info` DISABLE KEYS */;
INSERT INTO `admin_info` VALUES ('admin','root');
/*!40000 ALTER TABLE `admin_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grades`
--

DROP TABLE IF EXISTS `grades`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `grades` (
  `grade_id` int NOT NULL AUTO_INCREMENT,
  `student_id` int DEFAULT NULL,
  `teacher_id` int DEFAULT NULL,
  `subject_id` varchar(5) DEFAULT NULL,
  `grade` float DEFAULT NULL,
  PRIMARY KEY (`grade_id`),
  KEY `student_id` (`student_id`),
  KEY `teacher_id` (`teacher_id`),
  KEY `subject_id` (`subject_id`),
  CONSTRAINT `grades_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `student_info` (`student_id`),
  CONSTRAINT `grades_ibfk_2` FOREIGN KEY (`teacher_id`) REFERENCES `teacher_info` (`teacher_id`),
  CONSTRAINT `grades_ibfk_3` FOREIGN KEY (`subject_id`) REFERENCES `subjects` (`subject_id`)
) ENGINE=InnoDB AUTO_INCREMENT=162 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grades`
--

LOCK TABLES `grades` WRITE;
/*!40000 ALTER TABLE `grades` DISABLE KEYS */;
INSERT INTO `grades` VALUES (1,1,112,'1A',95),(2,1,113,'1ASHG',88),(3,1,114,'1G',92),(4,1,115,'1H',85),(5,1,116,'1S',90),(6,1,117,'2A',88),(7,1,118,'2G',91),(8,2,113,'1ASHG',90),(9,2,119,'2H',85),(10,2,120,'2S',89),(11,2,121,'3A',92),(12,2,122,'3G',87),(13,2,123,'3H',94),(14,2,124,'3S',88),(15,3,125,'4A',91),(16,3,126,'4G',86),(17,3,127,'4H',93),(18,3,128,'4S',89),(19,3,129,'5A',87),(20,3,130,'5G',92),(21,3,111,'5H',84),(22,4,112,'6A',93),(23,4,113,'6G',88),(24,4,114,'6H',94),(25,4,115,'6S',89),(26,4,116,'7A',87),(27,4,117,'7G',91),(28,4,118,'7H',85),(29,5,119,'7S',90),(30,5,120,'8A',88),(31,5,121,'8H',92),(32,5,122,'8S',87),(33,5,123,'9H',94),(34,6,124,'1A',89),(35,6,125,'1ASHG',91),(36,6,126,'1G',86),(37,6,127,'1H',92),(38,6,128,'1S',87),(39,6,129,'2A',93),(40,6,130,'2G',88),(41,7,111,'2H',91),(42,7,112,'2S',85),(43,7,113,'3A',90),(44,7,114,'3G',94),(45,7,115,'3H',89),(46,7,116,'3S',92),(47,7,117,'4A',87),(48,7,118,'4G',91),(49,8,119,'4H',86),(50,8,120,'4S',93),(51,8,121,'5A',89),(52,8,122,'5G',84),(53,8,123,'5H',94),(54,8,124,'5S',88),(55,8,125,'6A',87),(56,9,126,'6G',92),(57,9,127,'6H',88),(58,9,128,'6S',91),(59,9,129,'7A',85),(60,9,130,'7G',90),(61,10,111,'7H',89),(62,10,112,'7S',93),(63,10,113,'8A',88),(64,10,114,'8H',94),(65,10,115,'8S',86),(66,10,116,'9H',92),(67,11,117,'1A',87),(68,11,118,'1ASHG',91),(69,11,119,'1G',86),(70,11,120,'1H',92),(71,11,121,'1S',87),(72,11,122,'2A',93),(73,11,123,'2G',88),(74,11,124,'2H',91),(75,11,125,'2S',85),(76,11,126,'3A',90),(77,12,127,'3G',94),(78,12,128,'3H',89),(79,12,129,'3S',92),(80,12,130,'4A',87),(81,12,111,'4G',91),(82,12,112,'4H',86),(83,12,113,'4S',93),(84,13,114,'5A',89),(85,13,115,'5G',84),(86,13,116,'5H',94),(87,13,117,'5S',88),(88,13,118,'6A',87),(89,13,119,'6G',92),(90,13,120,'6H',88),(91,13,121,'6S',91),(92,13,122,'7A',85),(93,13,123,'7G',90),(94,14,124,'7H',89),(95,14,125,'7S',93),(96,14,126,'8A',88),(97,14,127,'8H',94),(98,14,128,'8S',86),(99,14,129,'9H',92),(100,15,130,'1A',87),(101,15,111,'1ASHG',91),(102,15,112,'1G',86),(103,15,113,'1H',92),(104,15,114,'1S',87),(105,15,115,'2A',93),(106,15,116,'2G',88),(107,15,117,'2H',91),(108,15,118,'2S',85),(109,16,119,'3A',90),(110,16,120,'3G',94),(111,16,121,'3H',89),(112,16,122,'3S',92),(113,16,123,'4A',87),(114,16,124,'4G',91),(115,16,125,'4H',86),(116,16,126,'4S',93),(117,17,127,'5A',89),(118,17,128,'5G',84),(119,17,129,'5H',94),(120,17,130,'5S',88),(121,17,111,'6A',87),(122,17,112,'6G',92),(123,17,113,'6H',88),(124,17,114,'6S',91),(125,18,115,'7A',85),(126,18,116,'7G',90),(127,18,117,'7H',89),(128,18,118,'7S',93),(129,18,119,'8A',88),(130,18,120,'8H',94),(131,18,121,'8S',86),(132,18,122,'9H',92),(133,19,123,'1A',87),(134,19,124,'1ASHG',91),(135,19,125,'1G',86),(136,19,126,'1H',92),(137,19,127,'1S',87),(138,19,128,'2A',93),(139,19,129,'2G',88),(140,19,130,'2H',91),(141,20,111,'2S',85),(142,20,112,'3A',90),(143,20,113,'3G',94),(144,20,114,'3H',89),(145,20,115,'3S',92),(146,20,116,'4A',87),(147,20,117,'4G',91),(148,20,118,'4H',86),(149,20,119,'4S',93),(150,20,120,'5A',89),(151,20,121,'5G',84),(152,20,122,'5H',94),(153,20,123,'5S',88),(154,20,124,'6A',87),(155,20,125,'6G',92),(156,20,126,'6H',88),(157,20,127,'6S',91),(158,20,128,'7A',85),(159,20,129,'7G',90),(160,20,130,'7H',89),(161,20,111,'7S',93);
/*!40000 ALTER TABLE `grades` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_info`
--

DROP TABLE IF EXISTS `student_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `student_info` (
  `student_id` int NOT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `section` varchar(20) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`student_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_info`
--

LOCK TABLES `student_info` WRITE;
/*!40000 ALTER TABLE `student_info` DISABLE KEYS */;
INSERT INTO `student_info` VALUES (1,'Juan','Dela Cruz','STEM-106','password'),(2,'Maria','Santos','HUMSS-101','password'),(3,'Luis','Garcia','ABM-102','password'),(4,'Elena','Reyes','GAS-102','password'),(5,'Carlos','Lopez','STEM-103','password'),(6,'Sofia','Torres','STEM-104','password'),(7,'Mateo','Mendoza','HUMSS-104','password'),(8,'Isabel','Rivera','ABM-102','password'),(9,'Andres','Castillo','GAS-102','password'),(10,'Gabriela','Vargas','STEM-103','password'),(11,'Jose','Ramos','STEM-105','password'),(12,'Ana','Fernandez','HUMSS-103','password'),(13,'Miguel','Martinez','ABM-105','password'),(14,'Carmen','Perez','GAS-101','password'),(15,'Juanito','Cruz','STEM-105','password'),(16,'Rosa','Luna','STEM-104','password'),(17,'Pedro','Gomez','HUMSS-102','password'),(18,'Luz','Hernandez','ABM-104','password'),(19,'Francisco','Diaz','GAS-106','password'),(20,'Beatriz','Torres','STEM-106','password');
/*!40000 ALTER TABLE `student_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `subjects`
--

DROP TABLE IF EXISTS `subjects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `subjects` (
  `subject_id` varchar(100) NOT NULL,
  `subject_name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`subject_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `subjects`
--

LOCK TABLES `subjects` WRITE;
/*!40000 ALTER TABLE `subjects` DISABLE KEYS */;
INSERT INTO `subjects` VALUES ('10S','Earth Science'),('11S','Disaster Readiness and Risk Reduction'),('1A','Applied Economics'),('1ASHG','WRCC'),('1G','Humanities 1'),('1H','Creative Writing/ Malikhaing Pagsulat'),('1S','Pre-Calculus'),('2A','Business Ethics and Social Responsibility'),('2G','Humanities 2'),('2H','Creative Nonfiction'),('2S','Basic Calculus'),('3A','Fundamentals of Accountancy, Business, and Management 1'),('3G','Social Science 1'),('3H','Introduction to World Religions and Belief Systems'),('3S','General Biology 1'),('4A','Fundamentals of Accountancy, Business, and Management 2'),('4G','Applied Economics Organization and Management'),('4H','Community Engagement, Solidarity, and Citizenship'),('4S','General Biology 2'),('5A','Business Math'),('5G','Disaster Readiness and Risk Reduction'),('5H','Philippine Politics and Governance'),('5S','General Physics 1'),('6A','Business Finance'),('6G','Elective 1'),('6H','Trends, Networks, and Critical Thinking in the 21st Century'),('6S','General Physics 2'),('7A','Organization and Management'),('7G','Elective 2'),('7H','Disciplines and Ideas in the Social Sciences'),('7S','General Chemistry 1'),('8A','Principles of Marketing'),('8H','Disciplines and Ideas in the Applied Social Sciences'),('8S','General Chemistry 2'),('9H','HUMSS Culminating Activity/Work Immersion');
/*!40000 ALTER TABLE `subjects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teacher_info`
--

DROP TABLE IF EXISTS `teacher_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teacher_info` (
  `teacher_id` int NOT NULL,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `passwords` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`teacher_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teacher_info`
--

LOCK TABLES `teacher_info` WRITE;
/*!40000 ALTER TABLE `teacher_info` DISABLE KEYS */;
INSERT INTO `teacher_info` VALUES (111,'Manuel','Gomez','password'),(112,'Maria','Santos','password'),(113,'Rodrigo','Lopez','password'),(114,'Elena','Reyes','password'),(115,'Antonio','Rivera','password'),(116,'Carmen','Torres','password'),(117,'Juan','Cruz','password'),(118,'Sofia','Diaz','password'),(119,'Luis','Mendoza','password'),(120,'Isabel','Hernandez','password'),(121,'Ricardo','Luna','password'),(122,'Estela','Garcia','password'),(123,'Felipe','Fernandez','password'),(124,'Cecilia','Velasco','password'),(125,'Gabriel','Perez','password'),(126,'Beatriz','Sison','password'),(127,'Eduardo','Martinez','password'),(128,'Margarita','Cordova','password'),(129,'Hector','Castillo','password'),(130,'Adriana','Ramos','password');
/*!40000 ALTER TABLE `teacher_info` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-12-28 21:11:15
