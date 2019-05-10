-- 유저 생성 및 권한 부여
CREATE USER day190510 IDENTIFIED BY 1234;
GRANT CONNECT, RESOURCE TO day190510;

-- 테이블 생성
create table gogek
(
	id varchar2(8)
		constraint gogek_pk primary key,
	name varchar2(10) not null,
	tel varchar2(13)
)
/

create table sangpum
(
	No varchar(6)
		constraint sangpum_pk primary key,
	title varchar2(20) not null,
	Detail varchar2(50),
	Count int not null,
	Price int
)
/

create table jumun
(
	No number(4)
		constraint jumun_pk primary key,
	gogek varchar2(8)
		constraint jumun_GOGEK_ID_fk references GOGEK(id) on delete set null,
	Sangpum varchar2(6)
		constraint jumun_SANGPUM_NO_fk references SANGPUM(No) on delete set null,
	Count int,
	Jumunil date
)
/

SELECT * FROM jumun;


-- 데이터 입력 고객
INSERT INTO gogek ( id, name, tel ) VALUES('babo1234','홍길동', '031-333-3333' );
INSERT INTO gogek ( id, name, tel ) VALUES('babo1111','김길동', '031-111-1111' );
INSERT INTO gogek ( id, name, tel ) VALUES('babo2222','홍길동', '031-222-2222' );
INSERT INTO gogek ( id, name, tel ) VALUES('babo9999','박길동', '031-333-3333' );
-- INSERT INTO gogek ( id, name, tel ) VALUES('babo1234','맹길동', '031-999-9999' ); // pk 중복
-- INSERT INTO gogek ( id, name, tel ) VALUES('babo12345','이길동', '031-333-1234' ); // 8자 넘음
INSERT INTO gogek ( id, name, tel ) VALUES('123','최길동', '031-999-9999' );
INSERT INTO gogek ( id, name ) VALUES('babo','봉길동' );
-- INSERT INTO gogek ( id, tel ) VALUES('babo1988','031-888-8888' ); // name not null 위배

-- 데이터 입력 상품
INSERT INTO sangpum ( no, title, count,price, detail ) VALUES ('A00001','이쁜바지', 30, 1000, '싸고이뻐서 금방 다 팔릴 바지입니다' );
INSERT INTO sangpum ( no, title, count,price, detail ) VALUES ('A00002','그냥바지', 20, 500, '그냥이뻐고 편안한 바지입니다' );
INSERT INTO sangpum ( no, title, count )VALUES ('B00009','윗도리', 20 );
-- INSERT INTO sangpum ( no, title, count,price ) VALUES ('Z0001','비싼코트', 3, 20000, '겁나 비싼코트입니다' ); // 4개 항에 5개 값을?
-- INSERT INTO sangpum VALUES ('Z00001','비싼코트2', 5, 20000, '겁나 비싼 코트입니다' ); // 컬럼 순서 틀림
INSERT INTO sangpum VALUES ('Z00001','비싼코트3','겁나 비싼 코트입니다', 5, 20000);

-- 데이터 입력 주문
INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1000, 'babo1234', 'A00001', 1, '2016/09/09' );
-- INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1001, 'babo1233', 'Z00001', 1, '2016/09/09' ); // 고객 부모키가 없음
-- INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1002, 'Babo1234', 'A00002', 2, '2016/09/10' ); // 고객 부모키가 없음
-- INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1003, 'babo1234', 'B00001', 1, '2016/09/11' );  // 상품 부모키가 없음
INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1004, 'babo', 'Z00001', 1, '2016/10/11' );
INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1005, 'babo1234', 'B00009', 1, '2016/11/11' );
INSERT INTO jumun(no, gogek, sangpum,count, jumunil) VALUES ( 1006, 'babo1234', 'B00009', 1, '2016/12/12' );



-- 데이터 변경 및 검색
-- 전화번호가 없는 고객은 누구인지 고객명을 검색하세요
SELECT * FROM gogek WHERE tel IS NULL;

-- 홍씨 성을 가진 고객들의 정보를 검색하세요
SELECT * FROM gogek WHERE name LIKE '홍%';

-- babo2222 고객명을 박길동으로 변경하세요
UPDATE gogek SET name = '박길동' WHERE id = 'babo2222';

-- 아이디 123 고객의 아이디를 babo123 으로 변경하세요
UPDATE gogek SET id = 'babo123' WHERE id = '123';

