package test.base;

public class HashCodeTest {
	public static void main(String[] args) {
		String a = "abc";
		String b = new String("abc");
		System.out.println(a.equals(b));
		System.out.println(a.hashCode());
		System.out.println(b.hashCode());
		
	}
}
