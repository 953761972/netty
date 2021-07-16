package com.xzq.test;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @Author XZQ
 * @Date 2021/5/24 00:04
 **/
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) { // (2)
    // 默默地丢弃收到的数据
        System.out.println((ByteBuf) msg);
        byte[] b=new byte[1024];
        System.out.println(new String(b));
        ((ByteBuf) msg).release(); // (3)
    }
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) { // (4)
    // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();





    }
}
