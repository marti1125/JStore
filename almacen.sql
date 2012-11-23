-- phpMyAdmin SQL Dump
-- version 3.3.7deb2build0.10.10.1
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tiempo de generación: 15-12-2010 a las 08:53:40
-- Versión del servidor: 5.1.49
-- Versión de PHP: 5.3.3-1ubuntu9.1

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `almacen`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ingreso`
--
CREATE DATABASE almacen;
USE almacen;

CREATE TABLE IF NOT EXISTS `ingreso` (
  `idIngreso` int(11) NOT NULL AUTO_INCREMENT,
  `codProducto` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `personal` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idIngreso`),
  KEY `codProducto` (`codProducto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcar la base de datos para la tabla `ingreso`
--

INSERT INTO `ingreso` (`idIngreso`, `codProducto`, `cantidad`, `fecha`, `personal`) VALUES
(1, 1, 20, '2010-12-15', 'o');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE IF NOT EXISTS `producto` (
  `idProducto` int(11) NOT NULL AUTO_INCREMENT,
  `codProducto` varchar(50) DEFAULT NULL,
  `presentacion` varchar(50) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `costo` double DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  PRIMARY KEY (`idProducto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Volcar la base de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `codProducto`, `presentacion`, `cantidad`, `costo`, `precio`, `fecha`) VALUES
(1, '10001', 'kjljk', 0, 10, 10, '2010-12-14'),
(2, '10002', 'oo', 8, 10, 10, '2010-12-14');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salida`
--

CREATE TABLE IF NOT EXISTS `salida` (
  `idSalida` int(11) NOT NULL AUTO_INCREMENT,
  `codProducto` int(11) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  `fecha` date DEFAULT NULL,
  `personal` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idSalida`),
  KEY `codProducto` (`codProducto`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=33 ;

--
-- Volcar la base de datos para la tabla `salida`
--

INSERT INTO `salida` (`idSalida`, `codProducto`, `cantidad`, `fecha`, `personal`) VALUES
(1, 1, 10, '2010-12-15', 'jejej'),
(2, 1, 1, '2010-12-15', 'k'),
(3, 1, 10, '2010-12-15', 'ñ{ñ'),
(4, 1, 10, '2010-12-16', 'jejeje'),
(5, 2, 10, '2010-12-16', 'jejeje'),
(6, 1, 10, '2010-12-08', 'tt'),
(7, 1, 10, '2010-12-08', 'tt'),
(8, 2, 10, '2010-12-08', 'tt'),
(9, 2, 10, '2010-12-08', 'tt'),
(10, 1, 10, '2010-12-02', 'k'),
(11, 1, 10, '2010-12-02', 'k'),
(12, 1, 10, '2010-12-02', 'k'),
(13, 1, 10, '2010-12-09', 'ñ'),
(14, 1, 10, '2010-12-09', ''),
(15, 2, 10, '2010-12-09', ''),
(16, 2, 10, '2010-12-09', ''),
(17, 2, 10, '2010-12-09', ''),
(18, 2, 10, '2010-12-09', ''),
(19, 2, 10, '2010-12-09', ''),
(20, 1, 10, '2010-12-15', 'l'),
(21, 1, 10, '2010-12-15', 'l'),
(22, 1, 10, '2010-12-15', 'l'),
(23, 1, 10, '2010-12-15', 'l'),
(24, 1, 10, '2010-12-15', 'l'),
(25, 1, 10, '2010-12-15', 'l'),
(26, 1, 10, '2010-12-15', 'l'),
(27, 1, 10, '2010-12-15', 'op'),
(28, 1, 10, '2010-12-15', 'op'),
(29, 1, 10, '2010-12-15', 'op'),
(30, 1, 10, '2010-12-15', 'o'),
(31, 1, 10, '2010-12-15', 'gt'),
(32, 1, 10, '2010-12-15', 'p');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE IF NOT EXISTS `usuario` (
  `idUsuario` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(50) DEFAULT NULL,
  `clave` varchar(50) DEFAULT NULL,
  `nombreCompleto` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idUsuario`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcar la base de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`idUsuario`, `usuario`, `clave`, `nombreCompleto`) VALUES
(1, 'admin', 'admin', 'Willy Aguirre');

--
-- Filtros para las tablas descargadas (dump)
--

--
-- Filtros para la tabla `ingreso`
--
ALTER TABLE `ingreso`
  ADD CONSTRAINT `ingreso_ibfk_1` FOREIGN KEY (`codProducto`) REFERENCES `producto` (`idProducto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `salida`
--
ALTER TABLE `salida`
  ADD CONSTRAINT `salida_ibfk_1` FOREIGN KEY (`codProducto`) REFERENCES `producto` (`idProducto`) ON DELETE CASCADE ON UPDATE CASCADE;
