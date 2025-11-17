create database bankmanagementsystem;

show databases;

use bankmanagementsystem;

create table signup(formno varchar(20), name varchar(20), father_name varchar(20), dob varchar(20), gender varchar(20), email varchar(30), address varchar(40), city varchar(20), pincode varchar(20), state varchar(20));

show tables;

select* from signup;

USE bankmanagementsystem;

alter table signup modify column marital_status varchar(20) after email;

USE bankmanagementsystem;

CREATE TABLE IF NOT EXISTS signup2 (
  formno VARCHAR(20) NOT NULL PRIMARY KEY,
  religion VARCHAR(50),
  category VARCHAR(50),
  income VARCHAR(50),
  education VARCHAR(100),
  occupation VARCHAR(100),
  pan VARCHAR(20),
  aadhar VARCHAR(30),
  senior_citizen VARCHAR(5),
  existing_account VARCHAR(5)
);

show tables;

show columns from signup2;

USE bankmanagementsystem;

CREATE TABLE IF NOT EXISTS signup3 (
  formno       VARCHAR(20) NOT NULL PRIMARY KEY,
  account_type VARCHAR(100),
  card_no      VARCHAR(32),
  pin          VARCHAR(8),
  facilities   VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS login (
  formno  VARCHAR(20) NOT NULL,
  cardno  VARCHAR(32) NOT NULL,
  pin     VARCHAR(8) NOT NULL,
  PRIMARY KEY (cardno),
  KEY idx_formno (formno)
);

show tables;
select* from signup3;

CREATE TABLE IF NOT EXISTS bank (
    pin VARCHAR(20),
    date VARCHAR(50),
    type VARCHAR(20),
    amount VARCHAR(20)
);

show tables;

show columns from bank;

USE bankmanagementsystem;

ALTER TABLE bank CHANGE COLUMN `type` `mode` VARCHAR(20);

SHOW COLUMNS FROM bank;

ALTER TABLE bank DROP COLUMN type;

USE bankmanagementsystem;
select * from bank;
-- 3) Compute the balance using a robust SQL that handles 'mode' or 'type' column
SELECT
  SUM(
    CASE
      WHEN TRIM(mode) = 'Deposit' THEN CAST(TRIM(amount) AS DECIMAL(12,2))
      WHEN TRIM(mode) IN ('Withdrawl','Withdrawal') THEN -CAST(TRIM(amount) AS DECIMAL(12,2))
      ELSE 0
    END
  ) AS balance
FROM bank
WHERE pin = 'THEPIN';
SELECT pin, mode, amount, LENGTH(IFNULL(mode,'')) AS mode_len, LENGTH(IFNULL(amount,'')) AS amt_len
FROM bank
WHERE pin = '7831'
ORDER BY date DESC;

DROP TABLE IF EXISTS bank;

CREATE TABLE bank (
    pin VARCHAR(10),
    date_time VARCHAR(50),
    mode VARCHAR(20),
    amount INT
);
