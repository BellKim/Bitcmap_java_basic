--함수
--매개변수, return값
--select

CREATE OR REPLACE FUNCTION func(p_val IN NUMBER)
    RETURN NUMBER

IS 
    v_val NUMBER;
BEGIN
        
        v_val := p_val * 2;
        RETURN v_val;
        
END;
/


SELECT func(24)
FROM dual;


----------------------------------------------
CREATE OR REPLACE FUNCTION tax(p_value IN NUMBER) RETURN NUMBER
IS
BEGIN   
    RETURN (p_value * 0.15);
END;
/

SELECT tax(1000)
FROM DUAL;


VAR tax_val NUMBER;
EXECUTE tax_val := tax(10000);
PRINT tax_val;

-- 급여와 커미션을 합쳐서 세금을 계산하기-- 급여와 커미션을 합쳐서 세금을 계산하기
CREATE OR REPLACE FUNCTION tax2(p_sal IN employees.salary%TYPE,
                                                            p_bonus IN employees.commission_pct%TYPE)
    RETURN NUMBER
    
IS
BEGIN
        RETURN ((p_sal + NVL(p_bonus, 0) * p_sal) * 0.15);
END;
/

SELECT first_name, salary + salary*NVL(commission_pct,0) 실급여,
    tax2(salary, commission_pct) 세금
from employees;




-- 사원번호를 입력하면, 업무명을 취득할 수 잇는 함수 
CREATE OR REPLACE FUNCTION getJobName(p_empno IN employees.employee_id%TYPE)
    RETURN VARCHAR2

IS
    v_jobname jobs.job_title%TYPE;
BEGIN
        SELECT j.job_title INTO v_jobname
        FROM employees e, jobs j
        WHERE e.job_id=j.job_id
        AND e.employee_id = p_empno;
        
        RETURN v_jobname;
END;
/

SELECT getjobname(100)
FROM dual;

select *
FROM employees;