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

-- --------------------------------------------------
-- 아이디, 프사, 글번호, 글내용, 날짜
-- 글이 1000만개 회원이 100만명이면 터질 걸?

select bm_id, bm_photo, bs_no, bs_txt, bs_date
from bpbascp_member, bpbascp_sns
where bm_id = bs_writer; -- 이렇게 outer join 하면 안 됨

-- 글번호, 글쓴이, 글내용, 날짜만 날짜역순 조회(2~4번) #1
-- bs_no, bs_writer, bs_txt, bs_date

select * 
from(
	select rownum as rn, bs_no, bs_writer, bs_txt, bs_date 
	from(
		select *
		from bpbascp_sns
		where bs_writer like '%%' or bs_txt like '%%'
		order by bs_date desc
		)
	)
where rn >=2 and rn <=4;

-- 글쓴이id, 글쓴이프사만 날짜역순 조회(2~4번) #2
-- bm_id, bm_photo

select bm_id, bm_photo
from bpbascp_member
where bm_id in (
	select bs_writer 
	from(
		select rownum as rn, bs_no, bs_writer, bs_txt, bs_date 
		from(
			select *
			from bpbascp_sns
			where bs_writer like '%%' or bs_txt like '%%'
			order by bs_date desc
			)
		)
where rn >=2 and rn <=4
);

-- 최종 결과물
select bm_id, bm_photo, bs_no, bs_txt, bs_date -- bm_id as bs_writer로 해줘도 bs_writer로 인식한다
from

(select * 
from(
	select rownum as rn, bs_no, bs_writer, bs_txt, bs_date 
	from(
		select *
		from bpbascp_sns
		where bs_writer like '%%' or bs_txt like '%%'
		order by bs_date desc
		)
	)
where rn >=2 and rn <=4
), -- #1

(select bm_id, bm_photo
from bpbascp_member
where bm_id in (
	select bs_writer 
	from(
		select rownum as rn, bs_no, bs_writer, bs_txt, bs_date 
		from(
			select *
			from bpbascp_sns
			where bs_writer like '%%' or bs_txt like '%%'
			order by bs_date desc
			)
		)
	where rn >=2 and rn <=4)
) -- #2

where bm_id = bs_writer
order by bs_date desc;

-- --------------------------------------------------

-- 모든 회원 정보 가져와서 검사?
select * from bpbascp_member;
select * from bpbascp_sns;

-- ID, PW으로 가져와지면 성공
-- SQL injection공격에 위험
select * 
from bpbascp_member 
where bm_id = 'test' and bm_pw = '1234';

-- ID로 가져와서
-- DAO에서 PW검사해서 - o
select * 
from bpbascp_member 
where bm_id = 'test';
