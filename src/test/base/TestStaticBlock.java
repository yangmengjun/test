package test.base;

/**
 * 测试考查静态语句块、构造语句块（就是只有大括号的那块）以及构造函数的执行顺序。
对象的初始化顺序：
（1）类加载之后，按从上到下（从父类到子类）执行被static修饰的语句；
（2）当static语句执行完之后,再执行main方法；
（3）如果有语句new了自身的对象，将从上到下执行构造代码块、构造器（两者可以说绑定在一起）。
 */
public class TestStaticBlock {
    static {
        System.out.println("父类静态块A");
    }
    /*构造语句块，只有{}*/
    {
        System.out.println("父类默认块B");
    }

    public TestStaticBlock() {
        System.out.println("父类构造器C");
    }

    public static void main(String[] args) {
        System.out.println("-------main start-------");
        new TestChildStaticBlock();
        new TestChildStaticBlock();
        System.out.println("-------main start-------");

        /*将打印：
        父类静态块A
        子类静态块D
        -------main start-------
        父类默认块B
        父类构造器C
        子类默认块E
        子类构造器F
        父类默认块B
        父类构造器C
        子类默认块E
        子类构造器F
        -------main start-------
         * */
    }

}

class TestChildStaticBlock extends TestStaticBlock {
    static {
        System.out.println("子类静态块D");
    }
    {
        System.out.println("子类默认块E");
    }

    public TestChildStaticBlock() {
        System.out.println("子类构造器F");
    }

}