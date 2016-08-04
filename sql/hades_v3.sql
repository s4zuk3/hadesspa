/*==============================================================*/
/* table: cliente                                              */
/*==============================================================*/
create table cliente
(
   id_cliente           int not null,
   nombre_cliente       varchar(30),
   descripcion          varchar(400),
   primary key (id_cliente)
);

/*==============================================================*/
/* table: cotizacion                                            */
/*==============================================================*/
create table cotizacion
(
   id_cotizacion        int not null,
   id_usuario           int,
   fecha                date,
   primary key (id_cotizacion)
);

/*==============================================================*/
/* table: factura                                              */
/*==============================================================*/
create table factura
(
   id_factura           int not null,
   id_ot                int,
   id_cliente           int,
   fecha_emision        date,
   estado_factura       int,
   monto_factura        int,
   primary key (id_factura)
);

/*==============================================================*/
/* table: oc                                                    */
/*==============================================================*/
create table oc
(
   id_oc                int not null,
   fecha_creacion_oc    date,
   estado_oc            int,
   monto_oc             int,
   primary key (id_oc)
);

/*==============================================================*/
/* table: oc_ot                                                 */
/*==============================================================*/
create table oc_ot
(
   id_ot                int not null,
   id_oc                int not null,
   primary key (id_ot, id_oc)
);

/*==============================================================*/
/* table: ot                                                    */
/*==============================================================*/
create table ot
(
   id_ot                int not null,
   id_cotizacion        int,
   estado_ot            int,
   fecha_creacion_ot    date,
   primary key (id_ot)
);

/*==============================================================*/
/* table: usuario                                               */
/*==============================================================*/
create table usuario
(
   id_usuario           int not null,
   contrasena           varchar(30),
   nombre               varchar(30),
   token                varchar(100),
   cargo                char(15),
   primary key (id_usuario),
   key ak_id_usuario (id_usuario)
);


alter table cotizacion add constraint fk_crea foreign key (id_usuario)
      references usuario (id_usuario) on delete restrict on update restrict;

alter table factura add constraint fk_finalizada_mediante foreign key (id_ot)
      references ot (id_ot) on delete restrict on update restrict;

alter table factura add constraint fk_pagan foreign key (id_cliente)
      references cliente (id_cliente) on delete restrict on update restrict;

alter table oc_ot add constraint fk_necesita foreign key (id_ot)
      references ot (id_ot) on delete restrict on update restrict;

alter table oc_ot add constraint fk_necesita2 foreign key (id_oc)
      references oc (id_oc) on delete restrict on update restrict;

alter table ot add constraint fk_genera foreign key (id_cotizacion)
      references cotizacion (id_cotizacion) on delete restrict on update restrict;

