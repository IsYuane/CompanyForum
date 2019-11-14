package test2;

public class TestWeb12306 {
    public static void main(String[] args) {
        Web12306 web12306 = new Web12306();
        Thread thread = new Thread(web12306,"路人甲");
        Thread thread2 = new Thread(web12306,"黄牛一");
        Thread thread3 = new Thread(web12306,"工程师");
        thread.start();
        thread2.start();
        thread3.start();
    }
}
