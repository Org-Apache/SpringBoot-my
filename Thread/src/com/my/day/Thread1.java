package com.my.day;

public class Thread1 {
    public static void main(String[] args) {
        //创建10个线程并启动
        for(int i=0;i<10;i++){
            MyThread thread = new MyThread(i);
            thread.run();
        }
    }
}
class MyThread extends Thread{
    private int id;

    MyThread(int id){
        this.id = id;
    }
    public void run(){
//        System.out.println("Thread"+id+"is runing");
        System.out.println(String.format("Thread %d is runing", id));
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

}
