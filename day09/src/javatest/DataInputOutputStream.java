package javatest;

import org.junit.Test;

import java.io.*;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @Description
 * @create 2020-04-24 17:27
 */

public class DataInputOutputStream {

    /**
     * 数据流的写入
     */
    @Test
    public void test1(){

        DataOutputStream dos = null;
        try {
            dos = new DataOutputStream(new FileOutputStream("data.txt"));

            dos.writeUTF("Renzhibin");
            dos.writeInt(18);
            dos.writeBoolean(true);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (dos != null) {
                try {
                    dos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }
    /**
     * 数据流的输出
     */
    @Test
    public void test2(){
        DataInputStream dis = null;
        try {
            dis = new DataInputStream(new FileInputStream("data.txt"));

            String name = dis.readUTF();
            int age = dis.readInt();
            boolean isMan = dis.readBoolean();
            System.out.println("Name = " + name + ",age = " + age + ",Man=" + isMan);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(dis != null){
                try {
                    dis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }

    }

}
