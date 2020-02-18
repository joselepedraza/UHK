-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 12-05-2019 a las 00:26:13
-- Versión del servidor: 5.7.24
-- Versión de PHP: 7.2.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `pruebas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contact_form`
--

DROP TABLE IF EXISTS `contact_form`;
CREATE TABLE IF NOT EXISTS `contact_form` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USERID` int(11) NOT NULL,
  `REQUEST` text NOT NULL,
  `IDSTATE` int(11) NOT NULL,
  `DATE` date DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `contact_user_id` (`USERID`),
  KEY `contact_state_id` (`IDSTATE`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `contact_form`
--

INSERT INTO `contact_form` (`ID`, `USERID`, `REQUEST`, `IDSTATE`, `DATE`) VALUES
(1, 2, 'Fill in your request please ', 1, '2019-05-11'),
(2, 0, '0', 0, NULL),
(3, 0, '0', 0, NULL),
(4, 0, '0', 0, NULL),
(5, 0, '0', 0, NULL),
(6, 2, 'Fill in your request please ', 1, '2019-05-11'),
(7, 2, 'Fill in your request please ', 1, '2019-05-11'),
(8, 2, 'Thanks', 1, '2019-05-11'),
(9, 2, 'I send this request with smartphone', 1, '2019-05-11'),
(10, 2, 'How is going my legal procedure?', 1, '2019-05-11'),
(11, 2, 'Fill in your request please 15', 1, '2019-05-11'),
(12, 1, 'Hi im Juan', 1, '2019-05-11'),
(13, 1, 'NEW QUERY FROM JUAN', 1, '2019-05-11'),
(14, 2, 'last', 1, '2019-05-11');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `state_form`
--

DROP TABLE IF EXISTS `state_form`;
CREATE TABLE IF NOT EXISTS `state_form` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `state_form`
--

INSERT INTO `state_form` (`ID`, `NAME`) VALUES
(1, 'waiting for review'),
(2, 'reviewed');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios_pass`
--

DROP TABLE IF EXISTS `usuarios_pass`;
CREATE TABLE IF NOT EXISTS `usuarios_pass` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `USUARIOS` varchar(20) NOT NULL,
  `PASSWORD` varchar(20) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios_pass`
--

INSERT INTO `usuarios_pass` (`ID`, `USUARIOS`, `PASSWORD`) VALUES
(1, 'JUAN', '1234'),
(2, 'ALFREDO', '4321');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
