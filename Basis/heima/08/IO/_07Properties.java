package heima.IO;

/*
    java.util.Properties集合 extends Hashtable<k,v> implements Map<k,v>
    Properties 类表示了一个持久的属性集。Properties 可保存在流中或从流中加载
    Properties 集合是一个唯一和IO流相结合的集合
        可以使用Properties集合中的方法store，把集合中的临时数据，持久化写入到硬盘中存储
        可以使用Properties集合中的方法load，把硬盘中保存的文件（键值对），读取到集合中使用
    属性列表中每个键及其对应值都是一个字符串。
        Properties集合是一个双列集合，key和value默认都是字符串
 */

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;

public class _07Properties {
    public static void main(String[] args) throws IOException {
//        show01();
//        show02();
        show03();
    }
    /*
    可以使用Properties集合中的方法load,把硬盘中保存的文件(键值对),读取到集合中使用
    void load(InputStream inStream)
    void load(Reader reader)
    参数:
        InputStream inStream:字节输入流,不能读取含有中文的键值对
        Reader reader:字符输入流,能读取含有中文的键值对
    使用步骤:
        1.创建Properties集合对象
        2.使用Properties集合对象中的方法load读取保存键值对的文件
        3.遍历Properties集合
    注意:
        1.存储键值对的文件中,键与值默认的连接符号可以使用=,空格(其他符号)
        2.存储键值对的文件中,可以使用#进行注释,被注释的键值对不会再被读取
        3.存储键值对的文件中,键与值默认都是字符串,不用再加引号
 */
    private static void show03() throws IOException {
        Properties prop = new Properties();
        prop.load(new FileReader("src\\heima\\IO\\prop.txt"));
        Set<String> set = prop.stringPropertyNames();
        for (String str :
                set) {
            String value = prop.getProperty(str);
            System.out.println(str + " = " + value);
        }
    }

    /*
        可以使用Properties集合中的方法store , 把集合中的临时数据，持久化写入到硬盘中存储
        void store(OutputStream out, String comments)
        void store(Writer writer, String comments)
        参数:
            OutputStream out:字节输出流， 不能写入中文
            Writer writer:字符输出流,可以写中文
            String comments:注释,用来解释说明保存的文件是做什么用的
                    不能使用中文,会产生乱码,默认是Unicode编码
                    一般使用""空字符串
     */
    private static void show02() throws IOException {
        Properties prop = new Properties();
        prop.setProperty("Asia","170");
        prop.setProperty("亚洲","172");
        prop.setProperty("洛璃","171");

        FileWriter fw = new FileWriter("src\\heima\\IO\\prop.txt");
        prop.store(fw,"Save data");
    }

    /*
        使用Properties集合存储数据，遍历取出Properties集合中的数组
        Properties集合有一个双列集合，Key和value默认都是字符串
        Properties集合有一些操作字符串的特有方法
            Object setProperties(String key, String value) 调用 Hashtable的方法 put
            String getProperties(String key) 通过key找到value值，此方法相当于Map集合中的get(key)方法
            Set<String> stringPropertiesNames() 返回此属性列表中的键值，其中该键及其对应值是字符串，此方法相当于Map集合中的keySet方法
     */
    private static void show01() {
        Properties prop = new Properties();
        prop.setProperty("Asia","170");
        prop.setProperty("Asia1","172");
        prop.setProperty("Asia2","171");
        Set<String> set = prop.stringPropertyNames();

        for (String str :
                set) {
            String value = prop.getProperty(str);
            System.out.println(str + "=" + value);
        }
    }
}
