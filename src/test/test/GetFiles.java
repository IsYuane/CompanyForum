package test;

import java.io.File;

public class GetFiles {
    static int count;

    public static void getFile(String filepath) {
        File file =new File(filepath);
//        file.delete()
//        file.createNewFile()创建路径新文件 需要抛出异常 or 捕获异常
//        file.mkdir()创建目录 mkdirs 创建不存在的多重目录  返回boolean
        File[] filelist = file.listFiles();
        for (int i = 0; i < filelist.length; i++) {
            if (!filelist[i].isDirectory()){
                System.out.println(filelist[i]); //直接getPath()得到路径+文件名
                //getParen() 父目录
                System.out.println("**");
                System.out.println(filelist[i].getParent());
                count++;
            }else{
                getFile(filelist[i].toString());
            }
        }
    }

    public static void main(String[] args) {
        getFile("C:\\Users\\user\\Desktop\\C");
        System.out.println(count);
    }
}
