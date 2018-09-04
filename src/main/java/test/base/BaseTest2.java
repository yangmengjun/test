package test.base;

import java.util.Scanner;

import junit.framework.TestCase;

/**
 * 基本数据类型占字节数
 * int   4
 * float 4 [但比8字节的long取值范围更广]
 * long  8
 * 〈一句话功能简述〉
 * 〈功能详细描述〉
 *
 * @author Json
 * @since 1.0.0
 */
public class BaseTest2 extends TestCase {

    public static void testStrange() {
        System.out.println("奇怪的++");
        int x = 5;
        // x = ++x;

        //同理
        int temp = x;
        x = x + 1;
        x = temp;
        System.out.println(x); //打印5  
        main(new String[] { "ewe", "" });
    }

    /**
     * cmd中 进入该目录
     * javac BaseTest2.java  //编译为class文件
     * java BaseTest2  //执行
     * 
     * javap -c BaseTest  //反编译，可以查看源码
     * 〈一句话功能简述〉
     * 〈功能详细描述〉
     * MAIN方法是由程序启动时虚拟机调用 的，所有是public，而不是对象调用的
     * @param args
     */
    public static void main(String[] args) {
        testStrange();
    }

    /**
     * int,float,double除0测试
     * 〈一句话功能简述〉
     * 〈功能详细描述〉
     *
     */
    public void testDiv0() {
        //1.int 
        int i = 1;
        int j = 0;
        try {
            int ij = i / j;
            System.out.println("整数除0正常：" + ij);
        } catch (ArithmeticException e) {
            System.out.println("整数除0发生异常"); //此处执行
        }
        //2.float 
        float m = 1f;
        float _m = -1f;
        float n = 0f;
        try {
            float mn = m / n;
            float _mn = _m / n;
            float temp = n / n;
            System.out.println("Float除0正常：" + mn); //打印Infinity
            System.out.println("负Float除0正常：" + _mn); //打印-Infinity
            System.out.println("float0除0正常：" + temp);//打印Nan
        } catch (ArithmeticException e) {
            System.out.println("Float除0发生异常");
        }
        //3.double 
        double x = 1d;
        double _x = -1d;
        double y = 0d;
        try {
            double xy = (double) (x / y);
            double _xy = (double) (_x / y);
            double temp1 = y / y;
            System.out.println("double除0正常：" + xy);//打印Infinity
            System.out.println("负数double除0正常：" + _xy);//打印-Infinity
            System.out.println("double0除0正常：" + temp1);//打印Nan
            System.out.println(Double.POSITIVE_INFINITY); //Infinity
        } catch (ArithmeticException e) {
            System.out.println("double除0发生异常");
        }
    }

    public void testMaxStringArrayLength() {
        //char[] c = new char[Integer.MAX_VALUE]; //java.lang.OutOfMemeryError 无法分配理论上最大的值，
        //大概4G，无法申请这么大 的连续内存空间

        /*通过折半查找的方法来获取可以申请的最大空间*/
        int low = 0;
        int high = Integer.MAX_VALUE;
        int mid = (low + high) / 2;
        int max = low;
        while (low <= high) {
            for (int i = 0; i < 10; i++) {
                try {
                    char[] myc = new char[mid];
                    //没有报异常，继续往上
                    max = mid;
                    low = mid + 1;
                    mid = (low + high) / 2;
                    System.out.println("第" + i + "次申请成功：" + max);
                    break;
                } catch (OutOfMemoryError e) {
                    e.printStackTrace();
                    //如果第十次申请失败，缩小申请值
                    if (i == 9) {
                        System.out.println("申请失败：" + mid);
                        high = mid - 1;
                        mid = (high + low) / 2;
                    }

                }
            }
        }
        System.out.println("The max vlue is:" + max);
    }
    
    public static int getDiv(int k){
    	int i = 2;
    	for (; i < k/2; i++) {
			if(k%i==0){
				System.out.print(i+"*");
				return k;
			}
		}
    	if(i>k/2){
    		return -1;
    	}
    	return -1;
    }
    
    /**
     * 将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
     */
    public void testComputeYinzi(){
    	while(true){
    		Scanner s = new Scanner(System.in);
    		int number = s.nextInt();
    		   int a = 2;
    	        System.out.print(number + "=");
    	        while(number > a){
    	            if(number % a == 0){
    	                System.out.print(a + "*");
    	                number = number / a;
    	            }else{
    	                a++;
    	            }
    	        }

    	        System.out.print(a);
    	}
    }

}
