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
