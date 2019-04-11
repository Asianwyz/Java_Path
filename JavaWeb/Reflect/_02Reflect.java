package Improve.Reflect;

import Improve.Person;

import java.lang.reflect.Field;

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
public class _02Reflect {
    public static void main(String[] args) throws Exception {
        // 获取Class对象
        Class personClass = Person.class;
        /*
            1. 获取成员变量
                Field[] getFields() 获取所有public修饰的成员变量
                Field getField(String name)
                Field[] getDeclaredFields() 获取所有的成员变量，不考虑修饰符
                Field getDeclaredField(String name)
         */
        Field[] fields = personClass.getFields();
        for(Field field:fields){
            System.out.println(field);
        }
        System.out.println("------------");

        Field a = personClass.getField("a");
        Person p = new Person();
        // 获取成员变量a的值
        Object value = a.get(p);
        System.out.println(value);
        // 设置a的值
        a.set(p,"张三");
        System.out.println(p);
        System.out.println("-------------");

        Field[] declaredFields = personClass.getDeclaredFields();
        for (Field field : declaredFields){
            System.out.println(field);
        }
        Field d = personClass.getDeclaredField("d");
        d.setAccessible(true);  // 暴力反射，可以获取设置非public成员变量值
        Object value2 = d.get(p);
        System.out.println(value2);
        d.set(p,"李四");
        System.out.println(p);

        // 2. 获取构造方法
    }
}
