create table mar03_snack(
	s_no number(3) primary key,
	s_name varchar2(10 char) not null,
	s_price number(5) not null,
	s_exp date not null
);

create sequence mar03_snack_seq;
drop sequence mar03_snack_seq;
drop table mar03_snack cascade constraint purge;

insert into mar03_snack values(mar03_snack_seq.nextval, '마이쮸', 500, sysdate);

select * from mar03_snack;

