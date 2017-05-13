-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-05-2017 a las 15:24:13
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

--
-- Volcado de datos para la tabla `cesta`
--

INSERT INTO `cesta` (`idCliente`, `idProducto`) VALUES
(4, 2),
(4, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compras`
--

CREATE TABLE `compras` (
  `numeroPedido` int(10) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `compras`
--

INSERT INTO `compras` (`numeroPedido`) VALUES
(1),
(2),
(3),
(6),
(7);

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
(1, 'Samsung', 'C/ Samsung', '654789123', 'contact@samsung.com', 'Proveedor'),
(2, 'Apple', 'C/ Cupertino', '632589741', 'contact@apple.com', 'Proveedor'),
(3, 'LG', 'C/ Corea del Sur', '678415398', 'contact@lg.com', 'Proveedor'),
(4, 'Huawei', 'C/ Huawei', '620178305', 'contact@huawei.com', 'Proveedor'),
(5, 'Vodafone', 'C/ Vodafone', '123', 'contact@vodafone.es', 'Operador'),
(6, 'Movistar', 'C/ Movistar', '1004', 'contact@movistar.es', 'Operador'),
(7, 'Orange', 'C/ Orange', '1414', 'contact@orange.es', 'Operador'),
(8, 'Yoigo', 'C/ Yoigo', '622', 'contact@yoigo.es', 'Operador');

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

--
-- Volcado de datos para la tabla `liberaciones`
--

INSERT INTO `liberaciones` (`numeroPedido`, `operador`, `imei`, `codigoLiberacion`, `instrucciones`) VALUES
(5, 5, '1234984', '321613764', '* No es necesario, pero sí altamente recomendable desactivar previamente el PIN de la sim no aceptada, para no confundir con el código de liberación cuando lo pida.\n\n1. Encienda su móvil con una tarjeta no aceptada por el terminal, es decir de otro operador distinto\n\n2. Si no ha desactivado el PIN como le recomendamos y le pide el codigo PIN meta el código PIN de la SIM. Si le da error \n y está seguro de que introduce el PIN correcto es porque el código que el pide es el de liberación, en la mayoría de modelos la pantalla es igual a la del PIN.\n\n3. Cuando le pida el código de liberación deberá introducir el código de 7 números que tiene y acto seguido pulsar en \n Confirmar, OK, aceptar o similar. Si no lo pidiera ni aparece ningun campo para introducirlo marque el código y luego pulse sobre Confirmar, OK, aceptar o similar.'),
(9, 6, '2569703952', NULL, NULL);

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
  `estadoPedido` enum('Completado','Pagado','Cancelado','Sin pagar','Liberado','Reparado') NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pedidos`
--

INSERT INTO `pedidos` (`numeroPedido`, `fecha`, `idCliente`, `subtotal`, `total`, `tipoPago`, `estadoPedido`) VALUES
(1, '2017-05-13 12:55:11', 4, 639.11, 809.00, 'Efectivo', 'Completado'),
(2, '2017-05-13 13:01:37', 4, 1325.62, 1678.00, 'Tarjeta', 'Cancelado'),
(3, '2017-05-13 13:03:23', 4, 473.21, 599.00, 'Efectivo', 'Cancelado'),
(4, '2017-05-13 13:07:38', 4, 39.50, 50.00, 'Efectivo', 'Completado'),
(5, '2017-05-13 13:11:04', 4, 7.90, 10.00, 'Tarjeta', 'Completado'),
(6, '2017-05-13 15:03:43', 4, 7773.60, 9840.00, 'Efectivo', 'Sin pagar'),
(7, '2017-05-13 15:08:16', 4, 7773.60, 9840.00, 'Efectivo', 'Sin pagar'),
(8, '2017-05-13 15:20:44', 4, 0.00, 0.00, 'Efectivo', 'Sin pagar'),
(9, '2017-05-13 15:21:27', 4, 7.90, 10.00, 'Tarjeta', 'Pagado');

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
  `stock` int(11) NOT NULL DEFAULT '0',
  `imagen` char(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productos`
--

INSERT INTO `productos` (`id`, `marca`, `modelo`, `precio`, `color`, `descripcion`, `stock`, `imagen`) VALUES
(1, 'Samsung', 'Galaxy S8', 809.00, 'Negro', 'Memoria RAM: 4GB\n\nBatería: 3000mAh\n\nPantalla: 5,8" SAMOLED\n\nAlmacenamiento: 64GB ampliables con microSD\n\n4G: LTE CAT16\n\nConector: USB Tipo C', 1498, 'galaxy-s8_gallery_back_black.png'),
(2, 'Samsung', 'Galaxy S8', 809.00, 'Orchid Grey', 'Memoria RAM: 4GB\n\nBatería: 3000mAh\n\nPantalla: 5,8" SAMOLED\n\nAlmacenamiento: 64GB ampliables con microSD\n\n4G: LTE CAT16\n\nConector: USB Tipo C', 1498, 'galaxy_s8_greyorchid.png'),
(3, 'Samsung', 'Galaxy S7 Edge', 550.00, 'Azul Coral', 'Memoria RAM: 4GB\n\nBatería: 3500mAh\n\nPantalla: 5,5" SAMOLED\n\nAlmacenamiento: 32GB ampliables con microSD\n\n4G: LTE CAT12\n\nConector: microUSB', 1498, 'galaxy-s7-edge-bluecoral.png'),
(4, 'Samsung', 'Galaxy S7 Edge', 550.00, 'Dorado', 'Memoria RAM: 4GB\n\nBatería: 3500mAh\n\nPantalla: 5,5" SAMOLED\n\nAlmacenamiento: 32GB ampliables con microSD\n\n4G: LTE CAT12\n\nConector: microUSB', 1498, 'Samsung-Galaxy-S7-edge-Gold.png'),
(5, 'Apple', 'iPhone 7', 769.00, 'Negro Brillante', 'Memoria RAM: 2GB\n\nBatería: 1969mAh\n\nPantalla: 4,7" IPS\n\nAlmacenamiento: 32GB\n\n4G: LTE CAT12\n\nConector: Lightning', 1498, 'iphone7-negrobrillante.png'),
(6, 'Apple', 'iPhone 7', 769.00, 'Plata', 'Memoria RAM: 2GB\n\nBatería: 1969mAh\n\nPantalla: 4,7" IPS\n\nAlmacenamiento: 32GB\n\n4G: LTE CAT12\n\nConector: Lightning', 1497, 'iphone7-silver.png'),
(7, 'Apple', 'iPhone 7 Plus', 909.00, 'Negro Brillante', 'Memoria RAM: 3GB\n\nBatería: 2900mAh\n\nPantalla: 5,5" IPS\n\nAlmacenamiento: 128GB\n\n4G: LTE CAT12\n\nConector: Lightning', 1497, 'iphone7-plus-jet-black_sku-header.png'),
(8, 'Apple', 'iPhone 7 Plus', 909.00, 'Oro Rosa', 'Memoria RAM: 3GB\n\nBatería: 2900mAh\n\nPantalla: 5,5" IPS\n\nAlmacenamiento: 32GB\n\n4G: LTE CAT12\n\nConector: Lightning', 1498, 'iphone7-plus-rosegold-select-2016.png'),
(9, 'LG', 'G5', 550.00, 'Oro', 'Memoria RAM: 4GB\n\nBatería: 2800mAh\n\nPantalla: 5,3" IPS\n\nAlmacenamiento: 32GB ampliables con microSD\n\n4G: LTE CAT12\n\nConector: USB Tipo C', 1498, 'lg-g5-gold.png'),
(10, 'LG', 'G5', 550.00, 'Gris', 'Memoria RAM: 4GB\n\nBatería: 2800mAh\n\nPantalla: 5,3" IPS\n\nAlmacenamiento: 32GB ampliables con microSD\n\n4G: LTE CAT12\n\nConector: USB Tipo C', 1498, 'LG-G5-gris.png'),
(11, 'LG', 'G6', 650.00, 'Negro', 'Memoria RAM: 4GB\n\nBatería: 3300mAh\n\nPantalla: 5,7" OLED\n\nAlmacenamiento: 32GB ampliables con microSD\n\n4G: LTE CAT12\n\nConector: USB Tipo C', 1498, 'LG-G6-negro.png'),
(12, 'Huawei', 'P9', 409.00, 'Blanco Cerámica', 'Memoria RAM: 3GB\n\nBatería: 3000mAh\n\nPantalla: 5,2" IPS\n\nAlmacenamiento: 32GB ampliables con microSD\n\n4G: LTE CAT12\n\nConector: USB Tipo C', 1498, 'Huawei_P9-Ceramic-White.png'),
(13, 'Huawei', 'P9', 409.00, 'Dorado', 'Memoria RAM: 3GB\n\nBatería: 3000mAh\n\nPantalla: 5,2" IPS\n\nAlmacenamiento: 32GB ampliables con microSD\n\n4G: LTE CAT12\n\nConector: USB Tipo C', 1498, 'Huawei-P9-Gold.png'),
(14, 'Huawei', 'P10', 599.00, 'Dorado', 'Memoria RAM: 4GB\n\nBatería: 3200mAh\n\nPantalla: 5,1" IPS\n\nAlmacenamiento: 64GB ampliables con microSD\n\n4G: LTE CAT12\n\nConector: USB Tipo C', 1498, 'huaweip10-gold.png'),
(15, 'Huawei', 'P10', 599.00, 'Blanco', 'Memoria RAM: 4GB\n\nBatería: 3200mAh\n\nPantalla: 5,1" IPS\n\nAlmacenamiento: 64GB ampliables con microSD\n\n4G: LTE CAT12\n\nConector: USB Tipo C', 1497, 'huaweip10-white.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `productoscomprados`
--

CREATE TABLE `productoscomprados` (
  `numeroPedido` int(10) UNSIGNED NOT NULL,
  `idProducto` int(10) UNSIGNED NOT NULL,
  `fechaCompra` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `productoscomprados`
--

INSERT INTO `productoscomprados` (`numeroPedido`, `idProducto`, `fechaCompra`) VALUES
(6, 1, '2017-05-13 15:03:43'),
(7, 1, '2017-05-13 15:08:16'),
(1, 2, '2017-05-13 12:55:11'),
(6, 2, '2017-05-13 15:03:43'),
(7, 2, '2017-05-13 15:08:16'),
(6, 3, '2017-05-13 15:03:43'),
(7, 3, '2017-05-13 15:08:16'),
(6, 4, '2017-05-13 15:03:43'),
(7, 4, '2017-05-13 15:08:16'),
(6, 5, '2017-05-13 15:03:43'),
(7, 5, '2017-05-13 15:08:16'),
(2, 6, '2017-05-13 13:01:37'),
(6, 6, '2017-05-13 15:03:43'),
(7, 6, '2017-05-13 15:08:16'),
(2, 7, '2017-05-13 13:01:37'),
(6, 7, '2017-05-13 15:03:43'),
(7, 7, '2017-05-13 15:08:16'),
(6, 8, '2017-05-13 15:03:43'),
(7, 8, '2017-05-13 15:08:16'),
(6, 9, '2017-05-13 15:03:43'),
(7, 9, '2017-05-13 15:08:16'),
(6, 10, '2017-05-13 15:03:43'),
(7, 10, '2017-05-13 15:08:16'),
(6, 11, '2017-05-13 15:03:43'),
(7, 11, '2017-05-13 15:08:16'),
(6, 12, '2017-05-13 15:03:43'),
(7, 12, '2017-05-13 15:08:16'),
(6, 13, '2017-05-13 15:03:43'),
(7, 13, '2017-05-13 15:08:16'),
(6, 14, '2017-05-13 15:03:43'),
(7, 14, '2017-05-13 15:08:16'),
(3, 15, '2017-05-13 13:03:23'),
(6, 15, '2017-05-13 15:03:43'),
(7, 15, '2017-05-13 15:08:16');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `reparaciones`
--

CREATE TABLE `reparaciones` (
  `numeroPedido` int(10) UNSIGNED NOT NULL,
  `proveedor` int(10) UNSIGNED NOT NULL,
  `diagnostico` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `reparaciones`
--

INSERT INTO `reparaciones` (`numeroPedido`, `proveedor`, `diagnostico`) VALUES
(4, 2, '---- Mensaje inicial ----\nMarca: Apple\nModelo: iPhone 6S\nObservaciones: El móvil no carga\n\n---- Informe de resultado ----\nHemos cambiado el conector de carga'),
(8, 4, 'Marca: Huawei\nModelo: P9 Lite\nObservaciones: Lector de huellas no funciona');

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
(1, 'admin', '21232f297a57a5a743894a0e4a801fc3', '2017-05-13 09:12:11', 'Administrador', 'Administrador', 'S/C', '600000000', '1970-01-01', '00000000T', 2),
(2, 'invitado', 'a6ae8a143d440ab8c006d799f682d48d', '2017-05-13 09:12:11', 'Invitado', 'Invitado', 'S/C', '600000000', '1970-01-01', '00000001R', 0),
(4, 'prueba', 'c893bad68927b457dbed39460e6afd62', '2017-05-13 12:53:16', 'Prueba', 'Probando', 'C/ Prueba', '654789123', '2017-05-13', '00000002W', 1);

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
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `nombre` (`nombre`);

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
  ADD PRIMARY KEY (`numeroPedido`,`idProducto`,`fechaCompra`),
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
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;
--
-- AUTO_INCREMENT de la tabla `pedidos`
--
ALTER TABLE `pedidos`
  MODIFY `numeroPedido` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT de la tabla `productos`
--
ALTER TABLE `productos`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
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
