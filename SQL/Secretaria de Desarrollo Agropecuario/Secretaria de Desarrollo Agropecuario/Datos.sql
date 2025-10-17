INSERT INTO Usuario(NombreUsuario,Clave) VALUES ('MariaTec021','Maria1'), ('AloRamos1','Alondra'),
('JesusMex','Mex20');
SELECT * FROM Usuario;

INSERT INTO Municipio(NombreMunicipio) VALUES ('Campeche'),('Hopelchen'),('Champoton');
SELECT * FROM Municipio;

INSERT INTO Sexo(NombreSexo) VALUES ('Macho'),('Hembra');
SELECT * FROM Sexo;

INSERT INTO Especies(NombreEspecie) VALUES ('Bovinos'),('Ovinos'),('Caprinos'),('Porcinos');
SELECT * FROM Especies;

INSERT INTO Propietario(Nombre,ApellidoPaterno,ApellidoMaterno,Edad,Curp,Telefono,Correo,FechaRegistro,
IdSexo,IdMunicipio,IdUsuario) VALUES ('Maria Leticia','Tec','Coh',21,'TECM13251HYS45HY45','6549871463','maria@gmail.com',
'2025-09-15',2,2,1)
SELECT * FROM Propietario;

INSERT INTO Rancho(NombreRancho,GpsLatitud,GpsLongitud,IdMunicipio,IdPropietario) VALUES
('Rancho La Esperanza', '19°12"13.5" N','89°15"49.0" W',2,1);
SELECT * FROM Rancho

INSERT INTO Empleado(Nombre,ApellidoPaterno,ApellidoMaterno,Edad,Curp,Oficio,Telefono,
FechaRegistro,Correo,IdSexo,IdPropietario,IdUsuario) VALUES ('Alondra Guadalupe','Ramos','Perez',
22,'RAPA124589GTRSHA12','Capatas','6547194967',GETDATE(),'Alondra@gmail.com',2,1,2),('Jesus 
Alejandro','Mex','Damian',21,'MEDJ129754HEYSTR45','Peon','6321359741',GETDATE(),'Jesus@gmail.com'
,1,1,3)
SELECT * FROM Empleado;

INSERT INTO Animal(Folio,Raza,NumeroArete,FechaNacimiento,Procedencia,Peso,Color,Caracter,Foto,
FechaRegistro,IdEspecie,IdPropietario,IdSexo,IdRancho,IdEmpleado) VALUES ('SPEI-0000001','Angus',
'001','2024-12-22','Criado desde ternero',450,'Cafe','Agresivo','Ubicacion de la foto',GETDATE(),
1,1,3,1,1),('SPEI-0000002','Beefmaster','002','2024-12-24','Criado desde ternero',500,'Negro',
'Agresivo','Ubicacion de la foto',GETDATE(),1,1,3,1,2);
SELECT * FROM Animal;

INSERT INTO Enfermedad(NombreEnfermedad,FechaContagio,Comentario,IdAnimal) VALUES 
('Rabia Paralítica Bovina','2025-4-9','El animal enfermo por la mordida de un murcielago
revisar en 3 dias', 1);
SELECT * FROM Enfermedad

INSERT INTO Vacuna(NombreVacuna,FechaAplicacion,Comentario,IdAnimal) VALUES ('Derri A Plus',
'2024-6-10','Vacuna que previene la Rabia Paralítica Bovina',1);
SELECT * FROM Vacuna;

INSERT INTO Venta(Peso,Precio,FechaVenta,IdAnimal) VALUES (500,120000,GETDATE(),2);
SELECT * FROM Venta