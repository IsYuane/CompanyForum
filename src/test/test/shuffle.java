package test;


import java.util.*;

public class shuffle {
    static void shuffle(int[] n){
        Integer[] ia={1,2,3,4,5,6};
        List list =Arrays.asList(n);
        Collections.shuffle(list);
        System.out.println(list);
        Iterator iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.print(iterator.next());
        }

    }

    public static void main(String[] args) {
        int[] n = {1,2,3,4,5,6};
        shuffle(n);
    }
}
