-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 01, 2018 at 01:32 AM
-- Server version: 10.1.33-MariaDB
-- PHP Version: 7.2.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mydb`
--

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `idcourse` int(11) NOT NULL,
  `name` varchar(45) NOT NULL,
  `level` varchar(45) DEFAULT NULL,
  `hall` varchar(45) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `description` varchar(500) DEFAULT NULL,
  `opened` varchar(45) DEFAULT 'off',
  `certified` varchar(45) DEFAULT 'off',
  `maxHours` int(11) DEFAULT NULL,
  `totalTrainees` int(11) DEFAULT NULL,
  `numOfSessions` int(11) DEFAULT NULL,
  `time` varchar(45) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `trackname` varchar(45) DEFAULT NULL,
  `code` varchar(45) DEFAULT NULL,
  `maxnumber` int(11) DEFAULT NULL,
  `intendedtrainees` varchar(45) DEFAULT NULL,
  `targetlocation` varchar(45) DEFAULT NULL,
  `sat` varchar(45) DEFAULT NULL,
  `sun` varchar(45) DEFAULT NULL,
  `mon` varchar(45) DEFAULT NULL,
  `tues` varchar(45) DEFAULT NULL,
  `wed` varchar(45) DEFAULT NULL,
  `thur` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `instructor_tech_courses`
--

CREATE TABLE `instructor_tech_courses` (
  `course_idcourse` int(11) NOT NULL,
  `user_iduser` int(11) NOT NULL,
  `year` varchar(45) DEFAULT NULL,
  `season` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `notification`
--

CREATE TABLE `notification` (
  `idnotification` int(11) NOT NULL,
  `startdate` date DEFAULT NULL,
  `enddate` date DEFAULT NULL,
  `messege` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `paymentdetails`
--

CREATE TABLE `paymentdetails` (
  `id` int(11) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `paiedAmount` double DEFAULT NULL,
  `remainedAmount` double DEFAULT NULL,
  `course_idcourse` int(11) NOT NULL,
  `user_iduser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `reports`
--

