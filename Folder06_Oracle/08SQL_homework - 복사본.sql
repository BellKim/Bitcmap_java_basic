--문제1) EMPLOYEES 테이블에서 입사일자 순으로 정렬하여 사원번호, 이름, 업 무, 급여, 입사일자,부서번호를 출력하라.
select
    employee_id, last_name, job_id, salary, hire_date
FROM employees
ORDER BY TO_DATE(hire_date, 'MM/DD/YY') asc;

--문제2) EMPLOYEES 테이블에서 가장 최근에 입사한 순으로 사원번호, 이름, 업무, 급여, 입사일자,부서번호를 출력하라. 
SELECT
    employee_id, last_name, job_id, salary, hire_date
FROM employees
ORDER BY TO_DATE(hire_date, 'YY/MM/DD') desc;

--문제3) EMPLOYEES 테이블에서 부서번호로 정렬한 후 부서번호가 같을 경우 급여가 많은 순으로 정렬하여 사원번호, 성명, 업무, 부서번호, 급여를 출력하 여라. 
SELECT
    department_id, last_name, job_id, employee_id, salary
FROM employees
ORDER BY salary desc;

--문제4) EMPLOYEES 테이블에서 첫번째 정렬은 부서번호로 두번째 정렬은 업무로 세번째 정렬은 급여가 많은 순으로 정렬하여 사원번호, 성명, 입사일자, 부서번호, 업무, 급여를 출력하여라. 
SELECT * FROM employees;
SELECT
    department_id, last_name, job_id, employee_id, salary
FROM employees
ORDER BY department_id desc, job_id desc, salary asc;
--문제5) 부서별로 담당하는 업무를 한번씩 출력하여라. 
SELECT * FROM employees;
SELECT
    job_id
FROM employees;







--문제6) EMPLOYEES 테이블에서 King의 정보를 소문자로 검색하고 사원번호, 성명, 담당업무(소문자로),부서번호를 출력하라. 
SELECT
    employee_id, last_name
FROM employees
WHERE upper(last_name) = 'KING';
--문제7) EMPLOYEES 테이블에서 King의 정보를 대문자로 검색하고 사원번호, 성명, 담당업무(대문자로),부서번호를 출력하라. 
SELECT
    department_id || ' ' || department_name, 
    department_name  || ' ' || location_id
FROM departments;
--concat 사용해서 출력  CONCAT(department_name, dddddd);
--문제8) DEPARTMENTS 테이블에서 부서번호와 부서이름, 부서이름과 위치번 호를 합하여 출력하도록 하라. 
SELECT
employee_id, first_name, job_id, salary, department_id
FROM employees
WHERE SUBSTR(first_name, 1, 1)>'k'
    AND SUBSTR(first_name, 1, 1)<'Y'
    ORDER BY first_name ASC;            --틀림.



--문제9) EMPLOYEES 테이블에서 이름의 첫 글자가 ?K? 보다 크고 ?Y?보다 적은 사원의 정보를 사원번호, 이름, 업무, 급여, 부서번호를 출력하라. 단 이름순으로 정렬하여라. 
SELECT 
    employee_id, first_name, LENGTH(first_name), salary, LENGTH(salary), department_id
FROM employees
WHERE department_id = 20;

SELECT COUNT(*)
FROM employees
WHERE department_id = 20;

--문제10) EMPLOYEES 테이블에서 20번 부서 중 이름의 길이 및 급여의 자릿수 를 사원번호, 이름, 이름의 자릿수, 급여, 급여의 자릿수를 출력하라. 
--INSTR 찾고자 하는 문자
SELECT
first_name, INSTR(first_name, 'e', 1, 1)
FROM employees;



--문제11) EMPLOYEES 테이블에서 이름 중 ?e?자의 위치를 출력하라. 
--문제12) 다음의 쿼리를 실행하고 결과를 분석하라. 
--SELECT ROUND(4567.678),ROUND(4567.678,0), ROUND(4567.678,2),ROUND(4567.678,-2) FROM dual; 
SELECT ROUND(4567.678) FROM DUAL;
SELECT ROUND(4567.678,0) FROM DUAL;ㅇ
SELECT ROUND(4567.678,2) FROM DUAL;
SELECT ROUND(4567.678,-2) FROM DUAL;

