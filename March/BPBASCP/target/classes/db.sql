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

create table bpbascp_sns_reply(
	bsr_no number(4) primary key,
	bsr_bs_no number(3) not null,
	bsr_writer varchar2(10 char) not null,
	bsr_txt varchar2(300 char) not null,
	bsr_date date not null,
	constraint sns_reply foreign key (bsr_bs_no) references bpbascp_sns(bs_no) on delete cascade,
	constraint sns_reply_writer foreign key (bsr_writer) references bpbascp_member(bm_id) on delete cascade
);

create table bpbascp_dataroom(
	bd_no number(3) primary key,
	bd_uploader varchar2(10 char) not null,
	bd_title varchar2(50 char) not null,
	bd_file varchar2(300 char) not null,
	bd_date date not null,
	constraint dataroom_uploader foreign key (bd_uploader) references bpbascp_member(bm_id) on delete cascade
);

create sequence bpbascp_sns_reply_seq;
create sequence bpbascp_sns_seq;
create sequence bpbascp_dataroom_seq;

select * from bpbascp_member;
select * from bpbascp_sns;
select * from bpbascp_sns_reply;
select * from bpbascp_dataroom;

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
-- subquery : 줄어서
-- join : 폭증해서
-- join 최대한 안 쓰려고 해야

-- 자료실 테이블에서 제목순 정렬 2 ~ 4번 #1
select *
from(
	select rownum as rn, bd_no, bd_uploader, bd_title, bd_file, bd_date
	from(
		select bd_no, bd_uploader, bd_title, bd_file, bd_date
		from bpbascp_dataroom
		order by bd_title
		)
	)
where rn >= 2 and rn <= 4

-- 자료실 테이블에서 제목순 정렬 2 ~ 4번까지를 업로드한 멤버 #2
select bm_id, bm_photo
from bpbascp_member
where bm_id in 
	(
	select bd_uploader
	from(
		select rownum as rn, bd_no, bd_uploader, bd_title, bd_file, bd_date
		from(
			select bd_no, bd_uploader, bd_title, bd_file, bd_date
			from bpbascp_dataroom
			order by bd_title
			)
		)
	where rn >= 2 and rn <= 4
	)

-- 최종 결과물
select bd_no, bd_uploader, bd_title, bd_file, bd_date, bm_photo 
from (
select *
from(
	select rownum as rn, bd_no, bd_uploader, bd_title, bd_file, bd_date
	from(
		select bd_no, bd_uploader, bd_title, bd_file, bd_date
		from bpbascp_dataroom
		order by bd_title
		)
	)
where rn >= 2 and rn <= 4),
(select bm_id, bm_photo
from bpbascp_member
where bm_id in 
		(
		select bd_uploader
		from(
			select rownum as rn, bd_no, bd_uploader, bd_title, bd_file, bd_date
			from(
				select bd_no, bd_uploader, bd_title, bd_file, bd_date
				from bpbascp_dataroom
				order by bd_title
				)
			)
		where rn >= 2 and rn <= 4
		)
	)
where bd_uploader = bm_id
order by bd_title;
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