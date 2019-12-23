/*
    block되어있는 처리 -> 함수화
    
    매개변수, return값
    
    PROCEDURE - INSERT, DELETE, UPDATE
    
    FUNCTION - SELECT
    
    TRIGGER - UTIL
    

*/

SET SERVEROUTPUT ON

--함수 선언
CREATE OR REPLACE PROCEDURE myProc(inNum IN NUMBER, outNum OUT NUMBER)
IS 
    --선언부

BEGIN
    --실행부
    DBMS_OUTPUT.PUT_LINE('inNum 값 = '|| inNum);
    
    outNum := 333;
    --예외처리
    
END;
/


-------------------------------------------------------------------------------
----함수 호출
--VAR val NUMBER;         --int val;
----프로시저 호출
--EXECUTE myProc(111, :val);
--PRINT val;
-------------------------------------------------------------------------------
VAR val NUMBER;        

EXECUTE myProc(111, :val);

PRINT val;


-------------------------------------------------------------------------------
--변수가 없을때는 () 조차 적지 않는다.
--매개변수가 없는경우
CREATE OR REPLACE PROCEDURE helloProc
IS
    msg VARCHAR2(10);
BEGIN
    msg :=' helloProc';
    DBMS_OUTPUT.PUT_LINE(msg || '호출');
END;
/

EXECUTE helloproc;




-------------------------------------------------------------------------------
-------------------------------------------------------------------------------
--departments 테이블에 row 추가하기(행 insert)
INSERT INTO departments(department_id, department_name, location_id) 
VALUES(300, '관리부', 1400);
rollback;

                                                                                                        --.department_id%type 는 해당 테이블의 변수가 입력되도록함
CREATE OR REPLACE PROCEDURE add_dept(p_deptno IN departments.department_id%TYPE,
                                                                    p_deptname IN departments.department_name%TYPE,
                                                                    p_deptloc IN departments.location_id%TYPE)
IS

BEGIN
    INSERT INTO departments(department_id, department_name, location_id) 
    VALUES(p_deptno, p_deptname, p_deptloc);
    --COMMIT;
EXCEPTION WHEN OTHERS THEN
    DBMS_OUTPUT.PUT_LINE('추가에 실패했습니다. ');
    --ROLLBACK;
END;
/

--함수 실행
EXECUTE add_dept(301, '신규부서', 2500);

--확인
SELECT * FROM departments;
rollback;



-- update salary
-- 사원번호를 입력받아서 급여인상 30% 
CREATE OR REPLACE PROCEDURE updateSal(v_empno IN NUMBER)
IS 

BEGIN
    UPDATE employees
    set salary = salary*1.3
    WHERE employee_id = v_empno;
    
    --commit
END;
/

ACCEPT empno PROMPT '사원번호 : '
EXECUTE updatesal(&empno);
select * FROM employees;
rollback;



--사원번호를 입력받았으면 그 사원의 이름, 사원번호, 사원급여도 출력이  되도록 작성하여라. 
CREATE OR REPLACE PROCEDURE emp_info(p_empno IN employees.employee_id%TYPE)
IS 
    v_emp employees%ROWTYPE;
BEGIN
    SELECT first_name, employee_id, salary
        INTO v_emp.first_name, v_emp.employee_id, v_emp.salary
    FROM employees
    WHERE employee_id = p_empno;
    
    DBMS_OUTPUT.PUT_LINE('이름 : ' || v_emp.first_name);
    DBMS_OUTPUT.PUT_LINE('사원번호 : ' || v_emp.employee_id);
    DBMS_OUTPUT.PUT_LINE('급여 : ' || v_emp.salary);
END;
/


execute emp_info(102);



/*
    cursor : 저장 주소 공간 -> pointer
    암시적 커서 : 자동생성 
                    SQL%ROWCOUNT    : ROW의 수 자동생성
                    SQL%FOUND           : ROW의 수가 한개 이상일 경우
                    SQL%NOTFOUND    : ROW의 수가 0일경우
                    
    
    명시적 커서 : 수동생성 
*/

-- 암시적 커서
--CREATE OR REPLACE PROCEDURE implicit_cursor(p_empname IN employees.first_name%TYPE)
--IS 
--    v_sal employees.salary%TYPE;
--    v_update_row NUMBER;        --몇개의 행이 수정되는지 조사하는 부분의 변수.
--BEGIN
--    --검색
--    SELECT salary INTO v_sal
--    FROM employees
--    WHERE first_name = p_empname;
--    
--    --검색한 데이터가 있는경우 
--    IF SQL%FOUND THEN
--        DBMS_OUTPUT.PUT_LINE('검색된 데이터 있습니다');
--    END IF;
--    
--    --수정
--    UPDATE employees
--    SET salary = salary * 1.1
--    WHERE first_name = p_empname;
--
--    --출력
--    v_update_row := SQL%ROWCOUNT;
--    DBMS_OUTPUT.PUT_LINE('급여가 인상된 사원수 : ' || v_update_row);
--
--EXCEPTION WHEN NO_DATA_FOUND THEN
--    DBMS_OUTPUT.PUT_LINE(' 검색된 데이터가 없습니다. ' );
--END;
--/




CREATE OR REPLACE PROCEDURE implicit_cursor(p_empname IN employees.first_name%TYPE)
IS 
    v_sal employees.salary%TYPE;
    v_update_row NUMBER;        
BEGIN

    SELECT salary INTO v_sal
    FROM employees
    WHERE first_name = p_empname;

    IF SQL%FOUND THEN
        DBMS_OUTPUT.PUT_LINE('검색된 데이터 있습니다');
    END IF;

    UPDATE employees
    SET salary = salary * 1.1
    WHERE first_name = p_empname;

    v_update_row := SQL%ROWCOUNT;
    DBMS_OUTPUT.PUT_LINE('급여가 인상된 사원수 : ' || v_update_row);

EXCEPTION WHEN NO_DATA_FOUND THEN
    DBMS_OUTPUT.PUT_LINE(' 검색된 데이터가 없습니다. ' );
END;
/




-- Steeven

EXECUTE implicit_cursor('길동');





--명시적 커서
CREATE OR REPLACE PROCEDURE expCursor_test(v_deptno IN departments.department_id%Type)
IS
    CURSOR dept_avg
    IS
    SELECT d.department_name, COUNT(e.employee_id) CNT, 
                                                ROUND(AVG(salary), 3) SAL
    FROM employees e, departments d
    WHERE e.department_id = d.department_id
    AND e.department_id = v_deptno
    GROUP BY d.department_name;
    
    --CURSOR 에 PATCH하기 위한 변수들을 선언. 
    v_dname departments.department_name%TYPE;
    emp_cnt NUMBER;
    sal_avg NUMBER;
    
BEGIN
    -- CURSOR OPEN
    OPEN dept_avg;
    
    --CURSOR FATCH (커서 붙히기)
    FETCH dept_avg INTO v_dname, emp_cnt, sal_avg;
    
    DBMS_OUTPUT.PUT_LINE('부서명 : ' || v_dname);
    DBMS_OUTPUT.PUT_LINE('사원수 : ' || emp_cnt);
    DBMS_OUTPUT.PUT_LINE('급여평균 : ' || sal_avg);

END;
/

EXECUTE expcursor_test(50);








