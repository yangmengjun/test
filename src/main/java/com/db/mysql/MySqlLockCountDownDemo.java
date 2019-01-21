package com.db.mysql;

import com.db.DBUtil;
import lombok.extern.slf4j.Slf4j;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.CountDownLatch;

/**
 *事务并发调度的问题

 脏读（dirty read）：A事务读取B事务尚未提交的更改数据，并在这个数据基础上操作。如果B事务回滚，那么A事务读到的数据根本不是合法的，称为脏读。在oracle中，由于有version控制，不会出现脏读。
 不可重复读（unrepeatable read）：A事务读取了B事务已经提交的更改（或删除）数据。比如A事务第一次读取数据，然后B事务更改该数据并提交，A事务再次读取数据，两次读取的数据不一样。
 幻读（phantom read）：A事务读取了B事务已经提交的新增数据。注意和不可重复读的区别，这里是新增，不可重复读是更改（或删除）。这两种情况对策是不一样的，对于不可重复读，只需要采取行级锁防止该记录数据被更改或删除，然而对于幻读必须加表级锁，防止在这个表中新增一条数据。
 第一类丢失更新：A事务撤销时，把已提交的B事务的数据覆盖掉。
 第二类丢失更新：A事务提交时，把已提交的B事务的数据覆盖掉。



 MySQL中select * for update锁表的问题
 由于InnoDB预设是Row-Level Lock，所以只有「明确」的指定主键，MySQL才会执行Row lock (只锁住被选取的资料例) ，否则MySQL将会执行Table Lock (将整个资料表单给锁住)。
 举个例子:
 假设有个表单products ，里面有id跟name二个栏位，id是主键。
 例1: (明确指定主键，并且有此笔资料，row lock)
 SELECT * FROM products WHERE id=’3’ FOR UPDATE;
 SELECT * FROM products WHERE id=’3’ and type=1 FOR UPDATE;

 例2: (明确指定主键，若查无此笔资料，无lock)
 SELECT * FROM products WHERE id=’-1’ FOR UPDATE;

 例2: (无主键，table lock)
 SELECT * FROM products WHERE name=’Mouse’ FOR UPDATE;

 例3: (主键不明确，table lock)
 SELECT * FROM products WHERE id<>’3’ FOR UPDATE;

 例4: (主键不明确，table lock)
 SELECT * FROM products WHERE id LIKE ‘3’ FOR UPDATE;

 注1: FOR UPDATE仅适用于InnoDB，且必须在交易区块(BEGIN/COMMIT)中才能生效。
 注2: 要测试锁定的状况，可以利用MySQL的Command Mode ，开二个视窗来做测试。

 在MySql 5.0中测试确实是这样的
 另外：MyAsim 只支持表级锁，InnerDB支持行级锁
 添加了(行级锁/表级锁)锁的数据不能被其它事务再锁定，也不被其它事务修改（修改、删除）
 是表级锁时，不管是否查询到记录，都会锁定表
 * @author: yangmengjun
 * @date: 2019\1\21 0021 16:37
 */
public class MySqlLockCountDownDemo implements Runnable{

    private CountDownLatch countDownLatch;

    public MySqlLockCountDownDemo(CountDownLatch countDownLatch){
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        Connection connection = DBUtil.getConnection();
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            pstmt = connection.prepareStatement("SELECT id,count from count_number where id=1 for UPDATE ");
//            pstmt = connection.prepareStatement("SELECT id,count from count_number where id=1");
            rs = pstmt.executeQuery();
            int count = 0;
            while(rs.next()){
                Integer id = rs.getInt("id");
                count = rs.getInt("count");
                System.out.printf("id{%d},count{%d}",id,count);
                System.out.println();
            }

            count++;
            pstmt = connection.prepareStatement("update count_number set count = ? where id =1 ");//行锁
            pstmt.setInt(1,count);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
           // DBUtil.close(pstmt,rs);
        }
        countDownLatch.countDown();

    }

}
