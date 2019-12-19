CREATE TABLE TB_TEST02(
KEY_01 VARCHAR2(10),
KEY_02 VARCHAR2(10),
col_01 VARCHAR2(10),
col_02 VARCHAR2(10),
CONSTRAINT PK_TEST_02 PRIMARY KEY(KEY_01, KEY_02)
);
-- PL 사용 (ON / OFF)
SET SERVEROUTPUT ON
SET SERVEROUTPUT OFF


--변수선언 및 내용출력
DECLARE 
    COUNTER INTEGER;
BEGIN
    COUNTER :=1;
    COUNTER := COUNTER+1;
    
    IF counter IS NULL THEN
        DBMS_OUTPUT.PUT_LINE('RESULT : COUNTER IS NULL');
    ELSE
        DBMS_OUTPUT.PUT_LINE('RESULT : COUNTER IS NULL');
    END IF;
END;
/

--반복문 
DECLARE 
    COUNTER INTEGER;
    i INTEGER;
    BEGIN
    FOR i IN 1..9 LOOP
        DBMS_OUTPUT.PUT_LINE('i = '||i);
        counter := i*2;
        DBMS_OUTPUT.PUT_LINE('i * 2= '||i);
    END LOOP;
END;
/

--CASE
DECLARE
    v_name VARCHAR2(10) := 'LEE';
    v_case NUMBER := 1;
BEGIN
    CASE 
        WHEN MOD(v_case, 2) = 0 THEN
            GOTO test1;
        WHEN MOD(v_case, 2) = 1 THEN
            GOTO  test2;
        ELSE
            GOTO err;
    END CASE;
    
<<test1>>
    DBMS_OUTPUT.PUT_LINE(v_name|| 'is woman');
    GOTO sub_end;
<<test2>>
    DBMS_OUTPUT.PUT_LINE(v_name|| 'is woman');
    GOTO sub_end;
<<err>>
    DBMS_OUTPUT.PUT_LINE('err');
    GOTO sub_end;
<<sub_end>>
    DBMS_OUTPUT.PUT_LINE('EXIT');   
END;
/

-- 예 외 처 리  부 
DECLARE
        --선언부
        counter INTEGER;
BEGIN
        --실행부
        counter :=10;
        counter := counter/0;
        --예외처리부
EXCEPTION WHEN OTHERS THEN
    dbms_output.put_line('예외가 발생했습니다.  ');
END;
/


-- 배열 (array)
-- array: variable array

DECLARE
    --여기서 배열은 0번시작이 아닌 1번시작이 처음이다. 
    TYPE varray_test IS VARRAY(3) OF INTEGER;      --int varray_test[] = new int [3];
    var varray_test;
BEGIN
        var := varray_test(111,222,333);
        dbms_output.put_line('var(1) = ' || var(1));
END;
/

ACCEPT p_deptno PROMPT '부서번호르 입력하시오 (급여의 합)'
DECLARE
    v_salTotal NUMBER;
BEGIN
    SELECT SUM(salary) INTO v_salTotal
    FROM employees
    WHERE department_id = &p_deptno;
    dbms_output.put_line(&p_deptno || '번 부서의 급여의 합은' ||TO_CHAR(v_saltotal, '$999,999,999'));
END;
/


ACCEPT p_empno PROMPT '사원번호를 입력하시오 (+1000)'
DECLARE
    v_sal EMPLOYEES.salary%type :=1000;
    v_salTotal NUMBER;
BEGIN

    SELECT salary INTO v_salTotal
    FROM employees
    WHERE employee_id=&p_empno;
    DBMS_OUTPUT.PUT_LINE(&p_empno || '번 + 1000후의 사원의 급여 = '|| v_salTotal);
    
    UPDATE employees
    SET salary = salary+v_sal
    WHERE employee_id = &p_empno;
    
    SELECT salary INTO  v_salTotal
    FROM employees
    WHERE employee_id = &p_empno;
    DBMS_OUTPUT.PUT_LINE(&p_empno || '번 + 1000후의 사원의 급여 = '|| v_salTotal);
END;
/
ROLLBACK;
select * FROM employees;
------------------------------------------------------------------------------------------------------

------------------------------------------------------------------------------------------------------

DECLARE
    --V_empno employee.employee_id%type;
    v_emp employees%ROWTYPE;
BEGIN
    SELECT employee_id, first_name
            INTO v_emp.employee_id, v_emp.first_name
    FROM employees
    WHERE employee_id = 100;
    
    DBMS_OUTPUT.PUT_LINE('값 ID: ' || v_emp.employee_id);
    DBMS_OUTPUT.PUT_LINE('값 v_emp.first_name: ' || v_emp.first_name);
END;
/

-- 이름, 급여, 부서번호
-- 사원 추가 -> employees  IT_PROG 이름@naver.com

-- 부서번호가 30일 경우 -> 입력받은 급여에 20%인상해서 
-- 부서번호가 60일 경우 -> 입력받은 급여에 10%인상해서 

-- 입력 처리
ACCEPT p_name PROMPT '이 름:'
ACCEPT p_sal PROMPT '급 여:'
ACCEPT p_deptno PROMPT '부서번호:'

DECLARE
    v_name employees.last_name%TYPE := '&p_name';   -- 문자열
    v_sal employees.salary%TYPE := &p_sal;
    v_deptno employees.department_id%TYPE := &p_deptno;
BEGIN
    DBMS_OUTPUT.PUT_LINE('v_name:' || v_name);
    DBMS_OUTPUT.PUT_LINE('v_sal:' || v_sal);
    DBMS_OUTPUT.PUT_LINE('v_deptno:' || v_deptno);
    
    IF v_deptno = 30 THEN
        v_sal := v_sal * 1.2;
    ELSIF v_deptno = 60 THEN
        v_sal := v_sal * 1.1;
    END IF;

    INSERT INTO employees(employee_id, last_name, salary, 
                            hire_date, department_id, job_id, email)
    VALUES(employees_seq.nextval, v_name, v_sal,
                            sysdate, 30, 'IT_PROG', v_name || '@naver.com');
END;
/

SELECT
    *
FROM employees
WHERE last_name = '일';




