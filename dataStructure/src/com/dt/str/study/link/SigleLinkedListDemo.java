package com.dt.str.study.link;

import java.util.Stack;

import static com.dt.str.study.link.SingleLikedList.*;

public class SigleLinkedListDemo {
    public static void main(String[] args) {
        //进行测试
        //先创建节点
        HeroNode heroNode1 = new HeroNode(1, "松江", "及时雨");
        HeroNode heroNode2= new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "公孙胜", "入云龙");

        SingleLikedList singleLikedList = new SingleLikedList();
//        singleLikedList.add(heroNode1);
//        singleLikedList.add(heroNode2);
//        singleLikedList.add(heroNode3);
//        singleLikedList.add(heroNode4);
        singleLikedList.addByOrder(heroNode4);
        singleLikedList.addByOrder(heroNode1);
        singleLikedList.addByOrder(heroNode3);
        singleLikedList.addByOrder(heroNode2);
        singleLikedList.list();

        System.out.println("----测试单链表的反转");
        reverseList(singleLikedList.getHead());
        singleLikedList.list();

        System.out.println("测试逆序打印单链表--没有改变链表本身的结构");
        reversePrint(singleLikedList.getHead());
    }
}
//定义一个SingleLinkedList 管理我们的英雄
class SingleLikedList{
    //先初始化一个头结点，头结点不要动
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode node){
        //思路：当不考虑编号的顺序时，找到当前链表的最后节点，然后将最后节点的next指向最新的这个节点
        //因为head节点不能动，因此我们需要一个辅助遍历·temp
        HeroNode temp = head;
        //遍历链表，找到最后
        while(true){
            //找到链表的最后
            if(temp.next == null){
                break;
            }
            //如果没有找到，就将temp后移
            temp = temp.next;
        }
        //当退出while循环是，temp就指向了链表的最后
        //讲最后的这个节点的next指向新的节点
        temp.next = node;
    }

    //显示链表
    public void list(){
        //先判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空！");
            return;
        }
        //因为头结点不能动，因此我们需要一个辅助变量来遍历
        HeroNode temp = head.next;
        while(true){
            //判断是否到链表的最后
            if(temp == null){
                break;
            }
            //输出节点的信息
            System.out.println(temp);
            //将temp后移，不然会进入死循环
            temp = temp.next;
        }
    }

     /*
     *第二种方式在添加英雄时，根据排名将英雄插入到指定位置
     * （如果有这个排名，则添加失败，并给出提示）
     * */
    public void addByOrder(HeroNode heroNode){
        //因为头结点不能动，因此我们仍然需要一个辅助变量来帮助找到添加的位置
        //我们找到这个temp位于添加位置的前一个节点，否则插入不了
        HeroNode temp = head;
        //标识添加的编号是否存在，默认为false
        boolean flag = false;
        while(true){
            if(temp.next == null){
                //说明temp已经在链表的最后
                break;
            }
            if(temp.next.no > heroNode.no){
                //位置找到了，就在temp的后面插入
                break;
            }else if(temp.next.no == heroNode.no){
                //说明希望添加的heroNode的编号已经存在、

                //说明编号存在
                flag =true;
                break;
            }
            //后移，遍历当前的链表
            temp = temp.next;

        }
        //判断flag的值，
        if(flag){
            //不能添加，说明编号存在
            System.out.println("准备插入的节点已经存在，不能加入！");
        }else{
            //插入到链表中，temp的后面
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //修改节点的信息，根据编号来修改，即no编号不能修改
    public void update(HeroNode newHeroNode){
        //根据newHeroNode的no来修改即可
        //判断是否为空
        if(head.next == null){
            System.out.println("链表为空！");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助遍历
        HeroNode temp = head.next;
        boolean flag =false;//表示是否找到该节点
        while (true){
            if(temp == null){
                break;
            }
            if(temp.no == newHeroNode.no){
                //找到了
                flag = true;
                break;
            }
            temp  = temp.next;
        }
        //根据falg判断是否找到了需要修改的节点
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else{
            System.out.println("没有找到该节点！");
        }
    }

    public void delete(int no){
        if(head.next == null){
            return;
        }
        HeroNode temp = head.next;
        boolean flag =false;//标识是否找到了待删除的节点
        while (true){
            if(temp == null){
                break;
            }
            if(temp.next.no == no){
                flag =true;
                break;
            }

            temp = temp.next;
        }

        if(flag){//说明找到，可以删除
            temp.next = temp.next.next;
        }else{
            System.out.println("没有找到待删除的节点");
        }
    }

    //获取到单链表的单链表的节点的个数（如果是带头结点的链表，需要不统计头结点）
    /*
    * @param head 链表的头结点
    * @return 返回的就是有效节点的个数
    * */
    public static int getLength(HeroNode head){
        if(head.next == null){
            return 0;
        }
        int length = 0;
        HeroNode temp = head.next;
        while(temp != null){
            length ++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 查找单链表中的倒数第K个节点
     * 思路：
     * 1.编写一个方法，接受head节点，同时接收一个index
     * 2.index表示的是倒数第index个节点
     * 3.先把链表从头到尾遍历，得到这个链表的总的长度getLength
     * 4.得到size后，我们从链表的第一个开始遍历，遍历size-index个就可以得到
     * 如果找到了，则返回该节点，否则返回null
     */
    public static HeroNode findListIndexNode(HeroNode head,int index){
        //判断如果链表为空，返回null
        if(head.next == null){
            return null;
        }
        //第一次遍历得到链表的长度(节点个数)
        int size = getLength(head);
        //第二次遍历,size-index位置，就是我们倒数的第K个节点
        if(index <= 0 || index > size){
            return null;
        }
        //定义一个辅助变量,for循环定位到这个倒数的index
        HeroNode temp = head.next;
        for(int i = 0; i < size-index ; i++){
            temp = temp.next;
        }
        return temp;
    }

    /**
     * 将单链表进行反转
     * */
    public static void reverseList(HeroNode head){
        //首先判断当前连败是否为空，或则只有一个节点，则无需反转，直接返回
        if(head.next == null || head.next.next == null){
            return;
        }
        //定义一个辅助指针，帮助我们变量原来的链表
        HeroNode curr = head.next;
        //定义当前节点[curr]的下一个节点
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0,"","");
        //遍历原来的链表，每遍历一个节点，就将其取代，并将其放在新的链表的最前端
        while(curr != null){
            //先暂时保持当前节点的下一个节点，因为后面需要实用
            next = curr.next;
            //讲curr的下一个节点指向新的链表的最前端
            curr.next = reverseHead.next;
            reverseHead.next = curr;
            //让current后移，指向下一个节点
            curr = next;
        }
        //将head.next指向reverseHead.next,实现单链表的反转
        head.next = reverseHead.next;
    }

    //方式2
    public static void reversePrint(HeroNode head){
        if(head.next == null){
            //空链表不能打印
            return;
        }
        //创建一个盏，将各个节点压入栈
        Stack<HeroNode> stack= new Stack<>();
        HeroNode cur = head.next;
        //将链表的所有节点压入盏中
        while (cur != null){
            stack.push(cur);
            //这样就可以压入下一个节点
            cur = cur.next;
        }
        //将盏中的节点节点进行打印 pop
        while (stack.size() > 0){
            //栈的特点是：先进后出
            System.out.println(stack.pop());
        }
    }
}

//定义一个heroNode节点，每一个HerNode就是一个节点
class HeroNode{
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }


    public HeroNode() {
    }

    //为了显示方便，我们重写toString()
    @Override
    public String toString() {
        return "HeroNode [no="+no+",name="+name+",nickname="+nickname+"]";
    }
}
