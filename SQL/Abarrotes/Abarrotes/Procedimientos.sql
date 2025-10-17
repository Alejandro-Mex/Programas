-------Consultar ventas por cliente-------------------------

CREATE PROCEDURE sp_VentasPorCliente
					@IdCliente INT

AS
BEGIN

	SELECT v.IdVenta, v.Fecha, v.Total 
	FROM Ventas v
	WHERE v.IdCliente = @IdCliente;

END;

sp_VentasPorCliente 2

-------Consultas stock actual de productos--------------------

CREATE PROCEDURE sp_ConsultarStock 

AS
BEGIN

	SELECT Nombre, Stock
		FROM Producto
ORDER BY Stock

END;
GO

sp_ConsultarStock 
-------------------------------------------- Procesos de la practica------------------------------------------------------
CREATE PROCEDURE sp_consulta_productos
@cTexto VARCHAR(100) = ''
AS
	SELECT idProducto,
		   nombre,
		   categoria,
		   precio,
		   stock
	FROM Producto
	WHERE upper(trim(nombre)) LIKE '%' + upper(trim(@cTexto))+'%'
	ORDER BY idProducto
GO

sp_consulta_productos 'Coca';

CREATE PROCEDURE sp_borrarProducto
@idProducto INT
AS
BEGIN
	DELETE FROM Producto
	WHERE IdProducto = @idProducto
END;
GO

sp_borrarProducto 20

CREATE PROCEDURE sp_agregarProducto
@cNombre VARCHAR(100),
@cCategoria VARCHAR(50),
@fPrecio FLOAT,
@fStock FLOAT
AS
BEGIN
	INSERT INTO Producto(nombre,categoria,precio,stock)  VALUES
	(@cNombre,@cCategoria,@fPrecio,@fStock)
END;
GO

sp_agregarProducto 'Cheetos Queso','Sabritas',15,20

CREATE PROCEDURE sp_datos_producto
@idProducto INT
AS
BEGIN
	SELECT p.nombre, p.categoria, p.precio, p.stock
	FROM Producto p
	WHERE p.IdProducto = @idProducto
END;
GO

sp_datos_producto 21

CREATE PROCEDURE sp_actualizarProducto
@idProducto INT,
@cNombre VARCHAR(100),
@cCategoria VARCHAR(50),
@fPrecio FLOAT,
@fStock FLOAT
AS
BEGIN
	UPDATE Producto
	SET nombre = @cNombre, categoria = @cCategoria, precio = @fPrecio, stock = @fStock
	WHERE IdProducto = @idProducto
END;
GO

sp_actualizarProducto 5,'Doritos Nachos','Sabritas',15,10

SELECT * FROM Producto

Select * from Bitacora
