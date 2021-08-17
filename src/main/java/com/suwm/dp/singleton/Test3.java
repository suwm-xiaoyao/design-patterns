package com.suwm.dp.singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 */
public class Test3 {
    private static Test3 INSTANCE;

    private Test3() {
    }

    public static Test3 getInstance() {
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Test3();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Test3.getInstance().hashCode())).start();
        }
    }
}
