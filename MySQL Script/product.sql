-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 04, 2020 at 05:37 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.1.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `product_management`
--

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `category` varchar(100) DEFAULT NULL,
  `price` int(11) NOT NULL DEFAULT 0,
  `color` varchar(50) DEFAULT NULL,
  `second_hand` tinyint(1) NOT NULL DEFAULT 0,
  `year` int(11) NOT NULL DEFAULT 0,
  `registry_date` date DEFAULT NULL,
  `deleted` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`id`, `name`, `category`, `price`, `color`, `second_hand`, `year`, `registry_date`, `deleted`) VALUES
(1, 'Toyota Camry', 'Car', 1000, 'Red', 0, 2020, NULL, 0),
(2, 'BMW X5', 'Car', 5000, 'Green', 1, 2019, '2019-05-14', 0),
(3, 'Toyota Vios', 'Car', 1500, 'Blue', 0, 2020, NULL, 0),
(4, 'Madaz CX5', 'Car', 3000, 'White', 1, 2017, '2017-07-18', 0),
(5, 'Honda SH', 'Motorcycle', 2000, 'White', 0, 2020, NULL, 0),
(6, 'Yamaha Exciter', 'Motorcycle', 1500, 'Gray', 1, 2015, '2016-03-19', 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
