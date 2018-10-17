-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Oct 17, 2018 at 10:44 AM
-- Server version: 10.1.31-MariaDB
-- PHP Version: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `recorder`
--

-- --------------------------------------------------------

--
-- Table structure for table `calving record`
--

CREATE TABLE `calving record` (
  `id` int(11) NOT NULL,
  `calfid` varchar(45) NOT NULL,
  `cowid` varchar(45) NOT NULL,
  `calvingdate` varchar(45) NOT NULL,
  `insemmethod` varchar(45) NOT NULL,
  `sex` varchar(45) NOT NULL,
  `birthweight` int(11) NOT NULL,
  `isActive` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `cow`
--

CREATE TABLE `cow` (
  `id` int(11) NOT NULL,
  `cowid` varchar(45) NOT NULL,
  `dob` varchar(45) NOT NULL,
  `dop` varchar(45) NOT NULL,
  `sex` int(11) NOT NULL,
  `birthplace` varchar(45) NOT NULL,
  `isActive` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `itemID` int(11) NOT NULL,
  `itemtype` varchar(45) DEFAULT NULL,
  `itemName` varchar(250) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `quantity` int(11) NOT NULL,
  `unit of measure` varchar(45) NOT NULL,
  `isActive` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `medical`
--

CREATE TABLE `medical` (
  `id` int(11) NOT NULL,
  `cowid` varchar(45) NOT NULL,
  `history` varchar(250) NOT NULL,
  `symtoms` varchar(250) NOT NULL,
  `diagnosis` varchar(250) NOT NULL,
  `treatment` varchar(250) NOT NULL,
  `result` varchar(250) NOT NULL,
  `date` varchar(50) NOT NULL,
  `isActive` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `milking record`
--

CREATE TABLE `milking record` (
  `id` int(11) NOT NULL,
  `cowid` int(11) NOT NULL,
  `firstmilking` int(11) NOT NULL,
  `secondmilking` int(11) NOT NULL,
  `thirdmilking` int(11) NOT NULL,
  `total` int(11) NOT NULL,
  `isActive` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `records`
--

CREATE TABLE `records` (
  `id` int(11) NOT NULL,
  `recordid` varchar(50) NOT NULL,
  `recordtype` varchar(45) NOT NULL,
  `time` varchar(45) NOT NULL,
  `isActive` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `id` int(11) NOT NULL,
  `firstname` varchar(60) NOT NULL,
  `lastname` varchar(60) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `national_id` varchar(15) NOT NULL,
  `address` varchar(30) NOT NULL,
  `gender` int(11) NOT NULL,
  `dob` varchar(70) DEFAULT NULL,
  `email` varchar(70) DEFAULT NULL,
  `isActive` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `uname` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `isActive` tinyint(1) NOT NULL DEFAULT '1'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id`, `uname`, `password`, `isActive`) VALUES
(1, 'admin', 'cf79491b22069cd9213a02f02e7d1f20677a81f8', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `calving record`
--
ALTER TABLE `calving record`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `cowid` (`cowid`);

--
-- Indexes for table `cow`
--
ALTER TABLE `cow`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`itemID`);

--
-- Indexes for table `medical`
--
ALTER TABLE `medical`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `milking record`
--
ALTER TABLE `milking record`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `records`
--
ALTER TABLE `records`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `calving record`
--
ALTER TABLE `calving record`
  ADD CONSTRAINT `cowid` FOREIGN KEY (`cowid`) REFERENCES `cattle` (`cowid`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
