-- * HR 계정에서
-- 1. 연도별로 입사자들의 최소급여, 최대 급여, 급여의 총합 그리고 평균 급여를 구하시오
SELECT to_char(hire_date, 'YYYY') YEAR, MIN(SALARY), MAX(SALARY), SUM(SALARY), ROUND(AVG(SALARY), 0)
FROM employees
GROUP BY to_char(hire_date, 'YYYY');

-- 2. 부서별 평균 급여가 $10,000 이상인 부서만 구하시오. ( 평균급여가 높은 순으로 )
SELECT DEPARTMENT_ID, ROUND(AVG(SALARY)) AVGSAL
FROM EMPLOYEES
GROUP BY DEPARTMENT_ID
HAVING ROUND(AVG(SALARY)) >= 10000;

-- 3. 부서별 최대 급여를 구하시오.  해당되는 부서번호는 10번과 20번임
SELECT DEPARTMENT_ID, MAX(SALARY) MAXSAL
FROM EMPLOYEES
WHERE DEPARTMENT_ID IN ('10', '20')
GROUP BY DEPARTMENT_ID;

--4. 이름의 성이 'King' 사원의 사번과 부서명을 출력 ( employees, departments )
SELECT e.employee_id, d.department_name
FROM employees e
       INNER JOIN departments d
                  ON e.department_id = d.department_id
WHERE e.last_name = 'King';

--5. 이름의 성이 'King' 사원의 사번과 부서명 그리고 업무명을 출력 ( employees, departments, jobs )
SELECT e.employee_id, e.FIRST_NAME, e.LAST_NAME, d.department_name, j.job_title
FROM employees e
       INNER JOIN departments d
                  ON e.department_id = d.department_id
       INNER JOIN jobs j
                  ON e.job_id = j.job_id
WHERE e.last_name = 'King';

--6. 2007년 상반기에 입사한 사원들의 사번과 이름, 입사일 그리고 부서명을 출력
--(*) Grant는 아직 부서가 배정받지 못한 상태이지만 Grant도 출력되려면
SELECT e.employee_id,
       e.first_name || ' ' || e.last_name fullname,
       e.hire_date,
       d.department_name
FROM employees e
       LEFT OUTER JOIN departments d
                       ON e.department_id = d.department_id
WHERE to_char(hire_date, 'YYYY-MM') <= '2007-06'
  AND to_char(hire_date, 'YYYY-MM') >= '2007-01'
ORDER BY HIRE_DATE DESC;

--7. 'Executive' 부서에서 사원과 해당 사원의 관리자 이름을 출력
--(*) 관리자가 없는 사원인 'King'이 출력되려면
SELECT E1.EMPLOYEE_ID EID, E1.FIRST_NAME ENAME, E1.MANAGER_ID MID, E2.FIRST_NAME MNAME, D.DEPARTMENT_NAME ENAME
FROM EMPLOYEES E1
       LEFT JOIN DEPARTMENTS D ON E1.DEPARTMENT_ID = D.DEPARTMENT_ID
       LEFT JOIN EMPLOYEES E2 ON E1.MANAGER_ID = E2.EMPLOYEE_ID
WHERE DEPARTMENT_NAME = 'Executive';

SELECT *
FROM ALL_TABLES
WHERE OWNER = 'HR';
SELECT *
FROM ALL_ALL_TABLES
WHERE OWNER = 'HR';

-- 적어도 한명의 사원으로부터 보고를 받을 수 있는 사원의 정보를 사원번호, 이름, 업무를 출력
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE EMPLOYEE_ID IN (
  SELECT DISTINCT MANAGER_ID
  FROM EMPLOYEES
);

-- 부하직원이 없는 사원
SELECT EMPLOYEE_ID, FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE EMPLOYEE_ID NOT IN (
  SELECT DISTINCT MANAGER_ID
  FROM EMPLOYEES
  WHERE MANAGER_ID IS NOT NULL
);

-- SCOTT
-- 1. scott의 업무와 급여로 jones의 업무와 급여를 수정
UPDATE EMP_COPY
SET (JOB, SAL) = (SELECT JOB, SAL FROM EMP WHERE ENAME = 'JONES')
WHERE ENAME = 'SCOTT';

-- 2. 부서명이  sales인 사원의 정보를 삭제
DELETE EMP_COPY
WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = 'SALES');

