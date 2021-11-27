package javatest;

import org.junit.Test;

import java.io.*;

/**
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description
 * @Effects
 * @create 2020-04-23 18:13
 */
public class BufferedInputOutputTest {

    @Test
    public void test1(){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File("爱情与友情.jpg")));
            bos = new BufferedOutputStream(new FileOutputStream(new File("爱情与友情Test.jpg")));

            //读取和写入的过程
            byte[] b = new byte[10];
            int len;
            while((len = bis.read(b)) != -1){
                bos.write(b,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bis != null){
                //关闭
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
    /*
    将复制封装到方法中
     */
    @Test
    public void test2(){

        long start = System.currentTimeMillis();

        copyInputOut("爱情与友情.jpg", "爱情与友情1.jpg");

        long end = System.currentTimeMillis();

        System.out.println("复制完成！共花费时间：" + (end - start));

    }

    public void copyInputOut(String srcFile,String destFile){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(new File(srcFile)));
            bos = new BufferedOutputStream(new FileOutputStream(new File(destFile)));

            byte[] b = new byte[10];
            int len;
            while((len = bis.read(b)) != -1){
                bos.write(b,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    /*
    有缓冲流和无缓冲流的对比
     */
    @Test
    public void test3(){

        long start = System.currentTimeMillis();

        fileInputOutputTest("爱情与友情.jpg", "爱情与友情2.jpg");

        long end = System.currentTimeMillis();

        System.out.println("复制成功！所耗费的时间为:" + (end - start));

    }

    public void fileInputOutputTest(String src, String dest) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(new File(src));
            fos = new FileOutputStream(new File(dest));

            //具体的复制过程
            byte[] b = new byte[10];
            int len;
            while((len = fis.read(b)) != -1){
                fos.write(b,0,len);
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
            if(fos != null){
                //关闭流
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
