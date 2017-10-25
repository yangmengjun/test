package test.base;

import junit.framework.TestCase;
/**
 * 1，程序计数器（Program Counter Register）
 * 2，虚拟机栈（JVM Stack）
 * 4堆区（Heap）：堆区是理解Java GC机制最重要的区域，没有之一。
 * @author Json
 *
 */
public class JVMTest extends TestCase{
	public void requetFor10MB(){//连续系统请求10MB空间，每次1MB
		byte[] b = null;
		for(int i=0;i<20;i++){
			b = new byte[1*1024*1024*20];
		}
		System.out.println("accomplished");
	}

}
