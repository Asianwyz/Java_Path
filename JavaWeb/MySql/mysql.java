
SELECT 
	address
FROM 
	student;
	
-- ȥ���ظ��Ľ����	
SELECT DISTINCT address,NAME FROM student;

-- ����math �� English ����֮��
SELECT NAME , math ��ѧ ,english Ӣ��, math + english FROM student;
SELECT NAME , math ��ѧ ,english Ӣ��, math + IFNULL(english,0) AS �ܷ� FROM student; 

SELECT * FROM student;

SELECT * FROM student WHERE age != 20;

SELECT * FROM student WHERE age >= 20 && age <= 30;
SELECT * FROM student WHERE age >= 20 AND age <= 30;
SELECT * FROM student WHERE BETWEEN 20 AND 30;

--  ��ѯ����22�꣬19�꣬25�����Ϣ
SELECT * FROM student WHERE age = 20 OR age = 18 OR age = 25;
SELECT * FROM student WHERE age IN (20,18,55);

-- ��ѯӢ��ɼ�ΪNULL
SELECT * FROM student WHERE english = NULL; -- ���ԣ�nullֵ����ʹ�� = ����= �� �ж�
SELECT * FROM student WHERE english IS NULL;
SELECT * FROM student WHERE english IS NOT NULL;


-- ģ����ѯ ��ѯ���������Щ  like
SELECT * FROM student WHERE NAME LIKE "��%";

SELECT * FROM student WHERE NAME LIKE "_��%";

SELECT * FROM student WHERE NAME LIKE "___";

-- ��ѯ�����а��������
SELECT * FROM student WHERE NAME LIKE "%��%";
SELECT * FROM student WHERE NAME LIKE "%��%";
