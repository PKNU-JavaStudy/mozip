CREATE TABLE MEMBER
(
    ID                INT AUTO_INCREMENT PRIMARY KEY,
    EMAIL             VARCHAR(50) NOT NULL,
    PASSWORD          VARCHAR(80) NOT NULL,
    USERNAME          VARCHAR(5)  NOT NULL,
    PHONE             VARCHAR(11) NOT NULL,
    CAREER            TINYINT,
    POSITION          VARCHAR(6),
    INFO              TEXT,
    GITHUB_LINK       VARCHAR(50),
    PROFILE_IMAGE_URL VARCHAR(200),
    IS_MODIFY         TINYINT,
    CREATED_AT        TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE MEMBER_SKILL
(
    ID         INT AUTO_INCREMENT PRIMARY KEY,
    SKILL_NAME VARCHAR(15) NOT NULL,
    MEMBER_ID  INT NOT NULL
);

CREATE TABLE PROJECT
(
    ID              INT AUTO_INCREMENT PRIMARY KEY,
    PROJECT_NAME    VARCHAR(50) NOT NULL,
    PROJECT_TYPE    VARCHAR(10) NOT NULL,
    SUBJECT         VARCHAR(30) NOT NULL,
    PROJECT_PURPOSE VARCHAR(15) NOT NULL,
    PROJECT_TIME    TINYINT     NOT NULL,
    RECRUIT_COUNT   TINYINT     NOT NULL,
    PROJECT_PROCESS VARCHAR(7)  NOT NULL,
    EXCEPT_DATE     TINYINT     NOT NULL,
    EXCEPT_TIME     TIMESTAMP   NOT NULL,
    PROJECT_INFO    TEXT        NOT NULL,
    STATUS          TINYINT     NOT NULL,
    OWNER_ID        INT         NOT NULL,
    VIEWS           INT,
    GITHUB_LINK     VARCHAR(100),
    IS_SHOW         TINYINT DEFAULT 1,
    IS_END          TINYINT DEFAULT 1,
    IMAGE_URL       VARCHAR(200),
    MODIFIED_SHOW   TIMESTAMP,
    CREATED_AT      TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE PROJECT_SKILL
(
    ID         INT AUTO_INCREMENT PRIMARY KEY,
    SKILL_NAME VARCHAR(15) NOT NULL,
    PROJECT_ID INT         NOT NULL
);

CREATE TABLE RECRUIT_ROLE
(
    ID         INT AUTO_INCREMENT PRIMARY KEY,
    PROJECT_ID INT,
    ROLE_NAME  VARCHAR(6) NOT NULL
);

CREATE TABLE TEAM_NOTE
(
    ID         INT AUTO_INCREMENT PRIMARY KEY,
    TEAM_NAME  VARCHAR(10),
    PROJECT_ID INT
);

-- TODO : CALENDAR 구현 후 테이블 추가

CREATE TABLE SUBSCRIBE
(
    ID         INT AUTO_INCREMENT PRIMARY KEY,
    PROJECT_ID INT NOT NULL,
    MEMBER_ID  INT NOT NULL,
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE BOOKMARK
(
    ID         INT AUTO_INCREMENT PRIMARY KEY,
    MEMBER_ID  INT NOT NULL,
    PROJECT_ID INT NOT NULL
);

CREATE TABLE PROJECT_MEMBER
(
    ID         INT AUTO_INCREMENT PRIMARY KEY,
    PROJECT_ID INT,
    MEMBER_ID  INT
);

CREATE TABLE CHAT
(
    ID         INT AUTO_INCREMENT PRIMARY KEY,
    CONTENT    VARCHAR(100) NOT NULL,
    TEAM_ID    INT,
    MEMBER_ID  INT,
    CREATED_AT TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE KANBAN
(
    ID         INT AUTO_INCREMENT PRIMARY KEY,
    STATUS     VARCHAR(10) NOT NULL,
    TODO       VARCHAR(20) NOT NULL,
    START_DATE TIMESTAMP   NOT NULL,
    END_DATE   TIMESTAMP   NOT NULL,
    TEAM_ID    INT,
    MEMBER_ID  INT
);

CREATE TABLE LIKES
(
    ID         INT AUTO_INCREMENT PRIMARY KEY,
    PROJECT_ID INT,
    MEMBER_ID  INT
);
