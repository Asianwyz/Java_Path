-- ���ű�
CREATE TABLE dept (
  id INT PRIMARY KEY PRIMARY KEY, -- ����id
  dname VARCHAR(50), -- ��������
  loc VARCHAR(50) -- �������ڵ�
);

-- ���4������
INSERT INTO dept(id,dname,loc) VALUES 
(10,'���в�','����'),
(20,'ѧ����','�Ϻ�'),
(30,'���۲�','����'),
(40,'����','����');



-- ְ���ְ�����ƣ�ְ������
CREATE TABLE job (
  id INT PRIMARY KEY,
  jname VARCHAR(20),
  description VARCHAR(50)
);

-- ���4��ְ��
INSERT INTO job (id, jname, description) VALUES
(1, '���³�', '����������˾���ӵ�'),
(2, '����', '������Ա��'),
(3, '����Ա', '�����������Ʒ'),
(4, '��Ա', 'ʹ�ð칫���');



-- Ա����
CREATE TABLE emp (
  id INT PRIMARY KEY, -- Ա��id
  ename VARCHAR(50), -- Ա������
  job_id INT, -- ְ��id
  mgr INT , -- �ϼ��쵼
  joindate DATE, -- ��ְ����
  salary DECIMAL(7,2), -- ����
  bonus DECIMAL(7,2), -- ����
  dept_id INT, -- ���ڲ��ű��
  CONSTRAINT emp_jobid_ref_job_id_fk FOREIGN KEY (job_id) REFERENCES job (id),
  CONSTRAINT emp_deptid_ref_dept_id_fk FOREIGN KEY (dept_id) REFERENCES dept (id)
);

-- ���Ա��
INSERT INTO emp(id,ename,job_id,mgr,joindate,salary,bonus,dept_id) VALUES 
(1001,'�����',4,1004,'2000-12-17','8000.00',NULL,20),
(1002,'¬����',3,1006,'2001-02-20','16000.00','3000.00',30),
(1003,'�ֳ�',3,1006,'2001-02-22','12500.00','5000.00',30),
(1004,'��ɮ',2,1009,'2001-04-02','29750.00',NULL,20),
(1005,'����',4,1006,'2001-09-28','12500.00','14000.00',30),
(1006,'�ν�',2,1009,'2001-05-01','28500.00',NULL,30),
(1007,'����',2,1009,'2001-09-01','24500.00',NULL,10),
(1008,'��˽�',4,1004,'2007-04-19','30000.00',NULL,20),
(1009,'�޹���',1,NULL,'2001-11-17','50000.00',NULL,10),
(1010,'����',3,1006,'2001-09-08','15000.00','0.00',30),
(1011,'ɳɮ',4,1004,'2007-05-23','11000.00',NULL,20),
(1012,'����',4,1006,'2001-12-03','9500.00',NULL,30),
(1013,'С����',4,1004,'2001-12-03','30000.00',NULL,20),
(1014,'����',4,1007,'2002-01-23','13000.00',NULL,10);



-- ���ʵȼ���
CREATE TABLE salarygrade (
  grade INT PRIMARY KEY,   -- ����
  losalary INT,  -- ��͹���
  hisalary INT -- ��߹���
);

-- ���5�����ʵȼ�
INSERT INTO salarygrade(grade,losalary,hisalary) VALUES 
(1,7000,12000),
(2,12010,14000),
(3,14010,20000),
(4,20010,30000),
(5,30010,99990);

-- 1.��ѯ����Ա����Ϣ����ѯԱ����ţ�Ա�����������ʣ�ְ�����ƣ�ְ������

SELECT 
	t1.`id`, 
	t1.`ename`,
	t1.`salary`,
	t2.`jname`,
	t2.`description`
FROM
	emp t1,
	job t2
WHERE 	
	t1.`job_id` = t2.`id`;
	
-- 2.��ѯԱ����ţ�Ա�����������ʣ�ְ�����ƣ�ְ���������������ƣ�����λ��
SELECT 
	t1.`id`,
	t1.`ename`,
	t1.`salary`,
	t2.`jname`,
	t2.`description`,
	t3.`dname`,
	t3.`loc`
	
FROM
	emp t1,
	job t2,
	dept t3
WHERE
	t1.`job_id` = t2.`id` AND
	t1.`dept_id` = t3.`id`;
	
-- 3.��ѯԱ�����������ʣ����ʵȼ�
SELECT 
	t1.`ename`,
	t1.`salary`,
	t2.`grade`
FROM
	emp t1,
	salarygrade t2
WHERE
	t1.`salary` BETWEEN t2.`losalary` AND t2.`hisalary`;
	
-- 4.��ѯԱ�����������ʣ�ְ�����ƣ�ְ���������������ƣ�����λ�ã����ʵȼ�
SELECT                     
	t1.`ename`,
	t1.`salary`,
	t2.`jname`,
	t2.`description`,
	t3.`dname`,
	t3.`loc`,
	t4.`grade`
FROM
	emp t1,
	job t2,
	dept t3,
	salarygrade t4
WHERE
	t1.`job_id` = t2.`id` AND
	t1.`dept_id` = t3.`id` AND
	t1.`salary` BETWEEN t4.`losalary` AND t4.`hisalary`;
	
-- 5.��ѯ�����ű�š��������ơ�����λ�á���������	
	
SELECT 
	t1.`id`,
	t1.`dname`,
	t1.`loc`,
	t2.number
FROM
	dept t1,
	(SELECT 
		dept_id,
		COUNT(id) number
	FROM
		emp
	GROUP BY 
		dept_id) t2
WHERE 
	t1.id = t2.dept_id;
	
-- 6.��ѯ����Ա������������ֱ���ϼ�������,û���쵼��Ա��Ҳ��Ҫ��ѯ
SELECT 
	t1.`ename`,
	t2.`ename`
FROM
	emp t1
LEFT JOIN
	emp t2
ON
	t1.`mgr` = t2.`id`;
