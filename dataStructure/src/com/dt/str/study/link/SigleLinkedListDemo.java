package com.dt.str.study.link;

public class SigleLinkedList {
    public static void main(String[] args) {

    }
}

//����һ��heroNode�ڵ㣬ÿһ��HerNode����һ���ڵ�
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname, HeroNode next) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
        this.next = next;
    }

    public HeroNode() {
    }

    //Ϊ����ʾ���㣬������дtoString()
    @Override
    public String toString() {
        return "HeroNode [no="+no+",name="+name+",nickname="+nickname+"]";
    }
}
