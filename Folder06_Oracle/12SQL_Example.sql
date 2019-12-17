--hr계정

--문제1) EMPLOYEES 테이블에서 Kochhar의 급여보다 많은 사원의 정보를
--         사원 번호,이름,담당업무,급여를 출력하라.
SELECT
    employee_id, last_name, job_id, salary
FROM employees
WHERE  salary > (
                            SELECT b.salary
                            FROM employees a, employees b
                            WHERE a.employee_id= b.employee_id
                            AND a.last_name = 'Kochhar'
                            );

select * FROM employees;
--강의답
SELECT employee_id, first_name, job_id, salary
FROM employees
WHERE salary > (SELECT salary FROM employees WHERE last_name = 'Kochhar');

--문제2) EMPLOYEES 테이블에서 급여의 평균보다 적은 사원의 정보를 
--             사원번호, 이름,담당업무,급여,부서번호를 출력하여라. 
SELECT employee_id, last_name, job_id, salary, department_id
FROM employees
WHERE salary < (SELECT AVG(salary)
                            FROM employees)
ORDER BY salary ASC;


SELECT employee_id, last_name, job_id, salary, department_id
FROM employees
WHERE salary < (SELECT AVG(salary) FROM employees );



select * FROM employees;
--문제3) EMPLOYEES 테이블에서 100번 부서의 최소 급여보다 최소 급여가 많은 다른 모든 부서를 출력하라 
SELECT department_id, MIN(salary)
FROM employees
WHERE salary> (SELECT min(salary) FROM employees WHERE department_id = 100)
GROUP BY department_id
ORDER BY department_id ASC;

--강읩답
SELECT department_id, MIN(salary)
FROM employees
WHERE salary> (SELECT min(salary) FROM employees WHERE department_id = 100)
GROUP BY department_id
HAVING MIN(salary) > ( SELECT MIN(salary)
                                    FROM employees
                                    WHERE department_id = 100);


--문제4) 업무별로 최소 급여를 받는 사원의 정보를 사원번호,이름,업무,부서번호 를 출력하여라. 단 업무별로 정렬하여라. 
SELECT a.employee_id, a.last_name, a.job_id, a.salary, a.department_id
FROM employees a, (SELECT job_id AS "jobid1", min(salary) AS "minsal1" FROM employees GROUP BY job_id ) b
WHERE a.job_id = b."jobid1" AND a.salary = b."minsal1"
ORDER BY a.employee_id DESC;

--강의답
SELECT employee_id, last_name, job_id, department_id, salary 
FROM employees
WHERE (job_id, salary) IN (SELECT job_id, MIN(salary) 
                                            FROM employees
                                            GROUP BY job_id)
ORDER BY job_id ASC;

--문제5) EMPLOYEES 과 DEPARTMENTS 테이블에서 
--        업무(job_id)가 세일드맨(SA_MAN) 사원의 정보를 이름,업무,부서명,근무지를 출력하라. 
SELECT e.last_name, e.job_id, d.department_name, d.location_id, l.city
FROM employees e, departments d, locations l
WHERE e.department_id = d.department_id
AND d.location_id = l.location_id
AND job_id='SA_MAN';

--강의답
select e.first_name, e.job_id, d.department_name, d.location_id
FROM employees e, departments d
WHERE e.department_id = d.department_id
AND e.department_id = d.department_id
ANd e.job_id = 'SA_MAN';

--강의답2
select e.first_name, e.job_id, d.department_name, d.location_id
FROM (SELECT first_name, job_id, department_id
            FROM employees
            WHERE job_id = 'SA_MAN') e, departments d
WHERE e.department_id = d.department_id;
             

--문제6) EMPLOYEES 테이블에서 가장 많은 사원을 갖는 MANAGER의 사원번호를 출력하라. 

SELECT RNUM, employee_id, "총합"
            FROM(
                        SELECT ROWNUM AS "RNUM", a. employee_id, b."총합"
                        FROM employees a, (SELECT  DISTINCT manager_id, COUNT(*)OVER(PARTITION BY manager_id) AS "총합" FROM employees) b
                        WHERE a.employee_id = b.manager_id
                        ORDER BY b."총합" desc
                        )
WHERE RNUM=1;
            
                                        /*
                                        SELECT a. employee_id, b."총합"
                                        FROM employees a, (SELECT  DISTINCT manager_id, COUNT(*)OVER(PARTITION BY manager_id) AS "총합" FROM employees) b
                                        WHERE a.employee_id = b.manager_id
                                        ORDER BY "총합" DESC;
                                        */
                                        
--강의답
SELECT  manager_id, COUNT(*)
FROM employees
GROUP BY manager_id
HAVING COUNT(manager_id )= ( SELECT MAX(COUNT(*))
                                                    FROM employees
                                                    GROUP BY manager_id);


