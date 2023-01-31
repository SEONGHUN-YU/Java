-- 휴게소
-- 안동휴게소, 하행, 중앙고속도로에 있는, 주차 100대 가능
-- 소떡소떡, 간식, 2000원

-- 안동휴게소, 하행, 중앙고속도로에 있는, 주차 100대 가능
-- 와이퍼, 차량용품, 2000원

select * from jan30_shop;

create table jan30_restarea(
	r_no number(3) primary key,
	r_name varchar2(10 char) not null,
	r_toward varchar2(2 char) not null,
	r_area varchar2(10 char) not null,
	r_parking number(4) not null
);

create table jan30_shop(
	s_no number(3) primary key,
	s_name varchar2(10 char) not null,
	s_kind varchar2(10 char) not null,
	s_price number(7) not null,
	s_r_no number(3) not null
);

create sequence jan30_restarea_seq;
create sequence jan30_shop_seq;

insert into jan30_restarea values(jan30_restarea_seq.nextval, '안동휴게소', '하행', '중앙고속도로', 100);
insert into jan30_shop values(jan30_shop_seq.nextval, '서울소주', '간식', 3000, 1);

-- 상품명, 가격
-- 상품명 가나다 -> 가격 싼 순
select s_name, s_price
from jan30_shop
order by s_name, s_price;

-- 간식은 몇 종류
select count(s_name)
from jan30_shop
where s_kind = '간식';

-- 안동휴게소 상품 평균가
select avg(s_price)
from jan30_shop
where s_r_no in (
	select r_no
	from jan30_restarea
	where r_name = '안동휴게소'
);

-- 휴게소명, 방향, 위치, 상품명, 가격
-- 휴게소명 가나다 -> 상품명 가나다
select r_name, r_toward, r_area, s_name, s_price
from jan30_restarea, jan30_shop
where r_no = s_r_no
order by r_name, s_name;
	
-- 상품명, 가격
-- 상품명 가나다, 가격 싼 순
-- 2 ~ 4번만
-- rownum은 가상필드
select *
from(
	select rownum as rn, s_name, s_price
	from(
		select s_name, s_price
		from jan30_shop
		order by s_name, s_price
		)
	)
where rn >= 2 and rn <= 4;

-- 평균가
select avg(s_price)
from jan30_shop;

-- 카테고리별 평균가
select s_kind, avg(s_price)
from jan30_shop
group by s_kind;

-- 휴게소 방향별로 주차대수 평균
select r_toward, avg(r_parking)
from jan30_restarea
group by r_toward;

-- 휴게소 이름별 최고가
select r_name, max(s_price)
from jan30_restarea, jan30_shop
where r_no = s_r_no
group by r_name;

-- 휴게소 이름별 -> 카테별 최저가
select r_name, s_kind, min(s_price)
from jan30_restarea, jan30_shop
where r_no = s_r_no
group by r_name, s_kind;

-- 카테별 -> 방향별 평균가
select s_kind, r_toward, avg(s_price)
from jan30_shop, jan30_restarea
where s_r_no = r_no
group by s_kind, r_toward;
	
-- 4000원 이상인 상품만 카테별 평균가
-- 1800원 미만인 거 빼고 계산을 함(통계 자체에 영향이 감)
select s_kind, avg(s_price)
from jan30_shop
where s_price >= 4000
group by s_kind;
	
-- 카테별 평균가 결과가 1800원 미만인 거 안 볼래
-- 통계는 정상적으로 다 내고, 결과를 필터링 함 
select s_kind, avg(s_price)
from jan30_shop
group by s_kind
having avg(s_price) >= 1800;

-- 평균가 이상인 것만
-- 휴게소 이름별 -> 카테별 갯수
-- 갯수가 2개 이상인 것만 나오게
select r_name, s_kind, count(*)
from jan30_restarea, jan30_shop
where r_no = s_r_no and s_price >= (select avg(s_price) from jan30_shop)
group by r_name, s_kind
having count(*) >= 2
order by r_name, s_kind;
-----------------------------------
-- DBA : DB관리자 <- 우리 목표가 아님
--		DB를 활용해서 분석/프로그램 만드는 사람
-- Data CRUD <- 우리 목표
create table - x
create sequence - x
drop table - x -- 다들 우리가 할 일은 아닐듯 함
-- C - insert
-- R - select
-- U - update
-----------------------------------
update 테이블명
set 필드명 = 값, 필드명 = 값, ...
where 조건식;
-----------------------------------

-- 소떡소떡을 1000원으로 수정
update jan30_shop
set s_price = 1000
where s_name = '소떡소떡';

-- 안동 하행 간식 0원으로 수정
update jan30_shop
set s_price = 0
where s_r_no = (
	select r_no
	from jan30_restarea
	where r_name = '안동휴게소' and r_toward = '하행'
	) and s_kind = '간식';
	
update jan30_restarea set r_park = ? where r_name = ?

-- 간식류 10% 인상
update jan30_shop
set s_price = s_price * 1.1
where s_kind = '간식';

-- 주차대수 제일 많은 휴게소
-- 평균가보다 비싼 상품
-- 20% 할인
update jan30_shop set s_price = s_price * 0.8
where s_r_no in (
	select r_no 
	from jan30_restarea 
	where r_parking = (
		select max(r_parking) 
		from jan30_restarea
		)
	) and s_price > (
	select avg(s_price) 
	from jan30_shop
	);

-- D - delete
delete from 테이블명
where 조건식;

-- 0원짜리 삭제
delete from jan30_shop
where s_price = 0;

-- 차량용품류 삭제
delete from jan30_shop
where s_kind = '차량용품';

-- 주차대수 제일 적은 휴게소 폐업
delete from jan30_restarea
where r_parking = (
	select min(r_parking)
	from jan30_restarea
	);
	
----------------------------------------------------------------------
-- foreign key 쓰는 법
-- constraint 조건이름
--		foreign key (필드명) references 테이블명(필드명)
--		on delete cascade
----------------------------------------------------------------------
	
-- 없는 휴게소 번호로 상품 등록 못하게 <- 이걸 구현해보자
-- 휴게소 지워지면 상품 좀 쓸려나갔으면 할 때
create table jan30_product(
	s_no number(3) primary key,
	s_name varchar2(10 char) not null,
	s_kind varchar2(10 char) not null,
	s_price number(7) not null,
	s_r_no number(3) not null,
	constraint jan30_restarea_destroy
		foreign key (s_r_no) references jan30_restarea(r_no)
		on delete cascade
);
-- s_r_no는 휴게소 테이블에 있는 r_no 이고
-- 그 r_no에 해당하는 휴게소가 삭제될 때 상품도 자동삭제 라는 뜻
insert into jan30_product
values(jan30_shop_seq.nextval, '테스트', '테스트', 0, 2); -- s_r_no가 2인 애를 만듬

delete from jan30_restarea where r_no = 2; -- r_no가 2인 애를 지운다

select * from jan30_restarea;
select * from jan30_product; -- 확인해보니 지워졌음

-- 이걸 이용해서 아래 같이 만들 수 있다

-- 계정
-- 글
--		계정 탈퇴하면 글 지워지게
-- 댓글
--		글 지워지면 댓글 지워지게