package com.dt.str.study.link;

import java.util.Stack;

import static com.dt.str.study.link.SingleLikedList.*;

public class SigleLinkedListDemo {
    public static void main(String[] args) {
        //���в���
        //�ȴ����ڵ�
        HeroNode heroNode1 = new HeroNode(1, "�ɽ�", "��ʱ��");
        HeroNode heroNode2= new HeroNode(2, "¬����", "������");
        HeroNode heroNode3 = new HeroNode(3, "����", "�Ƕ���");
        HeroNode heroNode4 = new HeroNode(4, "����ʤ", "������");

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

        System.out.println("----���Ե�����ķ�ת");
        reverseList(singleLikedList.getHead());
        singleLikedList.list();

        System.out.println("���������ӡ������--û�иı�������Ľṹ");
        reversePrint(singleLikedList.getHead());
    }
}
//����һ��SingleLinkedList �������ǵ�Ӣ��
class SingleLikedList{
    //�ȳ�ʼ��һ��ͷ��㣬ͷ��㲻Ҫ��
    private HeroNode head = new HeroNode(0,"","");

    public HeroNode getHead() {
        return head;
    }

    public void add(HeroNode node){
        //˼·���������Ǳ�ŵ�˳��ʱ���ҵ���ǰ��������ڵ㣬Ȼ�����ڵ��nextָ�����µ�����ڵ�
        //��Ϊhead�ڵ㲻�ܶ������������Ҫһ������������temp
        HeroNode temp = head;
        //���������ҵ����
        while(true){
            //�ҵ���������
            if(temp.next == null){
                break;
            }
            //���û���ҵ����ͽ�temp����
            temp = temp.next;
        }
        //���˳�whileѭ���ǣ�temp��ָ������������
        //����������ڵ��nextָ���µĽڵ�
        temp.next = node;
    }

    //��ʾ����
    public void list(){
        //���ж������Ƿ�Ϊ��
        if(head.next == null){
            System.out.println("����Ϊ�գ�");
            return;
        }
        //��Ϊͷ��㲻�ܶ������������Ҫһ����������������
        HeroNode temp = head.next;
        while(true){
            //�ж��Ƿ���������
            if(temp == null){
                break;
            }
            //����ڵ����Ϣ
            System.out.println(temp);
            //��temp���ƣ���Ȼ�������ѭ��
            temp = temp.next;
        }
    }

