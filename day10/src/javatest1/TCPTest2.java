package javatest1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @Description 客户端发送文件给服务端，服务端将文件保存在本地。
 * @create 2020-04-25 19:16
 */
public class TCPTest2 {

    /**
     * 客户端
     */
    @Test
    public void client(){
        Socket socket = null;
        OutputStream os = null;
        try {
            InetAddress lh = InetAddress.getByName("localhost");
            socket = new Socket(lh, 6464);

            os = socket.getOutputStream();

            BufferedInputStream bis = new BufferedInputStream(new FileInputStream("爱情与友情.jpg"));

            byte[] b = new byte[1024];
            int len;
            while ((len = bis.read(b)) != -1) {
                os.write(b,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(os != null){
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
     * 服务端
     */
    @Test
    public void server(){

        ServerSocket ss = null;
        Socket accept = null;
        InputStream is = null;
        BufferedOutputStream bos = null;
        try {
            ss = new ServerSocket(6464);

            accept = ss.accept();

            is = accept.getInputStream();

            //创建保存的文件路径
            File file = new File("爱情与友情1.jpg");
            bos = new BufferedOutputStream(new FileOutputStream(file));

            byte[] b = new byte[1024];
            int len;
            while((len = is.read(b)) != -1){
                bos.write(b, 0, len);
            }

            System.out.println("接收到来自:" + accept.getInetAddress().getHostAddress() + "的数据！" +
                    "已保存在" + file.getPath());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //资源的关闭
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (accept != null) {
                try {
                    accept.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (ss != null) {
                try {
                    ss.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

}
