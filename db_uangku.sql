-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Feb 05, 2020 at 05:40 PM
-- Server version: 10.4.10-MariaDB
-- PHP Version: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_uangku`
--

-- --------------------------------------------------------

--
-- Table structure for table `kategori`
--

CREATE TABLE `kategori` (
  `id_kategori` int(11) NOT NULL,
  `nama_kategori` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `kategori`
--

INSERT INTO `kategori` (`id_kategori`, `nama_kategori`) VALUES
(12, 'makanan dan minuman'),
(13, 'Tagihan'),
(14, 'Transportasi'),
(15, 'Belanja'),
(16, 'Hiburan'),
(17, 'Kesehatan'),
(18, 'Donasi'),
(19, 'Pendidikan'),
(21, 'Bisnis'),
(22, 'Asuransi'),
(23, 'biaya dan ongkos'),
(24, 'Hadiah'),
(25, 'Gaji'),
(26, 'Pemberian'),
(27, 'Penjualan'),
(28, 'Lain-lain'),
(29, 'Investasi');

-- --------------------------------------------------------

--
-- Table structure for table `pengguna`
--

CREATE TABLE `pengguna` (
  `uid` int(11) NOT NULL,
  `fullname` varchar(25) NOT NULL,
  `username` varchar(25) NOT NULL,
  `password` varchar(255) NOT NULL,
  `uang` int(11) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `pengguna`
--

INSERT INTO `pengguna` (`uid`, `fullname`, `username`, `password`, `uang`) VALUES
(14, 'Testing user', 'test', 'test', 0),
(15, 'test2', 'test2', 'test2', 0),
(16, 'Benno Alif', 'test3', '1234', 155000),
(17, 'Pengguna baru', 'pengguna', 'pengguna', 0),
(18, 'Jamal Kabur', 'jamal', 'jamal', 0),
(19, 'Jamal Kabur', 'kabur', 'kabur', 0),
(20, 'test4', 'test4', 'test4', 0),
(21, 'Jamal Kabur', 'jamal_kabur', 'jamal', 0);

-- --------------------------------------------------------

--
-- Table structure for table `rencana`
--

CREATE TABLE `rencana` (
  `id` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `nominal` int(11) NOT NULL,
  `tgl_rencana` date NOT NULL,
  `status` varchar(50) NOT NULL,
  `catatan` varchar(255) DEFAULT NULL,
  `id_kategori` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `rencana`
--

INSERT INTO `rencana` (`id`, `uid`, `nominal`, `tgl_rencana`, `status`, `catatan`, `id_kategori`) VALUES
(10, 16, 69000, '2020-02-06', 'Belum Bayar', 'Tagihan Spotify', 16),
(11, 16, 169000, '2020-02-06', 'Selesai', 'Tagihan netflix', 16);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `id_transaksi` int(11) NOT NULL,
  `uid` int(11) NOT NULL,
  `id_kategori` int(11) NOT NULL,
  `nominal` int(11) NOT NULL,
  `tgl_transaksi` date NOT NULL,
  `catatan` varchar(255) DEFAULT NULL,
  `jenis_transaksi` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`id_transaksi`, `uid`, `id_kategori`, `nominal`, `tgl_transaksi`, `catatan`, `jenis_transaksi`) VALUES
(169, 16, 26, 200000, '2020-02-01', 'Pemberian orang tua', 'Masuk'),
(170, 16, 26, 50000, '2020-02-03', 'Pemberian teman', 'Masuk'),
(171, 16, 24, 100000, '2020-02-05', 'Hadiah lomba', 'Masuk'),
(172, 16, 12, 15000, '2020-02-01', 'Makan di warteg', 'Keluar'),
(173, 16, 14, 16000, '2020-02-03', 'Ojek online', 'Keluar'),
(174, 16, 26, 20000, '2020-02-06', 'Pemberian orang tua', 'Masuk'),
(175, 16, 12, 15000, '2020-02-06', 'Makan nasi padang', 'Keluar'),
(176, 16, 16, 169000, '2020-02-06', 'Tagihan netflix', 'Keluar');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `kategori`
--
ALTER TABLE `kategori`
  ADD PRIMARY KEY (`id_kategori`);

--
-- Indexes for table `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`uid`);

--
-- Indexes for table `rencana`
--
ALTER TABLE `rencana`
  ADD PRIMARY KEY (`id`),
  ADD KEY `uid` (`uid`),
  ADD KEY `id_kategori` (`id_kategori`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`id_transaksi`),
  ADD KEY `uid` (`uid`),
  ADD KEY `id_kategori` (`id_kategori`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `kategori`
--
ALTER TABLE `kategori`
  MODIFY `id_kategori` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT for table `pengguna`
--
ALTER TABLE `pengguna`
  MODIFY `uid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `rencana`
--
ALTER TABLE `rencana`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `id_transaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=177;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `rencana`
--
ALTER TABLE `rencana`
  ADD CONSTRAINT `FK_rencana_kategori` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`),
  ADD CONSTRAINT `FK_rencana_pengguna` FOREIGN KEY (`uid`) REFERENCES `pengguna` (`uid`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `FK_transaksi_kategori` FOREIGN KEY (`id_kategori`) REFERENCES `kategori` (`id_kategori`),
  ADD CONSTRAINT `FK_transaksi_pengguna` FOREIGN KEY (`uid`) REFERENCES `pengguna` (`uid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
