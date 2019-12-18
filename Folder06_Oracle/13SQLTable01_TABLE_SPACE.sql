--상당 메뉴에서 보기 - dba 누르고  system 계정으로 로그인
CREATE TABLESPACE TABLESPACE2
DATAFILE 'D:\TEST\TEST_TBS1.DBF' SIZE 10M
AUTOEXTEND ON NEXT 1M MAXSIZE UNLIMITED -- 추가되는 용량 
LOGGING                                                                 --로깅사용
EXTENT MANAGEMENT LOCAL AUTOALLOCATE    --LOCAL
BLOCKSIZE 8K                                                            --블록크기 8k
SEGMENT SPACE MANAGEMENT AUTO

FLASHBACK ON;


-- table space rename
ALTER  TABLESPACE TABLESPACE2
RENAME TO TEST_TBS_NEW;

--파일 용량 수정
ALTER DATABASE 
DATAFILE 'D:\TEST\TEST_TBS1.DBF' RESIZE 20M;


--TABLE SPACE 삭제
--UI로도 삭제 가능하다. 
DROP TABLESPACE TABLESPACE1
INCLUDING CONTENTS AND DATAFILES
CASCADE CONSTRAINTS;

                                  



