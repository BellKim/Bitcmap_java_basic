/*
    sequence : 유일한 값ㅇ르 생성해 주는 Oracle Object
    회원번호, 게시판관리 글번호
    초기화가 불가능하다. 다시 그번호를 사용하기 위해서는 삭제후 다시 생성해야한다. 
    
    
*/
--시퀀스 생성 
CREATE SEQUENCE TEST_SEQ
INCREMENT BY 1      --1씩 증하하도록한다. 
START WITH 10       -- 시작 수
MAXVALUE 1000       --최대값, 생략가능.
MINVALUE 1;             --최소값


--currentval 현재의값
SELECT TEST_SEQ.CURRVAL
FROM DUAL;

-- NEXTVAL  --진행 값
SELECT TEST_SEQ.NEXTVAL
FROM DUAL;

-- SEQUENCE 수정
ALTER SEQUENCE TEST_SEQ
INCREMENT BY 3;

-- SEQUENCE 초기화가 불가
-- 시퀀스 삭제
DROP SEQUENCE TEST_SEQ;


--동의어   (SYSNOYM    /  시노넘? / 객체의 별명)
CREATE SYNONYM "사원들"
FOR EMPLOYEES;

SELECT * FROM 사원들;

INSERT INTO "사원들"
VALUES(EMPLOYEES_SEQ.NEXTVAL, '길동','홍', 'HONGGD@daum.net',
                '123-123-1223', TO_DATE('20050101', 'YYYYMMDD'),
                'IT_PROG', 20000, NULL, 100, 10);



