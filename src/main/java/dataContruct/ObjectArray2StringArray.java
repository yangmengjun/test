package dataContruct;

import java.util.Arrays;
/**
 * Object数组直接转换为String数组
 * @author Administrator
 *
 */
public class ObjectArray2StringArray {

	public static void main(String[] args) {
		Object[] objArr = new Object[3];
		objArr[0] = "Hello";
		objArr[1] = "World";
		objArr[2] = "YMJ";
		String[] arr = Arrays.asList(objArr).toArray(new String[0]);
		for(String s :arr){
			System.out.println(s);
		}
	}

}
