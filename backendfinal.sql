-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 15, 2021 at 05:32 PM
-- Server version: 10.4.17-MariaDB
-- PHP Version: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `backendfinal`
--

DELIMITER $$
--
-- Procedures
--
CREATE DEFINER=`root`@`localhost` PROCEDURE `addArtist` (IN `firstNameIN` VARCHAR(50) CHARSET utf8mb4, IN `lastNameIN` VARCHAR(50) CHARSET utf8mb4, IN `emailIN` VARCHAR(100) CHARSET utf8mb4, IN `phoneNumberIN` VARCHAR(20) CHARSET utf8mb4, IN `bankCardNumberIN` INT(16), IN `nationalNumberIN` INT(10), IN `birthdayIN` TIMESTAMP, IN `passwordIN` VARCHAR(50) CHARSET utf8mb4)  NO SQL
INSERT INTO `artist` (`artist`.`first_name`, `artist`.`last_name`, `artist`.`email`, `artist`.`phone_number`, `artist`.`bank_card_number`, `artist`.`national_number`, `artist`.`birthday`, `artist`.`password`) VALUES ( firstNameIN, lastNameIN, emailIN, phoneNumberIN, bankCardNumberIN, nationalNumberIN, birthdayIN, passwordIN )$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addArtwork` (IN `titleIN` VARCHAR(100) CHARSET utf8mb4, IN `imageUrlIN` VARCHAR(1000) CHARSET utf8mb4, IN `descriptionIN` VARCHAR(1000) CHARSET utf8mb4, IN `priceIN` INT(100), IN `sizeIN` VARCHAR(100) CHARSET utf8mb4, IN `artistIdIN` INT(10), IN `uploadDateIN` TIMESTAMP)  NO SQL
INSERT INTO `artwork` ( `artwork`.`title`, `artwork`.`image_url`, `artwork`.`description`, `artwork`.`price`, `artwork`.`size`, `artwork`.`artist_id`, `artwork`.`upload_date` ) VALUES ( titleIN, imageUrlIN, descriptionIN, priceIN, sizeIN, artistIdIN, uploadDateIN )$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addArtworksCategories` (IN `artworkIdIN` INT(10), IN `categoryIdIN` INT(10))  NO SQL
INSERT INTO `artworks_categories` (`artworks_categories`.`artwork_id`, `artworks_categories`.`category_id`) VALUES ( artworkIdIN, categoryIdIN )$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addCategory` (IN `categoryNameIN` VARCHAR(50) CHARSET utf8mb4)  NO SQL
INSERT INTO `category` (`category`.`name`) VALUES ( categoryNameIN )$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `addCustomer` (IN `firstNameIN` VARCHAR(50) CHARSET utf8mb4, IN `lastNameIN` VARCHAR(50) CHARSET utf8mb4, IN `emailIN` VARCHAR(100) CHARSET utf8mb4, IN `phoneNumberIN` VARCHAR(20) CHARSET utf8mb4, IN `birthdayIN` TIMESTAMP, IN `addressIN` VARCHAR(1000) CHARSET utf8mb4, IN `passwordIN` INT(50))  NO SQL
INSERT INTO `customer` (`customer`.`first_name`, `customer`.`last_name`, `customer`.`email`, `customer`.`phone_number`, `customer`.`birthday`, `customer`.`address`, `customer`.`password`) VALUES ( firstNameIN, lastNameIN, emailIN, phoneNumberIN, birthdayIN, addressIN, passwordIN )$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `countPurchasedItemsByCustomer` (IN `customerIdIN` INT(10), OUT `purchasedItems` INT(10))  NO SQL
SELECT COUNT(`artwork`.`id`) INTO purchasedItems FROM `artwork` WHERE `artwork`.`customer_id` = customerIdIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteArtist` (IN `idIN` INT(10))  NO SQL
DELETE FROM `artist` WHERE `artist`.`id` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteArtwork` (IN `idIN` INT(10))  NO SQL
DELETE FROM `artwork` WHERE `artwork`.`id` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteArtworksCategories` (IN `idIN` INT(10))  NO SQL
DELETE FROM `artworks_categories` WHERE `artworks_categories`.`id` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteCategory` (IN `idIN` INT(10))  NO SQL
DELETE FROM `category` WHERE 	`category`.`id` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `deleteCustomer` (IN `idIN` INT(10))  NO SQL
DELETE FROM `customer` WHERE `customer`.`id` = idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `editArtist` (IN `idIN` INT(10), IN `firstNameIN` VARCHAR(50) CHARSET utf8mb4, IN `lastNameIN` VARCHAR(50) CHARSET utf8mb4, IN `emailIN` VARCHAR(100) CHARSET utf8mb4, IN `phoneNumberIN` VARCHAR(20) CHARSET utf8mb4, IN `bankCardNumbeIN` INT(16), IN `nationalNumberIN` INT(10), IN `birthdayIN` TIMESTAMP, IN `passwordIN` VARCHAR(50) CHARSET utf8mb4)  NO SQL
UPDATE `artist` SET `artist`.`first_name`=firstNameIN, `artist`.`last_name`=lastNameIN, `artist`.`email`=emailIN, `artist`.`phone_number`=phoneNumberIN, `artist`.`bank_card_number`=bankCardNumbeIN, `artist`.`national_number`=nationalNumberIN, `artist`.`birthday`=birthdayIN, `artist`.`password`=passwordIN WHERE `artist`.`id`=idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `editArtwork` (IN `idIN` INT(10), IN `titleIN` VARCHAR(100) CHARSET utf8mb4, IN `imageUrlIN` VARCHAR(1000) CHARSET utf8mb4, IN `descriptionIN` VARCHAR(1000) CHARSET utf8mb4, IN `priceIN` INT(100), IN `sizeIN` VARCHAR(100) CHARSET utf8mb4, IN `artistIdIN` INT(10), IN `customerIdIN` INT(10), IN `uploadDateIN` TIMESTAMP, IN `sellDateIN` TIMESTAMP)  NO SQL
UPDATE `artwork` SET `artwork`.`title`=titleIN, `artwork`.`image_url`=imageUrlIN, `artwork`.`description`=descriptionIN, `artwork`.`price`=priceIN, `artwork`.`size`=sizeIN, `artwork`.`artist_id`=artistIdIN, `artwork`.`customer_id`=customerIdIN, `artwork`.`upload_date`=uploadDateIN, `artwork`.`sell_date`=sellDateIN WHERE `artwork`.`id`=idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `editArtworksCategories` (IN `idIN` INT(10), IN `artworkIdIN` INT(10), IN `categoryIdIN` INT(10))  NO SQL
UPDATE `artworks_categories` SET `artworks_categories`.`artwork_id`=artworkIdIN, `artworks_categories`.`category_id`=categoryIdIN WHERE `artworks_categories`.`id`=idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `editCategory` (IN `idIN` INT(10), IN `categoryNameIN` VARCHAR(50) CHARSET utf8mb4)  NO SQL
UPDATE `category` SET `category`.`name`=categoryNameIN WHERE `category`.`id`=idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `editCustomer` (IN `idIN` INT(10), IN `firstNameIN` VARCHAR(50) CHARSET utf8mb4, IN `lastNameIN` VARCHAR(50) CHARSET utf8mb4, IN `emailIN` VARCHAR(100) CHARSET utf8mb4, IN `phoneNumberIN` VARCHAR(20) CHARSET utf8mb4, IN `birthdayIN` TIMESTAMP, IN `addressIN` VARCHAR(1000) CHARSET utf8mb4, IN `passwordIN` VARCHAR(50) CHARSET utf8mb4)  NO SQL
UPDATE `customer` SET `customer`.`first_name`=firstNameIN, `customer`.`last_name`=lastNameIN, `customer`.`email`=emailIN, `customer`.`phone_number`=phoneNumberIN, `customer`.`birthday`=birthdayIN, `customer`.`address`=addressIN, `customer`.`password`=passwordIN WHERE `customer`.`id`=idIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getArtists` ()  NO SQL
SELECT * FROM `artist`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getArtworks` ()  NO SQL
SELECT * FROM `artwork`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getArtworksCategories` ()  NO SQL
SELECT * FROM `artworks_categories`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getCategories` ()  NO SQL
SELECT * FROM `category`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getCustomers` ()  NO SQL
SELECT * FROM `customer`$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getSoldArtworks` ()  NO SQL
SELECT * FROM `artwork` WHERE `artwork`.`sell_date` IS NOT NULL$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `getUnsoldArtworks` ()  NO SQL
SELECT * FROM `artwork` WHERE `artwork`.`sell_date` IS NULL$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `priceLowerThan` (IN `priceIN` INT(100))  NO SQL
SELECT * FROM `artwork` WHERE `artwork`.`price` < priceIN$$

CREATE DEFINER=`root`@`localhost` PROCEDURE `priceUpperThan` (IN `priceIN` INT(100))  NO SQL
SELECT * FROM `artwork` WHERE `artwork`.`price` > priceIN$$

DELIMITER ;

-- --------------------------------------------------------

--
-- Table structure for table `artist`
--

CREATE TABLE `artist` (
  `id` int(10) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `bank_card_number` int(16) NOT NULL,
  `national_number` int(10) NOT NULL,
  `birthday` date DEFAULT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `artist`
--

INSERT INTO `artist` (`id`, `first_name`, `last_name`, `email`, `phone_number`, `bank_card_number`, `national_number`, `birthday`, `password`) VALUES
(1, 'Vincent', 'Vanghog', 'vinvan@artist.com', '+666666', 123456, 123456, '2021-10-10', '123456'),
(3, 'ms', 'photographer', 'something@st.com', '787878', 787878, 787878, '1977-07-07', '787878');

-- --------------------------------------------------------

--
-- Table structure for table `artwork`
--

CREATE TABLE `artwork` (
  `id` int(10) NOT NULL,
  `title` varchar(100) NOT NULL,
  `image_url` varchar(1000) NOT NULL,
  `description` varchar(1000) DEFAULT NULL,
  `price` int(100) NOT NULL,
  `size` varchar(100) NOT NULL,
  `artist_id` int(10) NOT NULL,
  `customer_id` int(10) DEFAULT NULL,
  `upload_date` date DEFAULT NULL,
  `sell_date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `artwork`
