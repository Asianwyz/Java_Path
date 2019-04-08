package heima.IO;

/*
    文件复制练习：一读一写
    明确:
        数据源
        数据目的地

    文件复制的步骤：
        1. 创建一个字节输入流对象，构造方法中绑定要读取的数据源
        2. 创建一个字节输出流对象，构造方法中绑定要写入的目的地
        3. 使用字节输入流对象中的方法read读取文件
        4. 使用字节输出流中的方法write，把读取的字节写入到目的地的文件中
        5. 释放资源
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _03CopyFile {
    public static void main(String[] args) throws IOException {
        long s = System.currentTimeMillis();
        FileInputStream fis = new FileInputStream("src\\heima\\IO\\2.png");
        FileOutputStream fos = new FileOutputStream("src\\heima\\IO\\3.png");
//        int len = 0;
//        while ((len = fis.read()) != -1){
//            fos.write(len);
//        }

        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1){
            fos.write(bytes);
        }

        long e = System.currentTimeMillis();
        System.out.println(e - s);

        // 释放资源
        fos.close();
        fis.close();
        // 先关闭写的，再关闭读的，如果写完了，肯定读取完毕了
    }
}
