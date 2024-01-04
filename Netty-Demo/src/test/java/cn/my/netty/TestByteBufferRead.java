package cn.my.netty;

import java.nio.ByteBuffer;

public class TestByteBufferRead {
    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(10);
        buffer.put(new byte[]{'a','b','c','d'});
        buffer.flip();
        System.out.println(  buffer.get(new byte[4]));
    }
}
