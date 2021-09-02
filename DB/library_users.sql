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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `first_name` varchar(45) NOT NULL,
  `last_name` varchar(45) NOT NULL,
  `registration_date` date NOT NULL,
  `age` int DEFAULT NULL,
  `user_role_id` int NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`,`user_role_id`),
  KEY `user_role_id_idx` (`user_role_id`),
  CONSTRAINT `user_role_id` FOREIGN KEY (`user_role_id`) REFERENCES `users_roles` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'vira','vira@ukr.net','qweasdzxc','Vira','Vira','2021-09-01',20,1,NULL),(2,'Vira123','viravas@ukr.net','qweasdzxc','Alex','Vasunuk','2021-08-01',23,1,NULL),(3,'Taras','Taras@ukr.net','qweasdzxc','Taras','Petrunyk','2021-08-22',43,1,NULL),(4,'Ira','Ira@ukr.net','qweasdzxc','Ira','Bych','2021-03-11',54,1,NULL),(5,'Nazar','Nazar@ukr.net','qweasdzxc','Nazar','Varenyk','2021-03-23',23,1,NULL),(6,'Ivan77','Ivan23@ukr.net','qweasdzxc','Ivan','Ivachenko','2021-09-02',43,1,NULL),(7,'Petro','Petro@ukr.net','qweasdzxc','Petro','Grishin','2021-09-02',45,1,NULL),(8,'max','max@ukr.net','qweasdzxc','Maksym','Kyzbyt','2021-09-01',31,2,NULL),(9,'ivan','ivan@ukr.net','qweasdzxc','Ivan','Petrenko','2021-09-01',41,1,NULL),(10,'Pavlo','pavlo@ukr.net','qweasdzxc','Pavlo','Ivanov','2021-09-01',23,1,NULL),(11,'sergo','sergo@ukr.net','qweasdzxc','Sergie','Dobry','2021-09-01',25,1,NULL),(12,'Nadia','Nadia@ukr.net','qweasdzxc','Nadia','Voronyna','2021-08-31',33,1,NULL);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-09-02 23:07:59
