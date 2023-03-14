create table mar14_manager_request(
	mr_name varchar2(10 char) primary key,
	mr_price number(6) not null
);

insert into mar14_manager_request values('하하', 4321);

select * from mar14_manager_request;

create table mar14_bpbascp_macro(
	bm_no number(2) primary key,
	bm_comment varchar2(10 char) not null
);

create sequence mar14_bpbascp_macro_seq;

insert into mar14_bpbascp_macro values(mar14_bpbascp_macro_seq.nextval, '저런');

select * from mar14_bpbascp_macro;