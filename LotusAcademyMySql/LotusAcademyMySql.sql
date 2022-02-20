-- MySQL dump 10.13  Distrib 8.0.27, for Win64 (x86_64)
--
-- Host: localhost    Database: lotusacademy
-- ------------------------------------------------------
-- Server version	8.0.27

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
-- Table structure for table `bai_viet`
--

DROP TABLE IF EXISTS `bai_viet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bai_viet` (
  `bai_vietid` int NOT NULL AUTO_INCREMENT,
  `hinh_anh` varchar(255) DEFAULT NULL,
  `noi_dung` varchar(255) DEFAULT NULL,
  `noi_dung_ngan` varchar(1000) DEFAULT NULL,
  `ten_bai_viet` varchar(50) DEFAULT NULL,
  `ten_tac_gia` varchar(50) DEFAULT NULL,
  `thoi_gian_tao` date DEFAULT NULL,
  `chu_deid` int DEFAULT NULL,
  `tai_khoanid` int DEFAULT NULL,
  PRIMARY KEY (`bai_vietid`),
  KEY `FKf9h1s4jfpnd8kwe9iyhdyk97o` (`chu_deid`),
  KEY `FK4cv5nl719vk7l767um6slitms` (`tai_khoanid`),
  CONSTRAINT `FK4cv5nl719vk7l767um6slitms` FOREIGN KEY (`tai_khoanid`) REFERENCES `tai_khoan` (`tai_khoanid`),
  CONSTRAINT `FKf9h1s4jfpnd8kwe9iyhdyk97o` FOREIGN KEY (`chu_deid`) REFERENCES `chu_de` (`chu_deid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bai_viet`
--

LOCK TABLES `bai_viet` WRITE;
/*!40000 ALTER TABLE `bai_viet` DISABLE KEYS */;
INSERT INTO `bai_viet` VALUES (1,'./image/baiviet1','Nội dung 1','Nội dung ngắn 1','Tên bài viết 1','Cộng tác viên','2020-01-10',1,1),(2,'./image/baiviet2','Nội dung 2','Nội dung ngắn 2','Tên bài viết 2','Cộng tác viên','2020-01-10',2,2),(3,'./image/baiviet3','Nội dung 3','Nội dung ngắn 3','Tên bài viết so 3','Cộng tác viên 3','2020-01-10',3,3);
/*!40000 ALTER TABLE `bai_viet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chu_de`
--

DROP TABLE IF EXISTS `chu_de`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chu_de` (
  `chu_deid` int NOT NULL AUTO_INCREMENT,
  `noi_dung` varchar(255) DEFAULT NULL,
  `ten_chu_de` varchar(50) DEFAULT NULL,
  `loai_bai_vietid` int DEFAULT NULL,
  PRIMARY KEY (`chu_deid`),
  KEY `FKausefogl5tcc5i6uw7o1qr5dw` (`loai_bai_vietid`),
  CONSTRAINT `FKausefogl5tcc5i6uw7o1qr5dw` FOREIGN KEY (`loai_bai_vietid`) REFERENCES `loai_bai_viet` (`loai_bai_vietid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chu_de`
--

LOCK TABLES `chu_de` WRITE;
/*!40000 ALTER TABLE `chu_de` DISABLE KEYS */;
INSERT INTO `chu_de` VALUES (1,'Con trỏ','Kiến thức về con trỏ',2),(2,'Lịch nghỉ  tết','Thông báo nghỉ tết',1),(3,'Con trỏ','Kiến thức về java',2),(8,'Con trỏ','Kiến thức về Python',3),(9,'Kiến thức về VueJs','Kiến thức về VueJs',4);
/*!40000 ALTER TABLE `chu_de` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dang_ky_hoc`
--

DROP TABLE IF EXISTS `dang_ky_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `dang_ky_hoc` (
  `dang_ky_hocid` int NOT NULL AUTO_INCREMENT,
  `ngay_bat_dau` date DEFAULT NULL,
  `ngay_dang_ky` date DEFAULT NULL,
  `ngay_ket_thuc` date DEFAULT NULL,
  `hoc_vienid` int DEFAULT NULL,
  `khoa_hocid` int DEFAULT NULL,
  `tai_khoanid` int DEFAULT NULL,
  `tinh_trang_hocid` int DEFAULT NULL,
  PRIMARY KEY (`dang_ky_hocid`),
  KEY `FKha8puqtefhyfy2em32rdb2j9l` (`hoc_vienid`),
  KEY `FKq0to4ty0cpyp2bh38shpfqcyy` (`khoa_hocid`),
  KEY `FKi5l9nnf179w45wbbs8wygln4i` (`tai_khoanid`),
  KEY `FKckhub0fp425h0vmnuf1mflje7` (`tinh_trang_hocid`),
  CONSTRAINT `FKckhub0fp425h0vmnuf1mflje7` FOREIGN KEY (`tinh_trang_hocid`) REFERENCES `tinh_trang_hoc` (`tinh_trang_hocid`),
  CONSTRAINT `FKha8puqtefhyfy2em32rdb2j9l` FOREIGN KEY (`hoc_vienid`) REFERENCES `hoc_vien` (`hoc_vienid`),
  CONSTRAINT `FKi5l9nnf179w45wbbs8wygln4i` FOREIGN KEY (`tai_khoanid`) REFERENCES `tai_khoan` (`tai_khoanid`),
  CONSTRAINT `FKq0to4ty0cpyp2bh38shpfqcyy` FOREIGN KEY (`khoa_hocid`) REFERENCES `khoa_hoc` (`khoa_hocid`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dang_ky_hoc`
--

LOCK TABLES `dang_ky_hoc` WRITE;
/*!40000 ALTER TABLE `dang_ky_hoc` DISABLE KEYS */;
INSERT INTO `dang_ky_hoc` VALUES (2,'2020-01-02','2020-01-01','2020-03-02',2,2,2,2),(3,'2020-01-02','2020-01-01',NULL,3,3,NULL,NULL),(4,'2020-01-02','2020-01-01','2020-03-02',4,4,2,NULL),(5,'2020-01-02','2022-02-18',NULL,3,2,2,2),(6,'2020-01-02','2022-02-19',NULL,2,2,3,3),(7,'2020-01-02','2020-01-01','2020-01-04',2,2,2,2),(8,'2020-01-02','2020-01-02','2020-01-04',2,2,2,2);
/*!40000 ALTER TABLE `dang_ky_hoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hoc_vien`
--

DROP TABLE IF EXISTS `hoc_vien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hoc_vien` (
  `hoc_vienid` int NOT NULL AUTO_INCREMENT,
  `email` varchar(40) DEFAULT NULL,
  `hinh_anh` varchar(255) DEFAULT NULL,
  `ho_ten` varchar(50) DEFAULT NULL,
  `ngay_sinh` date DEFAULT NULL,
  `quan_huyen` varchar(50) DEFAULT NULL,
  `so_dien_thoai` varchar(11) DEFAULT NULL,
  `so_nha` varchar(50) DEFAULT NULL,
  `tinh_thanh` varchar(50) DEFAULT NULL,
  `phuong_xa` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`hoc_vienid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hoc_vien`
--

LOCK TABLES `hoc_vien` WRITE;
/*!40000 ALTER TABLE `hoc_vien` DISABLE KEYS */;
INSERT INTO `hoc_vien` VALUES (1,'abc@gmail.com','./image/anh1','Kim Soo Hook','2000-11-11','Từ sơn','0123455566','1','Bắc Ninh',NULL),(2,'abc@gmail.com','./image/anh2','Lee Min Hoo','2000-11-11','Từ Sơn','0123455566','1','Bắc Ninh',NULL),(3,'abc@gmail.com','./image/anh3','Kim Tran','2000-11-11','Từ Sơn','0123455566','2','Bắc Ninh',NULL),(4,'abc@gmail.com','./image/anh4','Uzumaki Maruto','2000-11-11','Từ Sơn','0123455566','2','Bắc Ninh',NULL);
/*!40000 ALTER TABLE `hoc_vien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khoa_hoc`
--

DROP TABLE IF EXISTS `khoa_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khoa_hoc` (
  `khoa_hocid` int NOT NULL AUTO_INCREMENT,
  `gioi_thieu` varchar(255) DEFAULT NULL,
  `hinh_anh` varchar(255) DEFAULT NULL,
  `hoc_phi` float DEFAULT NULL,
  `noi_dung` varchar(255) DEFAULT NULL,
  `so_hoc_vien` int DEFAULT NULL,
  `so_luong_mon` int DEFAULT NULL,
  `ten_khoa_hoc` varchar(50) DEFAULT NULL,
  `thoi_gian_hoc` int DEFAULT NULL,
  `loai_khoa_hocid` int DEFAULT NULL,
  PRIMARY KEY (`khoa_hocid`),
  KEY `FKpaaa8gtmm8ueulnftsdky5p7i` (`loai_khoa_hocid`),
  CONSTRAINT `FKpaaa8gtmm8ueulnftsdky5p7i` FOREIGN KEY (`loai_khoa_hocid`) REFERENCES `loai_khoa_hoc` (`loai_khoa_hocid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khoa_hoc`
--

LOCK TABLES `khoa_hoc` WRITE;
/*!40000 ALTER TABLE `khoa_hoc` DISABLE KEYS */;
INSERT INTO `khoa_hoc` VALUES (1,'Giới thiêu','./image/net.jpa',200000,'Nội dung',20,3,'.NET',2,1),(2,'Giới thiệu','./image/reactjs.jpg',200000,'Nội dung',20,3,'ReactJs',2,2),(3,'Giới thiệu','./image.java.jpg',200000,'Nội dung',15,4,'Java',3,1),(4,'Giới Thiệu','./image/vuejs.jpg',100000,'Nội dung',25,2,'VueJs',1,2);
/*!40000 ALTER TABLE `khoa_hoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loai_bai_viet`
--

DROP TABLE IF EXISTS `loai_bai_viet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loai_bai_viet` (
  `loai_bai_vietid` int NOT NULL AUTO_INCREMENT,
  `ten_loai` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`loai_bai_vietid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loai_bai_viet`
--

LOCK TABLES `loai_bai_viet` WRITE;
/*!40000 ALTER TABLE `loai_bai_viet` DISABLE KEYS */;
INSERT INTO `loai_bai_viet` VALUES (1,'Thông Báo'),(2,'Bài Giảng'),(3,'Java'),(4,'VueJS');
/*!40000 ALTER TABLE `loai_bai_viet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loai_khoa_hoc`
--

DROP TABLE IF EXISTS `loai_khoa_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loai_khoa_hoc` (
  `loai_khoa_hocid` int NOT NULL AUTO_INCREMENT,
  `ten_loai` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`loai_khoa_hocid`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loai_khoa_hoc`
--

LOCK TABLES `loai_khoa_hoc` WRITE;
/*!40000 ALTER TABLE `loai_khoa_hoc` DISABLE KEYS */;
INSERT INTO `loai_khoa_hoc` VALUES (1,'Back-End'),(2,'Front-End'),(3,'FullStack');
/*!40000 ALTER TABLE `loai_khoa_hoc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `quyen_han`
--

DROP TABLE IF EXISTS `quyen_han`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quyen_han` (
  `quyen_hanid` int NOT NULL AUTO_INCREMENT,
  `ten_quyen_han` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`quyen_hanid`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quyen_han`
--

LOCK TABLES `quyen_han` WRITE;
/*!40000 ALTER TABLE `quyen_han` DISABLE KEYS */;
INSERT INTO `quyen_han` VALUES (1,'Admin'),(2,'Cộng Tác Viên'),(3,'Quản Lý Đào Tạo'),(4,'Giảng viên'),(5,'Quản Lý Đào Tạo');
/*!40000 ALTER TABLE `quyen_han` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tai_khoan`
--

DROP TABLE IF EXISTS `tai_khoan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tai_khoan` (
  `tai_khoanid` int NOT NULL AUTO_INCREMENT,
  `mat_khau` varchar(50) DEFAULT NULL,
  `ten_dang_nhap` varchar(50) DEFAULT NULL,
  `ten_nguoi_dung` varchar(50) DEFAULT NULL,
  `quyen_hanid` int DEFAULT NULL,
  PRIMARY KEY (`tai_khoanid`),
  KEY `FKr0psi5ssln4d0amyd81ukedah` (`quyen_hanid`),
  CONSTRAINT `FKr0psi5ssln4d0amyd81ukedah` FOREIGN KEY (`quyen_hanid`) REFERENCES `quyen_han` (`quyen_hanid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tai_khoan`
--

LOCK TABLES `tai_khoan` WRITE;
/*!40000 ALTER TABLE `tai_khoan` DISABLE KEYS */;
INSERT INTO `tai_khoan` VALUES (1,'nhoc@Tap1','Queees','CaQuees',1),(2,'123','LA_CTV1','CTV1',2),(3,'123','LA_QL1','QuanLy1',3),(4,'123','LA_QL4','QuanLy4',NULL);
/*!40000 ALTER TABLE `tai_khoan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tinh_trang_hoc`
--

DROP TABLE IF EXISTS `tinh_trang_hoc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tinh_trang_hoc` (
  `tinh_trang_hocid` int NOT NULL AUTO_INCREMENT,
  `ten_tinh_trang` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`tinh_trang_hocid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tinh_trang_hoc`
--

LOCK TABLES `tinh_trang_hoc` WRITE;
/*!40000 ALTER TABLE `tinh_trang_hoc` DISABLE KEYS */;
INSERT INTO `tinh_trang_hoc` VALUES (1,'Chờ Duyệt'),(2,'Đang Học Chính'),(3,'Học Xong'),(4,'Chưa hoàn thành');
/*!40000 ALTER TABLE `tinh_trang_hoc` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-02-20 20:43:09
