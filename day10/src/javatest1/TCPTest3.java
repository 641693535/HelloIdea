package javatest1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @Description 从客户端发送文件给服务端，服务端保存到本地。
 *              并返回“发送成功”给客户端。并关闭相应的连接。
 * @create 2020-04-25 19:56
 */
public class TCPTest3 {

    /**
     * 客户端
     */
    @Test
    public void client() {
        Socket lh = null;
        OutputStream os = null;
        BufferedInputStream bis = null;
        InputStream is = null;
        ByteArrayOutputStream baos = null;
        try {
            lh = new Socket(InetAddress.getByName("localhost"), 35353);

            os = lh.getOutputStream();

            bis = new BufferedInputStream(new FileInputStream("爱情与友情.jpg"));

            int len;
            byte[] b = new byte[1024];
            while((len = bis.read(b)) != -1){
                os.write(b,0,len);
            }
            //关闭输出文件操作，表明文件已经传完毕了
            lh.shutdownOutput();

            //接收来自服务端的数据
            is = lh.getInputStream();
            baos = new ByteArrayOutputStream();
            int len1;
            byte[] b1 = new byte[1024];
            while((len1 = is.read(b1)) != -1){
                baos.write(b1);
            }
            lh.shutdownInput();
            System.out.println(baos);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (baos != null) {
                try {
                    baos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (lh != null) {
                try {
                    lh.close();
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
        OutputStream os = null;
        try {
            ss = new ServerSocket(35353);

            accept = ss.accept();

            is = accept.getInputStream();

            bos = new BufferedOutputStream(new FileOutputStream("爱情与友情2.jpg"));

            int len;
            byte[] b = new byte[1024];
            while ((len = is.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            //关闭输入文件操作，表明文件已经传完毕了
            accept.shutdownInput();

            //返回传输成功的回复数据
            os = accept.getOutputStream();
            os.write("Hello，文件我已经收到了！照片的寓意很美好~".getBytes());
            accept.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (os != null) {
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if (is != null) {
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
