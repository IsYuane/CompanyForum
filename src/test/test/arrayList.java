package test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class arrayList {
    static ArrayList arrayList =new ArrayList();
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args) {
        list.toArray();
        arrayList.add(1);
        arrayList.add(3);
        arrayList.add(2);
        arrayList.add(10);
        arrayList.add(4);
        Iterator iterator = arrayList.iterator();
        while(iterator.hasNext()){
//            String str = (String) iterator.next();
            System.out.println(iterator.next());
        }
    }
}
