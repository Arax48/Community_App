CREATE DATABASE  IF NOT EXISTS `community` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `community`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: localhost    Database: community
-- ------------------------------------------------------
-- Server version	8.0.39

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
-- Table structure for table `anuncio`
--

DROP TABLE IF EXISTS `anuncio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `anuncio` (
  `idAnuncio` int NOT NULL AUTO_INCREMENT,
  `idAdmin` int DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `asunto` varchar(45) DEFAULT NULL,
  `anuncio` text,
  `estado` varchar(45) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`idAnuncio`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anuncio`
--

LOCK TABLES `anuncio` WRITE;
/*!40000 ALTER TABLE `anuncio` DISABLE KEYS */;
INSERT INTO `anuncio` VALUES (11,20,'2024-09-05','Se cayó el vigilante','Se fracturó','A'),(12,19,'2024-09-05','Pagar arreglo matera','Pagar profa','A');
/*!40000 ALTER TABLE `anuncio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `apartamentos`
--

DROP TABLE IF EXISTS `apartamentos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `apartamentos` (
  `aparta_id` int NOT NULL AUTO_INCREMENT,
  `aparta_numero` varchar(45) DEFAULT NULL,
  `aparta_residente_id` int NOT NULL,
  PRIMARY KEY (`aparta_id`),
  KEY `apartaresidente_idx` (`aparta_residente_id`),
  CONSTRAINT `apartaresidente` FOREIGN KEY (`aparta_residente_id`) REFERENCES `usuarios` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `apartamentos`
--

LOCK TABLES `apartamentos` WRITE;
/*!40000 ALTER TABLE `apartamentos` DISABLE KEYS */;
INSERT INTO `apartamentos` VALUES (2,'101',20);
/*!40000 ALTER TABLE `apartamentos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `areas_comunes`
--

DROP TABLE IF EXISTS `areas_comunes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `areas_comunes` (
  `id_area` int NOT NULL AUTO_INCREMENT,
  `nom_area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_area`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areas_comunes`
--

LOCK TABLES `areas_comunes` WRITE;
/*!40000 ALTER TABLE `areas_comunes` DISABLE KEYS */;
INSERT INTO `areas_comunes` VALUES (1,'Piscina'),(2,'Juegos'),(3,'Cancha Deportiva'),(4,'Salon Social');
/*!40000 ALTER TABLE `areas_comunes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `logintest`
--

DROP TABLE IF EXISTS `logintest`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `logintest` (
  `idLoginTest` int NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`idLoginTest`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `logintest`
--

LOCK TABLES `logintest` WRITE;
/*!40000 ALTER TABLE `logintest` DISABLE KEYS */;
INSERT INTO `logintest` VALUES (1,'jack','1234'),(2,'jackaa','1234312');
/*!40000 ALTER TABLE `logintest` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mascotas`
--

DROP TABLE IF EXISTS `mascotas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mascotas` (
  `id_mascota` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `tipo_animal` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `id_usuario` int NOT NULL,
  `perdido` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `raza` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  `casa_o_apto` varchar(45) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_mascota`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mascotas`
--

LOCK TABLES `mascotas` WRITE;
/*!40000 ALTER TABLE `mascotas` DISABLE KEYS */;
INSERT INTO `mascotas` VALUES (1,'Tin',NULL,20,'1','Criolla','301'),(2,'Tomas',NULL,24,'1','Perro','301'),(4,'Brillo',NULL,24,'0','Gato','506'),(5,'Tin Tin',NULL,20,'1','Criolla','201'),(6,'Tims',NULL,20,'0','Perico','306'),(7,'tommy',NULL,20,'1','Pelicano','608');
/*!40000 ALTER TABLE `mascotas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `novedadesvigilante`
--

DROP TABLE IF EXISTS `novedadesvigilante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `novedadesvigilante` (
  `idNovedadesVigilante` int NOT NULL AUTO_INCREMENT,
  `idVigilante` int NOT NULL,
  `fecha` datetime DEFAULT NULL,
  `Asunto` varchar(45) DEFAULT NULL,
  `Peticion` text,
  `estado` varchar(2) NOT NULL DEFAULT 'A',
  PRIMARY KEY (`idNovedadesVigilante`),
  KEY `usuariovigilante_idx` (`idVigilante`),
  CONSTRAINT `vigilante_usuario` FOREIGN KEY (`idVigilante`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `novedadesvigilante`
--

LOCK TABLES `novedadesvigilante` WRITE;
/*!40000 ALTER TABLE `novedadesvigilante` DISABLE KEYS */;
INSERT INTO `novedadesvigilante` VALUES (1,21,'2024-09-03 06:10:09','NOVEDAD 1','SE ROMPIO LA MATERA DE LA TORRE 1','I'),(2,21,'2024-09-03 06:18:17','novedad 2','se entro ladron en la madrugada pero no se llevo nada','A'),(3,21,'2024-09-03 06:51:18','casa  302 sola','la desocuoaron ','A'),(4,21,'2024-09-03 07:00:04','ruptura agua','1234','A'),(5,21,'2024-09-03 08:39:36','REPORTE 45','SE DAÑO LA SALA DE BODEGA','I'),(6,21,'2024-09-04 12:47:02','Daño matera','Se partió','A'),(7,21,'2024-09-04 12:48:32','Matera rota','Se cayó','A'),(8,21,'2024-09-04 15:09:31','Baldosa rota','Se  quebró','A'),(9,21,'2024-09-04 20:42:56','Estoy cansado','Ya casitooo','A'),(10,21,'2024-09-05 16:35:16','Se daño el telecomunicador','Se ma cayó y chao','A');
/*!40000 ALTER TABLE `novedadesvigilante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paginas`
--

DROP TABLE IF EXISTS `paginas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `paginas` (
  `id_pagina` int NOT NULL AUTO_INCREMENT,
  `nom_pag` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `ruta` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `icono` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_pagina`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paginas`
--

LOCK TABLES `paginas` WRITE;
/*!40000 ALTER TABLE `paginas` DISABLE KEYS */;
/*!40000 ALTER TABLE `paginas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pago`
--

DROP TABLE IF EXISTS `pago`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pago` (
  `idpago` int NOT NULL AUTO_INCREMENT,
  `cantidad` varchar(45) NOT NULL,
  `concepto` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `estado` varchar(45) NOT NULL DEFAULT 'P',
  PRIMARY KEY (`idpago`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
INSERT INTO `pago` VALUES (34,'120.000','Agua','Alejo','P'),(35,'120.000','Arreglo Tuberias','Alejo','P'),(36,'340.000','Pagar Matera','Alejandro','P'),(37,'128.000','Arreglo electrico','Alejandro','P');
/*!40000 ALTER TABLE `pago` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfiles`
--

DROP TABLE IF EXISTS `perfiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfiles` (
  `id_perfil` int NOT NULL AUTO_INCREMENT,
  `nombre_perfil` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_perfil`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfiles`
--

LOCK TABLES `perfiles` WRITE;
/*!40000 ALTER TABLE `perfiles` DISABLE KEYS */;
/*!40000 ALTER TABLE `perfiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quejasypeticiones`
--

DROP TABLE IF EXISTS `quejasypeticiones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quejasypeticiones` (
  `id_queja` int NOT NULL AUTO_INCREMENT,
  `id_usuario` int NOT NULL,
  `fecha` date NOT NULL,
  `asunto` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `peticion` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `estado` varchar(45) COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'A',
  PRIMARY KEY (`id_queja`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `quejasypeticiones_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quejasypeticiones`
--

LOCK TABLES `quejasypeticiones` WRITE;
/*!40000 ALTER TABLE `quejasypeticiones` DISABLE KEYS */;
INSERT INTO `quejasypeticiones` VALUES (2,1,'2024-08-12','Daño Tuberia','Se daño la tuberia del baño','I'),(4,1,'2024-01-01','Trasteo','Solicito trasteo para el sabado','A'),(5,20,'2024-09-05','Necesito un Cerrajero','Me quedé sin llaves','A');
/*!40000 ALTER TABLE `quejasypeticiones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reservas`
--

DROP TABLE IF EXISTS `reservas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reservas` (
  `id_reservas` int NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `id_usuario` int NOT NULL,
  `id_area` int NOT NULL,
  `nombre` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `casa` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `horario` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `contacto` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id_reservas`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_area` (`id_area`),
  CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`id_area`) REFERENCES `areas_comunes` (`id_area`),
  CONSTRAINT `reservas_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
INSERT INTO `reservas` VALUES (9,'2024-09-05',20,2,'Alejandro','301','32153452345','12:20'),(10,'2024-09-13',20,1,'Alejandro','301','3124567898','12:45'),(11,'2024-09-13',20,3,'Alejandro','708','3214567834','12:45');
/*!40000 ALTER TABLE `reservas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `torres`
--

DROP TABLE IF EXISTS `torres`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `torres` (
  `torre_id` int NOT NULL AUTO_INCREMENT,
  `terre_nombre` varchar(45) NOT NULL,
  `torre_admin` int NOT NULL,
  PRIMARY KEY (`torre_id`),
  KEY `torreusuario_idx` (`torre_admin`),
  CONSTRAINT `torreusuario` FOREIGN KEY (`torre_admin`) REFERENCES `usuarios` (`id_usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `torres`
--

LOCK TABLES `torres` WRITE;
/*!40000 ALTER TABLE `torres` DISABLE KEYS */;
INSERT INTO `torres` VALUES (1,'TORRE 1',19);
/*!40000 ALTER TABLE `torres` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuario` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `telefono` varchar(15) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `email` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `password` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `username` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `numero_torre` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `numero_apartamento` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Admin` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Resident` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Vigilante` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id_usuario`),
  UNIQUE KEY `id_usuario_UNIQUE` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'jack','1234312','@gmail.com','aasdfdw','','3','203',NULL,NULL,NULL),(2,'jack','1234312','asd@gmail.com','1234','','3','203',NULL,NULL,NULL),(3,'bob','12312','@gmail','asdsa','jax','3','3',NULL,NULL,NULL),(6,'bob','12312','@gmailsafd','asdsa','jax','3','3',NULL,NULL,NULL),(8,'asfasfas','asfas','asfas','asfas','asfasasf','asfas','asfasfsa',NULL,NULL,NULL),(11,'bob','12312','@gmailsajfd','asdsa','jax','3','3','true',NULL,NULL),(13,'afasfsd','sdfsdf','sdfsd','sdfsd','sdfsd','sddfsd','sdfsd','1',NULL,NULL),(15,'poioi','poipi','poipoip','piopi','poipoi098','8908','09808','1',NULL,NULL),(17,'olkj','lkjlkj','lkj','kjlkj','lkjlkj','lkjlk','lkj','1',NULL,NULL),(18,'olkj','lkjlkj','lkj','kjlkj','lkjlkj','lkjlk','lkj','1',NULL,NULL),(19,'Alejo','asdasd','asdasd','1234','Alejo','1234','asdasd','1',NULL,NULL),(20,'Alejandro','ñlkñlk','lkjñlkj','1234','Alejandro','lkjlkj','lñkjlñkjl',NULL,'1',NULL),(21,'LEYDER','31081154','jhkjhhjk','1234','ley',NULL,NULL,NULL,NULL,'1'),(22,'Juan','12321','@asdas','1234','juan',NULL,NULL,NULL,NULL,'1'),(23,'bob','12312','@gmailsajfd','asdsa','jax','3','3','true',NULL,NULL),(24,'David','2351235','@mail','awfasdf','Lex','23','201',NULL,'1',NULL),(25,'','','','','',NULL,NULL,NULL,NULL,'1'),(30,'x','','','','',NULL,NULL,NULL,NULL,'1'),(31,'Cristian','12341234','@hotmail','cris','cris','23','12',NULL,'1',NULL),(32,'Juan Pérez','555-1234','juan.perez@example.com','password123','juanperez','Torre 1','Apt 101','No','Yes','No'),(33,'María Gómez','555-5678','maria.gomez@example.com','pass4567','mariag','Torre 2','Apt 202','Yes','No','No'),(34,'Carlos Díaz','555-9876','carlos.diaz@example.com','secret789','carlosd','Torre 3','Apt 303','No','Yes','No'),(35,'Ana López','555-6543','ana.lopez@example.com','mypassword','analopez','Torre 4','Apt 404','No','No','Yes'),(36,'Luis Fernández','555-4321','luis.fernandez@example.com','luispass','luisf','Torre 5','Apt 505','Yes','No','No'),(37,'Juan Pérez','555-1234','juan.perez@example.com','password123','juanperez','Torre 1','Apt 101','No','Yes','No'),(38,'María Gómez','555-5678','maria.gomez@example.com','pass4567','mariag','Torre 2','Apt 202','Yes','No','No'),(39,'Carlos Díaz','555-9876','carlos.diaz@example.com','secret789','carlosd','Torre 3','Apt 303','No','Yes','No'),(40,'Ana López','555-6543','ana.lopez@example.com','mypassword','analopez','Torre 4','Apt 404','No','No','Yes'),(41,'Luis Fernández','555-4321','luis.fernandez@example.com','luispass','luisf','Torre 5','Apt 505','Yes','No','No'),(42,'Cristian','32142344','hola@hotmail.com','asdfaffds','Cris','2','301',NULL,'1',NULL),(43,'Pedro','321123512','pedro@gmail.com','asdfasdf','Ped',NULL,NULL,NULL,NULL,'1'),(44,'Francisco','321452453','fran@hotmail.com','asdfsad','Fran',NULL,NULL,NULL,NULL,'1'),(45,'Alf','134564634','alfred@gmail.com','asdfsdg','Alfff','3','801',NULL,'1',NULL),(46,'Leyder','2342123443','ley@gmail.com','asdfdsf','Leyy',NULL,NULL,NULL,NULL,'1'),(47,'Roberto','3123456743','Roberto@hotmail.com','Robertoxd','Robert','3','805','1',NULL,NULL),(48,'Maycol','3456784356','mike@gmail.com','0987','Mike','5','908',NULL,'1',NULL),(49,'Reynaldo','3124567894','Rey@hotmail.com','0987','Rey',NULL,NULL,NULL,NULL,'1');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `visitante`
--

DROP TABLE IF EXISTS `visitante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `visitante` (
  `id_visitante` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `horaVisita` varchar(55) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `telefono` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `docIdentidad` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `torre` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `apto` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `proposito` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci,
  `isAdentro` varchar(45) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  UNIQUE KEY `docIdentidad_UNIQUE` (`docIdentidad`),
  KEY `id_usuario` (`id_visitante`),
  CONSTRAINT `visitante_ibfk_1` FOREIGN KEY (`id_visitante`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitante`
--

LOCK TABLES `visitante` WRITE;
/*!40000 ALTER TABLE `visitante` DISABLE KEYS */;
INSERT INTO `visitante` VALUES (30,'Gerardo','2024-09-05','12:45','3144365466','1234123423','1','401','Visitar a mi tia','true'),(31,'Ryan','2024-09-04','12:43','122345345','12342343','2','301','Visitar al abuelo','true'),(32,'Ronald','2024-09-04','2:23','3123413232','1552132345','3','301','Arreglar la cocina','false'),(33,'Anny','2024-09-05','15:53','3124456875','123456784','3','901','Arreglar paredes','false');
/*!40000 ALTER TABLE `visitante` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-05 17:11:27
