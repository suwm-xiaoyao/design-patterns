package com.suwm.dp.singleton;

/**
 * 饿汉式
 * 类加载到内存后，就实例化一个单例，JVM保证线程安全
 * 简单实用，推荐使用！
 * 唯一缺点：不管用到与否，类装载时就完成实例化
 * Class.forName("")
 * （话说你不用的，你装载它干啥）
 */
public class Test1 {

    private static final Test1 INSTANCE = new Test1();

    private Test1() {

    }

    public static Test1 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        Test1 t1 = Test1.getInstance();
        Test1 t2 = Test1.getInstance();
        System.out.println(t1 == t2);
    }

}