--문제7) EMPLOYEES 테이블에서 가장 많은 사원이 속해있는 부서번호와 사원수를 출력하라. 
SELECT RNUM, department_id, "부서별 총 인원"
FROM (

            SELECT ROWNUM AS RNUM, department_id, "부서별 총 인원"
            FROM (
                        SELECT DISTINCT department_id, COUNT(*)OVER(PARTITION BY department_id) AS "부서별 총 인원" 
                        FROM employees
                        ORDER BY "부서별 총 인원" DESC
                        )
            )
WHERE RNUM=1;

SELECT department_id, COUNT(department_id)
FROM employees
GROUP BY department_id
HAVING COUNT(department_id) = (SELECT MAX(COUNT(*))
                                                        FROM employees
                                                        GROUP BY department_id);

--문제8) EMPLOYEES 테이블에서 
--사원번호가 123인 사원의 직업과 같고 
--사원번호가 192인 사원의 급여(SAL)보다 많은 
--사원의 사원번호, 이름, 직업, 급여를 출력하라. 

SELECT employee_id, first_name, job_id, salary
FROM employees
WHERE job_id = (SELECT job_id FROM employees WHERE employee_id  =123)
AND  salary>(SELECT salary FROM employees WHERE employee_id  =192);


--문제9) 직업(JOB)별로 최소 급여를 받는 사원의 정보를 사원번호, 이름, 업 무, 부서명을 출력하라. 
-- 조건1 : 직업별로 내림차순 정렬 

--문제10) EMPLOYEES 테이블에서 업무별로 최소 급여를 받는 사원의 정보를 사 원번호,이름,업무,입사일자,급여,부서번호를 출력하라


--문제11) EMPLOYEES 테이블에서 50번 부서의 최소 급여를 받는 사원 보다 많 은 급여를 받는 사원의 정보를 
            -- 사원번호,이름,업무,입사일자,급여,부서번호를 출력하라. 단 50번은 제외 

--문제12) EMPLOYEES 테이블에서 50번 부서의 최고 급여를 받는 사원 보다 많은 급여를 받는 사원의 정보를
                --사원번호,이름,업무,입사일자,급여,부서번호를 출력하라. 단50번은 제외 

--문제13) 최근 입사한 사원 순으로 작성해서 1 ~ 10번째, 11 ~ 20 사원의 정보 를 출력하시오

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--scott특수쿼리


--33) 각 사원의 이름을 표시하고 근무 달 수(입사일로부터 현재까지의 달수)를 계산하여
--열 레이블을 MONTHS_WORKED로 지정하시오. 결과는 정수로 반올림하여 표시하고 근무달 수를
--기준으로 오름차순으로 정렬하시오.(MONTHS_BETWEEN 함수 참고)
--ROUND함수,
SELECT  ename, MONTHS_BETWEEN(SYSDATE, hiredate) AS MONTHS_WORKED
FROM emp
ORDER BY MONTHS_WORKED ASC;

--34)emp테이블에서 이름, 업무, 근무연차를 출력하시오.
SELECT ename, job, trunc(MONTHS_BETWEEN(SYSDATE,hiredate)/12)
FROM emp;


--35)emp테이블에서 사원이름, 월급, 월급과 커미션을 더한 값을 컬럼명 실급여라고 해서 출력.
--단, NULL값은 나타나지 않게 작성하시오.

--36)월급과 커미션을 합친 금액이 2,000이상인 급여를 받는 사원의 이름,업무,월급,커미션,고용날짜
--를 출력하시오. 단, 고용날짜는 1980-12-17 형태로 출력하시오.
SELECT 
    ename, job, sal, nvl(comm,0), to_char(hiredate, 'YYYY-MM-DD')
FROM emp
WHERE sal + nvl(comm, 0)>=2000;


--37)DECODE 또는 CASE WHEN THEN 함수를 사용하여 다음 데이터에 따라 JOB열의 값을 기준으로
--모든 사원의 등급을 표시하시오.
--업무        등급
--PRESIDENT   A
--ANALYST     B
--MANAGER     C
--SALESMAN    D
--CLERK       E
SELECT job, 
            DECODE(job, 
            'PRESIDENT', 'A',            
            'ANALYST', 'B',
            'MANAGER', 'C',
            'SALESMAN', 'D',
            'CLERK', 'E',
            '0') AS "GRAD"
FROM emp;

SELECT ename, sal, job,
CASE job
    CASE job WHEN 'PRESIDENT' THEN 'A'
    CASE job WHEN 'ANALYST' THEN 'B'
    CASE job WHEN 'MANAGER' THEN 'C'
    CASE job WHEN 'SALESMAN' THEN 'D'
    CASE job WHEN 'CLERK' THEN 'E'
    ELSE '0'
    END AS "GRADE"
FROM emp;
    


