package test;


import java.util.LinkedList;
import java.util.List;

/**
 * 经典算法-出圈 n个人 围成一圈 数到3或者3的倍数就出去，问最后剩下来的人的位置。
 */
public class OutCircle {

    public static Integer out(int total, int key) {
        List<Integer> list = new LinkedList<>();
        for (int i = 1; i <= total; i++) list.add(i);//循环赋值初始位置。从1开始。
        int index = -1; //下标从0开始 ， 初始化为-1；
        while (list.size() > 1) {
            index = (index + key) % list.size(); //对总数取余。 index+key，表示每次数key（3）个数
            list.remove(index--);//把当前元素删除，然后下标-1.
        }
        return list.get(0);//返回最后一个元素的最开始的位置。
    }

    public static void main(String[] args) {
        System.out.println("最后剩下的人的位置：" + out(3, 3));//打印出来
    }
}
