package test;

import static java.lang.Boolean.FALSE;
import static java.lang.Boolean.TRUE;

public class BubbleSort {
    static void bubbleSort(int[] ints){
        int n = ints.length;
        int temp;
        boolean change = TRUE;
        for (int i = 0; i <n-1 &&change; i++) {
            change =FALSE;
            for(int j = 0; j < n-1-i ; j++){
                if(ints[j] > ints[j+1]){
//                    ints[j]=ints[j]+ints[j+1];
//                    ints[j+1]=ints[j]-ints[j+1];
//                    ints[j]=ints[j]-ints[j+1];
                    ints[j]=ints[j]^ints[j+1];
                    ints[j+1]=ints[j]^ints[j+1];
                    ints[j]=ints[j]^ints[j+1];
                    change = TRUE;
                }
            }
        }
    }
    public static void main(String[] args){
        int[] a = {9,5,1,1,2,5,2,7};
        bubbleSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
