-- tiger
select *
from tab;

--ȸ����������(tbl_member)
--ȸ�� ���̵�,�̸�,����ó,����Ʈ
create table tbl_member(
--���������ڿ�,�ߺ������ʰ�
  member_id VARCHAR2(30) primary key,
  --�������� null -> �� ������ ������
  member_name varchar2(50) not null,
  phone varchar2(20),
  point number default 100
);

select * from tbl_member;
--���õ�����
insert into tbl_member(member_id,member_name)
values ('user01','ȫ�浿');
insert into tbl_member(member_id,member_name)
values ('happy','���ູ');

update tbl_member
set phone = '010-1232-9871' --, point = 200
where member_id = 'user01';

select * from student;

--Į�������൵�ǰ� *��ü�� �ᵵ��
select * from product;
--�Ѱ��߰�,���
insert into product (p_code,
                     p_name,
                     p_price)
values (200,'����Ĩ',2000);
--����
update product
set    p_name = '������',
       p_price = 2200
where  p_code = 200;
--����,��ü�������������� ����
delete from product;
drop table tbl_member;
--where p_code = 200;

select  * from tbl_member;


select *
from emp2;
--�����ϴ��۾��� �����̶���
--1��pc �����ͺ��̽�ó�����������ϸ� �����̶��ϰ�,insert,delete�������
--�ڹٿ����� ���ǹ޾ƿ;���


--CREATE table charter(
--  last_name varchar2(20) not null,
--  first_name varchar2(20) not null,
--  char_age varchar2(5),
--  char_job varchar2(10) default '����',
--  char_money default 2000
--);



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
       'ȫ�浿',
       '����',
        25,
        50,
        100,
        '�簥��',
        25,
        15,
        '����');


Drop table rpg_chars;

select * from rpg_chars;