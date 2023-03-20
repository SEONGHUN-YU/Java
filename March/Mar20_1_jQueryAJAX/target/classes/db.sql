create table mar20_menu(
	m_name varchar2(10 char) primary key,
	m_price number(5) not null
);

create table mar20_product(
	p_name varchar2(10 char) primary key,
	p_price number(6) not null
);

select * from mar20_menu;
select * from mar20_product;

insert into mar20_menu values('야채김밥', 4000);
insert into mar20_product values('모니터', 10000);

