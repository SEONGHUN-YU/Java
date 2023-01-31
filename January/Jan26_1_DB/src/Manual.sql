-- 여기서는 관리자쪽 기능 불가능
-- sqlplus라는 프로그램의 명령어 <- 이거 여기선 안 됨
-- 이건 SQL연습장 느낌
-- 앞으로 DB랑 연동된 프로그램 만들건데, SQL 연습이 필요함
-- -> 프로젝트에 sql파일 만들어서 이것저것 연습해봐
-- -> 프로그램 최종 출시할 때 연습했던 sql파일은 삭제하고 출시하면 되겠네!

drop table snack cascade constraint purge;
-- ↑ 테이블 삭제, 오라클 내에 있는 휴지통에 넣지말고, 라는 뜻

-- 테이블 만들기
create table snack (
	name char(3),
	price number(4)	
); -- 원래는 한줄로 쫘라락 쓰는 게 맞는데, 가독성을 위해 저렇게 쓴 것

-- 여러줄 실행 : 드래그로 덮어서(블록지정) alt + x
-- 한줄 실행 : 실행하고 싶은 줄 아무데나 커서 두고 alt + s <- 이건 sqlplus의 명령어

select * from snack; -- <- SQL 명령어
-- desc snack; -- <- sqlplus 명령어 (테이블 만들어 졌는지 확인)

-- SQL(Structured Query Language) : DB제어하는 언어
-- 자동완성 - x
-- 대소문자 구별 - x
-- DB메이커는 다양하다
-- OracleDB, MySQL, Mari 다 SQL을 쓰지만 다 위와 같은 특징을 띈다
-- OracleDB 쓸 줄 알면 MySQL도 할 수 있다