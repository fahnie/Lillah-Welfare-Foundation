-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: lillahwelfarefoundation
-- ------------------------------------------------------
-- Server version	8.0.42

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
-- Table structure for table `admins`
--

DROP TABLE IF EXISTS `admins`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admins` (
  `id` int NOT NULL,
  `role` enum('Leader / Head','Money Manager','Project Head','Media & Posts','Tech & Website') DEFAULT NULL,
  `assigned_date` date DEFAULT NULL,
  `can_edit_users` tinyint(1) DEFAULT '0',
  `can_manage_donations` tinyint(1) DEFAULT '0',
  `can_manage_courses` tinyint(1) DEFAULT '0',
  `can_view_reports` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id`),
  CONSTRAINT `admins_ibfk_1` FOREIGN KEY (`id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admins`
--

LOCK TABLES `admins` WRITE;
/*!40000 ALTER TABLE `admins` DISABLE KEYS */;
INSERT INTO `admins` VALUES (27,'Tech & Website','2021-09-08',0,0,0,0),(28,'Leader / Head','2022-09-01',0,0,0,0),(36,'Project Head','2025-06-16',0,0,0,0);
/*!40000 ALTER TABLE `admins` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendance` (
  `id` int NOT NULL AUTO_INCREMENT,
  `course_id` int NOT NULL,
  `student_id` int NOT NULL,
  `attendance_date` date NOT NULL,
  `status` enum('Present','Absent','Excused') NOT NULL,
  `marked_by` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `course_id` (`course_id`),
  KEY `student_id` (`student_id`),
  KEY `marked_by` (`marked_by`),
  CONSTRAINT `attendance_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`),
  CONSTRAINT `attendance_ibfk_2` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`),
  CONSTRAINT `attendance_ibfk_3` FOREIGN KEY (`marked_by`) REFERENCES `teachers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES (1,1,20,'2025-06-14','Present',22),(2,1,20,'2025-06-15','Absent',22),(3,3,31,'2025-06-18','Excused',38),(4,3,31,'2025-08-09','Absent',38),(5,3,31,'2025-08-09','Absent',38),(6,1,20,'2025-09-09','Absent',38),(7,1,31,'2025-09-09','Present',38),(8,1,37,'2025-09-09','Present',38),(9,3,31,'2025-09-09','Absent',38);
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `courses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `course_name` varchar(100) NOT NULL,
  `course_description` text,
  `duration_weeks` int DEFAULT NULL,
  `start_date` date DEFAULT NULL,
  `end_date` date DEFAULT NULL,
  `teacher_id` int DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `teacher_id` (`teacher_id`),
  CONSTRAINT `courses_ibfk_1` FOREIGN KEY (`teacher_id`) REFERENCES `teachers` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `courses`
--

LOCK TABLES `courses` WRITE;
/*!40000 ALTER TABLE `courses` DISABLE KEYS */;
INSERT INTO `courses` VALUES (1,'Qisa-e-Adam','A month long course for teeanagers to learn more about Prophet Adm (A.S)',4,'2025-06-16','2025-07-15',22),(2,'Uswa-e-Hasana','aims to inspire students to implement the Prophet’s ﷺ beautiful manners and teachings in their personal, social, and spiritual lives, fostering a deeper connection with Islamic values and a sincere commitment to righteous conduct.',7,'2025-06-18','2025-09-17',22),(3,'Sample Course','sample',3,'2025-09-09','2025-10-07',38);
/*!40000 ALTER TABLE `courses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donationcategories`
--

DROP TABLE IF EXISTS `donationcategories`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donationcategories` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `description` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donationcategories`
--

LOCK TABLES `donationcategories` WRITE;
/*!40000 ALTER TABLE `donationcategories` DISABLE KEYS */;
INSERT INTO `donationcategories` VALUES (1,'Sadaqah (Voluntary Charity)','General-purpose charity given to support various humanitarian efforts.'),(2,'Orphan Sponsorship','Covers living, schooling, and care expenses of orphans..'),(3,'Disaster Response','Rapid response to any national or local disaster with aid and relief...'),(4,'1234','1234'),(5,'Sample Category','checking');
/*!40000 ALTER TABLE `donationcategories` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donationrequests`
--

DROP TABLE IF EXISTS `donationrequests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donationrequests` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` int NOT NULL,
  `category_id` int NOT NULL,
  `status` enum('Pending','Approved','Rejected') DEFAULT 'Pending',
  `date` date NOT NULL,
  `purpose` text,
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `donationrequests_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`),
  CONSTRAINT `donationrequests_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `donationcategories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donationrequests`
--

LOCK TABLES `donationrequests` WRITE;
/*!40000 ALTER TABLE `donationrequests` DISABLE KEYS */;
INSERT INTO `donationrequests` VALUES (1,20,2,'Approved','2025-06-14','I am an orphaned student currently\n enrolled in the foundation’s educational program.\n I am requesting Sadaqah support to help cover my daily living expenses, \nschool materials, and basic needs,\n as I have no direct financial guardian. Your assistance will ease my hardship and allow me to continue my studies with dignity and hope'),(2,31,2,'Rejected','2025-06-16','please sponsor me'),(3,31,2,'Approved','2025-06-18','sample purpose'),(4,37,1,'Approved','2025-06-18','sample purpose student 1'),(5,31,2,'Pending','2025-06-18','sample');
/*!40000 ALTER TABLE `donationrequests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donations`
--

DROP TABLE IF EXISTS `donations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donations` (
  `id` int NOT NULL AUTO_INCREMENT,
  `donor_id` int NOT NULL,
  `category_id` int NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `date` date NOT NULL,
  `notes` text,
  PRIMARY KEY (`id`),
  KEY `donor_id` (`donor_id`),
  KEY `category_id` (`category_id`),
  CONSTRAINT `donations_ibfk_1` FOREIGN KEY (`donor_id`) REFERENCES `donors` (`id`),
  CONSTRAINT `donations_ibfk_2` FOREIGN KEY (`category_id`) REFERENCES `donationcategories` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donations`
--

LOCK TABLES `donations` WRITE;
/*!40000 ALTER TABLE `donations` DISABLE KEYS */;
INSERT INTO `donations` VALUES (1,13,1,5000.00,'2025-06-15','to help the needy'),(2,34,1,10000.00,'2025-06-08','sample'),(3,42,1,10000.00,'2025-09-09','Sample');
/*!40000 ALTER TABLE `donations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `donors`
--

DROP TABLE IF EXISTS `donors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `donors` (
  `id` int NOT NULL,
  `organization` varchar(100) DEFAULT NULL,
  `donation_frequency` enum('One-time','Monthly','Yearly') DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `donors_ibfk_1` FOREIGN KEY (`id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `donors`
--

LOCK TABLES `donors` WRITE;
/*!40000 ALTER TABLE `donors` DISABLE KEYS */;
INSERT INTO `donors` VALUES (13,'lwf','One-time'),(34,'Organization','One-time'),(39,'org','Monthly'),(41,'org','Monthly'),(42,'d.org','One-time'),(43,'donor.org','Monthly');
/*!40000 ALTER TABLE `donors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `studentcourses`
--

DROP TABLE IF EXISTS `studentcourses`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `studentcourses` (
  `id` int NOT NULL AUTO_INCREMENT,
  `student_id` int NOT NULL,
  `course_id` int NOT NULL,
  `enrollment_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `student_id` (`student_id`),
  KEY `course_id` (`course_id`),
  CONSTRAINT `studentcourses_ibfk_1` FOREIGN KEY (`student_id`) REFERENCES `students` (`id`),
  CONSTRAINT `studentcourses_ibfk_2` FOREIGN KEY (`course_id`) REFERENCES `courses` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `studentcourses`
--

LOCK TABLES `studentcourses` WRITE;
/*!40000 ALTER TABLE `studentcourses` DISABLE KEYS */;
INSERT INTO `studentcourses` VALUES (1,20,1,'2025-06-14'),(2,31,1,'2024-12-16'),(3,37,1,'2025-06-18'),(4,31,3,'2025-06-18'),(5,45,1,'2025-09-09');
/*!40000 ALTER TABLE `studentcourses` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `students` (
  `id` int NOT NULL,
  `age` int DEFAULT NULL,
  `address` text,
  `guardian_name` varchar(100) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `students_ibfk_1` FOREIGN KEY (`id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `students`
--

LOCK TABLES `students` WRITE;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` VALUES (20,22,'sample address','Aslam Khan','Female'),(31,19,'H#326,Street#51','M.Azeem Akhtar','Female'),(37,20,'student 1 . sample address','Student1 Guardian','Female'),(44,19,'heheheheh','Hahahahaha','Female'),(45,12,'demo','demo','demo');
/*!40000 ALTER TABLE `students` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `teachers`
--

DROP TABLE IF EXISTS `teachers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `teachers` (
  `id` int NOT NULL,
  `qualification` varchar(100) DEFAULT NULL,
  `specialization` varchar(100) DEFAULT NULL,
  `joining_date` date DEFAULT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `teachers_ibfk_1` FOREIGN KEY (`id`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `teachers`
--

LOCK TABLES `teachers` WRITE;
/*!40000 ALTER TABLE `teachers` DISABLE KEYS */;
INSERT INTO `teachers` VALUES (22,'Qualification','Specialization','2025-09-06'),(32,'MS English','Quran','2025-06-16'),(38,'t1','t1P','2025-08-09');
/*!40000 ALTER TABLE `teachers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `users` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `userType` enum('Admin','Donor','Student','Teacher') NOT NULL,
  `contact` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=46 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'Rufah','Admin','0311-xxxx-186','rufahgilani@gmail.com','Rufah','1234'),(3,' sara','Student','  0320-xxxx-128',' sara@gmail.com','saaara',' 1234'),(4,'testing','Donor','0000000000','test@mail.com','testinghaha','1212'),(6,'zexa','Student','012234556','Email','100mg','Password'),(7,'Aayan','Student','0311xxxxxxxx','aayan@gmail.com','IonicBond','0000'),(13,'Maira Gilani','Donor','mg_maira','mg@gmail.com','0123-456789','mg_maira'),(20,'Maha Khan','Student','01123456','maha@gmail.com','miscellinious','0000'),(22,'Full Name','Teacher','Contact','testinghehe','Username','Password'),(27,'name','Admin','Contact','Email@gmail.com','User123','Password'),(28,'Aasima Owais','Admin','03209595128','aasima.owais1@gmail.com','_aasima','aayan0987'),(31,'Malaika Azeem','Student','034629186780','malaika@gmail.com','_malaika','0000'),(32,'leah Adamms','Teacher','011234567','leah@gmail.com','_leah','0000'),(34,'Full Name','Donor','Username','Email.com','Contact','Username'),(36,'Full Name','Admin','Contact','qwerty','hello','0101'),(37,'Student1','Student','03009812345','student1@gmail.com','_student','0000'),(38,'teacher 1 ','Teacher','000000000','teacher1@gmail.com','teacher1','0000'),(39,'Donor1','Donor','d1','donor1@gmail.com','03105109895','d1'),(41,'Donor','Donor','d1_donor','donor@gmail.com','012034057392','d1_donor'),(42,'newDonor','Donor','_donor2','d@gmail.com','1234987467','_donor2'),(43,'SampleDonor','Donor','12098765','donor3@gmail.com','sampled','0000'),(44,'Mahi','Student','098765456','mahi@gmail.com','_mahei','980'),(45,'demo','Student','demo','demo','demo','demo');
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

-- Dump completed on 2025-08-25 15:37:45