CREATE TABLE `reports` (
  `idreports` int(11) NOT NULL,
  `projectName` varchar(45) DEFAULT NULL,
  `projectPrice` double DEFAULT NULL,
  `paied` double DEFAULT NULL,
  `remained` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `trainee_evaluate_course`
--

CREATE TABLE `trainee_evaluate_course` (
  `user_iduser` int(11) NOT NULL,
  `course_idcourse` int(11) NOT NULL,
  `rank` varchar(45) DEFAULT NULL,
  `question1` varchar(45) DEFAULT NULL,
  `question2` varchar(45) DEFAULT NULL,
  `question3` varchar(45) DEFAULT NULL,
  `question4` varchar(45) DEFAULT NULL,
  `question5` varchar(45) DEFAULT NULL,
  `question6` varchar(45) DEFAULT NULL,
  `question7` varchar(45) DEFAULT NULL,
  `question8` varchar(45) DEFAULT NULL,
  `question9` varchar(45) DEFAULT NULL,
  `question12` varchar(45) DEFAULT NULL,
  `question22` varchar(45) DEFAULT NULL,
  `question32` varchar(45) DEFAULT NULL,
  `question42` varchar(45) DEFAULT NULL,
  `question52` varchar(100) DEFAULT NULL,
  `question62` varchar(100) DEFAULT NULL,
  `question72` varchar(45) DEFAULT NULL,
  `question82` varchar(45) DEFAULT NULL,
  `question92` varchar(45) DEFAULT NULL,
  `question102` varchar(45) DEFAULT NULL,
  `question112` varchar(45) DEFAULT NULL,
  `question122` varchar(45) DEFAULT NULL,
  `questionText1` varchar(100) DEFAULT NULL,
  `questionText2` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `trainee_recieve_notificatin`
--

CREATE TABLE `trainee_recieve_notificatin` (
  `notification_idnotification` int(11) NOT NULL,
  `user_iduser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `trainee_register_course`
--

CREATE TABLE `trainee_register_course` (
  `user_iduser` int(11) NOT NULL,
  `course_idcourse` int(11) NOT NULL,
  `year` varchar(45) DEFAULT NULL,
  `paied` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `upload`
--

CREATE TABLE `upload` (
  `id` int(11) NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `size` varchar(45) DEFAULT NULL,
  `type` varchar(45) DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `course_idcourse` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `iduser` int(11) NOT NULL,
  `type` varchar(45) DEFAULT NULL,
  `userName` varchar(45) NOT NULL,
  `password` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `university` varchar(45) DEFAULT NULL,
  `college` varchar(45) DEFAULT NULL,
  `qualifications` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `ssn` varchar(45) DEFAULT NULL,
  `picname` varchar(256) DEFAULT NULL,
  `picsize` int(11) DEFAULT NULL,
  `pictype` varchar(256) DEFAULT NULL,
  `piclocation` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`idcourse`),
  ADD UNIQUE KEY `code_UNIQUE` (`code`);

--
-- Indexes for table `instructor_tech_courses`
--
ALTER TABLE `instructor_tech_courses`
  ADD PRIMARY KEY (`course_idcourse`,`user_iduser`),
  ADD KEY `fk_course_has_user_user1_idx` (`user_iduser`),
  ADD KEY `fk_course_has_user_course_idx` (`course_idcourse`);

--
-- Indexes for table `notification`
--
ALTER TABLE `notification`
  ADD PRIMARY KEY (`idnotification`);

--
-- Indexes for table `paymentdetails`
--
ALTER TABLE `paymentdetails`
  ADD PRIMARY KEY (`id`,`course_idcourse`,`user_iduser`),
  ADD KEY `fk_paymentDetails_course1_idx` (`course_idcourse`),
  ADD KEY `fk_paymentDetails_user1_idx` (`user_iduser`);

--
-- Indexes for table `reports`
--
ALTER TABLE `reports`
  ADD PRIMARY KEY (`idreports`);

--
-- Indexes for table `trainee_evaluate_course`
--
ALTER TABLE `trainee_evaluate_course`
  ADD PRIMARY KEY (`user_iduser`,`course_idcourse`),
  ADD KEY `fk_user_has_course_course1_idx` (`course_idcourse`),
  ADD KEY `fk_user_has_course_user1_idx` (`user_iduser`);

--
-- Indexes for table `trainee_recieve_notificatin`
--
ALTER TABLE `trainee_recieve_notificatin`
  ADD PRIMARY KEY (`notification_idnotification`,`user_iduser`),
  ADD KEY `fk_notification_has_user_user1_idx` (`user_iduser`),
  ADD KEY `fk_notification_has_user_notification1_idx` (`notification_idnotification`);

--
-- Indexes for table `trainee_register_course`
--
ALTER TABLE `trainee_register_course`
  ADD PRIMARY KEY (`user_iduser`,`course_idcourse`),
  ADD KEY `fk_user_has_course_course2_idx` (`course_idcourse`),
  ADD KEY `fk_user_has_course_user2_idx` (`user_iduser`);

--
-- Indexes for table `upload`
--
ALTER TABLE `upload`
  ADD PRIMARY KEY (`id`,`course_idcourse`),
  ADD KEY `fk_upload_course1_idx` (`course_idcourse`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`iduser`),
  ADD UNIQUE KEY `userName_UNIQUE` (`userName`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `idcourse` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `notification`
--
ALTER TABLE `notification`
  MODIFY `idnotification` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `paymentdetails`
--
ALTER TABLE `paymentdetails`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `reports`
--
ALTER TABLE `reports`
  MODIFY `idreports` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `upload`
--
ALTER TABLE `upload`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `iduser` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `instructor_tech_courses`
--
ALTER TABLE `instructor_tech_courses`
  ADD CONSTRAINT `fk_course_has_user_course` FOREIGN KEY (`course_idcourse`) REFERENCES `course` (`idcourse`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_course_has_user_user1` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `paymentdetails`
--
ALTER TABLE `paymentdetails`
  ADD CONSTRAINT `fk_paymentDetails_course1` FOREIGN KEY (`course_idcourse`) REFERENCES `course` (`idcourse`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_paymentDetails_user1` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `trainee_evaluate_course`
--
ALTER TABLE `trainee_evaluate_course`
  ADD CONSTRAINT `fk_user_has_course_course1` FOREIGN KEY (`course_idcourse`) REFERENCES `course` (`idcourse`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_user_has_course_user1` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `trainee_recieve_notificatin`
--
ALTER TABLE `trainee_recieve_notificatin`
  ADD CONSTRAINT `fk_notification_has_user_notification1` FOREIGN KEY (`notification_idnotification`) REFERENCES `notification` (`idnotification`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_notification_has_user_user1` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `trainee_register_course`
--
ALTER TABLE `trainee_register_course`
  ADD CONSTRAINT `fk_user_has_course_course2` FOREIGN KEY (`course_idcourse`) REFERENCES `course` (`idcourse`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_user_has_course_user2` FOREIGN KEY (`user_iduser`) REFERENCES `user` (`iduser`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `upload`
--
ALTER TABLE `upload`
  ADD CONSTRAINT `fk_upload_course1` FOREIGN KEY (`course_idcourse`) REFERENCES `course` (`idcourse`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
