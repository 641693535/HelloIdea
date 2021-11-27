package javatest;

import org.junit.Test;

import java.io.*;

/**
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description
 * @Effects
 * @create 2020-04-22 15:54
 */
public class ReadAndReadTest {
    @Test
    public void test1() {
        FileReader readFile = null;
        FileWriter writeFile = null;
        try {
            //创建文件目录 指定目录
            File read = new File("hello.txt");
            File write = new File("Copyhello.txt");

            //创建流文件
            readFile = new FileReader(read);
            writeFile = new FileWriter(write);

            //读取和写入文件
            char[] cbuf = new char[5];
            int len;//记录每次返回的数据长度
            while((len = readFile.read(cbuf)) != -1){
                writeFile.write(cbuf, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流资源
            if(readFile != null){
                try {
                    readFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(writeFile != null){
                try {
                    writeFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
