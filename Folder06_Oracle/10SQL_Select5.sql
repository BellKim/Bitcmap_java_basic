/*
    sub query
    query 안의 query
    
    한개의 행(row)  에서 결과값이 반환이 되는query. 
    
    SELECT      단일 ROW 단일 COLUMN 나오는 데이터는 한개, 컬럼도 한개 여아한다.                                 SELECT FIRST_NAME, SALARY FROM EMP
    FROM        다중 ROW 호출가능, 다중COLUMN 가능. 
    WHERE       다중ROW, 다중 COLUMN 가능. (제일 많이 사용한다.)    
    
    SELECT EMPLOYEE_ID, (SELECT FITST_NAME, LAST_NAME FROM EMPLOYEES)       --다중 컬럼 사용 x
    
    
    SELECT EMPLOYEE_ID, (SELECT FITST_NAME FROM EMPLOYEES)                          --다중 row 사용x 
   

*/

SELECT 
    employee_id, first_name, 
        (SELECT salary FROM employees)
    FROM employees;
    -- 오류. 
--    ORA-01427: single-row subquery returns more than one row
--01427. 00000 -  "single-row subquery returns more than one row"
    
    
    --다중컬럼, 다중로우 안됨. 무조건 하나만 가느아다.
    SELECT 
    employee_id, first_name, 
        (SELECT salary FROM employees WHERE employee_id = 100),
        (SELECT SUM(salary) FROM employees)
    FROM employees;
    
    
--FROM 
SELECT employee_id, first_name, department_id
FROM (SELECT employee_id, first_name, department_id
            FROM employees
            WHERE department_id = 20);
--where 로만으로도 사용가능하지만 다중from 으로도 가능할 수 잇다. 


--부서번호가 20번, 급여가 6000불 이상의 사원을 구하라. 
SELECT
    e.employee_id, e.salary
FROM ( SELECT  employee_id, salary
            FROM employees 
            WHERE department_id = 20) e
WHERE salary>6000;

SELECT
    employee_id
FROM ( SELECT  employees.employee_id, employees.salary
            FROM employees
            WHERE department_id = 20)
WHERE salary>6000;

SELECT a.employee_id, a.first_name, 
            a. job_id, b.job_id,
            b."급여합계", b."인원수"
FROM employees a, (SELECT job_id, sum(salary) as "급여합계", COUNT(*) as "인원수"
                                FROM employees
                                GROUP BY job_id) b
WHERE a.job_id = b.job_id;

--WHERE 절 사용

SELECT
* 
FROM employees
WHERE salary > ( SELECT AVG(salary)
                        FROM employees);        -- 6461.831.....

SELECT first_name, job_id
FROM employees
WHERE job_id IN(
                            SELECT job_id
                            FROM employees
                            WHERE job_id = 'IT_PROG');


SELECT first_name, job_id, department_id
FROM employees
WHERE job_id IN(
                            SELECT job_id
                            FROM employees
                            WHERE department_id = 90);
                            

-- 부서별로 가장 급여를 적게 받는 사원과 같은 급여를 받는사원?
SELECT * FROM employees ORDER BY salary ;

--서브쿼리
SELECT first_name, salary, department_id
FROM employees
WHERE salary IN(
                SELECT MIN(salary)
                FROM employees
                GROUP BY department_id
                ); 

--부서별 가장 급여를 적게 받는 사원의 정보
SELECT department_id, first_name, salary
FROM employees 
WHERE (salary, department_id) IN (select MIN(salary), department_id
                                                        FROM employees
                                                        GROUP BY department_id)
ORDER BY department_id ASC;




                            
                            





            
    
    
    
    
    
    
    
    
    
    