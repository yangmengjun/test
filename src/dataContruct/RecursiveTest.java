package dataContruct;

import org.junit.Test;

/**
 * 递归
 * @author Json
 *
 */
public class RecursiveTest{
	public static void main(String[] args) {
		//reverse("abcdf");
		System.out.println(reverse(new StringBuffer("yangmengjun"),new StringBuffer(),0));
		testHannuo();
	}
	/**
	 * 汉诺塔递归：
	 * 解题思维：
	 *    题目中只给了三座塔，我们利用C塔将圆盘堆在B塔。
	 */
	private static void testHannuo() {
		move(4,'A','B','C');
	}
	
	public static void move(int n,char a,char b,char c){
		if(n==1){
			System.out.println("盘"+n+" 由"+a+" 移至"+c);
		}else{
			move(n-1,a,c,b);
			System.out.println("盘"+n+" 由"+a+" 移至"+c);
			move(n-1,b,a,c);
		}
	}
	
	//倒序递归方法输出字符串：  abc->cba
	//另外：StringBuffer性能没有StringBuilder好
	public static StringBuffer reverse(StringBuffer target,StringBuffer result,int index){
		if(index<target.length()){
			result = reverse(target,result,index+1).append(target.toString().charAt(index));
			return result;
		}else{
			return result;
		}
	}
	
	
	
}
