package org.lf.learn.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EchoServerHandler extends SimpleChannelInboundHandler<String> {


    @Override
    protected void channelRead0(final ChannelHandlerContext ctx, final String msg) throws Exception {
        log.info("channelRead0 param is msg:{} ", msg);
    }

    @Override
    public void channelActive(final ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
    }

    @Override
    public void exceptionCaught(final ChannelHandlerContext ctx, final Throwable cause) throws Exception {
        super.exceptionCaught(ctx, cause);
    }
}
