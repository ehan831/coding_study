-- emp table insert
INSERT INTO EMP VALUES
        (7369, 'SMITH',  'CLERK',     7902,
        sysdate,  800, NULL, 20);

INSERT INTO EMP VALUES
        (7499, 'ALLEN',  'SALESMAN',  7698,
        sysdate, 1600,  300, 30);

INSERT INTO EMP VALUES
        (7521, 'WARD',   'SALESMAN',  7698,
        sysdate, 1250,  500, 30);

INSERT INTO EMP VALUES
        (7566, 'JONES',  'MANAGER',   7839,
        sysdate,  2975, NULL, 20);

INSERT INTO EMP VALUES
        (7654, 'MARTIN', 'SALESMAN',  7698,
        sysdate, 1250, 1400, 30);

INSERT INTO EMP VALUES
        (7698, 'BLAKE',  'MANAGER',   7839,
        sysdate,  2850, NULL, 30);

INSERT INTO EMP VALUES
        (7782, 'CLARK',  'MANAGER',   7839,
        sysdate,  2450, NULL, 10);
INSERT INTO EMP VALUES
        (7788, 'SCOTT',  'ANALYST',   7566,
        sysdate, 3000, NULL, 20);

INSERT INTO EMP VALUES
        (7839, 'KING',   'PRESIDENT', NULL,
        sysdate, 5000, NULL, 10);

INSERT INTO EMP VALUES
        (7844, 'TURNER', 'SALESMAN',  7698,
        sysdate,  1500,    0, 30);

INSERT INTO EMP VALUES
        (7876, 'ADAMS',  'CLERK',     7788,
        sysdate, 1100, NULL, 20);

INSERT INTO EMP VALUES
        (7900, 'JAMES',  'CLERK',     7698,
        sysdate,   950, NULL, 30);

INSERT INTO EMP VALUES
        (7902, 'FORD',   'ANALYST',   7566,
        sysdate,  3000, NULL, 20);

INSERT INTO EMP VALUES
        (7934, 'MILLER', 'CLERK',     7782,
        sysdate, 1300, NULL, 10);


-- << 도전문제 >>
-- 인사관리 ( hr 계정 )에서 EMPLOYEES 테이블에서

--1. EMPLOYEES 테이블에서 사원 이름을 first_name과 last_name를 합쳐 full_name으로 출력
 SELECT first_name ||' '|| last_name AS full_name FROM EMPLOYEES;

--2. 부서번호가 30(구매부서)이고 급여 10000미만인 사원의 full_name과 월급,부서번호를 출력
 SELECT FIRST_NAME ||' '|| LAST_NAME AS full_name, SALARY, DEPARTMENT_ID FROM EMPLOYEES
 WHERE DEPARTMENT_ID= 30 AND SALARY < 10000;

--3. 부서번호가 30이고 급여가 10000달러 이하를 받는 2006년도 이전 입사한 사원의 full_name을 출력
 SELECT FIRST_NAME ||' '|| LAST_NAME AS full_name, HIRE_DATE FROM EMPLOYEES
 WHERE DEPARTMENT_ID= 30 AND SALARY <= 10000 AND HIRE_DATE < TO_DATE('2006-01-01', 'YYYY-MM-DD');

--4. 부서번호가 30(구매부서)이고 급여가 10000이하인 사원과 부서번호가 60(IT부서)에서 급여가 5000이상인 사원을 조회
 SELECT FIRST_NAME, LAST_NAME, DEPARTMENT_ID, JOB_ID, SALARY FROM EMPLOYEES
 WHERE (DEPARTMENT_ID= 30 AND SALARY <= 10000) OR (DEPARTMENT_ID=60 AND SALARY >= 5000);

--5. 사원번호가 110번에서 120번인 사원 중 급여가 5000에서 10000사이의 사원명단을 조회
SELECT * FROM EMPLOYEES WHERE (EMPLOYEE_ID BETWEEN 110 AND 120) AND (SALARY BETWEEN 5000 and 10000);

