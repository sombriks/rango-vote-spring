--
-- versão inicial do banco
-- desenhado para trabalhar com postgresql
--

-- aqui temos os restaurantes
create table restaurante(
  idrestaurante serial primary key,
  nomerestaurante varchar(255) not null,
  latrestaurante numeric(9,6) DEFAULT -30.1087957,
  lngrestaurante numeric(9,6) DEFAULT -51.3169918,
  zoomrestaurante integer DEFAULT 10,
  fotorestaurante bytea
);

-- temos equipes também
create table equipe(
  idequipe serial primary key,
  nomeequipe varchar(255) not null
);

-- temos membros (o 'profissional faminto' da estória 1)
create table membro(
  idmembro serial primary key,
  idequipe integer not null,
  emailmembro varchar(255) not null,
  hashsenhamembro varchar(255) not null,
  fotomembro bytea,
  foreign key (idequipe) references equipe(idequipe)
);

-- temos votos
create table voto(
  dtvoto date not null,
  idrestaurante integer not null,
  idmembro integer not null,
  foreign key (idrestaurante) references restaurante(idrestaurante),
  foreign key (idmembro) references membro(idmembro),
  primary key (dtvoto,idmembro)
);

-- tabela com os ganhadores, pra facilitar a estória 2
-- só um ganhador por dia
create table ganhador(
  dtvitoria date primary key,
  idrestaurante integer not null,
  numvotosganhador integer not null,
  foreign key (idrestaurante) references restaurante(idrestaurante)
);

-- tabela com os usuários administradores
create table administrador(
  idadministrador serial primary key,
  emailadministrador varchar(255) not null,
  hashsenhaadministrador varchar(255) not null
);

-- view com o resultado das votações
create view vw_resultado_votacao as select
  dtvoto,idrestaurante,count(idmembro) as totvotos
from
  voto
group by
  dtvoto,idrestaurante
order by
  totvotos desc
limit 3;
