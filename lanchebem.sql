-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 15-Jul-2019 às 04:15
-- Versão do servidor: 10.1.40-MariaDB
-- versão do PHP: 7.3.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `lanchebem`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `atendentes`
--

CREATE TABLE `atendentes` (
  `id` smallint(6) NOT NULL,
  `nome` varchar(256) DEFAULT NULL,
  `cpf` varchar(256) DEFAULT NULL,
  `datadenascimento` date DEFAULT NULL,
  `salario` double DEFAULT NULL,
  `tipodefuncionario` varchar(256) DEFAULT NULL,
  `datadecadastro` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `clientes`
--

CREATE TABLE `clientes` (
  `id` smallint(6) NOT NULL,
  `nome` varchar(256) DEFAULT NULL,
  `cpf` varchar(256) DEFAULT NULL,
  `datadenascimento` date DEFAULT NULL,
  `tipodecliente` varchar(256) DEFAULT NULL,
  `datadecadastro` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `clientes`
--

INSERT INTO `clientes` (`id`, `nome`, `cpf`, `datadenascimento`, `tipodecliente`, `datadecadastro`) VALUES
(1, 'Cesario', '017.714.314.23', '1995-11-29', 'VIP', '2019-07-14');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `atendentes`
--
ALTER TABLE `atendentes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `atendentes`
--
ALTER TABLE `atendentes`
  MODIFY `id` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `clientes`
--
ALTER TABLE `clientes`
  MODIFY `id` smallint(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
