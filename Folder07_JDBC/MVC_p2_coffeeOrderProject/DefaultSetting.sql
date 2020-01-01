SELECT * FROM COFFEELIST;
SELECT * FROM COFFEEMEMBERS;
SELECT * FROM COFFEEORDER;

DROP TABLE COFFEELIST CASCADE CONSTRAINT;
DROP TABLE COFFEEMEMBERS CASCADE CONSTRAINT;
DROP TABLE COFFEEORDER CASCADE CONSTRAINT;
--DROP CONSTRAINT UK_ID_01;
--
--ALTER TABLE COFFEEMEMBERS DROP CONSTRAINT UK_ID_01;

DROP SEQUENCE cofee_index;
DROP SEQUENCE MEMBERINDEX;
DROP SEQUENCE ORDER_INDEX;

CREATE SEQUENCE cofee_index
INCREMENT BY 1 
START WITH 1
MAXVALUE 1000
MINVALUE 1
NOCYCLE;

CREATE SEQUENCE MEMBERINDEX
INCREMENT BY 1 
START WITH 1
MAXVALUE 1000
MINVALUE 1
NOCYCLE;

CREATE SEQUENCE ORDER_INDEX
INCREMENT BY 1 
START WITH 1
MAXVALUE 1000
MINVALUE 1
NOCYCLE;

CREATE TABLE COFFEELIST(
	coffee_index NUMBER(4),
	coffeeName VARCHAR2(100),
	coffeeSize NUMBER(1),
	sizePrice NUMBER(5),
	CONSTRAINT PR_COFFEELIST_01 PRIMARY KEY(coffee_index)
);

CREATE TABLE COFFEEMEMBERS(
	MEMBERINDEX	NUMBER(4),
	ID			VARCHAR2(20),
	PW			VARCHAR2(20),
	NAME		VARCHAR2(20),
	AGE			NUMBER(3),
	AUTH		NUMBER(2),
	CONSTRAINT PR_COFFEEMEMBERS_01 PRIMARY KEY(MEMBERINDEX)
	
);

CREATE TABLE COFFEEORDER(
	ORDER_INDEX	NUMBER(4),		--PK
	MEMBERINDEX	NUMBER(4),		--FK
	coffee_index NUMBER(4),		--FK
	order_date	DATE,
	coffee_size	VARCHAR2(3),
	SYRUP		VARCHAR2(1),
	ADDSHOT		VARCHAR2(1),
	ADDWHIPING	VARCHAR2(1),
	AMOUNT		VARCHAR2(2),
	CONSTRAINT PR_OrderList_01 PRIMARY KEY(ORDER_INDEX),
	CONSTRAINT FK_COFFEEMEMBERS_01 FOREIGN KEY(MEMBERINDEX) REFERENCES COFFEEMEMBERS(MEMBERINDEX),
	CONSTRAINT FK_COFFEELIST_01 FOREIGN KEY(coffee_index) REFERENCES COFFEELIST(coffee_index)
);

INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '헤이즐넛 카라멜 모카', 1, 4800);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '헤이즐넛 카라멜 모카', 2, 5300);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '헤이즐넛 카라멜 모카', 3, 5800);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '카라멜 마끼아또', 1, 4300);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '카라멜 마끼아또', 2, 4800);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '카라멜 마끼아또', 3, 5300);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '화이트 초콜릿 모카', 1, 4300);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '화이트 초콜릿 모카', 2, 4800);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '화이트 초콜릿 모카', 3, 5300);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '카라멜 모카', 1, 4300);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '카라멜 모카', 2, 4800);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '카라멜 모카', 3, 5300);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '카페 모카', 1, 3800);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '카페 모카', 2, 4300);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '카페 모카', 3, 4800);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '카라멜 라떼', 1, 3800);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '카라멜 라떼', 2, 4300);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '카라멜 라떼', 3, 4800);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '카페 라떼', 1, 3300);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '카페 라떼', 2, 3800);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '카페 라떼', 3, 4300);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '카푸치노', 1, 3300);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '카푸치노', 2, 3800);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '카푸치노', 3, 4300);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '아메리카노', 1, 2800);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '아메리카노', 2, 3300);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '아메리카노', 3, 3800);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '오늘의 커피', 1, 2500);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '오늘의 커피', 2, 3000);
INSERT INTO COFFEELIST
VALUES (cofee_index.NEXTVAL, '오늘의 커피', 3, 3500);


insert into COFFEEMEMBERS
values(MEMBERINDEX.nextval, 'asd', 'asd', 'asd', 29, 3);
insert into COFFEEMEMBERS
values(MEMBERINDEX.nextval, '1233', '1233', '12', 29, 3);


insert into coffeeorder
values(ORDER_INDEX.nextval,1,1,sysdate,1,1,1,1,3);


--커피이름 산출
SELECT b.coffee_index, b.coffeeName 
from coffeeorder a, coffeelist b
WHERE a.coffee_index = b.coffee_index; 


-- 커피가격 받아왔나 출력
SELECT * FROM COFFEELIST
WHERE coffeeName = '카라멜 마끼아또' 
AND coffeeSize = 1;

--커피 번호 출력 
SELECT coffee_index FROM COFFEELIST 
WHERE coffeeName = '아메리카노' AND coffeeSize  = 1
OR coffeeName = '아메리카노' AND coffeeSize  = 2
OR coffeeName = '아메리카노' AND coffeeSize  = 3; 