--문제13) EMPLOYEES 테이블에서 부서번호가 80인 사람의 급여를 30으로 나눈 나머지를 구하여 출력하라. 
select * FROM employees;
SELECT 
employee_id, first_name, MOD(salary,30), salary, department_id --                round((salary/30),0) AS hello
FROM employees
WHERE department_id =80;
--문제14) EMPLOYEES 테이블에서 30번 부서 중 이름과 담당 업무를 연결하여 출력하여라. 단 담당 업무를 한 줄 아래로 출력하라. 
--아스키코드값 10은 \n 과 같은 기능을 한다. 
SELECT 
    first_name || CHR(10) || job_id, department_id
FROM employees
WHERE department_id = 30;

--보이기엔 한줄처럼 보이지만 그리드를 더블 클릭하면 개행 되었다는 것을 확인할 수 있습니다. 
--문제15) EMPLOYEES 테이블에서 현재까지 근무일 수가 몇주 몇일 인가를 출 력하여라. 단 근무 일수가 많은 사람 순으로 출력하여라. 
SELECT first_name, hire_date, 
            trunc(sysdate - hire_date) AS "총 근무일수"
FROM employees;

--몇주 몇일 출력 
SELECT first_name, hire_date, 
            trunc(TO_DATE('19/12/01') - hire_date) AS "총 근무일수",
            trunc( (TO_DATE('19/12/01') - hire_date) /7 ) AS "총 근무 주일수",
            MOD( (TO_DATE('19/12/01') - hire_date),7 ) AS "남은 날수"
FROM employees
ORDER BY "총 근무일수" DESC;


--문제16) EMPLOYEES 테이블에서 부서 50에서 급여 앞에 $를 삽입하고 3자리 마다 ,를 출력하라 
SELECT
    first_name, department_id, salary, TO_CHAR(salary, '$999,999,999')
FROM employees
WHERE department_id = 50;


--문제17) 다음의 결과를 분석하여 보아라. 
--DECODE 각 조건에 맞는 값을 별도로 출력하고자 할때 사용한다. 
SELECT 
    EMPLOYEE_ID, LAST_NAME, JOB_ID, SALARY, 
    DECODE(JOB_ID,
    'IT_PROC', SALARY*1.1, 
    'ST_MAN', SALARY*1.15,
    'SA_MAN', SALARY*1.2, SALARY) d_sal 
FROM EMPLOYEES 
ORDER BY SALARY DESC; 

--문제18) EMPLOYEES 테이블에서 모든 SALESMAN(SA_MAN)에 대하여 급여의 평균, 최고액, 최저액, 합계를 구하여 출력하여라. 
SELECT
    AVG(salary), MAX(salary), MIN(salary), sum(salary)
FROM employees
WHERE job_id LIKE 'SA_%';

--문제19) EMPLOYEES 테이블에 등록되어 있는 인원수, 보너스가 NULL이 아닌 인원수, 보너스의 평균, 등록되어 있는 부서의 수를 구하여 출력하라. 
SELECT
    COUNT(*), COUNT(employee_id),trunc(AVG(commission_pct * salary)),
    COUNT(DISTINCT department_id)       --distinct 중복제거
FROM employees;


--문제20) EMPLOYEES 테이블에서 부서별로 인원수, 평균 급여, 최저급여, 최고 급여, 급여의 합을 구하여 출력하라. 
SELECT 
department_id, count(*), ROUND(AVG(salary), 1), MIN(salary), MAX(salary), SUM(SALARY)
FROM employees
GROUP BY department_id;

--문제21) EMPLOYEES 테이블에서 각 부서별로 인원수,급여의 평균, 최저 급여, 최고 급여, 급여의 합을 구하여 급여의 합이 많은 순으로 출력하여라. 
SELECT 
department_id, count(*), ROUND(AVG(salary), 1), MIN(salary), MAX(salary), SUM(SALARY) AS "급여의합"
FROM employees
GROUP BY department_id
ORDER BY "급여의합" DESC;



