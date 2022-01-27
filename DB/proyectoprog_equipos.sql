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
-- Table structure for table `equipos`
--

DROP TABLE IF EXISTS `equipos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `equipos` (
  `NOMBRE` varchar(45) NOT NULL,
  `PRESIDENTE` varchar(45) NOT NULL,
  `ESTADIO` varchar(45) NOT NULL,
  `CREACION` int NOT NULL,
  `ENTRENADOR` varchar(45) NOT NULL,
  `ID_E` int NOT NULL,
  `DESC` varchar(500) NOT NULL,
  PRIMARY KEY (`ID_E`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `equipos`
--

LOCK TABLES `equipos` WRITE;
/*!40000 ALTER TABLE `equipos` DISABLE KEYS */;
INSERT INTO `equipos` VALUES ('Athletic Club','Aitor Elizegi','Estadio San Mamés',1898,'Gaizka Garitano',1,'El Ahletic Club o también conocido como Athletic de Bilbao es un club de fútbol de la villa de Bilbao, junto al Real Madrid y al Barcelona, el único club que ha disputado todas las ediciones de la Primera División de España desde su creación. Es el 5º equipo en la clasificación histórica de la liga'),('Atlético de Madrid','Enrique Cerezo','Wanda Metropolitano',1903,'Diego Pablo Simeone',2,'El Club Atlético de Madrid identificado por sus colores rojos y blancos, es uno de los clubes españoles más laureados, superando la treintena entre títulos nacionales e internacionales, ocupando el puesto 3º en la clasificación histórica de la liga, solo por detrás del F.C. Barcelona y el Real Madrid'),('C.A. Osasuna ','Luis Sabalza','Estadio El Sadar',1920,'Jagoba Arrasate',3,'El Club Atlético Osasuna es un club de fútbol de Pamplona, Navarra. El Osasuna ha participado en una fase previa de la Liga de Campeones y en cuatro ediciones de la Copa de la UEFA, llegando una vez a semifinales, además, posee el 14º lugar en la clasificación histórica de nuestra liga'),('Cádiz C.F.','Manuel Vizcaíno','Ramón de Carranza',1910,'Álvaro Cervera',4,'El Cádiz Club de Fútbol es un equipo de fútbol español con sede en Cádiz. En estos últimos 5 años ha ascendido de 2ªB a 1ª división. En total el Cádiz cuenta con catorce temporadas en la máxima categoría del fútbol español en la que ocupa el 32.º puesto de su clasificación histórica'),('Deportivo Alavés','Alfonso Fernández','Mendizorroza',1921,'Pablo Machín',5,'El Deportivo Alavés, más conocido simplemente como Alavés, es un club de fútbol con sede en la ciudad de Vitoria. Desde su ascenso en la temporada 2016-17, resiste en la máxima categoría del fútbol español. Ocupa el 26º puesto en su clasificación histórica de la liga'),('Elche C.F.','Joaquín Buitrago','Estadio Martínez Valero',1923,'Jorge Almirón',6,'El Elche Club de Fútbol es un club de fútbol español procedente de la ciudad de Elche, Alicante. El Elche ha disputado 22 temporadas en Primera División y 39 en la Segunda División, este ocupa el 25ª puesto histórico del Campeonato Nacional de Liga con 23 participaciones'),('F.C. Barcelona','Joan Laporta','Camp Nou',1899,'Ronald Koeman',7,'El Fútbol Club Barcelona o conocido popularmente como Barça, es una entidad polideportiva con sede en Barcelona. Es el segundo club que posee más campeonatos de la Primera División, con 26 títulos, también es el 2º con más puntos en la clasificación histórica, 4603 puntos en 2914 partidos'),('Getafe C.F.','Ángel Torres','Coliseum Alfonso Pérez',1983,'José Bordalás',8,'El Getafe Club de Fútbol es un equipo de fútbol de España de la ciudad de Getafe, Madrid. Fue el 58.º equipo en incorporarse a Primera División, siendo su primera participación en la temporada 2004-05. Ocupa el puesto 23.º de la clasificación histórica de la máxima categoría'),('Granada C.F.','Rentao Yi','Nuevo Los Cármenes',1931,'Diego Martínez',9,'El Granada Club de Fútbol es una sociedad anónima deportiva de la ciudad española de Granada. Desde el 17 de julio de 2020 ocupa la posición 22 de la clasificación histórica por puntos de la Primera División, y en el 20 de la clasificación histórica por número de temporadas con 25'),('Levante U.D.','Francisco Catalán','Estadio Ciutat de València',1909,'Paco López',10,'El Levante Unión Deportiva es un club de fútbol español con sede en Valencia. Disputo su primer partido en Primera División en septiembre de 1963, el pasado 2 de febrero de 2020 disputó su partido 500 en primera división contra y actualmente está el 26º en la clasificación histótica de nuestra liga'),('R.C. Celta','Carlos Mouriño','Estadio Abanca Balaídos',1923,'Óscar García',11,'El Real Club Celta de Vigo es un club de fútbol español con sede en Vigo. Es el club gallego que más temporadas lleva en la Primera División. El Celta es uno de los once clubes con más de 55 temporadas en la competición, teniendo el puesto 11º de la clasificación histórica'),('Real Betis','Ángel Haro','Estadio Benito Villamarín',1907,'Manuel Pellegrini',12,'El Real Betis Balompié, también conocido como Real Betis, Es uno de los 9 clubes que han conquistado Liga y Copa Nacional, también es el club que más veces ha subido y bajado a Segunda División, este ocupa el 10º puesto de la clasificación histórica de Primera División'),('Real Madrid','Florentino Pérez','Estadio Santiago Bernabéu',1902,'Carlo Ancelotti',13,'El Real Madrid Club de Fútbol, más conocido simplemente como Real Madrid es el club que más títulos de la Primera División ha conquistado, con un total de 34. Además de esto, el Real Madrid es el equipo número 1 del ránking en la clasificación histórica, con un total de 4700 puntos en 2914 partidos'),('Real Sociedad','Jokin Aperribay','Reale Arena',1909,'Imanol Alguacil',14,'La Real Sociedad es un club de fútbol de la ciudad de San Sebastián, Guipúzcoa. Recientemente campeón de la Copa del Rey, en el pasado ganó dos títulos de liga consecutivos en los años 1980-81 y 1981-82, además de otros tres subcampeonatos. Ocupa en la clasificación histórica el puesto 8º'),('Real Valladolid C.F.','Ronaldo Nazário','Estadio Municipal José Zorilla',1928,'Sergio González',15,'El Real Valladolid Club de Fútbol es un club de fútbol español organizado como sociedad anónima deportiva de la ciudad de Valladolid. Es el club de fútbol más importante de Castilla y León por palmarés e historia, con de 45 temporadas en Primera División y el puesto 13º en la clasificación histórica'),('S.D. Eibar','Amaia Gorostiza','Municipal de Ipurua',1940,'José Luis Mendilibar',16,'La Sociedad Deportiva Eibar es un club de fútbol de la ciudad de Éibar en Guipúzcoa. En la temporada 2021/22 competirá en la Segunda División debido a su reciente descenso. Ha disputado 7 temporadas en la máxima categoría y esto le vale para estar el 35º en la clasificación histórica'),('S.D. Huesca','Agustín Lasaosa','El Alcoraz',1960,'Míchel',17,'La Sociedad Deportiva Huesca es un club de fútbol español de la ciudad de Huesca. Tan solo ha disputado dos temporadas en la máxima categoría, en la 2018/19 y la 2020/2021, este año volverá a Segunda encadenando varios ascensos y descensos consecutivos, es el 55º en la clasificación histórica'),('Sevilla F.C.','José Castro','Ramón Sánchez-Pizjuán',1905,'Julen Lopetegui',18,'El Sevilla Fútbol Club es un club de fútbol español organizado como sociedad anónima deportiva. Cuenta en su palmarés con varios trofeos y títulos que lo convierten en el equipo con más títulos de toda Andalucía. Ha sido campeón de Liga una vez y ocupa el 6º puesto de la clasificación histórica'),('Valencia C.F.','Anil Murthy','Camp de Mestalla',1919,'Javi Gracia',19,'El Valencia Club de Fútbol es una sociedad anónima deportiva con sede en la ciudad de Valencia. Es el 4º club español en cuanto a títulos internacionales (7) y el 5º club español con más títulos con un total de 23 trofeos. En la clasificación histórica ocupa el 4º puesto, habiendo disputado 85 de las 91 ediciones.'),('Villarreal C.F.','Fernando Roig','Estadio de la Cerámica',1923,'Unai Emery',20,'El Villarreal Club de Fútbol es un club de fútbol español, de la población de Villarreal (Castellón). A nivel internacional ha ganado 2 Intertotos y recientemente la Europa League, en el plano nacional su mejor resultado es el subcampeonato de 2007-08, ocupa el puesto 17º de la clasificación histórica');
/*!40000 ALTER TABLE `equipos` ENABLE KEYS */;
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
