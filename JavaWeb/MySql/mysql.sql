
SELECT 
	address
FROM 
	student;
	
-- 去除重复的结果集	
SELECT DISTINCT address,NAME FROM student;

-- 计算math 和 English 分数之和
SELECT NAME , math 数学 ,english 英语, math + english FROM student;
SELECT NAME , math 数学 ,english 英语, math + IFNULL(english,0) AS 总分 FROM student; 

SELECT * FROM student;

SELECT * FROM student WHERE age != 20;

SELECT * FROM student WHERE age >= 20 && age <= 30;
SELECT * FROM student WHERE age >= 20 AND age <= 30;
SELECT * FROM student WHERE BETWEEN 20 AND 30;

--  查询年龄22岁，19岁，25岁的信息
SELECT * FROM student WHERE age = 20 OR age = 18 OR age = 25;
SELECT * FROM student WHERE age IN (20,18,55);

-- 查询英语成绩为NULL
SELECT * FROM student WHERE english = NULL; -- 不对，null值不能使用 = （！= ） 判断
SELECT * FROM student WHERE english IS NULL;
SELECT * FROM student WHERE english IS NOT NULL;


-- 模糊查询 查询姓马的有哪些  like
SELECT * FROM student WHERE NAME LIKE "马%";

SELECT * FROM student WHERE NAME LIKE "_化%";

SELECT * FROM student WHERE NAME LIKE "___";

-- 查询姓名中包含马的人
SELECT * FROM student WHERE NAME LIKE "%马%";
SELECT * FROM student WHERE NAME LIKE "%德%";
