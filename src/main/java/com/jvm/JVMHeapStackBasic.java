package com.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * 面向对象：堆和栈的完美结合
 * 
 * 
 * 堆  ===>数据 （存放的数据【对象】由JVM自动进行管理）
 * 所有实例域、 静态域和数组元素都存储在堆内存中
 * 1.<strong>java 中几乎所有的对象都放在堆里,并且完全都是自动化管理的，通过垃圾回收机制，而不需要显示的释放</strong>
 * 2.最常用的结构是将java堆分为新生代和老年代
 * 
 * <br>
 * 栈 ===>逻辑，执行单元，指令（常用于存放对象引用和基本数据类型，而不用于存储对象）
 * 1.栈只有入栈和出栈两种操作
 * 2.线程执行的基本行为是方法的调用，而每次方法调用的数据都是都过java栈传递的
 * 3.每次函数调用都会生成相应的栈帧，从而占用一定的栈空间
 * 4.局部变量表是栈帧的重要组成部分，用于保存函数的参数和局部变量。局部变量只会在当前函数中使用，当函数直接结束，栈帧销毁，局部变量表会随之销毁
 *  
 *java中的基本数据类型一定存储在栈中的吗？”这句话肯定是错误的
 *在类中声明的变量是成员变量，也叫全局变量，放在堆中的（因为全局变量不会随着某个方法执行结束而销毁）。

       同样在类中声明的变量即可是基本类型的变量 也可是引用类型的变量

       （1）当声明的是基本类型的变量其变量名及其值放在堆内存中的

       （2）引用类型时，其声明的变量仍然会存储一个内存地址值，该内存地址值指向所引用的对象。引用变量名和对应的对象仍然存储在相应的堆中

 此外，为了反驳观点" Java的基本数据类型都是存储在栈的 "，我们也可以随便举出一个反例，例如：

      int[] array=new int[]{1,2};

      由于new了一个对象，所以new int[]{1,2}这个对象时存储在堆中的，也就是说1,2这两个基本数据类型是存储在堆中，

      这也就很有效的反驳了基本数据类型一定是存储在栈中~~
 * @author Json
 * @since 1.0.0
 */
public class JVMHeapStackBasic {
    private static int sum = 0;
    private static List<String> list = new ArrayList<String>();

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("参数" + (i + 1) + ":" + args[i]);
        }
        System.out.println("-Xmx" + Runtime.getRuntime().maxMemory() / 1000 / 1000 + "M");
        methodAreaOOMTest();
    }

    /**
     * 方法区异常
     * Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
     */
    private static void methodAreaOOMTest() {
		// TODO Auto-generated method stub
		//Enhancer 
	}

	//Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
    //堆 存储对象
    public static void heapOOMTest() {
		for (int i = 0; i < Integer.MAX_VALUE; i++) {
			list.add("hello");
		}
		
	}

	/**
     * 嵌套查询的调用层次很大程度上由栈的大小决定，栈越大，函数可以支持的嵌套调用的次数就越多
     * 
     * java有两种返回函数的方式：1正常返回 2异常返回 ，最终都会导致栈帧被弹出
     */
    private static void stackDeepTest() {
        try {
            recurse();
        } catch (Throwable e) {
            System.out.println("The deepest calling = " + sum);
            e.printStackTrace();
        }

    }

    private static void recurse() {
        sum++;
        recurse();
    }

    /**
     * 单精度节点的 IEEE754计算机表示，如5.0
     *
     */
    private static void floatShowInPC() {
        float f = 5f;
        int x = Float.floatToRawIntBits(f);
        String result = Integer.toBinaryString(x);
        System.out.println("浮点数5的但精度 IEEE754的表示：" + result);
    }

    /**
     * 浮点数在计算机中的表示
     * 1.（1）float 32位             （2）double 64位
     * 2.最广泛的是IEEE754定义的浮点数格式
     * 3.IEEE754的浮点数包含三个部分： 符号位   指数位  尾数位
     * */
    private static void test3() {

    }

    /**
     * 原码 反码和补码</br>
     * 1.<strong>整数在计算机中以补码表示</strong></br>
     * 2.原码:符号位（第一位0 1表示，其他位表示数值）</br>
     * 3.反码：原码的基础上，符号位不变，其余位取反</br>
     * 4.<strong>补码：负数的补码为反码加1，正数的补码就是原码</strong></br>
     * 5.使用补码的表示方法可以解决 ：</br>
     *             （1）0的存储的问题【0以正数或者负数的表示方法，其补码都一样，但原码和反码都不一样，】</br>
     *             （2）加减法的问题，直接通过补码的直接加即可得到正确的结果，无需考虑符号的问题</br>
     * */
    private static void test2() {
        // TODO Auto-generated method stub
        int a = -10; //-10在计算机内的实际表示 [以-10的补码表示]
        for (int i = 0; i < 32; i++) {
            int t = (a & 0x80000000 >>> i) >>> (31 - i);
            System.out.print(t); //11111111111111111111111111110110
        }
    }

    /*引用类型和原始类型的区别*/
    private static void test1() {
        int a1 = 1;
        int a2 = a1;
        a2 = 2;
        System.out.println("a1=" + a1 + "  and a2=" + a2); //  1   2

        MyBean b1 = new MyBean();
        b1.m = 4;
        MyBean b2 = b1;
        b2.m = 5;
        System.out.println(b1.m + ";" + b2.m); //5  5
    }
}

class MyBean {
    int m;
}