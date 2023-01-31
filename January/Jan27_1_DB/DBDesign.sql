-- DB
--		RDB계열
--			OracleDB, MySQL, MariaDB, MSSQL, ...
--		NoSQL계열
--			MongoDB, Elasticsearch, ...

-- RDBMS(Relational DB Management System)
-- 관계형DB : 테이블을 나눠서 설계하고
--			테이블간의 관계를 중심으로 풀어나감
			
-- 1. record 하나에는 하나의 정보만 넣는다
-- 2. 주제별로 테이블을 나눈다
-- 3. 테이블간의 관계를 따져본다
--		사장 m : 식당 n
--		식당 1 : 메뉴 n <- 연결해줄 key 필요
--		  사장 : 메뉴 ?? 이 둘은 아무런 연관이 없지

-- 식당 프랜차이즈
-- 수원사는, 홍길동, 1999-1-1생 // <- 사장
-- 김밥천국, 강남점, 서초동123, 10테이블 // <- 식당
-- 야채김밥, 4000원 // <- 메뉴

drop table jan27_run cascade constraint purge;
drop table jan27_ceo cascade constraint purge;
drop table jan27_rest cascade constraint purge;
drop table jan27_menu cascade constraint purge;

create table jan27_run(
	r_no number(3) primary key,
	r_c_no number(3) not null,
	r_r_no number(3) not null
);

create table jan27_ceo(
	c_no number(3) primary key,
	c_name varchar2(10 char) not null,
	c_birth date not null,
	c_home varchar2(10 char) not null
);
create table jan27_rest(
	r_no number(3) primary key,
	r_name varchar2(10 char) not null,
	r_area varchar2(10 char) not null,
	r_address varchar2(10 char) not null,
	r_table number(3) not null
);

create table jan27_menu(
	m_no number(3) primary key,
	m_menu varchar2(10 char) not null,
	m_price number(7) not null,
	m_r_no number(3) not null
);

create sequence jan27_run_seq;
create sequence jan27_ceo_seq;
create sequence jan27_rest_seq;
create sequence jan27_menu_seq;

drop sequence jan27_run_seq;
drop sequence jan27_ceo_seq;
drop sequence jan27_rest_seq;
drop sequence jan27_menu_seq;

select * from jan27_ceo;
select * from jan27_rest;
select * from jan27_run;
select * from jan27_menu;

insert into jan27_ceo values(jan27_ceo_seq.nextval, '홍길동', to_date('19990101', 'YYYYMMDD'), '수원');
insert into jan27_rest values(jan27_rest_seq.nextval, '김밥천국', '서초점', '서초동', 10);
insert into jan27_menu values(jan27_menu_seq.nextval, '야채김밥', 4000, 1);
insert into jan27_run values(jan27_run_seq.nextval, 1, 1)

-- 전체 메뉴명, 가격
select m_menu, m_price
from jan27_menu;

-- 전체 식당명, 지점명, 위치
select r_name, r_area, r_address
from jan27_rest;

-- 김밥시리즈 메뉴명, 가격 // 글자 포함 검색은 like
select m_menu, m_price
from jan27_menu
where m_menu like '%밥%';

-- 최연장자 사장님 이름, 생일
select c_name, c_birth
from jan27_ceo
where c_birth = (select min(c_birth)
from jan27_ceo);

-- 프랜차이즈 평균 식당 테이블 수
select count(r_table)
from jan27_rest;

-- 7000원 이하 메뉴명, 가격
select m_menu, m_price
from jan27_menu
where m_price <= 7000;

-- subquery 쓰는 이유 (subquery 결과값은 하나만 나와야 한다) // r_no = 1,2; 은 틀리다는 뜻
-- 1. where절에 통계함수를 못 써서
-- 2. 테이블간의 관계를 맺어줄 때
--		subquery의 결과는 하나만 나와야 한다 (r_no = 1,2; <- 는 틀리다는 뜻)
--		subqyery의 결과를 여러개 넣어주고 싶을 때 in을 쓴다 *중요

-- 위에서부터 안쪽으로 하나씩 들어간다
-- 김밥천국 메뉴명, 가격
select m_menu, m_price
from jan27_menu
where m_r_no in (
	select r_no
	from jan27_rest
	where r_name = '김밥천국'
	);

-- 처음에 연결된 것부터 쓰고 그 위에 덮는다 (안쪽에서 부터)
-- 최고가 메뉴를 파는 식당명, 지점명 
select r_name, r_area
from jan27_rest
where r_no = (
	select m_r_no
	from jan27_menu
	where m_price = (
		select max(m_price)
		from jan27_menu
		)
	);

-- 제일 작은 식당에서 파는 메뉴 평균가
select avg(m_price)
from jan27_menu
where m_r_no = (
	select r_no
	from jan27_rest
	where r_table = (
		select min(r_table)
		from jan27_restaurant
		)
	);
	
