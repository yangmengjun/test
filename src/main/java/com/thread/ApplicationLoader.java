package com.thread;

public class ApplicationLoader extends ThreadGroup {

    private ApplicationLoader() {

        super("ApplicationLoader");

    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("hello");
        super.uncaughtException(t, e);
    }

    public static void main(String args[]) {

        Runnable addStarter = new Runnable() {
            public void run() {
                //在这里调用我们自己的程序的入口函数
                //MyApplication.main(args);
                int[] a = { 1, 2, 3 };
                for (int i = 0; i < a.length; i++) {
                    System.out.println(a[i + 1]);
                }

            }

        };
        try {
            //把我们自己的程序当作这个线程组的一个线程来运行            
            new Thread(new ApplicationLoader(), addStarter).start();
        } catch (IndexOutOfBoundsException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

class StackVars {
    private int        instVar;
    private static int staticVar;

    //存取堆栈变量
    void stackAccess(int val) {
        int j = 0;
        for (int i = 0; i < val; i++) {
            j += 1;
        }
    }

    //存取类的实例变量
    void instanceAccess(int val) {
        for (int i = 0; i < val; i++) {
            instVar += 1;
        }
    }

    //存取类的 static 变量
    void staticAccess(int val) {
        for (int i = 0; i < val; i++) {
            staticVar += 1;
        }
    }
}