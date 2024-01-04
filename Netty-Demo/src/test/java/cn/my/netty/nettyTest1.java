package cn.my.netty;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

@Slf4j
public class nettyTest1 {
    public static void main(String[] args) {
        // FileChannel �������ݵĶ�дͨ��
        //1.ͨ�����롢�������ȡͨ��
        //2.RandomAccessFile��ȡͨ��
        try (FileChannel channel = new FileInputStream("data.txt").getChannel()) {
            //׼����һ�������� 100���ֽڴ�С��Ϊ������
            ByteBuffer buffer = ByteBuffer.allocate(100);
            while(true){
                //��channel��ȡ���ݣ�д��buffer��
                int len = channel.read(buffer);
                log.debug("��ȡ�����ֽ���{}",len);
                if(len == -1){
                    break;
                }
                //��ӡbuffer������
                buffer.flip();//�л���buffer�Ķ�ģʽ
                while(buffer.hasRemaining()){//���ʣ�������
                    byte b = buffer.get();//��һ���ֽ�
                    log.debug("��ȡ�����ֽ�{}",(char)b);
                }
                //�ڶ���һ���Ժ�bufferҪ�л�Ϊдģʽ
                buffer.clear();
            }
        } catch (IOException e) {
        };
    }
}
