-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 13 Des 2018 pada 04.12
-- Versi server: 10.1.31-MariaDB
-- Versi PHP: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `umeltravel`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `rinciandana`
--

CREATE TABLE `rinciandana` (
  `NomorTransaksi` varchar(10) NOT NULL,
  `Perjalanan` varchar(50) NOT NULL,
  `Lama Perjalanan` varchar(50) NOT NULL,
  `Jumlah Pembelian` varchar(50) NOT NULL,
  `Harga` varchar(50) NOT NULL,
  `Total Harga` varchar(50) NOT NULL,
  `Diskon` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `rinciandana`
--

INSERT INTO `rinciandana` (`NomorTransaksi`, `Perjalanan`, `Lama Perjalanan`, `Jumlah Pembelian`, `Harga`, `Total Harga`, `Diskon`) VALUES
('AA8', 'Lombok', '4H/3M', '3', '4250000', '12750000', '637500.0'),
('AA9', 'Walisongo (Jawa-Madura)', '7H/5M', '2', '1500000', '3000000', '150000.0');

-- --------------------------------------------------------

--
-- Struktur dari tabel `struk`
--

CREATE TABLE `struk` (
  `NomorTransaksi` varchar(10) NOT NULL,
  `Nama` varchar(50) NOT NULL,
  `Tanggal` varchar(50) NOT NULL,
  `Saldo` varchar(50) NOT NULL,
  `SisaCash` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `struk`
--

INSERT INTO `struk` (`NomorTransaksi`, `Nama`, `Tanggal`, `Saldo`, `SisaCash`) VALUES
('AA8', 'Bekan', 'Thu Dec 13 10:04:21 ICT 2018', '20000000', '7887500'),
('AA9', 'Ikhbal', 'Thu Dec 13 10:10:09 ICT 2018', '3000000', '150000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `wisata`
--

CREATE TABLE `wisata` (
  `TempatWisata` varchar(50) NOT NULL,
  `LamaWisata` varchar(50) NOT NULL,
  `HargaWisata` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `wisata`
--

INSERT INTO `wisata` (`TempatWisata`, `LamaWisata`, `HargaWisata`) VALUES
('Bali', '3H/2M', '1728000'),
('Danau Toba', '5H/4M', '3280000'),
('Lombok', '4H/3M', '4250000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `wisataharian`
--

CREATE TABLE `wisataharian` (
  `TempatCustom` varchar(50) NOT NULL,
  `HargaPerhari` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `wisataharian`
--

INSERT INTO `wisataharian` (`TempatCustom`, `HargaPerhari`) VALUES
('Bali', '525000'),
('Belitung', '473000'),
('Danau Toba', '720000'),
('Lombok', '675000'),
('P,Komodo', '759000');

-- --------------------------------------------------------

--
-- Struktur dari tabel `ziarah`
--

CREATE TABLE `ziarah` (
  `TempatZiarah` varchar(50) NOT NULL,
  `LamaZiarah` varchar(50) NOT NULL,
  `HargaZiarah` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `ziarah`
--

INSERT INTO `ziarah` (`TempatZiarah`, `LamaZiarah`, `HargaZiarah`) VALUES
('Pamijahan (Tasikmalaya)', '3H/2M', '300000'),
('Wali9+Wali7', '8H/6M', '2500000'),
('Walisongo (Jawa-Madura)', '7H/5M', '1500000');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `rinciandana`
--
ALTER TABLE `rinciandana`
  ADD UNIQUE KEY `NomorTransaksi` (`NomorTransaksi`);

--
-- Indeks untuk tabel `struk`
--
ALTER TABLE `struk`
  ADD PRIMARY KEY (`NomorTransaksi`);

--
-- Indeks untuk tabel `wisata`
--
ALTER TABLE `wisata`
  ADD PRIMARY KEY (`TempatWisata`);

--
-- Indeks untuk tabel `wisataharian`
--
ALTER TABLE `wisataharian`
  ADD PRIMARY KEY (`TempatCustom`);

--
-- Indeks untuk tabel `ziarah`
--
ALTER TABLE `ziarah`
  ADD PRIMARY KEY (`TempatZiarah`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
