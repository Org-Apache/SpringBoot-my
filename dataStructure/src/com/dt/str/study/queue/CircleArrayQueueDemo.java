package com.dt.str.study.queue;

import java.util.Scanner;

public class CircleArrayQueueDemo {

    public static void main(String[] args) {
        //测试队列
        //创建一个队列
        ArrayQueue queue = new ArrayQueue(3);
        char key = ' ';//用来接受用户的输入
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        //输出一个菜单
        while (flag) {
            System.out.println("s(show)：显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 取出队列数据");
            System.out.println("h(head)：显示头部数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's':
                    System.out.println("队列数据如下所示：");
                    queue.showQueue();
                    break;
                case 'e':
                    flag = false;
                    System.out.println("程序已经退出");
                    ;
                    break;
                case 'a':
                    System.out.println("请输入一个整数");
                    queue.addQueue(scanner.nextInt());
                    break;
                case 'g':
                    System.out.println("取得的数据为：");
                    try {
                        System.out.println(queue.getQueue());
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    ;
                    break;
                case 'h':
                    System.out.println("取得的数据为：");
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

//使用数组模拟队列-编写一个ArrayQueue类
class CircleQueue {
    private int maxSize;//数组最大容量
    private int front;//队列头
    private int rear;//队列尾部
    private int[] arr;//该数组用来存放队列，模拟队列

    //创建队列的构造器
    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;//指向队列中的第一个位置，
        rear = 0;//指向队列尾部
    }

    //判断队列是否满
    public boolean isFull() {

        return (rear+1) % maxSize == front;
    }

    //判断队列是否为空
    public boolean isEmpty() {

        return rear == front;
    }

    //添加数据到队列
    public void addQueue(int n) {
        //首先判断队列是否满
        if (isFull()) {
            System.out.println("队列不能加入数据！");
            return;
        } else {
            arr[rear] = n;
            rear++;
        }
    }

    //获取队列的数据
    public int getQueue() {
        //判断队列是否为空
        if (isEmpty()) {
            //通过抛出异常来处理
            throw new RuntimeException("队列空，不能取数据！");
        }
        //这里需要分析出front是指向队列的第一个元素
        //先将front对应的值放在一个临时变量中
        //front往后移一位
        //将临时变量返回
        int data  = arr[front];
        //后移考虑越界,即front++ > maxSize ,比最大值还大，数组下标越界
        front = (front + 1) % maxSize;
        return data;
    }

    //显示队列的所以数据
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列是空的，无法遍历");
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

    //显示头数据
    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能获取数据！");
        }
        return arr[front];
    }
}