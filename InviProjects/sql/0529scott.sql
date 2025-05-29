-- tiger
select *
from tab;

--회원정보관리(tbl_member)
--회원 아이디,이름,연락처,포인트
create table tbl_member(
--가변형문자열,중복되지않게
  member_id VARCHAR2(30) primary key,
  --제약조건 null -> 값 무조건 들어가야함
  member_name varchar2(50) not null,
  phone varchar2(20),
  point number default 100
);

select * from tbl_member;
--샘플데이터
insert into tbl_member(member_id,member_name)
values ('user01','홍길동');
insert into tbl_member(member_id,member_name)
values ('happy','김행복');

update tbl_member
set phone = '010-1232-9871' --, point = 200
where member_id = 'user01';

select * from student;

--칼럼적어줘도되고 *전체로 써도됨
select * from product;
--한건추가,등록
insert into product (p_code,
                     p_name,
                     p_price)
values (200,'감자칩',2000);
--수정
update product
set    p_name = '감자집',
       p_price = 2200
where  p_code = 200;
--삭제,전체삭제위험있으니 주의
delete from product;
drop table tbl_member;
--where p_code = 200;

select  * from tbl_member;


select *
from emp2;
--연결하는작업을 세션이라함
--1번pc 데이터베이스처리위해접속하면 세션이라하고,insert,delete기능을함
--자바에서도 세션받아와야함


--CREATE table charter(
--  last_name varchar2(20) not null,
--  first_name varchar2(20) not null,
--  char_age varchar2(5),
--  char_job varchar2(10) default '무직',
--  char_money default 2000
--);


--캐릭터 관련 테이블
CREATE table rpg_chars(
    char_id varchar2(20) primary key,
    char_name varchar2(10),
    char_job VARCHAR2(15),
    char_age NUMBER(3),
    char_exp number default 0,
    char_lv  number default 1,
    char_money number(15),
    char_hp number(4),
    char_ab  VARCHAR2(20),
    char_atck number(4),
    char_def  number(4),
    char_weapon varchar2(10)
);
insert into rpg_chars(char_id,char_name,char_job, char_age,char_money,char_hp,char_ab, char_atck,char_def,char_weapon)
values('user00',
       '홍길동',
       '농사꾼',
        25,
        50,
        100,
        '밭갈기',
        25,
        15,
        '괭이');

select * from rpg_chars;

--게임이벤트 테이블 - 랜덤
create table rpg_event(
    id number primary key, 
    name varchar2(50), -- user가 만날 이벤트 대상
	e_type varchar2(20), --퀘스트만 아이템관련 보상은 없음.
    hp_chan number(10),
    atk_chan number(10),
    def_chan  number(10),
    exp_chan number(10),
    money_chan number(15),
    action varchar2(200)
);

-- 저장테이블

create table rpg_reward(
    hp_rewa number(10),
    atk_rewa number(10),
    def_rewa  number(10),
    exp_rewa number(10),
    money_rewa number(15),
    lv_rewa  number(10)
);

insert into rpg_event(id,name,e_type,hp_chan,atk_chan,def_chan,exp_chan,money_chan,action)
values(1,'슬라임과 조우','전투',-20,5,3,7,50,'작은슬라임을 처치하였습니다.');

select * from rpg_event;

Drop table rpg_event;

select * 
from rpg_event 
where id = 1;



select * from rpg_chars;