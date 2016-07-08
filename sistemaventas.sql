-- phpMyAdmin SQL Dump
-- version 3.5.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 08-07-2016 a las 23:30:26
-- Versión del servidor: 5.5.24-log
-- Versión de PHP: 5.4.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `sistemaventas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `articulo`
--

CREATE TABLE IF NOT EXISTS `articulo` (
  `aArt` varchar(10) DEFAULT NULL,
  `aDs1` varchar(80) DEFAULT NULL,
  `aDs2` varchar(160) DEFAULT NULL,
  `aUvt` varchar(15) DEFAULT NULL,
  `aPru` decimal(12,2) DEFAULT NULL,
  `aCom` decimal(5,2) DEFAULT NULL,
  `aSto` decimal(12,2) DEFAULT NULL,
  `aSts` decimal(12,2) DEFAULT NULL,
  `aFot` varchar(80) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empresa`
--

CREATE TABLE IF NOT EXISTS `empresa` (
  `eCod` int(4) NOT NULL AUTO_INCREMENT COMMENT 'Codigo de empresa',
  `eRuc` varchar(9) DEFAULT NULL COMMENT 'Ruc de la empresa',
  `eRzS` varchar(80) DEFAULT NULL COMMENT 'Razon Social',
  `eDir` varchar(80) DEFAULT NULL COMMENT 'Direccion',
  `eLug` varchar(80) DEFAULT NULL COMMENT 'Lugar ubigeo',
  `eMap` varchar(120) DEFAULT NULL COMMENT 'maps',
  `eTl1` varchar(15) DEFAULT NULL COMMENT 'Telefono fijo1',
  `eTl2` varchar(15) DEFAULT NULL COMMENT 'Telefono fijo2',
  `eFax` varchar(15) DEFAULT NULL COMMENT 'fax',
  `eFio` varchar(16) DEFAULT NULL COMMENT 'fecha inicio operaciones',
  `eRep` varchar(80) DEFAULT NULL COMMENT 'Representante legar',
  `eIgv` decimal(5,2) DEFAULT NULL COMMENT 'igv',
  `eUfa` varchar(10) DEFAULT NULL COMMENT 'factura',
  `eUbv` varchar(11) DEFAULT NULL COMMENT 'boleta',
  `eUna` varchar(12) DEFAULT NULL COMMENT 'nota abono',
  `eUnc` varchar(13) DEFAULT NULL COMMENT 'nota cargo',
  `eUtk` varchar(14) DEFAULT NULL COMMENT 'ticket',
  `eUgr` varchar(15) DEFAULT NULL COMMENT 'guia remision',
  `eUgt` varchar(16) DEFAULT NULL COMMENT 'guia transporte',
  PRIMARY KEY (`eCod`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=15 ;

--
-- Volcado de datos para la tabla `empresa`
--

INSERT INTO `empresa` (`eCod`, `eRuc`, `eRzS`, `eDir`, `eLug`, `eMap`, `eTl1`, `eTl2`, `eFax`, `eFio`, `eRep`, `eIgv`, `eUfa`, `eUbv`, `eUna`, `eUnc`, `eUtk`, `eUgr`, `eUgt`) VALUES
(2, '64', '66677777', '22881', 'sddfefd', 'edf', 'dsdfsdfw', 'sdsdfsdf', '3333333', '0000-00-00', 'dssdfsdf', '12.00', 'sdsdf', 'sdfsdfs', 'dfsdfsdf', 'sdfsdfsdf', 'sdfsdfsdf', 'sdfsdfsdf', 'dfsdfd'),
(10, '64', '66677777', '22881', 'sddfefd', 'edf', 'dsdfsdfw', 'sdsdfsdf', '3333333', '0000-00-00', 'dssdfsdf', '12.00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(11, '64', '66677777', '22881', 'sddfefd', 'edf', 'dsdfsdfw', 'sdsdfsdf', '3333333', '0000-00-00', 'dssdfsdf', '12.00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(12, '64', '66677777', '22881', 'sddfefd', 'edf', 'dsdfsdfw', 'sdsdfsdf', '3333333', '0000-00-00', 'dssdfsdf', '12.00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(13, '64', '66677777', '22881', 'sddfefd', 'edf', 'dsdfsdfw', 'sdsdfsdf', '3333333', '0000-00-00', 'dssdfsdf', '12.00', NULL, NULL, NULL, NULL, NULL, NULL, NULL),
(14, '64', '66677777', '22881', 'sddfefd', 'edf', 'dsdfsdfw', 'sdsdfsdf', '3333333', '0000-00-00', 'dssdfsdf', '12.00', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vendedor`
--

CREATE TABLE IF NOT EXISTS `vendedor` (
  `vCod` tinyint(4) NOT NULL AUTO_INCREMENT,
  `vRuc` varchar(9) DEFAULT NULL,
  `vRzS` varchar(80) DEFAULT NULL,
  `vDir` varchar(80) DEFAULT NULL,
  `vLug` varchar(80) DEFAULT NULL,
  `vMap` varchar(9) DEFAULT NULL,
  `vFnc` date DEFAULT NULL,
  `vTlf` varchar(15) DEFAULT NULL,
  `vCl1` varchar(15) DEFAULT NULL,
  `vCl2` varchar(15) DEFAULT NULL,
  `vCe1` varchar(80) DEFAULT NULL,
  `vCe2` varchar(80) DEFAULT NULL,
  `vCom` decimal(5,2) DEFAULT NULL,
  `vFio` date DEFAULT NULL,
  `vFfo` date DEFAULT NULL,
  `vMcs` varchar(80) DEFAULT NULL,
  `vFot` binary(1) DEFAULT NULL,
  `VUsr` varchar(10) DEFAULT NULL,
  `vPas` varchar(10) DEFAULT NULL,
  `vAcc` char(1) DEFAULT NULL,
  PRIMARY KEY (`vCod`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `vendedor`
--

INSERT INTO `vendedor` (`vCod`, `vRuc`, `vRzS`, `vDir`, `vLug`, `vMap`, `vFnc`, `vTlf`, `vCl1`, `vCl2`, `vCe1`, `vCe2`, `vCom`, `vFio`, `vFfo`, `vMcs`, `vFot`, `VUsr`, `vPas`, `vAcc`) VALUES
(2, '64', '66677777', '221111', NULL, NULL, NULL, '992997872', '7777', '6666', '3333333', NULL, '0.00', NULL, NULL, NULL, NULL, NULL, NULL, NULL);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
