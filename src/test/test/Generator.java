package test;

import java.util.*;

public class Generator {
    private static long count;
    private static final String s = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final int length = s.length();
    private static Random random = new Random();


    private static List<String> codeList =new ArrayList<>();

    public static String generate(){
        boolean has= false;
        StringBuffer stringBuffer = new StringBuffer();
        while(!has){
            stringBuffer.setLength(0);
            for (int i = 0; i <4 ; i++) {
                int i1 = random.nextInt(length);
                stringBuffer.append(s.charAt(i1));
            }
            if(!codeList.contains(stringBuffer.toString())){
                has =true;
                synchronized (Generator.class){
                    count++;
                }
                codeList.add(stringBuffer.toString());
            }
        }
        return stringBuffer.toString();
    }
    public static void main(String[] args){
        for (int i = 0; i < 100; i++) {
            System.out.println(generate());
        }
        System.out.println(count);
    }
}
