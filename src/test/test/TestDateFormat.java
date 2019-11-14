package test;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDateFormat {
    public static void main(String[] args) {
//        MM 月份 mm分钟
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss:SS 本年的第w周 本月的第W周 E");
        Date date = new Date(1000L);
        System.out.println(date);
        String s = df.format(date);
        System.out.println(s);
        System.out.println("****");
        String  s1 = "1970-01-12";
        DateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d2 = df1.parse(s1);
            System.out.println(d2);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
