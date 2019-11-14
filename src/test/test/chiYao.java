package test;

import javax.swing.tree.TreeNode;
import java.util.*;

public  class chiYao {
    static Random random = new Random();
    static Map<String,Object> map = new HashMap();


    static int zero =0;
    static int day =0;
    static int count = 0;
    public static void chiYao(){
        for(int i=1;i<=100;i++){
            String str = String.valueOf(i);
            map.put(str,zero);
        }
        Integer a =11;
        a.toString();
        while(count<200){
            int i =random.nextInt(100)+1;
            String j =String.valueOf(i);
//            String j = Integer.toString(i);
            int d =  (int)map.get(j);
            if(d<2){
                d++;
                map.put(j,d);
                day++;
                count++;
                System.out.println("Day "+day+":Pill #"+j);
            }
        }
    }
    public static void main(String[] args){
        chiYao();

    }
}
