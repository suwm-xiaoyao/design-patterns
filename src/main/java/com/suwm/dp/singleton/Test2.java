package com.suwm.dp.singleton;

/**
 * 跟01是一个意思
 */
public class Test2 {
    private static final Test2 INSTANCE;

    static {
        INSTANCE = new Test2();
    }

    private Test2() {
    }

    public static Test2 getInstance() {
        return INSTANCE;
    }

    public void m() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        Test2 t1 = Test2.getInstance();
        Test2 t2 = Test2.getInstance();
        System.out.println(t1 == t2);
    }
}
