package com.concurrent.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 *  注意:这个无状态的servlet是线程安全的，重点在于无状态
 *  
 *  
 这个 Servlet 是无状态的，它不包含域，也没有引用其它类的域，一次特定计算的瞬时状
态，会唯一的存储在本地变量中，这些本地变量存在线程的栈中，只有执行线程才能访问，
一个执行该 Servlet 的线程不会影响访问同一个 Servlet 的其它线程的计算结果，因为两个线
程不共享状态，他们如同在访问不同的实例。
因为线程访问无状态对象的行为，不会影响其它线程访问对象时的正确性，所以无状态
对象是线程安全的。
 * @author Json
 * @since 1.0.0
 */
public class MyStatuslessServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    public MyStatuslessServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s1 = request.getParameter("num1");
        String s2 = request.getParameter("num2");
        int result = 0;
        if (s1 != null && s1 != null) {
            result = Integer.parseInt(s1) * Integer.parseInt(s2);
        }
        PrintWriter out = response.getWriter();
        out.print(result);
        out.close();
    }

}
