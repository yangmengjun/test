package com.jvm;

import junit.framework.TestCase;
/**
 * java 的堆和栈
 * 请查看下面的程序运行时变量引用的说明
 * @author Json
 *
 */
public class JVMHeapStack extends TestCase{
	/**
	 * 打印java虚拟机最大堆内存
	 */
	public void testGetJvmMaxUsefulHeapMemory(){
		long byteLen = Runtime.getRuntime().maxMemory();
		System.out.println("最大堆内存为："+byteLen/1000/1000+"M");
	}
}
class BirthDate {    
    private int day;    
    private int month;    
    private int year;        
    public BirthDate(int d, int m, int y) {    
        day = d;     
        month = m;     
        year = y;    
    }    
    //省略get,set方法………    
}    
    
class Test{    
    public static void main(String args[]){    
         int date = 9;    
         Test test = new Test();          
         test.change(date);     
         BirthDate d1= new BirthDate(7,7,1970);           
    }      
    
    public void change(int i){    
        i = 1234;    
    }   
}
/**
对于以上这段代码，date为局部变量，i,d,m,y都是形参为局部变量，day，month，year为成员变量。下面分析一下代码执行时候的变化：
1. main方法开始执行：int date = 9;
date局部变量，基础类型，引用和值都存在栈中。
2. Test com = new Test();
test为对象引用，存在栈中，对象(new Test())存在堆中。
3. com.change(date);
调用change(int i)方法，i为局部变量，引用和值存在栈中。当方法change执行完成后，i就会从栈中消失。
4. BirthDate d1= new BirthDate(7,7,1970);  
调用BIrthDate类的构造函数生成对象。
d1为对象引用，存在栈中；
对象(new BirthDate())存在堆中；
其中d,m,y为局部变量存储在栈中，且它们的类型为基础类型，因此它们的数据也存储在栈中；
day,month,year为BirthDate对象的的成员变量，它们存储在堆中存储的new BirthDate()对象里面；
当BirthDate构造方法执行完之后，d,m,y将从栈中消失。
5.main方法执行完之后。
date变量，com，d1引用将从栈中消失；
new Test(),new BirthDate()将等待垃圾回收器进行回收。
**/