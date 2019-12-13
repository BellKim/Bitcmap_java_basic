--ORDER BY : 정렬
--SCOTT account. conn

--asc 오름차순 desc 내림차순
SELECT *
FROM emp
ORDER BY sal ASC;
--내림차
SELECT*
FROM emp
ORDER BY sal desc;

SELECT*
FROM emp
ORDER BY hiredate ASC;

--ALIAS
SELECT empno, ename, sal*12 AS annsal
FROM emp
ORDER BY annsal ASC;

SELECT *
FROM emp
ORDER BY comm NULLS FIRST;

--null 우선 표기.
SELECT * FROM emp 
ORDER BY comm NULLS FIRST;

SELECT * FROM emp 
ORDER BY comm NULLS LAST;


--hr
SELECT employee_id, job_id
FROM employees
ORDER BY job_id ASC, salary DESC;
--잡아이디는 오름, salary 내림차순으로

--문자열을 합하는 기능
SELECT first_name || ' ' || last_name AS "dd"
FROM employees;


SELECT concat(first_name, last_name)
FROM employees;


--month_between :  두 날짜간의 월수(월간격)
SELECT MONTHS_BETWEEN('2019-12-13','2020-05-04')
FROM dual;
---4.709 .... 인데 나중기간이 앞으로가야한다.

SELECT MONTHS_BETWEEN('2020-05-04','2019-12-13')
FROM dual;

--add_months : 특정 날짜 월 정수에 더한 후 해당 날짜를 반환.
SELECT add_months('2019-12-13',3)
FROM DUAL;

--날짜 정보에서 특정한 연도, 월, 일, 시, 분, 초 
SELECT 
            EXTRACT(year from sysdate) as "연도",
            EXTRACT(month from sysdate) as "월",
            EXTRACT(day from sysdate) as "일"
FROM dual;
---------------------------------------------------------------- 이거 안된다아아아아아ㅏ아아앙ㄹ나ㅓㅁㄴ;이럼ㄴ;ㅣㅏㅑ매ㅣ;날;ㅣㅐㅁ냐ㅓㅎㅁ;ㅣ냐옺미;놓마ㅣ;너오
SELECT EXTRACT(year from to_date('191001', 'YYMMDD')) as "연도",
            EXTRACT(month from to_date('19/10/01')) as "월",
            EXTRACT(day from sysdate) as "일"
FROM dual;
---------------------------------------------------------------- 이거 안된다아아아아아ㅏ아아앙ㄹ나ㅓㅁㄴ;이럼ㄴ;ㅣㅏㅑ매ㅣ;날;ㅣㅐㅁ냐ㅓㅎㅁ;ㅣ냐옺미;놓마ㅣ;너오

--시, 분, 초

SELECT 
        EXTRACT(hour FROM CAST(sysdate AS TIMESTAMP)) as 시,
        EXTRACT(minute FROM CAST(sysdate AS TIMESTAMP)) as 분,
        EXTRACT(second FROM CAST(sysdate AS TIMESTAMP)) as 초
FROM dual;
--case내의 timestamp as 는 다른것


--그룹으로 묶는기능., distinct 중복제거
SELECT DISTINCT department_id , employee_id
FROM employees
ORDER BY department_id ASC;

select * FROM employees;

SELECT department_id
FROM employees
GROUP BY department_id
ORDER BY department_id asc;
--group by  사용시 묶은것만 사용할 수 있다. (규칙이다.) 여러개를 표현하고자 할때는 ORDER BY 로 진행하자. 
SELECT department_id
FROM employees
GROUP BY department_id
ORDER BY department_id asc;


/*
    GROUP 함수
    COUNT
    SUM
    AVG
    MAX
    MIN
    
*/



--다시볼것 --다시볼것 --다시볼것 --다시볼것 --다시볼것 --다시볼것 --다시볼것 --다시볼것 --다시볼것 --다시볼것 --다시볼것 
SELECT count(salary), count(*), sum(salary), AVG(salary), SUM(salary) / count(*)
FROM employees
where job_id = 'IT_PROG';