     /*
     *�ڶ��ַ�ʽ�����Ӣ��ʱ������������Ӣ�۲��뵽ָ��λ��
     * ���������������������ʧ�ܣ���������ʾ��
     * */
    public void addByOrder(HeroNode heroNode){
        //��Ϊͷ��㲻�ܶ������������Ȼ��Ҫһ�����������������ҵ���ӵ�λ��
        //�����ҵ����tempλ�����λ�õ�ǰһ���ڵ㣬������벻��
        HeroNode temp = head;
        //��ʶ��ӵı���Ƿ���ڣ�Ĭ��Ϊfalse
        boolean flag = false;
        while(true){
            if(temp.next == null){
                //˵��temp�Ѿ�����������
                break;
            }
            if(temp.next.no > heroNode.no){
                //λ���ҵ��ˣ�����temp�ĺ������
                break;
            }else if(temp.next.no == heroNode.no){
                //˵��ϣ����ӵ�heroNode�ı���Ѿ����ڡ�

                //˵����Ŵ���
                flag =true;
                break;
            }
            //���ƣ�������ǰ������
            temp = temp.next;

        }
        //�ж�flag��ֵ��
        if(flag){
            //������ӣ�˵����Ŵ���
            System.out.println("׼������Ľڵ��Ѿ����ڣ����ܼ��룡");
        }else{
            //���뵽�����У�temp�ĺ���
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    //�޸Ľڵ����Ϣ�����ݱ�����޸ģ���no��Ų����޸�
    public void update(HeroNode newHeroNode){
        //����newHeroNode��no���޸ļ���
        //�ж��Ƿ�Ϊ��
        if(head.next == null){
            System.out.println("����Ϊ�գ�");
            return;
        }
        //�ҵ���Ҫ�޸ĵĽڵ㣬����no���
        //����һ����������
        HeroNode temp = head.next;
        boolean flag =false;//��ʾ�Ƿ��ҵ��ýڵ�
        while (true){
            if(temp == null){
                break;
            }
            if(temp.no == newHeroNode.no){
                //�ҵ���
                flag = true;
                break;
            }
            temp  = temp.next;
        }
        //����falg�ж��Ƿ��ҵ�����Ҫ�޸ĵĽڵ�
        if(flag){
            temp.name = newHeroNode.name;
            temp.nickname = newHeroNode.nickname;
        }else{
            System.out.println("û���ҵ��ýڵ㣡");
        }
    }

    public void delete(int no){
        if(head.next == null){
            return;
        }
        HeroNode temp = head.next;
        boolean flag =false;//��ʶ�Ƿ��ҵ��˴�ɾ���Ľڵ�
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

        if(flag){//˵���ҵ�������ɾ��
            temp.next = temp.next.next;
        }else{
            System.out.println("û���ҵ���ɾ���Ľڵ�");
        }
    }

    //��ȡ��������ĵ�����Ľڵ�ĸ���������Ǵ�ͷ����������Ҫ��ͳ��ͷ��㣩
    /*
    * @param head �����ͷ���
    * @return ���صľ�����Ч�ڵ�ĸ���
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
     * ���ҵ������еĵ�����K���ڵ�
     * ˼·��
     * 1.��дһ������������head�ڵ㣬ͬʱ����һ��index
     * 2.index��ʾ���ǵ�����index���ڵ�
     * 3.�Ȱ������ͷ��β�������õ����������ܵĳ���getLength
     * 4.�õ�size�����Ǵ�����ĵ�һ����ʼ����������size-index���Ϳ��Եõ�
     * ����ҵ��ˣ��򷵻ظýڵ㣬���򷵻�null
     */
    public static HeroNode findListIndexNode(HeroNode head,int index){
        //�ж��������Ϊ�գ�����null
        if(head.next == null){
            return null;
        }
        //��һ�α����õ�����ĳ���(�ڵ����)
        int size = getLength(head);
        //�ڶ��α���,size-indexλ�ã��������ǵ����ĵ�K���ڵ�
        if(index <= 0 || index > size){
            return null;
        }
        //����һ����������,forѭ����λ�����������index
        HeroNode temp = head.next;
        for(int i = 0; i < size-index ; i++){
            temp = temp.next;
        }
        return temp;
    }

    /**
     * ����������з�ת
     * */
    public static void reverseList(HeroNode head){
        //�����жϵ�ǰ�����Ƿ�Ϊ�գ�����ֻ��һ���ڵ㣬�����跴ת��ֱ�ӷ���
        if(head.next == null || head.next.next == null){
            return;
        }
        //����һ������ָ�룬�������Ǳ���ԭ��������
        HeroNode curr = head.next;
        //���嵱ǰ�ڵ�[curr]����һ���ڵ�
        HeroNode next = null;
        HeroNode reverseHead = new HeroNode(0,"","");
        //����ԭ��������ÿ����һ���ڵ㣬�ͽ���ȡ��������������µ��������ǰ��
        while(curr != null){
            //����ʱ���ֵ�ǰ�ڵ����һ���ڵ㣬��Ϊ������Ҫʵ��
            next = curr.next;
            //��curr����һ���ڵ�ָ���µ��������ǰ��
            curr.next = reverseHead.next;
            reverseHead.next = curr;
            //��current���ƣ�ָ����һ���ڵ�
            curr = next;
        }
        //��head.nextָ��reverseHead.next,ʵ�ֵ�����ķ�ת
        head.next = reverseHead.next;
    }

    //��ʽ2
    public static void reversePrint(HeroNode head){
        if(head.next == null){
            //�������ܴ�ӡ
            return;
        }
        //����һ��յ���������ڵ�ѹ��ջ
        Stack<HeroNode> stack= new Stack<>();
        HeroNode cur = head.next;
        //����������нڵ�ѹ��յ��
        while (cur != null){
            stack.push(cur);
            //�����Ϳ���ѹ����һ���ڵ�
            cur = cur.next;
        }
        //��յ�еĽڵ�ڵ���д�ӡ pop
        while (stack.size() > 0){
            //ջ���ص��ǣ��Ƚ����
            System.out.println(stack.pop());
        }
    }
}

//����һ��heroNode�ڵ㣬ÿһ��HerNode����һ���ڵ�
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

    //Ϊ����ʾ���㣬������дtoString()
    @Override
    public String toString() {
        return "HeroNode [no="+no+",name="+name+",nickname="+nickname+"]";
    }
}
