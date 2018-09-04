package test.base;

import java.io.IOException;

import junit.framework.TestCase;

public class RuntimeTest extends TestCase{
	
	public static void testRuntimte() throws IOException {
		Process p = Runtime.getRuntime().exec("net start mysql");
		int k = p.exitValue();
	}

    public static void testException(){//发生了异常 继续往下走
    	int a =2;
    	int b=0;
    	int c = 0;
    	try {
    		c = a/b;
		} catch (ArithmeticException e) {
			e.printStackTrace();
		}
    	System.out.println(c);
    }

}
