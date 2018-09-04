package com.concurrent.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 要解决线程不安全性，其中一个主要的方法就是取消 Servlet 的实例变量，变成无状态的
Servlet。另外一种方法是对共享数据进行同步操作。使用 synchronized 关键字能保证一次只
有一个线程可以访问被保护的区段，同步后的 Servlet 如下:


Servlet 的线程安全问题只有在大量的并发访问时才会显现出来，并且很难发现


 * @author Json
 * @since 1.0.0
 */
public class SafetyServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    int                       result           = 0;

    public SafetyServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s1 = request.getParameter("num1");
        String s2 = request.getParameter("num2");
        synchronized (this) { //保证一次只 有一个线程可以访问被保护的区段
            if (s1 != null && s1 != null) {
                result = Integer.parseInt(s1) * Integer.parseInt(s2);
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            PrintWriter out = response.getWriter();
            out.print(result);
            out.close();
        }
    }
}
