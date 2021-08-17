package com.suwm.dp.singleton;

/**
 * lazy loading
 * 也称懒汉式
 * 虽然达到了按需初始化的目的，但却带来线程不安全的问题
 * 可以通过synchronized解决，但也带来效率下降
 */
public class Test4 {

    private static Test4 INSTANCE;

    private Test4(){

    }

    public static synchronized Test4 getInstance(){
        if (INSTANCE == null) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            INSTANCE = new Test4();
        }
        return INSTANCE;
    }

    public void m() {
        System.out.println("test");
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Test4.getInstance().hashCode())).start();
        }
    }
}
