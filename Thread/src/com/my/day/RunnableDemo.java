package com.my.day;

public class RunnableDemo {
    public static void main(String[] args) {
        for(int i = 0;i< 10 ;i++){
            Runnable task = new MyTask(i);
            Thread thread = new Thread(task);
            thread.start();
        }
    }
}

class MyTask implements Runnable{
    private int id;
    public MyTask(int id){
        this.id = id;
    }
    public void run(){
        System.out.println(String.format("The Thread %d is Running", id));
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

