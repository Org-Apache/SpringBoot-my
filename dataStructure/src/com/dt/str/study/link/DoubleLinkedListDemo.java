package com.dt.str.study.link;

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //����
        System.out.println("˫������Ĳ���");
        //�ȴ����ڵ�
        HeroNode2 heroNode1 = new HeroNode2(1, "�ɽ�", "��ʱ��");
        HeroNode2 heroNode2= new HeroNode2(2, "¬����", "������");
        HeroNode2 heroNode3 = new HeroNode2(3, "����", "�Ƕ���");
        HeroNode2 heroNode4 = new HeroNode2(4, "����ʤ", "������");
        //����һ��˫������
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(heroNode1);
        doubleLinkedList.add(heroNode2);
        doubleLinkedList.add(heroNode3);
        doubleLinkedList.add(heroNode4);
        doubleLinkedList.list();

        //�޸�һ���ڵ�
//        System.out.println("�޸�һ���ڵ�");
//        HeroNode2 heroNode5 = new HeroNode2(4, "������", "����");
//        doubleLinkedList.update(heroNode5);
//        doubleLinkedList.list();

        //ɾ��һ���ڵ�
        System.out.println("ɾ��һ���ڵ�");
        doubleLinkedList.delete(3);
        doubleLinkedList.list();
        System.out.println("��˳����ӽڵ�");
        HeroNode2 heroNode5 = new HeroNode2(3, "������", "����");
        HeroNode2 heroNode6 = new HeroNode2(5, "ɳɮ", "ɳ��");
        doubleLinkedList.addByOrder(heroNode5);
        doubleLinkedList.addByOrder(heroNode6);
        doubleLinkedList.list();
    }
}

//����һ��˫���������
class DoubleLinkedList{
    //�ȳ�ʼ��һ��ͷ��㣬ͷ��㲻Ҫ��
    private HeroNode2 head = new HeroNode2(0,"","");
    public HeroNode2 getHead() {
        return head;
    }

    //����˫������ķ���
    public void list(){
        //���ж������Ƿ�Ϊ��
        if(head.next == null){
            System.out.println("����Ϊ�գ�");
            return;
        }
        //��Ϊͷ��㲻�ܶ������������Ҫһ����������������
        HeroNode2 temp = head.next;
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

    //�������
    public void add(HeroNode2 node){
        //˼·���������Ǳ�ŵ�˳��ʱ���ҵ���ǰ��������ڵ㣬Ȼ�����ڵ��nextָ�����µ�����ڵ�
        //��Ϊhead�ڵ㲻�ܶ������������Ҫһ������������temp
        HeroNode2 temp = head;
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
        //��������ڵ��nextָ���µĽڵ�.�γ�һ��˫������
        temp.next = node;
        node.pre = temp;
    }

    //����˳���������
    public void addByOrder(HeroNode2 node){
        //�������Ϊ��
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

    //�޸�һ���ڵ������
    //�޸Ľڵ����Ϣ�����ݱ�����޸ģ���no��Ų����޸�
    public void update(HeroNode2 newHeroNode){
        //����newHeroNode��no���޸ļ���
        //�ж��Ƿ�Ϊ��
        if(head.next == null){
            System.out.println("����Ϊ�գ�");
            return;
        }
        //�ҵ���Ҫ�޸ĵĽڵ㣬����no���
        //����һ����������
        HeroNode2 temp = head.next;
        //��ʾ�Ƿ��ҵ��ýڵ�
        boolean flag = false;
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

    //��˫��������ɾ��һ���ڵ�
    //˵��������˫���������ǿ���ֱ���ҵ�Ҫɾ���Ľڵ㣬�ҵ�֮������ɾ������
    public void delete(int no){
        //�жϵ�ǰ�����Ƿ�Ϊ��
        //������
        if(head.next == null){
            System.out.println("����Ϊ�գ�����ɾ��");
            return;
        }
        //��������
        HeroNode2 temp = head.next;

        //��ʶ�Ƿ��ҵ��˴�ɾ���Ľڵ�
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

        //˵���ҵ�������ɾ��
        if(flag){
            temp.pre.next = temp.next;
            //��������һ���ڵ㣬�Ͳ���Ҫִ������Ĵ��룬�������ֿ�ָ���쳣
            if(temp.next != null){
                temp.next.pre = temp.pre;
            }

        }else{
            System.out.println("û���ҵ���ɾ���Ľڵ�");
        }
    }
}

//����һ��heroNode�ڵ㣬ÿһ��HerNode����һ���ڵ�
class HeroNode2{
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next;//ָ����һ���ڵ㣬Ĭ��Ϊnull
    public HeroNode2 pre;//ָ��ǰһ���ڵ㣬Ĭ��Ϊnull

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }


    public HeroNode2() {
    }

    //Ϊ����ʾ���㣬������дtoString()
    @Override
    public String toString() {
        return "HeroNode2 [no="+no+",name="+name+",nickname="+nickname+"]";
    }
}
