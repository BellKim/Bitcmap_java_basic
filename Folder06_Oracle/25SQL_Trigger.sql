/*
    Procedure ; insert, delete, update
                    프로시저는 IN, OUT의 기능이 있다. 
                    
    Function    : select
                    RETURN 
    
    Trigger     :  촉발시키다, 스스로 발생하다. 
                    CALLBACK : 특정 사건이 발생되었을때 자동으로 호출되도록 하는것. 
                                    
                    값이 들어가서 바뀌는지확인하거나 값이 못들어가도록 하는것. 
                                    old(이전값), new(새로운값) 요소가 존재ㅣ
                                        OLD(이전값)             NEW(새값)
                    INSERT      X                                   O
                    DELETE      O                                  X
                    UPDATE      O                                O
*/


SET SERVEROUTPUT ON;

--CREATE OR REPLACE TRIGGER Triger_test
--    BEFORE  
--        INSERT
--        UPDATE
--        DELETE
--                UPDATE ON departments
--            FOR EACH ROW              --로우(세로)방향으로 검사를해라
--BEGIN
--        DBMS_OUTPUT.PUT_LINE('변경전 컬럼의 값' || OLD.department_name); 
--        DBMS_OUTPUT.PUT_LINE('변경후 컬럼의 값' || NEW.department_name);
--END;
--/




CREATE OR REPLACE TRIGGER Triger_test
    BEFORE 
            UPDATE ON departments
            FOR EACH ROW
BEGIN
        DBMS_OUTPUT.PUT_LINE('변경전 컬럼의 값' || :OLD.department_name);
        DBMS_OUTPUT.PUT_LINE('변경후 컬럼의 값' || :NEW.department_name);
END;
/










