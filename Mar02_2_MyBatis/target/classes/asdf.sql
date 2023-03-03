create table mar02_snack(
	s_name varchar2(10 char) primary key,
	s_price number(4) not null
);

insert into MAR02_SNACK values('메로나', 5900);

select * from MAR02_SNACK;

-- JDBC, ConnectionPool : auto commit
-- MyBatis는 수동 commit

commit
rollback