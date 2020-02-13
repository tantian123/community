CREATE TABLE QUESTION
(
	ID INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
	TITLE VARCHAR(50),
	DESCRIPTION TEXT,
	GMT_CREATE BIGINT,
	GMT_MODIFIED BIGINT,
    CREATOR INT,
    COMMENT_COUNT INT DEFAULT 0,
	VIEW_COUNT int DEFAULT 0,
	LIKE_COUNT int DEFAULT 0,
	TAG VARCHAR(256)
);
