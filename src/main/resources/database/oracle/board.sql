create table board (
  bno number primary key,
  btitle varchar(200) not null,
  bcontent varchar(4000) not null,
  bdate timestamp not null,  
  mid varchar(20) references member(mid),
  bhitcount number not null,
  battachoname varchar(100) null,
  battachsname varchar(100) null,
  battachtype varchar(100) null
);

create sequence seq_bno;

insert into board (bno, btitle, bcontent, bdate, mid, bhitcount, battachoname, battachsname, battachtype) 
values (seq_bno.nextval, 'Spring', 'Spring을 이용한 MVC 웹 애플리케이션', sysdate, 'user', 0, null, null, null);
commit;

