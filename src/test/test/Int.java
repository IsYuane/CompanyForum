package test;

import java.util.*;

public class Int {
    private int i;

    public static void main(String[] args) {
        Int g =new Int();
        Int c =new Int();
        g.i=1;
        c.i=1;
        System.out.println(g.equals(c));
        Map map =new HashMap();
        Object ob = 1;
        Integer ig =(int) ob;
        System.out.println(ig);
        map.put("c",c);
//        LinkedList
        map.put("g",g);
        Set<Integer> set = new HashSet<>();
        List list = new ArrayList();
        set.add(1);
        set.add(2);
        set.add(3);
        Iterator<Integer> it =set.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        list.add(1);
        System.out.println(set.contains(list));
    }

}
