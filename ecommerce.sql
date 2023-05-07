-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: May 07, 2023 at 06:38 PM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `ecommerce`
--

-- --------------------------------------------------------

--
-- Table structure for table `cart`
--

CREATE TABLE `cart` (
  `cartId` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  `user` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `cart`
--

INSERT INTO `cart` (`cartId`, `productId`, `user`) VALUES
(1, 3, 'roshan@gmail.com'),
(2, 4, 'roshan@gmail.com'),
(3, 5, 'roshan@gmail.com'),
(16, 4, 'roshan@gmail.com'),
(17, 3, 'roshan@gmail.com'),
(18, 3, 'a@bikram.com'),
(19, 3, 'roshan@gmail.com'),
(20, 5, 'a@bikram.com'),
(21, 3, 'a@bikram.com');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `title` varchar(100) NOT NULL,
  `description` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `title`, `description`) VALUES
(1, 'Men', 'Stylish men outfits'),
(2, 'Women', 'Stalish women outfits'),
(3, 'Kids', 'Kids Fashion');

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `id` int(11) NOT NULL,
  `productId` int(11) NOT NULL,
  `user` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`id`, `productId`, `user`) VALUES
(6, 3, 'a@bikram.com'),
(7, 3, 'a@bikram.com'),
(8, 3, 'roshan@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `products`
--

CREATE TABLE `products` (
  `id` int(11) NOT NULL,
  `productTitle` varchar(100) NOT NULL,
  `productDescription` varchar(255) NOT NULL,
  `price` int(11) NOT NULL,
  `discount` int(11) NOT NULL,
  `quantity` int(11) NOT NULL,
  `category` varchar(100) DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `products`
--

INSERT INTO `products` (`id`, `productTitle`, `productDescription`, `price`, `discount`, `quantity`, `category`, `image`) VALUES
(3, 'Chopsi', 'Lopsi', 100, 10, 2, 'Men', 'productImage/Chopsi.png'),
(4, 'Victus HP', 'New Brand From HP', 150000, 2, 30, 'Women', 'productImage/Victus HP.png'),
(5, 'Shuit', 'Wedding', 9500, 12, 3, 'Kids', 'productImage/Shuit.png');

-- --------------------------------------------------------

--
-- Table structure for table `uplode`
--

CREATE TABLE `uplode` (
  `id` int(11) NOT NULL,
  `fullname` varchar(20) NOT NULL,
  `image` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `uplode`
--

INSERT INTO `uplode` (`id`, `fullname`, `image`, `password`) VALUES
(1, 'Deepak', 'userImage/Deepak.png', '123');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `fullname` varchar(255) NOT NULL,
  `phonenumber` varchar(20) NOT NULL,
  `email` varchar(255) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `password` varchar(255) NOT NULL,
  `userType` varchar(20) NOT NULL DEFAULT 'normal',
  `image` varchar(200) NOT NULL DEFAULT 'userImage/default.png'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `fullname`, `phonenumber`, `email`, `gender`, `password`, `userType`, `image`) VALUES
(1, 'Deepak Shrestha', '9804021094', 'DES0570@my.londonmet.ac.uk', 'Male', 'advancedprogramming', 'admin', 'userImage/default.jpg'),
(3, 'Hello world', '1234', 'nikola@tesla.com', 'Male', '123', 'normal', 'userImage/default.jpg'),
(8, 'df', '986666666666666666', 'a@bikram.com', 'Male', 'EgmD6EhnCXMSCp2tifgx7g==', 'normal', 'userImage/df.png'),
(9, 'roshan', '92929', 'roshan@gmail.com', 'Male', 'EgmD6EhnCXMSCp2tifgx7g==', 'normal', 'userImage/default.jpg'),
(10, 'suju', '123', 'a@bikrasm.com', 'Female', 'EgmD6EhnCXMSCp2tifgx7g==', 'normal', 'userImage/suju.png');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`cartId`),
  ADD KEY `fk_foreign_key_name` (`productId`),
  ADD KEY `fk_user` (`user`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_productid` (`productId`),
  ADD KEY `fk_users` (`user`);

--
-- Indexes for table `products`
--
ALTER TABLE `products`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `uplode`
--
ALTER TABLE `uplode`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cart`
--
ALTER TABLE `cart`
  MODIFY `cartId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `orders`
--
ALTER TABLE `orders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `products`
--
ALTER TABLE `products`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `uplode`
--
ALTER TABLE `uplode`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `fk_foreign_key_name` FOREIGN KEY (`productId`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `fk_user` FOREIGN KEY (`user`) REFERENCES `user` (`email`);

--
-- Constraints for table `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `fk_productid` FOREIGN KEY (`productId`) REFERENCES `products` (`id`),
  ADD CONSTRAINT `fk_users` FOREIGN KEY (`user`) REFERENCES `user` (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