select * FROM employees;

SELECT count(salary), count(*), sum(salary), AVG(salary), 
SUM(salary) / count(*) ,job_id
FROM employees
GROUP BY job_id;
--다시볼것 --다시볼것 --다시볼것 --다시볼것 --다시볼것 --다시볼것 --다시볼것 --다시볼것 --다시볼것 --다시볼것 --다시볼것 

/*
숫자일때
NVL(대상이 되는 컬럼, 0)           NUMBER
대상이 되는 컬럼이   != NULL,  -> 대상이 되는컬럼으로 리턴
대상이 되는 컬럼이   == NULL,  -> 0

문자일때
NVL(대상이 되는 컬럼, '없음')        VARCHAR2
대상이 되는 컬럼이   != NULL,  -> 대상이 되는컬럼으로 리턴
대상이 되는 컬럼이   == NULL,  -> '없음'

NVL2() 
NVL2(대상이 되는 컬럼, 1, 0) 
대상이 되는 컬럼 != NULL -> 1
대상이 되는 컬럼 == NULL -> 0
*/

SELECT first_name, NVL(commission_pct, 0)
FROM employees;

SELECT first_name, NVL2(commission_pct,'값있다', '값없다')
from employees;

SELECT department_id, SUM(salary), MAX(salary), trunc(AVG(salary))
FROM employees
GROUP BY department_id;

--HAVING <-- GROUP BY와 같이 사용

SELECT job_id, SUM(salary)
FROM employees
GROUP by job_id
HAVING SUM(salary) >=50000
ORDER BY SUM(salary) DESC;

-- 급여가 5000 이상 받는 사원만 합계를 내서 업무로 그룹화 하여  급여합계가 20000 초과하는 업무명을 구해라
-- 5000이상 연봉자들의 부서별 카운트를 내고, 그중에 급여 합계가 20000 초과하는 부서의 카운트만을 산출해 내어라.
/*
-- 급여가 5000 이상 받는 사원만 합계를 내서 
업무로 그룹화 하여 
급여합계가 20000 
초과하는 업무명을 구해라
*/

select * from employees;



SELECT job_id, count(*)        --, sum(salary), round(avg(salary))
FROM employees
WHERE salary > 5000
GROUP BY job_id
HAVING SUM(salary) > 20000;

SELECT 
job_id, count(*)
FROM employees
WHERE salary > 5000
GROUP BY job_id
HAVING SUM(salary)>20000;



--문제1) EMPLOYEES 테이블에서 입사일자 순으로 정렬하여 사원번호, 이름, 업 무, 급여, 입사일자,부서번호를 출력하라. 
SELECT * 
FROM employees
ORDER BY hire_date asc;

--문제2) EMPLOYEES 테이블에서 가장 최근에 입사한 순으로 사원번호, 이름, 업무, 급여, 입사일자,부서번호를 출력하라. 
SELECT * 
FROM employees
ORDER BY hire_date DESC;


--문제3) EMPLOYEES 테이블에서 부서번호로 정렬한 후 부서번호가 같을 경우 급여가 많은 순으로 정렬하여 사원번호, 성명, 업무, 부서번호, 급여를 출력하 여라. 
SELECT employee_id, first_name, job_id, department_id, salary
FROM employees
ORDER BY department_id ASC, salary DESC;

--문제4) EMPLOYEES 테이블에서 첫번째 정렬은 부서번호로 두번째 정렬은 업무로 세번째 정렬은 급여가 많은 순으로 정렬하여 사원번호, 성명, 입사일자, 부서번호, 업무, 급여를 출력하여라. 
SELECT employee_id, first_name, hire_date, department_id, job_id, salary
FROM employees
ORDER BY department_id asc, job_id ASC, salary DESC;


--문제1) 부서별로 담당하는 업무를 한번씩 출력하여라. 

SELECT DISTINCT job_id
FROM employees
GROUP BY job_id;













SELECT * FROM emp;