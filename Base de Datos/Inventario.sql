Select current_database();

drop table if exists categoria;
create table categoria (
	cod_cat serial primary key not null,
	nombre varchar (100) not null,
	cat_padre int,
	constraint categoria_padre_fk
	foreign key (cat_padre)
	references categoria(cod_cat)
);

insert into categoria(nombre, cat_padre)
values ('Materia Prima', null),
('Proteína',1), ('Salsas',1),
('Punto de Venta',null),('Bebidas',4),
('Con Alcohol', 5),('Sin Alcohol',5);

select * from categoria;

drop table if exists categoria_unidad_medida;
create table categoria_unidad_medida(
	cod_cat_udm char(1) primary key not null,
	nombre varchar (100) not null
);

insert into categoria_unidad_medida(cod_cat_udm,nombre)
values ('U','Unidades'),('V','Volumen'),('P','Peso');

select * from categoria_unidad_medida;

drop table if exists unidad_medida;
create table unidad_medida(
	cod_udm char(2) primary key not null,
	cat_udm char(1) not null,
	descripcion varchar(100) not null,
	constraint cat_unidad_medida_fk
	foreign key (cat_udm)
	references categoria_unidad_medida(cod_cat_udm)
);

insert into unidad_medida (cod_udm,cat_udm,descripcion)
values ('ML','V','Mililítros'),('L','V','Litros'),
('U','U','Unidades'),('D','U','Docenas'),
('G','P','Gramos'),('Kg','P','Kilogramos'),('Lb','P','Libras');

select * from unidad_medida;

drop table if exists producto;
create table producto (
	cod_prod serial primary key not null,
	cod_udm char(2) not null,
	cod_cat int not null,
	nombre varchar(100) not null,
	precio_venta money not null,
	costo money not null,
	tiene_iva boolean not null,
	stock int not null,
	constraint cod_udm_producto_fk
	foreign key (cod_udm)
	references unidad_medida(cod_udm),
	constraint cod_cat_producto_fk
	foreign key (cod_cat)
	references categoria(cod_cat)
);

insert into producto (cod_udm,cod_cat,nombre,precio_venta, costo,tiene_iva,stock)
values ('U',7,'Coca Cola personal',0.5804, 0.3729, TRUE, 105),
('Kg',3,'Salsa de tomate',0.95, 0.8736, TRUE, 0),
('Kg',3,'Mostaza',0.95, 0.89, TRUE, 0),
('U',7,'Fuze Tea',0.8, 0.7, TRUE, 49);

select * from producto;

drop table if exists tipo_documento;
create table tipo_documento(
	codigo char(1) primary key not null,
	descripcion varchar(100) not null
);

insert into tipo_documento(codigo,descripcion)
values ('C','Cédula'),('R','RUC');

select * from tipo_documento;

drop table if exists proveedor;
create table proveedor(
	identificador varchar(15) primary key not null,
	tipo_documento char(1) not null,
	nombre varchar(100) not null,
	telefono varchar(10) not null,
	correo varchar(100) not null,
	direccion varchar(150) not null,
	constraint proveedor_documento_fk
	foreign key (tipo_documento)
	references tipo_documento(codigo)
);

insert into proveedor (identificador, tipo_documento, nombre, telefono, correo,direccion)
values ('1002285747','C','Antonio López', '0967821031','antonio@mail.com','Quito'),
('1712345674001','R','Snacks S.A', '0992920398','snacks@mail.com','Ibarra');

select * from proveedor;

drop table if exists estado_pedido;
create table estado_pedido(
	cod_estado char(1) primary key not null,
	descripcion varchar(100) not null
);

insert into estado_pedido (cod_estado,descripcion)
values ('S','Solicitado'),('R','Recibido');

select * from estado_pedido;

drop table if exists cabecera_pedido;
create table cabecera_pedido(
	cod_cab_ped serial primary key not null,
	proveedor varchar(15) not null,
	fecha Date not null,
	estado char(1) not null,
	constraint cabecera_pedido_proveedor_fk
	foreign key (proveedor)
	references proveedor(identificador),
	constraint cabecera_pedido_estado_fk
	foreign key (estado)
	references estado_pedido(cod_estado)
);

insert into cabecera_pedido (proveedor,fecha, estado)
values ('1002285747','2023-11-20','R'),('1712345674001','2023-11-20','R');

select * from cabecera_pedido;

drop table if exists detalle_pedido;
create table detalle_pedido(
	cod_det_ped serial primary key not null,
	cabecera_pedido int not null,
	producto int not null,
	cantidad_solicitada int not null,
	sub_total money not null,
	cantidad_recibida int not null,
	constraint detalle_cabecera_pedido_fk
	foreign key (cabecera_pedido)
	references cabecera_pedido(cod_cab_ped),
	constraint detalle_producto_pedido_fk
	foreign key (producto)
	references producto(cod_prod)
);

insert into detalle_pedido (cabecera_pedido,producto,cantidad_solicitada,sub_total,cantidad_recibida)
values (1,1,100,37.29,100),(1,4,50,11.8,50),(2,1,10,3.73,10);

select * from detalle_pedido;

drop table if exists historial_stock;
create table historial_stock (
	cod_his serial primary key not null,
	producto int not null,
	fecha timestamp not null,
	referencia varchar (100) not null,
	cantidad int not null,
	constraint historial_producto_fk
	foreign key (producto)
	references producto(cod_prod)
);

insert into historial_stock (producto, fecha,referencia,cantidad)
values (1,'2023-11-20 19:59','Pedido 1', 100),(4,'2023-11-20 19:59','Pedido 1', 50),
(1,'2023-11-20 20:00','Pedido 2', 10),(1,'2023-11-20 20:00','Venta 1', -5),
(4,'2023-11-20 20:00','Venta 1', 1);

select * from historial_stock;

drop table if exists cabecera_venta;
create table cabecera_venta(
	cod_cab_venta serial primary key not null,
	fecha timestamp not null,
	total_sin_iva money not null,
	iva money not null,
	total money not null
);

insert into cabecera_venta(fecha, total_sin_iva,iva,total)
values ('2023-11-20 20:00', 3.26,0.39,3.65);

select * from cabecera_venta;

drop table if exists detalle_venta;
create table detalle_venta(
	cod_det_venta serial primary key not null,
	cabecera_venta int not null,
	producto int not null,
	cantidad int not null,
	precio_venta money not null,
	sub_total money not null,
	sub_total_iva money not null,
	constraint cabecera_detalle_venta_fk
	foreign key (cabecera_venta)
	references cabecera_venta(cod_cab_venta),
	constraint detalle_producto_venta_fk
	foreign key (producto)
	references producto(cod_prod)
);

insert into detalle_venta (cabecera_venta,producto,cantidad,precio_venta,sub_total,sub_total_iva)
values (1,1,5,0.58,2.9,3.25),(1,4,1,0.36,0.36,0.4);

select * from detalle_venta;
