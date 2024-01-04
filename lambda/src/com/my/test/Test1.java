package com.my.test;

import com.my.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        //添加学生信息
        List <Student> list = new ArrayList<>();
        list.add(new Student("鸡哥",20L,"女"));
        list.add(new Student("坤哥",21L,"男"));
        list.add(new Student("蔡哥",22L,"女"));
        list.add(new Student("徐哥",23L,"男"));
        //只查找一位学生中年龄大于22的
        //test1.method1(list);
        //test1.method2(list);

        //查找所有性别为女的学生信息
//        test1.method3(list);
        //获取前三名学生的信息
        test1.method4(list);

        //查询出全部学生的个数
        test1.method5(list);

        //取出集合里重复的元素
        test1.method6();

        //对集合内的元素进行排序
        test1.method7();
    }

    private void method1(List<Student> list){
        List <Student> specialStu = new ArrayList<>();
        int limit = 1;
        int counter = 0;
        for (Student stulist : list){
            if (stulist.getAge() > 22){
                specialStu.add(stulist);
                counter ++;
                if (counter == limit){
                    break;
                }
            }
        }
        specialStu.forEach(System.out::println);
    }
    private void method2(List<Student> list){
        List <Student> specialStu = list.stream().filter(student -> student.getAge() > 22).limit(1).collect(Collectors.toList());
        specialStu.forEach(System.out::println);
    }
    private void method3(List<Student> list){
        List <Student> specialStu = list.stream()
                .filter(student -> "女".equals(student.getSex()))
                .collect(Collectors.toList());
        specialStu.forEach(System.out::println);
    }
    private void method4(List<Student> list){
        List <Student> specialStu = list.stream()
                .limit(3)
                .collect(Collectors.toList());
        specialStu.forEach(System.out::println);
    }
    private void method5(List<Student> list){
        Long count = list.stream().count();
        System.out.println(String.format("全部学生的个数为%d",count));
    }

    private void method6(){
        List<String> str = new ArrayList<>();
        str.add("h");
        str.add("e");
        str.add("l");
        str.add("l");
        str.add("o");
        List<String> uniqueList = str.stream().distinct().collect(Collectors.toList());
        uniqueList.forEach(System.out::print);
        System.out.println("\n");
    }

    private void method7(){
        List<Integer> str = new ArrayList<>();
        str.add(1);
        str.add(3);
        str.add(4);
        str.add(5);
        str.add(9);
        str.add(2);
        str.add(0);
        List<Integer> sortList = str.stream()
                .sorted()
                .collect(Collectors.toList());
        sortList.forEach(System.out::print);
    }





}
