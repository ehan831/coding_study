-- 회원 테이블
create table ex_member
(
  ID   VARCHAR2(10) not null
    constraint EX_MEMBER_PK primary key, -- 아이디
  pass varchar2(10),                     -- 패스워드
  name varchar2(20),                     -- 이름
  tel  varchar2(20),                     -- 전화번호
  addr varchar2(100)                     -- 주소
);
-- 상품 테이블
create table ex_good
(
  GNO     VARCHAR2(10) not null
    constraint EX_GOOD_PK primary key, -- 상품번호
  gname   varchar(30),                 -- 상품명
  gdetail varchar2(300),               -- 상세설명
  price   number
);
-- 가격
-- 주문 테이블
create table ex_order
(
  ono     number,       -- 번호
  orderno varchar2(20), -- 주문번호
  gno     varchar2(10), -- 상품번호
  id      varchar2(10), -- 회원 아이디
  count   number,       -- 갯수
  status  varchar2(10)  -- 배송상태
);
create sequence seq_order_ono;



alter table EX_ORDER
  add constraint EX_ORDER_EX_GOOD_GNO_fk
    foreign key (GNO) references EX_GOOD (GNO)
      on delete set null
/

alter table EX_ORDER
  add constraint EX_ORDER_EX_MEMBER_ID_FK
    foreign key (ID) references EX_MEMBER (ID)
      on delete set null
/

-- 회원 테이블 데이타 입력
insert into ex_member(id, pass, name, tel, addr)
values ('kim', '1111', '김길동', '02-222-2222', '서울 멋지구 이쁜동');
insert into ex_member(id, pass, name, tel, addr)
values ('park', '1111', '박길동', '03-333-3333', '인천 멋지구 이쁜동');
insert into ex_member(id, pass, name, tel, addr)
values ('meng', '1111', '맹길동', '04-444-4444', '경기 멋지구 이쁜동');
commit;
-- 상픔 테이블 데이타 입력
insert into ex_good(gno, gname, gdetail, price)
values ('1001', '머리끈', '아주 비싼 머리끈', 200);

insert into ex_good(gno, gname, gdetail, price)
values ('2002', '자전거-A', '비싸지만 빠르게 달리는 자전거', 10000);
insert into ex_good(gno, gname, gdetail, price)
values ('2010', '자전거-B', '아주 비싸지만 느리고 안전하게 달린다는 자전거', 20000);
insert into ex_good(gno, gname, gdetail, price)
values ('3333', '핸드폰케이스', '싸고 유행하는 핸드폰 케이스', 1500);
commit;

-- 주문 테이블 데이타 입력
insert into ex_order(ono, orderno, gno, id, count, status)
values (seq_order_ono.nextval, '20161212', '1001', 'park', 1, '배송완료');
insert into ex_order(ono, orderno, gno, id, count, status)
values (seq_order_ono.nextval, '20161212', '2010', 'park', 1, '배송중');
insert into ex_order(ono, orderno, gno, id, count, status)
values (seq_order_ono.nextval, '20161111', '1001', 'kim', 2, '주문');
insert into ex_order(ono, orderno, gno, id, count, status)
values (seq_order_ono.nextval, '20161111', '3333', 'kim', 3, '주문');
insert into ex_order(ono, orderno, gno, id, count, status)
values (seq_order_ono.nextval, '20163333', '1001', 'park', 3, '주문');
insert into ex_order(ono, orderno, gno, id, count, status)
values (seq_order_ono.nextval, '20163333', '2010', 'park', 1, '배송중');
insert into ex_order(ono, orderno, gno, id, count, status)
values (seq_order_ono.nextval, '20163333', '2002', 'park', 2, '주문');
insert into ex_order(ono, orderno, gno, id, count, status)
values (seq_order_ono.nextval, '20165050', '1001', 'meng', 1, '배송중');
commit;

-- ###############################################################
--[ 문제 ]
--1. 배송중인 주문 내역과 상품 정보 출력


--2. 주문 들어온 상품 내역과 고객 정보 출력
--
--3. 주문별로 고객 정보(ID만 출력)와 주문한 상품의 총금액을 출력

SELECT o.orderno, (COUNT(o.gno) - 1) items, SUM(g.price) total_price
FROM ex_order o
       LEFT JOIN ex_good g ON o.gno = g.gno
GROUP BY o.orderno;


SELECT orderno, gno, (ROW_NUMBER() over (PARTITION BY orderno ORDER BY gno)) AS items
FROM ex_order
ORDER BY orderno, items DESC;
--4. [과제] 3번에 주문 내역을 한 개의 상품명 외 몇 개로 출력
-- [예] 20161212   머리끈 외 1개
SELECT o.orderno, min(o.gno), count(*)
FROM ex_order o
GROUP BY orderno;

SELECT DISTINCT aa.orderno, bb.gname, bb.items
FROM ex_order aa
       Left join
     (SELECT o.orderno, g.gname, ROW_NUMBER() over (PARTITION BY orderno ORDER BY o.gno) - 1 AS items
      FROM ex_order o
             LEFT JOIN ex_good g ON o.gno = g.gno
      ORDER BY orderno, items DESC) bb
     ON aa.orderno = bb.orderno
ORDER BY aa.orderno, bb.items DESC;

SELECT orderno,
       gno,
       (MAX() over (PARTITION BY orderno) AS items FROM ex_order ORDER BY orderno, items DESC;

SELECT orderno, min(gno)
FROM (
       SELECT orderno, gno, (sum(count) OVER (partition by orderno)) AS items FROM ex_order
     )
GROUP BY orderno;


SELECT or.orderno, or.gno, or.count, go.gname
FROM ex_order or
       LEFT JOIN ex_good go ON or.gno = go.gno;

SELECT count(empno), avg(sal)
FROM EMP;

-- 월별로 입사자 수
SELECT TO_CHAR(HIREDATE, 'MM') hire_month, COUNT(*)
FROM emp
WHERE HIREDATE IS NOT NULL
GROUP BY TO_CHAR(HIREDATE, 'MM')
ORDER BY hire_month;

-- 월급 top 10
-- 12c new feature
SELECT * FROM emp ORDER BY SAL DESC
FETCH FIRST 10 ROWS ONLY;

SELECT *
FROM (SELECT empno, sal FROM emp WHERE SAL IS NOT NULL ORDER BY SAL DESC)
WHERE rownum <= 10;