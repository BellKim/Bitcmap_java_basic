--TABLE 생성하기
CREATE TABLE TB_TEST01(
    COL_01 VARCHAR2(10),
    COL_02 VARCHAR2(10),
    COL_03 VARCHAR2(10),
    COL_04 VARCHAR2(10)
    );

CREATE TABLE TB_TEST02(
    COL_01 VARCHAR2(10),
    COL_02 VARCHAR2(10),
    COL_03 VARCHAR2(10),
    COL_04 VARCHAR2(10)
)
TABLESPACE TABLESPACE2;

--TABLE COPY (DATA 를 포함해서 복사한다.)
CREATE TABLE TB_TEST03
AS 
SELECT job_id AS "업무번호", job_title AS "업무명"  
FROM jobs;

SELECT * FROM TB_TEST03;
drop table TB_TEST03;

drop table TB_GROUP_DEPT;
CREATE TABLE TB_GROUP_DEPT
AS 
SELECT department_id AS "부서번호", SUM(salary) AS "합계", AVG(salary) AS "평균"
FROM employees
GROUP BY department_id;
SELECT * FROM TB_GROUP_DEPT;

--TABLE COPY :  데이터 미포함시키기
CREATE TABLE TB_TEST04
AS
SELECT * 
FROM departments
WHERE 1=2;       --1=2 성립할수 없는 조건을 WHERE에 넣으면 데이터를 미포함하게된다. 
select * FROM TB_test04;

--TABLE : CREATE, ALTER, DROP (생성 , 수정, 삭제, 
--DATA : INSERT, UPDATE, DELETE, SELECT (추가, 업데이트 삭제 선택)

--TABLE 수정 : 테이블명 수정. 
ALTER TABLE TB_TEST04
RENAME TO TB_TEST99;





