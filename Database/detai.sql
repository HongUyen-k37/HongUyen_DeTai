-- phpMyAdmin SQL Dump
-- version 4.2.11
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Oct 16, 2016 at 12:25 PM
-- Server version: 5.6.21
-- PHP Version: 5.6.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `detai_beo`
--

-- --------------------------------------------------------

--
-- Table structure for table `baithi`
--

CREATE TABLE IF NOT EXISTS `baithi` (
  `maKyThi` int(11) NOT NULL,
  `maMonThi` int(11) NOT NULL,
  `maThiSinh` int(11) NOT NULL,
  `soPhach` int(11) DEFAULT NULL,
  `tuiSo` int(11) DEFAULT NULL,
  `trangThaiDuThi` int(11) DEFAULT NULL,
  `diemChamThi` float DEFAULT NULL,
  `diemChinhThuc` float DEFAULT NULL,
  `ghiChu` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `danhsachthisinh`
--

CREATE TABLE IF NOT EXISTS `danhsachthisinh` (
  `maThiSinh` int(11) NOT NULL,
  `maKyThi` int(11) NOT NULL,
  `maPhongThi` int(11) NOT NULL,
  `hoDem` varchar(50) DEFAULT NULL,
  `Ten` varchar(50) DEFAULT NULL,
  `ngaySinh` varchar(50) DEFAULT NULL,
  `noiSinh` varchar(50) DEFAULT NULL,
  `dienThoai` varchar(50) DEFAULT NULL,
  `email` varchar(200) DEFAULT NULL,
  `diaChi` varchar(500) DEFAULT NULL,
  `soBaoDanh` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `kythi`
--

CREATE TABLE IF NOT EXISTS `kythi` (
  `maKyThi` int(11) NOT NULL,
  `tenKyThi` varchar(50) DEFAULT NULL,
  `ngayThi` varchar(10) DEFAULT NULL,
  `namTuyenSinh` int(11) DEFAULT NULL,
  `nganh` varchar(50) DEFAULT NULL,
  `hinhThucDT` varchar(50) DEFAULT NULL,
  `soMonThi` int(11) DEFAULT NULL,
  `trangThai` int(11) DEFAULT NULL,
  `coSoPhongThi` int(11) DEFAULT NULL,
  `soLuot` int(11) DEFAULT NULL,
  `tiepDauNgu` varchar(10) DEFAULT NULL,
  `soBatDau` int(11) DEFAULT NULL,
  `coSoTui` int(11) DEFAULT NULL,
  `soLuongChuSo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `monthi`
--

CREATE TABLE IF NOT EXISTS `monthi` (
  `maMonThi` int(11) NOT NULL,
  `maKyThi` int(11) NOT NULL,
  `tenMonThi` varchar(50) DEFAULT NULL,
  `trangThaiMonThi` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `phongthi`
--

CREATE TABLE IF NOT EXISTS `phongthi` (
  `maPhongThi` int(11) NOT NULL,
  `maKyThi` int(11) NOT NULL,
  `soHieuPhongThi` varchar(10) DEFAULT NULL,
  `soLuongThiSinh` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `baithi`
--
ALTER TABLE `baithi`
 ADD PRIMARY KEY (`maKyThi`,`maMonThi`,`maThiSinh`), ADD KEY `maMonThi` (`maMonThi`), ADD KEY `maThiSinh` (`maThiSinh`);

--
-- Indexes for table `danhsachthisinh`
--
ALTER TABLE `danhsachthisinh`
 ADD PRIMARY KEY (`maThiSinh`), ADD KEY `FK_danhsachthisinh_kythi` (`maKyThi`), ADD KEY `FK_danhsachthisinh_phongthi` (`maPhongThi`);

--
-- Indexes for table `kythi`
--
ALTER TABLE `kythi`
 ADD PRIMARY KEY (`maKyThi`);

--
-- Indexes for table `monthi`
--
ALTER TABLE `monthi`
 ADD PRIMARY KEY (`maMonThi`), ADD KEY `FK_monthi_kythi` (`maKyThi`);

--
-- Indexes for table `phongthi`
--
ALTER TABLE `phongthi`
 ADD PRIMARY KEY (`maPhongThi`), ADD KEY `FK_phongthi_kythi` (`maKyThi`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `baithi`
--
ALTER TABLE `baithi`
ADD CONSTRAINT `baithi_ibfk_1` FOREIGN KEY (`maKyThi`) REFERENCES `kythi` (`maKyThi`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `baithi_ibfk_2` FOREIGN KEY (`maMonThi`) REFERENCES `monthi` (`maMonThi`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `baithi_ibfk_3` FOREIGN KEY (`maThiSinh`) REFERENCES `danhsachthisinh` (`maThiSinh`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `danhsachthisinh`
--
ALTER TABLE `danhsachthisinh`
ADD CONSTRAINT `FK_danhsachthisinh_kythi` FOREIGN KEY (`maKyThi`) REFERENCES `kythi` (`maKyThi`) ON DELETE CASCADE ON UPDATE CASCADE,
ADD CONSTRAINT `FK_danhsachthisinh_phongthi` FOREIGN KEY (`maPhongThi`) REFERENCES `phongthi` (`maPhongThi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `monthi`
--
ALTER TABLE `monthi`
ADD CONSTRAINT `FK_monthi_kythi` FOREIGN KEY (`maKyThi`) REFERENCES `kythi` (`maKyThi`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `phongthi`
--
ALTER TABLE `phongthi`
ADD CONSTRAINT `FK_phongthi_kythi` FOREIGN KEY (`maKyThi`) REFERENCES `kythi` (`maKyThi`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
