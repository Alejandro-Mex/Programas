--Número de venta, fecha, nombre del cliente, nombre del cajero, nombre del producto, 
--cantidad, precio unitario y subtotal.
--- Total

CREATE VIEW VentasDetalladas AS
SELECT
    V.IdVenta AS 'Numero de venta', V.fecha 'Fecha de venta', C.nombre AS 'Nombre del cliente',
	E.nombre AS 'Nombre del Cajero',P.nombre AS 'Nombre de producto', DV.cantidad AS 'Cantidad', 
	DV.precioUnitario AS 'Pecio unitario', DV.subtotal AS 'Subtotal', V.total 'Total'
FROM
	DetalleVenta AS DV
JOIN
	Ventas AS V ON DV.IdVenta = V.idVenta
JOIN 
	Clientes AS C ON V.idCliente = C.IdClientes
JOIN
	Empleados AS E ON V.IdEmpleado = E.IdEmpleado
JOIN
	Producto AS P ON DV.IdProducto = P.IdProducto

SELECT * FROM VentasDetalladas;
-----------------------------------------------------------------------------------------------
--mostrando el nombre del producto y la cantidad total vendida.

CREATE VIEW VentasProductos AS
SELECT
	P.nombre, Count(D.idProducto) * D.cantidad AS 'Cantidad vendida' 
FROM 
	Producto AS P 
JOIN
	DetalleVenta AS D On P.idProducto = D.idProducto
GROUP BY 
	P.idProducto, P.nombre, P.categoria, P.precio, P.stock, D.cantidad
SELECT * FROM VentasProductos;
---------------------------------------------------------------------------------------------
--mostrando los nombres de los clientes y su total de compras.
CREATE VIEW	ClientesCompras AS
SELECT
	  C.nombre AS 'Cliente' , SUM(V.total) AS 'Total de compra'
FROM
	Ventas AS V
join 
	Clientes AS C ON V.idCliente = C.idClientes
GROUP BY
	C.nombre,C.idClientes
SELECT * FROM ClientesCompras