/*
    index == 색인
    원하는 정보의 위치를 빠르고 정확하게 알아낼 수 있는 방법. (자동생성과 수동생성이 있다)
    자동생성 : Primary key, Unique 
    수동생성 : Query 문으로 생성해준다. 
    
    생성했을때 효율적인 경우가있는반면, 비효율적인면이 있기도하다.
    
    효율적인경우
    1. WHEN절이나 JOIN 조건안에 자주 사용되는 column -- department_id
    2. null값이 많이 포함되어 있는 Column                         -- manager_id 
    3. where절이나 join조건안에 두개 이상 사용되는 column 
    
    생성했을떄 비효율적인 경우
    1. 테이블의 크기(row) 가 작을때 (3000개 이하일때 안만드는게 더 효율적이다.)
    2. 테이블이 자주 갱신 될 경우
*/

    CREATE TABLE emp_copy
    AS  SELECT * FROM employees;

    SELECT * FROM emp_copy;
    
    --자동생성
    ALTER TABLE emp_copy
    ADD 
    CONSTRAINT PK_EMPCOPY_01 PRIMARY KEY(EMPLOYEE_ID);
    
    --INDEX 확인
    SELECT 
    * 
    FROM ALL_INDEXES
    WHERE index_name IN('PK_EMPCOPY_01');
    
    --강제 생성     특별한 상황아니면 안스는게 좋다
    CREATE INDEX EMP_INDEX01
    ON EMP_COPY(MANAGER_ID);
    
    
    
    
    