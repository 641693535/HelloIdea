package javatest1;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @Description 客户端发送内容给服务端，服务端将内容打印到控制台上。
 * @create 2020-04-25 18:12
 */
public class TCPTest1 {

    /**
     * 模拟客户端
     */
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;

        try {
            //1. 创建目的地IP/端口号
            InetAddress lh = InetAddress.getByName("localhost");
            socket = new Socket(lh, 64169);

            //2. 创建端口的流文件
            os = socket.getOutputStream();

            //3. 向Socket传数据
            os.write("Hello,这是一条来自客户端的数据~~~".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(os != null){
                //4. 关闭资源
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 模拟服务端
     */
    @Test
    public void server(){
        ServerSocket ss = null;
        Socket accept = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;

        try {
            //1. 新建一个ServerSocket，并指明本地端口号
            ss = new ServerSocket(64169);

            //2. 接收来自端口的Socket
            accept = ss.accept();

            //3. 获取接收到的流
            is = accept.getInputStream();

            //4. 创建流文件，写入、保存Socket传递的数据
            baos = new ByteArrayOutputStream();

            byte[] b = new byte[1024];
            int len;
            while((len = is.read(b)) != -1){
                baos.write(b, 0, len);
            }

            System.out.println(baos.toString());
            System.out.println("接收到来自：" + accept.getInetAddress().getHostAddress() + "的数据！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(baos != null){
                //5.流的关闭
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(baos != null){
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(baos != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(baos != null){
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