-- 3.  King에게 보고하는 모든 사원의 이름과 급여를 출력
SELECT *
FROM EMP
WHERE MGR = (SELECT EMPNO FROM EMP WHERE ename = 'KING');

-- 4. 월급이 30번 부서의 최저 월급보다 많은 사원들을 출력
SELECT *
FROM EMP
WHERE SAL >
      (SELECT min(SAL) FROM EMP WHERE DEPTNO = 30)
ORDER BY SAL
;

-- 5. 10번 부서의 직원들 중 30번 부서의 사원과 같은 업무를 맡고 있는 사원의 이름과 업무를 출력
SELECT ENAME, JOB, DEPTNO
FROM EMP
WHERE JOB IN
      (SELECT DISTINCT JOB FROM EMP WHERE DEPTNO = 30)
  AND DEPTNO = 10;

-- view
CREATE OR REPLACE VIEW v_emp AS
SELECT EMPNO, ENAME, DEPTNO
FROM EMP;

-- view read only
CREATE OR REPLACE VIEW v_emp AS
SELECT EMPNO, ENAME, DEPTNO
FROM EMP
  With READ ONLY;

-- 원본 테이블을 변경처리함 --그래서 read only 주면 insert 못
INSERT INTO v_emp(empno, ename, deptno)
VALUES (9999, '꽁심이', 30);

--view < join
CREATE OR REPLACE VIEW v_emp AS
SELECT e.EMPNO, e.ENAME, d.DNAME
FROM emp e,
     dept d
WHERE e.DEPTNO = d.DEPTNO;

-- 복합뷰 -- ORA-01776: 조인 뷰에 의하여 하나 이상의 기본 테이블을 수정할 수 없습니다.
INSERT INTO v_emp (EMPNO, ENAME, DNAME)
VALUES (9911, '손흥민', 'RESEARCH');

--
CREATE OR REPLACE VIEW dept_sum AS
SELECT d.DNAME dname, MIN(e.SAL) minsal, MAX(e.SAL) maxsal, ROUND(AVG(e.SAL)) avgsal
FROM EMP e
       INNER JOIN DEPT d ON e.DEPTNO = d.DEPTNO
GROUP BY d.DNAME;


-- 시퀀스
/*
CREATE  SEQUENCE   sequence_name
           [ minvalue 1                  -- 시퀀스 최소 숫자
            maxvalue 999999999999 -- 시퀀스 최대 숫자
            increment by 1             -- 증가치
            start with 1                  -- 시작숫자
            nocache                      -- cache를 사용하면 미리 값을 할당하여 조금 빠르게 접근
            noorder                      -- 요청되는 순서대로 값 할당
            nocycle ] ;                    -- 다시 시작할지 여부
*/

CREATE SEQUENCE seq_emp_empno START WITH 5000;

INSERT INTO emp(EMPNO, ENAME, DEPTNO)
VALUES (seq_emp_empno.nextval, '홍2', 10);
INSERT INTO emp(EMPNO, ENAME, DEPTNO)
VALUES (seq_emp_empno.nextval, '홍3', 10);
INSERT INTO emp(EMPNO, ENAME, DEPTNO)
VALUES (seq_emp_empno.nextval, '홍4', 10);

SELECT seq_emp_empno.currval
FROM dual;

--- 190516 ----
-- GRANT
GRANT SELECT_CATALOG_ROLE TO HR;
GRANT SELECT ANY DICTIONARY TO HR;

SELECT *
FROM USER_INDEXES;

-- tablespace creation
CREATE TABLESPACE p1 datafile '/directory_path/file_name.DBF' size 5 m;
CREATE TABLESPACE p2 datafile '/directory_path/file_name.DBF' size 5 m;
CREATE TABLESPACE p3 datafile '/directory_path/file_name.DBF' size 5 m;

-- create table and partition
CREATE TABLE sawon_p
(
  sabun  number(4),
  saname varchar2(20),
  job    varchar2(20),
  sal    number
)
  PARTITION BY RANGE (sabun)
(
  partition sawon_p1 values less than (2000) tablespace p1,
  partition sawon_p2 values less than (4000) tablespace p2,
  partition sawon_p3 values less than (8000) tablespace p3
);

-- insert 각각의 테이블 스페이스에 데이터를 저장
INSERT INTO sawon_p
VALUES (101, '삼순이', '개발', 5000);
INSERT INTO sawon_p
VALUES (3001, '사순이', '디자인', 5000);
INSERT INTO sawon_p
VALUES (5001, '오순이', '디자인', 5000);

