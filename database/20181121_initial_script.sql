drop table if exists dish_ingredient_details;
drop table if exists dishes;
drop table if exists dimensions;

CREATE TABLE `dimensions` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL DEFAULT "",
  `is_standard` TINYINT(1) DEFAULT 1,
  `coefficient` FLOAT(10,2) default '1.00',
   PRIMARY KEY (`id`),
   UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED KEY_BLOCK_SIZE=8;

INSERT INTO dimensions VALUES(null, 'item', 1, 1);
INSERT INTO dimensions VALUES(null, 'gram', 1, 1);
INSERT INTO dimensions VALUES(null, 'spoon', 1, 1);

drop table if exists ingredients;

CREATE TABLE `ingredients` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL DEFAULT "",
  `description` MEDIUMTEXT default NULL,
   PRIMARY KEY (`id`),
   UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED KEY_BLOCK_SIZE=8;

INSERT INTO ingredients VALUES(null, 'egg', '');
INSERT INTO ingredients VALUES(null, 'tomato', '');
INSERT INTO ingredients VALUES(null, 'potato', '');

drop table if exists dish_categories;

CREATE TABLE `dish_categories` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL DEFAULT "",
   PRIMARY KEY (`id`),
   UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED KEY_BLOCK_SIZE=8;

INSERT INTO dish_categories VALUES(null, 'Favourite');
INSERT INTO dish_categories VALUES(null, 'Tasty');
INSERT INTO dish_categories VALUES(null, 'Want to try');

drop table if exists dishes;

CREATE TABLE `dishes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(32) NOT NULL DEFAULT "",
  `recipe` MEDIUMTEXT NOT NULL DEFAULT "",
  `category_id` int(11) NOT NULL,
  `how_to_serve` MEDIUMTEXT default NULL,
  `comment` MEDIUMTEXT default NULL,
  `image` MEDIUMBLOB default NULL,
  `link_to_website` MEDIUMTEXT default NULL,
   PRIMARY KEY (`id`),
   KEY `category_id` (`category_id`),
   CONSTRAINT `TICategories_fk_2` FOREIGN KEY (`category_id`) REFERENCES `dish_categories` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED KEY_BLOCK_SIZE=8;

drop table if exists dish_ingredient_details;

CREATE TABLE `dish_ingredient_details` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dish_id` int(11) NOT NULL,
  `dimension_id` int(11) NOT NULL,
  `ingredient_id` int(11) NOT NULL,
  `amount` float DEFAULT NULL,
  `comment` mediumtext DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `dish_id` (`dish_id`),
  KEY `dimension_id` (`dimension_id`),
  KEY `ingredient_id` (`ingredient_id`),
  CONSTRAINT `TIDish_fk_1` FOREIGN KEY (`dish_id`) REFERENCES `dishes` (`id`),
  CONSTRAINT `TIdimensions_fk_2` FOREIGN KEY (`dimension_id`) REFERENCES `dimensions` (`id`),
  CONSTRAINT `TIIngredients_fk_3` FOREIGN KEY (`ingredient_id`) REFERENCES `ingredients` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=COMPRESSED KEY_BLOCK_SIZE=8;