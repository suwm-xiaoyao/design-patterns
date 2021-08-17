package com.suwm.dp.singleton;

/**
 * 静态内部类方式
 * JVM保证单例
 * 加载外部类时不会加载内部类，这样可以实现懒加载
 */
public class Test7 {
    private Test7() {

    }

    private static class Test7Holder {
        private static final Test7 INSTANCE = new Test7();
    }

    public static Test7 getInstance() {
        return Test7Holder.INSTANCE;
    }

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for(int i=0; i<100; i++) {
            new Thread(()->{
                System.out.println(Test7.getInstance().hashCode());
            }).start();
        }
    }
}
