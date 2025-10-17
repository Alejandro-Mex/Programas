CREATE TRIGGER ActualizarStock
ON DetalleVenta 
AFTER INSERT
AS 
BEGIN
	DECLARE @Idproducto INT
	DECLARE @Vendida FLOAT
	DECLARE @Stock INT
	
	SELECT @Idproducto = DV.IdProducto, @Vendida = DV.cantidad FROM INSERTED DV

	IF (SELECT stock FROM Producto WHERE IdProducto = @Idproducto) >= @Vendida 
		UPDATE Producto SET stock = stock - @Vendida WHERE IdProducto = @Idproducto
	ELSE
		PRINT 'Stock insuficiente'
END