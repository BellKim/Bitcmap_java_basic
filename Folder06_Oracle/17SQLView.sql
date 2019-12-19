/*
        view 가상테이블
        실체가 없는 테이블
        실제 저장되는 것이 아니다. => pointer
        table <- view
        한개의 view로 여러개의 table의 데이터를 검색하는것이 가능하다. 
        뷰를 많이 만들어두면 작업 처리속도가 빨라진다. (검색속도)
        읽기전용이며, 보여야 할 영역을 직접 설정할 수 있다. 
        제한을 설정할 수 잇다. readONLY
        
*/

CREATE VIEW UB_TEST_01(
    JOB_ID,
    JOB_TITLE,
    MIN_salary
) AS SELECT job_id, job_title, min_salary
        FROM  jobs;
        
        
SELECT * FROM UB_TEST_01;

INSERT INTO UB_TEST_01
VALUES('DEVELOPER', '개발자', 100000);

select * FROM jobs;
ROLLBACK;

DELETE
FROM UB_TEST_01
WhERE job_title = '개발자';


CREATE TABLE TB_TEST_02(
KEY_01 VARCHAR2(10),
KEY_02 VARCHAR2(10),
COL_01 VARCHAR2(20),
COL_02 VARCHAR2(20),
CONSTRAINT PK_TEST_02 PRIMARY KEY(KEY_01, KEY_02)
);

CREATE VIEW UB_TEST_02(
KEY_01,
KEY_02,
COL_01,
CONSTRAINT PK_UB_TEST_02 PRIMARY KEY(KEY_01, KEY_02)DISABLE NOVALIDATE
)AS SELECT KEY_01, KEY_02, COL_01
      FROM TB_TEST_02;


INSERT INTO TB_TEST_02(KEY_01, KEY_02, COL_01)
VALUES('AAA','aaa','111');

INSERT INTO UB_TEST_02(KEY_01, KEY_02, COL_01)
VALUES('INSERT','aaa','111');


SELECT * FROM TB_TEST_02;
SELECT * FROM UB_TEST_02;       --뷰에 insert 해도 값이 입력된다. 

    --READ ONLY
CREATE OR REPLACE VIEW EMPVIEW(
    "사원번호",
    "성",
    "입사일",
    "업무",
    CONSTRAINT PK_UB_EMP PRIMARY KEY("사원번호") DISABLE NOVALIDATE
)AS 
    SELECT employee_id, LAST_name, email, hire_date, job_id 
    FROM employees 
    WITH READ ONLY;     --읽기전용으로 작성 (WITH READ ONLY)

SELECT * FROM EMPVIEW;
INSERT INTO EMPVIEW VALUES(400, 'KIM','KIM@naver.com', SYSDATE, 'IT_PROG' );
--READ ONLY이기에  데이터 입력이 안된다. 
 
 --여기서 입력을 하려면 삭제할 필요없이 바로위 create 뷰 구문에서 WITH READ ONLY 만 빼고 재실행하면됨.
 
 CREATE OR REPLACE VIEW DEPT_EMP_VIEW
 AS 
    SELECT e.employee_id, e.first_name, d.department_id, d.department_name, d.location_id
    FROM employees e, departments d
    WHERE e.department_id = d.department_id
    WITH READ ONLY;
    
    SELECT
        *
    FROM dept_emp_view;










