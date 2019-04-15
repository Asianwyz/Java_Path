CREATE TABLE emp (
id INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(30),
age INT,
dep_name VARCHAR(30),
dep_location VARCHAR(30)
);
-- �������
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('����', 20, '�з���', '����');
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('����', 21, '�з���', '����');
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('����', 20, '�з���', '����');
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('����', 20, '���۲�', '����');
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('����', 22, '���۲�', '����');
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('С��', 18, '���۲�', '����');

SELECT * FROM emp
-- ��������
-- ��Ĳ��





-- ����������ֳ� 2 �ű�
-- �������ű�(id,dep_name,dep_location)
-- һ��������

CREATE TABLE department(
	id INT PRIMARY KEY AUTO_INCREMENT,
	dep_name VARCHAR(20),
	dep_location VARCHAR(20)
);


-- ����Ա����(id,name,age,dep_id)
-- �෽���ӱ�

CREATE TABLE employee(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	age INT,
	dep_id INT, -- �����Ӧ���������
	CONSTRAINT emp_dept FOREIGN KEY (dep_id) REFERENCES department(id)
);


-- ��� 2 ������

INSERT INTO department VALUES(NULL, '�з���','����');
INSERT INTO department VALUES(NULL, '���۲�', '����');

SELECT * FROM department;

-- ���Ա��,dep_id ��ʾԱ�����ڵĲ���

INSERT INTO employee (NAME, age, dep_id) VALUES ('����', 20, 1);
INSERT INTO employee (NAME, age, dep_id) VALUES ('����', 21, 1);
INSERT INTO employee (NAME, age, dep_id) VALUES ('����', 20, 1);
INSERT INTO employee (NAME, age, dep_id) VALUES ('����', 20, 2);
INSERT INTO employee (NAME, age, dep_id) VALUES ('����', 22, 2);
INSERT INTO employee (NAME, age, dep_id) VALUES ('С��', 18, 2);


SELECT * FROM employee;

SELECT * FROM department;

DROP TABLE emp;
DROP TABLE department;
DROP TABLE employee;

-- ɾ�����
ALTER TABLE employee DROP FOREIGN KEY emp_dept;

-- �����������ü�������
 ALTER TABLE employee ADD CONSTRAINT emp_dept FOREIGN KEY 
(dep_id) REFERENCES department(id) ON UPDATE CASCADE ON DELETE CASCADE;
