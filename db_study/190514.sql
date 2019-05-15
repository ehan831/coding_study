-- << 도전 문제 >>
-- 1. 업무별, 부서별 급여 합계와 인원수를 출력하되, 10번 부서를 제외하고 업무가 ‘SALESMAN’과 ‘MANAGER’만 출력한다.
SELECT JOB, DEPTNO, sum(SAL) sum, count(*) FROM EMP
WHERE DEPTNO != 10 AND JOB IN ('SALESMAN', 'MANAGER')
GROUP BY JOB, DEPTNO;

-- 2. 업무별로 평균급여와 최대급여를 출력하되, 평균급여가 2000이상인 것만 출력하고 평균급여가 높은 순으로 정렬
SELECT job, round(avg(sal)) avg, max(sal) max
FROM emp
GROUP BY job
HAVING round(avg(sal)) >=2000
ORDER BY avg desc;

-- 3. 5개씩 급여합계와 인원수를 출력 (rownum이용)
SELECT sum(sal) sum,count(*) cnt
FROM emp
group by ceil(rownum/5);

-- 4. 같은 입사년도 별로 인원수를 출력
SELECT to_char(HIREDATE,'YYYY'), count(*) cnt
FROM emp
GROUP BY to_char(HIREDATE,'YYYY');

-- 5. 다음과 같이 출력
/*
   CLERK     SALESMAN MANAGER       (업무명)
-----------------------------------------------------------------------
     4           4       3           (인원수)
*/
SELECT
  sum(decode( job, 'CLERK',1)) as CLERK,
  sum(decode( job, 'SALESMAN', 1)) as SALESMAN,
  sum(decode( job, 'MANAGER', 1)) as MANAGER
FROM emp;


-- 6. 다음과 같이 출력
/*
업무명  10번부서 20번부서 30번부서 급여합계
----------------------------------------------------------------------------------------
CLERK  1300  1900     950  4150
SALESMAN 0     0    5600   5600
PRESIDENT 5000     0       0  5000
MANAGER    2450  2975    2850  8275
ANALYST     0  6000       0  6000
*/
select job                   "업무명",
  sum(decode(deptno,10,sal)) "10번부서" ,
  sum(decode(deptno,20,sal)) "20번부서" ,
  sum(decode(deptno,30,sal)) "30번부서" ,
  sum(sal)                   "급여합계"
from emp
group by job;




-----------------------

-- inner join
-- oracle ver.
select e.ename, d.dname, d.deptno
from emp e, dept d
where e.deptno = d.deptno;

-- ansi ver.
select e.ename, d.dname, d.deptno
from emp e INNER JOIN dept d
ON e.deptno = d.deptno;

select e.ename, d.dname, deptno
from emp e INNER JOIN dept d
USING (deptno);

-- outer join
-- oracle ver.
select e.ename, d.dname, d.deptno
from emp e, dept d
where e.deptno = d.deptno(+)
order by ENAME;

-- ms sql? ver.
select e.ename, d.dname, d.deptno
from emp e, dept d
where e.deptno =+ d.deptno
order by ENAME;

-- ansi ver.
select e.ename, d.dname, d.deptno
from emp e LEFT OUTER JOIN dept d
ON e.deptno = d.deptno;

select e.ename, d.dname, d.deptno
from emp e RIGHT OUTER JOIN dept d
ON e.deptno = d.deptno;

-- self join
-- oracle ver.
-- 사원테이블(emp)에 각 사원의 매니저를 조회
select e.empno,e.ename, e.mgr, e2.ename
from emp e, emp e2
where e.mgr =e2.empno(+);

select a.EMPNO, a.ename emp_name, a.MGR, b.ename manager_name
from emp a JOIN emp b
ON a.mgr = b.empno; -- king 없음!?



-- <도전문제 > HR 계정
-- 사원번호, 사원명, 부서명 출력
SELECT e.EMPLOYEE_ID, e.FIRST_NAME, e.DEPARTMENT_ID, d.DEPARTMENT_NAME
FROM EMPLOYEES e LEFT OUTER JOIN DEPARTMENTS d
ON e.DEPARTMENT_ID = d.DEPARTMENT_ID;

-- 사원번호, 사원명, 업무명, 부서명 출력
SELECT e.EMPLOYEE_ID, e.FIRST_NAME, e.JOB_ID, d.DEPARTMENT_NAME
FROM EMPLOYEES e LEFT OUTER JOIN DEPARTMENTS d
ON e.DEPARTMENT_ID = d.DEPARTMENT_ID;

-- 사원번호, 사원명, 부서명, 위치 출력
SELECT e.EMPLOYEE_ID, e.FIRST_NAME, d.DEPARTMENT_NAME, d.LOCATION_ID, l.STREET_ADDRESS
FROM EMPLOYEES e
  LEFT OUTER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
  LEFT OUTER JOIN LOCATIONS l ON d.LOCATION_ID = l.LOCATION_ID;

-- 사원번호, 사원명, 업무명, 부서명, 위치출력
SELECT e.EMPLOYEE_ID, e.FIRST_NAME, e.JOB_ID, d.DEPARTMENT_NAME, d.LOCATION_ID, l.STREET_ADDRESS
FROM EMPLOYEES e
  LEFT OUTER JOIN DEPARTMENTS d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
  LEFT OUTER JOIN LOCATIONS l on d.LOCATION_ID = l.LOCATION_ID;

-- 입사년도 별 최고 월급을 받는 사원의 이름과 부서명을 출력
SELECT e1.FIRST_NAME, e1.HIRE_DATE, e1.SALARY, d.DEPARTMENT_NAME
FROM EMPLOYEES e1
  INNER JOIN (
    SELECT TO_CHAR(HIRE_DATE, 'YYYY') year, MAX(SALARY) maxsal
    FROM EMPLOYEES e2
    GROUP BY TO_CHAR(HIRE_DATE, 'YYYY')
    ORDER BY year
  ) e2
    ON TO_CHAR(e1.HIRE_DATE, 'YYYY') = e2.year
    AND e1.SALARY = e2.maxsal
  LEFT JOIN DEPARTMENTS d ON e1.DEPARTMENT_ID = d.DEPARTMENT_ID
ORDER BY HIRE_DATE;

SELECT TO_CHAR(HIRE_DATE, 'YYYY') year1, MAX(SALARY) maxsal
    FROM EMPLOYEES e2
GROUP BY TO_CHAR(HIRE_DATE, 'YYYY')
ORDER BY year1;


