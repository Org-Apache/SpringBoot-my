package com.my.day;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {
    public static void main(String[] args) {
        //创建一个包含10个线程的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);
        //提交10个任务给线程池执行
        for(int i =0;i<10;i++){
            service.execute(new MyTask2(i));
        }
        //关闭线程池
        service.shutdown();
    }
}

class MyTask2 implements Runnable{
    private int id;

    public MyTask2(int id){
        this.id = id ;
    }
    public void run(){
        System.out.println(String.format("Thread %d is runing", id));
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
