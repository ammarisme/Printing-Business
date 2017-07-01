/*
 * copyright Ammar Bin Ameerdeen
 * All rights reserved
 */
package printare_system;

/**
 * @author Ammar Bin Ameerdeen
 * 
 * This class contains scripts to execute.
 * Contains 2 types of scripts.
 * Data definition script - public final String script
 * Data population script - public final String data
 * 
 * Constructor initializes both script strings. Requires the database class to exist.
 *
 */


public class Script {
    public final String script =
"DROP SCHEMA IF EXISTS "+Database.databaseName+" ;CREATE SCHEMA IF NOT EXISTS "+Database.databaseName+" DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;USE "+Database.databaseName+" ;"+
"DROP TABLE IF EXISTS "+Database.databaseName+".`product_category` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`product_category` (" +
"  `name` VARCHAR(45) NOT NULL," +
"  PRIMARY KEY (`name`))" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`product` ;" +
"CREATE TABLE IF NOT EXISTS `printare`.`product` (" +
"  `name` VARCHAR(45) NOT NULL," +
"  `price` INT NULL," +
"  `description` VARCHAR(45) NULL," +
"  `stock` INT NULL," +
"  `cost` VARCHAR(45) NULL," +
"  `product_category_name` VARCHAR(45) NOT NULL," +
"  `minimum_stock` INT(11) NULL DEFAULT 0," +
"  PRIMARY KEY (`name`)," +
"  INDEX `fk_product_product_category1_idx` (`product_category_name` ASC)," +
"  CONSTRAINT `fk_product_product_category1`" +
"    FOREIGN KEY (`product_category_name`)" +
"    REFERENCES `printare`.`product_category` (`name`)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION)" +
"ENGINE = InnoDB ;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`grn` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`grn` (" +
"  `id` INT NOT NULL AUTO_INCREMENT," +
"  `date` DATE NULL," +
"  `status` VARCHAR(45) NULL," +
"  `note` VARCHAR(45) NULL," +
"  PRIMARY KEY (`id`))" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`product_in_grn` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`product_in_grn` (" +
"  `id` INT NOT NULL AUTO_INCREMENT," +
"  `grn_id` INT NOT NULL," +
"  `quantity` INT NULL," +
"  `product_name` VARCHAR(45) NOT NULL," +
"  PRIMARY KEY (`id`)," +
"  INDEX `fk_product_in_grn_grn_idx` (`grn_id` ASC)," +
"  INDEX `fk_product_in_grn_product1_idx` (`product_name` ASC)," +
"  CONSTRAINT `fk_product_in_grn_grn`" +
"    FOREIGN KEY (`grn_id`)" +
"    REFERENCES "+Database.databaseName+".`grn` (`id`)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION," +
"  CONSTRAINT `fk_product_in_grn_product1`" +
"    FOREIGN KEY (`product_name`)" +
"    REFERENCES "+Database.databaseName+".`product` (`name`)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION)" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`customer` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`customer` (" +
"  `id` INT NOT NULL AUTO_INCREMENT," +
"  `name` VARCHAR(45) NULL," +
"  PRIMARY KEY (`id`))" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`business` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`business` (" +
"  `name` VARCHAR(45) NOT NULL," +
"  `id` INT(11) NULL," +
"  PRIMARY KEY (`name`))" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`order` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`order` (" +
"  `id` INT NOT NULL AUTO_INCREMENT," +
"  `customer_id` INT NOT NULL," +
"  `status` VARCHAR(45) NULL," +
"  `due_date` VARCHAR(45) NULL," +
"  `ordered_date` VARCHAR(45) NULL," +
"  `business_name` VARCHAR(45) NOT NULL," +
"  PRIMARY KEY (`id`)," +
"  INDEX `fk_order_customer1_idx` (`customer_id` ASC)," +
"  INDEX `fk_order_business1_idx` (`business_name` ASC)," +
"  CONSTRAINT `fk_order_customer1`" +
"    FOREIGN KEY (`customer_id`)" +
"    REFERENCES "+Database.databaseName+".`customer` (`id`)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION," +
"  CONSTRAINT `fk_order_business1`" +
"    FOREIGN KEY (`business_name`)" +
"    REFERENCES "+Database.databaseName+".`business` (`name`)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION)" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`item_sale` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`item_sale` (" +
"  `customer_id` INT NOT NULL," +
"  `date` VARCHAR(45) NULL," +
"  `id` INT(11) NOT NULL AUTO_INCREMENT," +
"  INDEX `fk_ordered_product_customer1_idx` (`customer_id` ASC)," +
"  PRIMARY KEY (`id`)," +
"  CONSTRAINT `fk_ordered_product_customer1`" +
"    FOREIGN KEY (`customer_id`)" +
"    REFERENCES "+Database.databaseName+".`customer` (`id`)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION)" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`material_detail` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`material_detail` (" +
"  `name` VARCHAR(45) NOT NULL," +
"  `stock` INT(11) NULL," +
"  PRIMARY KEY (`name`))" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`utility_bill` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`utility_bill` (" +
"  `type` VARCHAR(45) NOT NULL," +
"  PRIMARY KEY (`type`))" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`payment` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`payment` (" +
"  `id` INT NOT NULL AUTO_INCREMENT," +
"  `status` VARCHAR(45) NULL," +
"  `amount` INT NULL," +
"  `account_number` VARCHAR(45) NULL," +
"  `date` VARCHAR(45) NULL," +
"  `customer_id` INT NOT NULL DEFAULT 1," +
"  `utility_bill_type` VARCHAR(45) NOT NULL," +
"  PRIMARY KEY (`id`)," +
"  INDEX `fk_payment_customer1_idx` (`customer_id` ASC)," +
"  INDEX `fk_payment_utility_bill1_idx` (`utility_bill_type` ASC)," +
"  CONSTRAINT `fk_payment_customer1`" +
"    FOREIGN KEY (`customer_id`)" +
"    REFERENCES "+Database.databaseName+".`customer` (`id`)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION," +
"  CONSTRAINT `fk_payment_utility_bill1`" +
"    FOREIGN KEY (`utility_bill_type`)" +
"    REFERENCES "+Database.databaseName+".`utility_bill` (`type`)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION)" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`project` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`project` (" +
"  `id` INT NOT NULL AUTO_INCREMENT," +
"  `name` VARCHAR(45) NULL," +
"  `starting_date` DATE NULL," +
"  `status` VARCHAR(45) NULL," +
"  `finishing_date` DATE NULL," +
"  `revenue` INT(11) NULL," +
"  `amount_recieved` INT(11) NULL," +
"  `cost` INT(11) NULL," +
"  PRIMARY KEY (`id`))" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`network_b` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`network_b` (" +
"  `name` VARCHAR(45) NOT NULL," +
"  `value` INT(11) NULL," +
"  `profit` INT(11) NULL," +
"  PRIMARY KEY (`name`))" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`card` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`card` (" +
"  `value` INT(11) NOT NULL," +
"  `profit` INT(11) NULL," +
"  `stock` INT(11) NULL DEFAULT 0," +
"  `network_b_name` VARCHAR(45) NOT NULL," +
"  INDEX `fk_card_network_b1_idx` (`network_b_name` ASC)," +
"  PRIMARY KEY (`network_b_name`, `value`)," +
"  CONSTRAINT `fk_card_network_b1`" +
"    FOREIGN KEY (`network_b_name`)" +
"    REFERENCES "+Database.databaseName+".`network_b` (`name`)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION)" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`reload_sent` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`reload_sent` (" +
"  `id` INT NOT NULL AUTO_INCREMENT," +
"  `amount` INT NULL," +
"  `date` DATE NULL," +
"  `network_b_name` VARCHAR(45) NOT NULL," +
"  PRIMARY KEY (`id`)," +
"  INDEX `fk_reload_sent_network_b1_idx` (`network_b_name` ASC)," +
"  CONSTRAINT `fk_reload_sent_network_b1`" +
"    FOREIGN KEY (`network_b_name`)" +
"    REFERENCES "+Database.databaseName+".`network_b` (`name`)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION)" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`card_sold` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`card_sold` (" +
"  `id` INT NOT NULL AUTO_INCREMENT," +
"  `date` VARCHAR(45) NULL," +
"  `card_network_b_name` VARCHAR(45) NOT NULL," +
"  `card_value` INT(11) NOT NULL," +
"  `quantity` INT(11) NULL," +
"  PRIMARY KEY (`id`)," +
"  INDEX `fk_card_sold_card1_idx` (`card_network_b_name` ASC, `card_value` ASC)," +
"  CONSTRAINT `fk_card_sold_card1`" +
"    FOREIGN KEY (`card_network_b_name` , `card_value`)" +
"    REFERENCES "+Database.databaseName+".`card` (`network_b_name` , `value`)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION)" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`product_of_sale` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`product_of_sale` (" +
"  `Item_sale_id` INT(11) NOT NULL," +
"  `product_name` VARCHAR(45) NOT NULL," +
"  `quantity` INT(11) NULL," +
"  INDEX `fk_prodcut_of_sale_Item_sale1_idx` (`Item_sale_id` ASC)," +
"  INDEX `fk_prodcut_of_sale_product1_idx` (`product_name` ASC)," +
"  CONSTRAINT `fk_prodcut_of_sale_Item_sale1`" +
"    FOREIGN KEY (`Item_sale_id`)" +
"    REFERENCES "+Database.databaseName+".`item_sale` (`id`)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION," +
"  CONSTRAINT `fk_prodcut_of_sale_product1`" +
"    FOREIGN KEY (`product_name`)" +
"    REFERENCES "+Database.databaseName+".`product` (`name`)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION)" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`supplier` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`supplier` (" +
"  `id` INT NOT NULL," +
"  `name` VARCHAR(45) NULL," +
"  PRIMARY KEY (`id`))" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`material_load` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`material_load` (" +
"  `id` INT NOT NULL AUTO_INCREMENT," +
"  `date` DATE NULL," +
"  `supplier_id` INT NOT NULL," +
"  PRIMARY KEY (`id`)," +
"  INDEX `fk_material_load_supplier1_idx` (`supplier_id` ASC)," +
"  CONSTRAINT `fk_material_load_supplier1`" +
"    FOREIGN KEY (`supplier_id`)" +
"    REFERENCES "+Database.databaseName+".`supplier` (`id`)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION)" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`material_of_load` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`material_of_load` (" +
"  `material_load_id` INT NOT NULL," +
"  `material_name` VARCHAR(45) NOT NULL," +
"  INDEX `fk_material_of_load_material_load1_idx` (`material_load_id` ASC)," +
"  INDEX `fk_material_of_load_material1_idx` (`material_name` ASC)," +
"  CONSTRAINT `fk_material_of_load_material_load1`" +
"    FOREIGN KEY (`material_load_id`)" +
"    REFERENCES "+Database.databaseName+".`material_load` (`id`)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION," +
"  CONSTRAINT `fk_material_of_load_material1`" +
"    FOREIGN KEY (`material_name`)" +
"    REFERENCES "+Database.databaseName+".`material_detail` (`name`)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION)" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`print_order` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`print_order` (" +
"  `id` INT NOT NULL AUTO_INCREMENT," +
"  `width` INT(11) NULL," +
"  `height` INT(11) NULL," +
"  `order_id` INT NOT NULL," +
"  PRIMARY KEY (`id`)," +
"  INDEX `fk_print_order_order1_idx` (`order_id` ASC)," +
"  CONSTRAINT `fk_print_order_order1`" +
"    FOREIGN KEY (`order_id`)" +
"    REFERENCES "+Database.databaseName+".`order` (`id`)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION)" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`material_print` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`material_print` (" +
"  `quantity` INT NULL," +
"  `material_name` VARCHAR(45) NOT NULL," +
"  `print_order_id` INT NOT NULL," +
"  INDEX `fk_material_print_material1_idx` (`material_name` ASC)," +
"  INDEX `fk_material_print_print_order1_idx` (`print_order_id` ASC)," +
"  CONSTRAINT `fk_material_print_material1`" +
"    FOREIGN KEY (`material_name`)" +
"    REFERENCES "+Database.databaseName+".`material_detail` (`name`)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION," +
"  CONSTRAINT `fk_material_print_print_order1`" +
"    FOREIGN KEY (`print_order_id`)" +
"    REFERENCES "+Database.databaseName+".`print_order` (`id`)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION)" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`service_category` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`service_category` (" +
"  `name` VARCHAR(45) NOT NULL," +
"  PRIMARY KEY (`name`))" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`service` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`service` (" +
"  `name` VARCHAR(45) NOT NULL," +
"  `price` VARCHAR(45) NULL," +
"  `cost` VARCHAR(45) NULL," +
"  `description` VARCHAR(45) NULL," +
"  `service_category_name` VARCHAR(45) NOT NULL," +
"  PRIMARY KEY (`name`)," +
"  INDEX `fk_services_service_category1_idx` (`service_category_name` ASC)," +
"  CONSTRAINT `fk_services_service_category1`" +
"    FOREIGN KEY (`service_category_name`)" +
"    REFERENCES "+Database.databaseName+".`service_category` (`name`)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION)" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`service_sale` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`service_sale` (" +
"  `id` INT NOT NULL AUTO_INCREMENT," +
"  `customer_id` INT NOT NULL," +
"  `date` DATE NULL," +
"  PRIMARY KEY (`id`)," +
"  INDEX `fk_service_sale_customer1_idx` (`customer_id` ASC)," +
"  CONSTRAINT `fk_service_sale_customer1`" +
"    FOREIGN KEY (`customer_id`)" +
"    REFERENCES "+Database.databaseName+".`customer` (`id`)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION)" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`services_of_sale` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`services_of_sale` (" +
"  `service_name` VARCHAR(45) NOT NULL," +
"  `service_sale_id` INT NOT NULL," +
"  `income` INT(11) NULL," +
"  INDEX `fk_services_of_sale_service1_idx` (`service_name` ASC)," +
"  INDEX `fk_services_of_sale_service_sale1_idx` (`service_sale_id` ASC)," +
"  CONSTRAINT `fk_services_of_sale_service1`" +
"    FOREIGN KEY (`service_name`)" +
"    REFERENCES "+Database.databaseName+".`service` (`name`)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION," +
"  CONSTRAINT `fk_services_of_sale_service_sale1`" +
"    FOREIGN KEY (`service_sale_id`)" +
"    REFERENCES "+Database.databaseName+".`service_sale` (`id`)" +
"    ON DELETE NO ACTION" +
"    ON UPDATE NO ACTION)" +
"ENGINE = InnoDB;" +
"DROP TABLE IF EXISTS "+Database.databaseName+".`notification` ;" +
"CREATE TABLE IF NOT EXISTS "+Database.databaseName+".`notification` (" +
"  `id` INT NOT NULL AUTO_INCREMENT," +
"  `title` VARCHAR(45) NULL," +
"  `text` VARCHAR(200) NULL," +
"  `link` VARCHAR(45) NULL," +
"  `start_date` DATE NULL," +
"  `stop_date` DATE NULL," +
"  `notified` TINYINT(1) NOT NULL DEFAULT false," +
"  PRIMARY KEY (`id`, `notified`))" +
"ENGINE = InnoDB;" +
"" +
"CREATE TABLE IF NOT EXISTS `printare`.`notification` (" +
"  `id` INT NOT NULL AUTO_INCREMENT," +
"  `title` VARCHAR(45) NULL," +
"  `text` VARCHAR(200) NULL," +
"  `link` VARCHAR(45) NULL," +
"  `start_date` DATE NULL," +
"  `stop_date` DATE NULL," +
"  `notified` TINYINT(1) NOT NULL DEFAULT false," +
"  `temporary` TINYINT(1) NULL DEFAULT true," +
"  PRIMARY KEY (`id`, `notified`))" +
"ENGINE = InnoDB" ;
    
    String data = "INSERT INTO "+Database.databaseName+".`product_category` (`name`) VALUES ('Electronic');" +
"INSERT INTO "+Database.databaseName+".`product_category` (`name`) VALUES ('Non electronic');" +
"INSERT INTO "+Database.databaseName+".`customer` (`id`, `name`) VALUES ('1', 'Default');" +
"INSERT INTO "+Database.databaseName+".`network_b` (`name`, `value`, `profit`) VALUES ('Etisalat', '0', '5');" +
"INSERT INTO "+Database.databaseName+".`network_b` (`name`, `value`, `profit`) VALUES ('Airtel', '0', '5');" +
"INSERT INTO "+Database.databaseName+".`network_b` (`name`, `value`, `profit`) VALUES ('Dialog', '0', '5');" +
"INSERT INTO "+Database.databaseName+".`network_b` (`name`, `value`, `profit`) VALUES ('Hutch', '0', '5');" +
"INSERT INTO "+Database.databaseName+".`card` (`value`, `profit`, `stock`, `network_b_name`) VALUES ('50', '2', '0', 'Etisalat');" +
"INSERT INTO "+Database.databaseName+".`card` (`value`, `profit`, `stock`, `network_b_name`) VALUES ('100', '5', '0', 'Etisalat');" +
"INSERT INTO "+Database.databaseName+".`card` (`value`, `profit`, `stock`, `network_b_name`) VALUES ('49', '3', '0', 'Etisalat');" +
"INSERT INTO "+Database.databaseName+".`card` (`value`, `profit`, `stock`, `network_b_name`) VALUES ('99', '5', '0', 'Etisalat');" +
"INSERT INTO "+Database.databaseName+".`card` (`value`, `profit`, `stock`, `network_b_name`) VALUES ('200', '10', '0', 'Etisalat');" +
"INSERT INTO "+Database.databaseName+".`card` (`value`, `profit`, `stock`, `network_b_name`) VALUES ('199', '10', '0', 'Etisalat');" +
"INSERT INTO "+Database.databaseName+".`card` (`value`, `profit`, `stock`, `network_b_name`) VALUES ('50', '2', '0', 'Airtel');" +
"INSERT INTO "+Database.databaseName+".`card` (`value`, `profit`, `stock`, `network_b_name`) VALUES ('100', '5', '0', 'Airtel');" +
"INSERT INTO "+Database.databaseName+".`card` (`value`, `profit`, `stock`, `network_b_name`) VALUES ('49', '3', '0', 'Airtel');" +
"INSERT INTO "+Database.databaseName+".`card` (`value`, `profit`, `stock`, `network_b_name`) VALUES ('99', '5', '0', 'Airtel');" +
"INSERT INTO "+Database.databaseName+".`card` (`value`, `profit`, `stock`, `network_b_name`) VALUES ('200', '10', '0', 'Airtel');" +
"INSERT INTO "+Database.databaseName+".`card` (`value`, `profit`, `stock`, `network_b_name`) VALUES ('199', '10', '0', 'Airtel');" +
"INSERT INTO "+Database.databaseName+".`card` (`value`, `profit`, `stock`, `network_b_name`) VALUES ('50', '2', '0', 'Dialog');" +
"INSERT INTO "+Database.databaseName+".`card` (`value`, `profit`, `stock`, `network_b_name`) VALUES ('100', '5', '0', 'Dialog');" +
"INSERT INTO "+Database.databaseName+".`card` (`value`, `profit`, `stock`, `network_b_name`) VALUES ('49', '3', '0', 'Dialog');" +
"INSERT INTO "+Database.databaseName+".`card` (`value`, `profit`, `stock`, `network_b_name`) VALUES ('99', '5', '0', 'Dialog');" +
"INSERT INTO "+Database.databaseName+".`card` (`value`, `profit`, `stock`, `network_b_name`) VALUES ('200', '10', '0', 'Dialog');" +
"INSERT INTO "+Database.databaseName+".`card` (`value`, `profit`, `stock`, `network_b_name`) VALUES ('199', '10', '0', 'Dialog');" +
"INSERT INTO "+Database.databaseName+".`card` (`value`, `profit`, `stock`, `network_b_name`) VALUES ('50', '2', '0', 'Hutch');" +
"INSERT INTO "+Database.databaseName+".`card` (`value`, `profit`, `stock`, `network_b_name`) VALUES ('100', '5', '0', 'Hutch');" +
"INSERT INTO "+Database.databaseName+".`card` (`value`, `profit`, `stock`, `network_b_name`) VALUES ('49', '3', '0', 'Hutch');" +
"INSERT INTO "+Database.databaseName+".`card` (`value`, `profit`, `stock`, `network_b_name`) VALUES ('99', '5', '0', 'Hutch');" +
"INSERT INTO "+Database.databaseName+".`card` (`value`, `profit`, `stock`, `network_b_name`) VALUES ('200', '10', '0', 'Hutch');" +
"INSERT INTO "+Database.databaseName+".`card` (`value`, `profit`, `stock`, `network_b_name`) VALUES ('199', '10', '0', 'Hutch');" +
"INSERT INTO "+Database.databaseName+".`utility_bill` (`type`) VALUES ('Water');" +
"INSERT INTO "+Database.databaseName+".`utility_bill` (`type`) VALUES ('Electricity');" +
"INSERT INTO "+Database.databaseName+".`utility_bill` (`type`) VALUES ('SLT');" +
"INSERT INTO "+Database.databaseName+".`service_category` (`name`) VALUES ('General');" +
"INSERT INTO "+Database.databaseName+".`service_category` (`name`) VALUES ('Premium');" +
"INSERT INTO "+Database.databaseName+".`service_category` (`name`) VALUES ('Free');" +
"INSERT INTO "+Database.databaseName+".`supplier` (`id`, `name`) VALUES ('1', 'Default');" +
"INSERT INTO "+Database.databaseName+".`business` (`name`, `id`) VALUES ('print', '25');" +
"INSERT INTO "+Database.databaseName+".`notification` (`title`, `text`, `notified`) VALUES ('Product Low', 'Some products are critically low. Please click here for info.', '0');"+
"INSERT INTO "+Database.databaseName+".`notification` (`title`, `text`, `notified`) VALUES ('Software Update', 'Updates available.', '0');"+
"INSERT INTO "+Database.databaseName+".`notification` (`title`, `text`, `notified`) VALUES ('Orders Due', 'You have orders due today', '0');"+
"INSERT INTO "+Database.databaseName+".`notification` (`title`, `text`, `notified`) VALUES ('Service Requests', 'There are service request updates for you', '0');"+
"INSERT INTO "+Database.databaseName+".`notification` (`id`,`title`,`text`,`link`,`start_date`,`stop_date`,`notified`) VALUES (1,'Product Low','Some products are critically low. Please click here for info.',NULL,NULL,NULL,0);"+
"INSERT INTO "+Database.databaseName+".`notification` (`id`,`title`,`text`,`link`,`start_date`,`stop_date`,`notified`) VALUES (2,'Software Update','Updates available.',NULL,NULL,NULL,0);"+
"INSERT INTO "+Database.databaseName+".`notification` (`id`,`title`,`text`,`link`,`start_date`,`stop_date`,`notified`) VALUES (3,'Orders Due','You have orders due today',NULL,NULL,NULL,0);"+
"INSERT INTO "+Database.databaseName+".`notification` (`id`,`title`,`text`,`link`,`start_date`,`stop_date`,`notified`) VALUES (4,'Service Requests','There are service request updates for you',NULL,NULL,NULL,0);";
;
}
