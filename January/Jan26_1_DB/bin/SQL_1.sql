-- Java : 한달했다
--		이해가 필요
--		정답이 없음, 날카롭게 쓰는 법을 배웠지 -> 창의성이 들어감
--		정답없이 프로그램을 만듬

-- SQL : 이틀하자
--		변수,조건문,반복문,배열,컬렉션,객체 아무것도 없다
--		이해가 없는 언어, 걍 암기
--		정답이 있음 -> 창의성의 영역이 필요가 없음
--		asdf(뭔가 입력) -> 결과
--		DB제어하는 프로그램 <- 생각보다 문법이 별로 없음
--		=> 따라서 분량이 적음

-- 열(column)[세로줄]을 SQL의 table에선 field라고 부름
-- 행(row)[가로줄]을 SQL의 table에선 record 또는 data 라고 부름

-- field : 열(column)
-- record/data : 행(row)

-- DB메이커가 다르면 자료형 이름이 다를 거다

-- 테이블명, 필드명 : 변수명 짓는 느낌으로 하면 돼
-- 자료형 :
--			글자
--				char(용량)
					띄어쓰기를 넣어서 강제로 용량만큼 채워서 저장
					불편하지만 빠름
--					글자수가 정해져 있는 것들 저장할 때 좋음 ex)주민번호, 성별)

--				varchar2(용량) <- 주력, 개선된 버전, 그냥 varchar도 있음(더 느리겠지)
					용량만큼 안 쓰면 줄여서 저장
					편하지만 느림
--					대부분의 상황에서 사용, 글자수가 바뀌는 것들 ex)사람이름
--------------------------
char(5 char)
	홍길동" "" "(용량 다 못채우면 뒤에 띄어쓰기가 강제로 들어감
varchar2(5 char)[variable의 약자]
	홍길동 <- 이러고 끝
--------------------------
-- 용량[영어/숫자 개당 1byte, 한글 개당 3bytes]
--		2 : 2bytes
--		2 char : 뭐든 2글자[이 경우는 사실상 6bytes라고 봐야지] ex) char(5char)
--------------------------
--			숫자
--				number(용량)
--				number(5) 	 : 5자리 정수형(12345 같은 식)
--				number(5, 3) : 실수형(전체자리수, 소수점자리수) ex)12.345 <- 전체 5글자 소수점 3글자
	
--			날짜/시간
--				date
-- 자료형 끝
--------------------------
-- 테이블 삭제 [DBA의 작업이긴 함]
drop table 테이블명 cascade constraint purge;
	
drop table jan26_snack cascade constraint purge;

-- 옵션 (써도 되고 안 써도 되지만 사실상 필수로 쓰는 애)
--		not null : 데이터 비워놓지 못하게 하는 것
--		primary key : not null + 중복데이터 못넣게 하는 것
--			그 데이터를 대표하는 값으로 만들어준다고 봐도 된다
--			검색/삭제할 때 유용하게 사용
--			테이블 만들 때 primary key는 웬만하면 있도록 해주자

-- 테이블 만들기 [만들기 업무는 엄밀히 따지면 DBA의 업무, 내가 하게 될 일은 아님]	
create table 테이블명(
	필드명 자료형 옵션,
	필드명 자료형 옵션,
	...
); 

-- 필드명은 "열제목" 이라고 부르기도 함
-- 중복된 테이블명으로 테이블 못 만듬, 지우고 쓰거나 이름을 바꾸거나 해줘야 함 <- 이게 꽤 불편하고 신경써야하는 부분임
-- [테이블명 첫글자_필드명]으로 쓰는 게 일반적 (중복을 피하려고)(가독성을 위한 것도 있음)
create table jan26_snack(
	s_name varchar2(10 char) primary key,
	s_price number(6) not null
);

select * from jan26_snack;
--------------------------
-- 데이터 추가 [여기부터는 나도 하게 될 수도 있는 일]
insert into 테이블명(필드명, 필드명, ...) values(값, 값, ...);
insert into 테이블명 values(값, 값, ...); -- <- 이게 주력 ↑는 생각보다 성가셔서 쓸 일이 없다

-- Java는 ""를 쓰지만 OracleDB는 ''를 쓴다
insert into jan26_snack(s_name, s_price) values('칸쵸', 2000); 

insert into jan26_snack(s_name, s_price) values('새콤달콤', 500);

-- 필드끼리 자리 바꿔도 적용된다 <- 그닥 쓸모 없음
insert into jan26_snack(s_price, s_name) values(300, '츄파츕스');

-- 0이면 계산가능, 값이 없으면 계산불가
-- 값 생략도 가능 <- 완전 쓸모 없는 짓 나중에 계산할 때 문제 일으킴
insert into jan26_snack(s_name) values('포카칩');

-- ↓ 이런 방식으로 매우 자주 씀
insert into jan26_snack values('초코파이', 5000);
insert into jan26_snack values('오예스', 5000);
insert into jan26_snack values('오예스', 3000);

-- 이클립스는 첫 조회 때 안 나오는 버그가 있음
select * from jan26_snack;