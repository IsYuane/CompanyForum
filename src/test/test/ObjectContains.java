package test;

import java.util.ArrayList;

public class ObjectContains {
    public static void main(String[] args) {
//        字符串的contains查找是否包含子字符串 ArrayList可以对任意位置进行添加修改、Array不行
//        ArraryList 可以异构存储 Array不行
        ArrayList list = new ArrayList<>(2);
        list.add("a");
        list.add("b");
        list.add(2);
        System.out.println(list);
        list.add(0,"A");
        System.out.println(list);

//        如果原先是String toString不会生成对象相等，而如果原先是int之类的toString不会相等

//        object a=1 false
        Object a="1";
        System.out.println(a.toString()=="1"); //true

//        toLowerCase 会生成一个对象
        System.out.println("ABC".toLowerCase()=="abc"); //false
        System.out.println("ABC".toLowerCase());
        String d = "ABC";
        //不能是字符''
        char c='c';
        String b = ""+c;
        if(d.contains(b)){
            System.out.println("包含");
        }
    }
}
