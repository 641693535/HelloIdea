package someexer;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 1. 利用File构造器，new 一个文件目录file
 * 1)在其中创建多个文件和目录
 * 2)编写方法，实现删除file中指定文件的操作
 * 2. 判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
 * 3. 遍历指定目录所有文件名称，包括子文件目录中的文件。
 * 拓展1：并计算指定目录占用空间的大小
 * 拓展2：删除指定文件目录及其下的所有文件
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description
 * @Effects
 * @create 2020-04-21 21:41
 */
public class SomeExerTest {

    /*
     * 1. 利用File构造器，new 一个文件目录file
     * 1)在其中创建多个文件和目录
     * 2)编写方法，实现删除file中指定文件的操作
     */
    @Test
    public void test1() throws IOException {
        File file = new File("E:\\MyIOTest\\file");
        if(file.mkdirs()){
            System.out.println("创建成功");
        }

        //创建多个文件或目录
        File destFile1 = new File(file.getParent(),"MyTxt.txt");
        File myMuLu1 = new File(file.getParent(), "MyMuLu1");
        destFile1.createNewFile();
        myMuLu1.mkdirs();

        //删除file中指定的文件
        File myMuLu11 = new File(file.getParent(), "MyMuLu1");
        File file1 = new File(file.getParent(), "MyTxt.txt");
        myMuLu11.delete();
        file1.delete();
    }

    @Test
    public void test2(){
        /*
        2. 判断指定目录下是否有后缀名为.jpg的文件，如果有，就输出该文件名称
         */
        File file = new File("E:\\MyIOTest");

        String[] list = file.list();
        for(String s : list){
            boolean b = s.endsWith(".jpg");
            if(b){
                System.out.println(s);
            }
        }
    }
    @Test
    public void test3(){
        /*
         3. 遍历指定目录所有文件名称，包括子文件目录中的文件。
         * 拓展1：并计算指定目录占用空间的大小
         * 拓展2：删除指定文件目录及其下的所有文件
         */
        File file = new File("E:\\MyIOTest");

        printName(file);
    }
    public void printName(File file){
        File[] files = file.listFiles();
        for(File f : files){
            if(f.isDirectory()){
                printName(f);
            }else{
                System.out.println(f.getName());
            }
        }
    }
    @Test
    public void test4(){
        //拓展1：并计算指定目录占用空间的大小
        File file = new File("E:\\MyIOTest");

        long big = 0;
        big = howBig(file,big);
        System.out.println(file.getPath() + "内文件总共占用" + big + "个字节！");

    }
    public long howBig(File file,long big){
        File[] files = file.listFiles();
        for (File f : files) {
            if(f.isDirectory()){
                howBig(f,big);
            }else{
                big += f.length();
            }
        }
        System.out.println(big+ "&&&&&&");
        return big;
    }


}
