package heima.File;

/*
    练习：
        递归打印多级目录
 */

import java.io.File;

public class _07RecursionFile {
    public static void main(String[] args) {
        File file = new File("src");
        getAllFile(file);
    }

    private static void getAllFile(File file) {
        System.out.println(file);
        File[] files = file.listFiles();
        for (File ff:files
             ) {
            if (ff.isDirectory()){
                getAllFile(ff);
            }
            else{
                System.out.println(ff);
            }
        }
    }
}
