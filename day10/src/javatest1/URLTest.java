package javatest1;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author RZBlegion    Email:641693535@qq.com
 * @Description
 * @create 2020-04-25 21:49
 */
public class URLTest {

    public static void main(String[] args) {

        HttpURLConnection urlConnection = null;
        InputStream is = null;
        FileOutputStream fos = null;
        try {
            URL url = new URL("https://pic3.zhimg.com/v2-16d29f724b44d47caa7c2f0561b08088_1200x500.jpg");

            urlConnection = (HttpURLConnection) url.openConnection();

            urlConnection.connect();

            is = urlConnection.getInputStream();
            fos = new FileOutputStream("day10\\IdeaJPG.jpg");

            int len;
            byte[] b = new byte[1024];
            while ((len = is.read(b)) != -1) {
                fos.write(b, 0, len);
            }

            System.out.println("下载完成~！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
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
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

    }

}
