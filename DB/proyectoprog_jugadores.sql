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
-- Table structure for table `jugadores`
--

DROP TABLE IF EXISTS `jugadores`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `jugadores` (
  `IDJUGADOR` int NOT NULL,
  `JUGADOR` varchar(45) NOT NULL,
  `EQUIPO` varchar(45) NOT NULL,
  `POSICION` varchar(45) NOT NULL,
  `ALTURA` float NOT NULL,
  `PESO` float NOT NULL,
  `NACIMIENTO` date NOT NULL,
  `DORSAL` int DEFAULT NULL,
  PRIMARY KEY (`IDJUGADOR`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `jugadores`
--

LOCK TABLES `jugadores` WRITE;
/*!40000 ALTER TABLE `jugadores` DISABLE KEYS */;
INSERT INTO `jugadores` VALUES (1,'UNAI SIMON','Athletic Club','Portero',1.9,88,'1997-06-11',1),(2,'JOKIN EZKIETA','Athletic Club','Portero',1.93,82,'1996-08-17',13),(3,'IAGO HERRERIN','Athletic Club','Portero',1.87,88,'1988-01-25',25),(4,'UNAI NUÑEZ','Athletic Club','Defensa',1.86,80,'1997-01-30',3),(5,'IÑIGO MARTINEZ','Athletic Club','Defensa',1.82,76,'1991-05-17',4),(6,'YERAY','Athletic Club','Defensa',1.82,78,'1995-01-24',5),(7,'IÑIGO LEKUE','Athletic Club','Defensa',1.8,70,'1993-05-04',15),(8,'YURI BERCHICHE','Athletic Club','Defensa',1.81,79,'0199-02-10',17),(9,'OSCAR DE MARCOS','Athletic Club','Defensa',1.82,77,'1989-04-14',18),(10,'CAPA','Athletic Club','Defensa',1.75,75,'1992-02-08',21),(11,'NOLASKOAIN','Athletic Club','Defensa',1.86,81,'1998-10-25',23),(12,'BALENZIAGA','Athletic Club','Defensa',1.77,76,'1988-02-29',24),(13,'MIKEL VESGA','Athletic Club','Centrocampista',1.91,83,'1993-04-08',6),(14,'UNAI LOPEZ','Athletic Club','Centrocampista',1.7,68,'1995-10-30',8),(15,'DANI GARCIA','Athletic Club','Centrocampista',1.8,81,'1990-05-24',14),(16,'OIHAN SANCET','Athletic Club','Centrocampista',1.88,73,'2000-04-25',16),(17,'OIER ZARRAGA','Athletic Club','Centrocampista',1.75,76,'1999-01-04',19),(18,'RAUL GARCIA','Athletic Club','Centrocampista',1.84,83,'1986-07-11',22),(19,'JON MORCILLO','Athletic Club','Delantero',1.83,72,'1998-09-15',2),(20,'IBAI GOMEZ','Athletic Club','Delantero',1.77,72,'1989-11-11',7),(21,'IÑAKI WILLIAMS','Athletic Club','Delantero',1.86,78,'1994-06-15',9),(22,'IKER MUNIAIN','Athletic Club','Delantero',1.7,65,'1992-12-19',10),(23,'ALEJANDRO BERENGUER','Athletic Club','Delantero',1.75,73,'1995-07-04',12),(24,'ASIER VILLALIBRE','Athletic Club','Delantero',1.84,86,'1997-09-30',20),(25,'IVO GRBIC','Atlético de Madrid','Portero',1.95,83,'1996-01-18',1),(26,'JAN OBLAK','Atlético de Madrid','Portero',1.88,87,'1993-01-07',13),(27,'JOSE MARIA GIMENEZ','Atlético de Madrid','Defensa',1.85,80,'1995-01-20',2),(28,'RENAN LODI','Atlético de Madrid','Defensa',1.73,68,'1998-04-08',12),(29,'STEFAN SAVIC','Atlético de Madrid','Defensa',1.87,81,'1991-01-08',15),(30,'FELIPE','Atlético de Madrid','Defensa',1.9,83,'1989-05-16',18),(31,'MARIO HERMOSO','Atlético de Madrid','Defensa',1.84,75,'1995-06-18',22),(32,'KIERAN TRIPPIER','Atlético de Madrid','Defensa',1.78,71,'1990-09-19',23),(33,'SIME VRSALJKO','Atlético de Madrid','Defensa',1.81,76,'1992-01-10',24),(34,'GEOFFREY KONDOGBIA','Atlético de Madrid','Centrocampista',1.88,80,'1993-02-15',4),(35,'LUCAS TORREIRA','Atlético de Madrid','Centrocampista',1.68,64,'1996-02-11',5),(36,'KOKE','Atlético de Madrid','Centrocampista',1.76,77,'1992-01-08',6),(37,'SAUL ÑIGUEZ','Atlético de Madrid','Centrocampista',1.84,76,'1994-11-21',8),(38,'THOMAS LEMAR','Atlético de Madrid','Centrocampista',1.71,63,'1995-11-12',11),(39,'MARCOS LLORENTE','Atlético de Madrid','Centrocampista',1.83,74,'1995-01-30',14),(40,'HECTOR HERRERA','Atlético de Madrid','Centrocampista',1.85,80,'1990-04-19',16),(41,'YANNICK CARRASCO','Atlético de Madrid','Centrocampista',1.8,71,'1993-09-04',21),(42,'JOAO FELIX','Atlético de Madrid','Delantero',1.81,70,'1999-11-10',7),(43,'LUIS SUAREZ','Atlético de Madrid','Delantero',1.82,86,'1987-01-24',9),(44,'ANGEL CORREA','Atlético de Madrid','Delantero',1.71,70,'1995-03-09',10),(45,'MOUSSA DEMBELE','Atlético de Madrid','Delantero',1.83,73,'1997-07-12',19),(46,'VITOLO','Atlético de Madrid','Delantero',1.85,80,'1989-11-02',20),(47,'LIONEL MESSI','F.C. Barcelona','Delantero',1.7,72,'1987-06-24',10),(48,'KARIM BENZEMA','Real Madrid','Delantero',1.85,81,'1987-12-19',9),(49,'GERARD MORENO','Villarreal C.F.','Delantero',1.8,77,'1992-04-07',7);
/*!40000 ALTER TABLE `jugadores` ENABLE KEYS */;
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
