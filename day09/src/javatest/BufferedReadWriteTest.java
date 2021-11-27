package javatest;

import org.junit.Test;

import java.io.*;

/**
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description
 * @Effects
 * @create 2020-04-23 19:52
 */
public class BufferedReadWriteTest {

    @Test
    public void test1(){
        long start = System.currentTimeMillis();

        copyBufferedReadWrite("dbcp.txt", "dbcp1.txt");

        long end = System.currentTimeMillis();

        System.out.println("复制完成！共耗时:" + (end - start));
    }

    public void copyBufferedReadWrite(String src,String dest){

        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new FileReader(new File(src)));
            bw = new BufferedWriter(new FileWriter(new File(dest)));

            //方式一：
//            String str;
//            while((str = br.readLine()) != null){
//                bw.write(str);
//                bw.newLine();
//            }
            //方式二：
            char[] c = new char[10];
            int len;
            while((len = br.read(c)) != -1){
                bw.write(c, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
