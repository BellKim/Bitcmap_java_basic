/*
join 의 정의 

두개 이상의 테이블을 연결하여 데이터를 검색하는 방법이다.

보통 2개이상의 행(row) 들의 공통된 값(Primary key(기본키),  Forign key(외래키) 값을 사용해서 조인한다. 

primary key (기본키) : 테이블에서 중복이 되지 않는 키
Forign key(외래키) : 다른 테이블에서 primary key, unique 가능성이 크다. 

inner join  *****
cross join X 
outer join 
left join       ***
rigth join      ***
self join     *****

*/

-- inner join

--Ansi 문법 (SQL)
--ORACLE문법 총 2가지가 있다. 살펴보자.

--Ansi 문법 (SQL)
SELECT employee_id, first_name,
        e.department_id, d.department_id,
        d.department_name
FROM employees e INNER JOIN departments d
ON e.department_id = d.department_id;


--ORACLE문법 살펴보기
SELECT employee_id, first_name,
        e.department_id, d.department_id,
        d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;


SELECT employee_id, first_name,
        e.department_id, d.department_id,
        d.department_name
FROM employees e, departments d
WHERE e.department_id = d.department_id;


--Shanta의 업무명을 알고싶다. 
SELECT
    e.employee_id, e.first_name,
    e.job_id, j.job_id,
    j.job_title
FROM employees e, jobs j
WHERE e.job_id = j.job_id
    AND e.first_name = 'Shanta';


    
-- 147번 사원의 부서명과 업무명을 구해라.
SELECT
    e.employee_id, e.first_name,
    e.department_id, d.department_id,
    e.job_id, j.job_id,
    d.department_name, j.job_title
FROM employees e, departments d, jobs j
WHERE e.department_id = d.department_id
    and  e.job_id = j.job_id
    and e.employee_id = 147;

--많이 중요하진 않지만 일단 ㅇ라아두자.
--CrossJoin

--ANSI문법
SELECT
    e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e CROSS JOIN departments d;
/*
1       a
2       b
3       c
1   a 
1   b
1   c
2   a
2   b
2   c
3   a
3   b
3   c
*/

--ORACLE 문법 crossjoin
SELECT
    e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e,departments d;


--FULL OUTER JOIN
SELECT 
e.employee_id, e.first_name,
e.department_id, d.department_id,
d.department_name
FROM employees e FULL OUTER JOIN departments d
ON e.department_id = d.department_id;


SELECT 
e.employee_id, e.first_name,
e.department_id, d.department_id,
d.department_name
FROM employees e FULL OUTER JOIN departments d
    ON e.department_id = d.department_id
WHERE e.department_id IS NULL OR d.department_id IS NULL; --조인이 안된 사람들만 산출해낸다.



--OUTER JOIN
        --left outer join,  right outer join

--ANSI

SELECT
    e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
FROM employees e LEFT OUTER JOIN departments d
        ON e.department_id = d.department_id;
        
--ORACLE
SELECT
 e.employee_id, e.first_name,
    e.department_id, d.department_id,
    d.department_name
 FROM employees e, departments d
 WHERE e.department_id = d.department_id(+)    --기호가 있는데서 없는데로 가는것. 
  AND e.department_id IS NULL;



-- 매우 중요한 SELF JOIN
--동일한 테이블을 조인시키는것이다. 
--사원의 매니저를 찾는 방법은? 

SELECT
    a.employee_id, a.first_name,
    a.manager_id, a.employee_id,
    b.first_name
FROM employees a, employees b
WHERE a.manager_id = b.employee_id;

--계층형 구조 오름, 내림.
SELECT
    a.employee_id, a.first_name AS "사원",
    a.manager_id as "사원의 상사", b.employee_id,
    b.first_name AS "상사"
FROM employees a, employees b
WHERE a.manager_id = b.employee_id(+)
CONNECT BY PRIOR a.manager_id  = a.employee_id; --상향식 표현

SELECT
    a.employee_id, a.first_name AS "사원",
    a.manager_id as "사원의 상사", b.employee_id,
    b.first_name AS "상사"
FROM employees a, employees b
WHERE a.manager_id = b.employee_id(+)
CONNECT BY a.manager_id  = PRIOR a.employee_id; --하향식 표현




