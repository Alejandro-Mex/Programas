
SELECT * FROM Bitacora

CREATE TABLE Bitacora(
	IdBitacora INT PRIMARY KEY IDENTITY(1,1),
	IdProducto INT NOT NULL,
	Nombre_Anterior VARCHAR(100),
	Categoria_Anterior VARCHAR(100),
	Precio_Anterior DECIMAL(10,2),
	Strock_Anterior INT,
	Nombre_Nuevo VARCHAR(100),
	Categoria_Nueva VARCHAR(50),
	Precio_Nuevo DECIMAL(10,2),
	Stock_Nuevo INT,
	Fecha_Cambio DATETIME DEFAULT GETDATE(),
	UsuarioSistema VARCHAR(100) DEFAULT SYSTEM_USER
);


---Trigger----------------------------------

CREATE TRIGGER trg_BitacoraProductos
ON Producto
AFTER UPDATE
AS
BEGIN
	INSERT INTO Bitacora (
		IdProducto,
		Nombre_Anterior, Categoria_Anterior,Precio_Anterior, Strock_Anterior,
		Nombre_Nuevo, Categoria_Nueva, Precio_Nuevo, Stock_Nuevo
	)
	SELECT
		C.IdProducto,
		C.Nombre, C.Categoria, C.Precio, C.stock,
		A.Nombre, A.Categoria, A.Precio, A.stock
	FROM deleted C
	INNER JOIN inserted A ON C.IdProducto = C.IdProducto;
END;
GO