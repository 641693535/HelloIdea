package javatest;

import org.junit.Test;

import java.io.*;

/**
 * @author RZBstart    Email:641693535@qq.com
 * @Description
 * @create 2020-04-24 1:02
 */
public class InputStreamReadOutputStreamWrite {

    @Test
    public void test1() {

        FileInputStream fis = null;
        OutputStreamWriter osw = null;
        try {
            fis = new FileInputStream(new File("dbcp.txt"));
            FileOutputStream fos = new FileOutputStream(new File("dbcp_gbk.txt"));

            InputStreamReader isr = new InputStreamReader(fis,"utf-8");
            osw = new OutputStreamWriter(fos,"gbk");

            char[] c = new char[1024];
            int len;
            while((len = isr.read(c)) != -1){
                osw.write(c, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(osw != null){
                try {
                    osw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
