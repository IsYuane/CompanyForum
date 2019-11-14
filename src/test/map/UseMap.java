package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 *  题目：输出字符串中每个字符出现的次数
 *      this is cat and that is mice and where is the food ?
 *
 *      存储到Map中
 *      key：String
 *      value：自定义 Letter
 */
public class UseMap {

    public static void main(String[] args) {
        String s = "this is cat and that is mice and where is the food ?";
        String[] arrays = new String[3];
        arrays[0]="aa";
        arrays[1]="bb";
        arrays[2]="acc";
        arrays[0].compareTo(arrays[1]);
        System.out.println(arrays[0].compareTo(arrays[2]));
        new UseMap().printLetter(s);
//        Map<String,Letter> map = new HashMap<>();
//        String[] s2 = s.split(" ");
//        Letter letter;
//        for (String temp:s2
//        ) {
//            //没有对象就先new一个对象 有对象的直接取出对象进行放值
//            if((letter=map.get(temp))==null){
//                letter = new Letter();
//                letter.setCount(letter.getCount()+1);
//                map.put(temp,letter);
//            }else {
//                letter.setCount(letter.getCount()+1);
//            }
//
//
//        }
//        //输出map值
//        Set<String> keys = map.keySet();
//        for (String key:keys
//        ) {
//            Letter col = map.get(key);
//            System.out.println("字母："+key+"出现次数："+col.getCount());
//        }
    }
    public void printLetter(String s){
        Map<String,Letter> map = new HashMap<>();
        String[] s2 = s.split(" ");
        Letter letter= null;
        for (String temp:s2
             ) {
            //没有对象就先new一个对象 有对象的直接取出对象进行放值
            if(!map.containsKey(temp)){
                 letter = new Letter();
                map.put(temp,letter);
            }
             letter = map.get(temp);
            letter.setCount(letter.getCount()+1);

        }
        //输出map值
        Set<String> keys = map.keySet();
        Iterator<String> it =  keys.iterator();
        for (String key:keys
             ) {
            Letter col = map.get(key);
            System.out.println("字母："+key+"出现次数："+col.getCount());
        }
    }
}
