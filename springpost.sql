/*!40101 SET @OLD_CHARACTER_SET_CLIENT = @@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS = @@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION = @@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE = @@TIME_ZONE */;
/*!40103 SET TIME_ZONE = '+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS = @@UNIQUE_CHECKS, UNIQUE_CHECKS = 0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS = @@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS = 0 */;
/*!40101 SET @OLD_SQL_MODE = @@SQL_MODE, SQL_MODE = 'NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES = @@SQL_NOTES, SQL_NOTES = 0 */;

--
-- Table structure for table `comments`
--

DROP TABLE IF EXISTS `comments`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comments`
(
    `id`                 int(11)   NOT NULL AUTO_INCREMENT,
    `body`               text           DEFAULT NULL,
    `user_id`            int(11)        DEFAULT NULL,
    `post_id`            int(11)        DEFAULT NULL,
    `user_ip`            varchar(100)   DEFAULT NULL,
    `parents_comment_id` int(11)        DEFAULT NULL,
    `created_at`         timestamp NULL DEFAULT current_timestamp(),
    `updated_at`         timestamp NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `comments_FK_1` (`post_id`),
    KEY `comments_FK` (`user_id`),
    CONSTRAINT `comments_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`),
    CONSTRAINT `comments_FK_1` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `email_tokens`
--

DROP TABLE IF EXISTS `email_tokens`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `email_tokens`
(
    `id`         int(11)   NOT NULL AUTO_INCREMENT,
    `user_id`    int(11)        DEFAULT NULL,
    `token`      varchar(100)   DEFAULT NULL,
    `auth_at`    timestamp NULL DEFAULT NULL COMMENT '링크를 클릭한 시간',
    `state`      tinyint(1)     DEFAULT 1 COMMENT '1:회원가입\r\n2:비밀번호 변경',
    `sended_at`  timestamp NULL DEFAULT NULL COMMENT '인증 메일을 보낸 시간',
    `deleted_at` timestamp NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `email_tokens_FK` (`user_id`),
    CONSTRAINT `email_tokens_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `like`
--

DROP TABLE IF EXISTS `like`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `like`
(
    `id`      bigint(20) NOT NULL AUTO_INCREMENT,
    `post_id` int(11)    DEFAULT NULL,
    `user_id` int(11)    DEFAULT NULL,
    `type`    varchar(1) DEFAULT NULL COMMENT 'g = 좋아요 b = 싫어요',
    PRIMARY KEY (`id`),
    KEY `like_FK` (`post_id`),
    KEY `like_FK_1` (`user_id`),
    CONSTRAINT `like_FK` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
    CONSTRAINT `like_FK_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `post_tag`
--

DROP TABLE IF EXISTS `post_tag`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `post_tag`
(
    `post_id` int(11) DEFAULT NULL,
    `tag_id`  int(11) DEFAULT NULL,
    KEY `post_id` (`post_id`),
    KEY `tag_id` (`tag_id`),
    CONSTRAINT `post_tag_ibfk_1` FOREIGN KEY (`post_id`) REFERENCES `posts` (`id`),
    CONSTRAINT `post_tag_ibfk_2` FOREIGN KEY (`tag_id`) REFERENCES `tag` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `posts`
--

DROP TABLE IF EXISTS `posts`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `posts`
(
    `id`         int(11)   NOT NULL,
    `title`      varchar(100)   DEFAULT NULL,
    `body`       text           DEFAULT NULL,
    `user_id`    int(11)        DEFAULT NULL,
    `created_at` timestamp NULL DEFAULT current_timestamp(),
    `updated_at` timestamp NULL DEFAULT NULL,
    PRIMARY KEY (`id`),
    KEY `posts_FK` (`user_id`),
    CONSTRAINT `posts_FK` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `tag`
--

DROP TABLE IF EXISTS `tag`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tag`
(
    `id`         int(11)   NOT NULL,
    `name`       varchar(255)   DEFAULT NULL,
    `created_at` timestamp NULL DEFAULT current_timestamp(),
    `updated_at` timestamp NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user`
(
    `id`         int(11)   NOT NULL AUTO_INCREMENT,
    `email`      varchar(100)   DEFAULT NULL,
    `password`   varchar(100)   DEFAULT NULL,
    `name`       varchar(100)   DEFAULT NULL,
    `created_at` timestamp NULL DEFAULT current_timestamp(),
    `updated_at` timestamp NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 10
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `user_login_logs`
--

DROP TABLE IF EXISTS `user_login_logs`;
/*!40101 SET @saved_cs_client = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_login_logs`
(
    `id`         bigint(20) NOT NULL,
    `user_id`    int(11)         DEFAULT NULL,
    `user_ip`    varchar(15)     DEFAULT NULL,
    `user_agent` text            DEFAULT NULL,
    `created_at` timestamp  NULL DEFAULT current_timestamp(),
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping routines for database 'springpost'
--
/*!40103 SET TIME_ZONE = @OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE = @OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS = @OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS = @OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT = @OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS = @OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION = @OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES = @OLD_SQL_NOTES */;

-- Dump completed on 2022-07-19 17:15:47
