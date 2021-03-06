/*------------------------------------------------------------------------------
-- 개체명 : RTMASTER.TBL_USER_INFO
-- 생성일 : 2016-10-27 오후 2:16:06
-- 최종수정일 : 2016-10-27 오후 2:20:57
-- 상태 : VALID
------------------------------------------------------------------------------*/
DROP TABLE RTMASTER.TBL_USER_INFO CASCADE CONSTRAINTS;

CREATE TABLE RTMASTER.TBL_USER_INFO (
CORP_CODE   VARCHAR2(2)       NOT NULL,
  USER_ID      VARCHAR2(20)     NOT NULL,
  PASSWD_NO    VARCHAR2(20)         NULL,
  USER_NM      VARCHAR2(20)         NULL
)
TABLESPACE RETAIL_DB
PCTFREE 10
PCTUSED 0
INITRANS 1
MAXTRANS 255
STORAGE (
    INITIAL 64 K
    MINEXTENTS 1
    MAXEXTENTS UNLIMITED
    FREELISTS 1
    FREELIST GROUPS 1
)
LOGGING
NOCACHE
MONITORING
NOPARALLEL
;

COMMENT ON TABLE RTMASTER.TBL_USER_INFO IS '사용자_정보';

COMMENT ON COLUMN RTMASTER.TBL_USER_INFO.CORP_CODE IS '기업코드';

COMMENT ON COLUMN RTMASTER.TBL_USER_INFO.USER_ID IS '사용자_ID ';

COMMENT ON COLUMN RTMASTER.TBL_USER_INFO.PASSWD_NO IS '패스워드_번호 ';

COMMENT ON COLUMN RTMASTER.TBL_USER_INFO.USER_NM IS '사용자_명 ';

ALTER TABLE RTMASTER.TBL_USER_INFO ADD
(
    PRIMARY KEY ( CORP_CODE, USER_ID )
        USING INDEX
        TABLESPACE RETAIL_DB
        PCTFREE 10
        INITRANS 2
        MAXTRANS 255
        STORAGE (
            INITIAL 64 K
            MINEXTENTS 1
            MAXEXTENTS UNLIMITED
            FREELISTS 1
            FREELIST GROUPS 1
        )
);

