package com.jvm.gc;
/**
 * 垃圾回收
 * @author Json
 * 
 * 设置JVM参数:-Xms1024M -Xmx1024M -XX:+PrintGCDetails
 *       可打印出回收的信息
 * 新生代： eden       form(s0，【survivor】)  to(s1)
 * 老年代     tenured
 * 
 * JVM提供了一个参数： MaxTenuringThreshold 新生代对象的最大年龄 ，15 即新生代对象最大经历15次GC就可晋升为老年代
 * threshold  n.  门槛，入口，临界值
 */
public class GCTest {
	private static final int _1K=1024;
	public static void main(String[] args) {
		allocEden();
	}

	private static void allocEden() {
		for (int i = 0; i <5*_1K; i++) {
			byte[] b = new byte[_1K]; //首次创建会放在eden区,一次新生代回收后会存在于s0或s1区
		}
	}

}
