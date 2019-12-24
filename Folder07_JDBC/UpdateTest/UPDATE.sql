SELECT * FROM EMPLOYEES;

CREATE TABLE USERDTO(
	ID VARCHAR2(50),
	NAME VARCHAR2(50),
	AGE NUMBER(3),
	JOINDATE DATE
);
drop table USERDTO;

UPDATE USERDTO SET AGE=99 WHERE id='aaa';



SELECT * FROM USERDTO;

select * FROM user_constraint;
select * FROM tab;

SELECT * FROM emp;
SELECT COUNT(department_id) FROM EMPLOYEES GROUP BY department_id;

select department_id sum(salary) from emp;