insert into usuario (id_usuario, contrasena, nombre, token, cargo)
values
(17677686, 'asd123', 'Francisco', 'U06Bqauja0EPodjrcSWH','Gerente General'),
(18311321, 'asd123', 'Joaquin', 'tDArH5IrCWEo1bMBfBn0','Gerente General'),
(5118321, 'asd123', 'Benjamin', 'BKc9nYUNs2MtwHXvWlzv','Gerente General');

insert into cliente (id_cliente, nombre_cliente, descripcion)
values
(23555235, 'Facturaciones S.A.', 'Empresa dedicada al rubro de Facturar'),
(89553135, 'Google S.A.', 'Empresa dedicada al rubro de Googlear'),
(2512221, 'Lopez S.A.', 'Empresa dedicada al rubro de Lopear');

insert into cotizacion (id_cotizacion, id_usuario, fecha)
values
(581, 17677686, '2016/05/15 23:15:00'),
(582, 17677686, '2016/05/15 23:15:00'),
(721, 18311321, '2016/05/15 23:15:00');

insert into ot (id_ot, id_cotizacion, estado_ot, fecha_creacion_ot)
values
(122, 581, 1,'2016/05/15 23:15:00'),
(123, 582, 1,'2016/05/15 23:15:00'),
(124, 721, 1,'2016/05/15 23:15:00');

insert into oc (id_oc, fecha_creacion_oc, estado_oc, monto_oc)
values
(7721, '2016/05/15 23:15:00',1,150000),
(7795, '2016/05/15 23:15:00',1,200000),
(7811, '2016/05/15 23:15:00',1,500123);


insert into oc_ot (id_ot, id_oc)
values
(122,7721),
(122,7795),
(123,7811);

insert into factura (id_factura, id_ot, id_cliente, fecha_emision, estado_factura, monto_factura)
values
(8821,122,23555235,'2016/05/15 23:15:00',1,500000),
(8822,123,23555235,'2016/05/15 23:15:00',1,1500000),
(8823,124,23555235,'2016/05/15 23:15:00',1,2500000);

