package heima.Buffer;

import java.io.*;
import java.util.HashMap;

public class _05Test {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("src\\heima\\Buffer\\chushibiao.txt"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("src\\heima\\Buffer\\csb.txt"));
        HashMap<String,String> map = new HashMap<>();
        String line;
        while ((line = br.readLine()) != null){
            String[] arr = line.split("\\.");
            map.put(arr[0],arr[1]);
        }
        for(String key : map.keySet()){
            String value = map.get(key);
            line = key + ". " + value;
            bw.write(line);
            bw.newLine();
        }
        bw.close();
        br.close();
    }
}
