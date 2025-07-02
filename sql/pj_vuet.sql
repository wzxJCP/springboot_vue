-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: pj_vuet
-- ------------------------------------------------------
-- Server version	8.0.31

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `username` varchar(255) DEFAULT NULL COMMENT '账号',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `role` varchar(255) DEFAULT NULL COMMENT '角色',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='管理员信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES (1,'admin','admin123','管理员A','ADMIN','http://localhost:9090/files/download/1750940349435_2.jpg'),(2,'admin2','admin1123456','赵六A','EMP',NULL),(3,'adminA','adminA123456','王五','EMP',NULL),(5,'111','111123456','111','EMP',NULL);
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `article`
--

DROP TABLE IF EXISTS `article`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `article` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'id',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `img` varchar(255) DEFAULT NULL COMMENT '封面',
  `description` varchar(255) DEFAULT NULL COMMENT '简介',
  `content` longtext COMMENT '内容',
  `time` varchar(255) DEFAULT NULL COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='文章信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `article`
--

LOCK TABLES `article` WRITE;
/*!40000 ALTER TABLE `article` DISABLE KEYS */;
INSERT INTO `article` VALUES (14,'123213','http://localhost:9090/files/download/1751222964127_A.png','哒哒哒哒哒哒哒哒哒哒哒哒但是幅度反反复复凤飞啊啊啊啊啊啊啊啊啊啊啊啊啊自行车自行车现在V型在VS的更大','<h1 style=\"text-align: center;\"><strong>习近平会见塞内加尔总理松科</strong></h1><p style=\"text-align: left;\"><a href=\"https://author.baidu.com/home?from=bjh_article&amp;app_id=1582378850174815\" target=\"_blank\"><span style=\"color: rgb(51, 51, 51);\">新华社 </span></a>2025-06-27 14:58北京</p><p style=\"text-align: center;\"><img src=\"http://localhost:9090/files/download/1751274818815_A.png\" alt=\"\" data-href=\"\" style=\"width: 50%;\"></p><p>6月27日上午，国家主席习近平在北京人民大会堂会见来华出席夏季达沃斯论坛的塞内加尔总理松科。新华社记者 翟健岚 摄</p><p><u>松科转达法耶总统对习近平主席的诚挚问候。</u>松科表示，中国是塞内加尔可靠的合作伙伴，塞中双方始终相互尊重、团结互助，双边关系稳定坚韧，各领域合作进展良好。塞方坚定奉行一个中国原则，<span style=\"color: rgb(225, 60, 57);\">期待同中方深化全面战略合作伙伴关系</span>，推进共建“一带一路”，密切贸易、投资、能源等领域合作，助力塞经济社会发展。塞中两国都是全球南方成员，有着共同的价值追求，<span style=\"background-color: rgb(225, 60, 57);\">塞方愿同中方在国际地区事务中密切配合</span>，坚定做中国的战略伙伴，共同促进国际公平正义，维护全球南方共同利益。</p><p>王毅参加会见。</p>','2025-06-27 15:28:51'),(15,'34322','http://localhost:9090/files/download/1751222964127_A.png','大概答复','<h1 style=\"text-align: center;\"><strong>习近平会见塞内加尔总理松科</strong></h1><p style=\"text-align: left;\"><a href=\"https://author.baidu.com/home?from=bjh_article&amp;app_id=1582378850174815\" target=\"_blank\"><span style=\"color: rgb(51, 51, 51);\">新华社 </span></a>2025-06-27 14:58北京</p><p style=\"text-align: center;\"><img src=\"http://localhost:9090/files/download/1751274818815_A.png\" alt=\"\" data-href=\"\" style=\"width: 50%;\"></p><p>6月27日上午，国家主席习近平在北京人民大会堂会见来华出席夏季达沃斯论坛的塞内加尔总理松科。新华社记者 翟健岚 摄</p><p><u>松科转达法耶总统对习近平主席的诚挚问候。</u>松科表示，中国是塞内加尔可靠的合作伙伴，塞中双方始终相互尊重、团结互助，双边关系稳定坚韧，各领域合作进展良好。塞方坚定奉行一个中国原则，<span style=\"color: rgb(225, 60, 57);\">期待同中方深化全面战略合作伙伴关系</span>，推进共建“一带一路”，密切贸易、投资、能源等领域合作，助力塞经济社会发展。塞中两国都是全球南方成员，有着共同的价值追求，<span style=\"background-color: rgb(225, 60, 57);\">塞方愿同中方在国际地区事务中密切配合</span>，坚定做中国的战略伙伴，共同促进国际公平正义，维护全球南方共同利益。</p><p>王毅参加会见。</p>','2025-06-28 15:28:51'),(16,'5643','http://localhost:9090/files/download/1751222964127_A.png','辅导费等等','<h1 style=\"text-align: center;\"><strong>习近平会见塞内加尔总理松科</strong></h1><p style=\"text-align: left;\"><a href=\"https://author.baidu.com/home?from=bjh_article&amp;app_id=1582378850174815\" target=\"_blank\"><span style=\"color: rgb(51, 51, 51);\">新华社 </span></a>2025-06-27 14:58北京</p><p style=\"text-align: center;\"><img src=\"http://localhost:9090/files/download/1751274818815_A.png\" alt=\"\" data-href=\"\" style=\"width: 50%;\"></p><p>6月27日上午，国家主席习近平在北京人民大会堂会见来华出席夏季达沃斯论坛的塞内加尔总理松科。新华社记者 翟健岚 摄</p><p><u>松科转达法耶总统对习近平主席的诚挚问候。</u>松科表示，中国是塞内加尔可靠的合作伙伴，塞中双方始终相互尊重、团结互助，双边关系稳定坚韧，各领域合作进展良好。塞方坚定奉行一个中国原则，<span style=\"color: rgb(225, 60, 57);\">期待同中方深化全面战略合作伙伴关系</span>，推进共建“一带一路”，密切贸易、投资、能源等领域合作，助力塞经济社会发展。塞中两国都是全球南方成员，有着共同的价值追求，<span style=\"background-color: rgb(225, 60, 57);\">塞方愿同中方在国际地区事务中密切配合</span>，坚定做中国的战略伙伴，共同促进国际公平正义，维护全球南方共同利益。</p><p>王毅参加会见。</p>','2025-06-29 15:28:51'),(17,'1233','http://localhost:9090/files/download/1751222964127_A.png','发给黄发个','<h1 style=\"text-align: center;\"><strong>习近平会见塞内加尔总理松科</strong></h1><p style=\"text-align: left;\"><a href=\"https://author.baidu.com/home?from=bjh_article&amp;app_id=1582378850174815\" target=\"_blank\"><span style=\"color: rgb(51, 51, 51);\">新华社 </span></a>2025-06-27 14:58北京</p><p style=\"text-align: center;\"><img src=\"http://localhost:9090/files/download/1751274818815_A.png\" alt=\"\" data-href=\"\" style=\"width: 50%;\"></p><p>6月27日上午，国家主席习近平在北京人民大会堂会见来华出席夏季达沃斯论坛的塞内加尔总理松科。新华社记者 翟健岚 摄</p><p><u>松科转达法耶总统对习近平主席的诚挚问候。</u>松科表示，中国是塞内加尔可靠的合作伙伴，塞中双方始终相互尊重、团结互助，双边关系稳定坚韧，各领域合作进展良好。塞方坚定奉行一个中国原则，<span style=\"color: rgb(225, 60, 57);\">期待同中方深化全面战略合作伙伴关系</span>，推进共建“一带一路”，密切贸易、投资、能源等领域合作，助力塞经济社会发展。塞中两国都是全球南方成员，有着共同的价值追求，<span style=\"background-color: rgb(225, 60, 57);\">塞方愿同中方在国际地区事务中密切配合</span>，坚定做中国的战略伙伴，共同促进国际公平正义，维护全球南方共同利益。</p><p>王毅参加会见。</p>','2025-06-27 15:28:51'),(18,'12355','http://localhost:9090/files/download/1751222964127_A.png','一天也','<h1 style=\"text-align: center;\"><strong>习近平会见塞内加尔总理松科</strong></h1><p style=\"text-align: left;\"><a href=\"https://author.baidu.com/home?from=bjh_article&amp;app_id=1582378850174815\" target=\"_blank\"><span style=\"color: rgb(51, 51, 51);\">新华社 </span></a>2025-06-27 14:58北京</p><p style=\"text-align: center;\"><img src=\"http://localhost:9090/files/download/1751274818815_A.png\" alt=\"\" data-href=\"\" style=\"width: 50%;\"></p><p>6月27日上午，国家主席习近平在北京人民大会堂会见来华出席夏季达沃斯论坛的塞内加尔总理松科。新华社记者 翟健岚 摄</p><p><u>松科转达法耶总统对习近平主席的诚挚问候。</u>松科表示，中国是塞内加尔可靠的合作伙伴，塞中双方始终相互尊重、团结互助，双边关系稳定坚韧，各领域合作进展良好。塞方坚定奉行一个中国原则，<span style=\"color: rgb(225, 60, 57);\">期待同中方深化全面战略合作伙伴关系</span>，推进共建“一带一路”，密切贸易、投资、能源等领域合作，助力塞经济社会发展。塞中两国都是全球南方成员，有着共同的价值追求，<span style=\"background-color: rgb(225, 60, 57);\">塞方愿同中方在国际地区事务中密切配合</span>，坚定做中国的战略伙伴，共同促进国际公平正义，维护全球南方共同利益。</p><p>王毅参加会见。</p>','2025-06-26 15:28:51'),(19,'1232','http://localhost:9090/files/download/1751222964127_A.png','规定发过的','<h1 style=\"text-align: center;\"><strong>习近平会见塞内加尔总理松科</strong></h1><p style=\"text-align: left;\"><a href=\"https://author.baidu.com/home?from=bjh_article&amp;app_id=1582378850174815\" target=\"_blank\"><span style=\"color: rgb(51, 51, 51);\">新华社 </span></a>2025-06-27 14:58北京</p><p style=\"text-align: center;\"><img src=\"http://localhost:9090/files/download/1751274818815_A.png\" alt=\"\" data-href=\"\" style=\"width: 50%;\"></p><p>6月27日上午，国家主席习近平在北京人民大会堂会见来华出席夏季达沃斯论坛的塞内加尔总理松科。新华社记者 翟健岚 摄</p><p><u>松科转达法耶总统对习近平主席的诚挚问候。</u>松科表示，中国是塞内加尔可靠的合作伙伴，塞中双方始终相互尊重、团结互助，双边关系稳定坚韧，各领域合作进展良好。塞方坚定奉行一个中国原则，<span style=\"color: rgb(225, 60, 57);\">期待同中方深化全面战略合作伙伴关系</span>，推进共建“一带一路”，密切贸易、投资、能源等领域合作，助力塞经济社会发展。塞中两国都是全球南方成员，有着共同的价值追求，<span style=\"background-color: rgb(225, 60, 57);\">塞方愿同中方在国际地区事务中密切配合</span>，坚定做中国的战略伙伴，共同促进国际公平正义，维护全球南方共同利益。</p><p>王毅参加会见。</p>','2025-06-25 15:28:51'),(20,'12388','http://localhost:9090/files/download/1751222964127_A.png','自行车咋','<h1 style=\"text-align: center;\"><strong>习近平会见塞内加尔总理松科</strong></h1><p style=\"text-align: left;\"><a href=\"https://author.baidu.com/home?from=bjh_article&amp;app_id=1582378850174815\" target=\"_blank\"><span style=\"color: rgb(51, 51, 51);\">新华社 </span></a>2025-06-27 14:58北京</p><p style=\"text-align: center;\"><img src=\"http://localhost:9090/files/download/1751274818815_A.png\" alt=\"\" data-href=\"\" style=\"width: 50%;\"></p><p>6月27日上午，国家主席习近平在北京人民大会堂会见来华出席夏季达沃斯论坛的塞内加尔总理松科。新华社记者 翟健岚 摄</p><p><u>松科转达法耶总统对习近平主席的诚挚问候。</u>松科表示，中国是塞内加尔可靠的合作伙伴，塞中双方始终相互尊重、团结互助，双边关系稳定坚韧，各领域合作进展良好。塞方坚定奉行一个中国原则，<span style=\"color: rgb(225, 60, 57);\">期待同中方深化全面战略合作伙伴关系</span>，推进共建“一带一路”，密切贸易、投资、能源等领域合作，助力塞经济社会发展。塞中两国都是全球南方成员，有着共同的价值追求，<span style=\"background-color: rgb(225, 60, 57);\">塞方愿同中方在国际地区事务中密切配合</span>，坚定做中国的战略伙伴，共同促进国际公平正义，维护全球南方共同利益。</p><p>王毅参加会见。</p>','2025-06-25 15:28:51'),(21,'1299','http://localhost:9090/files/download/1751222964127_A.png','一头痛医头','<h1 style=\"text-align: center;\"><strong>习近平会见塞内加尔总理松科</strong></h1><p style=\"text-align: left;\"><a href=\"https://author.baidu.com/home?from=bjh_article&amp;app_id=1582378850174815\" target=\"_blank\"><span style=\"color: rgb(51, 51, 51);\">新华社 </span></a>2025-06-27 14:58北京</p><p style=\"text-align: center;\"><img src=\"http://localhost:9090/files/download/1751274818815_A.png\" alt=\"\" data-href=\"\" style=\"width: 50%;\"></p><p>6月27日上午，国家主席习近平在北京人民大会堂会见来华出席夏季达沃斯论坛的塞内加尔总理松科。新华社记者 翟健岚 摄</p><p><u>松科转达法耶总统对习近平主席的诚挚问候。</u>松科表示，中国是塞内加尔可靠的合作伙伴，塞中双方始终相互尊重、团结互助，双边关系稳定坚韧，各领域合作进展良好。塞方坚定奉行一个中国原则，<span style=\"color: rgb(225, 60, 57);\">期待同中方深化全面战略合作伙伴关系</span>，推进共建“一带一路”，密切贸易、投资、能源等领域合作，助力塞经济社会发展。塞中两国都是全球南方成员，有着共同的价值追求，<span style=\"background-color: rgb(225, 60, 57);\">塞方愿同中方在国际地区事务中密切配合</span>，坚定做中国的战略伙伴，共同促进国际公平正义，维护全球南方共同利益。</p><p>王毅参加会见。</p>','2025-06-30 15:28:51'),(22,'1365','http://localhost:9090/files/download/1751222964127_A.png','偶遇也发','<h1 style=\"text-align: center;\"><strong>习近平会见塞内加尔总理松科</strong></h1><p style=\"text-align: left;\"><a href=\"https://author.baidu.com/home?from=bjh_article&amp;app_id=1582378850174815\" target=\"_blank\"><span style=\"color: rgb(51, 51, 51);\">新华社 </span></a>2025-06-27 14:58北京</p><p style=\"text-align: center;\"><img src=\"http://localhost:9090/files/download/1751274818815_A.png\" alt=\"\" data-href=\"\" style=\"width: 50%;\"></p><p>6月27日上午，国家主席习近平在北京人民大会堂会见来华出席夏季达沃斯论坛的塞内加尔总理松科。新华社记者 翟健岚 摄</p><p><u>松科转达法耶总统对习近平主席的诚挚问候。</u>松科表示，中国是塞内加尔可靠的合作伙伴，塞中双方始终相互尊重、团结互助，双边关系稳定坚韧，各领域合作进展良好。塞方坚定奉行一个中国原则，<span style=\"color: rgb(225, 60, 57);\">期待同中方深化全面战略合作伙伴关系</span>，推进共建“一带一路”，密切贸易、投资、能源等领域合作，助力塞经济社会发展。塞中两国都是全球南方成员，有着共同的价值追求，<span style=\"background-color: rgb(225, 60, 57);\">塞方愿同中方在国际地区事务中密切配合</span>，坚定做中国的战略伙伴，共同促进国际公平正义，维护全球南方共同利益。</p><p>王毅参加会见。</p>','2025-06-30 15:28:51'),(23,'6555','http://localhost:9090/files/download/1751222964127_A.png','辅导费等等','<h1 style=\"text-align: center;\"><strong>习近平会见塞内加尔总理松科</strong></h1><p style=\"text-align: left;\"><a href=\"https://author.baidu.com/home?from=bjh_article&amp;app_id=1582378850174815\" target=\"_blank\"><span style=\"color: rgb(51, 51, 51);\">新华社 </span></a>2025-06-27 14:58北京</p><p style=\"text-align: center;\"><img src=\"http://localhost:9090/files/download/1751274818815_A.png\" alt=\"\" data-href=\"\" style=\"width: 50%;\"></p><p>6月27日上午，国家主席习近平在北京人民大会堂会见来华出席夏季达沃斯论坛的塞内加尔总理松科。新华社记者 翟健岚 摄</p><p><u>松科转达法耶总统对习近平主席的诚挚问候。</u>松科表示，中国是塞内加尔可靠的合作伙伴，塞中双方始终相互尊重、团结互助，双边关系稳定坚韧，各领域合作进展良好。塞方坚定奉行一个中国原则，<span style=\"color: rgb(225, 60, 57);\">期待同中方深化全面战略合作伙伴关系</span>，推进共建“一带一路”，密切贸易、投资、能源等领域合作，助力塞经济社会发展。塞中两国都是全球南方成员，有着共同的价值追求，<span style=\"background-color: rgb(225, 60, 57);\">塞方愿同中方在国际地区事务中密切配合</span>，坚定做中国的战略伙伴，共同促进国际公平正义，维护全球南方共同利益。</p><p>王毅参加会见。</p>','2025-06-29 15:28:51'),(24,'1477','http://localhost:9090/files/download/1751222964127_A.png','发给黄发个','<h1 style=\"text-align: center;\"><strong>习近平会见塞内加尔总理松科</strong></h1><p style=\"text-align: left;\"><a href=\"https://author.baidu.com/home?from=bjh_article&amp;app_id=1582378850174815\" target=\"_blank\"><span style=\"color: rgb(51, 51, 51);\">新华社 </span></a>2025-06-27 14:58北京</p><p style=\"text-align: center;\"><img src=\"http://localhost:9090/files/download/1751274818815_A.png\" alt=\"\" data-href=\"\" style=\"width: 50%;\"></p><p>6月27日上午，国家主席习近平在北京人民大会堂会见来华出席夏季达沃斯论坛的塞内加尔总理松科。新华社记者 翟健岚 摄</p><p><u>松科转达法耶总统对习近平主席的诚挚问候。</u>松科表示，中国是塞内加尔可靠的合作伙伴，塞中双方始终相互尊重、团结互助，双边关系稳定坚韧，各领域合作进展良好。塞方坚定奉行一个中国原则，<span style=\"color: rgb(225, 60, 57);\">期待同中方深化全面战略合作伙伴关系</span>，推进共建“一带一路”，密切贸易、投资、能源等领域合作，助力塞经济社会发展。塞中两国都是全球南方成员，有着共同的价值追求，<span style=\"background-color: rgb(225, 60, 57);\">塞方愿同中方在国际地区事务中密切配合</span>，坚定做中国的战略伙伴，共同促进国际公平正义，维护全球南方共同利益。</p><p>王毅参加会见。</p>','2025-06-28 15:28:51'),(25,'1255','http://localhost:9090/files/download/1751222964127_A.png','一天也','<h1 style=\"text-align: center;\"><strong>习近平会见塞内加尔总理松科</strong></h1><p style=\"text-align: left;\"><a href=\"https://author.baidu.com/home?from=bjh_article&amp;app_id=1582378850174815\" target=\"_blank\"><span style=\"color: rgb(51, 51, 51);\">新华社 </span></a>2025-06-27 14:58北京</p><p style=\"text-align: center;\"><img src=\"http://localhost:9090/files/download/1751274818815_A.png\" alt=\"\" data-href=\"\" style=\"width: 50%;\"></p><p>6月27日上午，国家主席习近平在北京人民大会堂会见来华出席夏季达沃斯论坛的塞内加尔总理松科。新华社记者 翟健岚 摄</p><p><u>松科转达法耶总统对习近平主席的诚挚问候。</u>松科表示，中国是塞内加尔可靠的合作伙伴，塞中双方始终相互尊重、团结互助，双边关系稳定坚韧，各领域合作进展良好。塞方坚定奉行一个中国原则，<span style=\"color: rgb(225, 60, 57);\">期待同中方深化全面战略合作伙伴关系</span>，推进共建“一带一路”，密切贸易、投资、能源等领域合作，助力塞经济社会发展。塞中两国都是全球南方成员，有着共同的价值追求，<span style=\"background-color: rgb(225, 60, 57);\">塞方愿同中方在国际地区事务中密切配合</span>，坚定做中国的战略伙伴，共同促进国际公平正义，维护全球南方共同利益。</p><p>王毅参加会见。</p>','2025-06-30 15:28:51'),(26,'1477','http://localhost:9090/files/download/1751222964127_A.png','规定发过的','<h1 style=\"text-align: center;\"><strong>习近平会见塞内加尔总理松科</strong></h1><p style=\"text-align: left;\"><a href=\"https://author.baidu.com/home?from=bjh_article&amp;app_id=1582378850174815\" target=\"_blank\"><span style=\"color: rgb(51, 51, 51);\">新华社 </span></a>2025-06-27 14:58北京</p><p style=\"text-align: center;\"><img src=\"http://localhost:9090/files/download/1751274818815_A.png\" alt=\"\" data-href=\"\" style=\"width: 50%;\"></p><p>6月27日上午，国家主席习近平在北京人民大会堂会见来华出席夏季达沃斯论坛的塞内加尔总理松科。新华社记者 翟健岚 摄</p><p><u>松科转达法耶总统对习近平主席的诚挚问候。</u>松科表示，中国是塞内加尔可靠的合作伙伴，塞中双方始终相互尊重、团结互助，双边关系稳定坚韧，各领域合作进展良好。塞方坚定奉行一个中国原则，<span style=\"color: rgb(225, 60, 57);\">期待同中方深化全面战略合作伙伴关系</span>，推进共建“一带一路”，密切贸易、投资、能源等领域合作，助力塞经济社会发展。塞中两国都是全球南方成员，有着共同的价值追求，<span style=\"background-color: rgb(225, 60, 57);\">塞方愿同中方在国际地区事务中密切配合</span>，坚定做中国的战略伙伴，共同促进国际公平正义，维护全球南方共同利益。</p><p>王毅参加会见。</p>','2025-07-01 15:28:51'),(27,'1655','http://localhost:9090/files/download/1751222964127_A.png','自行车咋','<h1 style=\"text-align: center;\"><strong>习近平会见塞内加尔总理松科</strong></h1><p style=\"text-align: left;\"><a href=\"https://author.baidu.com/home?from=bjh_article&amp;app_id=1582378850174815\" target=\"_blank\"><span style=\"color: rgb(51, 51, 51);\">新华社 </span></a>2025-06-27 14:58北京</p><p style=\"text-align: center;\"><img src=\"http://localhost:9090/files/download/1751274818815_A.png\" alt=\"\" data-href=\"\" style=\"width: 50%;\"></p><p>6月27日上午，国家主席习近平在北京人民大会堂会见来华出席夏季达沃斯论坛的塞内加尔总理松科。新华社记者 翟健岚 摄</p><p><u>松科转达法耶总统对习近平主席的诚挚问候。</u>松科表示，中国是塞内加尔可靠的合作伙伴，塞中双方始终相互尊重、团结互助，双边关系稳定坚韧，各领域合作进展良好。塞方坚定奉行一个中国原则，<span style=\"color: rgb(225, 60, 57);\">期待同中方深化全面战略合作伙伴关系</span>，推进共建“一带一路”，密切贸易、投资、能源等领域合作，助力塞经济社会发展。塞中两国都是全球南方成员，有着共同的价值追求，<span style=\"background-color: rgb(225, 60, 57);\">塞方愿同中方在国际地区事务中密切配合</span>，坚定做中国的战略伙伴，共同促进国际公平正义，维护全球南方共同利益。</p><p>王毅参加会见。</p>','2025-06-29 15:28:51'),(28,'1874','http://localhost:9090/files/download/1751222964127_A.png','一头痛医头','<h1 style=\"text-align: center;\"><strong>习近平会见塞内加尔总理松科</strong></h1><p style=\"text-align: left;\"><a href=\"https://author.baidu.com/home?from=bjh_article&amp;app_id=1582378850174815\" target=\"_blank\"><span style=\"color: rgb(51, 51, 51);\">新华社 </span></a>2025-06-27 14:58北京</p><p style=\"text-align: center;\"><img src=\"http://localhost:9090/files/download/1751274818815_A.png\" alt=\"\" data-href=\"\" style=\"width: 50%;\"></p><p>6月27日上午，国家主席习近平在北京人民大会堂会见来华出席夏季达沃斯论坛的塞内加尔总理松科。新华社记者 翟健岚 摄</p><p><u>松科转达法耶总统对习近平主席的诚挚问候。</u>松科表示，中国是塞内加尔可靠的合作伙伴，塞中双方始终相互尊重、团结互助，双边关系稳定坚韧，各领域合作进展良好。塞方坚定奉行一个中国原则，<span style=\"color: rgb(225, 60, 57);\">期待同中方深化全面战略合作伙伴关系</span>，推进共建“一带一路”，密切贸易、投资、能源等领域合作，助力塞经济社会发展。塞中两国都是全球南方成员，有着共同的价值追求，<span style=\"background-color: rgb(225, 60, 57);\">塞方愿同中方在国际地区事务中密切配合</span>，坚定做中国的战略伙伴，共同促进国际公平正义，维护全球南方共同利益。</p><p>王毅参加会见。</p>','2025-06-30 15:28:51'),(29,'1258','http://localhost:9090/files/download/1751222964127_A.png','偶遇也发','<h1 style=\"text-align: center;\"><strong>习近平会见塞内加尔总理松科</strong></h1><p style=\"text-align: left;\"><a href=\"https://author.baidu.com/home?from=bjh_article&amp;app_id=1582378850174815\" target=\"_blank\"><span style=\"color: rgb(51, 51, 51);\">新华社 </span></a>2025-06-27 14:58北京</p><p style=\"text-align: center;\"><img src=\"http://localhost:9090/files/download/1751274818815_A.png\" alt=\"\" data-href=\"\" style=\"width: 50%;\"></p><p>6月27日上午，国家主席习近平在北京人民大会堂会见来华出席夏季达沃斯论坛的塞内加尔总理松科。新华社记者 翟健岚 摄</p><p><u>松科转达法耶总统对习近平主席的诚挚问候。</u>松科表示，中国是塞内加尔可靠的合作伙伴，塞中双方始终相互尊重、团结互助，双边关系稳定坚韧，各领域合作进展良好。塞方坚定奉行一个中国原则，<span style=\"color: rgb(225, 60, 57);\">期待同中方深化全面战略合作伙伴关系</span>，推进共建“一带一路”，密切贸易、投资、能源等领域合作，助力塞经济社会发展。塞中两国都是全球南方成员，有着共同的价值追求，<span style=\"background-color: rgb(225, 60, 57);\">塞方愿同中方在国际地区事务中密切配合</span>，坚定做中国的战略伙伴，共同促进国际公平正义，维护全球南方共同利益。</p><p>王毅参加会见。</p>','2025-07-01 15:28:51');
/*!40000 ALTER TABLE `article` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `department` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `deptname` varchar(255) DEFAULT NULL COMMENT '部门名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='部门信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `department`
--

LOCK TABLES `department` WRITE;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` VALUES (1,'人事部'),(2,'测试部'),(4,'开发部'),(5,'采购部'),(7,'外贸部');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `username` varchar(255) DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) DEFAULT NULL COMMENT '密码',
  `role` varchar(255) DEFAULT NULL COMMENT '角色',
  `name` varchar(255) DEFAULT NULL COMMENT '姓名',
  `sex` varchar(255) DEFAULT NULL COMMENT '性别',
  `no` varchar(255) DEFAULT NULL COMMENT '工号',
  `age` int DEFAULT NULL COMMENT '年龄',
  `description` longtext COMMENT '个人介绍',
  `department_id` int DEFAULT NULL COMMENT '所属部门ID',
  `avatar` varchar(255) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=95 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='员工信息表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES (2,'admin','admin123','EMP','小薇','女','001',31,'测试工程师帝国时代放大法守法手动阀三打哈代发件',2,'http://localhost:9090/files/download/1750938790432_2.jpg'),(4,'test','1223','EMP','李四AA','男','0041',35,'架构师帝国时代放大法守法手动阀三打哈代发件12',5,'http://localhost:9090/files/download/1750938790432_2.jpg'),(5,'test1','admin123','EMP','王五','男','003',32,'帝国时代放大法守法手动阀三打哈代发件',5,NULL),(6,'test2','admin123','EMP','赵六','男','006',30,'帝国时代放大法守法手动阀三打哈代发件',1,NULL),(7,'test3','admin123','EMP','小薇','女','002',31,'测试工程师帝国时代放大法守法手动阀三打哈代发件',7,NULL),(8,'test4','admin123','EMP','李四','男','004',33,'架构师',4,NULL),(9,'test5','admin123','EMP','王五','男','0031',32,'架构师',1,NULL),(10,'test6','admin123','EMP','赵六','男','021',30,'软件工程师',2,NULL),(11,'test7','admin123','EMP','小薇','女','022',31,'测试工程师',4,NULL),(12,'test8','admin123','EMP','李四','男','0015',33,'架构师',7,NULL),(13,'test9','admin123','EMP','王五','男','018',32,'架构师',2,NULL),(14,'test10','admin123','EMP','赵六','男','016',30,'软件工程师',5,NULL),(15,'test11','admin123','EMP','小薇','女','009',31,'测试工程师',5,NULL),(16,'test12','admin123','EMP','李四','男','014',33,'架构师',1,NULL),(17,'test13','admin123','EMP','王五','男','013',32,'架构师',7,NULL),(18,'test14','admin123','EMP','赵六','男','011',30,'软件工程师',4,NULL),(23,'test15','admin123','EMP','小李','男','012',30,'尔特地方收到感受得到废墟注册证陈大发干撒代发',4,NULL),(55,'admin12','admin12123456','EMP','小龙',NULL,'017',27,NULL,4,'http://localhost:9090/files/download/1750938790432_2.jpg'),(56,'asd','admin123','EMP','qqq',NULL,'023',NULL,NULL,7,'http://localhost:9090/files/download/1750938790432_2.jpg'),(57,'AA','AA123456','EMP','Axs','男','1222',21,'sdasda三大阿嘎嘎',5,'http://localhost:9090/files/download/1751222964127_A.png'),(64,'A','A123456','EMP','A',NULL,'1',NULL,NULL,2,NULL),(92,'BB','BB123456','EMP','BB1','男','0125',21,'sdasda三大阿嘎嘎',5,'http://localhost:9090/files/download/1751222964127_A.png'),(93,'CC','CC123456','EMP','CC1','女','0126',30,'撒旦撒风蚀高地信号蝶阀防擦女码高压塔',7,'http://localhost:9090/files/download/1750938790432_2.jpg'),(94,'CA','CA123456','EMP','VV1','男','0129',30,'水电费撒打算大师傅',1,'http://localhost:9090/files/download/1750938790432_2.jpg');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-07-02 11:28:20
