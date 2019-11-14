package test2;

import java.util.concurrent.*;

//Callable 可以有返回值 可以声明异常 throws Runnable 捕获
public class Call {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //创建线程
        ExecutorService service = Executors.newFixedThreadPool(2);
        Race tortoise =new Race("乌龟",2000);
        Race rabbit = new Race("兔子",200);
        //获取值
        Future<Integer> result1 = service.submit(tortoise); //Future未来的 获取值 .get 获取返回值
        Future<Integer> result2 = service.submit(rabbit);//放实现类

        Thread.sleep(2000);
        tortoise.setFlag(false);
        rabbit.setFlag(false);

        int num1= result1.get();
        int num2= result2.get();
        System.out.println("乌龟跑了"+num1+"步");
        System.out.println("兔子跑了"+num2+"步");
        Thread.sleep(4000);
        System.out.println("乌龟跑了"+num1+"步");
        System.out.println("兔子跑了"+num2+"步");
        //停止服务
        service.shutdownNow();

    }
}
class Race implements Callable<Integer> {
    private String name;
    private long time;
    private boolean flag=true;
    private int step=0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public Race(String name, long time) {
        this.name = name;
        this.time = time;
    }

    @Override
    public Integer call() throws Exception {
        while(flag){
            Thread.sleep(time);
            step++;
        }
        return step;
    }
}
