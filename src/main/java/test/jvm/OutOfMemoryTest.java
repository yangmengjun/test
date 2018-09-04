package test.jvm;

/**
 * 内存溢出分类：
 *  * 
 * 年老代堆空间被占满
 异常： java.lang.OutOfMemoryError: Java heap space
 持久代被占满
 异常：java.lang.OutOfMemoryError: PermGen space
 堆栈溢出
 异常：java.lang.StackOverflowError
 线程堆栈满
 异常：Fatal: Stack size too small
 系统内存被占满（堆）
 异常：java.lang.OutOfMemoryError: unable to create new native thread
 */
public class OutOfMemoryTest {

	public static void main(String[] args) {
		suanfa();
	}

	private static void suanfa() {
		// TODO Auto-generated method stub
		/**
		 * 1.Mark-Sweep（标记-清除）算法
		 * 
		 * 2.Copying（复制）算法
		 * 
		 * 3.Mark-Compact（标记-整理）算法
		 * 
		 * 4.Generational Collection（分代收集）算法

分代收集算法是目前大部分JVM的垃圾收集器采用的算法。它的核心思想是根据对象存活的生命周期将内存划分为若干个不同的区域。一般情况下将堆区划分为老年代（Tenured Generation）和新生代（Young Generation），老年代的特点是每次垃圾收集时只有少量对象需要被回收，而新生代的特点是每次垃圾回收时都有大量的对象需要被回收，那么就可以根据不同代的特点采取最适合的收集算法。

目前大部分垃圾收集器对于新生代都采取Copying算法，因为新生代中每次垃圾回收都要回收大部分对象，也就是说需要复制的操作次数较少，但是实际中并不是按照1：1的比例来划分新生代的空间的，一般来说是将新生代划分为一块较大的Eden空间和两块较小的Survivor空间，每次使用Eden空间和其中的一块Survivor空间，当进行回收时，将Eden和Survivor中还存活的对象复制到另一块Survivor空间中，然后清理掉Eden和刚才使用过的Survivor空间。

而由于老年代的特点是每次回收都只回收少量对象，一般使用的是Mark-Compact算法。

注意，在堆区之外还有一个代就是永久代（Permanet Generation），它用来存储class类、常量、方法描述等。对永久代的回收主要回收两部分内容：废弃常量和无用的类。
		 
		 */
	}
	
	

}
