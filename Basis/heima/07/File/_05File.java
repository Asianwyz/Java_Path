package heima.File;

/*
    File类创建删除功能的方法
        - public boolean createNewFile()    :   当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
        - public boolean delete()   :   删除由此File表示的文件或目录。
        - public boolean mkdir()    :   创建由此File表示的目录。
        - public boolean mkdirs()   :   创建由此File表示的目录，包括任何必须但不存在的父目录。
 */

import java.io.File;
import java.io.IOException;

public class _05File {
    public static void main(String[] args) throws IOException {
//        show01();
//        show02();
        show03();
    }

    /*
        public boolean delete() :   删除由此File表示的文件或目录
        此方法可以删除构造方法中路径中给出的文件/文件夹
        返回值：布尔值
            true：文件/文件夹删除成功，返回true
            false：文件夹中有内容，不会删除返回false；构造方法中路径不存在，返回false
        注意：
            delete方法是直接在硬盘删除文件/文件夹，不走回收站，删除要谨慎
     */
    private static void show03() {
        File f1 = new File("src\\heima\\File\\test");
        File f2 = new File("src\\heima\\File\\a.java"); //  创建的还是文件夹
//        File f3 = new File("src\\heima\\File\\111\\222\\333\\444");     // 会创建多级文件夹
        File f3 = new File("src\\heima\\File\\111\\222\\333");     // 会创建多级文件夹
        File f4 = new File("hei\\File\\111\\222");
//        File f4 = new File("hei\\File\\111\\222\\333");
        boolean b1 = f1.delete();
        System.out.println("b1: " + b1);
        boolean b2 = f2.delete();
        System.out.println("b2: " + b2);
        boolean b3 = f3.delete();
        System.out.println("b3: " + b3);
        boolean b4 = f4.delete();
        System.out.println("b4: " + b4);
    }

    /*
        public boolean mkdir()  :   创建单级空文件夹
        public boolean mkdirs() :   即可以创建单级空文件夹，也可以创建多级文件夹
        创建文件夹的路径和名称在构造方法中给出（构造方法的参数)
        返回值：布尔值
            true:   文件夹不存在，创建文件夹，返回true
            false:  文件夹存在，不创建，返回false；构造方法中给出的路径不存在，返回false
        注意:
            1. 此方法只能创建文件夹，不能创建文件
     */
    private static void show02() {
        File f1 = new File("src\\heima\\File\\test");
        boolean b1 = f1.mkdir();
        System.out.println("b1: " + b1);

        File f2 = new File("src\\heima\\File\\a.java"); //  创建的还是文件夹
        boolean b2 = f2.mkdir();
        System.out.println("b2: " + b2);

        File f3 = new File("src\\heima\\File\\111\\222\\333\\444");     // 会创建多级文件夹
        boolean b3 = f3.mkdirs();
        System.out.println("b3: " + b3);

        File f4 = new File("hei\\File\\111\\222\\333");
        boolean b4 = f4.mkdirs();
        System.out.println("b4: " + b4);
    }

    /*
        public boolean createNewFile()  :   当且仅当具有该名称的文件尚不存在时，创建一个新的空文件
        创建文件的路径和名称再构造方法中给出（构造方法的参数）
        返回值：布尔值
            true:   文件不存在，创建文件，返回true
            false:  文件存在，不会创建，否则会抛出异常

        public boolean createNewFile() throws IOException
        createNewFile声明抛出了IOException，我们调用这个方法，就必须处理这个异常，要么throws，要么try...catch
     */
    private static void show01() throws IOException {
//        File f1 = new File("C:\\Users\\Asia\\abcd\\a.java");
//        boolean b1 = f1.createNewFile();
//        System.out.println("b1: "  + b1);     // 抛出异常

//        File f2 = new File("D:\\Learning\\code\\asia.java");
//        boolean b2 = f2.createNewFile();
//        System.out.println("b2: " + b2);

        File f3 = new File("src\\heima\\File\\中文.txt"); // 中英不影响
        boolean b3 = f3.createNewFile();
        System.out.println("b3: " + b3);
    }
}
