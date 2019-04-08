package heima.IO;

/*
    java.io.Writer: 字符输出流，是所有字符输出流的最顶层的父类，是一个抽象类

    共性的成员方法：
        - void write(int c) 写入单个字符
        - void write(char[] cbuf) 写入字符数组
        - abstract void write(char[] cbuf, int off, int len) 写入字符数组的某一部分，off数组的开始索引，len写的字符个数
        - void write(String str) 写入字符串
        - void flush() 刷新该流的缓冲
        - void close() 关闭此流，但要先刷新它
        flush方法和close方法的区别
            - flush ：刷新缓冲区，流对象可以继续使用。
            - close:  先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用了。

    java.io.FileWriter extends OutputStreamWriter extends Writer
    FileWriter 文件字符输出流
    作用：把内存中字符数组写入文件中
    构造方法：
        FileWriter(File file) 根据给定的File对象构造一个FileWriter对象
        FileWriter(String fileName) 根据给定的文件名构造一个FileWriter对象

    使用：
        1. 创建
        2. 使用：write方法，把数组写入到内存缓冲区中（字符转换为字节的过程）
        3. 刷新：把内存缓冲区的数据，刷新到文件中
        4. 释放资源（会先把内存缓存区中的数据刷新到文件中）
 */

import java.io.FileWriter;
import java.io.IOException;

public class _05Writer {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("src\\heima\\IO\\d.txt");
//        FileWriter fw = new FileWriter("src\\heima\\IO\\d.txt",true); // 追加和续写

        fw.write(99);
        fw.flush();

        char[] cs = {'a','b','c','d','e'};
        fw.write(cs);
        fw.write("亚洲风Style");
        fw.write("亚洲风Style",2,3);
        fw.close();
    }
}
