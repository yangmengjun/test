package com.base;
/**
 * 泛型测试类
 * @author Json
 * 
 * 泛型类型在逻辑上看以看成是多个不同的类型，实际上都是相同的基本类型。
 *
 */
public class GenericTest {
	public static void main(String[] args) {
		Point<Number> pn = new Point<Number>();
		Point<String> ps = new Point<String>();
		ps.setX("X轴位50");
		ps.setY("y轴位50");
		Point<Integer> pi = new Point<Integer>();
		System.out.println(ps.getClass()==pi.getClass()); //true
		testGenericMethod(ps);
		testGenericMethod(pi);
		
		//testGenericMethod2(ps); 编译出错，必须是Number的子类才行
		testGenericMethod2(pi);
		
		testGenericMethod3(pn);
		testGenericMethod3(pi);
	}
	
	//类型通配符
	public static void testGenericMethod(Point<?> p){
		System.out.println(p.getX());
	}
	//类型通配符
	public static void testGenericMethod2(Point<? extends Number> p){
		System.out.println(p.getX());
	}
	//类型通配符
	public static void testGenericMethod3(Point<? super Integer> p){
		System.out.println(p.getX());
	}
	
}
class Point<T>{
	T x;
	T y;
	public T getX() {
		return x;
	}
	public void setX(T x) {
		this.x = x;
	}
	public T getY() {
		return y;
	}
	public void setY(T y) {
		this.y = y;
	}
}
class MutiPoint<T,X>{
	
}