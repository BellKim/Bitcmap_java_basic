-- 무결성 : 컬럼에 지정하는 성질이다.
-- primary key(PK) : 기본키, NULL을 허용하지 않음. 중복되지 않는 값.  ex> ID
-- Unique key(UK) : 고유키, NULL허용 email 
-- CHECK : 범위를 설정하여 범위 내의 값만 값을 입력받도록 하며, NULL허용이 된다. 
-- Foreignkey : 다른테이블에서 PK나 unique key 여야  생성이 된다. (아니면 안만들어진다)
                        -- 목적은 테이블과 테이블을 연결해준다 .
                        -- 외래키는 NULL 허용한다. 
                        
-- NOT NULL : NULL을 허용하지 않는다. 
CREATE TABLE TB_TEST(
COL_01 VARCHAR2(10) NOT NULL,
COL_02 VARCHAR2(10) 
);

INSERT INTO TB_TEST(COL_01, COL_02) VALUES (10, 20);
INSERT INTO TB_TEST(COL_01, COL_02) VALUES ('AAA', 'aaa');
INSERT INTO TB_TEST(COL_01, COL_02) VALUES ('AAA', '');
INSERT INTO TB_TEST(COL_01, COL_02) VALUES (' ', 'aaa');        --앞에 데이터가 NULL들어가면 오류됨. 

select * FROM tb_test;

-- primary ket = NOT NULL + Unique
-- 유일하게 식별할 수 있는 정의된 규칙
--한 테이블에서 최대 32개 컬럼까지 지정할 수 있다. 
--CONSTRAINT == 무결성
CREATE TABLE TEST_01(
key_01 VARCHAR2(10) CONSTRAINT PK_TEST_01 PRIMARY KEY,
key_02 VARCHAR2(10),
key_03 VARCHAR2(10)
);
INSERT INTO TEST_01(KEY_01, KEY_02, key_03)
VALUES('AAA', 'aaa', '111');

INSERT INTO TEST_01(KEY_01, KEY_02, key_03)
VALUES('BBB', 'aaa', '111');
INSERT INTO TEST_01(KEY_01, KEY_02, key_03)
VALUES('', 'aaa', '111');   --NOTNULL 임.

DROP TABLE TEST_01
CASCADE CONSTRAINTS;



-----------------------------------------------------------------------------------------------------
--PK는 32개까지 가능하다. 또한 다중PK 사용하려면 다음과 같이 작성해야 한다. 
CREATE TABLE TEST_01(
key_01 VARCHAR2(10),
key_02 VARCHAR2(10),
key_03 VARCHAR2(10),
CONSTRAINT PK_TEST_01 PRIMARY KEY(KEY_01, KEY_02)
);

INSERT INTO TEST_01(key_01, KEY_02, KEY_03)
VALUES('AAA', 'aaa', '111');
INSERT INTO TEST_01(key_01, KEY_02, KEY_03)
VALUES('AAA', 'AAA', '111');--앞키값, 뒤키값이 같아도 오류는 안생김. 
INSERT INTO TEST_01(key_01, KEY_02, KEY_03)
VALUES('', '', '111');          --1 과 2 서로  NULL 안됨. 

drop table test_01;

CREATE TABLE TEST_01(
KEY_01 VARCHAR2(10),
KEY_02 VARCHAR2(10),
KEY_03 VARCHAR2(20)
);

--테이블 생성후에 PK나중에 추가하기
ALTER TABLE TEST_01
ADD CONSTRAINT PK_TEST_01
PRIMARY KEY(KEY_01, KEY_02); 

--기본키 삭제하기
ALTER TABLE TEST_01
DROP CONSTRAINT PK_TEST_01;

--UNIQUE KEY : 고유키 =  EMAIL 같은것. 

--유일한 값 NULL을 혀용. 
CREATE TABLE TEST_01(
    UKEY_01 VARCHAR2(10) CONSTRAINT UK_TEST_01 UNIQUE,
    COL_01 VARCHAR2(10),
    COL_02 VARCHAR2(20)
);

