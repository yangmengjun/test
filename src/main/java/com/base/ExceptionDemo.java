package com.base;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.nio.ByteBuffer;
import java.util.List;

/**
 * HeapOutOfMemory

 Young OutOfMemory：设置XX: MaxTenuringThreshold为一个很大的值，使对象无法及时移入到年老代中，导致年轻代内存溢出。

 MethodArea OutOfMemory ：在经常生成大量Class的应用中，需要特别注意类的回收状况。这类场景除了使用CGLib字节码增强和动态语言之外，
                  常见的还有：大量JSP或动态产生JSP文件的应用（JSP第一次运行时，需要编译成Java类）、基于OSGi的应用（即使是同一个类文件，被不同的类加载器加载也会视为不同的类）等。


 ConstantPool OutOfMemory ：一般来说是不可能的，只有项目启动方法区内存很小或者项目中的静态变量及其多时才会发生。

 DirectMemory OutOfMemory

 Stack OutOfMemory Stack OverFlow
 * @author: yangmengjun
 * @date: 2018\11\28 0028 11:57
 */
@Slf4j
public class ExceptionDemo {
    private static int stackInvokeTime = 0;

    /**
     * StackOverflow
     * 栈溢出一般与方法递归次数过多，或者方法中有产生大量数据的循环有关。
     * java.lang.StackOverflowError
     */
    @Test
    public void stackoverflowExceptionDemo(){
        try{
            test();
        }catch (Error e){
            log.error("已经达到最大深度，最大递归深度："+stackInvokeTime);
        }
    }

    /**
     * 无限递归
     */
    public void  test(){
        stackInvokeTime++;
        test();
    }


    /**
     * 执行前可将堆最小和最大设为 ：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     */
    @Test
    public void HeapOutOfMemoryDemo(){
        List<OOMObject> list = Lists.newArrayList();
        while(true){
            list.add(new OOMObject());
        }
    }
    static class OOMObject{}

    /**
     * DirectMemory OutOfMemory
     * 堆外溢出，  一般和NIO有关
     */
    @Test
    public void directoryOutofmemoryErrorDemo(){
        List<ByteBuffer> list = Lists.newArrayList();
        while(true){
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024*1024*1024);
            list.add(byteBuffer);
        }
    }
}
