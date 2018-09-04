package com.base;

public class StaticTest2 {

	private static int a = 5;
	int b = 3;

	public StaticTest2() {
		a++;
		b++;
	}

	/**
	 * 
	 * 静态变量是共有的，而非静态的是跟对象走的
	 * 
	 0 静态变量是在程序编译时加载的、只初始化一次、所以当你new两个对象时、静态变量第一次加到6第二次加到7、
	 * 而非静态的成员变量是new一个对象初始化一次
	 * 、也就是说new第一个对象时3加到4了、new第二个对象时这个变量又初始化了一次再从3加到4、所以是两个4、
	 * @param args
	 */
	public static void main(String[] args) {
		StaticTest2 st = new StaticTest2();
		System.out.println("第一次实例化后，a=" + st.a + " ;b=" + st.b); // a=6,b=4
		StaticTest2 stagain = new StaticTest2();
		System.out.println("再次实例化后，a=" + stagain.a + " ;b=" + stagain.b);// a=7,b=4
	}

}
