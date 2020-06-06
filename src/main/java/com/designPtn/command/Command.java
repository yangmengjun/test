package com.designPtn.command;

/**
 * 命令模式：将请求封装成对象，以便使用不同的请求队列或者日志来参数化其他对象
 *
 * 所有的请求对象实现这个接口
 */
public interface Command {
    public void excute();
}
