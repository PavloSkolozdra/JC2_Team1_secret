-- MySQL dump 10.13  Distrib 8.0.22, for Linux (x86_64)
--
-- Host: localhost    Database: library
-- ------------------------------------------------------
-- Server version	8.0.26-0ubuntu0.20.04.2

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
-- Table structure for table `books_copies`
--

DROP TABLE IF EXISTS `books_copies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `books_copies` (
  `id` int NOT NULL AUTO_INCREMENT,
  `book_id` int NOT NULL,
  `status` int NOT NULL DEFAULT '2',
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`book_id`,`status`),
  KEY `fk_book_copies_book1_idx` (`book_id`),
  KEY `fk_book_copies_status_idx` (`status`),
  CONSTRAINT `fk_book_copies_book1` FOREIGN KEY (`book_id`) REFERENCES `books` (`id`),
  CONSTRAINT `fk_books_copies_status` FOREIGN KEY (`status`) REFERENCES `books_copies_statuses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `books_copies`
--

LOCK TABLES `books_copies` WRITE;
/*!40000 ALTER TABLE `books_copies` DISABLE KEYS */;
INSERT INTO `books_copies` VALUES (1,1,2,NULL),(2,1,2,NULL),(3,1,2,NULL),(4,1,2,NULL),(5,1,2,NULL),(6,1,2,NULL),(7,1,2,NULL),(8,1,2,NULL),(9,1,2,NULL),(10,1,2,NULL),(11,1,2,NULL),(12,2,2,NULL),(13,2,2,NULL),(14,2,2,NULL),(15,2,2,NULL),(16,2,2,NULL),(17,3,2,NULL),(18,3,2,NULL),(19,3,2,NULL),(20,3,2,NULL),(21,3,2,NULL),(22,3,2,NULL),(23,3,2,NULL),(24,4,2,NULL),(25,4,2,NULL),(26,4,2,NULL),(27,5,2,NULL),(28,5,2,NULL),(29,6,2,NULL),(30,7,2,NULL),(31,7,2,NULL),(32,7,2,NULL),(33,8,2,NULL),(34,8,2,NULL),(35,9,2,NULL),(36,10,2,NULL),(37,10,2,NULL),(38,10,2,NULL),(39,10,2,NULL),(40,10,2,NULL),(41,10,2,NULL),(42,10,2,NULL);
/*!40000 ALTER TABLE `books_copies` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-03  1:39:01
