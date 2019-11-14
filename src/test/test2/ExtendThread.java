package test2;

import test.ThreadTest;
//
class ExtendThread {
     public static void main(String[] args) {
         new ThreadTest().start();
         new ThreadTest().start();
         new ThreadTest().start();
     }
}
//class ExtendThread {
//    public static void main(String[] args) {
////        ThreadTest runnable = new ThreadTest();
//        new Thread(runnable).start();
//        new Thread(runnable).start();
//        new Thread(runnable).start();
//    }
//}