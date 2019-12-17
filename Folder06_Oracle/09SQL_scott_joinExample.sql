--SCOTT
-- 50) 모든 사원의 이름, 부서번호, 부서이름을 표시하시오.(emp,dept)
SELECT
    e.ename, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno;

SELECT
    e.ename, e.deptno, d.deptno, d.dname
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND d.dname ='SALES';


--51) 업무가 MANAGER인 사원의 정보를 이름,업무,부서명,근무지 순으로
--    출력하시오.(emp,dept)
SELECT e. ename, e.job, d.dname, d.loc
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND e. job = 'MANAGER';


-- 52) 커미션을 받고 급여가 1,600이상인 사원의 사원이름,부서명,근무지를 출력하시오
SELECT 
*
FROM emp e, dept d
WHERE e.deptno = d.deptno
AND e.comm IS NOT NULL
AND e.comm <>0
AND e.sal>=1600;




-- 53) 근무지가 CHICAGO인 모든 사원의 이름,업무,부서번호 및 부서이름을 표시하시오.
SELECT e.ename, e.job, d.deptno, d.dname, d.loc
FROM dept d, emp e
WHERE d.deptno=  e.deptno
AND d.loc = 'CHICAGO';

-- 54) 근무지별로 근무하는 사원의 수가 5명 이하인 경우, 인원이 적은 도시순으로 정렬하시오.
-- (근무 인원이 0명인 곳도 표시)
SELECT 
d.loc, COUNT(e.empno)
FROM emp e, dept d
WHERE e.deptno(+) = d.deptno
GROUP BY d.loc
HAVING count(e.empno) <=5
ORDER BY COUNT(e.empno) ASC;


-- 55) 사원의 이름 및 사원 번호를 관리자의 이름과 관리자 번호와 함께 표시하고 
-- 각각의 열 레이블은 employee, emp#, manager, mgr#로 지정하시오.
SELECT
a.ename, a.empno, b.ename, b.empno
FROM emp a, emp b
WHERE a.mgr = b.empno;


-- 56) 관리자보다 먼저 입사한 모든 사원의 이름 및 입사일을 
-- 관리자의 이름 및 입사일과 함께 표시하고 관리자보다 입사일이 빠른 사원을 산출하라.
-- 열 레이블을 각각 employee, emp hired, manager, mgr hired로 지정
SELECT 
a.ename, a.hiredate, b.ename, b.hiredate
FROM emp a, emp b
WHERE a.mgr = b.empno
AND a.hiredate < b.hiredate;



-- 57) 사원의 이름 및 사원번호를 관리자의 이름과 관리자 번호와 함께 표시하고 
-- 각각의 열 레이블은 employee, emp#, manager, mgr#로 지정하는데 
-- King을 포함하여 관리자가 없는 모든 사원을 표시하도록 하고 
-- 결과를 사원번호를 기준으로 정렬
SELECT a.ename, a.empno, b.ename, b.empno
FROM emp a, emp b
WHERE a.mgr = b.empno(+)
ORDER BY a.empno ASC;


-- 58) 지정한 부서번호, 사원이름 및 지정한 사원과 동일한 부서에서 근무하는 
-- 모든 사원을 표시하도록 질의를 작성하고 
-- 부서번호는 department, 사원이름은 employee, 동일한 부서에서 근무하는 사원은 colleague로 표시하시오.
-- (부서번호, 사원이름,동료 순으로 오름차순 정렬) 
SELECT
a.empno, a.deptno, b.deptno, b.empno
FROM emp a, emp b
WHERE a.deptno = b.deptno
AND a.empno != b.empno
AND a.ename = 'SMITH'       --smith와 같은 부서에서 근무하는 사원.
ORDER BY a.empno ASC;


-- 59)10번 부서에서 근무하는 사원들의 
-- 부서번호, 부서이름, 사원이름, 월급, 급여등급을 출력하시오.
SELECT 
e.deptno, d.dname, e.ename, e.sal, s.grade
FROM emp e, dept d, salgrade s
WHERE e.deptno = d.deptno
AND e.deptno = 10
--아래 한줄이 다르다
AND e.sal >= s.losal AND e.sal <=s.hisal;

SELECT 
e.deptno, d.dname, e.ename, e.sal, s.grade
FROM emp e, dept d, salgrade s
WHERE e.deptno = d.deptno
AND e.deptno = 10
--아래 한줄이 다르다
AND e.sal BETWEEN s.losal AND s.hisal;




