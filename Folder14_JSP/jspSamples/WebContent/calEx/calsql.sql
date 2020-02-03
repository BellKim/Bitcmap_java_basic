DROP TABLE CALENDAR
CASCADE CONSTRAINTS;

DROP SEQUENCE SEQ_CAL;

CREATE TABLE CALENDAR(
	SEQ NUMBER(8) PRIMARY KEY,		--unique (null은 허용하나 중복은안됨)
	ID VARCHAR2(50) NOT NULL,
	TITLE VARCHAR2(200) NOT NULL,
	CONTENT VARCHAR2(4000) NOT NULL,
	RDATE VARCHAR2(12),
	WDATE DATE NOT NULL
);

CREATE SEQUENCE SEQ_CAL
START WITH 1
INCREMENT BY 1;



ALTER TABLE CALENDAR
ADD CONSTRAINT FK_CAL_ID FOREIGN KEY(ID)
REFERENCES MEMBER(ID);



							--8자리를 가진다. 2020/02/03  => 20200203으로 입력 
							--날짜별로 일정을 파티션 쳐준다. 
SELECT ROW_NUMBER() OVER(PARTITION BY SUBSTR(RDATE, 1, 8)ORDER BY RDATE ASC)
	SEQ, ID, TITLE, CONTENT, RDATE, WDATE
FROM CALENDAR
WHERE ID=? AND SUBSTR(RDATE, 6, 1)=?
				--연도와 월만 가지고온다.


SELECT SEQ, ID, TITLE, CONTENT, RDATE, WDATE 
FROM (SELECT ROW_NUMBER() OVER(PARTITION BY SUBSTR(RDATE, 1, 8)ORDER BY RDATE ASC) RNUM,
	SEQ, ID, TITLE, CONTENT, RDATE, WDATE
FROM CALENDAR
WHERE ID=? AND SUBSTR(RDATE, 6, 1)=?)
WHERE RNUM BETWEEN 1 AND 5;










