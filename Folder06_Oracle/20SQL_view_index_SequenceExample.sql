

--문제1) EMPLOYEES 테이블에서 20번 부서의 세부 사항을 포함하는 EMP_20 VIEW를 생성 하라 
    SELECT * FROM employees;
    
    CREATE VIEW EMP_20(
    employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)
    AS SELECT *
     FROM employees WHERE department_id=20;
     
     SELECT * FROM emp_20;
    

--문제2) EMPLOYEES 테이블에서 30번 부서만
--                                                    EMPLOYEE_ID 를 emp_no 로
--                                                    LAST_NAME을 name으로
--                                                    SALARY를 sal로 바꾸어 
--                                                    EMP_30 VIEW를 생성하라. 

CREATE VIEW EMP_30(
    employee_no, first_name, name, email, phone_number, hire_date, job_id, sal, commission_pct, manager_id, department_id)
    AS SELECT *
     FROM employees WHERE department_id=30;
          SELECT * FROM emp_30;
    
     
--문제3) 부서별로 부서명,최소 급여,최대 급여,부서의 평균 급여를 포함하는 DEPT_SUM VIEW을 생성하여라. 
CREATE VIEW DEPT_SUM (
                                            "부서명", "급여최저", "급여최대", "급여평균")
    AS(SELECT d.department_name, "급여최저", "급여최대", "급여평균"
        FROM (
                    SELECT department_id, MIN(salary) AS "급여최저", MAX(salary) AS "급여최대", TRUNC(AVG(salary))AS "급여평균" 
                    FROM employees 
                    GROUP BY department_id
                    ) e, departments d
        WHERE e.department_id = d.department_id
        GROUP BY d.department_name);
        
        
        SELECT d.department_name       --, 
        FROM (SELECT department_id, MIN(salary), MAX(salary), TRUNC(AVG(salary)) FROM employees GROUP BY department_id) e, departments d
        WHERE e.department_id = d.department_id
        GROUP BY d.department_name;
        
        select * from departments
        
     
SELECT * FROM DEPT_SUM
ORDER BY "부서명" ASC;
          



--문제4) 앞에서 생성한 EMP_20,EMP_30 VIEW을 삭제하여라. 
DROP VIEW EMP_20;
DROP VIEW EMP_30;






--1. 초기값1부터 최대값999,999까지 1씩 증가하는 TEST_SEQ SEQUENCE를 생성하여라.
CREATE SEQUENCE TEST_SEQ
INCREMENT BY 1      --1씩 증하하도록한다. 
START WITH 10       -- 시작 수
--MAXVALUE 1000       --최대값, 생략가능.
MINVALUE 1;             --최소값


-- 2. 1번에서 작성한 SRQUENCE의 현재 값을 조회하여라.
SELECT TEST_SEQ.CURRVAL
FROM DUAL;


-- 3. CURRVAL과 NEXTVAL을 설명하여라.
-- NEXTVAL  --진행 값
SELECT TEST_SEQ.NEXTVAL
FROM DUAL;


-- 4. 1번에서 생성한 SRQUENCE를 삭제하여라.
DROP sequence TEST_SEQ;




