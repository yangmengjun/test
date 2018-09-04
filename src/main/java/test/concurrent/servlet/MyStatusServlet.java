package test.concurrent.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 注意:这个有状态的servlet不是线程安全的
 * 
 * 
 * 对上面的 Servlet 进行修改，把 result 变量提升为类的实例变量。那么这个 Servlet 就有状
态了。有状态的 Servlet 在多线程访问时，有可能发生线程不安全性。
 
在 Servlet 中定义了一个实例变量 result， Servlet 把它的值进行输出。当只有一个用户访
问该 Servlet 时，程序会正常的运行，但当多个用户并发访问时，就可能会出现其它用户的信
息显示在另外一些用户的浏览器上的问题 。<strong>这是一个严重的问题</strong>。
 * @author Json
 * @since 1.0.0
 */
public class MyStatusServlet extends HttpServlet {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    int                       result           = 0;

    public MyStatusServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String s1 = request.getParameter("num1");
        String s2 = request.getParameter("num2");
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
