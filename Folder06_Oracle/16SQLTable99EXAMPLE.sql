--문제1) EMPLOYEES 테이블에서 
--          부서별로  인원수,평균 급여,급여의 합,최소 급여, 최대 급여를 포함하는 EMP_DEPTNO 테이블을 생성하라. 
CREATE TABLE EMP_DEPTNO
AS (SELECT 
        department_id AS "부서ID", COUNT(*) AS "인원", trunc(AVG(salary)) AS"급여평균", SUM(salary) AS "급여총합", MIN(salary)AS "최저",MAX(salary) AS "최고"
      FROM employees
      GROUP BY department_id
      );

SELECT*FROM emp_deptno;
DROP TABLE emp_deptno;

--문제2) EMP_DEPTNO 테이블에 ETC COLUMN을 추가하라. 단 자료형은 VARCHAR2(50) 사용하라. 
ALTER TABLE EMP_DEPTNO
ADD ETC VARCHAR2(50);


--문제3) EMP_DEPTNO 테이블에 ETC COLUMN을 수정하라. 자료 형은 VARCHAR2(15)로 하라. 
ALTER TABLE EMP_DEPTNO
MODIFY ETC VARCHAR2(15);

--문제4) EMP_DEPTNO 테이블에 있는 ETC 을 삭제하고 확인하라. 
ALTER TABLE EMP_DEPTNO
DROP COLUMN ETC;

--문제5) 이전에 생성한 EMP_DEPTNO 테이블의 이름을 EMP_DEPT로 변경하라. 
ALTER TABLE EMP_DEPTNO
RENAME TO  "EMP_DEPT";


SELECT*FROM EMP_DEPT;
--문제6) EMP_DEPT 테이블을 삭제하라. 
DROP TABLE emp_dept
CASCADE CONSTRAINTS;
DROP TABLE emp;

--문제7) EMPLOYEES 테이블을 EMP 테이블을 생성하고 복제하도록 하라. (데이터 포함) 

CREATE TABLE EMP 
AS (
            SELECT * FROM EMPLOYEES
            WHERE 1=2)

--문제8) EMP 테이블에 row를 추가해 봅니다. 다만, 반드시 데이터를 기입을 안해도 되면, NULL로 설정하도록 한다. 
INSERT INTO EMP(employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)
values('','','lsat','email','',to_date(sysdate),'IT_PROG','','','','');


--CREATE TABLE TEST_01(
--    UKEY_01 VARCHAR2(10) CONSTRAINT UK_TEST_01 UNIQUE,
--    COL_01 VARCHAR2(10),
--    COL_02 VARCHAR2(20)
--);
select * FROM emp;
select * FROM employees;

--문제9) EMPLOYEES 테이블에서 EMPNO,ENAME,SAL,HIREDATE의 COLUMN만 선택하여 
--           EMP_10 테이블을 생성(데이터 미포함)한 후 10번 부서만 선택하여 이에 대응하는 값을 EMP_10테이블에 입력하라. 

CREATE TABLE EMP_10
AS (select employee_id, last_name, salary, hire_date  FROM employees);
SELECT * FROM emp_10;
-- 문제10) EMPLOYEES 테이블에서 사원 번호가 107인 사원의 부서를 10번으로 변경하여라. 
    UPDATE employees
    SET department_id=10
    WHERE employee_id=107;
    
    SELECT * FROM employees where employee_id = 107;


-- 문제11) EMPLOYEES 테이블에서 사원 번호가 180인 사원의 부서를 20, 급여를 3500으로 변경하여라.
update employees
SET salary = 3500, department_id=20
WHERE employee_id=108;
SELECT * FROM employees where employee_id = 108;

--문제12) EMPLOYEES 테이블에서 Smith의 업무와 급여가 Hall의 업무와 급여와 일치하도록 수정하라.
 --못품
 
update employees
SET  last_name='Smith'
WHERE salary = (SELECT trunc(AVG(salary)) FROM employees where last_name='Smith' OR last_name='Hall');

select * FROM employees WHERE last_name = 'Smith' OR last_name = 'Hall' ;
 
 
 
 ------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--문제 1번) 테이블명 address,
--id, name, addr, phone, email (BYTE 크기는 자유)
--테이블 생성하기.
create table address(
id VARCHAR(20),
name VARCHAR(20), 
addr VARCHAR(20), 
phone VARCHAR(20), 
email VARCHAR(20) UNIQUE
);


--문제2번) 주소록 테이블의 구조와 데이터를 복사하여 addr_second 테이블을 생성.(구조와 데이터만 복사해서 생성함.)
CREATE TABLE addr_second
AS (SELECT * FROM address);
--문제 3번) 주소록 테이블에서 id, name 칼럼만 복사하여 
--addr_forth 테이블을 생성 (구조만 복사)
CREATE TABLE addr_forth
AS (SELECT id,name FROM address WHERE 1=2);


--문제4번) Address 테이블에 5개의 데이터를 추가하세요 
INSERT INTO Address(id, name, addr, phone, email) VALUES ('1','2','3','4','5');
INSERT INTO Address(id, name, addr, phone, email) VALUES ('1','2','3','4','2');
INSERT INTO Address(id, name, addr, phone, email) VALUES ('1','2','3','4','3');
INSERT INTO Address(id, name, addr, phone, email) VALUES ('1','2','3','4','4');
INSERT INTO Address(id, name, addr, phone, email) VALUES ('1','2','3','4','1');
drop table address;
SELECT * FROM address;

--문제 5번)Address 테이블에서 id, name 만 가진 Address2 테이블을 만들고
--자료를 전부 가지고 오기
CREATE TABLE address2
AS (SELECT id, name FROM address);
SELECT * FROM address2;
--문제 6번) 주소록 테이블에 날짜 타입을 가지는 birth 칼럼을 추가
ALTER TABLE address
ADD birth VARCHAR2(20);
SELECT * FROM address;
--문제 7번) 주소록 테이블에 문자 타입을 가지는 comments 칼럼을 추가
--기본값은 'No Comment'로 지정하여라.
alter table address
ADD comments varchar(20);

--문제 8번)주소록 테이블에서 comments 칼럼을 삭제
alter table address
drop COLUMN comments;

--문제 9번) 주소록 테이블에서
--phone 칼럼의 데이터 타입의 크기를 50으로 증가
alter table address
MODIFY phone VARCHAR(50);


