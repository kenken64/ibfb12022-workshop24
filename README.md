## Workshop 24
```
CREATE SCHEMA `shensang` ;
```

```
CREATE TABLE `purchase_order` (
  `order_id` char(8) NOT NULL,
  `notes` text,
  `order_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `customer_name` varchar(128) DEFAULT NULL,
  `shipping_address` varchar(128) DEFAULT NULL,
  `tax` decimal(2,2) DEFAULT '0.05',
  PRIMARY KEY (`order_id`)
)


```

```
CREATE TABLE `line_item` (
  `item_id` int NOT NULL AUTO_INCREMENT,
  `product` varchar(64) NOT NULL,
  `quantity` int DEFAULT '1',
  `order_id` char(8) NOT NULL,
  `unit_price` decimal(3,2) DEFAULT NULL,
  `discount` decimal(2,2) DEFAULT '0.10',
  PRIMARY KEY (`item_id`),
  KEY `fk_order_id_idx` (`order_id`),
  CONSTRAINT `fk_order_id` FOREIGN KEY (`order_id`) REFERENCES `purchase_order` (`order_id`)
) 


```

```
ALTER TABLE `shensang`.`purchase_order` 
CHANGE COLUMN `tax` `tax` DECIMAL(2,2) NULL DEFAULT 0.05 ;
```

```
ALTER TABLE `shensang`.`purchase_order`
CHANGE COLUMN `notes` `notes` TEXT NULL ;
```


## Configure Spring Boot App connect to Railway MySQL
1. Make sure pom uses the latest MySQL Connector J driver 

```
<dependency>
  <groupId>com.mysql</groupId>
  <artifactId>mysql-connector-j</artifactId>
  <scope>runtime</scope>
</dependency>
```
2. Make sure the application.properties setup with the following attributes

```
spring.datasource.url=${MYSQL_APP_URL}
spring.datasource.username=${MYSQL_APP_USER}
spring.datasource.password=${MYSQL_APP_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

3. Configure Railway App instance with the following env variables

![Railway Env Var](/images/railwayenv.png "Railway Env Variable")