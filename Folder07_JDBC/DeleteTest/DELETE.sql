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