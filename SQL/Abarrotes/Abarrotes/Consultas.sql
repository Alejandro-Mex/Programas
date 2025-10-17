--Consultas basicas
select * from Clientes
select * from Empleados
Select * from Producto
select * from Ventas
select * from DetalleVenta
------------------------------------------------------------------------------------------------------------------
select idVenta, fecha,total from ventas
------------------------------------------------------------------------------------------------------------------
select * from Clientes where telefono like '981%'

--Consultas intermedias

SELECT
    V.idVenta As 'Numero de venta',V.fecha AS 'Fecha',C.nombre AS 'Nombre Cliente', 
	E.nombre As 'Nombre Empleado', V.total AS 'Total de venta'
FROM
    Ventas AS V
JOIN
    Clientes AS C ON V.idCliente = C.idClientes
JOIN 
	Empleados AS E ON V.idEmpleado = E.idEmpleado
-----------------------------------------------------------------------------------------------------------

Select P.nombre AS 'Nombre del producto',  Count(D.idProducto) * D.cantidad AS 'Cantidad vendida' from Producto As P 
JOIN
	DetalleVenta AS D On P.idProducto = D.idProducto
	
	group by P.idProducto, P.nombre, P.categoria, P.precio, P.stock, D.cantidad

	Order by 'Cantidad vendida' DESC

--Consultas avanzadas-------------------------------------------------------------------------------------
--Utilizar CAST -----------------------------------------------------------------------------------
Select Sum(total) As 'Total de ventas del dia'  from Ventas 
where fecha between '2025-08-25 00:00:00.000' and '2025-08-25 23:59:59.000' 
--GROUP BY fecha
-----------------------------------------------------------------------------------------------
-- select * from Ventas group by idVenta,fecha,idCliente,total,idEmpleado having total >= 50

select
	 C.idClientes As 'IdCliente', C.nombre As 'Cliente' , SUM(V.total) As 'Total'
from 
	Ventas As V
join 
	Clientes As C on V.idCliente = C.idClientes
group by 
	C.nombre,C.idClientes
having
	Sum(V.total) > 100
----------------------------------------------------------------------------------------------
Select * from Producto where stock < 15