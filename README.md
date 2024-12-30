# Spring boot 3 Ehcache example with cachemanager
Example code of using ehcache manager with spring boot 3

## Local Setup steps:
* Step 1. Set environment variables
  
  ``` DB_PASSWORD=<replace with database password>; DB_USER_NAME=<replace with database user name>```
  
* Step 2. Run the following is the DDL for the creation t_employee tabe:
  
  ``` CREATE TABLE `t_employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(100) DEFAULT NULL,
  `last_name` varchar(100) DEFAULT NULL,
  `date_of_birth` date DEFAULT NULL,
  `date_of_joining` date DEFAULT NULL,
  `date_of_termination` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='Employee table'; ```
