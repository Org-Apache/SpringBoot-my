package com.my.day;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ThreadPoolDemo {
    public static void main(String[] args)throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(10);
        //提交10个任务为线程池执行，并记录每个任务的执行结果
        List<Future<Integer>> results = new ArrayList<>();
        for(int i=0;i<10;i++){
            Callable<Integer> task = new ThreadPoolTask();
            Future<Integer> result = executor.submit(task);
            results.add(result);
        }
        //等待所有任务执行完毕
        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);

        //输出所有任务的执行结果
        int total = 0;
        for(int i = 0;i<10;i++){
            try {
                Integer result = results.get(i).get();
                System.out.println(String.format("Task %s result is %d", i,result));
                total += result;
            }catch (Exception e){
                System.out.println(String.format("Task %s execution error : %s",i,e.getCause().getMessage()));
            }
        }
        System.out.println("Total result is"+total);
    }
}
class ThreadPoolTask implements Callable<Integer> {
    private int id;
    public void ThreadPoolTask(int id){
        this.id = id ;
    }
    @Override
    public Integer call() throws Exception {
        System.out.println(String.format("The Thread %s is Running", id));
        Thread.sleep(2000);
        if(id % 2 ==0){
            throw new RuntimeException(String.format("Task %s execution error !", id));
        }
        return id*10;
    }
}
