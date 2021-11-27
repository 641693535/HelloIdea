package javatest;

import org.junit.Test;

import java.io.*;

/**
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description
 * @Effects
 * @create 2020-04-22 19:00
 */
public class JPGReadAndWriteTest {

    @Test
    public void test1() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //创建file文件路径
            File file = new File("爱情与友情.jpg");
            File newFile = new File("Copy爱情与友情.jpg");

            //创建流
            fis = new FileInputStream(file);
            fos = new FileOutputStream(newFile);

            //读取和写入
            byte[] b = new byte[10];
            //方式一：
//            int len;
//            while((len = fis.read(b)) != -1){
//                fos.write(b, 0, len);
//            }
            //方式二：
            int len = fis.read(b);
            while(len != -1){
                fos.write(b, 0, len);
                len = fis.read(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流文件
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
