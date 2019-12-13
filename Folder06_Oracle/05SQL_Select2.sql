--      where절  == if == 조건절

/*
    표현식
    비교연산자 ( >, < >=, <=, =, !=)
    NULL, =NULL, IS NULL, IS NOT NULL
    ( ), NOT, AND, OR( || )
    
    SELECT 
    FROM 
    WHERE
    


*/

--FIRST_NAME == JULIA

SELECT first_name, last_name, salary
FROM employees
WHERE first_name = 'Julia'; 
-- name 에는 대소문자를 맞춰야한다.(아스키코드값으로 비교를 하기 때문에)

SELECT * FROM employees;
--급여가 $9000이상인 사람.
SELECT first_name, salary
FROM employees
WHERE salary >= 9000;


-- 이름이 shanta 보다 큰 이름
SELECT 
first_name
FROM employees
WHERE first_name >= 'Shanta';
--shanta 문자열의 사전순보다 더 나중순서들을 비교한다. 

SELECT
    first_name, salary
FROM employees
WHERE first_name >='A';


SELECT first_name, salary
FROM employees
WHERE manager_id = '' ;                 --null이 없다면을 다음과같이 표기하면 안됨.


SELECT first_name, salary, manager_id
FROM employees
WHERE manager_id IS NULL ;

SELECT first_name, salary, manager_id
FROM employees
WHERE manager_id IS NOT NULL ;

--AND
SELECT
    first_name
FROM employees
WHERE first_name = 'Shanta'
AND first_name = 'Jhon';


--OR
SELECT
    *
FROM employees
WHERE first_name = 'Shanta'
OR first_name = 'John';

-- 이름 John, 월급이 5000이상
SELECT 
first_name, salary
FROM employees
WHERE first_name = 'John'
AND salary >=5000;

--2007년 12월 31일 이후에 입사한 사원을 출력하라. 
SELECT 
first_name,  hire_date
FROM employees
WHERE hire_date > '07/12/31';

--연도의 두자리만 출력하는윗방식
--연도의 4자리 모두 출력하는 방식
SELECT 
first_name,  hire_date
FROM employees
WHERE hire_date > TO_DATE('20071231', 'YYYYMMDD');


-- ALL(AND), ANY(OR)

-- ALL(AND)
SELECT
*
FROM employees
WHERE first_name = ALL('Julia', 'John');

SELECT
*
FROM employees
WHERE first_name = ANY('Julia', 'John');

-- 급여가ㅏ 8000, 3200, 6000 일떄
-- ANY(OR)
SELECT
*
FROM employees
WHERE salary= ANY(8000, 3200, 6000);


-- IN,,    NOT IN
--IN      해당 값에 있는 사람들만 출력. 
SELECT 
*
FROM employees
WHERE salary IN(8000, 3200, 6000);

SELECT 
*
FROM employees
WHERE salary NOT IN(8000, 3200, 6000);

SELECT 
first_name, salary
FROM employees
WHERE first_name IN('Julia', 'John');


--exists

SELECT
first_name, job_id
FROM employees e
WHERE EXISTS (
                        SELECT 1
                        FROM dual
                        WHERE e.job_id = 'IT_PROG'
                        );
                        --SELECT 1 은 조건충족이 되었을때 1을 내보내준다.
                        
-- BETWEEN 범위 연산자

-- salary >= 3200 AND salary <= 9000
-- salary BETWEEN 3200 AND 9000
--비트윈 -> 두 수의 사이값,   NOT BETWEEN 두 수의 사이값 외의 범위.

SELECT
    first_name, salary
FROM employees
WHERE salary BETWEEN 3200 AND 9000;

SELECT
    first_name, salary
FROM employees
WHERE salary<3200 OR salary >9000;


SELECT
    first_name, salary
FROM employees
WHERE salary NOT BETWEEN 3200 AND 9000;



--LIKE
SELECT
first_name, last_name
FROM employees
WHERE first_name LIKE 'G_ra_d';
--LIKE  는 첫글자와 끝글자 사이에 _ 를 써서 문자를 포함한 단어를 검색해서 리턴할 수 있다.( _는 한글자)

SELECT
first_name, last_name
FROM employees
WHERE first_name LIKE 'K%y';    --k 와 y 사이의 글자수의 제한이 없다. 

SELECT
first_name, last_name
FROM employees
WHERE first_name LIKE '%Al%';

SELECT
first_name, last_name
FROM employees
WHERE first_name LIKE '%e%';    --  e가 있는 아무단어

SELECT
first_name, hire_date
FROM employees
WHERE hire_date LIKE '06/01%';      -- 2006년 1월에 입사한사람이 다나옴.






select * FROM employees;






