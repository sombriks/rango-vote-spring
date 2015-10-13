create table restaurante(
  idrestaurante serial primary key,
  nomerestaurante varchar(255) not null,
  latrestaurante numeric(9,6) DEFAULT -30.1087957,
  lngrestaurante numeric(9,6) DEFAULT -51.3169918,
  zoomrestaurante integer DEFAULT 10,
);
