-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Mar 27, 2018 at 07:05 AM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `paf_test`
--

-- --------------------------------------------------------

--
-- Table structure for table `book`
--

CREATE TABLE IF NOT EXISTS `book` (
  `bookid` int(11) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(45) DEFAULT NULL,
  `author` varchar(45) DEFAULT NULL,
  `category` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`bookid`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `book`
--

INSERT INTO `book` (`bookid`, `bookname`, `author`, `category`, `price`) VALUES
(1, 'harry potter', 'j.k.rowling', 'adventure', '7000'),
(2, 'java', 'namal', 'education', '29999');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE IF NOT EXISTS `category` (
  `idcategory` int(11) NOT NULL AUTO_INCREMENT,
  `categoryname` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idcategory`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`idcategory`, `categoryname`) VALUES
(1, 'adventure'),
(2, 'education');

-- --------------------------------------------------------

--
-- Table structure for table `interests`
--

CREATE TABLE IF NOT EXISTS `interests` (
  `idinterests` int(11) NOT NULL AUTO_INCREMENT,
  `memberid` varchar(45) DEFAULT NULL,
  `interest` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idinterests`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Dumping data for table `interests`
--

INSERT INTO `interests` (`idinterests`, `memberid`, `interest`) VALUES
(1, '1', 'science');

-- --------------------------------------------------------

--
-- Table structure for table `members`
--

CREATE TABLE IF NOT EXISTS `members` (
  `memberiID` int(11) NOT NULL AUTO_INCREMENT,
  `Fullname` varchar(45) DEFAULT NULL,
  `dob` varchar(45) DEFAULT NULL,
  `paddress` varchar(45) DEFAULT NULL,
  `caddress` varchar(45) DEFAULT NULL,
  `mobile` varchar(45) DEFAULT NULL,
  `homeno` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `nic` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`memberiID`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `members`
--

INSERT INTO `members` (`memberiID`, `Fullname`, `dob`, `paddress`, `caddress`, `mobile`, `homeno`, `password`, `email`, `nic`) VALUES
(1, 'lumini ', '8-6-1996', 'piliyandala', 'piliyandala', '0778144720', '0112700971', '1234', 'lum@gmail.com', '967192473v'),
(2, 'imasha', '8-20-1995', 'malabe', 'malabe', '0715793991', '0112700971', '1234', 'imaha@gmail.com', '957192473v');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
