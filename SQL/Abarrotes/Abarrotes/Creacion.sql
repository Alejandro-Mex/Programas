create database abarrotes;

--Productos(idProducto, nombre, categoría, precio, stock), 

create table Producto (
	IdProducto  int identity not null primary key,
	nombre varchar(100) not null,
	categoria varchar(50) not null,
	precio float not null,
	stock float not null
)

--Clientes(idCliente, nombre, dirección, teléfono),

create table Clientes (
	IdClientes int identity not null primary key,
	nombre varchar(100) not null,
	direccion varchar(50) not null,
	telefono varchar(12) not null
)

--Empleados(idEmpleado, nombre, puesto), 

create table Empleados(
	IdEmpleado int identity not null primary key,
	nombre varchar(100) not null,
	puesto varchar(50) not null
)

--Ventas(idVenta, fecha, idCliente, idEmpleado, total), 

create table Ventas (
	IdVenta int identity not null primary key,
	fecha DateTime not null,
	IdCliente int not null,
	IdEmpleado int not null,
	total float not null,
	Constraint FK_IDCLIENTE ForeIGN key (IdCliente) References Clientes(IdClientes),
	Constraint FK_IDEMPLEADO FOREIGN KEY (IdEmpleado) REFERENCES Empleados(IdEmpleado)

)

--DetalleVenta(idDetalle, idVenta, idProducto, cantidad, precioUnitario, subtotal).

create table DetalleVenta(
	IdDetalle int identity not null primary key,
	IdVenta int not null,
	IdProducto int not null,
	cantidad float not null,
	precioUnitario float not null,
	subtotal float not null
	CONSTRAINT FK_IDVENTA FOREIGN KEY (IdVenta) REFERENCES Ventas(IdVenta),
	CONSTRAINT FK_IDPRODUCTO FOREIGN KEY (IdProducto) REFERENCES Producto(IdProducto)

)