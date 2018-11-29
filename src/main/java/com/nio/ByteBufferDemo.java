package com.nio;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * ByteBuffer缓冲区流 读写文件
 * 【所有的IO操作无非就是把数据移入和移除缓冲区】
 * 优点： 相对于java的io对于数据的小块处理（几个字节，几行文本），ByteBuffer直接通过缓冲区（操作系统就是通过缓冲区大块的处理数据的） 直接处理的是整个文件，效率要高很多
 * 但是， java io中的RandomAccessFile 可以大块大块的处理数据，并且效率也不低，只要坚持使用基于数组的read()和write()方法即可
 *
 * @author: yangmengjun
 * @date: 2018\11\28 0028 17:34
 */
public class ByteBufferDemo {
    @Test
    public void test() throws IOException {
        ByteBuffer buff = ByteBuffer.allocate(128);
        FileChannel fin = null;
        FileChannel fout = null;
        try {
            fin = new FileInputStream("d:\\rong360.log.2018-11-07").getChannel();
            fout = new FileOutputStream("d:\\test.txt").getChannel();
            while ((fin.read(buff)) != -1) {
                //limit是可以读写的边界，当position到达limit时，就表示将ByteBuffer中的内容读完，或者将ByteBuffer写满了。
                // 由读切换到写的时候，flip方法将limit值置为position值，position置0，这样才能读到正确数据
                buff.flip();
                fout.write(buff);
                //将buff缓冲区中的数据写入到输出管道，此时调用ByteBuffer.clear()方法为下次从管道中读取数据做准备，但是调用clear方法并不将缓冲区的数据清空，而是设置position，mark，limit这三个变量的值，
                buff.clear();
            }
        } catch (java.io.IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fin != null) {
                    fin.close();
                }
                if (fout != null) {
                    fout.close();
                }
            } catch (IOException e) {
                throw e;
            }
        }
    }

    /**
     * 现有如下的一个需求，向已存在1G数据的txt文本里末尾追加一行文字，可能大多数朋友会觉得这个需求很easy，直接使用Java中的流读取了txt文本里原来所有的数据转成字符串后，然后拼接了又写回文本里了，至此，大功告成。
     * 后来需求改了，向5G数据的txt文本里追加了，结果XXX君傻了，他内存只有4G，如果强制读取所有的数据并追加，会报内存溢出的异常。
     * 其实上面的需求很简单，如果我们使用JAVA IO体系中的RandomAccessFile类来完成的话，可以实现零内存追加。其实这就是支持任意位置读写类的强大之处。
     */
    @Test
    public void randomAccessFileDemo() {
        RandomAccessFile randomAccessFile = null;
        try {
            randomAccessFile = new RandomAccessFile("d:\\test.txt", "rw");
            byte[] b = new byte[1024];
            System.out.println("初始指针位置[当然是0啦]:" + randomAccessFile.getFilePointer());
            int hasRead = 0;
            //下面这行可以指定指针的位置，从那开始读取
//            randomAccessFile.seek(500);
            while ((hasRead = randomAccessFile.read(b)) > 0) {
                String out = new String(b, 0, hasRead);
                System.out.println(out);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 追加文件
     */
    @Test
    public void randomAccessFileAdd2FileTailDemo() {
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("D:\\test.txt", "rw");
            //直接将指针指向文件末尾
            raf.seek(raf.length());
            raf.write("This part is new ".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * randomAccessFile 文件中间插入文件【错误示范】
     */
    @Test
    public void randomAccessFileInsertContentInMiddleWrongDemo() {
        RandomAccessFile raf = null;
        try {
            String file = "d:\\test.txt";
            String contents = "I want to insert this sentence to position 55";
            int pos = 55;
            raf = new RandomAccessFile(file, "rw");
            raf.seek(pos);
            //千万注意：直接按照下面这样的方法写文件会直接覆盖原有文件的内容【长度和插入的内容长度一样】
            raf.write(contents.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                raf.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * randomAccessFile 文件中间插入文件
     * 思路：
     * 将要插入点的后面部分保存再临时文件，等要插入内容插入到文件之后，再插入临时文件内容
     */
    @Test
    public void randomAccessFileInsertContentInMiddleDemo() {
        String fileName = "d:\\test.txt";
        int pos = 20;
        String content = "Hello,I love u.";
        RandomAccessFile raf = null;
        try {
            File tmp = File.createTempFile("tmp", null);
            //JVM退出时删除文件
            tmp.deleteOnExit();
            FileOutputStream out = new FileOutputStream(tmp);
            raf = new RandomAccessFile(fileName, "rw");
            raf.seek(pos);
            int hasRead = 0;
            byte[] bytes = new byte[1024];
            while ((hasRead = raf.read(bytes)) > 0) {
                out.write(bytes, 0, hasRead);
            }
            //插入content
            raf.seek(pos);
            raf.write(content.getBytes());

            //在插入内容的后面插入临时文件内容
            raf.seek(pos + content.length());

            FileInputStream in = new FileInputStream(tmp);
            byte[] b = new byte[1024];
            while (in.read(b) != -1) {
                raf.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
