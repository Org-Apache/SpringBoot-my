package com.dt.str.study.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        //���Զ���
        //����һ������
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';//���������û�������
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        //���һ���˵�
        while (flag) {
            System.out.println("s(show)����ʾ����");
            System.out.println("e(exit): �˳�����");
            System.out.println("a(add): ������ݵ�����");
            System.out.println("g(get): ȡ����������");
            System.out.println("h(head)����ʾͷ������");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    System.out.println("��������������ʾ��");
                    queue.showQueue();
                    break;
                case 'e':
                    flag = false;
                    System.out.println("�����Ѿ��˳�");
                    ;
                    break;
                case 'a':
                    System.out.println("������һ������");
                    queue.addQueue(scanner.nextInt());
                    break;
                case 'g':
                    System.out.println("ȡ�õ�����Ϊ��");
                    try {
                        System.out.println(queue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    ;
                    break;
                case 'h':
                    System.out.println("ȡ�õ�����Ϊ��");
                    try {
                        System.out.println(queue.headQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
                    break;
            }

        }
    }

}

//ʹ������ģ�����-��дһ��ArrayQueue��
class CircleQueue {
    private int maxSize;//�����������
    private int front;//����ͷ
    private int rear;//����β��
    private int[] arr;//������������Ŷ��У�ģ�����

    //�������еĹ�����
    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;//ָ������еĵ�һ��λ�ã�
        rear = 0;//ָ�����β��
    }

    //�ж϶����Ƿ���
    public boolean isFull() {

        return (rear+1) % maxSize == front;
    }

    //�ж϶����Ƿ�Ϊ��
    public boolean isEmpty() {

        return rear == front;
    }

    //������ݵ�����
    public void addQueue(int n) {
        //�����ж϶����Ƿ���
        if (isFull()) {
            System.out.println("���в��ܼ������ݣ�");
            return;
        } else {
            arr[rear] = n;
            rear++;
        }
    }

    //��ȡ���е�����
    public int getQueue() {
        //�ж϶����Ƿ�Ϊ��
        if (isEmpty()) {
            //ͨ���׳��쳣������
            throw new RuntimeException("���пգ�����ȡ���ݣ�");
        }
        //������Ҫ������front��ָ����еĵ�һ��Ԫ��
        //�Ƚ�front��Ӧ��ֵ����һ����ʱ������
        //front������һλ
        //����ʱ��������
        int data  = arr[front];
        //���ƿ���Խ��,��front++ > maxSize ,�����ֵ���������±�Խ��
        front = (front + 1) % maxSize;
        return data;
    }

    //��ʾ���е���������
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("�����ǿյģ��޷�����");
        } else {
            for (int i = front; i < front + valiableSize(); i++) {
                System.out.printf("%d\t", arr[i % maxSize]);
            }
            System.out.println();
        }
    }

    public int valiableSize(){
        return (rear + maxSize - front ) % maxSize;
    }

    //��ʾͷ����
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("����Ϊ�գ����ܻ�ȡ���ݣ�");
        }
        return arr[front];
    }
}