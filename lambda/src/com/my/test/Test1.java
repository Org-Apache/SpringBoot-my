package com.my.test;

import com.my.entity.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        //���ѧ����Ϣ
        List <Student> list = new ArrayList<>();
        list.add(new Student("����",20L,"Ů"));
        list.add(new Student("����",21L,"��"));
        list.add(new Student("�̸�",22L,"Ů"));
        list.add(new Student("���",23L,"��"));
        //ֻ����һλѧ�����������22��
        //test1.method1(list);
        //test1.method2(list);

        //���������Ա�ΪŮ��ѧ����Ϣ
//        test1.method3(list);
        //��ȡǰ����ѧ������Ϣ
        test1.method4(list);

        //��ѯ��ȫ��ѧ���ĸ���
        test1.method5(list);

        //ȡ���������ظ���Ԫ��
        test1.method6();

        //�Լ����ڵ�Ԫ�ؽ�������
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
                .filter(student -> "Ů".equals(student.getSex()))
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
        System.out.println(String.format("ȫ��ѧ���ĸ���Ϊ%d",count));
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
