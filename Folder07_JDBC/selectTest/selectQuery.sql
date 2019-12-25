drop table USERDTO;

CREATE TABLE USERDTO(
	id VARCHAR2(20),
	name VARCHAR2(30),
	age NUMBER(10),
	joinDate DATE
);


INSERT INTO USERDTO VALUES('ggg', '가짜초코', 15, sysdate);
INSERT INTO USERDTO VALUES('fff', '민트만', 23, sysdate);
INSERT INTO USERDTO VALUES('eee', '요거트', 34, sysdate);
INSERT INTO USERDTO VALUES('aaa', 'aaa', 15, sysdate);
INSERT INTO USERDTO VALUES('bbb', 'bbb', 23, sysdate);
INSERT INTO USERDTO VALUES('ccc', 'cccc', 34, sysdate);



SELECT * FROM USERDTO;

