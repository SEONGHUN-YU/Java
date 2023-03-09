-- 프로젝트 설계 -> DB -> JavaBean -> mapper.xml + interface
-- -> DAO -> C -> V

-- 아이디 중복검사, 비번, 주소, 프사
create table bpbascp_member(
	bm_id varchar2(10 char) primary key,
	bm_pw varchar2(10 char) not null,
	bm_name varchar2(10 char) not null,
	bm_birthday date not null,
	bm_address varchar2(100 char) not null,
	bm_photo varchar2(200 char) not null
);

create table bpbascp_sns(
	bs_no number(3) primary key,
	bs_writer varchar2(10 char) not null,
	bs_txt varchar2(300 char) not null,
	bs_date date not null,
	constraint sns_writer foreign key (bs_writer) references bpbascp_member(bm_id) on delete cascade
);
create sequence bpbascp_sns_seq;
select * from bpbascp_sns;


-- 모든 회원 정보 가져와서?
select * from bpbascp_member;

-- id, pw으로 가져와지면 성공
-- SQL injection공격에 위험
select * 
from bpbascp_member 
where bm_id = 'test' and bm_pw = '1234';

-- id로 가져와서
-- DAO에서 pw검사해서 - o
select * 
from bpbascp_member 
where bm_id = 'test';
