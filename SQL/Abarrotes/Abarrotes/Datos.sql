-- Ingresar productos
--Productos(idProducto, nombre, categoría, precio, stock),
INSERT INTO Producto(nombre,categoria,precio,stock) VALUES ('Coca cola Lata','Bebida',20,25), ('Coca cola 1.5L','Bebida', 25,10 ), 
('Cheetos Flamin','Sabritas', 15,20 ), ('Fab Ace','Detergente', 25, 8 ), ('Cheetos Bolitas','Sabritas', 15,10 ),
('Totopos','Tostada', 30,15 ), ('Coca cola 2.5L','Bebida', 15,25 ), ('Gatore','Bebida', 25,10 ),
('Tostitos','Sabritas', 20,20 ), ('Jabon Azul','Jabon', 5,9 ), ('Jabon Palmolime Coco','Jabon', 18,18 ),
('Fab Foca','Detergente', 20,10 ), ('Jabon Rosavenus','Jabon', 5,15 ), ('Jamon Pamolive Miel','Jabon', 18,10 ),
('powerAde 600ml','Bebida',27 ,15 ),('papel suavel 6pz','higiene', 34,8 ), ('suavitel en sueño 500ml','suavitel', 30,12 ),
('queso crema 500g','queso', 50,18 ), ('galleta Soda','Galleta', 22,7), ('Globitos Donde 250g','Galleta', 18,16 )
UPDATE Producto SET precio = 30, nombre = 'Coca de sabor' WHERE IdProducto = 21

-- INGRESAR CLIENTES
--Clientes(idCliente, nombre, dirección, teléfono),
INSERT INTO Clientes(nombre, direccion, telefono) VALUES ('Jorge Ramirez','calle Santa Ana','981 657 4321'), ('Alberto Lopez','calle rosas num 23','981 789 3490'),
('Emanuel Villareal','calle San martin','996 765 4321'), ('Alonso Jimenez','calle norte 46','996 123 4567'), 
('Nairobi Sanchez','calle Flores 43','981 123 4567'), ('Maria Tec','Chan-Chen','981 465 7985')

--INGRESAR EMPLEADOS
--Empleados(idEmpleado, nombre, puesto), 
INSERT INTO Empleados(nombre, puesto) VALUES ('Dinora Perez Chan','Supervisora'), ('Jazmin Chan Chan','Gerente'), 
 ('Diadeli Lopez Keb','Cajera'), ('Cinthia Ek Uc','Intendente'), ('Jesus Perez Coh','Jefe'), ('Jesus Mex', 'Cajero')

 --Ingresar ventas
 --Ventas(idVenta, fecha, idCliente, idEmpleado, total), 
 INSERT INTO Ventas(fecha,idCliente,idEmpleado,total) VALUES ('2025-8-25 12:00', 1, 6,50),('2025-8-25 15:00', 5, 3,60), ('2025-8-25 17:52', 4, 3,44), ('2025-8-25 21:40', 2,6,72),
 ('2025-8-26 18:42', 1, 6, 100), ('2025-8-27 15:00', 6, 3,85),('2025-8-27 18:10', 3,3,80), ('2025-8-27 21:45', 6,6,52), ('2025-8-28 11:00', 6,3,35), ('2025-8-28 16:00',1,6,36)
 

 --Ingresar detalle ventas
 --DetalleVenta(idDetalle, idVenta, idProducto, cantidad, precioUnitario, subtotal).
INSERT INTO DetalleVenta (idVenta,idProducto, cantidad, precioUnitario, subtotal) VALUES (1,1,1,20,20),(1,3,2,15,30),(2,4,1,25,25),(2,10,1,5,5),(2,17,1,30,30),
(3,19,2,22,44),(4,11,1,18,18), (4,16,1,34,34),(4,12,2,20,40),(5,18,2,50,100),(6,2,1,25,25),(6,6,2,30,60),(7,19,2,22,44),(7,20,2,18,36),(8,15,1,27,27),(8,8,1,25,25),
(9,5,1,15,15),(9,9,1,20,20),(10,11,1,18,18),(10,17,1,18,18)

INSERT INTO Ventas(fecha,idCliente,idEmpleado,total) VALUES ('2025-8-28 12:00', 1, 6,20)
INSERT INTO DetalleVenta (idVenta,idProducto, cantidad, precioUnitario, subtotal) VALUES (1,19,6,20,20)
Select * from Producto
select * from Ventas
select * from DetalleVenta