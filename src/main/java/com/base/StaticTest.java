package com.base;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * 1.此类主要描述了static关键字的3种用法
 * 2.内部类的实现
 * 3.transient关键字的引用
 * @author Json
 * @since 1.0.0
 */
public class StaticTest {

    /**
     * 
     */
    private static final long  serialVersionUID = 1L;
    public final static String ID_CARD          = "421127";
    private int                sum              = 0;

    transient String           myBankAcount;               //改属性将不会被序列化

    static {
        System.out.println();
    }

    public static void test() {
        //        MyUser u = new MyUser();
    }

    /*2.局部内部类
     * 局部内部类也像别的类一样进行编译，但只是作用域不同而已，只在该方法或条件的作用域内才能使用，退出这些作用域后无法引用的*/
    public void testCertainInnerCls(String param) { //
        class InnerClsCertain {
            private String label;

            private InnerClsCertain() {

            }

            private InnerClsCertain(String a) {
                label = a;
            }
        }
    }

    /*
     * 3.嵌套内部类（局部内部类）
     */
    public static class MyInerCls {
        public MyInerCls() {

        }

    }

    /*
     *4.匿名内部类【可去看看Runnable接口的实现】
     */
    public Inner getAnonInnerTest(final String name) {
        return new Inner() {
            private String strName = name;

            public String getName() {
                return strName;
            }
        };
    }

    public class MyInnerClsNonStatic { //1.成员内部类()
        public MyInnerClsNonStatic() {
            sum++;
        }
    }

    public static void writeObj() {
        MyUser u = new MyUser("yang", "123245", "china");
        try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("d:/user.txt"))) {
            o.writeObject(u);
            o.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void transientTest() {
        //从流中读取属性
        try {
            ObjectInputStream read = new ObjectInputStream(new FileInputStream("d:/user.txt"));
            MyUser user = (MyUser) read.readObject();
            System.out.println("读取用户对象：" + user.getUsername() + "===" + user.getPasswd());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //        StaticTest outter = new StaticTest();
        //        // StaticTest.MyInerCls c = outter.new MyInerCls();
        //        MyInerCls ic = new MyInerCls();
        //        StaticTest.MyInnerClsNonStatic min = outter.new MyInnerClsNonStatic();
        //        transientTest();
        writeObj();
    }
}

interface Inner {
    String getName();
}

/**
1）一旦变量被transient修饰，变量将不再是对象持久化的一部分，该变量内容在序列化后无法获得访问。
2）transient关键字只能修饰变量，而不能修饰方法和类。注意，本地变量是不能被transient关键字修饰的。变量如果是用户自定义类变量，则该类需要实现Serializable接口。
3）被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化。
 */
class MyUser implements Serializable {//该对象可以被序列化
    private static final long serialVersionUID = 8294180014912103005L;

    private String            username;
    private transient String  passwd;                                 //不被序列化的属性
    private static String     country;                                //静态变量也不能被序列化

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public MyUser(String name, String pwd, String c) {
        this.username = name;
        this.passwd = pwd;
        this.country = c;
    }

    public static String getCountry() {
        return country;
    }

    public static void setCountry(String country) {
        MyUser.country = country;
    }

}