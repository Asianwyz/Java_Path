package heima.B_S_Server;
/*
    创建BS版本TCP服务器
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();

//        while ((len = is.read(bytes)) != -1){
//            System.out.println(new String(bytes,0,len));
//        }

        // 把is网络字节输入流对象，转换为字符缓冲输入流
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        // 把客户端请求信息的第一行读取出来 GET /web/index.html HTTP/1.1
        String line = br.readLine();
        String[] arr = line.split(" ");
        String htmlpath = arr[1].substring(1);
        System.out.println(htmlpath);
        // 创建一个本地字节输入流，绑定要读取的HTML路径
        FileInputStream fis = new FileInputStream(htmlpath);
        OutputStream os = socket.getOutputStream();

        // 写入HTTP协议响应头，固定写法
        os.write("HTTP/1.1 200 OK\r\n".getBytes());
        os.write("Content-Type:text/html\r\n".getBytes());
        os.write("\r\n".getBytes());

        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = fis.read(bytes)) != -1){
            os.write(bytes,0,len);
        }


        is.close();
        socket.close();
        server.close();
    }
}
