# �������ű�
USE asia;

SHOW TABLES;

CREATE TABLE dept(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20)
);

INSERT INTO dept (NAME) VALUES ('������');
INSERT INTO dept (NAME) VALUES ('�г���');
INSERT INTO dept (NAME) VALUES ('����');

SELECT * FROM dept;

# ����Ա����
CREATE TABLE emp (
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(10),
	gender CHAR(1), -- �Ա�
	salary DOUBLE, -- ����
	join_date DATE, -- ��ְ����
	dept_id INT,
	FOREIGN KEY (dept_id) REFERENCES dept(id) -- ������������ű�(���ű������)
);

INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('�����','��',7200,'2013-02-24',1);
INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('��˽�','��',3600,'2010-12-02',2);
INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('��ɮ','��',9000,'2008-08-08',2);
INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('�׹Ǿ�','Ů',5000,'2015-10-07',3);
INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('֩�뾫','Ů',4500,'2011-03-14',1);

SELECT * FROM emp;

SELECT * FROM emp, dept;

-- ��ѯ����Ա����Ϣ�Ͷ�Ӧ�Ĳ�����Ϣ
SELECT * FROM emp, dept WHERE emp.`dept_id` = dept.`id`;

-- ��ѯԱ��������ƣ��Ա� ���ű������  
SELECT emp.name, emp.`gender`, dept.`name` FROM emp, dept WHERE emp.`dept_id` = dept.`id`;

SELECT
	t1.name, 	-- Ա��������
	t1.gender, 	-- Ա�����Ա�
	t2.name		--  ���ű�����
FROM
	emp t1, dept t2
WHERE 
		t1.`dept_id` = t2.`id`;


SELECT * FROM emp INNER JOIN dept ON emp.`dept_id` = dept.id;
SELECT * FROM emp JOIN dept ON emp.`dept_id` = dept.id;

-- ��ѯ����Ա����Ϣ�����Ա���в��ţ����ѯ�������ƣ�û�в��ţ�����ʾ��������

SELECT t1.*, t2.name FROM emp t1 LEFT JOIN dept t2 ON t1.`dept_id`=t2.`id`;
SELECT t1.*, t2.name FROM emp t1 RIGHT JOIN dept t2 ON t1.`dept_id`=t2.`id`;

SELECT * FROM dept t2 RIGHT JOIN emp t1 ON t1.`dept_id`=t2.`id`;


-- ��ѯ������ߵ�Ա����Ϣ
-- 1. ��ѯ��ߵĹ����Ƕ���
SELECT MAX(salary) FROM emp;
-- 2. ��ѯԱ����Ϣ�����ҹ��ʵ���9000��
SELECT * FROM emp WHERE emp.`salary` = 9000;

-- һ��SQL������������
  SELECT * FROM emp WHERE emp.`salary` = (SELECT MAX(salary) FROM emp);

-- ��ѯԱ������С��ƽ�����ʵ���
SELECT * FROM emp WHERE emp.`salary` <= (SELECT AVG(salary) FROM emp);

-- ��ѯ�������е�Ա������Ϣ
SELECT id FROM dept WHERE NAME = '����' OR NAME = '�г���';
SELECT * FROM emp WHERE dept_id = 3 OR dept_id = 2;

SELECT * FROM emp WHERE dept_id IN (SELECT id FROM dept WHERE NAME = '����' OR NAME ='�г���');

-- ��ѯԱ����ְ������2011-11-11��֮���Ա����Ϣ�Ͳ�����Ϣ
-- ������
SELECT * FROM dept t1, (SELECT * FROM emp WHERE emp.`join_date` > '2011-11-11') t2
WHERE t1.`id` = t2.dept_id;

-- ��ͨ������
  SELECT * FROM emp t1, dept t2 WHERE t1.`dept_id` = t2.`id` AND t1.`join_date` > '2011-11-11';

