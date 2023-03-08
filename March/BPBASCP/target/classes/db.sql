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

select * from bpbascp_member;
