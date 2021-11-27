package javatest1;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @Description
 * @create 2020-04-25 16:53
 */
public class InetAddressTest {

    @Test
    public void test1(){

        try {
            InetAddress inet1 = InetAddress.getByName("www.baidu.com");

            System.out.println(inet1);

            InetAddress inet2 = InetAddress.getLocalHost();

            System.out.println(inet2);

            String hostName = InetAddress.getLocalHost().getHostName();
            String hostAddress = InetAddress.getLocalHost().getHostAddress();
            System.out.println(hostName);
            System.out.println(hostAddress);

        } catch (UnknownHostException e) {
            e.printStackTrace();
        }


    }

}