---------------------------------------------------------------------------------------------------------------------------------------------------------------------

-- 60) (BLAKE와 같은 부서)에 있는 사원들의 이름과 입사일을 구하는데 
-- BLAKE는 제외하고 출력하시오.(BLAKE가 여러명일 수 있음)
SELECT ename, hiredate, deptno
FROM emp
WHERE deptno IN(SELECT deptno
                            FROM emp
                            WHERE ename = 'BLAKE')
AND ename != 'BLAKE';
    
-- 61) 평균급여보다 많은 급여를 받는 사원들의 사원번호, 이름, 월급을 출력하는데 
-- 월급이 높은 사람순으로 출력하시오.
SELECT empno, ename, sal

FROM emp
WHERE sal > (SELECT AVG(sal) FROM emp)
ORDER BY sal DESC;


-- 62) (10번부서에서 급여를 가장 적게 받는 사원)과 동일한 급여를 받는 사원의 이름을 출력하시오.
SELECT  ename, sal, deptno
FROM emp
WHERE sal = ( SELECT MIN(sal)
                        FROM emp
                        WHERE deptno = 10);
                        
-- 63) 사원수가 3명이 넘는 부서의 부서명과 사원수를 출력하시오.
--그룹바이문제
SELECT d.dname, COUNT(e.empno)
FROM emp e, dept d
WHERE e.deptno = d.deptno
GROUP BY d.dname
HAVING COUNT(e.empno)>3;


-- 64) (사원번호가 7844인 사원)보다 빨리 입사한 사원의 이름과 입사일을 출력하시오.
SELECT ename, hiredate
FROM emp
WHERE hiredate < (SELECT hiredate
                                FROM emp 
                                WHERE empno = 7844);


-- 65) 직속상사(mgr)가 KING인 모든 사원의 이름과 급여를 출력하시오.
SELECT ename, sal, mgr
FROM emp
WHERE mgr = (SELECT empno FROM emp WHERE ename = 'KING');


-- 66) (20번 부서에서 가장 급여를 많이 받는 사원)과 동일한 급여를 받는 
-- 사원의 이름과 부서명,급여, 급여등급을 출력하시오.(emp, dept, salgrade)

SELECT e.ename, d.dname, e.sal, s.grade
FROM emp e, dept d, salgrade s
WHERE sal = (SELECT MAX(sal) FROM emp WHERE deptno = 20)
AND e.deptno = d.deptno 
AND e.sal >= s.losal
AND e.sal <=s.hisal;


--67) 총급여(sal+comm)가 평균 급여보다 많은 급여를 받는 사람의 부서번호, 이름, 총급여, 
--    커미션을 출력하시오.(커미션은 유(O),무(X)로 표시하고 컬럼명은 "comm유무" 출력)
SELECT deptno, ename, sal + nvl(comm,0), nvl2(comm, '0', 'x')
FROM emp
WHERE sal + nvl(comm, 0) > (SELECT AVG(sal)   
                                                FROM emp);


-- 68) (CHICAGO 지역에서 근무하는 사원의 평균 급여)보다 높은 급여를 받는 사원의 이름과 급여,
--    지역명을 출력하시오.
/*      1. 지역을구한다.
        2. 평균급여를 구해서 
        3. 지역과 평균급여를 서로비교한다.*/
        
SELECT e.ename, e.sal, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND sal>  (SELECT AVG(sal)             --2. 평균급여
        FROM emp
        WHERE deptno = (SELECT deptno      -- 1. 지역번호
                                        FROM dept
                                        WHERE loc = 'CHICAGO')
        GROUP BY deptno
        );



-- 69) 업무가 SALESMAN인 직원이 2명 이상인 부서의 이름, 근무하는 사원의 이름, 업무를 출력
--    하시오.(컬럼명은 부서명, 사원명, 업무로 출력)
SELECT d.dname, e.ename, e.job
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND e.deptno in(
                            SELECT deptno
                            FROM emp
                            WHERE job = 'SALESMAN'
                            GROUP BY deptno
                            HAVING COUNT(job) >=2
                         );
                
-- 70) (커미션이 없는 사원들) 중 월급이 가장 높은 사원의 이름과 급여등급을 출력하시오.

SELECT e.ename, s.grade
FROM emp e,  salgrade s
WHERE sal =  (SELECT MAX(sal)
                        FROM emp
                        WHERE comm IS NULL OR comm = 0)
    AND 
            sal BETWEEN s.losal AND s.hisal;



-- 71) SMITH의 관리자(mgr)의 이름과 부서명, 근무지역을 출력하시오. 

SELECT e.ename, d.dname, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND 
e.empno = (SELECT mgr
                FROM  emp 
                WHERE ename = 'SMITH');


---------------------------------------------------------------------------------------------------------------------------------------------------------------------







