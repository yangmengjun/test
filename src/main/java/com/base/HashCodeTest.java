package com.base;
/**
 * 哈希值测试
 * @author Json
 *
 * HashMap 查找一个元素：散列表中维护了一个数组，数组的每一个元素被称为一个桶（bucket），
 *    	当你传入一个key = "a"进行查询时，散列表会先把key传入散列（hash）函数中进行寻址，
 *    	得到的结果就是数组的下标，然后再通过这个下标访问数组即可得到相关联的值
 *
 */
public class HashCodeTest {
	public static void main(String[] args) {
		String a = "abc";
		String b = new String("abc");
		String c = "abc";
		System.out.println(a.equals(b));  //true
		System.out.println(a==b);  //false
		System.out.println(a==c);  //true
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		
	}
}
