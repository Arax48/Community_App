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
  PRIMARY KEY (`idAnuncio`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `anuncio`
--

LOCK TABLES `anuncio` WRITE;
/*!40000 ALTER TABLE `anuncio` DISABLE KEYS */;
INSERT INTO `anuncio` VALUES (1,232,'2002-01-21','zsdfd','asdfsd'),(2,12,'2001-02-12','asdasdfsdasdf','asdfasdf');
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
-- Table structure for table `areas comunes`
--

DROP TABLE IF EXISTS `areas comunes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `areas comunes` (
  `id_area` int NOT NULL AUTO_INCREMENT,
  `nom_area` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_area`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `areas comunes`
--

LOCK TABLES `areas comunes` WRITE;
/*!40000 ALTER TABLE `areas comunes` DISABLE KEYS */;
INSERT INTO `areas comunes` VALUES (1,'piscina'),(2,'juesgos'),(3,'Cancha Deportiva'),(4,'Salon Social');
/*!40000 ALTER TABLE `areas comunes` ENABLE KEYS */;
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
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
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
  `tipo_animal` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `id_usuario` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `perdido` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`id_mascota`),
  KEY `id_dueno` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mascotas`
--

LOCK TABLES `mascotas` WRITE;
/*!40000 ALTER TABLE `mascotas` DISABLE KEYS */;
INSERT INTO `mascotas` VALUES (1,'tin','Labrador','123','0'),(2,'alf','perrro','234','0'),(3,'alf','perrro','234','1'),(4,'kjhkjh','kjhkjh','54','0'),(5,'jhgjhg','jkhghj','565','0'),(6,'jkjlkj','lkjlkj','87','1'),(7,'sdfsd','jhhvjh','7676','1'),(8,'tomas','golden','101','1');
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
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `novedadesvigilante`
--

LOCK TABLES `novedadesvigilante` WRITE;
/*!40000 ALTER TABLE `novedadesvigilante` DISABLE KEYS */;
INSERT INTO `novedadesvigilante` VALUES (1,21,'2024-09-03 06:10:09','NOVEDAD 1','SE ROMPIO LA MATERA DE LA TORRE 1','A'),(2,21,'2024-09-03 06:18:17','novedad 2','se entro ladron en la madrugada pero no se llevo nada','A'),(3,21,'2024-09-03 06:51:18','casa  302 sola','la desocuoaron ','A'),(4,21,'2024-09-03 07:00:04','ruptura agua','1234','A'),(5,21,'2024-09-03 08:39:36','REPORTE 45','SE DAÑO LA SALA DE BODEGA','A');
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
  PRIMARY KEY (`idpago`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pago`
--

LOCK TABLES `pago` WRITE;
/*!40000 ALTER TABLE `pago` DISABLE KEYS */;
INSERT INTO `pago` VALUES (19,'kljhkjlkl','lkjlk','lkjlkj'),(20,'asdsad','asdsa','asdsa'),(21,'8987','jhhkjh','kjhkjh'),(22,'asdas','asdasd','asdas'),(23,'2323','asds','asdas'),(24,'2323','asds','asdas'),(25,'2323','asds','asdas'),(26,'2323','asds','asdas'),(27,'2323','asds','asdas'),(28,'asd','asd','123412'),(29,'kjlkj','lkjlkj','lkjlkj'),(30,'klkjlkj','lkjlkj','lkjlkj'),(31,'1500','administracion','lorena'),(32,'1500','administracion','lorena'),(33,'1500','administracion','lorena');
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
  PRIMARY KEY (`id_queja`),
  KEY `id_usuario` (`id_usuario`),
  CONSTRAINT `quejasypeticiones_ibfk_1` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quejasypeticiones`
--

LOCK TABLES `quejasypeticiones` WRITE;
/*!40000 ALTER TABLE `quejasypeticiones` DISABLE KEYS */;
INSERT INTO `quejasypeticiones` VALUES (2,1,'2024-08-12','hola','jhkjkjhkjh'),(4,1,'2024-01-01','1','1');
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
  `nombre` varchar(45) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `casa` varchar(45) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `horario` varchar(45) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `contacto` varchar(45) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id_reservas`),
  KEY `id_usuario` (`id_usuario`),
  KEY `id_area` (`id_area`),
  CONSTRAINT `reservas_ibfk_1` FOREIGN KEY (`id_area`) REFERENCES `areas comunes` (`id_area`),
  CONSTRAINT `reservas_ibfk_2` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reservas`
--

LOCK TABLES `reservas` WRITE;
/*!40000 ALTER TABLE `reservas` DISABLE KEYS */;
INSERT INTO `reservas` VALUES (1,'2024-09-03',20,1,'leo','101','10','3108113034'),(2,'2024-09-04',20,1,'martha','102','10','3108113035'),(4,'2024-09-05',20,4,'martha','104','5','123'),(5,'2024-09-02',20,3,'paco','455','1','969'),(6,'2024-09-02',20,2,'junita','123','5','3108512'),(7,'2024-09-05',20,1,'ALEJANDRO','458','5','3151');
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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'jack','1234312','@gmail.com','aasdfdw','','3','203',NULL,NULL,NULL),(2,'jack','1234312','asd@gmail.com','1234','','3','203',NULL,NULL,NULL),(3,'bob','12312','@gmail','asdsa','jax','3','3',NULL,NULL,NULL),(6,'bob','12312','@gmailsafd','asdsa','jax','3','3',NULL,NULL,NULL),(8,'asfasfas','asfas','asfas','asfas','asfasasf','asfas','asfasfsa',NULL,NULL,NULL),(11,'bob','12312','@gmailsajfd','asdsa','jax','3','3','true',NULL,NULL),(13,'afasfsd','sdfsdf','sdfsd','sdfsd','sdfsd','sddfsd','sdfsd','1',NULL,NULL),(15,'poioi','poipi','poipoip','piopi','poipoi098','8908','09808','1',NULL,NULL),(17,'olkj','lkjlkj','lkj','kjlkj','lkjlkj','lkjlk','lkj','1',NULL,NULL),(18,'olkj','lkjlkj','lkj','kjlkj','lkjlkj','lkjlk','lkj','1',NULL,NULL),(19,'asdsa','asdasd','asdasd','1234','leo','1234','asdasd','1',NULL,NULL),(20,'ñlkñlk','ñlkñlk','lkjñlkj','1234','cris','lkjlkj','lñkjlñkjl',NULL,'1',NULL),(21,'LEYDER','31081154','jhkjhhjk','1234','ley',NULL,NULL,NULL,NULL,'1'),(22,'Juan','12321','@asdas','1234','juan',NULL,NULL,NULL,NULL,'1'),(23,'bob','12312','@gmailsajfd','asdsa','jax','3','3','true',NULL,NULL);
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
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `visitante`
--

LOCK TABLES `visitante` WRITE;
/*!40000 ALTER TABLE `visitante` DISABLE KEYS */;
INSERT INTO `visitante` VALUES (6,'aiil','2003-07-06','12:00','6476476','765764764','5','601','hgkfkjlkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkkk kkhkjh','0'),(8,'jhkjhkjh','2024-08-14','12:12','kjhkjh','nbnbkjb','kjhkjh','kjhkjh','kjhjhkjh','1'),(11,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'0'),(13,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'false'),(15,'CRISTIAN SUESCA','2024-09-03','10:10','12345','1018523','1','1','VISITA CLARITA',NULL),(21,'a','2024-09-02','2:2','a','1','1','1','ana',NULL);
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

-- Dump completed on 2024-09-03  8:53:07
