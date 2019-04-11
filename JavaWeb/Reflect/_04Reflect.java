package Improve.Reflect;

import Improve.Person;

import java.lang.reflect.Method;

/*
    Class对象功能：
        * 获取功能：
        1. 获取成员变量们
             * Field[] getFields()
             * Field getField(String name)

             * Field[] getDeclaredFields()
             * Field getDeclaredField(String name)
        2. 获取构造方法们
             * Constructor<?>[] getConstructors()
             * Constructor<T> getConstructor(类<?>... parameterTypes)

             * Constructor<T> getDeclaredConstructor(类<?>... parameterTypes)
             * Constructor<?>[] getDeclaredConstructors()
        3. 获取成员方法们：
             * Method[] getMethods()
             * Method getMethod(String name, 类<?>... parameterTypes)

             * Method[] getDeclaredMethods()
             * Method getDeclaredMethod(String name, 类<?>... parameterTypes)

        4. 获取类名
             * String getName()
 */
public class _04Reflect {
    public static void main(String[] args) throws Exception {
        // 获取Class对象
        Class personClass = Person.class;

        // 获取成员方法
        Method eat_method = personClass.getMethod("eat");
        Person p = new Person();
        // 执行方法
        eat_method.invoke(p);

        Method eat_method1 = personClass.getMethod("eat",String.class);
        // 执行方法
        eat_method1.invoke(p,"饭");

        // 获取所有Public修饰的方法
        Method[] methods = personClass.getMethods();
        for (Method method:methods){
            System.out.println(method);
            String name = method.getName();
            System.out.println(name);
//            method.setAccessible(true);
        }

        // 获取类名
        String className = personClass.getName();
        System.out.println(className);
    }
}
