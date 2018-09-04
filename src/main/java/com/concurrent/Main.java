package com.concurrent;

/**
 * 
 * Bloch 给出了描述五类线程安全性的分类方法：
 * <ul>
 * <li>不可变[不可变肯定是线程安全的]</li>
 * <li>线程安全</li>
 * <li>有条件线程安全</li>
 * <li>线程兼容</li>
 * <li>线程对立</li>
 * </ul>
 * @author Json
 * @since 1.0.0
 */
public class Main {
    public static void main(String[] args) {
        testServlet();
    }

    /**
     * Servlet 体系结构是建立在 Java 多线程机制之上的，它的生命周期是由 Web 容器负责的。
    当客户端第一次请求某个 Servlet 时， Servlet 容器将会根据 web.xml 配置文件实例化这个
    Servlet 类。当有新的客户端请求该 Servlet 时，一般不会再实例化该 Servlet 类，也就是有多
    个线程在使用这个实例。 Servlet 容器会自动使用线程池等技术来支持系统的运行。
     *
     */
    private static void testServlet() {
        // TODO Auto-generated method stub

    }

    /**
    4) 线程兼容
    线程兼容类不是线程安全的，但是可以通过正确使用同步而在并发环境中安全地使用。
    这可能意味着用一个 synchronized 块包围每一个方法调用，或者创建一个包装器对象，其中
    每 一 个 方 法 都 是 同 步 的 ( 就 像  Collections.synchronizedList() 一 样 ) 
     也 可 能 意 味 着 用 synchronized 块包围某些操作序列。为了最大程度地利用线程兼容类，如果所有调用都使用
    同一个块，那么就不应该要求调用者对该块同步。这样做会使线程兼容的对象作为变量实例
    包含在其他线程安全的对象中，从而可以利用其所有者对象的同步。 
    许 多 常 见 的 类 是 线 程 兼 容 的 ， 如 集 合 类  ArrayList 和  HashMap 、
    <see>java.text.SimpleDateFormat</see> 、或者 JDBC 类 Connection 和 ResultSet 。
     */
    private static void test4() {
        // TODO Auto-generated method stub

    }

}
