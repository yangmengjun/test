package test.base;


public class RecursiveTest {
	
	public static void main(String[] args) {
		//System.out.println(reverseStr("yangmengjun"));
		System.out.println(countWays(3));
	}
	
	//递归实现字符串倒序
	public static String reverseStr(String str){
		if(str.length()==1){
			return str;
		}
		return reverseStr(str.substring(1))+str.charAt(0);
	}
	
	//一个有n级的台阶，一次可以走1级、2级或3级，问走完n级台阶有多少种走法
	public static int countWays(int n) {   
        if(n < 0) {   
            return 0;   
        }   
        else if(n == 0) {   
            return 1;   
        }   
        else {   
            return countWays(n - 1) + countWays(n - 2) + countWays(n -3);   
        }   
   }   

}
