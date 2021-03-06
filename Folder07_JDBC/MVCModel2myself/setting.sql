drop table MEMBER;
DROP TABLE BBS
CASCADE CONSTRAINTS;
DROP SEQUENCE SEQ_BBS;


CREATE TABLE MEMBER(
	id varchar2(30) NOT NULL,
	pwd varchar2(30) NOT NULL,
	name VARCHAR2(30) NOT NULL,
	email VARCHAR2(20) UNIQUE NOT NULL,
	auth NUMBER(1) NOT NULL
);

INSERT INTO MEMBER(id, pwd, name, email, auth)
VALUES ('asd', 'asd', 'kim', 'hello@world.com', 3);




CREATE TABLE BBS(
	SEQ NUMBER(8) PRIMARY KEY,
	ID VARCHAR2(30) NOT NULL,
	TITLE VARCHAR2(200) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	WDATE DATE NOT NULL,
	DEL NUMBER(1) NOT NULL,
	READCOUNT NUMBER(8) NOT NULL
);

CREATE SEQUENCE SEQ_BBS
START WITH 1
INCREMENT BY 1;

ALTER TABLE BBS
ADD CONSTRAINT FK_BBS_ID FOREIGN KEY(ID)
REFERENCES MEMBER(ID);

INSERT INTO BBS(SEQ,  ID, TITLE, CONTENT, WDATE, DEL, READCOUNT)
VALUES(SEQ_BBS.NEXTVAL, 'asd', '첫번쨰 타이틀 입니ek.. ', '컨텐츠 입력란', sysdate, 0, 1);
INSERT INTO BBS(SEQ,  ID, TITLE, CONTENT, WDATE, DEL, READCOUNT)
VALUES(SEQ_BBS.NEXTVAL, 'asd', '첫번쨰 타이틀 입니ek.. ', '컨텐츠 입력란', sysdate, 0, 1);
INSERT INTO BBS(SEQ,  ID, TITLE, CONTENT, WDATE, DEL, READCOUNT)
VALUES(SEQ_BBS.NEXTVAL, 'asd', '첫번쨰 타이틀 입니ek.. ', '컨텐츠 입력란', sysdate, 0, 1);


SELECT * FROM MEMBER;

SELECT * FROM BBS;
