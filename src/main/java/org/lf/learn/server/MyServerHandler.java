package org.lf.learn.server;

import java.util.Map;
import java.util.UUID;

import ch.qos.logback.classic.util.ContextInitializer;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelId;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyServerHandler extends SimpleChannelInboundHandler<String> {

    private static Map<String, Channel> channelMap;

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        //打印出客户端地址
        final ChannelId id = ctx.channel().id();
        channelMap.put(id.asShortText(), ctx.channel());
        log.info(ctx.channel().remoteAddress() + ", " + msg);
        ctx.channel().writeAndFlush("form server: " + UUID.randomUUID());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    public void sendMsg(String msg) {
        channelMap.values().forEach(channel -> channel.writeAndFlush(msg));
    }
}