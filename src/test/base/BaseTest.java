package test.base;

import junit.framework.TestCase;
@Description(value="This is my base class",type=1)
public class BaseTest extends TestCase {
    public static int a = 1;

    public static void main(String[] args) {
    	testInteger();
        String s;
        System.out.println(2.0-1.10); //0.8999999999999999
        //  System.out.println("s=" + s);  无法编译通过，但是只是在引用处报错无法编译
    }
    
    /**
     * 在程序默认配置下，jvm开始会把-128到127都的Integer都初始化一遍。
     * 这种方式的时候，相当于i1，i2都指向了我们默认生成的Integer（127）这个对象上面。
     * 
     */
    private static void testInteger() {
		Integer i1 = 100;
		Integer i2 = 100;
		Integer t1 = 128;
		Integer t2 = 128;
		
		Integer i3 = 120;
		System.out.println(i1==i2); //true
		System.out.println(t1==t2); //false(1~127之间的都是true，128以上d都是false)
		System.out.println(i1==i3); //false
		System.out.println();
		
	}

	//100的各个进制表示法，最终打印出来的是换算后的十进制
    public void testJinzhi(){
    	System.out.println(0b100);//二进制100
    	System.out.println(0100);//八进制100
    	System.out.println(0x100);//十六进制100
    	System.out.println(100);//十进制100
    	System.out.println(Integer.toOctalString(100)); //100转换为8进制
    	System.out.println(Integer.toHexString(100)); //100转换为16进制
    }

    /**
     * goto,const不是java的关键字，但是是保留字
     * ture false null不是关键字
     * 〈功能详细描述〉
     *
     */
    public void testGoto() {
        module: {
	    	for (int i = 0; i < 5; i++) {
	            if (i == 3) {
	                break module;
	            }
	        }
	    	System.out.println(123);
    	}
	    System.out.println(1213);
        h: System.out.println("12");
    }

    /**
     * Unicode字符取值范围： 0x0000 ~ 0x10ffff
     * 〈一句话功能简述〉
     * 〈功能详细描述〉
     *
     */
    public void test(int... myint) {
        int startNum = 0, identifierNum = 0;
        char tes = '\u0022';
        //  String t= "u0027"
        for (int i = 0x0000; i < 0x10ffff; i++) {
            if (Character.isJavaIdentifierStart(i)) {
                startNum++;
            }
            if (Character.isJavaIdentifierPart(i)) {
                identifierNum++;
            }
        }
        System.out.println("Unicode个数：" + (0x10ffff + 1));
        System.out.println(startNum);
        System.out.println(identifierNum);

        System.out.println("--------输出java标识符的最大长度--------");

    }

    /**
     * 1.整形：byte char short int long
     *   char:无符号类型（0~65535），其他的为有符号类型
     * 〈功能详细描述〉
     *
     */
    public void testfor1() {
        int i = 1;
        char j = 1;
        long m = 1;
        short a = 1;
        byte c = 1;
    }

    /**
     * 1.浮点和整形运算会将整形先转换为浮点型
     * 2.byte到char转换为扩展收缩转换，要先将byte转换为int再转换为char
     * 〈一句话功能简述〉
     * 〈功能详细描述〉
     *
     */
    public void testFloatInt() {
        // float a = 1.1;  //无法编译，不能强制将double转为float
        double b = 1.2231; //有小数点的默认为double类型的数
    }

    /**
     * 前置，先自增（减），再参与运算；后置先参与运算，再自增（减）【可以想想典型的for循环】
     */
    public void testPreSub() {
        int i = 1;
        int j = 2 * ++i + 3 * i--; //2*（1+1）+3*2  10
        int m = 1;
        int n = 2 * m++ + 3 * --m; //2*（1）+3*1  5  //三个加号或减号，编译器会自动组合成合法的，但是两个的话会发生编译错误
        // int k =j--1; //编译无法通过
        int k = j-- - 1;
        System.out.println(j + " " + n);
        System.out.println((null instanceof Object) + String.valueOf(a)); //false
        String String = "";

        int a = 1;
        int b = a + (++a) + (a = 1) + a;
        System.out.println(String.format("a=%s,b=%s", a, b)); //a=1,b=5 java是从左向右进行运算的
        int c = b = a;
    }

    /*不允许新建临时变量的交换，  可以通过加减法实现*/
    public void testSwap() {
        int x = 5;
        int y = 7;
        x = x + y;
        y = x - y;
        x = x - y;
        System.out.println(String.format("交换后x=%x,y=%x", x, y));
    }

    /**
     * 知识点：两个整数x，y  x异或y两次的结果是x，即 （x^y^y）= x
     * 通过异或方式交换两个整数
     * 
     * */
    public void testSwapByXor() {
        int x = 6;
        int y = 7;
        x = x ^ y;
        System.out.println(x);
        y = x ^ y;
        x = x ^ y;
        System.out.println(String.format("异或方式交换后x=%x,y=%x", x, y));
    }

    /**
     * 1.千万注意，没有break的话，会一直往下执行
     * 2.支持数据类型：基本数据类型，除了 boolean，float，double之外都支持【String是从jdk1.7以后支持的】，还有 枚举类
     * 
     *   支持： byte short char int 以及他们的装箱类：Byte Short Character Integer【jdk1.4以后】（最后都会转换为基本数据类型比较）
     * 〈一句话功能简述〉
     * 〈功能详细描述〉
     *
     */
    public void testSwitchCase() {
        int i = 1;
        //for (int i = 0; i < 3; i++) {
        switch (i) {
            case 0:
                System.out.println("first");
                break;
            case 1:
                System.out.println("SECOND");
                break;
            case 2:
                System.out.println("THRID");
                break;
            case 3:
                System.out.println("FOURTH");
                break;
            default:
                System.out.println("defalut");
        }
        Sex x = Sex.FEMAIL;
        switch (x) {
            case MAIL:
                System.out.println("U are a genteman");
                break;
            case FEMAIL:
                System.out.println("U are a woman");
                break;
        }

        //}
    }

    public void testEqualStr() {
        String s1 = "hello";
        String s2 = "hello";
        String s3 = "he" + new String("llo"); //分配了新的地址块
        String s4 = "he" + "llo";
        System.out.println(s1 == s2); //true 
        System.out.println(s1 == s3);//false
        System.out.println(s1 == s4); //true
        System.out.println(s3 == s4);//false
        /********beautiful cut line*******/
        //equals具有 自反性，一致性，传递性，对称性，另外任何与null比较的equals都返回false
        String ss1 = new String("abc");
        String ss2 = new String("abc");
        System.out.println(ss1.equals(ss2)); //true ,因为String重写了equals方法，下面两个没有
        StringBuilder ss3 = new StringBuilder("abc");
        StringBuilder ss4 = new StringBuilder("abc");
        System.out.println(ss3.equals(ss4)); //false
        StringBuffer ss5 = new StringBuffer("abc");
        StringBuffer ss6 = new StringBuffer("abc");
        System.out.println(ss5.equals(ss6)); //false
    }
}

enum Sex {
    MAIL, FEMAIL
}