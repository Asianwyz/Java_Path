package heima.File;

import java.io.File;
import java.io.FileFilter;

public class _09Filter {
    public static void main(String[] args) {
        File file = new File("src");
        getAllFile(file);
    }

    private static void getAllFile(File file) {
        File[] files = file.listFiles(new FileFilter(){
            @Override
            public boolean accept(File pathname){
                return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".java");
            }
        });
        for (File f :files){
            if (f.isDirectory()){
                getAllFile(f);
            }
            else{
                System.out.println(f);
            }
        }
    }
}
