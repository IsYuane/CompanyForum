package test2;

public class Web12306 implements Runnable{
    private int num =50;
    @Override
    public void run() {
        for (int i = 0; i < num; i++) {
            System.out.println(Thread.currentThread().getName()+"抢到票了");
        }
    }
}