-- 봉길동씨의 전화번호 02-555-5555를 추가하세요
UPDATE gogek SET tel = '02-555-5555' WHERE name = '봉길동';

-- 상품번호 B00009 에 가격 1200원 그리고 “겁나 쌕시한 옷입니다”라는 상품설명을 추가하세요
UPDATE sangpum SET Detail = '겁나 쌕시한 옷입니다' WHERE No = 'B00009';

-- 이쁜바지 상품이 10개가 팔렸습니다. // 의미가 이상함, 주문이 들어왔다는 의미인가?
UPDATE sangpum SET Count = Count - 10 WHERE title = '이쁜바지';

-- Z00001 상품이 3개가 더 입고 되었습니다.
UPDATE sangpum SET Count = Count + 3 WHERE No = 'Z00001';

-- 상품 가격이 1000원을 넘는 상품들을 검색하세요
SELECT * FROM sangpum WHERE Price > 1000;

-- 11월 이후에 주문한 상품 번호를 검색하세요
SELECT * FROM jumun WHERE Jumunil >= TO_DATE('2016-11-01', 'YYYY-MM-DD');

-- babo 고객이 주문한 상품을 A00002로 변경하고 수량을 2개로 수정하세요
UPDATE jumun SET Sangpum = 'A00002',  Count = 2 WHERE gogek = 'babo';

-- babo1234 고객이 11월에 주문한 상품 번호을 검색하세요
SELECT No, Sangpum FROM jumun WHERE gogek = 'babo1234'
  AND Jumunil BETWEEN TO_DATE('2016-11-01', 'YYYY-MM-DD') AND TO_DATE('2016-11-30', 'YYYY-MM-DD');

-- SELECT No, Sangpum FROM jumun WHERE gogek = 'babo1234' AND Jumunil LIKE '2016/11/%';

-- B00009 상품을 주문한 고객 아이디를 검색하세요
SELECT DISTINCT gogek FROM jumun WHERE Sangpum = 'B00009';


---------------------------------------------
--사원명, 급여, 세금(급여의 3.3%)를 원단위 절삭하고 출력
SELECT ename, sal, trunc(sal * 0.033, -1) as TAX FROM scott.EMP;

-- 양쪽 공백을 제거

select  '-'||  trim(' 이순신 ') || '-' as col1,
        '-'|| ltrim(' 이순신 ') || '-' as col2,
        '-'|| rtrim(' 이순신 ') || '-' as col3 from dual;

-- (*) dual : dummy 테이블로 sys user가 owner이고 모든 사용자가 사용가능.
-- 임의의 값을 알고자 할 경우 유용하게 사용하는 테이블.
SELECT sysdate FROM dual;

-- 월급을 숫자에서 ‘영일이삼사오육칠팔구’ 글자로 대체
SELECT translate(sal, '0123456789', '영일이삼사오육칠팔구') FROM EMP;

-- 월급의 숫자에서 0을‘$’로 바꾸어 출력
SELECT replace(sal, 0, '$') FROM EMP;

-- smith의정보를 사원번호, 성명, 담당업무(소문자) 출력
SELECT EMPNO, ENAME, LOWER(JOB) FROM EMP WHERE ENAME = 'SMITH';

-- 사원번호, 사원명(첫글자만 대문자), 담당업무(첫글자만대문자)로 출력
SELECT EMPNO, INITCAP(ENAME), INITCAP(JOB) FROM EMP WHERE ENAME = 'SMITH';

-- 이름의 첫글자가 ‘K’보다크고 ‘Y’보다 작은 사원의 정보( 사원번호, 이름, 업무, 급여, 부서번호)를 출력하되 이름순으로 정렬
SELECT EMPNO, ENAME, JOB, SAL, DEPTNO FROM EMP WHERE SUBSTR(ENAME, 1, 1) > 'K' AND SUBSTR(ENAME, 1, 1) < 'Y' ORDER BY ENAME;

-- 이름이 5글자 이상인사원들을 출력
SELECT * FROM EMP WHERE LENGTH(ename) > 5;

-- 이름을 15자로 맞추고글자는 왼쪽에 오른쪽에는 ‘*’로 채운다
SELECT RPAD(ENAME, 15, '*') FROM EMP;
-- 월급은 10자로 맞추고숫자는 오른쪽에 왼쪽엔 ‘-‘로 채운다
SELECT LPAD(SAL, 15, '-') FROM EMP;

--------------------------------------------------------------------------