--6. 사원번호가 110번에서 120번이 아닌 사원을 조회
SELECT * FROM EMPLOYEES WHERE (EMPLOYEE_ID NOT BETWEEN 110 AND 120);

--7. 부서번호가 30(구매부서), 60(IT부서), 90(경영부서)에 속한 사원을 조회
SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID IN (30, 60, 90);

--8. 부서번호가 30(구매부서), 60(IT부서), 90(경영부서) 외의 부서에 속한 사원을 조회
SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID NOT IN (30, 60, 90);

--9. 전화번호에서 590으로 시작하는 사원명과 전화번호를 조회
SELECT FIRST_NAME, LAST_NAME, PHONE_NUMBER FROM EMPLOYEES WHERE PHONE_NUMBER LIKE '590%' ;



-- << 정규식 연습문제 >>
-- 테이블 생성
CREATE TABLE reg_tab( text varchar2(20) );

-- 레코드 입력
INSERT INTO reg_tab VALUES('TIGER');
INSERT INTO reg_tab VALUES('TIGGER');
INSERT INTO reg_tab VALUES('elephant');
INSERT INTO reg_tab VALUES('tiger');
INSERT INTO reg_tab VALUES('tiger2');
INSERT INTO reg_tab VALUES('tiger3');
INSERT INTO reg_tab VALUES('doggy');
INSERT INTO reg_tab VALUES('5doggy');
INSERT INTO reg_tab VALUES('DOG');
INSERT INTO reg_tab VALUES('DOG2');
INSERT INTO reg_tab VALUES('개');
INSERT INTO reg_tab VALUES('cat');
INSERT INTO reg_tab VALUES('catty');
INSERT INTO reg_tab VALUES('9catty');
INSERT INTO reg_tab VALUES('catwoman');
INSERT INTO reg_tab VALUES('고양이');
INSERT INTO reg_tab VALUES('BAT');
INSERT INTO reg_tab VALUES('BATMAN');
INSERT INTO reg_tab VALUES('BATGIRL');
INSERT INTO reg_tab VALUES('0BATGIRL');
INSERT INTO reg_tab VALUES('박쥐');

-- 커밋
COMMIT;


[ 문제 ]

-- 1.  text 컬럼의 문자열에서 't'로시작하는 데이터 검색
 SELECT * FROM reg_tab WHERE REGEXP_LIKE(text, '^t');

-- 2. text 컬럼의 문자열에서 't'로 끝나는 데이터 검색
 SELECT * FROM reg_tab WHERE REGEXP_LIKE(text, 't$');

-- 3. 첫번째 't'로시작하여 5번째 'r'이 있는 데이터 검색
 SELECT * FROM reg_tab WHERE REGEXP_LIKE(text, '^t...r');

-- 4. 숫자로 끝나는 데이터 검색
 SELECT * FROM reg_tab WHERE REGEXP_LIKE(text, '[0-9]$');

-- 5. 숫자로 시작하는 데이타 검색
 SELECT * FROM reg_tab WHERE REGEXP_LIKE(text, '^[0-9]');

-- 6. 숫자가 아닌 문자로 시작하는 데이터 검색
 SELECT * FROM reg_tab WHERE REGEXP_LIKE(text, '^[^0-9]');

-- 7. 대문자로 시작하는 데이터 검색
 SELECT * FROM reg_tab WHERE REGEXP_LIKE(text, '^[A-Z]');

-- 8. 소문자 외의 문자로 시작하는 데이터 검색
 SELECT * FROM reg_tab WHERE REGEXP_LIKE(text, '^[^a-z]');

-- 9. 한글로 시작하는 데이터 검색
 SELECT * FROM reg_tab WHERE REGEXP_LIKE(text, '^[가-힣]');

-- 10. 데이터 중 'gg'나 'GG'가 들어있는 데이터 검색
 SELECT * FROM reg_tab WHERE REGEXP_LIKE(text, 'gg|GG');