--문제22) EMPLOYEES 테이블에서 부서별, 업무별 그룹하여 결과를 부서번호, 업 무, 인원수, 급여의 평균, 급여의 합을 구하여 출력하여라. 
SELECT 
    department_id, job_id, COUNT(*), trunc(AVG(salary)), sum(salary)
FROM employees
GROUP BY department_id, job_id;

SELECT 
    department_id, job_id
FROM employees
WHERE department_id = '110';

--문제23) EMPLOYEES 테이블에서 부서 인원이 4명보다 많은 부서의 부서번호, 인원수, 급여의 합을 구하여 출력하여라.(GROUP BY, HAVING) 
SELECT
    department_id, count(*)
FROM employees
GROUP BY department_id
HAVING COUNT(*)>4;

--문제24) EMPLOYEES 테이블에서 급여가 최대 10000이상인 부서에 대해서 부 서번호, 평균 급여, 급여의 합을 구하여 출력하여라. 
SELECT
    department_id, AVG(salary), MAX(salary), SUM(salary)
    
FROM employees
GROUP BY department_id
HAVING MAX(salary)>=10000;

--문제25) EMPLOYEES 테이블에서 업무별 급여의 평균이 10000 이상인 업무에 대해서 업무명,평균 급여, 급여의 합을 구하여 출력하라. 
SELECT
    job_id, AVG(salary), SUM(salary)
FROM employees
GROUP BY job_id
HAVING MAX(salary) >=10000;



--문제26) EMPLOYEES 테이블에서 젂체 월급이 10000을 초과하는 각 업무에 대 해서 업무와 월급여 합계를 출력하라. 단 판매원은 제외하고 월 급여 합계로 정렬(내림차순)하라.(SA_) 
SELECT
    job_id, SUM(salary)
FROM employees 
WHERE job_id NOT LIKE 'SA%'
GROUP BY job_id
HAVING SUM(salary)>10000 
ORDER BY sum(salary) DESC;













---- SCOTT
--문제1) emp테이블의 업무(job)을 첫글자는 대문자 나머지는 소문자로 출력하시오.
SELECT 
job, INITCAP(job)
FROM emp;

--문제2) emp테이블에서 사원이름 중 A가 포함된 사원이름을 구하고 그 이름 중 앞에서 3자만 추출하여 출력
SELECT
ename, SUBSTR(ename,1,3)
FROM emp
WHERE ename LIKE '%A%';

--문제3) 이름의 세번째 문자가 A인 모든 사원의 이름을 표시하시오.
SELECT
    ename
FROM emp
WHERE SUBSTR(ename, 3,1) = 'A';

--문제4) 이름이 J,A 또는 M으로 시작하는 모든 사원의 이름 (첫 글자는 대문자로, 나머지 글자는 소문자로 표시) 및 이름의 길이를 표시하시오.(열 레이블은 name과 length로 표시)   
SELECT
    ename
FROM emp
WHERE SUBSTR(ename, 3,1) = 'A';

--문제5) 이름의 글자수가 6자 이상인 사원의 이름을 소문자로 이름만 출력하시오
SELECT
    ename, LOWER(ename)
FROM emp
WHERE LENGTH(ename) >=6;

--문제6) 이름의 글자수가 6자 이상인 사람의 이름을 앞에서 3자만 구하여 소문자로 출력하시오.
SELECT 
ename, SUBSTR(ename,1, 3), LOWER(SUBSTR(ename,1, 3))
FROM emp
WHERE LENGTH(ename)>=6;

--문제7) 모든 사원의 이름과 급여를 표시하시오. 급여는 15자 길이로 왼쪽에 $기호가 채워진 형식으로 표기하고 열레이블을 SALARY로 지정하시오.
SELECT ename, sal, LPAD(sal, 15, '$') AS salary
FROM emp;