-- 현재까지 근무일 수가 많은 사람 순으로 출력
SELECT * FROM EMP ORDER BY sysdate - NVL(HIREDATE, sysdate) DESC;

-- 현재까지 근무일 수가 몇 주 몇 일인가를 출력
SELECT ENAME, HIREDATE, TRUNC(sysdate - HIREDATE) TOTAL_DAYS, TRUNC((sysdate - HIREDATE)/7) WEEKS, CEIL(MOD(sysdate - HIREDATE, 7)) DAYS FROM EMP;

-- 10번 부서의 사원의 현재까지의 근무 월수를 계산
SELECT ENAME, HIREDATE, TRUNC(MONTHS_BETWEEN(sysdate, HIREDATE)) MONTHS FROM EMP WHERE DEPTNO=10;

-- 현재 날짜에서 3개월후의 날짜 구하기
select  add_months( sysdate, 3 ) as mydate from dual;

-- 현재 날짜에서 돌아오는 ‘월’요일의 날짜 구하기
SELECT NEXT_DAY(sysdate, '화') FROM dual;

-- 현재 날짜에서 해당 월의 마지막 날짜 구하기
SELECT LAST_DAY(sysdate) FROM dual;


-- 입사일자에서 입사년도를 출력
SELECT ENAME, HIREDATE, TO_CHAR(HIREDATE, 'YYYY') FROM EMP;

-- 입사일자를 ‘1999년 1월 1일’ 형식으로 출력
SELECT ENAME, HIREDATE, TO_CHAR(HIREDATE, 'YYYY"년" MM"월" DD"일"') FROM EMP;

-- 1981년도에 입사한 사원 검색
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'YYYY') = '1981';

-- 5월에 입사한 사원 검색
SELECT * FROM EMP WHERE TO_CHAR(HIREDATE, 'MM') = '05';

-- 급여 앞에 $를 삽입하고 3자리 마다 ,를 출력
SELECT ENAME, TO_CHAR(sal, '999,999,999' ) AS sal FROM EMP;

-- DECODE 주민등록번으로 성별 구하기
SELECT  decode( substr(jumin, 8, 1), 1, '남자', 3, '남자', '여자')AS  gender  FROM table_name;
-- CASE WHEN END
SELECT  CASE  substr(jumin, 8, 1)
	WHEN '1' THEN '남자'
  WHEN'3' THEN '남자'
	ELSE '여자'
  END as gender
FROM   emp;


-- 부서번호가 10이면영업부, 20이면 관리부, 30이면 IT부 그 외는 기술부로 출력
SELECT ENAME, DEPTNO,
       CASE DEPTNO
         WHEN 10 THEN '영업부'
         WHEN 20 THEN '관리부'
         WHEN 30 THEN 'IT'
         ELSE '기술부'
				 END AS DEPT
FROM EMP;

-- 업무(job)이 analyst이면 급여 증가가 10%이고 clerk이면 15%, manager이면 20%인 경우 사원번호, 사원명, 업무, 급여, 증가한 급여를 출력
SELECT EMPNO, ENAME, JOB, SAL,
       CASE JOB
         WHEN 'ALALYST' THEN 1.1 * SAL
         WHEN 'CLERK' THEN 1.15 * SAL
         WHEN 'MANAGER' THEN 1.2 * SAL
         ELSE SAL
				 END AS SAL_PLUS
FROM EMP;

SELECT EMPNO, ENAME, JOB, SAL,
		DECODE(JOB,
		  'ALALYST', 1.1 * SAL,
		  'CLERK', 1.15 * SAL,
		  'MANAGER', 1.2 * SAL,
		  SAL) AS SAL_PLUS
FROM EMP;

-- 업무가 ‘SALESMAN’인 사람들의 월급의 평균, 총합, 최소값, 최대값을 구하기
SELECT avg(sal) avg, sum(sal) sum, min(sal) min_sal, max(sal) max_sal
FROM emp
WHERE JOB = 'SALESMAN';

--커미션(COMM)을 받는 사람들의 수는
SELECT COUNT(*) cnt FROM EMP WHERE COMM IS NOT NULL;
SELECT COUNT(*) cnt FROM EMP WHERE NVL(COMM, 0) <> 0;
SELECT COUNT(*) cnt FROM EMP WHERE COMM != 0;
-- null 은 아닌데 값이 0인 것들은 제외된다.

