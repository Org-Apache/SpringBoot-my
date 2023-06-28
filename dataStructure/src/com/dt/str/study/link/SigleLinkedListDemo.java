package com.dt.str.study.link;

public class SigleLinkedList {
    public static void main(String[] args) {

    }
}

//定义一个heroNode节点，每一个HerNode就是一个节点
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

    //为了显示方便，我们重写toString()
    @Override
    public String toString() {
        return "HeroNode [no="+no+",name="+name+",nickname="+nickname+"]";
    }
}
