package com.suwm.dp.singleton;

/**
 * 不仅可以解决线程同步，还可以防止反序列化。
 */
public enum Test8 {
    INSTANCE;

    public void m() {
        System.out.println("m");
    }

    public static void main(String[] args) {
        for(int i=0; i<100; i++) {
            new Thread(()->{
                System.out.println(Test8.INSTANCE.hashCode());
            }).start();
        }
    }
}
