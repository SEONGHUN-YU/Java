-- 테이블 만들면 PK는 있도록
-- 수정/삭제/검색 정확하게 데이터 하나 선택

-- 빅데이터
-- 1000만개 중에368만203번째 날씨만 선택?? 그런 걸 왜 해...
-- 이번 경우는 PK 필요없다

-- MVC패턴 파싱
create table realtime_dust(
	r_date date,
	r_area char(3 char) not null,
	r_location varchar2(4 char) not null,
	r_fine_dust number(3) not null,
	r_ultra_fine_dust number(3) not null,
	r_condition varchar2(10 char) not null
);
create sequence realtime_dust_seq;

select realtime_dust.currval from dual;
select * from REALTIME_DUST;

-- 일단 데이터 다 가져와서 Java쪽에서 ArrayList로 만들고 통계를 내자 - X

-- DB서버에서 통계내서 가져오자 - O
select r_location, avg(r_fine_dust + r_ultra_fine_dust)
from realtime_dust
where r_condition != '없음'
group by r_location
order by avg(r_fine_dust + r_ultra_fine_dust) desc;

