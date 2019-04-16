# 创建部门表
USE asia;

SHOW TABLES;

CREATE TABLE dept(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20)
);

INSERT INTO dept (NAME) VALUES ('开发部');
INSERT INTO dept (NAME) VALUES ('市场部');
INSERT INTO dept (NAME) VALUES ('财务部');

SELECT * FROM dept;

# 创建员工表
CREATE TABLE emp (
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(10),
	gender CHAR(1), -- 性别
	salary DOUBLE, -- 工资
	join_date DATE, -- 入职日期
	dept_id INT,
	FOREIGN KEY (dept_id) REFERENCES dept(id) -- 外键，关联部门表(部门表的主键)
);

INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('孙悟空','男',7200,'2013-02-24',1);
INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('猪八戒','男',3600,'2010-12-02',2);
INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('唐僧','男',9000,'2008-08-08',2);
INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('白骨精','女',5000,'2015-10-07',3);
INSERT INTO emp(NAME,gender,salary,join_date,dept_id) VALUES('蜘蛛精','女',4500,'2011-03-14',1);

SELECT * FROM emp;

SELECT * FROM emp, dept;

-- 查询所有员工信息和对应的部门信息
SELECT * FROM emp, dept WHERE emp.`dept_id` = dept.`id`;

-- 查询员工表的名称，性别。 部门表的名称  
SELECT emp.name, emp.`gender`, dept.`name` FROM emp, dept WHERE emp.`dept_id` = dept.`id`;

SELECT
	t1.name, 	-- 员工表姓名
	t1.gender, 	-- 员工表性别
	t2.name		--  部门表名称
FROM
	emp t1, dept t2
WHERE 
		t1.`dept_id` = t2.`id`;


SELECT * FROM emp INNER JOIN dept ON emp.`dept_id` = dept.id;
SELECT * FROM emp JOIN dept ON emp.`dept_id` = dept.id;

-- 查询所有员工信息，如果员工有部门，则查询部门名称，没有部门，则不显示部门名称

SELECT t1.*, t2.name FROM emp t1 LEFT JOIN dept t2 ON t1.`dept_id`=t2.`id`;
SELECT t1.*, t2.name FROM emp t1 RIGHT JOIN dept t2 ON t1.`dept_id`=t2.`id`;

SELECT * FROM dept t2 RIGHT JOIN emp t1 ON t1.`dept_id`=t2.`id`;


-- 查询工资最高的员工信息
-- 1. 查询最高的工资是多少
SELECT MAX(salary) FROM emp;
-- 2. 查询员工信息，并且工资等于9000的
SELECT * FROM emp WHERE emp.`salary` = 9000;

-- 一条SQL就完成这个操作
  SELECT * FROM emp WHERE emp.`salary` = (SELECT MAX(salary) FROM emp);

-- 查询员工工资小于平均工资的人
SELECT * FROM emp WHERE emp.`salary` <= (SELECT AVG(salary) FROM emp);

-- 查询财务部所有的员工的信息
SELECT id FROM dept WHERE NAME = '财务部' OR NAME = '市场部';
SELECT * FROM emp WHERE dept_id = 3 OR dept_id = 2;

SELECT * FROM emp WHERE dept_id IN (SELECT id FROM dept WHERE NAME = '财务部' OR NAME ='市场部');

-- 查询员工入职日期是2011-11-11日之后的员工信息和部门信息
-- 子连接
SELECT * FROM dept t1, (SELECT * FROM emp WHERE emp.`join_date` > '2011-11-11') t2
WHERE t1.`id` = t2.dept_id;

-- 普通内连接
  SELECT * FROM emp t1, dept t2 WHERE t1.`dept_id` = t2.`id` AND t1.`join_date` > '2011-11-11';

