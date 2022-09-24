package com.jnlzw.lzwtool.other.javaIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NIOServer {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open().bind(new InetSocketAddress(9999));
        serverSocketChannel.configureBlocking(false);
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true){
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()){
                SelectionKey selectionKey = iterator.next();
                iterator.remove();
                if(selectionKey.isAcceptable()){
                    SocketChannel socketChannel = ((ServerSocketChannel) selectionKey.channel()).accept();
                    socketChannel.configureBlocking(false);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if(selectionKey.isReadable()){
                    SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(32);
                    int len = socketChannel.read(buffer);
                    if(len == -1){
                        throw  new RuntimeException("连接已断开");
                    }
                    byte[] buf = new byte[len];
                    buffer.flip();
                    buffer.get(buf);
                    System.out.println("recv:" + new String(buf, 0, len));
                    selectionKey.interestOps(selectionKey.interestOps() | SelectionKey.OP_WRITE);
                } else if(selectionKey.isWritable()){
                    SocketChannel socketChannel = (SocketChannel)selectionKey.channel();
                    int len = socketChannel.write(ByteBuffer.wrap("hello".getBytes()));
                    if(len == -1){
                        throw  new RuntimeException("连接已断开");
                    }
                    selectionKey.interestOps(selectionKey.interestOps() & ~SelectionKey.OP_WRITE);
                }
            }
        }
    }
}
