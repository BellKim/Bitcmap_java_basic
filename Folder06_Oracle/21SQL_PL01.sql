/*
    PL/SQL      Procedural Extension to Structured Language
    
    Procedure == 처리자
    
    sql을 확장한 순차적인 언어 -> Procedure, function, trigger
    
    + script 를 이용해서 동작시킴. 
    
    Script 구조
    1. 선언부 : 사용할 변수, 상수를 선언, 초기화
    2. 실행부 : 실제 처리할 QUERY 부분이나 제어문을 활용한다. 
    3. 예외처리부 : 각종 오류를 처리하는 부분. 
    
SET SERVEROUTPUT OFF//ON으로 동작을 켜고 끌 수 있다.     
*/
            --
SET SERVEROUTPUT ON
BEGIN
    -- 실행부
    dbms_output.put_line('HELLO PL');
END;
/
SET SERVEROUTPUT OFF

/*
--------기본구조 

DECLARE
        --선언부
BEGIN
        --실행부
        
        --예외처리부
END;
/


*/

DECLARE
        --선언부
        message VARCHAR2(10);
BEGIN
        --실행부
        message := 'hello PL';
        DBMS_OUTPUT.PUT_LINE('message = ' || message );
        --예외처리부
END;
/



DECLARE
    counter INTEGER;
BEGIN
    counter :=1;
    counter := counter + 1;
    
    IF counter IS NULL THEN 
        DBMS_OUTPUT.PUT_LINE('RESULT : COUNTER IS NULL');
    ELSE 
         DBMS_OUTPUT.PUT_LINE('RESULT : COUNTER IS NOT NdULL');
    END IF;
    
END;
/



DECLARE
    counter INTEGER;
    i INTEGER;
BEGIN
    FOR i IN 1..9 LOOP
    
            DBMS_OUTPUT.PUT_LINE('i = ' || i);
            counter := i*2;
            DBMS_OUTPUT.PUT_LINE('2 * ' || i || ' = ' || counter);
        
        END LOOP;

END;
/



DECLARE
        --선언부
        v_count NUMBER := 0;
        v_total NUMBER := 0;
BEGIN
        --실행부
        LOOP
                EXIT WHEN v_count = 10;
                
                v_count := v_count +1;
                v_total := v_total + v_count;
                DBMS_OUTPUT.PUT_LINE('v_count = ' || v_count );
        
        END LOOP;
        DBMS_OUTPUT.PUT_LINE('v_count = ' || v_count );
END;
/


DECLARE
        --선언부
        v_count NUMBER := 0;
        v_total NUMBER := 0;
BEGIN
        --실행부
        WHILE v_count < 10
        LOOP
            v_count := v_count + 1;
            v_total := v_total +v_count;
        END LOOP;
        
        DBMS_OUTPUT.PUT_LINE('v_total = ' || v_total );
        DBMS_OUTPUT.PUT_LINE('열공하시오');
        
END;
/


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
    varr varray_test;

BEGIN
        varr := varray_test(111,222,333);
        dbms_output.put_line('varr(1) = ' || varr(1));
        
END;
/

ACCEPT p_deptno PROMPT '부서번호르 입력하시오 (급여의 합)'
DECLARE
    v_salTotal NUMBER;
BEGIN
    SELECT SUM(salary) INTO v_salTotal
    FROM employees
    WHERE department_id = &p_deptno;
    
    dbms_output.put_line(&p_deptno || '번 부서의 급여의 합은'
                                            ||TO_CHAR(v_saltotal, '$999,999,999'));
END;
/


ACCEPT p_empno PROMPT '사우너번호를 입력하시오 (+1000)'
DECLARE
    v_sal EMPLOYEES.salary%type :=1000;
    v_salTotal NUMBER;
BEGIN
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



---------------------------------------

--ROWTYPE -->
DECLARE
    -- v_empno employees.employee_id%type;
    v_emp employees%ROWTYPE;     --컬럼의 이름이 자동적으로 변수명이 된다.  v_emp.first_name 
    --임플로이 안에 있는타입을 넣는다
BEGIN

    SELECT employee_id, first_name, last_name, salary
            INTO v_emp.employee_id, v_emp.first_name, v_emp.last_name, v_emp.salary
    FROM employees
    WHERE employee_id = 100;
    
     DBMS_OUTPUT.PUT_LINE('사원번호' || v_emp.employee_id);
     DBMS_OUTPUT.PUT_LINE('사원성' || v_emp.first_name);
     DBMS_OUTPUT.PUT_LINE('사원이름' || v_emp.last_name);
     DBMS_OUTPUT.PUT_LINE('사원임금' || v_emp.salary);
END;
/

-- 이름 급여 부서번호를 입력받아서 
--사원을 추가하고자 한다.  ( employees 테이블, job_id='IT_PROG', email=이름@알아서.해)
-- 부서번호가 30일 경우에는 -> 입력받은 급여에 20% 인상하여 입력
-- 부서번호가 20일 경우에는 -> 입력받은 급여에 10% 인상하여 입력



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