/* GROUP BY, HAVING

SELECT columns  FROM  table_name  WHERE condition
GROUP BY group_by_expression
HAVING condition
ORDER BY column;

*/

-- 부서별로인원수, 평균급여, 최저급여, 최고급여, 급여의 합을 구하기
SELECT DEPTNO, COUNT(*) cnt, ROUND(AVG(sal)) avg, MIN(sal) min, MAX(sal) max, SUM(sal) sum
FROM EMP
GROUP BY DEPTNO;

 -- 부서별로인원수, 평균급여, 최저급여, 최고급여, 급여의 합을 구하기 (부서별 급여의 합이 높은 순으로)
SELECT DEPTNO, COUNT(*) cnt, ROUND(AVG(sal)) avg, MIN(sal) min, MAX(sal) max, SUM(sal) sum
FROM EMP
GROUP BY DEPTNO
ORDER BY sum DESC;

 -- 부서별업무별 그룹하여 부서번호, 업무, 인원수, 급여의 평균, 급여의 합을 구하기
SELECT DEPTNO, JOB, COUNT(*) cnt, ROUND(AVG(sal)) avg, SUM(sal) sum
FROM EMP
GROUP BY DEPTNO, JOB
ORDER BY DEPTNO;

-- 급여가 최대 2900 이상인부서에 대해 부서번호, 평균 급여, 급여의 합을 출력
SELECT DEPTNO,ROUND(AVG(sal)) avg, SUM(sal) sum
FROM EMP
GROUP BY DEPTNO
HAVING MAX(sal) >= 2900;

-- 업무별 급여의 평균이 3000이상인 업무에 대해 업무명, 평균 급여, 급여의 합을 출력
SELECT JOB, ROUND(AVG(sal)) avg, SUM(sal) sum
FROM EMP
GROUP BY JOB
HAVING ROUND(AVG(sal)) >= 3000;

-- 전체 합계 급여가 5000를초과하는 각 업무에 대해서 업무와 급여 합계를 출력
-- 단, SALESMAN은 제외하고 급여 합계가 높은 순으로 정렬
SELECT JOB, COUNT(*) cnt, ROUND(AVG(sal)) avg, MIN(sal) min, MAX(sal) max, SUM(sal) sum
FROM EMP
WHERE JOB != 'SALESMAN'
GROUP BY JOB
HAVING SUM(sal) >= 5000
ORDER BY sum DESC;

--  업무별최고 급여와 최소 급여의 차이를 구하라
SELECT JOB, MAX(sal) - MIN(sal) sal_gap
FROM EMP
GROUP BY JOB;

-- 부서 인원이 4명보다 많은 부서의 부서번호, 인원수, 급여의 합을 출력
SELECT DEPTNO, COUNT(*), SUM(SAL) sum
FROM EMP
GROUP BY DEPTNO
HAVING COUNT(*) > 4;

/*
[ GROUP BY 절에 사용하는 함수 ]
- ROLLUP : 결과에 그룹별 합계 정보를 추가
- CUBE : 그룹핑 된 컬럼의 합계 정보를 추가
*/
select job, sum( sal ) from emp group by job;

select job, sum( sal ) from emp group by rollup(job);

select job, sum( sal ) from emp group by cube(job);


-- # HR 계정에서 ( employees 테이블 )
-- 1. 2003년에 입사한 사원들의 사번, 이름, 입사일을 출력
SELECT EMPLOYEE_ID, FIRST_NAME, HIRE_DATE FROM EMPLOYEES
WHERE TO_CHAR(HIRE_DATE, 'YYYY') = 2003;

-- 2. 업무가 FI_ACCOUNT / FI_MGR / SA_MAN / SA_REP 인 사원들의 정보를 출력
SELECT * FROM EMPLOYEES
WHERE JOB_ID IN ('FI_ACCOUNT', 'FI_MGR', 'SA_MAN', 'SA_REP')
ORDER BY JOB_ID;

3. 커미션을 받는 사원들의 명단을 출력
SELECT * FROM EMPLOYEES
WHERE COMMISSION_PCT IS NOT NULL;

4.업무가 SA_MAN 또는 SA_REP이면 "판매부서"를 그 외는 "그 외 부서"라고 출력
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID,
       CASE JOB_ID
				 WHEN 'SA_MAN' THEN '판매부서'
         WHEN 'SA_REP' THEN '판매부서'
				 ELSE '그 외 부서'
				 END AS JOB_ID
FROM EMPLOYEES;
