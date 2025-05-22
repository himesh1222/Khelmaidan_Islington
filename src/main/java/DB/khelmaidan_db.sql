-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2025 at 06:58 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `khelmaidan_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `booking_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `booking_date` date NOT NULL,
  `slot_time` time NOT NULL,
  `duration_hours` int(11) NOT NULL,
  `booking_status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booking`
--

INSERT INTO `booking` (`booking_id`, `user_id`, `booking_date`, `slot_time`, `duration_hours`, `booking_status`) VALUES
(36, 16, '2002-12-02', '11:11:00', 1, 'Confirmed'),
(38, 22, '2025-05-21', '10:00:00', 1, 'Confirmed'),
(39, 22, '2025-11-11', '11:11:00', 2, 'Confirmed'),
(40, 22, '2000-06-07', '11:11:00', 1, 'Pending');

-- --------------------------------------------------------

--
-- Table structure for table `booking_ground`
--

CREATE TABLE `booking_ground` (
  `booking_id` int(11) NOT NULL,
  `futsal_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booking_ground`
--

INSERT INTO `booking_ground` (`booking_id`, `futsal_id`) VALUES
(36, 3),
(38, 2),
(39, 8),
(40, 2);

-- --------------------------------------------------------

--
-- Table structure for table `booking_payment`
--

CREATE TABLE `booking_payment` (
  `booking_id` int(11) NOT NULL,
  `payment_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `booking_payment`
--

INSERT INTO `booking_payment` (`booking_id`, `payment_id`) VALUES
(36, 20),
(38, 22),
(39, 23),
(40, 24);

-- --------------------------------------------------------

--
-- Table structure for table `ground`
--

CREATE TABLE `ground` (
  `Ground_Name` varchar(100) NOT NULL,
  `Location` varchar(255) NOT NULL,
  `Capacity` int(11) DEFAULT NULL CHECK (`Capacity` > 0),
  `Description` text DEFAULT NULL,
  `PricePerHour` decimal(10,2) DEFAULT NULL CHECK (`PricePerHour` >= 0),
  `futsal_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ground`
--

INSERT INTO `ground` (`Ground_Name`, `Location`, `Capacity`, `Description`, `PricePerHour`, `futsal_id`) VALUES
('Bhatbhateni Futsal', 'Kathmandu, Kalopul', 10, 'Convenient city-center turf', 1300.00, 1),
('Biratnagar Soccer Center', 'Biratnagar, Main Road', 12, 'Premium turf, bookings online', 1400.00, 2),
('Butwal Futsal Hub', 'Butwal, Traffic Chowk', 10, 'Spacious court with good parking', 1200.00, 3),
('Chitwan Arena', 'Bharatpur, Narayangarh', 10, 'Cool environment with synthetic turf', 1100.00, 4),
('Dharan Football Zone', 'Dharan-14, Bhanuchowk', 10, 'Standard indoor court', 1250.00, 5),
('Gorkha Futsal', 'Kathmandu, Baneshwor', 10, 'Synthetic turf, indoor court', 1500.00, 6),
('Nepal Arena', 'Lalitpur, Jawalakhel', 12, 'Modern futsal with changing room', 2000.00, 7),
('Pokhara Turf', 'Pokhara, Lakeside', 10, 'Outdoor turf with night lights', 1000.00, 8);

-- --------------------------------------------------------

--
-- Table structure for table `grounds`
--

CREATE TABLE `grounds` (
  `Ground_ID` int(11) NOT NULL,
  `Ground_Name` varchar(100) DEFAULT NULL,
  `Location` varchar(100) DEFAULT NULL,
  `Capacity` int(11) DEFAULT NULL,
  `Description` text DEFAULT NULL,
  `PricePerHour` decimal(10,2) DEFAULT NULL,
  `Ground_Image` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `grounds`
--

INSERT INTO `grounds` (`Ground_ID`, `Ground_Name`, `Location`, `Capacity`, `Description`, `PricePerHour`, `Ground_Image`) VALUES
(2, ' Liverpool fustal', 'Sundhara', 21, 'good', 2200.00, 'uploads/s.png'),
(3, 'Velocity fustal', 'ganeshowr', 20, 'very good', 1300.00, 'uploads/paiyum-sport-center.png'),
(4, 'chaur fustal', 'maitidevi', 19, 'good', 1000.00, 'uploads/fustal5.png'),
(5, 'kumari futsal', 'paknajol', 20, 'good', 3000.00, 'uploads/kumari.png'),
(6, 'Bhat futsal', 'kapan', 30, 'good', 2350.00, 'uploads/bhat.png'),
(8, 'Barcalona fustal', 'Rangasala', 20, 'good', 4500.00, 'uploads/barcas.png'),
(10, 'Birendra fustal', 'kaladhara', 20, 'good', 2820.00, 'uploads/name.png'),
(11, 'Army fustal', 'Swyambhu', 20, 'good', 2399.00, 'uploads/01(3).jpg'),
(13, 'Islington ground', 'Kamalpokhari', 20, 'good', 5000.00, 'uploads/barcas.png');

-- --------------------------------------------------------

--
-- Table structure for table `newuser`
--

CREATE TABLE `newuser` (
  `id` int(11) NOT NULL,
  `first_name` varchar(50) DEFAULT NULL,
  `last_name` varchar(50) DEFAULT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `image_path` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `newuser`
--

INSERT INTO `newuser` (`id`, `first_name`, `last_name`, `dob`, `email`, `password`, `phone`, `image_path`) VALUES
(13, 'Admin', 'Main', '2000-11-11', 'admin1@gmail.com', 'PIlu8ZeKiylNSi5P5oqmScENDBYgonZACwL83YrCqTU1xrupugR6NCKE+XewlaQAmesFmFk=', NULL, 'uploads/default.png'),
(16, 'Anis', 'shakya', '2002-01-01', 'anis@gmail.com', 'RU/j9zc/slvlaJ8RHLJeF5rV6tjYnqY/j6fbCswq8Bi5zDI9Pc2A/7jo9TPI4Ys=', '9841555676', NULL),
(18, 'Himesh', 'Shakya', '2001-01-01', 'jyoti@gmail.com', '0qtCvVFHdvHZGDzLwz/JF1CmTfTRwFBAItyWjuw0kdVDaM/aQkDQz7H/jojdGdNrZ5JXbv8=', NULL, 'uploads/default.png'),
(19, 'Anis', 'Budakothi', '2001-01-10', 'anis@gmail.com', 'KakMp2r1RN6fpsGWzfXopG5SIAWOooR0drF2xzuoXkISsD+arn/Gm2XILlr5GaZge9V0Zl0=', NULL, 'uploads/default.png'),
(20, 'himesh', 'shakya', '2002-01-01', 'NP01CP4S240027@islingtoncollege.edu.np', 'ZtHpykn6odl2W0goIIjJYOjhmbjyq8pnUqkWxAGkiL78JXcpJIo6uqCigrSbiwRckkjghYw=', NULL, 'uploads/default.png'),
(22, 'Messika', 'Malla', '2004-01-01', 'NP01CP4S240028@islingtoncollege.edu.np', 'u+MqWzGZTCthPJ0MKgBL2XsTvJheNqvoHb5LMPu0gObl/5zc/bYUGjt65CY0ezuxEQQBw2I=', '9841555676', 'uploads/HD-wallpaper-cute-korean-girl-face-portrait-thumbnail.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `payment_id` int(11) NOT NULL,
  `payment_date` date NOT NULL,
  `amount` decimal(10,2) NOT NULL,
  `payment_status` varchar(20) NOT NULL,
  `payment_method` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`payment_id`, `payment_date`, `amount`, `payment_status`, `payment_method`) VALUES
(10, '2025-05-05', 1400.00, 'Completed', 'Khalti'),
(11, '2025-05-05', 2000.00, 'Completed', 'Khalti'),
(12, '2025-05-05', 1500.00, 'Completed', 'Khalti'),
(13, '2025-05-05', 1500.00, 'Completed', 'Khalti'),
(14, '2025-05-05', 1250.00, 'Completed', 'Khalti'),
(15, '2025-05-20', 1200.00, 'Completed', 'Khalti'),
(16, '2025-05-20', 1200.00, 'Completed', 'Khalti'),
(17, '2025-05-20', 1200.00, 'Completed', 'Khalti'),
(18, '2025-05-20', 1200.00, 'Completed', 'Khalti'),
(19, '2025-05-21', 1300.00, 'Completed', 'Khalti'),
(20, '2025-05-21', 1300.00, 'Completed', 'Khalti'),
(21, '2025-05-21', 1300.00, 'Completed', 'Khalti'),
(22, '2025-05-21', 2200.00, 'Completed', 'Khalti'),
(23, '2025-05-21', 4500.00, 'Completed', 'Khalti'),
(24, '2025-05-21', 2200.00, 'Completed', 'Khalti');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`booking_id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `booking_ground`
--
ALTER TABLE `booking_ground`
  ADD PRIMARY KEY (`booking_id`,`futsal_id`),
  ADD KEY `futsal_id` (`futsal_id`);

--
-- Indexes for table `booking_payment`
--
ALTER TABLE `booking_payment`
  ADD PRIMARY KEY (`booking_id`,`payment_id`),
  ADD KEY `payment_id` (`payment_id`);

--
-- Indexes for table `ground`
--
ALTER TABLE `ground`
  ADD PRIMARY KEY (`futsal_id`);

--
-- Indexes for table `grounds`
--
ALTER TABLE `grounds`
  ADD PRIMARY KEY (`Ground_ID`);

--
-- Indexes for table `newuser`
--
ALTER TABLE `newuser`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`payment_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `booking_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=41;

--
-- AUTO_INCREMENT for table `ground`
--
ALTER TABLE `ground`
  MODIFY `futsal_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `grounds`
--
ALTER TABLE `grounds`
  MODIFY `Ground_ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;

--
-- AUTO_INCREMENT for table `newuser`
--
ALTER TABLE `newuser`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `payment_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `newuser` (`id`) ON DELETE CASCADE;

--
-- Constraints for table `booking_ground`
--
ALTER TABLE `booking_ground`
  ADD CONSTRAINT `booking_ground_ibfk_1` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`booking_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `booking_ground_ibfk_2` FOREIGN KEY (`futsal_id`) REFERENCES `ground` (`futsal_id`) ON DELETE CASCADE;

--
-- Constraints for table `booking_payment`
--
ALTER TABLE `booking_payment`
  ADD CONSTRAINT `booking_payment_ibfk_1` FOREIGN KEY (`booking_id`) REFERENCES `booking` (`booking_id`) ON DELETE CASCADE,
  ADD CONSTRAINT `booking_payment_ibfk_2` FOREIGN KEY (`payment_id`) REFERENCES `payment` (`payment_id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
