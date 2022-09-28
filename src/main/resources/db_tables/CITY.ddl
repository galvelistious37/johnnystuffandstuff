DROP TABLE CITY;

CREATE TABLE CITY (
	CITY_ID		INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    STATE_ID	INT,
    CITY_NAME	VARCHAR(20),

    CONSTRAINT FK_STATE
    FOREIGN KEY (STATE_ID)
    REFERENCES STATE(STATE_ID)
);

INSERT INTO CITY (CITY_NAME, STATE)
VALUES ('Portland', 'OR');