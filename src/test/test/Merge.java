package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Merge {

    /** @param array1 有序子数组1
     * @param array2 有序子数组2
     * @return 合并之后的数组
     */
    public static int[] mergeAnother(int[] array1,int[] array2){
        long begin = System.currentTimeMillis();

        int[] result = new int[array1.length+array2.length];
        int i = 0;  //数组1下标
        int j = 0;  //数组2下标
        int k = 0;  //合并数组下标

        while(i<array1.length && j<array2.length){
            if(array1[i]>array2[j]){
                result[k++] = array1[i++];
            }else{
                result[k++] = array2[j++];
            }
        }
        while(i<array1.length)
        {
            result[k++] = array1[i++];
        }
        while(j<array2.length)
        {
            result[k++] = array1[j++];
        }
        long end = System.currentTimeMillis();
        System.out.println("使用while耗时："+(end-begin)+"ms");
        return result;
    }
    public static int[] merge(int[] array1,int[]array2){
        long begin = System.currentTimeMillis();
        List<Integer> list = new ArrayList<>();
        int[] result =new int[array1.length+array2.length];
        for (int i = 0; i < array1.length; i++) {
            list.add(array1[i]);
        }
        for (int i = 0; i < array2.length; i++) {
            list.add(array2[i]);
        }
        Collections.sort(list);
        for (int i = list.size(), index =0;i>0;i-- ){
            result[index++] = list.get(i-1);
        }
        long end = System.currentTimeMillis();
        System.out.println("使collection方法耗时："+(end-begin)+"ms");
        return result;
    }
    public static void main(String[] args){
        int[] ary1 = {99,92,87,80};
        int[] ary2 = {98,90,82};
        int[] result = merge(ary1,ary2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
        System.out.println();
        result = mergeAnother(ary1,ary2);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }
    }
}
