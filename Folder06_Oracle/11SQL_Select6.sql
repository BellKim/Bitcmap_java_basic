--특수쿼리
--case decode

SELECT employee_id, first_name, phone_number,
    CASE SUBSTR(phone_number, 1, 3)
        WHEN '515' THEN '서울'
        WHEN '519' THEN '부산'
        WHEN '659' THEN '광주'
        WHEN '603' THEN '대전'
        ELSE '기타'
    END AS "지역"
FROM employees;

SELECT 
    employee_id, first_name, phone_number,
    CASE
        WHEN SUBSTR(phone_number, 1, 3) = '515' THEN '서울'
        WHEN SUBSTR(phone_number, 1, 3) = '590' THEN '부산'
        WHEN SUBSTR(phone_number, 1, 3) = '659' THEN '광주'
        WHEN SUBSTR(phone_number, 1, 3) = '603' THEN '대전'
        ELSE '기타'
    END AS 지역
FROM employees;

SELECT 
    employee_id, first_name, phone_number,
    DECODE( SUBSTR(phone_number,1,3),
                    '515', '서울',
                    '590', '부산',
                    '659','광주',
                    '603', '대전', '기타') AS "지역"
FROM employees;


--분석함수
--순위 RANK
--RANK()                1 2 3 3 5 6 
--DENSE_RANK()    1 2 3 3 4 5 
--ROW_NUMBER() 1 2 3 4 5 6 
--ROWNUM            

SELECT
*
FROM employees;

--          ROWNUM

--  OVER() PARTITION BY ORDER BY    ...
SELECT job_id, COUNT(*)OVER()       --107 = 전체 카운트
FROM employees;

--job_id 단위로 파티션을 설정하여 카운트한다.
SELECT job_id, COUNT(*)OVER(PARTITION BY job_id)     
FROM employees;

SELECT job_id, salary, COUNT(*)OVER(PARTITION BY job_id ORDER BY salary DESC)
FROM employees;
--over = 카운트될 조건을 설정하여라 

SELECT
    first_name, salary,
    RANK() OVER(ORDER BY salary DESC) AS RANK
FROM employees;

SELECT
    first_name, salary,
    RANK() OVER(ORDER BY salary DESC) AS RANK,
    DENSE_RANK()OVER(ORDER BY salary DESC) AS DENSE_RANK        --순위먹이기
FROM employees;

SELECT
    first_name, salary,
    RANK() OVER(ORDER BY salary DESC) AS RANK,
    DENSE_RANK()OVER(ORDER BY salary DESC) AS DENSE_RANK,        --순위먹이기
    ROW_NUMBER()OVER(ORDER BY salary DESC) AS ROW_NUMBER    --동률이라도 순서에 의해서 그냥 카운트를 생성한다.
FROM employees;

--      ROWNUM

--10명의 ROW문을 산출하는 경우
SELECT  ROWNUM, employee_id, first_name, salary
FROM employees
-- rownum에 번호를 순차적으로 먹일 수 있다. 
WHERE ROWNUM <=10;
--  10명까지 자를 수 있다. 


--  11~20 만의 ROW 만 산출하는 경우
SELECT  ROWNUM, employee_id, first_name, salary
FROM employees
-- rownum에 번호를 순차적으로 먹일 수 있다. 
WHERE ROWNUM >10 AND ROWNUM <=20;       -- ROWNUM은 제일 나중에 추가되므로 동작하지 않는다. 다음을 참조하여 보자. 



--1. 설정, 
--2. ROWNUM 완성
--3. 범위를 설정
SELECT RNUM, employee_id, first_name, salary
FROM(
            SELECT ROWNUM AS RNUM, employee_id, first_name, salary      --2. 번호를 붙히는 작업을 해준다.(RNUM완성)
            FROM (
                        SELECT employee_id, first_name, salary        -- 1. data 설정 
                        FROM employees
            )
        )
WHERE RNUM > 10 AND RNUM <=20;                          --3. 범위를 설정하여 값을 산출해준다. (선택적 옵션)

/*
    합집합 : UNION
    교집합 : INTERSECT
    차집합 : MINUS
*/



--UNION (합집합)
SELECT  job_id
FROM employees
WHERE job_id IN('AD_VP', 'FI_ACCOUNT')
UNION
    SELECT job_id
    FROM jobs
    WHERE job_id IN ('AD_VP', 'IT_PROG');







