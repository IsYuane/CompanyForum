package test2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 倒计时
 */
public class SleepDemo01 {
    public static void main(String[] args) {
        Date date =new Date(System.currentTimeMillis());
        long end = date.getTime();
        while(true){
            System.out.println(new SimpleDateFormat("hh:mm:ss").format(date));
            //构建下一秒时间
            date = new Date(date.getTime()-1000);
            if(end-10000>date.getTime()){
                break;
            }
        }
    }
}
