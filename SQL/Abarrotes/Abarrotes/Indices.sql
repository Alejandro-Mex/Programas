CREATE INDEX Producto_Nombre ON Producto(Nombre)

SELECT nombre fROM Producto
-------------------------------------------------------------------
CREATE INDEX Ventas_Por_Dia ON Ventas(fecha)

SELECT fecha FROM Ventas
-------------------------------------------------------------------
CREATE INDEX Detalle_Productos ON DetalleVenta(IdProducto)

SELECT idProducto FROM DetalleVenta
-------------------------------------------------------------------
CREATE INDEX Clientes_Nombre ON Clientes(nombre)

SELECT nombre FROM Clientes
-------------------------------------------------------------------