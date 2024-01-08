package com.my.day;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {
    public static void main(String[] args) {
        //创建一个线程池
        ExecutorService executor = Executors.newFixedThreadPool(10);
        //提交10个Callable任务给线程池执行
        Future<Integer>[] results = new Future[10];
        for(int i=0;i<10;i++){
            Callable<Integer> task = new CallableTast(i);
            results[i] = executor.submit(task);
        }
        //输出Callable任务的执行结果
        for(int i=0;i<10;i++){
            try {
                Integer result = results[i].get();
                System.out.println(String.format("Task %s result is %s",i,result));
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        //关闭线程池
        executor.shutdown();
    }
}
/*
* CallableTast类实现了Callable接口，并重写了call()方法，在方法中虚拟
* 了一个需要执行1秒钟的任务，并返回一个结果。
* */
class CallableTast implements Callable<Integer> {

    private int id;
    public CallableTast(int id){
       this.id = id;
    }
    public Integer call(){
        System.out.println(String.format("The Thread %s is running", id));
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return id * 10;
    }
}
