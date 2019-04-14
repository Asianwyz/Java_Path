package Improve.Annotation;

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

@ProAnno(className = "Improve.Annotation.Demo1",methodName = "show")
public class ReflectTest {
    public static void main(String[] args) throws Exception {
        // 1. 解析注解
        // 1.1 获取该类的字节码文件对象
        Class<ReflectTest> reflectTestClass = ReflectTest.class;
        // 2. 获取上边的注解对象
        ProAnno anno = reflectTestClass.getAnnotation(ProAnno.class);
    }
}
