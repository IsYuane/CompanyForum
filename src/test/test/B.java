package test;


import java.util.*;

public class B extends A{
    int x=1,y;
    public B(){
        y=-1;
    }
    public void PrintFields(){
        System.out.println("x="+x+",y="+y);
        System.out.println(a);
        List l =new ArrayList();
        Set s =new HashSet<>();
        Map m = new HashMap();
//        l.addAll(s);
//        l.retainAll(s);//容器取交集

        System.out.println(l.equals(s));
    }

    public static void main(String[] args) {
        //装对象
        List l =new ArrayList();
        List l2 = new ArrayList();

        Set s =new HashSet<>();
        Map m = new HashMap();
//        l.addAll(s);
//        l.retainAll(s);//容器取交集
        l.add(1);
        l2.add(1);
        l2.add(2);
        System.out.println(l.size());
        System.out.println(l.equals(l2));
        l.add(1,1);
        l.addAll(l2);
        String[] a={"a"};
        System.out.println(l.size());
        Arrays.asList(a);

    }
}
