
-- equipes
insert into equipe (nomeequipe) values ('Equipe 1');
insert into equipe (nomeequipe) values ('Equipe 2');
insert into equipe (nomeequipe) values ('Equipe 3');

commit;

-- membros (idequipe,email,123456)
insert into membro (idequipe,emailmembro,hashsenhamembro) values (1,'email1@email1.com','e10adc3949ba59abbe56e057f20f883e');
insert into membro (idequipe,emailmembro,hashsenhamembro) values (1,'email1@email2.com','e10adc3949ba59abbe56e057f20f883e');
insert into membro (idequipe,emailmembro,hashsenhamembro) values (1,'email1@email3.com','e10adc3949ba59abbe56e057f20f883e');
insert into membro (idequipe,emailmembro,hashsenhamembro) values (1,'email1@email4.com','e10adc3949ba59abbe56e057f20f883e');
insert into membro (idequipe,emailmembro,hashsenhamembro) values (1,'email1@email5.com','e10adc3949ba59abbe56e057f20f883e');

insert into membro (idequipe,emailmembro,hashsenhamembro) values (2,'email2@email1.com','e10adc3949ba59abbe56e057f20f883e');
insert into membro (idequipe,emailmembro,hashsenhamembro) values (2,'email2@email2.com','e10adc3949ba59abbe56e057f20f883e');
insert into membro (idequipe,emailmembro,hashsenhamembro) values (2,'email2@email3.com','e10adc3949ba59abbe56e057f20f883e');
insert into membro (idequipe,emailmembro,hashsenhamembro) values (2,'email2@email4.com','e10adc3949ba59abbe56e057f20f883e');
insert into membro (idequipe,emailmembro,hashsenhamembro) values (2,'email2@email5.com','e10adc3949ba59abbe56e057f20f883e');

insert into membro (idequipe,emailmembro,hashsenhamembro) values (3,'email3@email1.com','e10adc3949ba59abbe56e057f20f883e');
insert into membro (idequipe,emailmembro,hashsenhamembro) values (3,'email3@email2.com','e10adc3949ba59abbe56e057f20f883e');
insert into membro (idequipe,emailmembro,hashsenhamembro) values (3,'email3@email3.com','e10adc3949ba59abbe56e057f20f883e');
insert into membro (idequipe,emailmembro,hashsenhamembro) values (3,'email3@email4.com','e10adc3949ba59abbe56e057f20f883e');
insert into membro (idequipe,emailmembro,hashsenhamembro) values (3,'email3@email5.com','e10adc3949ba59abbe56e057f20f883e');

commit;

-- restaurantes
insert into restaurante (nomerestaurante) values ('Restaurate 01');
insert into restaurante (nomerestaurante) values ('Restaurate 02');
insert into restaurante (nomerestaurante) values ('Restaurate 03');
insert into restaurante (nomerestaurante) values ('Restaurate 04');
insert into restaurante (nomerestaurante) values ('Restaurate 05');
insert into restaurante (nomerestaurante) values ('Restaurate 06');
insert into restaurante (nomerestaurante) values ('Restaurate 07');
insert into restaurante (nomerestaurante) values ('Restaurate 08');
insert into restaurante (nomerestaurante) values ('Restaurate 09');
insert into restaurante (nomerestaurante) values ('Restaurate 11');
insert into restaurante (nomerestaurante) values ('Restaurate 12');
insert into restaurante (nomerestaurante) values ('Restaurate 13');
insert into restaurante (nomerestaurante) values ('Restaurate 14');
insert into restaurante (nomerestaurante) values ('Restaurate 15');
insert into restaurante (nomerestaurante) values ('Restaurate 16');
insert into restaurante (nomerestaurante) values ('Restaurate 17');
insert into restaurante (nomerestaurante) values ('Restaurate 18');
insert into restaurante (nomerestaurante) values ('Restaurate 19');
insert into restaurante (nomerestaurante) values ('Restaurate 20');
insert into restaurante (nomerestaurante) values ('Restaurate 21');

-- administrador
insert into administrador (emailadministrador,hashsenhaadministrador) values ('admin@admin.com','e10adc3949ba59abbe56e057f20f883e');
