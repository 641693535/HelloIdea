package javatest1;

import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @Description
 * @create 2020-04-25 21:11
 */
public class UDPTest1 {

    /**
     * 发送端
     */
    @Test
    public void send() {
        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket();

            String str = "我是以UDP的形式发送给你的.";
            byte[] data = str.getBytes();
            InetAddress lh = InetAddress.getByName("localhost");
            DatagramPacket packet = new DatagramPacket(data, 0, data.length, lh, 9090);

            socket.send(packet);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }

    /**
     * 接收端
     */
    @Test
    public void receive() {

        DatagramSocket socket = null;
        try {
            socket = new DatagramSocket(9090);

            byte[] b = new byte[1024];
            DatagramPacket packet = new DatagramPacket(b, 0, b.length);

            socket.receive(packet);

            String str = new String(packet.getData(), 0, packet.getLength());

            System.out.println(str);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();

            }
        }

    }

}