-- update
-- 테이블 스페이스의 범위 내에서 사번의 변경은 가능, 다른 영역으로는 변경 불가
-- 테이블 스페이스의 저장 영역과 상관없는 JOB은 변경 가능

-- PL/SQL
/*
[문제-1]  emp 테이블에서 scott의사원번호, 이름, 입사일을 처리할 변수를 선언하고 값을 지정한후 화면 출력

DECLARE
  v_empno    number;
  v_ename    varchar2(30);
  v_hiredate date;
BEGIN
  SELECT empno,
         ename,
         hiredate
         INTO v_empno, v_ename, v_hiredate
  FROM emp
  WHERE ename = upper(‘SCOTT’
  );
  -- “” 사용하면 에러 ‘’사용해야
  dbms_output.put_line('사번 #' || v_empno);
  dbms_output.put_line('이름 #' || v_ename);
  dbms_output.put_line('입사일 #' || v_hiredate);
END;
/
*/

-- [문제-2] EMP 테이블의 컬럼의 데이터 타입으로 레코드 선언
/*
SET SERVEROUTPUT ON
  ACCEPT p_ename PROMPT '조회할 사원 이름은?'
DECLARE
  -- EMP 테이블의 컬럼들로 레코드타입 변수 선언
  emp_record emp%ROWTYPE;
  -- 입력한 이름을 저장할 변수 선언
  v_ename    emp.ename%TYPE := '&p_ename';
BEGIN
  SELECT * -- *는 emp%ROWTYPE으로 정의시 가능
         INTO emp_record
  FROM emp
  WHERE ename = upper(v_ename);
  dbms_output.put_line('사원 번호 : ' || to_char(emp_record.empno));
  dbms_output.put_line('사 원 명 : ' || emp_record.ename);
  dbms_output.put_line('업   무 : ' || emp_record.job);

EXCEPTION
  WHEN NO_DATA_FOUND THEN dbms_output.put_line('&p_ename' || '의 자료는 없습니다');
  WHEN TOO_MANY_ROWS THEN dbms_output.put_line('&p_ename' || '자료가 2건 이상입니다.');
  WHEN OTHERS THEN dbms_output.put_line('검색시 오류가 발생하였습니다.');
END;
/
SET SERVEROUTPUT OFF
*/

-- 부서가 20번인 사용자는 30%를 추가하기, 사번은 시퀀스를 이용
/*
ACCEPT p_name PROMPT '이름?'
ACCEPT p_sal PROMPT '월급?'
ACCEPT p_deptno PROMPT '부서번호?'

DECLARE
  v_name emp.ename%type := '&p_name';
  v_sal emp.sal%type := &p_sal;
  v_deptno emp.deptno%type := &p_deptno;

BEGIN
  IF v_deptno =20 THEN v_sal := v_sal * 1.3;
  END IF;
  INSERT INTO emp(EMPNO, ENAME, SAL, DEPTNO)
  VALUES (seq_emp_empno.nextval, v_name, v_sal, v_deptno);
  COMMIT ;

end;
*/


-- 이름을 입력받아서 그 사람의 업무가 MANAGER 이면 10%, ANALYST 면 20%,
-- SALESMAN 30%, PRESIDENT 40%, CLERK 50% 로 급여를 증가한다.
ACCEPT p_name PROMPT '이름을 입력하세요'
DECLARE
  v_name  emp.ename%type := upper('&p_name');
  v_job   emp.job%type ;
  v_sal   emp.sal%type ;
  v_empno emp.empno%type ;

BEGIN
  -- 1. 이름으로 검색한 결과를 내부 변수에 저장
  SELECT JOB,
         SAL,
         EMPNO
         INTO v_job, v_sal, v_empno
  FROM EMP
  WHERE ENAME = v_name;

  -- 2. 업무
  /*
IF v_job = 'MANAGER' THEN v_sal := v_sal * 1.1;
elsif v_job = 'ANALYST' THEN v_sal := v_sal * 1.2;
elsif v_job = 'SALESMAN' THEN v_sal := v_sal * 1.3;
elsif v_job = 'PRESIDENT' THEN v_sal := v_sal * 1.4;
elsif v_job = 'CLERK' THEN v_sal := v_sal * 1.5;
END IF ;
*/
  CASE v_job WHEN 'MANAGER' THEN v_sal := v_sal * 1.1;
    WHEN 'ANALYST' THEN v_sal := v_sal * 1.2;
    WHEN 'SALESMAN' THEN v_sal := v_sal * 1.3;
    WHEN 'PRESIDENT' THEN v_sal := v_sal * 1.4;
    WHEN 'CLERK' THEN v_sal := v_sal * 1.5;
    END CASE;

  -- 3. 해당 사원의 월급을 수정(update)
  UPDATE EMP
  SET SAL = v_sal
  WHERE ENAME = v_name;
  COMMIT;

  dbms_output.put_line(v_name || '님의 정보 수정 완료');
