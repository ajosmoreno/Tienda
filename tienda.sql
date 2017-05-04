-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 04-05-2017 a las 11:25:49
-- Versión del servidor: 5.7.14
-- Versión de PHP: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tienda`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cesta`
--

CREATE TABLE `cesta` (
  `idCliente` int(10) UNSIGNED NOT NULL,
  `idProducto` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE `compras` (
  `numeroPedido` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `gestores`
--

CREATE TABLE `gestores` (
  `id` int(10) UNSIGNED NOT NULL,
  `nombre` char(50) NOT NULL,
  `direccion` char(50) NOT NULL,
  `telefono` char(9) NOT NULL,
  `email` char(50) NOT NULL,
  `tipo` enum('Operador','Proveedor') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `gestores`
--

INSERT INTO `gestores` (`id`, `nombre`, `direccion`, `telefono`, `email`, `tipo`) VALUES
(1, 'Vodafone', 'C/ Madrid', '123', 'consultas@vodafone.es', 'Operador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `liberaciones`
--

CREATE TABLE `liberaciones` (
  `numeroPedido` int(10) UNSIGNED NOT NULL,
  `operador` int(10) UNSIGNED NOT NULL,
  `imei` char(15) NOT NULL,
  `codigoLiberacion` char(50) DEFAULT NULL,
  `instrucciones` text
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedidos`
--

CREATE TABLE `pedidos` (
  `numeroPedido` int(10) UNSIGNED NOT NULL,
  `fecha` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `idCliente` int(10) UNSIGNED NOT NULL,
  `subtotal` float(6,2) NOT NULL,
  `total` float(6,2) NOT NULL,
  `tipoPago` enum('Efectivo','Tarjeta') NOT NULL,
  `estadoPedido` enum('Completado','Pagado','Procesando') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productos`
--

CREATE TABLE `productos` (
  `id` int(10) UNSIGNED NOT NULL,
  `marca` char(50) NOT NULL,
  `modelo` char(50) NOT NULL,
  `precio` float(6,2) NOT NULL,
  `color` char(20) NOT NULL,
  `descripcion` text NOT NULL,
  `stock` tinyint(4) NOT NULL DEFAULT '0',
  `imagen` char(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `marca`, `modelo`, `precio`, `color`, `descripcion`, `stock`, `imagen`) VALUES
(1, 'Apple', 'iPhone 7', 769.00, 'Negro Brillante', 'Aquí toda la parafernalia del iPhone 7 jejeje\r\n\r\nAdemás esto y lo otro.\r\n\r\nY para terminar otro más.', 50, 'iphone7-jetblack.png'),
(2, 'Apple', 'iPhone 7 Plus', 909.00, 'Negro', 'Aquí toda la parafernalia del iPhone 7 Plus jejeje', 50, 'iPhone7plus.jpg'),
(3, 'Samsung', 'Galaxy S8', 809.00, 'Negro', 'Aquí la información sobre el Galaxy S8', 50, 'galaxys8.jpg');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productoscomprados`
--

CREATE TABLE `productoscomprados` (
  `numeroPedido` int(10) UNSIGNED NOT NULL,
  `idProducto` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reparaciones`
--

CREATE TABLE `reparaciones` (
  `numeroPedido` int(10) UNSIGNED NOT NULL,
  `proveedor` int(10) UNSIGNED NOT NULL,
  `diagnostico` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` int(10) UNSIGNED NOT NULL,
  `usuario` char(30) NOT NULL,
  `contrasenya` char(32) NOT NULL,
  `fechaRegistro` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `nombre` char(50) NOT NULL,
  `apellidos` char(50) NOT NULL,
  `direccion` char(50) NOT NULL,
  `telefono` char(9) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `dni` char(9) NOT NULL,
  `permiso` tinyint(3) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `usuario`, `contrasenya`, `fechaRegistro`, `nombre`, `apellidos`, `direccion`, `telefono`, `fechaNacimiento`, `dni`, `permiso`) VALUES
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', '2017-05-03 13:44:21', 'Administrador', 'Administrador', 'S/C', '600000000', '1970-01-01', '00000000T', 2),
(4, 'invitado', 'a6ae8a143d440ab8c006d799f682d48d', '2017-05-03 14:16:58', 'Invitado', 'Invitado', 'S/C', '600000000', '2017-05-03', '00000001R', 0),
(5, 'prueba', 'c893bad68927b457dbed39460e6afd62', '2017-05-04 08:43:33', 'probando', 'prueba', 'ssc', '1234', '2017-05-04', '155616549', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cesta`
--
ALTER TABLE `cesta`
  ADD PRIMARY KEY (`idCliente`,`idProducto`),
  ADD KEY `idProducto` (`idProducto`);

--
-- Indices de la tabla `compras`
--
ALTER TABLE `compras`
  ADD PRIMARY KEY (`numeroPedido`);

--
-- Indices de la tabla `gestores`
--
ALTER TABLE `gestores`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `liberaciones`
--
ALTER TABLE `liberaciones`
  ADD PRIMARY KEY (`numeroPedido`),
  ADD KEY `operador` (`operador`);

--
-- Indices de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD PRIMARY KEY (`numeroPedido`),
  ADD KEY `idCliente` (`idCliente`);

--
-- Indices de la tabla `productos`
--
ALTER TABLE `productos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `productoscomprados`
--
ALTER TABLE `productoscomprados`
  ADD PRIMARY KEY (`numeroPedido`,`idProducto`),
  ADD KEY `idProducto` (`idProducto`);

--
-- Indices de la tabla `reparaciones`
--
ALTER TABLE `reparaciones`
  ADD PRIMARY KEY (`numeroPedido`),
  ADD KEY `proveedor` (`proveedor`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `usuario` (`usuario`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `gestores`
--
ALTER TABLE `gestores`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `numeroPedido` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cesta`
--
ALTER TABLE `cesta`
  ADD CONSTRAINT `cesta_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cesta_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `compras`
--
ALTER TABLE `compras`
  ADD CONSTRAINT `compras_ibfk_1` FOREIGN KEY (`numeroPedido`) REFERENCES `pedidos` (`numeroPedido`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `liberaciones`
--
ALTER TABLE `liberaciones`
  ADD CONSTRAINT `liberaciones_ibfk_1` FOREIGN KEY (`numeroPedido`) REFERENCES `pedidos` (`numeroPedido`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `liberaciones_ibfk_2` FOREIGN KEY (`operador`) REFERENCES `gestores` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `pedidos`
--
ALTER TABLE `pedidos`
  ADD CONSTRAINT `pedidos_ibfk_1` FOREIGN KEY (`idCliente`) REFERENCES `usuarios` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `productoscomprados`
--
ALTER TABLE `productoscomprados`
  ADD CONSTRAINT `productoscomprados_ibfk_1` FOREIGN KEY (`numeroPedido`) REFERENCES `compras` (`numeroPedido`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `productoscomprados_ibfk_2` FOREIGN KEY (`idProducto`) REFERENCES `productos` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Filtros para la tabla `reparaciones`
--
ALTER TABLE `reparaciones`
  ADD CONSTRAINT `reparaciones_ibfk_1` FOREIGN KEY (`numeroPedido`) REFERENCES `pedidos` (`numeroPedido`) ON DELETE NO ACTION ON UPDATE CASCADE,
  ADD CONSTRAINT `reparaciones_ibfk_2` FOREIGN KEY (`proveedor`) REFERENCES `gestores` (`id`) ON DELETE NO ACTION ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
