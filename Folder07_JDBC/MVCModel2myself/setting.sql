drop table BBS;
drop table MEMBER;

CREATE TABLE MEMBER(
	id varchar2(30) NOT NULL,
	pwd varchar2(30) NOT NULL,
	name VARCHAR2(30) NOT NULL,
	email VARCHAR2(20) UNIQUE NOT NULL,
	auth NUMBER(1) NOT NULL
	
);

INSERT INTO MEMBER(id, pwd, name, email, auth)
VALUES ('asd', 'asd', 'kim', 'hello@world.com', 3);


SELECT * FROM MEMBER;

SELECT * FROM BBS;
