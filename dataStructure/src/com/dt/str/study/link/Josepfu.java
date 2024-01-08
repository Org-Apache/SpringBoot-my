package com.dt.str.study.link;

public class Josepfu {
    public static void main(String[] args) {
        //����һ�ѣ����������Ļ�������ͱ����Ƿ���ȷ
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(5);
        circleSingleLinkedList.showBoy();
        circleSingleLinkedList.countBoy(1,2,5);

    }
}
//����һ�����εĵ�������
class CircleSingleLinkedList{

    //����һ��first�ڵ㣬��ǰû�б��/**/
    private Boy first = new Boy(-1);

    //���С���ڵ㣬������һ�����ε�����
    public void addBoy(int nums){
        //��һ������У��
        if(nums < 1){
            System.out.println("nums��ֵ����ȷ");
            return;
        }

        //����ָ�룬�������ǹ�����������
        Boy curBoy = null;
        //ʵ��һ��forѭ����������������
        for(int i = 1 ; i <= nums ; i++){
            //���ݱ�ţ������ڵ�
            Boy boy = new Boy(i);
            //����ǵ�һ���ڵ�
            if(i == 1){
                first = boy;
                first.setNext(first);
                curBoy = first;//��curBoyָ���һ��С��
            }else{
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }
        }
    }

    //��������ǰ��������
    public void showBoy(){
        //�ж��Ƿ���һ���յ�����
        if(first.getNext() == null){
            System.out.println("����Ϊ��");
            return;
        }
        //��Ϊfirst���ܶ������������Ȼʵ��һ������ָ�룬��ɱ���
        Boy curBoy = first;
        while (true){
            System.out.printf("С���ı��%d\n",curBoy.getNo());
            if(curBoy.getNext() == first){
                //˵���Ѿ��������
                break;
            }
            curBoy = curBoy.getNext();
        }
    }

    //�����û������룬�����С����Ȧ��˳��
    /*
    * @param startNo ��ʾ�ӵڼ���С����ʼ����
    * @param countNum ��ʾ������
    * @param nums ��ʾ����ж���С����Ȧ��
    * */
    public void countBoy(int startNo,int countNum,int nums){
        //�ȶ����ݽ���У��
        if(first == null || startNo < 1 || startNo > nums){
            System.out.println("����Ĳ�������������������");
            return;
        }
        //����һ������ָ�룬�������С����Ȧ
        Boy helper = first;
        while(helper.getNext() != first){
            helper = helper.getNext();
        }

        //����ǰ������first��helper�ƶ�k-1��
        for(int i = 0; i < startNo -1 ;i++){
            first = first.getNext();
            helper = helper.getNext();
        }

        //��С������ʱ����first��helperָ��ͬʱ���ƶ� m-1�Σ�Ȼ���Ȧ
        //������һ��ѭ��������ֱ��Ȧ��ֻ��һ���ڵ�
        while (true){
            if(helper == first){
                //˵��Ȧ��ֻ��һ���ڵ�
                break;
            }else{
                //��first��helperͬʱ�ƶ�countNum - 1�Σ�Ȼ���Ȧ
                for(int j = 0;j < countNum -1 ;j++){
                    first = first.getNext();
                    helper = helper.getNext();
                }
                //��ʱfirstָ��Ľ�����Ҫ��Ȧ�Ľڵ�
                System.out.printf("С��%d��Ȧ\n",first.getNo());
                first = first.getNext();
                helper.setNext(first);
            }
        }
        System.out.printf("�������Ȧ�е�С�����Ϊ%d\n",first.getNo());

    }
}

//�ȶ���һ��boy�࣬��ʾһ���ڵ�
class Boy{
    private int no;//���
    private Boy next;//ָ����һ���ڵ�
    public Boy(int no){
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }

}