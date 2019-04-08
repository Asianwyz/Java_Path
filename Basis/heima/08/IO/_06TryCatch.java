package heima.IO;
/*
    JDK7的新特性
    在try的后边可以增加一个(),在括号中可以定义流对象
    那么这个流对象的作用域就在try中有效
    try中的代码执行完毕,会自动把流对象释放,不用写finally
    格式:
        try(定义流对象;定义流对象....){
            可能会产出异常的代码
        }catch(异常类变量 变量名){
            异常的处理逻辑
        }
 */
/*
    JDK9新特性
    try的前边可以定义流对象
    在try后边的()中可以直接引入流对象的名称(变量名)
    在try代码执行完毕之后,流对象也可以释放掉,不用写finally
    格式:
        A a = new A();
        B b = new B();
        try(a,b){
            可能会产出异常的代码
        }catch(异常类变量 变量名){
            异常的处理逻辑
        }
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _06TryCatch {
    public static void main(String[] args) throws IOException {
//        FileInputStream fis = new FileInputStream("src\\heima\\IO\\2.png");
//        FileOutputStream fos = new FileOutputStream("src\\heima\\IO\\4.png");
//        try(fis;fos){
//            int len = 0;
//            byte[] bytes = new byte[1024];
//            while ((len = fis.read(bytes)) != -1){
//                fos.write(bytes);
//            }
//        }catch(IOException e){
//            System.out.println(e);
//        }
        try(        FileInputStream fis = new FileInputStream("src\\heima\\IO\\2.png");
                    FileOutputStream fos = new FileOutputStream("src\\heima\\IO\\4.png");){
            int len = 0;
            byte[] bytes = new byte[1024];
            while ((len = fis.read(bytes)) != -1){
                fos.write(bytes);
            }
        }catch(IOException e){
            System.out.println(e);
        }
    }
}
