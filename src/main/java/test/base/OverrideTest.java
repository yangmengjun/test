package test.base;
/**
 * 重写测试
 * @author Administrator
 *
 */
public class OverrideTest {

	public static void main(String[] args) {
		Parent p = new Child();
		p.test();
		//将会打印：
		// child method1
		//parent method2
	}

}
class Parent{
	void method1(){
		System.out.println("parent method1");
	}
	final void method2(){
		System.out.println("parent method2");
	}
	void test(){
		method1();
		method2();
	}
}
class Child extends Parent{

	@Override
	void method1() {
		System.out.println("child method1");
	}

	@Override
	void test() {
		super.test();
	}
	
}