-- MySQL dump 10.13  Distrib 8.0.22, for Win64 (x86_64)
--
-- Host: localhost    Database: fashionshop_v5
-- ------------------------------------------------------
-- Server version	8.0.22

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
-- Table structure for table `chitietdonhang`
--

DROP TABLE IF EXISTS `chitietdonhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietdonhang` (
  `maSanPham` int NOT NULL,
  `donGia` double DEFAULT NULL,
  `soLuong` int DEFAULT NULL,
  `tenNoiSanXuat` varchar(255) DEFAULT NULL,
  `tenSanPham` varchar(255) DEFAULT NULL,
  `thanhTien` double DEFAULT NULL,
  `maDonHang` int NOT NULL,
  `phanLoai` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`maSanPham`,`maDonHang`),
  KEY `FKc6u2skna5psh3e10vrapqwecx` (`maDonHang`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietdonhang`
--

LOCK TABLES `chitietdonhang` WRITE;
/*!40000 ALTER TABLE `chitietdonhang` DISABLE KEYS */;
/*!40000 ALTER TABLE `chitietdonhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietgiohang`
--

DROP TABLE IF EXISTS `chitietgiohang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietgiohang` (
  `maChiTietGioHang` int NOT NULL,
  `phanLoai` varchar(255) DEFAULT NULL,
  `soLuong` int DEFAULT NULL,
  `thanhTien` double DEFAULT NULL,
  `maGioHang` int DEFAULT NULL,
  `maSanPham` int DEFAULT NULL,
  PRIMARY KEY (`maChiTietGioHang`),
  KEY `FKb8ymhkeo64o0d1g2neb3le1mg` (`maGioHang`),
  KEY `FKtkxwdoy6w8kqtglkbfqd1hpt2` (`maSanPham`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietgiohang`
--

LOCK TABLES `chitietgiohang` WRITE;
/*!40000 ALTER TABLE `chitietgiohang` DISABLE KEYS */;
/*!40000 ALTER TABLE `chitietgiohang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `chitietphieunhap`
--

DROP TABLE IF EXISTS `chitietphieunhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `chitietphieunhap` (
  `maSanPham` int NOT NULL,
  `donGia` double DEFAULT NULL,
  `soLuongNhap` int DEFAULT NULL,
  `tenNoiSanXuat` varchar(255) DEFAULT NULL,
  `tenSanPham` varchar(255) DEFAULT NULL,
  `thanhTien` double DEFAULT NULL,
  `maPhieuNhap` int NOT NULL,
  PRIMARY KEY (`maPhieuNhap`,`maSanPham`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `chitietphieunhap`
--

LOCK TABLES `chitietphieunhap` WRITE;
/*!40000 ALTER TABLE `chitietphieunhap` DISABLE KEYS */;
/*!40000 ALTER TABLE `chitietphieunhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `danhgia`
--

DROP TABLE IF EXISTS `danhgia`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `danhgia` (
  `maDanhGia` int NOT NULL,
  `noiDung` varchar(10000) DEFAULT NULL,
  `sao` int DEFAULT NULL,
  `tenKhachHang` varchar(255) DEFAULT NULL,
  `maSanPham` int DEFAULT NULL,
  `thoiGian` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`maDanhGia`),
  KEY `FKqfrgxmaf1my1ist758s7e58a8` (`maSanPham`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `danhgia`
--

LOCK TABLES `danhgia` WRITE;
/*!40000 ALTER TABLE `danhgia` DISABLE KEYS */;
/*!40000 ALTER TABLE `danhgia` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donhang`
--

DROP TABLE IF EXISTS `donhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donhang` (
  `maDonHang` int NOT NULL,
  `diaChiNguoiNhan` varchar(255) DEFAULT NULL,
  `donViVanChuyen` varchar(255) DEFAULT NULL,
  `ngayDatHang` varchar(255) DEFAULT NULL,
  `phuongThucThanhToan` varchar(255) DEFAULT NULL,
  `sdtNguoiNhan` varchar(255) DEFAULT NULL,
  `tenNguoiNhan` varchar(255) DEFAULT NULL,
  `thanhTien` double DEFAULT NULL,
  `trangThai` varchar(255) DEFAULT NULL,
  `maKhachHang` int DEFAULT NULL,
  `ghiChu` varchar(255) DEFAULT NULL,
  `gioNhanHang` varchar(255) DEFAULT NULL,
  `ngayNhanHang` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`maDonHang`),
  KEY `FKhn0vg48paa8yiquwfdqb8ywlm` (`maKhachHang`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donhang`
--

LOCK TABLES `donhang` WRITE;
/*!40000 ALTER TABLE `donhang` DISABLE KEYS */;
/*!40000 ALTER TABLE `donhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `giohang`
--

DROP TABLE IF EXISTS `giohang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `giohang` (
  `maGioHang` int NOT NULL,
  `maKhachHang` int DEFAULT NULL,
  PRIMARY KEY (`maGioHang`),
  KEY `FKggru9b2xhq1diu9lrcia23iro` (`maKhachHang`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `giohang`
--

LOCK TABLES `giohang` WRITE;
/*!40000 ALTER TABLE `giohang` DISABLE KEYS */;
INSERT INTO `giohang` VALUES (26,1),(1026,2),(1041,4),(1042,5),(1043,6),(1044,7),(1045,8),(1046,9),(1047,10),(1048,11);
/*!40000 ALTER TABLE `giohang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hibernate_sequence`
--

DROP TABLE IF EXISTS `hibernate_sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hibernate_sequence`
--

LOCK TABLES `hibernate_sequence` WRITE;
/*!40000 ALTER TABLE `hibernate_sequence` DISABLE KEYS */;
INSERT INTO `hibernate_sequence` VALUES (1127),(1127),(1127),(1127),(1127),(1127),(1127),(1127);
/*!40000 ALTER TABLE `hibernate_sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `hinhanh`
--

DROP TABLE IF EXISTS `hinhanh`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `hinhanh` (
  `maHinhAnh` int NOT NULL,
  `tenHinhAnh` varchar(255) DEFAULT NULL,
  `maSanPham` int DEFAULT NULL,
  PRIMARY KEY (`maHinhAnh`),
  KEY `FK4dsrp2lkg0pbwg3mqcgc794tf` (`maSanPham`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hinhanh`
--

LOCK TABLES `hinhanh` WRITE;
/*!40000 ALTER TABLE `hinhanh` DISABLE KEYS */;
INSERT INTO `hinhanh` VALUES (1,'13052021040505_IMG_8646.jpg',1),(2,'13052021040511_Dai_dien.jpg',1),(3,'13052021040524_IMG_8647.jpg',1),(4,'13052021040532_IMG_8648.jpg',1),(5,'13052021040549_IMG_8644.jpg',1),(29,'31032021090306_IMG_4445.jpg',2),(30,'31032021090321_IMG_4444.jpg',2),(31,'31032021090331_1.jpg',2),(33,'31032021090347_IMG_4447.jpg',2),(54,'14052021030502_IMG_8613.jpg',3),(55,'14052021030527_dai_dien.jpg',3),(56,'14052021030534_IMG_8616.jpg',3),(57,'14052021030546_IMG_8622.jpg',3),(58,'14052021030556_IMG_8620.jpg',3),(79,'412202141231_IMG_1874.jpg',4),(80,'412202141244_IMG_1870.jpg',4),(91,'13052021030514_IMG_8652.jpg',5),(92,'13052021030531_IMG_8651.jpg',5),(93,'13052021030543_Dai_dien.jpg',5),(94,'13052021030558_IMG_8649.jpg',5),(110,'122202122237_IMG_3714.jpg',6),(111,'122202122255_IMG_3716.jpg',6),(112,'123202122310_IMG_3715.jpg',6),(128,'d3t3-sweater-hoa-tiet-totoshop (1).jpg',8),(129,'d3t3-sweater-hoa-tiet-totoshop (4).jpg',8),(130,'d3t3-sweater-hoa-tiet-totoshop (5).jpg',8),(131,'d3t3-sweater-hoa-tiet-totoshop (6).jpg',8),(132,'d3t3-sweater-hoa-tiet-totoshop (7).jpg',8),(153,'7 ao tay dai t3 (6).jpg',9),(154,'7 ao tay dai t3 (7).jpg',9),(155,'7 ao tay dai t3 (8).jpg',9),(156,'7 ao tay dai t3 (9).jpg',9),(157,'T3D2 SWEATER (1).jpg',9),(178,'14052021100524_IMG_8667.jpg',10),(179,'14052021100541_Dai_dien.jpg',10),(180,'14052021100559_IMG_8676.jpg',10),(191,'14052021030501_IMG_8640.jpg',11),(192,'14052021030538_dai_dien.jpg',11),(193,'14052021030555_IMG_8642.jpg',11),(204,'14052021030522_IMG_8426.jpg',12),(205,'14052021030527_IMG_8425.jpg',12),(206,'14052021030532_IMG_8427.jpg',12),(207,'14052021030551_dai_dien.jpg',12),(223,'16042021110427_1.jpg',13),(224,'16042021110437_IMG_6996.jpg',13),(225,'16042021110442_IMG_6997.jpg',13),(226,'16042021110447_IMG_6995.jpg',13),(227,'16042021110453_IMG_6998.jpg',13),(248,'1.jpg',14),(249,'29452021114532_IMG_4427.jpg',14),(250,'29452021114549_IMG_4429.jpg',14),(261,'14052021030537_IMG_8709.jpg',15),(262,'14052021030545_IMG_8715.jpg',15),(263,'14052021030547_dai_dien.jpg',15),(264,'14052021030552_IMG_8719.jpg',15),(280,'14052021020514_dai_dien.jpg',16),(281,'14052021020526_IMG_8656.jpg',16),(291,'14052021030513_IMG_8726.jpg',17),(292,'14052021030525_dai_dien.jpg',17),(302,'13052021030506_IMG_8336.jpg',18),(303,'13052021030510_IMG_8339.jpg',18),(304,'13052021030529_IMG_8333.jpg',18),(305,'13052021030546_IMG_8331.jpg',18),(306,'13052021030550_Dai_dien.jpg',18),(343,'16042021120401_1.jpg',19),(344,'16042021120405_IMG_6754.jpg',19),(345,'16042021120428_IMG_6749.jpg',19),(346,'16042021120435_IMG_6753.jpg',19),(374,'14052021030545_IMG_8353.jpg',20),(375,'14052021030557_dai_dien.jpg',20),(385,'16042021120448_1.jpg',21),(386,'16042021120454_IMG_7024.jpg',21),(406,'quan-kaki-nam-black-stripes-06(1).jpg',23),(416,'31032021090318_1.jpg',24),(417,'31032021090318_IMG_4480.jpg',24),(418,'31032021090331_IMG_4482.jpg',24),(437,'23162021111607_IMG_1739.jpg',25),(438,'23162021111611_IMG_1738.jpg',25),(439,'23162021111616_IMG_1740.jpg',25),(488,'2906202130622_1.jpg',27),(489,'2906202130641_IMG_4418.jpg',27),(490,'2906202130655_IMG_4419.jpg',27),(491,'2907202130708_IMG_4417.jpg',27),(492,'2907202130722_IMG_4420.jpg',27),(513,'2924202132400_1.jpg',28),(514,'2924202132415_IMG_4386.jpg',28),(515,'2924202132427_IMG_4383.jpg',28),(516,'2924202132440_IMG_4384.jpg',28),(517,'2924202132454_IMG_4382.jpg',28),(538,'2915202131534_1.jpg',29),(539,'2915202131549_IMG_4388.jpg',29),(540,'2916202131620_IMG_4390.jpg',29),(541,'2916202131632_IMG_4389.jpg',29),(542,'2916202131644_IMG_4391.jpg',29),(563,'23082021100832_IMG_0061.jpg',30),(564,'23082021100848_IMG_0057.jpg',30),(565,'23082021100858_IMG_0062.jpg',30),(566,'23092021100903_IMG_0058.jpg',30),(587,'23032021100354_IMG_0044.jpg',31),(588,'23032021100359_IMG_0048.jpg',31),(589,'23042021100405_IMG_0046.jpg',31),(590,'23042021100410_IMG_0047.jpg',31),(611,'IMG_2523.jpg',32),(612,'IMG_2526.jpg',32),(613,'IMG_2528.jpg',32),(614,'IMG_2529.jpg',32),(615,'IMG_2530.jpg',32),(641,'9142021111443_IMG_2788.jpg',33),(642,'9142021111452_IMG_2792.jpg',33),(643,'9152021111505_IMG_2791.jpg',33),(644,'9152021111520_IMG_2790.jpg',33),(645,'9152021111526_IMG_2793.jpg',33),(671,'9062021110602_IMG_2798.jpg',34),(672,'9062021110630_IMG_2797.jpg',34),(673,'9062021110644_IMG_2795.jpg',34),(674,'9062021110652_IMG_2796.jpg',34),(695,'IMG_8791.jpg',35),(696,'IMG_8792.jpg',35),(697,'IMG_8793.jpg',35),(713,'IMG_9129.jpg',36),(714,'IMG_9131.jpg',36),(715,'IMG_9133.jpg',36),(731,'somi-nu-cham-bi-totoshop 4 (2).jpg',37),(737,'somi-nu-cham-bi-totoshop 3 (2).jpg',38),(743,'somi-nu-cham-bi-totoshop (2).jpg',39),(749,'ao-somi-nu-in-chu-totoshop 4 (2).jpg',40),(770,'156202115638_IMG_2453.jpg',41),(771,'159202115913_IMG_2452.jpg',41),(772,'159202115929_IMG_2455.jpg',41),(788,'4412021114138_IMG_1927.jpg',42),(789,'4412021114143_IMG_1930.jpg',42),(790,'4412021114148_IMG_1931.jpg',42),(818,'IMG_2587.jpg',43),(819,'IMG_2588.jpg',43),(838,'558202155820_5L7A9862.jpg',44),(839,'558202155834_5L7A9863.jpg',44),(858,'145202124557_IMG_3761.jpg',45),(859,'146202124640_IMG_3762.jpg',45),(860,'146202124658_IMG_3760.jpg',45),(888,'15042021050416_IMG_7026.jpg',46),(889,'15042021050442_1.jpg',46),(899,'16042021110419_IMG_7033.jpg',47),(900,'16042021110452_1.jpg',47),(901,'16042021110419_IMG_7033.jpg',48),(902,'16042021110452_1.jpg',48),(912,'142202124254_IMG_3758.jpg',49),(913,'143202124326_IMG_3757.jpg',49),(932,'9402021114015_IMG_1924.jpg',50),(933,'9402021114027_IMG_1923.jpg',50),(962,'6 balo (1).jpg',54),(963,'D2T8-A2BLO080011-BALO-NAM-NU-TOTOSHOP (3).jpg',55),(964,'D2T8-A2BLO080015-BALO-NAM-NU-TOTOSHOP (5).jpg',56),(965,'1222202132254_IMG_9803.jpg',57),(966,'1222202132254_IMG_9803.jpg',58),(967,'1345202144530_IMG_9819.jpg',59),(968,'D2T8-A2TXA080003-TÚI XÁCH-NAM-NỮ-TOTOSHOP (2).jpg',60),(969,'D2T8-A2TXA080005-TÚI XÁCH-NAM-NỮ-TOTOSHOP (2).jpg',61),(970,'IMG_9254.jpg',62),(971,'IMG_9418.jpg',63),(972,'IMG_9693.jpg',64),(973,'IMG_9671.jpg',65),(974,'IMG_9649.jpg',66),(975,'IMG_9622.jpg',67),(976,'dong_ho_5__1__500x749.jpg',68),(977,'đồng hồ 3 - totoshop (2).jpg',69),(978,'đồng hồ - totoshop 24 (2).jpg',70),(979,'03042021090456_IMG_6607.jpg',71),(980,'03042021090451_IMG_6579.jpg',72),(981,'03042021090404_IMG_6549.jpg',73),(982,'26 day nit (3).jpg',74),(32,'31032021090340_IMG_4446.jpg',2),(60,'demo-22.jpg',24),(59,'demo-21.jpg',23),(53,'demo-20.jpg',21),(52,'demo-19.jpg',20),(51,'demo-18.jpg',19),(50,'demo-17.jpg',18),(49,'demo-16.jpg',17),(48,'demo-15.jpg',16),(47,'demo-14.jpg',15),(46,'demo-13.jpg',14),(45,'demo-12.jpg',13),(44,'demo-11.jpg',12),(43,'demo-10.jpg',11),(42,'demo-9.jpg',10),(41,'demo-8.jpg',9),(40,'demo-7.jpg',8),(39,'demo-6.jpg',6),(38,'demo-5.jpg',5),(37,'demo-4.jpg',4),(36,'demo-3.jpg',3),(35,'demo-2.jpg',2),(34,'demo-1.jpg',1),(61,'demo-23.jpg',25),(62,'demo-24.jpg',27),(63,'demo-25.jpg',28),(64,'demo-26.jpg',29),(65,'demo-27.jpg',30),(66,'demo-28.jpg',31),(67,'demo-29.jpg',32),(68,'demo-30.jpg',33),(69,'demo-31.jpg',34),(70,'demo-32.jpg',35),(71,'demo-33.jpg',36),(72,'demo-34.jpg',37),(73,'demo-35.jpg',38),(74,'demo-36.jpg',39),(75,'demo-37.jpg',40),(76,'demo-38.jpg',41),(77,'demo-39.jpg',42),(78,'demo-40.jpg',43),(81,'demo-41.jpg',44),(82,'demo-42.jpg',45),(83,'demo-43.jpg',46),(84,'demo-44.jpg',48),(85,'demo-45.jpg',49),(86,'demo-46.jpg',50),(87,'demo-47.jpg',55),(88,'demo-48.jpg',54),(89,'demo-49.jpg',56),(95,'demo-50.jpg',60),(96,'demo-51.jpg',58),(97,'demo-52.jpg',59),(98,'demo-53.jpg',61),(99,'demo-54.jpg',62),(100,'demo-55.jpg',63),(101,'demo-56.jpg',65),(102,'demo-57.jpg',66),(103,'demo-58.jpg',64),(104,'demo-59.jpg',67),(105,'demo-62.jpg',71),(106,'demo-61.jpg',72),(107,'demo-60.jpg',73),(108,'demo-63.jpg',74),(1087,NULL,75),(1088,'9142021111443_IMG_2788.jpg',76),(1089,'9142021111452_IMG_2792.jpg',76),(1090,'9152021111520_IMG_2790.jpg',76),(1091,'9152021111526_IMG_2793.jpg',76),(1092,'demo-30.jpg',76);
/*!40000 ALTER TABLE `hinhanh` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `khachhang`
--

DROP TABLE IF EXISTS `khachhang`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `khachhang` (
  `maKhachHang` int NOT NULL AUTO_INCREMENT,
  `diaChi` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gioiTinh` varchar(255) DEFAULT NULL,
  `matKhau` varchar(36) DEFAULT NULL,
  `ngaySinh` varchar(255) DEFAULT NULL,
  `soDienThoai` varchar(255) DEFAULT NULL,
  `tenKhachHang` varchar(255) DEFAULT NULL,
  `trangThai` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`maKhachHang`)
) ENGINE=MyISAM AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `khachhang`
--

LOCK TABLES `khachhang` WRITE;
/*!40000 ALTER TABLE `khachhang` DISABLE KEYS */;
INSERT INTO `khachhang` VALUES (1,'Chung cư 120 căn, Phường An Phú, Quận 2, TP.HCM','lvphuc99er@gmail.com','Nam','vanphuc123','1999-01-02','0396653521','Lê Văn Phúc','CHO PHÉP'),(2,'4 Nguyễn Văn Bảo, Phường 4, Quận Gò Vấp, TP.HCM','quenhetroi347@gmail.com','Nam','minhan123','2003-07-18','0915580797','Nguyễn Minh An','CHO PHÉP'),(4,'38, Phan Văn Trị, Phường 11, Quận Gò Vấp, TP.HCM','ngocdinh@gmail.com','Nam','ngocdinh123','2006-12-22','0984345794','Trương Ngọc Định','CHO PHÉP'),(5,NULL,NULL,NULL,'hoainam123',NULL,'0885702969','Phạm Hoài Nam','CHO PHÉP'),(6,NULL,NULL,NULL,'hanhi123',NULL,'0342208799','Nguyễn Lê Hà Nhi','CHO PHÉP'),(7,NULL,NULL,NULL,'duchuan123',NULL,'0369982347','Lê Đức Huấn','CHO PHÉP'),(8,NULL,NULL,NULL,'thily123',NULL,'0349919104','Lê Thị Lý','CHO PHÉP'),(9,NULL,NULL,NULL,'huongyen123',NULL,'0365019181','Trần Thị Hương Yên','CHO PHÉP'),(10,NULL,NULL,NULL,'thuyngan123',NULL,'0348885639','Trần Thủy Ngân','KHÓA'),(11,NULL,NULL,NULL,'minhanh123',NULL,'0882585829','Nguyễn Thị Minh Anh','KHÓA');
/*!40000 ALTER TABLE `khachhang` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `kichco`
--

DROP TABLE IF EXISTS `kichco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `kichco` (
  `maKichCo` int NOT NULL,
  `soLuong` int DEFAULT NULL,
  `tenKichCo` varchar(255) DEFAULT NULL,
  `maMau` int DEFAULT NULL,
  PRIMARY KEY (`maKichCo`),
  KEY `FKiic7vs91toqxbvni09610clon` (`maMau`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `kichco`
--

LOCK TABLES `kichco` WRITE;
/*!40000 ALTER TABLE `kichco` DISABLE KEYS */;
INSERT INTO `kichco` VALUES (7,3,'S',6),(8,3,'M',6),(9,2,'L',6),(10,2,'XL',6),(12,3,'S',11),(13,3,'M',11),(14,2,'L',11),(15,2,'XL',11),(17,3,'S',16),(18,3,'M',16),(19,2,'L',16),(20,2,'XL',16),(22,3,'S',21),(23,3,'M',21),(24,2,'L',21),(25,2,'XL',21),(35,3,'S',34),(36,3,'M',34),(37,2,'L',34),(38,2,'XL',34),(40,3,'S',39),(41,3,'M',39),(42,2,'L',39),(43,2,'XL',39),(45,3,'S',44),(46,3,'M',44),(47,2,'L',44),(48,2,'XL',44),(50,3,'S',49),(51,3,'M',49),(52,2,'L',49),(53,2,'XL',49),(60,3,'S',59),(61,3,'M',59),(62,2,'L',59),(63,2,'XL',59),(65,3,'S',64),(66,3,'M',64),(67,2,'L',64),(68,2,'XL',64),(70,3,'S',69),(71,3,'M',69),(72,2,'L',69),(73,2,'XL',69),(75,3,'S',74),(76,3,'M',74),(77,2,'L',74),(78,2,'XL',74),(82,5,'S',81),(83,5,'M',81),(84,5,'L',81),(85,5,'XL',81),(87,5,'S',86),(88,5,'M',86),(89,5,'L',86),(90,5,'XL',86),(96,5,'S',95),(97,5,'M',95),(98,5,'L',95),(99,5,'XL',95),(101,3,'S',100),(102,3,'M',100),(103,2,'L',100),(104,2,'XL',100),(106,3,'S',105),(107,3,'M',105),(108,2,'L',105),(109,2,'XL',105),(114,5,'S',113),(115,5,'M',113),(116,5,'L',113),(117,5,'XL',113),(119,3,'S',118),(120,3,'M',118),(121,2,'L',118),(122,2,'XL',118),(124,3,'S',123),(125,3,'M',123),(126,2,'L',123),(127,2,'XL',123),(134,3,'S',133),(135,3,'M',133),(136,2,'L',133),(137,2,'XL',133),(139,3,'S',138),(140,3,'M',138),(141,2,'L',138),(142,2,'XL',138),(144,3,'S',143),(145,3,'M',143),(146,2,'L',143),(147,2,'XL',143),(149,3,'S',148),(150,3,'M',148),(151,2,'L',148),(152,2,'XL',148),(159,3,'S',158),(160,3,'M',158),(161,2,'L',158),(162,2,'XL',158),(164,3,'S',163),(165,3,'M',163),(166,2,'L',163),(167,2,'XL',163),(169,3,'S',168),(170,3,'M',168),(171,2,'L',168),(172,2,'XL',168),(174,3,'S',173),(175,3,'M',173),(176,2,'L',173),(177,2,'XL',173),(182,3,'S',181),(183,3,'M',181),(184,2,'L',181),(185,2,'XL',181),(187,5,'S',186),(188,5,'M',186),(189,5,'L',186),(190,5,'XL',186),(195,5,'S',194),(196,5,'M',194),(197,5,'L',194),(198,5,'XL',194),(200,5,'S',199),(201,5,'M',199),(202,5,'L',199),(203,5,'XL',199),(209,5,'S',208),(210,5,'M',208),(211,5,'L',208),(212,5,'XL',208),(214,3,'S',213),(215,3,'M',213),(216,2,'L',213),(217,2,'XL',213),(219,3,'S',218),(220,3,'M',218),(221,2,'L',218),(222,2,'XL',218),(229,3,'S',228),(230,3,'M',228),(231,2,'L',228),(232,2,'XL',228),(234,3,'S',233),(235,3,'M',233),(236,2,'L',233),(237,2,'XL',233),(239,3,'S',238),(240,3,'M',238),(241,2,'L',238),(242,2,'XL',238),(244,3,'S',243),(245,3,'M',243),(246,2,'L',243),(247,2,'XL',243),(252,5,'S',251),(253,5,'M',251),(254,5,'L',251),(255,5,'XL',251),(257,5,'S',256),(258,5,'M',256),(259,5,'L',256),(260,5,'XL',256),(266,5,'S',265),(267,5,'M',265),(268,5,'L',265),(269,5,'XL',265),(271,3,'S',270),(272,3,'M',270),(273,2,'L',270),(274,2,'XL',270),(276,3,'S',275),(277,3,'M',275),(278,2,'L',275),(279,2,'XL',275),(283,5,'26',282),(284,5,'27',282),(285,5,'28',282),(286,5,'29',282),(287,5,'30',282),(288,5,'31',282),(289,5,'32',282),(290,5,'33',282),(294,5,'26',293),(295,5,'27',293),(296,5,'28',293),(297,5,'29',293),(298,5,'30',293),(299,5,'31',293),(300,5,'32',293),(301,5,'33',293),(308,2,'26',307),(309,2,'27',307),(310,1,'28',307),(311,1,'29',307),(312,1,'30',307),(313,1,'31',307),(314,1,'32',307),(315,1,'33',307),(317,2,'26',316),(318,2,'27',316),(319,1,'28',316),(320,1,'29',316),(321,1,'30',316),(322,1,'31',316),(323,1,'32',316),(324,1,'33',316),(326,2,'26',325),(327,2,'27',325),(328,1,'28',325),(329,1,'29',325),(330,1,'30',325),(331,1,'31',325),(332,1,'32',325),(333,1,'33',325),(335,2,'26',334),(336,2,'27',334),(337,1,'28',334),(338,1,'29',334),(339,1,'30',334),(340,1,'31',334),(341,1,'32',334),(342,1,'33',334),(348,4,'26',347),(349,4,'27',347),(350,2,'28',347),(351,2,'29',347),(352,2,'30',347),(353,2,'31',347),(354,2,'32',347),(355,2,'33',347),(357,2,'26',356),(358,2,'27',356),(359,1,'28',356),(360,1,'29',356),(361,1,'30',356),(362,1,'31',356),(363,1,'32',356),(364,1,'33',356),(366,2,'26',365),(367,2,'27',365),(368,1,'28',365),(369,1,'29',365),(370,1,'30',365),(371,1,'31',365),(372,1,'32',365),(373,1,'33',365),(377,5,'26',376),(378,5,'27',376),(379,5,'28',376),(380,5,'29',376),(381,5,'30',376),(382,5,'31',376),(383,5,'32',376),(384,5,'33',376),(388,5,'26',387),(389,5,'27',387),(390,5,'28',387),(391,5,'29',387),(392,5,'30',387),(393,5,'31',387),(394,5,'32',387),(395,5,'33',387),(398,5,'26',397),(399,5,'27',397),(400,5,'28',397),(401,5,'29',397),(402,5,'30',397),(403,5,'31',397),(404,5,'32',397),(405,5,'33',397),(408,5,'26',407),(409,5,'27',407),(410,5,'28',407),(411,5,'29',407),(412,5,'30',407),(413,5,'31',407),(414,5,'32',407),(415,5,'33',407),(420,4,'26',419),(421,4,'27',419),(422,2,'28',419),(423,2,'29',419),(424,2,'30',419),(425,2,'31',419),(426,2,'32',419),(427,2,'33',419),(429,4,'26',428),(430,4,'27',428),(431,2,'28',428),(432,2,'29',428),(433,2,'30',428),(434,2,'31',428),(435,2,'32',428),(436,2,'33',428),(441,4,'26',440),(442,4,'27',440),(443,2,'28',440),(444,2,'29',440),(445,2,'30',440),(446,2,'31',440),(447,2,'32',440),(448,2,'33',440),(450,2,'26',449),(451,2,'27',449),(452,1,'28',449),(453,1,'29',449),(454,1,'30',449),(455,1,'31',449),(456,1,'32',449),(457,1,'33',449),(459,2,'26',458),(460,2,'27',458),(461,1,'28',458),(462,1,'29',458),(463,1,'30',458),(464,1,'31',458),(465,1,'32',458),(466,1,'33',458),(512,4,'XL',508),(511,2,'L',508),(510,2,'M',508),(509,2,'S',508),(507,4,'XL',503),(506,2,'L',503),(505,2,'M',503),(504,2,'S',503),(502,4,'XL',498),(501,2,'L',498),(500,2,'M',498),(499,2,'S',498),(497,4,'XL',493),(496,2,'L',493),(495,2,'M',493),(494,2,'S',493),(519,4,'S',518),(520,2,'M',518),(521,2,'L',518),(522,2,'XL',518),(524,4,'S',523),(525,2,'M',523),(526,2,'L',523),(527,2,'XL',523),(529,4,'S',528),(530,2,'M',528),(531,2,'L',528),(532,2,'XL',528),(534,4,'S',533),(535,2,'M',533),(536,2,'L',533),(537,2,'XL',533),(544,4,'S',543),(545,2,'M',543),(546,2,'L',543),(547,2,'XL',543),(549,4,'S',548),(550,2,'M',548),(551,2,'L',548),(552,2,'XL',548),(554,4,'S',553),(555,2,'M',553),(556,2,'L',553),(557,2,'XL',553),(559,4,'S',558),(560,2,'M',558),(561,2,'L',558),(562,2,'XL',558),(568,4,'S',567),(569,2,'M',567),(570,2,'L',567),(571,2,'XL',567),(573,4,'S',572),(574,2,'M',572),(575,2,'L',572),(576,2,'XL',572),(578,4,'S',577),(579,2,'M',577),(580,2,'L',577),(581,2,'XL',577),(583,4,'S',582),(584,2,'M',582),(585,2,'L',582),(586,2,'XL',582),(592,4,'S',591),(593,2,'M',591),(594,2,'L',591),(595,2,'XL',591),(597,4,'S',596),(598,2,'M',596),(599,2,'L',596),(600,2,'XL',596),(602,4,'S',601),(603,2,'M',601),(604,2,'L',601),(605,2,'XL',601),(607,4,'S',606),(608,2,'M',606),(609,2,'L',606),(610,2,'XL',606),(617,2,'S',616),(618,2,'M',616),(619,2,'L',616),(620,2,'XL',616),(622,2,'S',621),(623,2,'M',621),(624,2,'L',621),(625,2,'XL',621),(627,2,'S',626),(628,2,'M',626),(629,2,'L',626),(630,2,'XL',626),(632,2,'S',631),(633,2,'M',631),(634,2,'L',631),(635,2,'XL',631),(637,2,'S',636),(638,2,'M',636),(639,2,'L',636),(640,2,'XL',636),(647,2,'S',646),(648,2,'M',646),(649,2,'L',646),(650,2,'XL',646),(652,2,'S',651),(653,2,'M',651),(654,2,'L',651),(655,2,'XL',651),(657,2,'S',656),(658,2,'M',656),(659,2,'L',656),(660,2,'XL',656),(662,2,'S',661),(663,2,'M',661),(664,2,'L',661),(665,2,'XL',661),(667,2,'S',666),(668,2,'M',666),(669,2,'L',666),(670,2,'XL',666),(676,4,'S',675),(677,2,'M',675),(678,2,'L',675),(679,2,'XL',675),(681,4,'S',680),(682,2,'M',680),(683,2,'L',680),(684,2,'XL',680),(686,4,'S',685),(687,2,'M',685),(688,2,'L',685),(689,2,'XL',685),(691,4,'S',690),(692,2,'M',690),(693,2,'L',690),(694,2,'XL',690),(699,5,'S',698),(700,5,'M',698),(701,5,'L',698),(702,5,'XL',698),(704,4,'S',703),(705,2,'M',703),(706,2,'L',703),(707,2,'XL',703),(709,4,'S',708),(710,2,'M',708),(711,2,'L',708),(712,2,'XL',708),(717,5,'S',716),(718,5,'M',716),(719,5,'L',716),(720,5,'XL',716),(722,4,'S',721),(723,2,'M',721),(724,2,'L',721),(725,2,'XL',721),(727,4,'S',726),(728,2,'M',726),(729,2,'L',726),(730,2,'XL',726),(733,10,'S',732),(734,10,'M',732),(735,10,'L',732),(736,10,'XL',732),(739,10,'S',738),(740,10,'M',738),(741,10,'L',738),(742,10,'XL',738),(745,10,'S',744),(746,10,'M',744),(747,10,'L',744),(748,10,'XL',744),(751,4,'S',750),(752,2,'M',750),(753,2,'L',750),(754,2,'XL',750),(756,4,'S',755),(757,2,'M',755),(758,2,'L',755),(759,2,'XL',755),(761,4,'S',760),(762,2,'M',760),(763,2,'L',760),(764,2,'XL',760),(766,4,'S',765),(767,2,'M',765),(768,2,'L',765),(769,2,'XL',765),(774,5,'S',773),(775,5,'M',773),(776,5,'L',773),(777,5,'XL',773),(779,4,'S',778),(780,2,'M',778),(781,2,'L',778),(782,2,'XL',778),(784,4,'S',783),(785,2,'M',783),(786,2,'L',783),(787,2,'XL',783),(792,4,'26',791),(793,4,'27',791),(794,2,'28',791),(795,2,'29',791),(796,2,'30',791),(797,2,'31',791),(798,2,'32',791),(799,2,'33',791),(801,2,'26',800),(802,2,'27',800),(803,1,'28',800),(804,1,'29',800),(805,1,'30',800),(806,1,'31',800),(807,1,'32',800),(808,1,'33',800),(810,2,'26',809),(811,2,'27',809),(812,1,'28',809),(813,1,'29',809),(814,1,'30',809),(815,1,'31',809),(816,1,'32',809),(817,1,'33',809),(821,4,'26',820),(822,4,'27',820),(823,2,'28',820),(824,2,'29',820),(825,2,'30',820),(826,2,'31',820),(827,2,'32',820),(828,2,'33',820),(830,4,'26',829),(831,4,'27',829),(832,2,'28',829),(833,2,'29',829),(834,2,'30',829),(835,2,'31',829),(836,2,'32',829),(837,2,'33',829),(841,4,'26',840),(842,4,'27',840),(843,2,'28',840),(844,2,'29',840),(845,2,'30',840),(846,2,'31',840),(847,2,'32',840),(848,2,'33',840),(850,4,'26',849),(851,4,'27',849),(852,2,'28',849),(853,2,'29',849),(854,2,'30',849),(855,2,'31',849),(856,2,'32',849),(857,2,'33',849),(862,4,'26',861),(863,4,'27',861),(864,2,'28',861),(865,2,'29',861),(866,2,'30',861),(867,2,'31',861),(868,2,'32',861),(869,2,'33',861),(871,2,'26',870),(872,2,'27',870),(873,1,'28',870),(874,1,'29',870),(875,1,'30',870),(876,1,'31',870),(877,1,'32',870),(878,1,'33',870),(880,2,'26',879),(881,2,'27',879),(882,1,'28',879),(883,1,'29',879),(884,1,'30',879),(885,1,'31',879),(886,1,'32',879),(887,1,'33',879),(891,5,'26',890),(892,5,'27',890),(893,5,'28',890),(894,5,'29',890),(895,5,'30',890),(896,5,'31',890),(897,5,'32',890),(898,5,'33',890),(904,5,'26',903),(905,5,'27',903),(906,5,'28',903),(907,5,'29',903),(908,5,'30',903),(909,5,'31',903),(910,5,'32',903),(911,5,'33',903),(915,4,'26',914),(916,4,'27',914),(917,2,'28',914),(918,2,'29',914),(919,2,'30',914),(920,2,'31',914),(921,2,'32',914),(922,2,'33',914),(924,4,'26',923),(925,4,'27',923),(926,2,'28',923),(927,2,'29',923),(928,2,'30',923),(929,2,'31',923),(930,2,'32',923),(931,2,'33',923),(935,4,'26',934),(936,4,'27',934),(937,2,'28',934),(938,2,'29',934),(939,2,'30',934),(940,2,'31',934),(941,2,'32',934),(942,2,'33',934),(944,4,'26',943),(945,4,'27',943),(946,2,'28',943),(947,2,'29',943),(948,2,'30',943),(949,2,'31',943),(950,2,'32',943),(951,2,'33',943),(1094,0,'S',1093),(1095,0,'M',1093),(1096,0,'L',1093),(1097,0,'XL',1093),(1099,0,'S',1098),(1100,0,'M',1098),(1101,0,'L',1098),(1102,0,'XL',1098),(1104,0,'S',1103),(1105,0,'M',1103),(1106,0,'L',1103),(1107,0,'XL',1103),(1109,0,'S',1108),(1110,0,'M',1108),(1111,0,'L',1108),(1112,0,'XL',1108);
/*!40000 ALTER TABLE `kichco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mausac`
--

DROP TABLE IF EXISTS `mausac`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mausac` (
  `maMau` int NOT NULL,
  `soLuong` int DEFAULT NULL,
  `tenMau` varchar(255) DEFAULT NULL,
  `maSanPham` int DEFAULT NULL,
  PRIMARY KEY (`maMau`),
  KEY `FKr7385nq3m11r6nx8igyvi7x82` (`maSanPham`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mausac`
--

LOCK TABLES `mausac` WRITE;
/*!40000 ALTER TABLE `mausac` DISABLE KEYS */;
INSERT INTO `mausac` VALUES (6,10,'Vàng',1),(11,10,'Xanh dương',1),(16,10,'Đen',1),(21,10,'Tím',1),(34,10,'Xanh dương',2),(39,10,'Trắng',2),(44,10,'Đen',2),(49,10,'Xám',2),(59,10,'Xanh dương',3),(64,10,'Trắng',3),(69,10,'Đen',3),(74,10,'Xám',3),(81,20,'Vàng',4),(86,20,'Đen',4),(95,20,'Trắng',5),(100,10,'Đen',5),(105,10,'Nâu',5),(113,20,'Vàng',6),(118,10,'Trắng',6),(123,10,'Đen',6),(133,10,'Đỏ',8),(138,10,'Xanh dương',8),(143,10,'Đen',8),(148,10,'Nâu',8),(158,10,'Đỏ',9),(163,10,'Vàng',9),(168,10,'Đen',9),(173,10,'Nâu',9),(181,20,'Trắng',10),(186,20,'Đen',10),(194,20,'Trắng',11),(199,20,'Đen',11),(208,20,'Đen',12),(213,10,'Xám',12),(218,10,'Nâu',12),(228,10,'Xanh dương',13),(233,10,'Hồng',13),(238,10,'Xám',13),(243,10,'Nâu',13),(251,20,'Xanh dương',14),(256,20,'Cam',14),(265,20,'Trắng',15),(270,10,'Đen',15),(275,10,'Xám',15),(282,40,'Xanh dương',16),(293,40,'Xám',17),(307,10,'Vàng',18),(316,10,'Xanh lá',18),(325,10,'Trắng',18),(334,10,'Đen',18),(347,20,'Trắng',19),(356,10,'Đen',19),(365,10,'Nâu',19),(376,40,'Xanh dương',20),(387,40,'Xám',21),(397,40,'Xám',22),(407,40,'Đen',23),(419,20,'Đen',24),(428,20,'Xám',24),(440,20,'Đen',25),(449,10,'Xám',25),(458,10,'Nâu',25),(503,10,'Đen',27),(498,10,'Trắng',27),(493,10,'Vàng',27),(508,10,'Xám',27),(518,10,'Vàng',28),(523,10,'Xanh dương',28),(528,10,'Trắng',28),(533,10,'Tím',28),(543,10,'Đỏ',29),(548,10,'Vàng',29),(553,10,'Xanh dương',29),(558,10,'Xám',29),(567,10,'Đỏ',30),(572,10,'Vàng',30),(577,10,'Đen',30),(582,10,'Xám',30),(591,10,'Đỏ',31),(596,10,'Vàng',31),(601,10,'Trắng',31),(606,10,'Đen',31),(616,8,'Vàng',32),(621,8,'Xanh dương',32),(626,8,'Hồng',32),(631,8,'Trắng',32),(636,8,'Đen',32),(646,8,'Vàng',33),(651,8,'Xanh dương',33),(656,8,'Hồng',33),(661,8,'Trắng',33),(666,8,'Xám',33),(675,10,'Vàng',34),(680,10,'Xanh dương',34),(685,10,'Hồng',34),(690,10,'Đen',34),(698,20,'Đỏ',35),(703,10,'Hồng',35),(708,10,'Đen',35),(716,20,'Vàng',36),(721,10,'Xanh dương',36),(726,10,'Đen',36),(732,40,'Xanh dương',37),(738,40,'Trắng',38),(744,40,'Xanh dương',39),(750,10,'Vàng',40),(755,10,'Trắng',40),(760,10,'Cam',40),(765,10,'Xám',40),(773,20,'Vàng',41),(778,10,'Hồng',41),(783,10,'Xám',41),(791,20,'Xanh dương',42),(800,10,'Trắng',42),(809,10,'Đen',42),(820,20,'Xanh dương',43),(829,20,'Đen',43),(840,20,'Vàng',44),(849,20,'Đen',44),(861,20,'Vàng',45),(870,10,'Đen',45),(879,10,'Nâu',45),(890,40,'Đen',46),(903,40,'Xanh dương',48),(914,20,'Vàng',49),(923,20,'Hồng',49),(934,20,'Xanh dương',50),(943,20,'Trắng',50),(1093,0,'Vàng',76),(1098,0,'Hồng',76),(1103,0,'Trắng',76),(1108,0,'Xám',76);
/*!40000 ALTER TABLE `mausac` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhacungcap`
--

DROP TABLE IF EXISTS `nhacungcap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhacungcap` (
  `maNhaCungCap` int NOT NULL,
  `diaChi` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `soDienThoai` varchar(255) DEFAULT NULL,
  `tenNhaCungCap` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`maNhaCungCap`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhacungcap`
--

LOCK TABLES `nhacungcap` WRITE;
/*!40000 ALTER TABLE `nhacungcap` DISABLE KEYS */;
INSERT INTO `nhacungcap` VALUES (109,'28 Dương Chí Tiễn, Phường 17, Quận 4, HCM','bonghoanho@gmail.com','0326588524','Công ty MTV Bông Hoa Nhỏ'),(110,'28 Dương Chí Tiễn, Phường 16, Quận 3, HCM','giatinh@gmail.com','0346986532','Xưởng may mặc Gia Tịnh'),(112,'28 Dương Chí Tiễn, Phường 2, Quận 8, HCM','hoangthien@gmail.com','0775632141','Công ty phân phối Hoàng Thiên'),(113,'28 Dương Chí Tiễn, Phường 1, Quận 6, HCM','anhhoang@gmail.com','0902521421','Công ty TNHH MTV Ánh Hoàng'),(114,'28 Dương Chí Tiễn, Phường 13, Quận Thủ Đức, HCM','namsaigon@gmail.com','0852367998','Công ty may mặc Nam Sài Gòn'),(115,'28 Dương Chí Tiễn, Phường 6, Quận 12, HCM','chitien@gmail.com','0978652325','Công ty TNHH Chí Tiến'),(116,'28 Dương Chí Tiễn, Phường 5, Quận 12, HCM','ngoclan@gmail.com','0813652542','Công ty cổ phần may mặc Ngọc Lan');
/*!40000 ALTER TABLE `nhacungcap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `nhanvien` (
  `maNhanVien` int NOT NULL AUTO_INCREMENT,
  `diaChi` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `gioiTinh` varchar(255) DEFAULT NULL,
  `matKhau` varchar(36) DEFAULT NULL,
  `ngaySinh` varchar(255) DEFAULT NULL,
  `soDienThoai` varchar(255) DEFAULT NULL,
  `tenNhanVien` varchar(255) DEFAULT NULL,
  `viTri` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`maNhanVien`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nhanvien`
--

LOCK TABLES `nhanvien` WRITE;
/*!40000 ALTER TABLE `nhanvien` DISABLE KEYS */;
INSERT INTO `nhanvien` VALUES (1,'Quận Bình Thạnh','trongdai@gmail.com','Nam','trongdai123','1995-07-11','0396653521','Nguyễn Trọng Đại','Nhân viên quản lý kho'),(2,'Quận Gò Vấp','thiminh@gmail.com','Nữ','thiminh123','2021-05-06','0915580797','Nguyễn Thị Minh','Nhân viên bán hàng'),(3,'Quận Bình Thạnh','vutu@gmail.com','Nam','vutu123','2001-08-15','0394809743','Vũ Tú','Nhân viên quản lý kho'),(4,'Quận Gò Vấp','baoanh@gmail.com','Nữ','baoanh123','2006-12-20','0382944181','Trần Ngọc Bảo Ánh','Nhân viên quản lý kho'),(5,'Quận Bình Thạnh','ngochao@gmail.com','Nữ','ngochao123','2006-06-14','0365741170','Võ Ngọc Hảo','Nhân viên bán hàng'),(6,'Quận 2','hoanganh@gmail.com','Nữ','hoanganh123','1999-05-02','0889768947','Đặng Hoàng Anh','Nhân viên bán hàng');
/*!40000 ALTER TABLE `nhanvien` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `phieunhap`
--

DROP TABLE IF EXISTS `phieunhap`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `phieunhap` (
  `maPhieuNhap` int NOT NULL,
  `ngayLapPhieu` varchar(255) DEFAULT NULL,
  `tenNhanVien` varchar(255) DEFAULT NULL,
  `thanhTien` double DEFAULT NULL,
  `maNhaCungCap` int DEFAULT NULL,
  PRIMARY KEY (`maPhieuNhap`),
  KEY `FKcc6m7fq0ma13edkql4hdjf293` (`maNhaCungCap`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `phieunhap`
--

LOCK TABLES `phieunhap` WRITE;
/*!40000 ALTER TABLE `phieunhap` DISABLE KEYS */;
INSERT INTO `phieunhap` VALUES (1113,'2021-06-03','Nguyễn Trọng Đại',1875000,109);
/*!40000 ALTER TABLE `phieunhap` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sanpham`
--

DROP TABLE IF EXISTS `sanpham`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `sanpham` (
  `maSanPham` int NOT NULL AUTO_INCREMENT,
  `donGia` double DEFAULT NULL,
  `loai` varchar(255) DEFAULT NULL,
  `moTaSanPham` varchar(10000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `soLuongCoSan` int DEFAULT NULL,
  `tenLoaiSanPham` varchar(255) DEFAULT NULL,
  `tenNoiSanXuat` varchar(255) DEFAULT NULL,
  `tenSanPham` varchar(255) DEFAULT NULL,
  `trangThai` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`maSanPham`)
) ENGINE=MyISAM AUTO_INCREMENT=77 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sanpham`
--

LOCK TABLES `sanpham` WRITE;
/*!40000 ALTER TABLE `sanpham` DISABLE KEYS */;
INSERT INTO `sanpham` VALUES (1,190000,'1','- Áo thun phối 2 màu cơ bản                                      • Hàng chính hãng 100%\n- Chất liệu vải thun 100% co giãn 4 chiều                   • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Sản phẩm tạo cảm giác đơn giản, thoáng mát         \n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Ưu tiên sử dụng các hình thức giặt khô, giặt hấp hoặc giặt tay để giữ tuổi thọ của quần áo\n► Sử dụng túi giặt riêng & không giặt chung với các chất liệu khác',40,'THUN NAM TAY NGẮN TRƠN','Việt Nam','Áo thun nam 2 màu LLTNNT001','ĐANG BÁN'),(2,185000,'1','- Áo thun in hình BANG BANG BANG                         • Hàng chính hãng 100%\n- Chất liệu vải cotton 100% co giãn 4 chiều               • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Bề mặt vải láng mịn không bị xù lông, an toàn cho da\n- Đặc biệt có khả năng hút ẩm cao, thấm hút tốt, độ bền cao    \n- Form áo đa dạng phù hợp với nhiều vóc dáng người mặc\n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Ưu tiên sử dụng các hình thức giặt khô, giặt hấp hoặc giặt tay để giữ tuổi thọ của quần áo\n► Sử dụng túi giặt riêng & không giặt chung với các chất liệu khác',38,'THUN NAM TAY NGẮN IN HÌNH','Việt Nam','Áo thun nam BANG LLTNNI001','ĐANG BÁN'),(3,195000,'1','- Áo thun tay ngắn ngang vai một màu                      • Hàng chính hãng 100%\n- Chất liệu vải thun lạnh  thể thao co giãn 4 chiều     • Được đổi trả hàng theo chính sách của cửa hàng \n- Kiểu áo slimfit tôn dáng cơ thể                                                \n- Thiết kế đơn giản, nam tính\n- Đường may chắc chắn. Không chảy xệ sau khi giặt         \n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Ưu tiên sử dụng các hình thức giặt khô, giặt hấp hoặc giặt tay để giữ tuổi thọ của quần áo',40,'THUN NAM TAY NGẮN TRƠN','Việt Nam','Áo thun nam SWE LLTNNT002','ĐANG BÁN'),(4,245000,'1','- Áo thun cổ trụ một màu đơn giản                             • Hàng chính hãng 100%\n- Chất liệu vải mềm CVC                                               • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Sản phẩm tạo cảm giác đơn giản, thoáng mát   \n- Tính hút ẩm cao, kháng khuẩn tự nhiên, hạn chế sự phát triển của vi khuẩn trên quần áo\n-Chống tia UV gây hại cho da \n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Ưu tiên sử dụng các hình thức giặt khô, giặt hấp hoặc giặt tay để giữ tuổi thọ của quần áo',40,'THUN NAM TAY NGẮN CÓ CỔ','Việt Nam','Áo thun nam POLO LLTNNC001','ĐANG BÁN'),(5,285000,'1','- Áo thun cổ tròn in hình BEST                                   • Hàng chính hãng 100%\n- Chất liệu vải cotton 100% co giãn 4 chiều               • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Vải mịn tạo cảm giác đơn giản, thoáng mát         \n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Ưu tiên sử dụng các hình thức giặt khô, giặt hấp hoặc giặt tay để giữ tuổi thọ của quần áo',40,'THUN NAM TAY NGẮN IN HÌNH','Việt Nam','Áo thun nam BÉsT LLTNNI002','ĐANG BÁN'),(6,285000,'1','- Áo thun in chữ kiểu nhiều màu                                 • Hàng chính hãng 100%\n- Chất liệu vải cotton 100% co giãn 4 chiều                • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                      \n- Form regular vừa vặn, thoải mái                           \n- Sản phẩm tạo cảm giác đơn giản, thoáng mát         \n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Ưu tiên sử dụng các hình thức giặt khô, giặt hấp hoặc giặt tay để giữ tuổi thọ của quần áo',40,'THUN NAM TAY NGẮN IN HÌNH','Việt Nam','Áo thun nam PLASTIC LLTNNI003','ĐANG BÁN'),(8,325000,'1','- Áo thun tay dài in hình BON                                      • Hàng chính hãng 100%\n- Chất liệu vải thun lạnh co dãn 4 chiều                       • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Phong cách: Đơn giản, trẻ trung, nam tính   \n- Đường may tinh tế, tỉ mỉ trong từng chi tiết\n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Ưu tiên sử dụng các hình thức giặt khô, giặt hấp hoặc giặt tay để giữ tuổi thọ của quần áo',40,'THUN NAM TAY DÀI IN HÌNH','Việt Nam','Áo thun nam BON LLTD001','ĐANG BÁN'),(9,315000,'1','- Áo thun tay dài in hình PINK FLOP                             • Hàng chính hãng 100%\n- Chất liệu vải thun lạnh co dãn 4 chiều                       • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Phong cách: Đơn giản, trẻ trung, nam tính   \n- Đường may tinh tế, tỉ mỉ trong từng chi tiết\n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Ưu tiên sử dụng các hình thức giặt khô, giặt hấp hoặc giặt tay để giữ tuổi thọ của quần áo',40,'THUN NAM TAY DÀI IN HÌNH','Việt Nam','Áo thun nam PINK FLOP LLTD002','ĐANG BÁN'),(10,285000,'1','- Kiểu dáng SLIM FIT - Tà Lượn                                   • Hàng chính hãng 100%\n- Áo sơ mi tay ngắn in hình xương rồng                     • Được đổi trả hàng theo chính sách của cửa hàng               \n- Xuất xứ tại Việt Nam     \n- Chất liệu Modal từ sợi sồi thiên nhiên cho mặt vải mềm mại, nhẹ và thoáng mát\n- Kết hợp Polyspun và Tencel giúp áo đứng dáng tự nhiên, hạn chế nhăn co, dễ chăm sóc và bền màu sau thời gian dài sử dụng                                            \n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Ưu tiên sử dụng các hình thức giặt khô, giặt hấp hoặc giặt tay để giữ tuổi thọ của quần áo',40,'SƠ MI NAM TAY NGẮN','Việt Nam','Áo sơ mi nam XR LLSMN001','ĐANG BÁN'),(11,285000,'1','- Kiểu dáng SLIM FIT - Tà Lượn                                   • Hàng chính hãng 100%\n- Áo sơ mi tay ngắn in hình hoạt hình                        • Được đổi trả hàng theo chính sách của cửa hàng               \n- Xuất xứ tại Việt Nam     \n- Chất liệu Modal từ sợi sồi thiên nhiên cho mặt vải mềm mại, nhẹ và thoáng mát\n- Kết hợp Polyspun và Tencel giúp áo đứng dáng tự nhiên, hạn chế nhăn co, dễ chăm sóc và bền màu sau thời gian dài sử dụng                                            \n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Ưu tiên sử dụng các hình thức giặt khô, giặt hấp hoặc giặt tay để giữ tuổi thọ của quần áo',40,'SƠ MI NAM TAY NGẮN','Việt Nam','Áo sơ mi nam IC LLSMN002','ĐANG BÁN'),(12,285000,'1','- Kiểu dáng SLIM FIT - Tà Lượn                                   • Hàng chính hãng 100%\n- Áo sơ mi tay ngắn một màu đơn giản                      • Được đổi trả hàng theo chính sách của cửa hàng               \n- Xuất xứ tại Việt Nam     \n- Chất liệu Modal từ sợi sồi thiên nhiên cho mặt vải mềm mại, nhẹ và thoáng mát\n- Kết hợp Polyspun và Tencel giúp áo đứng dáng tự nhiên, hạn chế nhăn co, dễ chăm sóc và bền màu sau thời gian dài sử dụng                                            \n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Ưu tiên sử dụng các hình thức giặt khô, giặt hấp hoặc giặt tay để giữ tuổi thọ của quần áo',40,'SƠ MI NAM TAY NGẮN','Việt Nam','Áo sơ mi nam TRƠN LLSMN003','ĐANG BÁN'),(13,305000,'1','- Áo sơ mi dài tay phom dáng Regular fit suông        • Hàng chính hãng 100%             \n- Xuất xứ tại Việt Nam                                                 • Được đổi trả hàng theo chính sách của cửa hàng \n- Có tính kháng khuẩn nhẹ.\n- Kết hợp Polyspun và Tencel giúp áo đứng dáng tự nhiên, hạn chế nhăn co, dễ chăm sóc và bền màu sau thời gian dài sử dụng                                            \n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Ưu tiên sử dụng các hình thức giặt khô, giặt hấp hoặc giặt tay để giữ tuổi thọ của quần áo',40,'SƠ MI NAM TAY DÀI','Việt Nam','Áo sơ mi nam PLEASE SURE LLSMD001','ĐANG BÁN'),(14,305000,'1','- Áo sơ mi dài tay phom dáng Regular fit suông        • Hàng chính hãng 100%             \n- Xuất xứ tại Việt Nam                                                 • Được đổi trả hàng theo chính sách của cửa hàng \n- Có tính kháng khuẩn nhẹ.\n- Kết hợp Polyspun và Tencel giúp áo đứng dáng tự nhiên, hạn chế nhăn co, dễ chăm sóc và bền màu sau thời gian dài sử dụng                                            \n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Ưu tiên sử dụng các hình thức giặt khô, giặt hấp hoặc giặt tay để giữ tuổi thọ của quần áo',40,'SƠ MI NAM TAY DÀI','Việt Nam','Áo sơ mi nam CARO LLSMD002','ĐANG BÁN'),(15,305000,'1','- Áo sơ mi dài tay phom dáng Regular fit suông        • Hàng chính hãng 100%             \n- Xuất xứ tại Việt Nam                                                 • Được đổi trả hàng theo chính sách của cửa hàng \n- Có tính kháng khuẩn nhẹ.\n- Một màu đơn giản, thể hiện sự trang trọng\n- Kết hợp Polyspun và Tencel giúp áo đứng dáng tự nhiên, hạn chế nhăn co, dễ chăm sóc và bền màu sau thời gian dài sử dụng                                            \n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Ưu tiên sử dụng các hình thức giặt khô, giặt hấp hoặc giặt tay để giữ tuổi thọ của quần áo',40,'SƠ MI NAM TAY DÀI','Việt Nam','Áo sơ mi nam TRƠN LLSMD003','ĐANG BÁN'),(16,265000,'2','- Quần short jean nam chất liệu vải jean dày              • Hàng chính hãng 100%             \n- Xuất xứ tại Việt Nam                                                 • Được đổi trả hàng theo chính sách của cửa hàng \n- Kiểu dáng thời trang, sành điệu\n- Form quần mới trẻ trung hơn, bạn sẽ thoải mái thoạt động mạnh mà không sợ nhàu nát vải vì cấu trúc sợi chéo chống nhàu, đảm bảo độ bền trong nhiều năm sử dụng               \n- Có thể kết hợp cùng nhiều trang phục khác nhau để mang tới cho mình một phong cách cá tính riêng                          \n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Ưu tiên sử dụng các hình thức giặt khô, giặt hấp hoặc giặt tay để giữ tuổi thọ của quần áo',40,'QUẦN SHORT NAM JEAN','Việt Nam','Quần short nam JEAN LLQSJ001','ĐANG BÁN'),(17,265000,'2','- Quần short jean nam chất liệu vải jean dày              • Hàng chính hãng 100%             \n- Xuất xứ tại Việt Nam                                                 • Được đổi trả hàng theo chính sách của cửa hàng \n- Kiểu dáng thời trang, sành điệu\n- Form quần mới trẻ trung hơn, bạn sẽ thoải mái thoạt động mạnh mà không sợ nhàu nát vải vì cấu trúc sợi chéo chống nhàu, đảm bảo độ bền trong nhiều năm sử dụng               \n- Có thể kết hợp cùng nhiều trang phục khác nhau để mang tới cho mình một phong cách cá tính riêng                          \n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Ưu tiên sử dụng các hình thức giặt khô, giặt hấp hoặc giặt tay để giữ tuổi thọ của quần áo',40,'QUẦN SHORT NAM JEAN','Việt Nam','Quần short nam JEAN LLQSJ002','ĐANG BÁN'),(18,245000,'2','- Quần short kaki nam basic                                       • Hàng chính hãng 100%             \n- Xuất xứ tại Việt Nam                                                 • Được đổi trả hàng theo chính sách của cửa hàng \n- Chất liệu: Khaki cotton vải dày dặn\n- Kiểu dáng thời trang, sành điệu\n- Mềm, thoáng mát, co giãn, đứng form   \n- Đường may được gia công tỉ mỉ, chắc chắn            \n- Có thể kết hợp cùng nhiều trang phục khác nhau để mang tới cho mình một phong cách cá tính riêng                          \n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Ưu tiên sử dụng các hình thức giặt khô, giặt hấp hoặc giặt tay để giữ tuổi thọ của quần áo',40,'QUẦN SHORT NAM KAKI','Việt Nam','Quần short nam KAKI LLQSK001','ĐANG BÁN'),(19,245000,'2','- Quần short kaki nam basic                                       • Hàng chính hãng 100%             \n- Xuất xứ tại Việt Nam                                                 • Được đổi trả hàng theo chính sách của cửa hàng \n- Chất liệu: Khaki cotton vải dày dặn\n- Kiểu dáng thời trang, sành điệu\n- Mềm, thoáng mát, co giãn, đứng form   \n- Đường may được gia công tỉ mỉ, chắc chắn            \n- Có thể kết hợp cùng nhiều trang phục khác nhau để mang tới cho mình một phong cách cá tính riêng                          \n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Ưu tiên sử dụng các hình thức giặt khô, giặt hấp hoặc giặt tay để giữ tuổi thọ của quần áo',40,'QUẦN SHORT NAM KAKI','Việt Nam','Quần short nam KAKI LLQSK002','ĐANG BÁN'),(20,465000,'2','- Quần dài nam JEAN Ống suông cao cấp                  • Hàng chính hãng 100%             \n- Xuất xứ tại Việt Nam                                                 • Được đổi trả hàng theo chính sách của cửa hàng \n- Chất liệu jean cotton bền đẹp\n- Kiểu dáng thời trang, sành điệu\n- Có hai túi xéo trước và hai túi sau rất tiện dụng, chắc chắn, không phai màu, không co rút khi giặc             \n- Có thể kết hợp cùng nhiều trang phục khác nhau để mang tới cho mình một phong cách cá tính riêng                          \n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Ưu tiên sử dụng các hình thức giặt khô, giặt hấp hoặc giặt tay để giữ tuổi thọ của quần áo',40,'QUẦN DÀI NAM JEAN','Việt Nam','Quần dài nam JEAN LLQDJ001','ĐANG BÁN'),(21,465000,'2','- Quần dài nam JEAN Ống suông cao cấp                  • Hàng chính hãng 100%             \n- Xuất xứ tại Việt Nam                                                 • Được đổi trả hàng theo chính sách của cửa hàng \n- Chất liệu jean cotton bền đẹp\n- Kiểu dáng thời trang, sành điệu\n- Có hai túi xéo trước và hai túi sau rất tiện dụng, chắc chắn, không phai màu, không co rút khi giặc             \n- Có thể kết hợp cùng nhiều trang phục khác nhau để mang tới cho mình một phong cách cá tính riêng                          \n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Ưu tiên sử dụng các hình thức giặt khô, giặt hấp hoặc giặt tay để giữ tuổi thọ của quần áo',40,'QUẦN DÀI NAM JEAN','Việt Nam','Quần dài nam JEAN LLQDJ002','ĐANG BÁN'),(23,365000,'2','- Quần dài nam Kaki Ống suông cao cấp                   • Hàng chính hãng 100%             \n- Xuất xứ tại Việt Nam                                                 • Được đổi trả hàng theo chính sách của cửa hàng \n- Chất liệu: kaki cao cấp\n- Form dáng thể thao thoải mái vận động trong mọi hoạt động hàng ngày\n- Chất liệu kaki cao cấp, mềm mịn, dày dặn, thấm hút mồ hôi tốt, co giãn nhẹ, không nhăn, không nhàu             \n- Có thể kết hợp cùng nhiều trang phục khác nhau để mang tới cho mình một phong cách cá tính riêng                          \n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Ưu tiên sử dụng các hình thức giặt khô, giặt hấp hoặc giặt tay để giữ tuổi thọ của quần áo',40,'QUẦN DÀI NAM KAKI','Việt Nam','Quần dài nam KAKI LLQDK002','ĐANG BÁN'),(24,280000,'2','- Quần dài nam thun Ống suông cao cấp                   • Hàng chính hãng 100%             \n- Xuất xứ tại Việt Nam                                                 • Được đổi trả hàng theo chính sách của cửa hàng \n- Chất liệu vải mềm mại \n- Form dáng thể thao thoải mái vận động trong các hoạt động mùa hè nóng nực\n- Từng đường may tinh tế, chỉn chu, màu sắc đa dạng, tươi mát chắc chắn sẽ làm vừa lòng những chàng trai khó tính  nhất             \n- Gồm những gam màu tươi mới giúp bạn dễ dàng phối nhiều loại trang phục khác nhau                          \n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Ưu tiên sử dụng các hình thức giặt khô, giặt hấp hoặc giặt tay để giữ tuổi thọ của quần áo',40,'QUẦN DÀI NAM THUN','Việt Nam','Quần dài nam THUN LLQDT001','ĐANG BÁN'),(25,280000,'2','- Quần dài nam thun Ống suông cao cấp                   • Hàng chính hãng 100%             \n- Xuất xứ tại Việt Nam                                                 • Được đổi trả hàng theo chính sách của cửa hàng \n- Chất liệu vải mềm mại \n- Form jogger dáng thể thao thoải mái vận động trong các hoạt động mùa hè nóng nực\n- Từng đường may tinh tế, chỉn chu, màu sắc đa dạng, tươi mát chắc chắn sẽ làm vừa lòng những chàng trai khó tính  nhất             \n- Gồm những gam màu tươi mới giúp bạn dễ dàng phối nhiều loại trang phục khác nhau                          \n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Ưu tiên sử dụng các hình thức giặt khô, giặt hấp hoặc giặt tay để giữ tuổi thọ của quần áo',40,'QUẦN DÀI NAM THUN','Việt Nam','Quần dài nam THUN LLQDT002','ĐANG BÁN'),(27,215000,'1','- Áo thun phông nữ in hình PLUTO                             • Hàng chính hãng 100%\n- Chất liệu:  Cotton hóa lỏng                                       • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Chất liệu vải sẽ mượn và bóng do dung môi được bao bọc quanh sơ bông     \n- Sản phẩm với khả năng thấm hút tốt, có độ co giãn tốt vì được pha thêm sợi Spandex    \n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Lộn trái sản phẩm khi giặt, không giặt chung sản phẩm với quần áo tối màu\n► Không sử dụng chất tẩy, không ngâm sản phẩm',40,'THUN NỮ TAY NGẮN IN HÌNH','Việt Nam','Áo thun nữ PLUTO LLTN001','ĐANG BÁN'),(28,215000,'1','- Áo thun phông nữ trơn một màu                             • Hàng chính hãng 100%\n- Chất liệu:  Cotton hóa lỏng                                       • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Chất liệu vải sẽ mượn và bóng do dung môi được bao bọc quanh sơ bông     \n- Sản phẩm với khả năng thấm hút tốt, có độ co giãn tốt vì được pha thêm sợi Spandex    \n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Lộn trái sản phẩm khi giặt, không giặt chung sản phẩm với quần áo tối màu\n► Không sử dụng chất tẩy, không ngâm sản phẩm',40,'THUN NỮ TAY NGẮN TRƠN','Việt Nam','Áo thun nữ TRƠN LLTN002','ĐANG BÁN'),(29,215000,'1','- Áo thun phông nữ in hình chữ                                  • Hàng chính hãng 100%\n- Chất liệu:  Cotton hóa lỏng                                       • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Chất liệu vải sẽ mượn và bóng do dung môi được bao bọc quanh sơ bông     \n- Sản phẩm với khả năng thấm hút tốt, có độ co giãn tốt vì được pha thêm sợi Spandex    \n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Lộn trái sản phẩm khi giặt, không giặt chung sản phẩm với quần áo tối màu\n► Không sử dụng chất tẩy, không ngâm sản phẩm',40,'THUN NỮ TAY NGẮN IN HÌNH','Việt Nam','Áo thun nữ CA LLTN003','ĐANG BÁN'),(30,215000,'1','- Áo thun phông nữ CROPTOP một màu có logo       • Hàng chính hãng 100%\n- Chất liệu:  Cotton hóa lỏng                                       • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Thiết kế phong cách cổ điển, cá tính, đơn giản, tinh tế mang lại nhiều nét khác biệt   \n- Chất liệu  siêu đẹp, không nhăn, xù bền đẹp theo thời gian khiến chị em luôn xinh đẹp và tự tin khi đi chơi cùng gia đình và bạn bè\n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Lộn trái sản phẩm khi giặt, không giặt chung sản phẩm với quần áo tối màu\n► Không sử dụng chất tẩy, không ngâm sản phẩm',40,'THUN NỮ TAY NGẮN CROPTOP','Việt Nam','Áo thun nữ CROPTOP LLTNC001','ĐANG BÁN'),(31,215000,'1','- Áo thun phông nữ CROPTOP một màu in hình        • Hàng chính hãng 100%\n- Chất liệu:  Thun                                                         • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Thiết kế phong cách cổ điển, cá tính, đơn giản, tinh tế mang lại nhiều nét khác biệt   \n- Chất liệu  siêu đẹp, không nhăn, xù bền đẹp theo thời gian khiến chị em luôn xinh đẹp và tự tin khi đi chơi cùng gia đình và bạn bè\n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Lộn trái sản phẩm khi giặt, không giặt chung sản phẩm với quần áo tối màu\n► Không sử dụng chất tẩy, không ngâm sản phẩm',40,'THUN NỮ TAY NGẮN CROPTOP','Việt Nam','Áo thun nữ CROPTOP LLTNC002','ĐANG BÁN'),(32,215000,'1','- Áo thun phông nữ trơn một màu                             • Hàng chính hãng 100%\n- Chất liệu:  Cotton                                                      • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Thiết kế phong cách cổ điển, cá tính, đơn giản, tinh tế mang lại nhiều nét khác biệt   \n- Chất liệu  siêu đẹp, không nhăn, xù bền đẹp theo thời gian khiến chị em luôn xinh đẹp và tự tin khi đi chơi cùng gia đình và bạn bè\n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Lộn trái sản phẩm khi giặt, không giặt chung sản phẩm với quần áo tối màu\n► Không sử dụng chất tẩy, không ngâm sản phẩm',40,'THUN NỮ TAY NGẮN TRƠN','Việt Nam','Áo thun nữ TRƠN LLTN004','ĐANG BÁN'),(34,245000,'1','- Áo thun nữ tay dài cổ tròn một màu in số 1987       • Hàng chính hãng 100%\n- Chất liệu:  Thun                                                         • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Thiết kế phong cách cổ điển, cá tính, đơn giản, tinh tế mang lại nhiều nét khác biệt   \n- Chất thun mềm mại co giãn, mặc riêng hoặc phối cùng áo len bên ngoài rất đẹp\n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Lộn trái sản phẩm khi giặt, không giặt chung sản phẩm với quần áo tối màu\n► Không sử dụng chất tẩy, không ngâm sản phẩm',40,'THUN NỮ TAY DÀI IN HÌNH','Việt Nam','Áo thun nữ 1987 LLTND002','ĐANG BÁN'),(35,205000,'1','- Áo thun nữ tay dài CROTOP in chữ Mystical            • Hàng chính hãng 100%\n- Chất liệu:  Thun                                                         • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Thiết kế phong cách cổ điển, cá tính, đơn giản, tinh tế mang lại nhiều nét khác biệt   \n- Chất thun mềm mại co giãn, mặc riêng hoặc phối cùng áo len bên ngoài rất đẹp\n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Lộn trái sản phẩm khi giặt, không giặt chung sản phẩm với quần áo tối màu\n► Không sử dụng chất tẩy, không ngâm sản phẩm',40,'THUN NỮ TAY DÀI CROPTOP','Việt Nam','Áo thun nữ MYSTICAL LLTNDC001','ĐANG BÁN'),(36,205000,'1','- Áo thun nữ tay dài CROTOP trơn một màu              • Hàng chính hãng 100%\n- Chất liệu:  Thun                                                         • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Thiết kế phong cách cổ điển, cá tính, đơn giản, tinh tế mang lại nhiều nét khác biệt   \n- Chất thun mềm mại co giãn, mặc riêng hoặc phối cùng áo len bên ngoài rất đẹp\n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Lộn trái sản phẩm khi giặt, không giặt chung sản phẩm với quần áo tối màu\n► Không sử dụng chất tẩy, không ngâm sản phẩm',40,'THUN NỮ TAY DÀI CROPTOP','Việt Nam','Áo thun nữ CROPTOP LLTNDC002','ĐANG BÁN'),(37,215000,'1','- Áo sơ mi nữ tay ngắn chấm bi                                  • Hàng chính hãng 100%\n- Chất liệu:  Lụa voan                                                   • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Thiết kế tinh tế, kiểu dáng trending 2021 - Mang lại sự sang trọng cho người mặc \n- Áo chất đẹp không nhăn, không nhàu lên form chuẩn dáng đẹp\n- Chất voan lụa hàn mềm mịn ko nhăn nhàu tạo cảm giác thoải mái, thoáng mát.\n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Lộn trái sản phẩm khi giặt, không giặt chung sản phẩm với quần áo tối màu\n► Không sử dụng chất tẩy, không ngâm sản phẩm',40,'SƠ MI NỮ TAY NGẮN','Việt Nam','Áo sơ mi nữ CBI LLSMN001','ĐANG BÁN'),(38,215000,'1','- Áo sơ mi nữ có cổ                                                     • Hàng chính hãng 100%\n- Chất liệu:  Lụa voan                                                   • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Thiết kế tinh tế, kiểu dáng trending 2021 - Mang lại sự sang trọng cho người mặc \n- Áo chất đẹp không nhăn, không nhàu lên form chuẩn dáng đẹp\n- Có thể thắt nút thời trang, tạo kiểu sành điệu\n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Lộn trái sản phẩm khi giặt, không giặt chung sản phẩm với quần áo tối màu\n► Không sử dụng chất tẩy, không ngâm sản phẩm',40,'SƠ MI NỮ TAY NGẮN','Việt Nam','Áo sơ mi nữ LLSMN002','ĐANG BÁN'),(39,215000,'1','- Áo sơ mi nữ có cổ                                                     • Hàng chính hãng 100%\n- Chất liệu:  Lụa voan                                                   • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Thiết kế tinh tế, kiểu dáng trending 2021 - Mang lại sự sang trọng cho người mặc \n- Áo chất đẹp không nhăn, không nhàu lên form chuẩn dáng đẹp\n- Có thể thắt nút thời trang, tạo kiểu sành điệu\n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Lộn trái sản phẩm khi giặt, không giặt chung sản phẩm với quần áo tối màu\n► Không sử dụng chất tẩy, không ngâm sản phẩm',40,'SƠ MI NỮ TAY NGẮN','Việt Nam','Áo sơ mi nữ LLSMN003','ĐANG BÁN'),(40,265000,'1','- Áo sơ mi nữ tay dài in chữ logo BROKEN                 • Hàng chính hãng 100%\n- Chất liệu:  Cotton                                                      • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Áo sơ mi kẻ caro tay bồng form siêu rộng LylyshopUnisex là sản phẩm áo sơ mi thời trang\n- Được thiết kế theo phong cách ullzang siêu rộng\n- Chất liệu: áo sơ mi nữ tay phồng kẻ caro form rộng chất kate cotton 100% phù hợp thời tiết mùa hè , mềm mịn, không co rút hay chảy nhão, giặt máy thoải mái\n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Lộn trái sản phẩm khi giặt, không giặt chung sản phẩm với quần áo tối màu',40,'SƠ MI NỮ TAY DÀI','Việt Nam','Áo sơ mi nữ BROKEN LLSMD001','ĐANG BÁN'),(41,265000,'1','- Áo sơ mi nữ tay dài một màu basic                          • Hàng chính hãng 100%\n- Chất liệu:  Cotton                                                      • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Áo sơ mi kẻ caro tay bồng form siêu rộng LylyshopUnisex là sản phẩm áo sơ mi thời trang\n- Được thiết kế theo phong cách ullzang siêu rộng\n- Chất liệu: áo sơ mi nữ tay phồng kẻ caro form rộng chất kate cotton 100% phù hợp thời tiết mùa hè , mềm mịn, không co rút hay chảy nhão, giặt máy thoải mái\n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Lộn trái sản phẩm khi giặt, không giặt chung sản phẩm với quần áo tối màu',40,'SƠ MI NỮ TAY DÀI','Việt Nam','Áo sơ mi nữ LLSMD002','ĐANG BÁN'),(42,285000,'2','- Quần short Jean nữ có thắt lưng                              • Hàng chính hãng 100%\n- Chất liệu:  vải Jeans cao cấp                                     • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Vải mang đến cảm giác mặc rất thoải mái, không hề bí bách khi mặc thường xuyên\n- Vải có độ bên cao nhất, ít bị sờn, bị rách, hay xô chỉ\n- Dễ bảo quản, bạn có thể giặt bằng tay hoặc bằng máy mà không lo lắng vải bị rách. Ngoài ra, khi phơi hay bảo quản cũng dễ dàng hơn\n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Lộn trái sản phẩm khi giặt, không giặt chung sản phẩm với quần áo tối màu',40,'QUẦN SHORT NỮ JEAN','Việt Nam','Quần short nữ JEAN LLSNJ001','ĐANG BÁN'),(43,285000,'2','- Quần short Jean nữ                                                  • Hàng chính hãng 100%\n- Chất liệu:  vải Jeans cao cấp                                     • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Vải mang đến cảm giác mặc rất thoải mái, không hề bí bách khi mặc thường xuyên\n- Vải có độ bên cao nhất, ít bị sờn, bị rách, hay xô chỉ\n- Dễ bảo quản, bạn có thể giặt bằng tay hoặc bằng máy mà không lo lắng vải bị rách. Ngoài ra, khi phơi hay bảo quản cũng dễ dàng hơn\n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Lộn trái sản phẩm khi giặt, không giặt chung sản phẩm với quần áo tối màu',40,'QUẦN SHORT NỮ JEAN','Việt Nam','Quần short nữ JEAN LLSNJ002','ĐANG BÁN'),(44,215000,'2','- Quần short Kaki nữ                                                  • Hàng chính hãng 100%\n- Chất liệu:  Vải kaki siêu nhẵn                                    • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Đường kim mũi chỉ cẩn thận, chắc chắn\n- Vải kaki siêu nhẵn, không xù lông, thấm hút mồ hôi\n- Quần kaki dáng ôm basic lưng cao đính cúc trẻ trung\n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Lộn trái sản phẩm khi giặt, không giặt chung sản phẩm với quần áo tối màu',40,'QUẦN SHORT NỮ KAKI','Việt Nam','Quần short nữ KAKI LLQSNK001','ĐANG BÁN'),(45,215000,'2','- Quần short Kaki nữ                                                  • Hàng chính hãng 100%\n- Chất liệu:  Vải kaki siêu nhẵn                                    • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Đường kim mũi chỉ cẩn thận, chắc chắn\n- Vải kaki siêu nhẵn, không xù lông, thấm hút mồ hôi\n- Quần kaki dáng ôm basic lưng cao đính cúc trẻ trung\n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Lộn trái sản phẩm khi giặt, không giặt chung sản phẩm với quần áo tối màu',40,'QUẦN SHORT NỮ KAKI','Việt Nam','Quần short nữ KAKI LLQSNK002','ĐANG BÁN'),(46,440000,'2','- Quần dài Jean nữ                                                      • Hàng chính hãng 100%\n- Chất liệu:  Jeans khá dày dặn                                    • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Kiểu dáng ôm sát lưng cao ngang rốn\n- Mẫu quần jeans cơ bản màu trơn phù hợp với mọi độ tuổi, mọi công việc và môi trường khác nhau\n- Quần jeans dáng ôm, vải siêu co giãn, form dáng, đường kim mũi chỉ rất chuẩn và chất lượng wash cực tốt\n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Lộn trái sản phẩm khi giặt, không giặt chung sản phẩm với quần áo tối màu',40,'QUẦN DÀI NỮ JEAN','Việt Nam','Quần dài nữ JEAN LLQDJ001','ĐANG BÁN'),(48,450000,'2','- Quần dài Jean nữ                                                      • Hàng chính hãng 100%\n- Chất liệu:  Jeans khá dày dặn                                    • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Kiểu dáng ôm sát lưng cao ngang rốn\n- Mẫu quần jeans cơ bản màu trơn phù hợp với mọi độ tuổi, mọi công việc và môi trường khác nhau\n- Quần jeans dáng ôm, vải siêu co giãn, form dáng, đường kim mũi chỉ rất chuẩn và chất lượng wash cực tốt\n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Lộn trái sản phẩm khi giặt, không giặt chung sản phẩm với quần áo tối màu',40,'QUẦN DÀI NỮ JEAN','Việt Nam','Quần dài nữ JEAN LLQDJ002','ĐANG BÁN'),(49,225000,'2','- Chân váy nữ Kaki                                                      • Hàng chính hãng 100%\n- Chất liệu:  Kaki                                                          • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Chất vải tuyết mưa dày, mịn, thấm mút mồ hôi tốt, không xù lông, mềm mại cho làn da, cầm mát tay\n- Kiểu dáng: chân váy ôm\n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Tốt nhất nên giặt tay và không nên chà mạnh bằng bàn chải có sợi cứng\n► Không nên sử dụng chất giặt tẩy',40,'CHÂN VÁY','Việt Nam','Chân váy W2CH LLCV001','ĐANG BÁN'),(50,315000,'2','- Chân váy nữ Kaki                                                      • Hàng chính hãng 100%\n- Chất liệu:  Kaki                                                          • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Chất vải tuyết mưa dày, mịn, thấm mút mồ hôi tốt, không xù lông, mềm mại cho làn da, cầm mát tay\n- Kiểu dáng: chân váy ôm\n                                                                            \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Tốt nhất nên giặt tay và không nên chà mạnh bằng bàn chải có sợi cứng\n► Không nên sử dụng chất giặt tẩy',40,'CHÂN VÁY','Việt Nam','Chân váy W2JEAN LLCV002','ĐANG BÁN'),(55,345000,'3','- Ba lô                                                                          • Hàng chính hãng 100%\n- Chất liệu:  Chất liệu vải Polyester cao cấp                 • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Sản phẩm có kích thước rộng rãi, được chia làm nhiều ngăn tiện lợi. Có các ngăn lớn  để đựng các vật dụng cần thiết và nhiều ngăn nhỏ để đựng giấy tờ, tiền, ví… tiện dùng khi đi học, làm việc\n- Sản phẩm được chế tác bằng những đường may tỉ mỉ và chắc chắn, không chỉ mang đến độ bền mà còn mang đến tính thẩm mỹ, tinh tế cao   \n                                                                    \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn',40,'BA LÔ','Việt Nam','Ba lô LLBL002','ĐANG BÁN'),(54,235000,'3','- Ba lô đỏ New York                                                     • Hàng chính hãng 100%\n- Chất liệu:  Chất liệu vải Polyester cao cấp                 • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Sản phẩm có kích thước rộng rãi, được chia làm nhiều ngăn tiện lợi. Có các ngăn lớn  để đựng các vật dụng cần thiết và nhiều ngăn nhỏ để đựng giấy tờ, tiền, ví… tiện dùng khi đi học, làm việc\n- Sản phẩm được chế tác bằng những đường may tỉ mỉ và chắc chắn, không chỉ mang đến độ bền mà còn mang đến tính thẩm mỹ, tinh tế cao   \n                                                                    \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn',40,'BA LÔ','Việt Nam','Ba lô NY LLBL001','ĐANG BÁN'),(56,235000,'3','- Ba lô xám Ladata                                                       • Hàng chính hãng 100%\n- Chất liệu:  Chất liệu vải Polyester cao cấp                 • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Sản phẩm có kích thước rộng rãi, được chia làm nhiều ngăn tiện lợi. Có các ngăn lớn  để đựng các vật dụng cần thiết và nhiều ngăn nhỏ để đựng giấy tờ, tiền, ví… tiện dùng khi đi học, làm việc\n- Sản phẩm được chế tác bằng những đường may tỉ mỉ và chắc chắn, không chỉ mang đến độ bền mà còn mang đến tính thẩm mỹ, tinh tế cao   \n                                                                    \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn',40,'BA LÔ','Việt Nam','Ba lô LLBL003','ĐANG BÁN'),(60,195000,'3','- Túi đeo chéo thời trang vải canvas                           • Hàng chính hãng 100%\n- Chất liệu:  Vải canvas bền đẹp                                  • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Túi đeo chéo nam, nữ thời trang với kích thước phù hợp mang, đựng các vật dụng, sách, bút, vở, pin ,sạc dự phòng, thẻ ATM, các đồ dùng cá nhân\n-Đường may chắc chắn, tinh tế giúp đựng được các đồ dùng nặng   \n                                                                    \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Tránh tiếp xúc trực tiếp với nước lâu hoặc để trong môi trường ẩm thấp\n► Thường xuyên vệ sinh túi bằng khăn hoặc giấy khô ',40,'TÚI XÁCH','Việt Nam','Túi xách LLTX003','ĐANG BÁN'),(58,385000,'3','- Túi đeo chéo nữ thời trang dây da                           • Hàng chính hãng 100%\n- Chất liệu:  Da PU                                                       • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Túi đeo chéo nữ, Túi xách nữ được thiết kế tinh tế, trẻ trung màu sắc sang trọng thời thượng kết hợp với chất liệu da tổng hợp cao cấp, mềm mại, không bong tróc và không thấm nước\n- Lớp lót bên trong túi da được làm bằng vải dù cao cấp. Túi đeo chéo nữ, túi xách nữ dễ dàng vệ sinh với xà phòng và nước\n                                                                    \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Tránh tiếp xúc trực tiếp với nước lâu hoặc để trong môi trường ẩm thấp\n► Thường xuyên vệ sinh túi bằng khăn hoặc giấy khô ',40,'TÚI XÁCH','Việt Nam','Túi xách LLTX001','ĐANG BÁN'),(59,345000,'3','- Túi xách thời trang dây da                                        • Hàng chính hãng 100%\n- Chất liệu:  Da PU                                                       • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n-Túi xách được thiết kế tinh tế, trẻ trung màu sắc sang trọng thời thượng kết hợp với chất liệu da tổng hợp cao cấp, mềm mại, không bong tróc và không thấm nước\n- Lớp lót bên trong túi da được làm bằng vải dù cao cấp. Túi đeo chéo nữ, túi xách nữ dễ dàng vệ sinh với xà phòng và nước\n                                                                    \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Tránh tiếp xúc trực tiếp với nước lâu hoặc để trong môi trường ẩm thấp\n► Thường xuyên vệ sinh túi bằng khăn hoặc giấy khô ',40,'TÚI XÁCH','Việt Nam','Túi xách LLTX002','ĐANG BÁN'),(61,195000,'3','- Túi đeo chéo nữ thời trang                                       • Hàng chính hãng 100%\n- Chất liệu:  Polyester chống nước nhẹ                       • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Dây đai điều chỉnh chiều dài linh hoạt, phù hợp mọi đối tượng\n- Với 1 ngăn khoá kéo chính + 1 ngăn zip phụ bên trong, đảm bảo an toàn, cất ví + điện thoại + passport + gậy tự sướng + son phấn vô tư\n                                                                    \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Tránh tiếp xúc trực tiếp với nước lâu hoặc để trong môi trường ẩm thấp\n► Thường xuyên vệ sinh túi bằng khăn hoặc giấy khô ',40,'TÚI XÁCH','Việt Nam','Túi xách LLTX004','ĐANG BÁN'),(62,90000,'3','- Nón lưỡi trai Jean style đường phố                          • Hàng chính hãng 100%\n- Chất liệu:  Jeans                                                        • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Thiết kế ôm đầu, có thể điều chỉnh, vành đai thấm mồ hôi tốt \n- VÒNG ĐẦU: 52cm – 59cm (MỨC CHUẨN: 54cm – 57cm) phù hợp với hầu hết mọi đầu Phụ kiện – khóa, nút: Khóa – lỗ gió, làm từ hợp kim không gỉ\n- Kích thước: form chuẩn nam nữ điều đội được - dể dàng điều chỉnh - thau vào và mở ra                              \n                                      \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn',40,'NÓN LƯỠI TRAI','Việt Nam','Nón lưỡi trai LLNLT001','ĐANG BÁN'),(63,90000,'3','- Nón lưỡi trai SCY                                                      • Hàng chính hãng 100%\n- Chất liệu:  Cotton                                                      • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Thiết kế ôm đầu, có thể điều chỉnh, vành đai thấm mồ hôi tốt \n- VÒNG ĐẦU: 52cm – 59cm (MỨC CHUẨN: 54cm – 57cm) phù hợp với hầu hết mọi đầu Phụ kiện – khóa, nút: Khóa – lỗ gió, làm từ hợp kim không gỉ\n- Kích thước: form chuẩn nam nữ điều đội được - dể dàng điều chỉnh - thau vào và mở ra                              \n                                      \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn',40,'NÓN LƯỠI TRAI','Việt Nam','Nón lưỡi trai LLNLT002','ĐANG BÁN'),(64,195000,'3','- Nón Bucket Balenciaga                                             • Hàng chính hãng 100%\n- Chất liệu:  Cotton                                                      • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Chất vải cotton dày mịn, thoáng mát\n- Size vòng đầu 54-57cm, chiều cao nón 9cm, vành rộng 6,5cm\n- Mũ tai bèo rất hợp cạ với những trang phục thiên về sự năng động, thoải mái và trẻ trung                              \n                                      \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Không nên chà xát mạnh bằng bàn chải. Khuyến cáo nên giặt bằng tay',40,'NÓN BUCKET','Việt Nam','Nón BUCKET LLNBK001','ĐANG BÁN'),(65,195000,'3','- Nón bucket adidas                                                    • Hàng chính hãng 100%\n- Chất liệu:  Cotton                                                      • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Chất vải cotton dày mịn, thoáng mát\n- Size vòng đầu 54-57cm, chiều cao nón 9cm, vành rộng 6,5cm\n- Mũ tai bèo rất hợp cạ với những trang phục thiên về sự năng động, thoải mái và trẻ trung                              \n                                      \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Không nên chà xát mạnh bằng bàn chải. Khuyến cáo nên giặt bằng tay',40,'NÓN BUCKET','Việt Nam','Nón BUCKET LLNBK002','ĐANG BÁN'),(66,195000,'3','- Nón Bucket NY                                                         • Hàng chính hãng 100%\n- Chất liệu:  Cotton                                                      • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Chất vải cotton dày mịn, thoáng mát\n- Size vòng đầu 54-57cm, chiều cao nón 9cm, vành rộng 6,5cm\n- Mũ tai bèo rất hợp cạ với những trang phục thiên về sự năng động, thoải mái và trẻ trung                              \n                                      \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Không nên chà xát mạnh bằng bàn chải. Khuyến cáo nên giặt bằng tay',40,'NÓN BUCKET','Việt Nam','Nón BUCKET LLNBK003','ĐANG BÁN'),(67,150000,'3','- Nón Snapback adidas                                               • Hàng chính hãng 100%\n- Chất liệu:  Vải dù                                                       • Được đổi trả hàng theo chính sách của cửa hàng \n- Xuất xứ tại Việt Nam                                                 \n- Chất liệu được dệt từ vải dù cao cấp, bắn laze công nghệ Hàn Quốc\n- Không gây kích ứng da đầu, không ra màu\n- Size: freesize, dễ dàng điều chỉnh size bằng khóa sau mũ, vòng đầu 52-58cm thích hợp cho cả nam nữ                              \n                                      \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn\n► Không nên chà xát mạnh bằng bàn chải. Khuyến cáo nên giặt bằng tay',40,'NÓN SNAPBACK','Việt Nam','Nón SNAPBACK LLSNB001','ĐANG BÁN'),(68,245000,'3','- Đồng hồ dây da                                               • Hàng chính hãng 100%\n- Chất liệu dây: Da                                              • Được đổi trả hàng theo chính sách của cửa hàng \n- Chất liệu viền ngoài: Thép không gỉ\n- Chất liệu mặt kính: Mặt kính Mineral crytal chống trầy và va đập tốt\n- Xuất xứ tại Việt Nam         \n- Chống nước: 3ATM chống nước sinh hoạt                                                                      \n                                      \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn',40,'ĐỒNG HỒ','Việt Nam','Đồng hồ LLDH001','ĐANG BÁN'),(69,245000,'3','- Đồng hồ dây da                                               • Hàng chính hãng 100%\n- Chất liệu dây: Da                                              • Được đổi trả hàng theo chính sách của cửa hàng \n- Chất liệu viền ngoài: Thép không gỉ\n- Chất liệu mặt kính: Mặt kính Mineral crytal chống trầy và va đập tốt\n- Xuất xứ tại Việt Nam         \n- Chống nước: 3ATM chống nước sinh hoạt                                                                      \n                                      \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn',40,'ĐỒNG HỒ','Việt Nam','Đồng hồ LLDH002','ĐANG BÁN'),(70,245000,'3','- Đồng hồ dây da                                               • Hàng chính hãng 100%\n- Chất liệu dây: Da                                              • Được đổi trả hàng theo chính sách của cửa hàng \n- Chất liệu viền ngoài: Thép không gỉ\n- Chất liệu mặt kính: Mặt kính Mineral crytal chống trầy và va đập tốt\n- Xuất xứ tại Việt Nam         \n- Chống nước: 3ATM chống nước sinh hoạt                                                                      \n                                      \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn',40,'ĐỒNG HỒ','Việt Nam','Đồng hồ LLDH003','ĐANG BÁN'),(71,255000,'3','- Thắt lưng dây da GG                                        • Hàng chính hãng 100%\n- Chất liệu : Da thật                                              • Được đổi trả hàng theo chính sách của cửa hàng \n- Đầu khóa hợp kim không rỉ, sang trọng\n- Xuất xứ tại Việt Nam    \n- Thiết kế vân da trơn, đầu khóa hợp kim xám, tạo hoa văn xéo sang trọng             \n- Thoải mái điều chỉnh kích cỡ thắt lưng theo số đo vòng 2 \n- Sản phẩm dễ dàng phối với quần jean, quần kaiki, quần âu... Mang lại vẻ thanh lịch, hiện đại và trẻ trung cho bạn                                                          \n                                      \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn',40,'DÂY NỊCH','Việt Nam','Dây nịch LLDN001','ĐANG BÁN'),(72,255000,'3','- Thắt lưng dây da GĐ                                         • Hàng chính hãng 100%\n- Chất liệu : Da thật                                              • Được đổi trả hàng theo chính sách của cửa hàng \n- Đầu khóa hợp kim không rỉ, sang trọng\n- Xuất xứ tại Việt Nam    \n- Thiết kế vân da trơn, đầu khóa hợp kim xám, tạo hoa văn xéo sang trọng             \n- Thoải mái điều chỉnh kích cỡ thắt lưng theo số đo vòng 2 \n- Sản phẩm dễ dàng phối với quần jean, quần kaiki, quần âu... Mang lại vẻ thanh lịch, hiện đại và trẻ trung cho bạn                                                          \n                                      \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn',40,'DÂY NỊCH','Việt Nam','Dây nịch LLDN002','ĐANG BÁN'),(73,255000,'3','- Thắt lưng dây da GĐ                                         • Hàng chính hãng 100%\n- Chất liệu : Da thật                                              • Được đổi trả hàng theo chính sách của cửa hàng \n- Đầu khóa hợp kim không rỉ, sang trọng\n- Xuất xứ tại Việt Nam    \n- Thiết kế vân da trơn, đầu khóa hợp kim xám, tạo hoa văn xéo sang trọng             \n- Thoải mái điều chỉnh kích cỡ thắt lưng theo số đo vòng 2 \n- Sản phẩm dễ dàng phối với quần jean, quần kaiki, quần âu... Mang lại vẻ thanh lịch, hiện đại và trẻ trung cho bạn                                                          \n                                      \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn',40,'DÂY NỊCH','Việt Nam','Dây nịch LLDN003','ĐANG BÁN'),(74,255000,'3','- Thắt lưng dây da GĐ                                         • Hàng chính hãng 100%\n- Chất liệu : Da thật                                              • Được đổi trả hàng theo chính sách của cửa hàng \n- Đầu khóa hợp kim không rỉ, sang trọng\n- Xuất xứ tại Việt Nam    \n- Thiết kế vân da trơn, đầu khóa hợp kim xám, tạo hoa văn xéo sang trọng             \n- Thoải mái điều chỉnh kích cỡ thắt lưng theo số đo vòng 2 \n- Sản phẩm dễ dàng phối với quần jean, quần kaiki, quần âu... Mang lại vẻ thanh lịch, hiện đại và trẻ trung cho bạn                                                          \n                                      \n► Tránh va chạm, tiếp súc với bề mặt sắc nhọn',40,'DÂY NỊCH','Việt Nam','Dây nịch LLDN004','ĐANG BÁN');
/*!40000 ALTER TABLE `sanpham` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'fashionshop_v5'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-06-03 17:46:17
