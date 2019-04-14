package Improve.Annotation;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.lang.reflect.Method;

/**
 *  简单的测试框架
 *  当主方法执行后，会自动自行被检测的所有方法（加了Check注解的方法），判断方法是否有异常，记录到文件中
 */
public class TestCheck {
    public static void main(String[] args) throws Exception{
        Calculator c = new Calculator();
        // 获取字节码文件
        Class cls = c.getClass();
        // 获取所有方法
        Method[] methods = cls.getMethods();

        int number = 0; //  异常出现的次数
        BufferedWriter bw = new BufferedWriter(new FileWriter("src\\Improve\\Annotation\\bug.txt"));

        for(Method method:methods){
            // 判断方法上是否有Check注解
            if (method.isAnnotationPresent(Check.class)){
                try{
                    method.invoke(c);
                }catch (Exception e){
                    // 捕获并记录异常
                    ++number;
                    bw.write(method.getName() + "方法出异常了");
                    bw.newLine();
                    bw.write("异常的名称：" + e.getCause().getClass().getSimpleName());
                    bw.newLine();
                    bw.write("异常的原因：" + e.getCause().getMessage());
                    bw.newLine();
                    bw.write("----------------------");
                    bw.newLine();
                }
            }
        }

        bw.write("本次测试一共出现 " + number + " 此异常");
        bw.flush();
        bw.close();

    }
}
