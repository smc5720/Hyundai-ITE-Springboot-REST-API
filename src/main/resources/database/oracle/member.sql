create table member (
  mid varchar(20) primary key,
  mname varchar(20) not null,
  mpassword varchar(200) not null,
  menabled number(1) not null, /*spring security에서 필요*/
  mrole varchar(50) not null, /*spring security에서 필요*/
  memail varchar(100) null
);

insert into member values ('admin', '총관리자', '{noop}12345', 1, 'ROLE_ADMIN', 'admin@mycompany.com');
insert into member values ('manager', '관리자', '{bcrypt}$2a$10$vI7tC2h4pDre.YqStwOl5uiT.H2bE/T5IkiZ0bDsWGw9wTgcDdUOa', 1, 'ROLE_MANAGER', 'manager@mycompany.com');
insert into member values ('user', '사용자', '{sha256}64c8cb002682d8136b5aca3e780651023a669c79046616f27659297bb0346027e70ee4ecf0670d21', 1, 'ROLE_USER', 'user@mycompany.com');
commit;

