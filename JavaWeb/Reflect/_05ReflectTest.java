package Improve.Reflect;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 框架演示类
 *      可以创建任意类的对象，可以执行任意方法
 * 前提：
 *      不能改变该类的任何代码。可以创建任意类的对象，可以执行任意方法
 *
 * 1. 加载配置文件
 * 2. 获取配置文件中定义的数据
 * 3. 加载该类进内存
 * 4. 创建对象
 * 5. 获取方法对象
 * 6. 执行方法
 */

public class _05ReflectTest {
    public static void main(String[] args) throws Exception {

        // 创建Properties对象
        Properties pro = new Properties();
        ClassLoader classLoader = _05ReflectTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        pro.load(is);

        // 获取配置文件中定义的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");

        // 加载该类进内存
        Class cls = Class.forName(className);
        // 创建对象
        Object obj = cls.newInstance();
        // 获取对象方法
        Method method = cls.getMethod(methodName);
        // 执行方法
        method.invoke(obj);
    }
}
