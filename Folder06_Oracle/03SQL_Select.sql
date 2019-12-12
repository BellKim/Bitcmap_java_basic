--  DML     insert, delete, select, update 
/*
    select
        (값, 문자,  column, 함수, subquery)
    FROM
        (table명, subquery)

*/

SELECT 1 FROM DUAL;


--현재 테이블을 모두 명세(자세하게 출력한다.)

select * from tab;

--테이블에서 원하는 컬럼의 값만을 명세

SELECT * FROM EMP;

--조건부출력 
SELECT  ENAME, JOB  FROM EMP;

--   월급 +300
SELECT ename, sal, sal+300
FROM EMP;

-- 월급 * 12
SELECT empno, sal, sal*12
FROM emp;


--alias int alias[] = array;   alias[0] = 12;
SELECT empno AS 사원번호, sal, sal*12
FROM emp;




--  공백없이 붙혀주면 상관없지만,  공백이 있을 경우에는 큰따옴표 속에 넣어준다. 
SELECT empno as 사원번호, sal "월급", sal*12 "일년치 연봉"
FROM emp;


-- 연결 연산자 + ||      
--     자바문법 : "ABC" + "DEF" 
--      오라클문법 "ABC" || "DEF" 
SELECT ename || 'has $' || sal
FROM emp;


SELECT ename || 'has $' || sal as "월급"
FROM emp;


-- distinct : 중복행의 삭제,, 중복값을 모두 제거해서 고유값만 나오도록 처리함.
SELECT  DISTINCT deptno 
FROM EMP;

-- DESC -> table의 column의 자료형을 명세.
DESC emp;

DESC dept;


--    1)emp 테이블에서 사원번호, 사원이름, 월급을 출력
SELECT * FROM EMP;
SELECT EMPNO, ENAME, SAL FROM EMP;


--    2)emp 테이블에서 사원이름과 월급을 출력하는데 컬럼명은 이 름, 월 급으로 바꿔서 출력하시오.
SELECT ENAME AS "이 름", SAL AS "월 급"
FROM EMP;

--    3)emp 테이블에서 사원번호, 사원이름, 월급, 연봉을 구하고 각각 컬럼명은
--    사원번호, 사원이름, 월급, 연봉으로 출력하시오 
SELECT EMPNO AS 사원번호, ENAME AS 이름, SAL AS 월급, SAL*12 AS 연봉
FROM EMP;

--    4)emp 테이블의 업무(job) 을 중복되지 않게 표시하시오.
SELECT DISTINCT job 
FROM EMP;


--    5)emp 테이블의 사원명과 업무로 연결(SMITH, CLERK) 해서 표시하고
--    컬럼명은 Employee and Job 으로 표시하시오.

SELECT ename || job as "Employee and Job"
FROM EMP;










