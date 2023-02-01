// 편의점 이벤트
// 매니저들이 자꾸 아이스크림/과자 사오라고 해서
// 1. 간식등록
// 2. 편의점등록
// 3. 간식조회

// GS25, 서초점, 서초동123에 있는
// 2023-05-05까지 먹어야하는, 하겐다즈 바닐라맛, 5000원짜리

create table cvs(
	c_no number(3) primary key,
	c_name varchar2(10 char) not null,
	c_location varchar2(8 char) not null,
	c_addr varchar2(12 char) not null
);
drop table snack cascade constraint purge;
create table snack(	
	s_no number(3) primary key,
	s_name varchar2(10 char) not null,
	s_price number(8) not null,
	s_exp date not null,
	s_c_no number(3) not null,
	constraint cvs_snack
		foreign key (s_c_no) references cvs(c_no)
		on delete cascade
);

create sequence cvs_seq;
create sequence snack_seq;