-- 홍길동이 운영하는 매장명, 지점명, 위치
select r_name, r_area, r_address
from jan27_rest
where r_no in (
	select r_r_no
	from jan27_run
	where r_c_no in (
		select c_no
		from jan27_ceo
		where c_name = '홍길동'
		)
	);
	
-- 최연소 사장님네 메뉴명, 가격 *1
select m_menu, m_price
from jan27_menu
where m_r_no in (
	select r_r_no
	from jan27_run
	where r_c_no = (
		select c_no
		from jan27_ceo
		where c_birth = (
			select max(c_birth)
			from jan27_ceo)
		)
	);
	
-- join (데이터 조회 테크닉)
--		outer join : 모든 경우의 수 별로 다 만듬 (이게 default)
--		inner join : outer join 시키고, 제대로 된 것만 추출
	
-- 식당명, 지점명, 메뉴명, 가격
select r_name, r_area, m_menu, m_price
from jan27_rest, jan27_menu; -- 여기까지만 하면 outer join
where r_no = m_r_no; 

-- 사장이름, 생일, 식당명, 지점명
select c_name, c_birth, r_name, r_area
from jan27_ceo, jan27_run, jan27_rest
where c_no = r_c_no and r_r_no = jan27_rest.r_no; -- 필드명 중복될 때는 [테이블.필드명]해서 this. 처럼 연결해줄 수 있다

-- 평균가보다 비싼 메뉴의 식당명, 메뉴명, 가격
select r_name, m_menu, m_price
from jan27_rest, jan27_menu
where r_no = m_r_no and m_price > (
	select avg(m_price)
	from jan27_menu
	);
	
-- 최연소 사장님네 메뉴명, 가격 (쉽지만, 매우 비효율적인, 안 좋은 방법) *1
select m_menu, m_price
from jan27_ceo, jan27_run, jan27_menu
where c_no = r_c_no and r_r_no = m_r_no and c_birth = (
	select max(c_birth)
	from jan27_ceo
	);
	
-- 사장님 데이터가 4개 -> subquery를 쓰면 사장님 데이터가 1개로 줄어든다
-- subquery나 join 결과는 변수에 저장할텐데 => RAM에

-- subquery vs join
--		subquery : 수행하면 데이터 갯수가 줄어듬
--			1TB -> 1kb로 줄여서 RAM에 저장
--		join : 수행하면 데이터 갯수가 폭증함
--			1TB -> 100TB로 늘려서 RAM에 저장 <- 이게 될리가 있냐??
-- join은 최대한 안 쓰려고 노력하는 게 좋다
-- 어쩔 수 없을 때만 써라
	
	
-- 사장이름, 식당이름, 지점명, 메뉴명, 가격
select c_name, r_name, r_area, m_menu, m_price
from jan27_ceo, jan27_rest, jan27_menu, jan27_run
where c_no = r_c_no and r_r_no = jan27_rest.r_no and r_r_no = m_r_no
order by m_menu, m_price;
-- where c_no = r_c_no and r_r_no = jan27_rest.r_no and jan27_rest.r_no = m_r_no;


-- 메뉴명, 가격
-- 가격 비싼 순 -> 메뉴명 가나다순
select m_menu, m_price -- 어떤 값이 보고 싶냐
from jan27_menu -- 어디서 출신이냐
-- where 			-- 조건식
order by m_price desc, m_menu;
-- 정렬 : 가격을 기준으로 내림차순 정렬하고,(가격이 같다면) 메뉴명으로 오름차순 정렬


-- 식당명, 지점명, 메뉴명, 가격
-- 평균가보다 비싼 거
-- 식당명 가나다순 -> 메뉴명 가나다순
select r_name, r_area, m_menu, m_price
from jan27_rest, jan27_menu
where r_no = m_r_no and m_price > (
	select avg(m_price)
	from jan27_menu
	)
order by r_name, m_menu;


-- rownum
--		select할 때마다 부여되는 가상필드
--		rownum은 *랑 같이 사용 불가능
--		order by보다 먼저 부여됨(먼저 실행된다고 보면 될 듯)
--		무조건 1번부터 조회해야 함 (1번부터 만들어지기 때문에 4번부터 시작할 수 없다)


-- 메뉴 테이블 다
-- 메뉴명 가나다 -> 가격 싼 순

select *
from (
	select rownum as rn, m_no, m_menu, m_price
	from (
		select m_no, m_menu, m_price
		from jan27_menu
		order by m_menu, m_price
		)
	)
where rn >= 4 and rn <= 6;

-- 사장이름, 식당이름, 지점명, 메뉴명, 가격
-- 올 메뉴명 가나다순 -> 가격 오름차순
-- 3 ~ 5번만

select *
from(
	select rownum as rn, c_name, r_name, r_area, m_menu, m_price
	from(
		select c_name, r_name, r_area, m_menu, m_price
		from jan27_ceo, jan27_rest, jan27_menu, jan27_run
		where c_no = r_c_no
			and r_r_no = jan27_rest.r_no
			and jan27_rest.r_no = m_r_no
		order by m_menu, m_price
		)
	)
where rn >= 3 and rn <= 5;