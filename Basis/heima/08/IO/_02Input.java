package heima.IO;

/*
    java.io.InputStream 字节输入流
    此抽象类是表示字节输入流的所有类的超类。

    定义了所有子类共性的方法
        int read() 从输入流中读取数据的下一个字节
        int read(byte[] b) 从输入流中读取一定数量的字节，并将其春初在缓冲区数组 b 中
        void close() 关闭此输入流并释放与该流关联的所有系统资源。

    java.io.FileInputStream extends InputStream
    FileInputStream: 文件字节输入流
    作用： 把硬盘文件中的数据，读取到内存中使用
    构造方法；
        FileInputStream(String name)
        FileInputStream(File file)
        参数: 读取文件的数据源
            String name : 文件的路径
            File file : 文件
        构造方法的作用：
            1. 会构建一个FileInputStream 对象
            2. 会把FileInputStream对象指定构造方法中要读取的文件

    读取数据的原理（硬盘--->内存）
        java程序 --> JVM --> OS --> OS读取数据的方法 --> 读取文件

    字节输入流的使用步骤：
        1. 创建FileInputStream对象，构造方法中绑定要读取的数据源
        2. 使用FileInputStream对象中的方法read，读取文件
        3. 释放资源
 */

import java.io.FileInputStream;
import java.io.IOException;

public class _02Input {
    public static void main(String[] args) throws IOException {
        // 1. 创建FileInputStream对象，构造方法中绑定要读取的数据源
        FileInputStream fis = new FileInputStream("src\\heima\\IO\\c.txt");
        int len = 0;    // 记录读取到的单个字节
        while((len = fis.read()) != -1){
            System.out.println((char)len);    // a b c
        }

        /*
            一次读取多个字节
            int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中。
            方法返回的int值是每次读取的有效字节个数
         */

        FileInputStream fis1 = new FileInputStream("src\\heima\\IO\\c.txt");
        byte[] bytes = new byte[1024];
        int len1 = 0;
        while ((len1 = fis1.read(bytes)) != -1){
            // String(byte[], int offset, int length) 把字节数组的一部分转换为字符串 offset: 数组的开始索引 length：转换的字节个数
            System.out.println(new String(bytes,0,len1));
            System.out.println(len1);
        }

        fis.close();
        fis1.close();
    }
}
