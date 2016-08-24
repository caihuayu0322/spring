package com.caicai.www.netty;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.bytes.ByteArrayDecoder;
import io.netty.handler.codec.serialization.ClassResolvers;
import io.netty.handler.codec.serialization.ObjectDecoder;
import io.netty.handler.codec.serialization.ObjectEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

import java.util.concurrent.TimeUnit;

public class POSClient {
    private int port;
    private String host;
    private SocketChannel socketChannel;
    private static final EventExecutorGroup group = new DefaultEventExecutorGroup(20);

    public POSClient(int port, String host) throws InterruptedException {
        this.port = port;
        this.host = host;
        start();
    }

    private void start() throws InterruptedException {
        NioEventLoopGroup eventLoopGroup = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.channel(NioSocketChannel.class);
        bootstrap.option(ChannelOption.SO_KEEPALIVE, true);
        bootstrap.group(eventLoopGroup);
        bootstrap.remoteAddress(host, port);
        bootstrap.handler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel) throws Exception {
                socketChannel.pipeline().addLast(new IdleStateHandler(20, 10, 0));
                socketChannel.pipeline().addLast(new StringEncoder(CharsetUtil.UTF_8));
//                socketChannel.pipeline().addLast(new StringDecoder(CharsetUtil.UTF_8));
                socketChannel.pipeline().addLast(new ByteArrayDecoder());
                socketChannel.pipeline().addLast(new NettyClientHandler());
            }
        });
        ChannelFuture future = bootstrap.connect(host, port).sync();
        if (future.isSuccess()) {
            socketChannel = (SocketChannel) future.channel();
            System.out.println("connect server  成功---------");
        }
    }

    public static void main(String[] args) throws InterruptedException {
//        Constants.setClientId("001");
        POSClient bootstrap = new POSClient(9100, "10.66.18.3");
//
//        LoginMsg loginMsg = new LoginMsg();
//        loginMsg.setPassword("yao");
//        loginMsg.setUserName("robin");
//        bootstrap.socketChannel.writeAndFlush("测试");
        while (true) {
            TimeUnit.SECONDS.sleep(3);
//            AskMsg askMsg = new AskMsg();
//            AskParams askParams = new AskParams();
//            askParams.setAuth("authToken");
//            askMsg.setParams(askParams);
//            bootstrap.socketChannel.writeAndFlush("测试");
        }
        }

}
