-- 날짜/시간
--		sysdate 				: 현재날짜/시간
--		to_date('글자','패턴')	: 글자 -> 날짜로 바꿔주는 함수
-- Java				SQL
--		y				YYYY
--		M				MM
--		d				DD
--		h				(AM, PM) HH / HH24
--		m				MI
--		s				SS


--		더 배우면 Java/Python에서 Date객체 써서 SQL에 넣어줄 수도 있음

drop table jan26_food cascade constraint purge;

drop sequence jan26_food_seq;

create table jan26_food(
	f_no number(2) primary key,
	f_name varchar2(10 char) not null,
	f_exp date not null,
	f_price number(5) not null,
	f_weight number(5,2) not null
);

create sequence jan26_food_seq;

select * from jan26_food;

insert into jan26_food values(jan26_food_seq.nextval, '우유', sysdate, 3000, 200.12);
insert into jan26_food values(jan26_food_seq.nextval, '돌김', sysdate, 2400, 511.12);
insert into jan26_food values(jan26_food_seq.nextval, '요구르트', to_date('20230201', 'YYYYMMDD'), 2000, 150.33);
insert into jan26_food values(jan26_food_seq.nextval, '감자튀김', to_date('20230601', 'YYYYMMDD'), 45000, 89.11);
insert into jan26_food values(jan26_food_seq.nextval, '슈넬치킨', to_date('20230921', 'YYYYMMDD'), 99000, 66.66);
insert into jan26_food values(jan26_food_seq.nextval, '슈넬치킨', to_date('20230921 오전 09:24', 'YYYYMMDD PM HH:MI'), 99000, 66.66);
insert into jan26_food values(jan26_food_seq.nextval, '요구르트', to_date('20230201 13:30', 'YYYYMMDD HH24:MI'), 2000, 150.33);
insert into jan26_food values(jan26_food_seq.nextval, '감자', to_date('20230303 오후 10:30', 'YYYYMMDD PM HH:MI'), 5000, 650.33);
insert into jan26_food values(jan26_food_seq.nextval, '슈넬치킨mk2', to_date('2020', 'YYYY'), 990, 22.66);
insert into jan26_food values(jan26_food_seq.nextval, '슈넬치킨mk3', to_date('11', 'mm'), 990, 22.66);
insert into jan26_food values(jan26_food_seq.nextval, '뒷자리치킨', to_date('02', 'mm')+78, 9290, 222.66);