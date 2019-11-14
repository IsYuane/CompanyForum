package test;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class TestCalendar {
    public static void main(String[] args) {
        Calendar c = new GregorianCalendar();
        c.set(2001,2,1);
        System.out.println(c.getTime()); //没设置的时间为当前时间 得到DATA类
        c.set(Calendar.YEAR,1998);
        System.out.println(c.get(Calendar.YEAR)+" "+c.getTime());
        c.add(Calendar.YEAR,-1); // 去1997年
        System.out.println(c.getTime());
    }
}
