"# basic-spring-mvc-and-hibernate-project" 
  
  Customer Relationship Management - CRM APP
  
  Full working Spring MVC and Hibernate application that connects to database. Added AOP logging support.
  
  Features:
    - List customers
    - Add a new customer
    - Update customer
    - Delete customer
    
 sql-sript:

CREATE DATABASE  IF NOT EXISTS `web_customer_tracker`;
USE `web_customer_tracker`;

Database: web_customer_tracker
-- ------------------------------------------------------

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
CREATE TABLE `customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=latin1;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` VALUES 
	(1,'Ács','Milán','acsmilan@gmail.com'),
	(2,'Balaton','Boglárka','bboglar@freemail.hu'),
	(3,'Bors','Menta','borsmenta@citromail.hu'),
	(4,'Erdő','Benő','ebeno@gmail.com'),
    	(5,'Harci','Marci','hmarci@freemail.hu'),
	(6,'Lekvár','Titán','ltitan@hotmail.com');


