package cn.my.netty;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
public class nettyTest1 {
    public static void main(String[] args) {
        // FileChannel 代表数据的读写通道
        //1.通过输入、输出流获取通道
        //2.RandomAccessFile获取通道
        try (FileChannel channel = new FileInputStream("data.txt").getChannel()) {
            //准备好一个缓冲区 100个字节大小作为缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(100);
            while(true){
                //从channel读取数据，写到buffer中
                int len = channel.read(buffer);
                log.debug("读取到的字节数{}",len);
                if(len == -1){
                    break;
                }
                //打印buffer的内容
                buffer.flip();//切换到buffer的读模式
                while(buffer.hasRemaining()){//检查剩余的数据
                    byte b = buffer.get();//读一个字节
                    log.debug("读取到的字节{}",(char)b);
                }
                //在读完一次以后，buffer要切换为写模式
                buffer.clear();
            }
        } catch (IOException e) {
        };
    }
}
