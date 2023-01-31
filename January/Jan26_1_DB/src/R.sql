-- 데이터 조회 : R
select *
from 테이블명;

select 필드명, 필드명 as 별칭, 연산자 사용가능, 통계함수 사용가능, ...
from 테이블명, 테이블명, ...
where 조건식;
group by 필드명, 필드명, ...
having 조건식 -- group by랑 세트, group by 하고나서 보기 싫은 거 걷어낼 때 씀
order by 필드명, 필드명 desc, ...; -- 정렬 (default는 오름차순) (필드명 뒤에 desc붙이면 내림차순)

-- Java
-- int a = 10; 10을 a에 넣어라
-- a == 10; a는 10과 같다

-- SQL
-- a = 10; a는 10과 같다

-- 번호, 이름, 유통기한, 가격, 중량 중에서
-- 이름, 가격만(필드명 바꿔서)
select f_name as name, f_price as exp_date
from jan26_food;

-- 이름, 유통기한만
select f_name, f_exp
from jan26_food;

-- 이름, 가격, 부가세(필드명 뒤에 연산자 써서 계산도 된다)
select f_name, f_price, f_price * 0.1 as vat
from jan26_food;

-- 이름, 가격, g당 얼마인지
select f_name, f_price, f_price / f_weight as price_per_gram
from jan26_food;

-- 통계함수
--		sum(), avg(), max(), min(), count()
-- 평균가
select avg(f_price)
from jan26_food;

-- 최고가, 최소가, 총 음식 몇 종류
select max(f_price), min(f_price), count(*)
from jan26_food;

-- g당 가격 평균
select avg(f_price / f_weight)
from jan26_food;

-- 이름, 평균가 <- 나올 수가 없는 모양... 조회 불가능(따로 조회하던지)
select f_name, avg(f_price)
from jan26_food;

-- 이름, 가격 5000원 미만인 것들만
select f_name, f_price
from jan26_food
where f_price < 5000;

-- 7000원 이상인 거 몇개?
select f_price
from jan26_food
where f_price >= 7000;

-- 먹으면 안 되는 거
-- 이름, 유통기한
select f_name, f_exp
from jan26_food
where f_exp < sysdate;

-- 오늘안에 먹어야 하는 거[내일 먹으면 죽는거]
insert into jan26_food values(jan26_food_seq.nextval, '콜라', to_date('20230127 13:00', 'YYYYMMDD HH24:Mi'), 3000, 350.33);
-- 이름, 유통기한, 가격
select f_name, f_exp, f_price
from jan26_food
where f_exp < to_date(concat(to_char(sysdate, 'YYYYMMDD'), ' 23:59:59'), 'YYYYMMDD HH24:MI:SS');


select * from jan26_food;

-- to_date('글자','패턴') : 글자 -> 날짜
-- to-char(날짜, '패턴') : 날짜 -> 글자
-- concat('글자', '글자') : 글자글자 <- 글자를 붙여줌 ('a', 'b') : ab
-- sysdate : 현재 날짜/시간 [2023/1/27 9:30]

-- sysdate : 2023년 1월 27일 9시 30분
-- to_char(sysdate, 'YYYYMMDD') : '20230127'
-- concat(to_char(sysdate, 'YYYYMMDD'), ' 23:59:59') : '20230127 23:59:59'
-- to_date(concat(to_char(sysdate, 'YYYYMMDD'), ' 23:59:59'), 'YYYYMMDD HH24:MI:SS') : 오늘 23:59:59


-- 문자열 포함검색 방법
--		필드명 like '패턴'
--					'%장' : 장으로 끝나는
--					'장%' : 장으로 시작하는
--					'%장%':	장 포함
-- % <- 값에 뭐가 들어오든 신경 안 쓴다는 의미

-- Java		SQL
-- && -> and 라고 써야 먹힘
-- || -> or 라고 써야 먹힘


-- 이름에 '장'이 포함된 거
-- 이름, 가격
select f_name, f_price
from jan26_food
where f_name like '%장%';

-- 장류, or 우유류
-- 이름, 가격
select f_name, f_price
from jan26_food
where f_name like '%장' or f_name like '%우유';

-- 1000 < 가격 < 5000 물건 갯수
select count(*)
from jan26_food
where f_price < 5000 and f_price > 1000; -- &&는 희귀한 조건을 앞으로가 좋긴 함
-- price between 1 and 10; 1 <= price <= 10 // between 이라는 애도 있는데 <=나 >=만 있다

-- 오늘 9시 ~ 18시 사이에 유통기한이 끝나는 거 갯수
select count(*)
from jan26_food
where f_exp > to_date(concat(to_char(sysdate, 'YYYYMMDD'), ' 09:00:00'), 'YYYYMMDD HH24:MI:SS') and
f_exp < to_date(concat(to_char(sysdate, 'YYYYMMDD'), ' 18:00:00'), 'YYYYMMDD HH24:MI:SS');


-- 최고가
select max(f_price)
from jan26_food;
-- subquery : query안에 query가 있을 때 그 안에 있는 query를 말한다
-- 최고가 상품명, 유통기한, 가격
select f_name, f_exp, f_price
from jan26_food
where f_price = (select max(f_price) from jan26_food);

-- 평균가 이상인 거 상품명, 가격, VAT
select f_name, f_price, f_price * 0.1 as VAT
from jan26_food
where f_price >= (select avg(f_price) from jan26_food);


-- DBA 정점
-- SQL튜닝 : 그 DB서버에서 SQL이 최적으로 돌도록

-- SQL : 서버(좋은컴)에서 분석
-- numpy, pandas : PC에서 분석... 