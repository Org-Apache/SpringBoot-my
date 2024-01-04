package com.dt.str.study.link;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //测试
        System.out.println("双向链表的测试");
        //先创建节点
        HeroNode2 heroNode1 = new HeroNode2(1, "松江", "及时雨");
        HeroNode2 heroNode2= new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 heroNode3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 heroNode4 = new HeroNode2(4, "公孙胜", "入云龙");
        //创建一个双向链表
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);
        doubleLinkedList.list();

        //修改一个节点
//        System.out.println("修改一个节点");
//        HeroNode2 heroNode5 = new HeroNode2(4, "唐三藏", "玄奘");
//        doubleLinkedList.update(heroNode5);
//        doubleLinkedList.list();

        //删除一个节点
        System.out.println("删除一个节点");
        doubleLinkedList.delete(3);
        doubleLinkedList.list();
        System.out.println("按顺序添加节点");
        HeroNode2 heroNode5 = new HeroNode2(3, "唐三藏", "玄奘");
        HeroNode2 heroNode6 = new HeroNode2(5, "沙僧", "沙悟净");
        doubleLinkedList.addByOrder(heroNode5);
        doubleLinkedList.addByOrder(heroNode6);
        doubleLinkedList.list();
    }
}

//创建一个双向链表的类
class DoubleLinkedList{
    //先初始化一个头结点，头结点不要动
    private HeroNode2 head = new HeroNode2(0,"","");
    public HeroNode2 getHead() {
        return head;
    }

    //遍历双向链表的方法
    public void list(){
        //先判断链表是否为空
        if(head.next == null){
            System.out.println("链表为空！");
            return;
        }
        //因为头结点不能动，因此我们需要一个辅助变量来遍历
        HeroNode2 temp = head.next;
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

    //添加数据
    public void add(HeroNode2 node){
        //思路：当不考虑编号的顺序时，找到当前链表的最后节点，然后将最后节点的next指向最新的这个节点
        //因为head节点不能动，因此我们需要一个辅助遍历·temp
        HeroNode2 temp = head;
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
        //最后的这个节点的next指向新的节点.形成一个双向链表
        temp.next = node;
        node.pre = temp;
    }

    //根据顺序添加数据
    public void addByOrder(HeroNode2 node){
        //如果链表为空
        if(head.next == null){
            head.next = node;
            node.pre = head;
            return;
        }
        HeroNode2 temp = head.next;
        boolean flag = false;
        while (temp != null){
            if(node.no < temp.no){
                flag = true;
                break;
            }
            if(temp.next != null){
                temp = temp.next;
            }else{
                break;
            }

        }
        if(flag){
            temp.pre.next = node;
            node.next = temp;
        }else{
            temp.next = node;
            node.pre = temp;
        }
    }

    //修改一个节点的内容
    //修改节点的信息，根据编号来修改，即no编号不能修改
    public void update(HeroNode2 newHeroNode){
        //根据newHeroNode的no来修改即可
        //判断是否为空
        if(head.next == null){
            System.out.println("链表为空！");
            return;
        }
        //找到需要修改的节点，根据no编号
        //定义一个辅助遍历
        HeroNode2 temp = head.next;
        //表示是否找到该节点
        boolean flag = false;
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

    //从双向链表中删除一个节点
    //说明，对于双向链表，我们可以直接找到要删除的节点，找到之后自我删除即可
    public void delete(int no){
        //判断当前链表是否为空
        //空链表
        if(head.next == null){
            System.out.println("链表为空，不能删除");
            return;
        }
        //辅助变量
        HeroNode2 temp = head.next;

        //标识是否找到了待删除的节点
        boolean flag =false;
        while (true){
            if(temp == null){
                break;
            }
            if(temp.no == no){
                flag =true;
                break;
            }
            temp = temp.next;
        }

        //说明找到，可以删除
        if(flag){
            temp.pre.next = temp.next;
            //如果是最后一个节点，就不需要执行下面的代码，否则会出现空指针异常
            if(temp.next != null){
                temp.next.pre = temp.pre;
            }

        }else{
            System.out.println("没有找到待删除的节点");
        }
    }
}

//定义一个heroNode节点，每一个HerNode就是一个节点
class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;//指向下一个节点，默认为null
    public HeroNode2 pre;//指向前一个节点，默认为null

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }


    public HeroNode2() {
    }

    //为了显示方便，我们重写toString()
    @Override
    public String toString() {
        return "HeroNode2 [no="+no+",name="+name+",nickname="+nickname+"]";
    }
}
