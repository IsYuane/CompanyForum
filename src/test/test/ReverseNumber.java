package test;


import java.util.Scanner;
import java.lang.*;

public class ReverseNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        scanner.close();
        int result = reverse(num);
        System.out.println(result);
    }

    public static int reverse(int num) {
        String s = String.valueOf(num);
        StringBuffer sb = new StringBuffer();
        char zf = s.charAt(0);
        if (zf != '-') {
            zf = '-';
            sb.append(zf);
            for (int i = s.length() - 1; i >= 0; i--) {
                sb.append(s.charAt(i));
            }
        } else{
            for (int i = s.length() - 1; i > 0; i--) {
                sb.append(s.charAt(i));
            }
        }

        String st = sb.toString();
        int last = Integer.valueOf(st);
        return last;
    }
}