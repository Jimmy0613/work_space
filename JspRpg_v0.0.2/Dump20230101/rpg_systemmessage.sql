-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: rpg
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `systemmessage`
--

DROP TABLE IF EXISTS `systemmessage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `systemmessage` (
  `sm_num` int NOT NULL AUTO_INCREMENT,
  `msg` char(255) DEFAULT NULL,
  PRIMARY KEY (`sm_num`)
) ENGINE=InnoDB AUTO_INCREMENT=79 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `systemmessage`
--

LOCK TABLES `systemmessage` WRITE;
/*!40000 ALTER TABLE `systemmessage` DISABLE KEYS */;
INSERT INTO `systemmessage` VALUES (59,'[ 0 ] 환영합니다!'),(60,'[ 1 ] 복도(으)로 이동했습니다.'),(61,'[ 2 ] 아늑한 방(으)로 이동했습니다.'),(62,'[ 3 ] 복도(으)로 이동했습니다.'),(63,'[ 4 ] 아늑한 방(으)로 이동했습니다.'),(64,'[ 5 ] 복도(으)로 이동했습니다.'),(65,'[ 6 ] 아늑한 방(으)로 이동했습니다.'),(66,'[ 7 ] 복도(으)로 이동했습니다.'),(67,'[ 8 ] 아늑한 방(으)로 이동했습니다.'),(68,'[ 9 ] 복도(으)로 이동했습니다.'),(69,'[ 10 ] 아늑한 방(으)로 이동했습니다.'),(70,'[ 11 ] 복도(으)로 이동했습니다.'),(71,'[ 12 ] 아늑한 방(으)로 이동했습니다.'),(72,'[ 13 ] 복도(으)로 이동했습니다.'),(73,'[ 14 ] 복도(으)로 이동했습니다.'),(74,'[ 15 ] 복도(으)로 이동했습니다.'),(75,'[ 16 ] 복도(으)로 이동했습니다.'),(76,'[ 17 ] 아늑한 방(으)로 이동했습니다.'),(77,'[ 18 ] 복도(으)로 이동했습니다.'),(78,'[ 19 ] 아늑한 방(으)로 이동했습니다.');
/*!40000 ALTER TABLE `systemmessage` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-01-01 23:15:01
