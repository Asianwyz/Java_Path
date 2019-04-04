package heima.File;

/*
    创建过滤器FileFilter的实现类，重写过滤方法accept，定义过滤规则
 */

import java.io.File;
import java.io.FileFilter;

public class FileFilterImpl implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        if (pathname.isDirectory())
            return true;

        return pathname.getName().toLowerCase().endsWith(".java");
    }
}
