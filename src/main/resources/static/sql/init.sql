CREATE TABLE MEMBER
(
    ID                NUMBER(4) PRIMARY KEY,
    EMAIL             NVARCHAR2(50) NOT NULL,
    PASSWORD          NVARCHAR2(80) NOT NULL,
    USERNAME          NVARCHAR2(5)  NOT NULL,
    PHONE             NVARCHAR2(11) NOT NULL,
    CAREER            NUMBER(1),
    POSITION          NVARCHAR2(6),
    INFO              NCLOB,
    GITHUB_LINK       NVARCHAR2(50),
    PROFILE_IMAGE_URL NVARCHAR2(200),
    IS_MODIFY         NUMBER(1),
    CREATED_AT        TIMESTAMP
);

CREATE TABLE MEMBER_SKILL
(
    ID         NUMBER(5) PRIMARY KEY,
    SKILL_NAME NVARCHAR2(15) NOT NULL,
    MEMBER_ID  NUMBER(4)     NOT NULL
);

CREATE TABLE PROJECT
(
    ID              NUMBER(5) PRIMARY KEY,
    PROJECT_NAME    NVARCHAR2(50) NOT NULL,
    PROJECT_TYPE    NVARCHAR2(10) NOT NULL,
    SUBJECT         NVARCHAR2(30) NOT NULL,
    PROJECT_PURPOSE NVARCHAR2(15) NOT NULL,
    PROJECT_TIME    NUMBER(1)     NOT NULL,
    RECRUIT_COUNT   NUMBER(1)     NOT NULL,
    PROJECT_PROCESS NVARCHAR2(7)  NOT NULL,
    EXCEPT_DATE     NUMBER(1)     NOT NULL,
    EXCEPT_TIME     TIMESTAMP     NOT NULL,
    PROJECT_INFO    NCLOB         NOT NULL,
    STATUS          NUMBER(1)     NOT NULL,
    OWNER_ID        NUMBER(4)     NOT NULL,
    VIEWS           NUMBER(10),
    GITHUB_LINK     NVARCHAR2(100),
    IS_SHOW         NUMBER(1) DEFAULT 1,
    IMAGE_URL       NVARCHAR2(200),
    MODIFIED_SHOW   TIMESTAMP,
    CREATED_AT      TIMESTAMP
);

CREATE TABLE PROJECT_SKILL
(
    ID         NUMBER(5) PRIMARY KEY,
    SKILL_NAME NVARCHAR2(15) NOT NULL,
    PROJECT_ID NUMBER(5)     NOT NULL
);

CREATE TABLE RECRUIT_ROLE
(
    ID         NUMBER(4) PRIMARY KEY,
    PROJECT_ID NUMBER(5),
    ROLE_NAME  NVARCHAR2(6) NOT NULL
);

CREATE TABLE TEAM_NOTE
(
    ID         NUMBER(5) PRIMARY KEY,
    TEAM_NAME  NVARCHAR2(10),
    PROJECT_ID NUMBER(5)
);

-- TODO : CALENDAR 구현 후 테이블 추가

CREATE TABLE SUBSCRIBE
(
    ID         NUMBER(5) PRIMARY KEY,
    CONTENT    NVARCHAR2(100) NOT NULL,
    PROJECT_ID NUMBER(5)      NOT NULL,
    MEMBER_ID  NUMBER(4)      NOT NULL,
    CREATED_AT TIMESTAMP
);

CREATE TABLE BOOKMARK
(
    ID         NUMBER(5) PRIMARY KEY,
    MEMBER_ID  NUMBER(4) NOT NULL,
    PROJECT_ID NUMBER(5) NOT NULL
);

CREATE TABLE PROJECT_MEMBER
(
    ID         NUMBER(2) PRIMARY KEY,
    PROJECT_ID NUMBER(5),
    MEMBER_ID  NUMBER(4)
);

CREATE TABLE CHAT
(
    ID         NUMBER(5) PRIMARY KEY,
    CONTENT    NVARCHAR2(100) NOT NULL,
    TEAM_ID    NUMBER(5),
    MEMBER_ID  NUMBER(4),
    CREATED_AT TIMESTAMP
);

CREATE TABLE KANBAN
(
    ID         NUMBER(5) PRIMARY KEY,
    STATUS     NVARCHAR2(10) NOT NULL,
    TODO       NVARCHAR2(20) NOT NULL,
    START_DATE TIMESTAMP     NOT NULL,
    END_DATE   TIMESTAMP     NOT NULL,
    TEAM_ID    NUMBER(5),
    MEMBER_ID  NUMBER(4)
);

CREATE SEQUENCE MEMBER_SEQ
    INCREMENT BY 1
    START WITH 1
    NOCYCLE
    NOCACHE;

CREATE SEQUENCE PROJECT_SEQ
    INCREMENT BY 1
    START WITH 1
    NOCYCLE
    NOCACHE;

CREATE SEQUENCE MEMBER_SKILL_SEQ
    INCREMENT BY 1
    START WITH 1
    NOCYCLE
    NOCACHE;

CREATE SEQUENCE BOOKMARK_SEQ
    INCREMENT BY 1
    START WITH 1
    NOCYCLE
    NOCACHE;

CREATE SEQUENCE CHAT_SEQ
    INCREMENT BY 1
    START WITH 1
    NOCYCLE
    NOCACHE;

CREATE SEQUENCE KANBAN_SEQ
    INCREMENT BY 1
    START WITH 1
    NOCYCLE
    NOCACHE;

CREATE SEQUENCE PROJECT_MEMBER_SEQ
    INCREMENT BY 1
    START WITH 1
    NOCYCLE
    NOCACHE;

CREATE SEQUENCE PROJECT_SKILL_SEQ
    INCREMENT BY 1
    START WITH 1
    NOCYCLE
    NOCACHE;

CREATE SEQUENCE RECRUIT_ROLE_SEQ
    INCREMENT BY 1
    START WITH 1
    NOCYCLE
    NOCACHE;

CREATE SEQUENCE SUBSCRIBE_SEQ
    INCREMENT BY 1
    START WITH 1
    NOCYCLE
    NOCACHE;

CREATE SEQUENCE TEAM_NOTE_SEQ
    INCREMENT BY 1
    START WITH 1
    NOCYCLE
    NOCACHE;