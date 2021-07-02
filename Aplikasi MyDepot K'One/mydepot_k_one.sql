-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 29, 2021 at 08:06 AM
-- Server version: 10.1.36-MariaDB
-- PHP Version: 7.2.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `mydepot_k_one`
--

-- --------------------------------------------------------

--
-- Table structure for table `airgalon`
--

CREATE TABLE `airgalon` (
  `id_air` varchar(20) CHARACTER SET latin1 NOT NULL,
  `keterangan_air` varchar(50) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `airgalon`
--

INSERT INTO `airgalon` (`id_air`, `keterangan_air`) VALUES
('0', 'Tidak Tersedia'),
('1', 'Tersedia');

-- --------------------------------------------------------

--
-- Table structure for table `karyawan`
--

CREATE TABLE `karyawan` (
  `id_k` varchar(20) CHARACTER SET latin1 NOT NULL,
  `password` varchar(20) CHARACTER SET latin1 NOT NULL,
  `keterangan` varchar(50) CHARACTER SET latin1 NOT NULL,
  `nama_k` varchar(50) CHARACTER SET latin1 NOT NULL,
  `nohp_k` varchar(20) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `karyawan`
--

INSERT INTO `karyawan` (`id_k`, `password`, `keterangan`, `nama_k`, `nohp_k`) VALUES
('00000', '99999', 'Karyawan', 'tupai', '124626264'),
('11223344', '224466', 'Karyawan', 'chid', '089373463454'),
('12345', '12345', 'Owner', 'virda', '0972525373'),
('admin', 'admin', 'Owner', 'admin', '0829273634'),
('G001', 'dani123', 'Galonman', 'Dani', '083213'),
('G002', 'randi', 'Galonman', 'Randi', '0832131');

-- --------------------------------------------------------

--
-- Table structure for table `memesan`
--

CREATE TABLE `memesan` (
  `nopesanan` int(20) NOT NULL,
  `id_p` varchar(20) CHARACTER SET latin1 NOT NULL,
  `id_k` varchar(20) CHARACTER SET latin1 NOT NULL,
  `id_g` varchar(20) CHARACTER SET latin1 NOT NULL,
  `nama_k` varchar(20) CHARACTER SET latin1 NOT NULL,
  `nama_g` varchar(20) CHARACTER SET latin1 NOT NULL,
  `jmlpesanan` int(15) DEFAULT NULL,
  `tglpesanan` date DEFAULT NULL,
  `biaya` double NOT NULL,
  `diskon` int(15) DEFAULT NULL,
  `voucher` varchar(50) CHARACTER SET latin1 DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `memesan`
--

INSERT INTO `memesan` (`nopesanan`, `id_p`, `id_k`, `id_g`, `nama_k`, `nama_g`, `jmlpesanan`, `tglpesanan`, `biaya`, `diskon`, `voucher`) VALUES
(10, 'P012', 'admin', 'G002', 'admin', 'Randi', 3, '2021-06-29', 10000, 5000, 'Piring'),
(16, 'P0001', 'admin', 'G002', 'admin', 'Randi', 4, '2021-06-30', 15000, 5000, 'Piring'),
(17, 'P051', 'admin', 'G002', 'admin', 'Randi', 5, '2021-06-29', 23000, 2000, 'Sendok'),
(18, 'P023', 'admin', 'G001', 'admin', 'Dani', 5, '2021-06-29', 23000, 2000, 'Gelas'),
(19, 'P2141', 'admin', 'G002', 'admin', 'Randi', 2, '2021-06-29', 8000, 2000, 'Kipas');

-- --------------------------------------------------------

--
-- Table structure for table `pelanggan`
--

CREATE TABLE `pelanggan` (
  `alamat_p` text CHARACTER SET latin1 NOT NULL,
  `id_p` varchar(20) CHARACTER SET latin1 NOT NULL,
  `nama_p` varchar(50) CHARACTER SET latin1 NOT NULL,
  `nohp_p` varchar(20) CHARACTER SET latin1 NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pelanggan`
--

INSERT INTO `pelanggan` (`alamat_p`, `id_p`, `nama_p`, `nohp_p`) VALUES
('dsad', 'P0001', 'adi', '08432123'),
('Padang', 'P012', 'Uni', '0478324'),
('dsadas', 'P023', 'Rani', '43242'),
('dasjd', 'P051', 'Yani', '43241'),
('kjasld', 'P2141', 'Jani', '4324');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `airgalon`
--
ALTER TABLE `airgalon`
  ADD PRIMARY KEY (`id_air`);

--
-- Indexes for table `karyawan`
--
ALTER TABLE `karyawan`
  ADD PRIMARY KEY (`id_k`);

--
-- Indexes for table `memesan`
--
ALTER TABLE `memesan`
  ADD PRIMARY KEY (`nopesanan`),
  ADD KEY `id_k` (`id_k`),
  ADD KEY `id_p` (`id_p`);

--
-- Indexes for table `pelanggan`
--
ALTER TABLE `pelanggan`
  ADD PRIMARY KEY (`id_p`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `memesan`
--
ALTER TABLE `memesan`
  MODIFY `nopesanan` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `memesan`
--
ALTER TABLE `memesan`
  ADD CONSTRAINT `memesan_ibfk_1` FOREIGN KEY (`id_k`) REFERENCES `karyawan` (`id_k`),
  ADD CONSTRAINT `memesan_ibfk_2` FOREIGN KEY (`id_p`) REFERENCES `pelanggan` (`id_p`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
