package test;

import java.util.Scanner;

public class BestShortStr {

    public static int bestShortStr(String str){
        //我在这里有一次使用了sb = s = new StringBuilder() 这是不行的这样
        //这样只new了一个dioxide sb和s相等
        StringBuilder sb=new StringBuilder();
        StringBuilder s=new StringBuilder();
        for(int i=0; i < str.length();i++){
            s.setLength(0);
            s.append(str.charAt(i));
            //contains放 int char类型都会报错
            //这里的contains竟然可以放缓冲区？
            //难道是因为StringBuilder是用来解决字符串拼接问题？
            if(!sb.toString().contains(s)){
                sb.append(s);
            }
        }
//        s.insert(1,'a'); 往原先位置插入字符 其后字符往后退一位
        return sb.length();
    }

    public static void main(String[] args) {
        Scanner scanner =new Scanner(System.in);
        String str = scanner.next();//空格后不算
        System.out.println(bestShortStr(str));
    }
}
