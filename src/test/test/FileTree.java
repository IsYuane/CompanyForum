package test;

import java.io.File;

/**
 * 树状文件
 */

public class FileTree {
    public static void main(String[] args) {
        File f =new File("C:/Users/user/Desktop/omo.txt");
        printFile(f,0);
//        Integer a = new Integer("12"); √
//        FileReader;
//        FileInputStream;
    }
    public static void printFile(File f,int level){
        for (int i = 0; i < level; i++) {
            System.out.print("-");
        }
        System.out.println(f.getName());
        if(f.isDirectory()){
            File[] files = f.listFiles();
            for (File temp:files
                 ) { printFile(temp,level+1);

            }
        }
    }
}
