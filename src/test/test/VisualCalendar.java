package test;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class VisualCalendar {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
        String sCalender = sc.next();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date d  =df.parse(sCalender);
        Calendar calendar =new GregorianCalendar();
        calendar.setTime(d);
        calendar.set(Calendar.DATE,1); //得到 1号的星期天
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        int maxNum = calendar.getActualMaximum(Calendar.DATE);
        System.out.println(d);
        for (int i = 0; i < calendar.get(Calendar.DAY_OF_WEEK)-1; i++) {
            System.out.print("\t");
        }
        for (int i = 1; i <= maxNum; i++) {
            System.out.print(i+"\t");
            int dayWeek = calendar.get(Calendar.DAY_OF_WEEK);
            if(dayWeek==Calendar.SATURDAY){
                System.out.println();
            }
            calendar.add(Calendar.DAY_OF_MONTH,1);
        }
    }
}