--

INSERT INTO `artwork` (`id`, `title`, `image_url`, `description`, `price`, `size`, `artist_id`, `customer_id`, `upload_date`, `sell_date`) VALUES
(1, 'starry night', 'google.com', 'wow', 0, 'size00', 1, NULL, '2021-10-21', NULL),
(3, '', '', '', 0, '', 0, 5, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `artworks_categories`
--

CREATE TABLE `artworks_categories` (
  `id` int(255) NOT NULL,
  `artwork_id` int(10) NOT NULL,
  `category_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `artworks_categories`
--

INSERT INTO `artworks_categories` (`id`, `artwork_id`, `category_id`) VALUES
(1, 1, 1),
(2, 1, 2),
(4, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(10) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `name`) VALUES
(1, 'Painting'),
(2, 'Design'),
(4, 'Sculpture');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `id` int(10) NOT NULL,
  `first_name` varchar(50) NOT NULL,
  `last_name` varchar(50) NOT NULL,
  `email` varchar(100) NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `birthday` date DEFAULT NULL,
  `address` varchar(1000) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`id`, `first_name`, `last_name`, `email`, `phone_number`, `birthday`, `address`, `password`) VALUES
(1, 'lolo', 'honri', 'lohon@buyer.com', '789456', NULL, 'somewhere far', '555555'),
(3, 'sam', 'smith', 'sam@smith.com', '+9999', NULL, 'nomand', '145'),
(4, 'walle', 'robot', 'string', '00000', '2001-11-06', 'Budapest', 'password'),
(5, 'evan', 'robot', 'evan@mars', '123', NULL, 'mars', '123456'),
(6, 'leo', 'brown', '', '121212', NULL, 'paris', '123654789'),
(7, 'srftghj', 'sdcfvbnm', 'esrty', '123456', NULL, 'dfbcgb', '0'),
(8, 'string', 'string', 'string', 'string', NULL, 'string', 'string');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `role_id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`role_id`, `name`) VALUES
(1, 'ADMIN'),
(2, 'ARTIST'),
(3, 'CUSTOMER');

-- --------------------------------------------------------

--
-- Table structure for table `user_entity`
--

CREATE TABLE `user_entity` (
  `user_id` int(11) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_entity`
--

INSERT INTO `user_entity` (`user_id`, `email`, `password`) VALUES
(1, 'admin', '$2a$10$J92PaPe8VzkgJiI/PPGf5eL6MMZgzh/SRM281mMekXgcSGIH7XLxK'),
(2, 'artist', '$2a$10$jR94dhzs5BDc67mxFDC4J.nIxZXvOjGThTKjfQ.yfFmxKmEDuB7Pi'),
(3, 'customer', '$2a$10$VHyDTxYcnJ3JLBY/yZo4mO7wAs13k8.jtPKR77C/WYiCLm81YvUbu'),
(4, 'patrick', '$2a$10$cTUErxQqYVyU2qmQGIktpup5chLEdhD2zpzNEyYqmxrHHJbSNDOG.');

-- --------------------------------------------------------

--
-- Table structure for table `user_role`
--

CREATE TABLE `user_role` (
  `user_id` int(11) NOT NULL,
  `role_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_role`
--

INSERT INTO `user_role` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 1),
(4, 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `artist`
--
ALTER TABLE `artist`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `artwork`
--
ALTER TABLE `artwork`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `artworks_categories`
--
ALTER TABLE `artworks_categories`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`role_id`);

--
-- Indexes for table `user_entity`
--
ALTER TABLE `user_entity`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `user_role`
--
ALTER TABLE `user_role`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKa68196081fvovjhkek5m97n3y` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `artist`
--
ALTER TABLE `artist`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `artwork`
--
ALTER TABLE `artwork`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `artworks_categories`
--
ALTER TABLE `artworks_categories`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `role_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `user_entity`
--
ALTER TABLE `user_entity`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `user_role`
--
ALTER TABLE `user_role`
  ADD CONSTRAINT `FK79ltvrbu1ni2ad7w7i9vers1k` FOREIGN KEY (`user_id`) REFERENCES `user_entity` (`user_id`),
  ADD CONSTRAINT `FKa68196081fvovjhkek5m97n3y` FOREIGN KEY (`role_id`) REFERENCES `role` (`role_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
