package stringexer;

import org.junit.Test;

/**
 * @author PengYuDeMao    Email:641693535@qq.com
 * @Description
 * @Effects
 * @create 2020-04-09 12:25
 */
public class Exer1 {
    /*
    模拟一个trim方法，去除字符串两端的空格。
     */
    @Test
    public void test1() {
        String str = "  abcde fg  ";
        String s = testTrim(str);
        System.out.println(s);
    }

    public String testTrim(String str) {
        if (str.length() == 0 || str == null) {
            return str;
        }
        int startInt = 0;
        int endInt = str.length() - 1;
        while (startInt < endInt && str.charAt(startInt) == ' ') {
            startInt++;
        }
        while (startInt < endInt && str.charAt(endInt) == ' ') {
            endInt--;
        }
        return str.substring(startInt, endInt);
    }

    /*
    将一个字符串进行反转。将字符串中指定部分进行反转。比如“abcdefg”反转为”abfedcg”

     */
    @Test
    public void test2() {
        String str = "abcdefg";
        String s = reversStr(str, 2, 5);
        System.out.println(s);
    }

    public String reversStr(String str, int startInt, int endInt) {
        //分成三部分：
        //第一部分
//        String newStr = str.substring(0, startInt);
        //第二部分
//        for(int i = endInt;i >= startInt;i--){
//            newStr += str.charAt(i);
//            newStr = newStr + str.substring(i, i + 1);
//        }
        //第三部分
//        newStr = newStr.concat(str.substring(endInt + 1));
//        newStr += str.substring(endInt + 1, str.length() - 1);
//        return newStr;
        //分成三部分的改进
        StringBuilder newStr = new StringBuilder(str.length());
        newStr.append(str.substring(0, startInt));
        for (int i = endInt; i >= startInt; i--) {
            newStr.append(str.charAt(i));
        }
        newStr.append(str.substring(endInt + 1));
        return new String(newStr);
    }

    /*
    获取一个字符串在另一个字符串中出现的次数。
    比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
     */
    @Test
    public void test3() {
        String str = "abkkcadkabkebfkabkskab";
        int ab = getCount(str, "ab");
        System.out.println(ab);
    }

    public int getCount(String mainStr, String subStr) {
        int count = 0;
        int index = 0;
        //变换角标的方式
//        while((index = mainStr.indexOf(subStr, index)) >= 0){
//            count++;
//            index = index + subStr.length();
//        }
        //变换字符串的方式
        while ((index = mainStr.indexOf(subStr)) >= 0) {
            count++;
            mainStr = mainStr.substring(index + subStr.length());
        }
        return count;
    }
    /*
    获取两个字符串中最大相同子串。比如：
    str1 = "abcwerthelloyuiodef“;str2 = "cvhellobnm"
    提示：将短的那个串进行长度依次递减的子串与较长的串比较。
     */
    @Test
    public void test4(){
        String maxStr = "abcwerthelloyuiodef";
        String minStr = "cvbnmhello";
        String maxStr1 = getMaxStr(maxStr, minStr);
        System.out.println(maxStr1);

    }
    public String getMaxStr(String mainStr,String subStr){
        String maxStr = (mainStr.length() > subStr.length())? mainStr : subStr;
        String minStr = (mainStr.length() > subStr.length())? subStr : mainStr;

        String maxString;
        for (int index = 0; index < minStr.length(); index++) {//设置去掉几个字符
            for (int i = 0, j = minStr.length() - index; j <= minStr.length(); i++, j++) {
                if(maxStr.contains(minStr.substring(i, j))){
                    return new String(minStr.substring(i, j));
                }
            }
        }
        return null;
    }
}
