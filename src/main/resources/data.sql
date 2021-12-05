insert into usuario(id, nombre, apellido, email, password, telefono)
values (1, 'Daniel', 'Escobar', 'descobar@testemail.com', '$argon2id$v=19$m=2024,t=1,p=1$h16PyfLz46BwxzxLEh0PNA$aNGXSbsAc5PkiKJnw0dB46fW88xEfaCJCJTk7UpQPpU', '971123001');
insert into usuario(id, nombre, apellido, email, password, telefono)
values (2, 'Francisco', 'Martinez', 'fmartinez@testemail.com', '12345678', '971123002');
insert into usuario(id, nombre, apellido, email, password, telefono)
values (3, 'Roberto', 'Morey', 'rmorey@testemail.com', '12345678', '971123003');

alter sequence usuario_id_seq restart with 4;
