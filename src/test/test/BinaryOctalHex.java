package test;

public class BinaryOctalHex {
    static int a=10;
    static int k;
    int j=3;
    private void aVoid(){
        System.out.println(j);
    }
    public static void main(String[] args) {
        new BinaryOctalHex().aVoid();
        System.out.println(k);
        //八种基本类型数据类型 六种数字、char、boolean 0为false 1为true
        //除基本类型可以直接赋值外 其他类型都为引用类型 从常量池中找到常量、从堆里找到对象
        //其他类型初始默认为null 成员变量会自动初始化 方法不会;
        //byte -128-127
        //short 正负 3w 总数65536
        //char 范围 65536
        //int 正负 21亿
        //当数大于21亿时候 后面加L 把常量int型转为long  8个字节
        //自动转换 低容量转换为高容量 int特例可以转byte short char 只要不超过范围
        //大类型给小类型要强制转为 int = (int)(long +int) --->不然会报错
        // 一个long类型数不能赋给int
        //float浮点数4个字节 表示范围3.4*10^38 比long大 long可以转但是可能会损失精度
        // double 1.7*10^308
        long b = 12345678910L;
        //L放前面避免前面运算溢出
        long f = 30L*1000*29;
        byte c =1;
        //65+32=97为a 65 为A
        char d = 97;
        System.out.println(d);
        System.out.println(Integer.toBinaryString(a));//二进制
        System.out.println(Integer.toOctalString(a));//八进制
        System.out.println(Integer.toHexString(a));//十六进制
        //小数默认double 需要加F/f
        //浮点数存在舍入误差 为什么 4字节比int 4字节表示范围大？
        //需要精确浮点数可以使用BigDecimal 银行 还有一个比long大的 BigInteget
        float m =0.1f; //1e-1f
        double m1 = 1.0/10;
        System.out.println(m1); //0.1
        System.out.println(m); //0.1
        System.out.println(m==m1); // 但是仍然是false 舍入误差m1实际0.99...?
        System.out.println("**");
        Integer a1=10000;
        System.out.println(a1); //自动拆箱
        Integer a2=1234;
        Integer a3=1234;
        System.out.println(a2==a3); //false 如果[-128,127]则true 范围内 编译器扔当做基本类型来处理
    }
}
