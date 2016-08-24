package com.caicai.www.netty;

import com.alibaba.fastjson.JSON;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * Created by Administrator on 2016-6-12.
 */
public class NettyClientHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            switch (e.state()) {
                case WRITER_IDLE:
//                    PingMsg pingMsg=new PingMsg();

            		ByteBuf buf = Unpooled.copiedBuffer(new byte[] { 29, 97, 1 });
                    ctx.writeAndFlush(buf);
                    System.out.println("send ping to server----------");
                    break;
                default:
                	System.out.println("收到信息： "+JSON.toJSONString(evt));
                    break;
            }
        }
    }

    @Override
	public void channelRead(ChannelHandlerContext channelHandlerContext, Object o) throws Exception {
    	System.out.println("读到消息");
    	byte[] array = (byte[]) o;
    	for (int i = 0; i < array.length; i++) {
			System.out.println(array[i]);
		}
    	System.out.println(JSON.toJSONString(o));
    }
}
