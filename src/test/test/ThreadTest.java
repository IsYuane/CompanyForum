package test;

public class ThreadTest extends Thread {

    @Override
    public void run() {
//        super.run();
//        Thread.yield(); 静态 阻塞本线程
        System.out.println(Thread.currentThread().getName()+"执行run中");
        System.out.println(Thread.currentThread().getName()+"执行完毕");
    }
}
//
//public class ThreadTest implements Runnable {
//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName() + "执行run中");
//        System.out.println(Thread.currentThread().getName() + "执行完毕");
//    }
//}
class C {
    public static void main(String[] args) {
        System.out.println("a");
    }
}
