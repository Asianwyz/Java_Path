CREATE TABLE emp (
id INT PRIMARY KEY AUTO_INCREMENT,
NAME VARCHAR(30),
age INT,
dep_name VARCHAR(30),
dep_location VARCHAR(30)
);
-- 添加数据
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('张三', 20, '研发部', '广州');
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('李四', 21, '研发部', '广州');
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('王五', 20, '研发部', '广州');
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('老王', 20, '销售部', '深圳');
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('大王', 22, '销售部', '深圳');
INSERT INTO emp (NAME, age, dep_name, dep_location) VALUES ('小王', 18, '销售部', '深圳');

SELECT * FROM emp
-- 数据冗余
-- 表的拆分





-- 解决方案：分成 2 张表
-- 创建部门表(id,dep_name,dep_location)
-- 一方，主表

CREATE TABLE department(
	id INT PRIMARY KEY AUTO_INCREMENT,
	dep_name VARCHAR(20),
	dep_location VARCHAR(20)
);


-- 创建员工表(id,name,age,dep_id)
-- 多方，从表

CREATE TABLE employee(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	age INT,
	dep_id INT, -- 外键对应主表的主键
	CONSTRAINT emp_dept FOREIGN KEY (dep_id) REFERENCES department(id)
);


-- 添加 2 个部门

INSERT INTO department VALUES(NULL, '研发部','广州');
INSERT INTO department VALUES(NULL, '销售部', '深圳');

SELECT * FROM department;

-- 添加员工,dep_id 表示员工所在的部门

INSERT INTO employee (NAME, age, dep_id) VALUES ('张三', 20, 1);
INSERT INTO employee (NAME, age, dep_id) VALUES ('李四', 21, 1);
INSERT INTO employee (NAME, age, dep_id) VALUES ('王五', 20, 1);
INSERT INTO employee (NAME, age, dep_id) VALUES ('老王', 20, 2);
INSERT INTO employee (NAME, age, dep_id) VALUES ('大王', 22, 2);
INSERT INTO employee (NAME, age, dep_id) VALUES ('小王', 18, 2);


SELECT * FROM employee;

SELECT * FROM department;

DROP TABLE emp;
DROP TABLE department;
DROP TABLE employee;

-- 删除外键
ALTER TABLE employee DROP FOREIGN KEY emp_dept;

-- 添加外键，设置级联更新
 ALTER TABLE employee ADD CONSTRAINT emp_dept FOREIGN KEY 
(dep_id) REFERENCES department(id) ON UPDATE CASCADE ON DELETE CASCADE;
