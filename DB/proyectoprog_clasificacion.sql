-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: proyectoprog
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `clasificacion`
--

DROP TABLE IF EXISTS `clasificacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clasificacion` (
  `POSICION` int NOT NULL,
  `NOMBRE` varchar(45) DEFAULT NULL,
  `PUNTOS` int DEFAULT NULL,
  `PARTIDOS` int DEFAULT NULL,
  `VICTORIAS` int DEFAULT NULL,
  `EMPATES` int DEFAULT NULL,
  `DERROTAS` int DEFAULT NULL,
  `GF` int DEFAULT NULL,
  `GC` int DEFAULT NULL,
  `DG` int DEFAULT NULL,
  PRIMARY KEY (`POSICION`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clasificacion`
--

LOCK TABLES `clasificacion` WRITE;
/*!40000 ALTER TABLE `clasificacion` DISABLE KEYS */;
INSERT INTO `clasificacion` VALUES (1,'Atlético de Madrid',86,38,26,8,4,67,25,42),(2,'Real Madrid',84,38,25,9,4,67,28,39),(3,'Barcelona',79,38,24,7,7,85,38,47),(4,'Sevilla',77,38,24,5,9,53,33,20),(5,'Real Sociedad',62,38,17,11,10,59,38,21),(6,'Betis',61,38,17,10,11,50,50,0),(7,'Villarreal',58,38,15,13,10,60,44,16),(8,'Celta de Vigo',53,38,14,11,13,55,57,-2),(9,'Granada',46,38,13,7,18,47,65,-18),(10,'Ath. Bilbao',46,38,11,13,14,46,42,4),(11,'Osasuna',44,38,11,11,16,37,48,-11),(12,'Cádiz',44,38,11,11,16,36,58,-22),(13,'Valencia',43,38,10,13,15,50,53,-3),(14,'Levante',41,38,9,14,15,46,57,-11),(15,'Getafe',38,38,9,11,18,28,43,-15),(16,'Alavés',38,38,9,11,18,36,57,-21),(17,'Elche',36,38,8,12,18,34,55,-21),(18,'Huesca',34,38,7,13,18,34,53,-19),(19,'Valladolid',31,38,5,16,17,34,57,-23),(20,'Eibar',30,38,6,12,20,29,52,-23);
/*!40000 ALTER TABLE `clasificacion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-01-27 11:04:45
