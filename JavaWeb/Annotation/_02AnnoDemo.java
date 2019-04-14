package Improve.Annotation;

import java.util.Date;

/**
 * JDK中预定义的一些注解
 *      * @Override : 检测被该注解标注的方法是否是继承自父类（接口）的
 *      * @Deprecated   :   该注解标注的内容，表示已过时
 *      * @SupperssWarnings :   压制警告
 */
@SuppressWarnings("all")
@MyAnno3

public class _02AnnoDemo {
    @Override
    public String toString(){
        return super.toString();
    }

    @Deprecated
    public void show1(){
        // 有缺陷
    }

    @MyAnno(value = 12,per = Person.P1,anno2 = @MyAnno2(),args = {"aaa","bbb"})
    public void show2(){
        // 替代show1方法
    }

    public void demo(){
        show1();
        Date date = new Date();
    }
}