INSERT INTO TEST_01(UKEY_01, COL_01, COL_02)
VALUES('AAA','aaa','111');
--두번실행시 오류발생(중복값 허용안되는 UNIQUE 적용이기에)

INSERT INTO TEST_01(UKEY_01, COL_01, COL_02)
VALUES(' ','aaa','111');

SELECT * FROM test_01;

--유니크 삭제
ALTER TABLE TEST_01
DROP CONSTRAINT UK_TEST_01;

--CHECK 
-- 데이터의 값을 범위, 특정한 값의 지정이 가능하다.
--NULL을 허용한다.

DROP TABLE TEST_01
CASCADE CONSTRAINTS;

--안됨--안됨--안됨--안됨--안됨--안됨--안됨--안됨--안됨--안됨--안됨--안됨
CREATE TABLE TEST_01(
    KEY_01 VARCHAR2(10),
    COL_02 VARCHAR2(10),
    CONSTRAINT CHK_TEST_01 CHECK(KEY_01 IN('사과', '배', '바나나')),
    CONSTRAINT CHK_TEST_02 CHECK(COL_01 > 0 AND COL_01 <= 100)
);
--안됨--안됨--안됨--안됨--안됨--안됨--안됨--안됨--안됨--안됨--안됨--안됨--안됨
INSERT INTO TEST_01(KEY_01, COL_01)
VALUES('사과', 50);

INSERT INTO TEST_01(KEY_01, COL_01)
VALUES('귤', 50);

INSERT INTO TEST_01(KEY_01, COL_01)
VALUES('배', 50);


--FOREIGN KEY
--테이블을 연결하기 위한 무결성 제약조건이다. 
-- 다른 테이블의 값이 기본키, 고유키로 사용해야 한다. 
---중복 불가, NULL 허용






--  기본키가 있는 TABLE
    CREATE TABLE TEST_PAR(
        PKEY_01 VARCHAR2(10),
        PKEY_02 VARCHAR2(10),
        COL_01  VARCHAR2(20),
        COL_02 VARCHAR2(20),
        CONSTRAINT PK_TEST_01 PRIMARY KEY(PKEY_01, PKEY_02)
    );
    
    
-- 외래키가 있는 테이블 
    CREATE TABLE TEST_CHD(
        COL_01 VARCHAR2(10),
        FKEY_01 VARCHAR2(10),
        FKEY_02 VARCHAR2(10),
        
        CONSTRAINT FK_TEST_01 FOREIGN KEY(FKEY_01, FKEY_02)
        REFERENCES TEST_PAR(PKEY_01, PKEY_02)
    );

INSERT INTO TEST_PAR(PKEY_01, PKEY_02,COL_01,COL_02)
VALUES('AAA','aaa','123','345');
INSERT INTO TEST_PAR(PKEY_01, PKEY_02, COL_01,COL_02)
VALUES('BBB','bbb','123','345');


INSERT INTO TEST_CHD(COL_01, FKEY_01,FKEY_02) 
VALUES('ABC', 'AAA', 'aaa');
INSERT INTO TEST_CHD(COL_01, FKEY_01,FKEY_02) 
VALUES('ABC', 'aaa', 'aaa');    --안됨.
INSERT INTO TEST_CHD(COL_01, FKEY_01,FKEY_02) 
VALUES('CDE', '', ''); -- NULL 허용

SELECT * FROM test_chd;








CREATE TABLE EMP
AS SELECT * FROM employees;


--UPDATE

                --UPDATE emp 
                --SET 
                --WHERE
UPDATE emp 
SET salary = 1200
WHERE employee_id = 100;
SELECT * FROM emp;

commit;
ROLLBACK;
                
UPDATE emp 
SET salary = 1200, department_id = NULL
WHERE employee_id = 100;
SELECT * FROM emp;
                                

--DELETE
DELETE
FROM EMP
WHERE salary > 15000;
