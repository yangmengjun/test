package com.jvm.jmm;
/**
 * java内存模型 JMM
 * @author Json
 * java 数据的5中存储位置： 
 * 1.寄存器
最快的存储区，位于处理器内部，但是数量极其有限。所以寄存器根据需求进行自动分配，无法直接人为控制。
2.栈内存
位于RAM当中，通过堆栈指针可以从处理器获得直接支持。堆栈指针向下移动，则分配新的内存；向上移动，则释放那些内存。这种存储方式速度仅次于寄存器。
（常用于存放对象引用和基本数据类型，而不用于存储对象）
3.堆内存
一种通用的内存池，也位于RAM当中。其中存放的数据由JVM自动进行管理。
堆相对于栈的好处来说：编译器不需要知道存储的数据在堆里存活多长。当需要一个对象时，使用new写一行代码，当执行这行代码时，会自动在堆里进行存储分配。同时，因为以上原因，用堆进行数据的存储分配和清理，需要花费更多的时间。
4.常量池
常量(字符串常量和基本类型常量)通常直接存储在程序代码内部（常量池）。这样做是安全的，因为它们的值在初始化时就已经被确定，并不会被改变。常量池在java用于保存在编译期已确定的，已编译的class文件中的一份数据。它包括了关于类，方法，接口等中的常量，也包括字符串常量，如String s = "java"这种申明方式
5.非RAM存储区
如果数据完全存活于程序之外，那么它可以不受程序的任何控制，在程序没有运行时也可以存在。其中两个基本的例子是：流对象和持久化对象。
 *
 *
 *关于并发编程

在并发编程领域，有两个关键问题：线程之间的通信和同步。

线程之间的通信

线程的通信是指线程之间以何种机制来交换信息。在命令式编程中，线程之间的通信机制有两种共享内存和消息传递。

在共享内存的并发模型里，线程之间共享程序的公共状态，线程之间通过写-读内存中的公共状态来隐式进行通信，典型的共享内存通信方式就是通过共享对象进行通信。

在消息传递的并发模型里，线程之间没有公共状态，线程之间必须通过明确的发送消息来显式进行通信，在java中典型的消息传递方式就是wait()和notify()。
 */
public class JavaMemoryModel {
	
}