end;


-- 1.1부터 9까지의숫자를 입력 받아 해당하는 구구단을 출력
ACCEPT p_dan PROMPT  '구구단 단을 입력 : '

DECLARE
  v_dan INTEGER := &p_dan;
  cnt   INTEGER;

BEGIN
  FOR i IN 1..9
    LOOP
      cnt := v_dan * i;
      dbms_output.put_line(v_dan || ' * ' || i || ' = ' || cnt);
    END LOOP;
END;


-- 2.1부터100까지의 홀수의 합과 짝수의 합을 출력
DECLARE
  sum_odd  INTEGER := 0;
  sum_even INTEGER := 0;

BEGIN
  FOR i IN 1..10
    LOOP
      IF i mod 2 = 1 THEN
        sum_odd := sum_odd + i;
      ELSE
        sum_even := sum_even + i;
      end if;
    end loop;
  dbms_output.put_line('홀수의 합:' || sum_odd);
  dbms_output.put_line('짝수의 합:' || sum_even);
end;

-- 2. 부서번호를 입력 받아 사원번호,이름, 급여를 출력
ACCEPT p_deptno PROMPT '부서번호?'

DECLARE
  v_deptno emp.deptno%type;
  v_empno  emp.empno%type ;
  v_ename  emp.ename%type ;
  v_sal    emp.sal%type;

  CURSOR emp_cursor IS
    SELECT EMPNO, ENAME, SAL
    FROM EMP
    WHERE DEPTNO = v_deptno
    ORDER BY ENAME;

BEGIN
  OPEN emp_cursor;
  LOOP
    FETCH emp_cursor INTO v_empno, v_ename, v_sal;
    EXIT WHEN emp_cursor%NOTFOUND;
    DBMS_OUTPUT.PUT_LINE(lpad(v_empno, 6) || lpad(v_ename, 10) || lpad(v_sal, 10));
  end loop;
  CLOSE emp_cursor;
end;



-- hr
-- 1. Zlotkey와 동일한 부서에 속한 모든 사원의 이름과 입사일을 표시하는 질의를 작성하십시오.  // Zlotkey는 제외하십시오.
SELECT *
FROM EMPLOYEES
WHERE DEPARTMENT_ID = (SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE LAST_NAME = 'Zlotkey')
  AND LAST_NAME != 'Zlotkey';

-- 2. 급여가 평균 급여보다 많은 모든 사원의 사원 번호와 이름을 표시하는 질의를 작성하고, 결과를 급여에 대해 오름차순으로 정렬하십시오.
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEES)
ORDER BY SALARY;
-- 3. King에게 보고하는 모든 사원의 이름과 급여를 표시하십시오.
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, MANAGER_ID
FROM EMPLOYEES
WHERE MANAGER_ID IN (SELECT EMPLOYEE_ID FROM EMPLOYEES WHERE LAST_NAME = 'King');

-- 4. Executive 부서의 모든 사원에 대한 부서 번호, 이름 및 업무 ID를 표시하십시오.
SELECT DEPARTMENT_ID, FIRST_NAME, JOB_ID
FROM EMPLOYEES
WHERE DEPARTMENT_ID =
      (SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME = 'Executive');

-- 5. 평균 급여보다 많은 급여를 받고 이름에 u가 포함된 사원과 같은 부서에서 근무하는 모든 사원의 사원 번호, 이름 및 급여를 표시하는 질의를 작성하십시오.
SELECT EMPLOYEE_ID, FIRST_NAME, SALARY, DEPARTMENT_ID
FROM EMPLOYEES
WHERE DEPARTMENT_ID IN (
  SELECT DISTINCT DEPARTMENT_ID
  FROM EMPLOYEES
  WHERE FIRST_NAME LIKE '%u%' AND SALARY > (SELECT AVG(SALARY) FROM EMPLOYEES));