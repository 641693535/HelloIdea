package javatest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @Description
 * @create 2020-04-24 11:09
 */
public class SystemInOutTest {

    /*
    从键盘输入字符串，要求将读取到的整行字符串转成大写输出。然后继续
    进行输入操作，直至当输入“e”或者“exit”时，退出程序
     */
    public static void main(String[] args) {

        BufferedReader br = null;
        try {
            InputStreamReader isr = new InputStreamReader(System.in);
            br = new BufferedReader(isr);

            while(true){
                String str = br.readLine();
                if(("e".equalsIgnoreCase(str) || "exit".equalsIgnoreCase(str))){
                    break;
                }

                String s = str.toUpperCase();
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(br != null){
                System.out.println("退出成功！");
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