-- JOIN 문제
--문제27) EMPLOYEES 테이블과 DEPARTMENTS 테이블을 Cartesian Product(모든 가능한 행들의 Join)하여 사원번호,이름,업무,부서번호,부서명, 근무지를 출력하여라. 
                                                                                                                                                        -- emp  emp  emp emp      departments  departments의 locations테이블
SELECT * FROM employees;

SELECT
e.employee_id, e.last_name, e.job_id, e.department_id,
d.department_id, d.location_id, l.location_id,  l.city
FROM employees e, departments d, locations l
WHERE e.department_id = d.department_id
        AND d.location_id = l.location_id;

--문제28) EMPLOYEES 테이블에서 사원번호,이름,업무, 
        --    EMPLOYEES 테이블의 부서번호, DEPARTMENTS 테이블의 부서번호,부서명,근무지를 출력하여라. 
SELECT
    e.employee_id, e.last_name, e.job_id, d.department_name, l.city --부서명, 근무지
FROM employees e, departments d, locations l
WHERE e.department_id=d.department_id
AND d.location_id = l.location_id;

--문제29) Alexander Hunold 의 부서명을 출력하라. 
select * from employees;

SELECT 
e.first_name, e.last_name, d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id
AND first_name = 'Alexander' AND last_name = 'Hunold';

--문제30) 세일즈 부서에서 근무하고 있는 사람들을 출력하라. 
SELECT
d.department_name , e. first_name, e.last_name
FROM departments d, employees e
WHERE d.department_id = e.department_id
AND
department_name = 'Sales';

--문제31) EMPLOYEES 테이블과 DEPARTMENTS 테이블의 부서번호를 조인하고 SA_MAN 사원만의 사원번호,이름,급여,부서명,근무지를 출력하라. (Alias를 사용) (AS "이름, 급여 등등")
select * from employees;
select 
e.employee_id, first_name, last_name, e.salary, d.department_name, l.city
FROM employees e, departments d, locations l
WHERE e.department_id = d.department_id
AND d.location_id = l.location_id
AND JOB_ID = 'SA_MAN';

--문제32) EMPLOYEES 테이블과 DEPARTMENTS 테이블에서
--    DEPARTMENTS 테 이블에 있는 모든 자료를
--    사원번호,이름,업무, 
--    EMPLOYEES 테이블의 부서번 호, 
--    DEPARTMENTS 테이블의 부서번호,부서명,근무지를 출력하여라 (Outer Join)   ------------선생님꺼랑 비교하기------------선생님꺼랑 비교하기------------선생님꺼랑 비교하기------------선생님꺼랑 비교하기------------선생님꺼랑 비교하기------------선생님꺼랑 비교하기------------선생님꺼랑 비교하기------------선생님꺼랑 비교하기------------선생님꺼랑 비교하기------------선생님꺼랑 비교하기
SELECT * FROM departments;
SELECT 
d.department_id, 
 e.employee_id, e.first_name, e.last_name,
 d.department_id, d.department_name, d.location_id
FROM employees e, departments d, locations l
WHERE e.department_id = d.department_id(+)
AND  l.location_id(+) = d.location_id;


SELECT 
d.department_id, 
 e.employee_id, e.first_name, e.last_name,
 d.department_id, d.department_name, d.location_id
FROM departments d, employees e 
WHERE d.department_id = e.department_id(+);





--문제33) EMPLOYEES 테이블에서 Self join하여 관리자(매니저)를 출력하여라. 
SELECT 
    a.employee_id, a.first_name, a.last_name, a.manager_id, b.first_name, b.last_name
FROM employees a, employees b
WHERE a.manager_id = b.employee_id;

--문제34) EMPLOYEES 테이블에서 left join하여 관리자(매니저)를 출력하고 매니저 아이디가 없는 사람은 배제하고 하향식으로 하며, 급여는 역순으로 출력하라. 

--문제35) EMPLOYEES 테이블에서 right join하여 관리자(매니저)가 108번 상향식으로 급여는 역순으로 출력하라.
