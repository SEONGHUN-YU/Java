-- 테이블 수정 : 사실상 실전에서는 없는 작업이라고 봐야 함
-- 학생이 1000명 등록 되어있는데, 번호를 추가? <- 감당 안 됨

drop table jan26_student cascade constraint purge;

select * from jan26_student;
-- 필드들에 딱히 pk 먹일 게 없으면 -> 번호필드를 추가해서 pk 주는 방법이 있다
-- 데이터가 많아지면 번호 관리하기 힘듬
-- -> 번호 자동관리 시스템이 가지고 싶음 (Java factory패턴 느낌)

-- 오라클은 sequence라는 걸 만들 수 있다 <- 테이블과는 아무 상관없는 독립적인 존재
--											용도상 테이블에서 쓰니...
-- 											테이블명 뒤에 _seq를 붙여서 만드는 게 일반적
--											insert 실패해도 올라가는 특징이 있음...
--											sequence 하나 만들어놓고 여러 테이블에서 사용도 가능은 하다 (잘 안 그러지만)
--											나는 3번, 2번 학생이 전학 -> 내가 2번이 되나? 아니요
--											정확하게 1,2,3,4 하기 위한 존재가 아님(이건 따로 있음)
--											sequence는 어디까지나 pk 번호필드를 위한 존재
-- sequence 생성 (철저히 Oracle의 얘기)
create sequence 시퀀스명;

create sequence jan26_student_seq;

-- sequence 활용
insert into 할 때 데이터 들어갈 위치에 시퀀스명.nextval

-- sequence 삭제
drop sequence 시퀀스명;

drop sequence jan26_student_seq;

create table jan26_student(
	s_no number(2) primary key,
	s_name varchar2(10char) not null,
	s_kor number(3) not null,
	s_eng number(3) not null,
	s_mat number(3) not null
);

insert into jan26_student values(jan26_student_seq.nextval,'홍길동',89,56,67)
insert into jan26_student values(jan26_student_seq.nextval,'김길동',34,43,99)
insert into jan26_student values(jan26_student_seq.nextval,'이길동',54,45,76)
insert into jan26_student values(jan26_student_seq.nextval,'이길동',94,95,96)