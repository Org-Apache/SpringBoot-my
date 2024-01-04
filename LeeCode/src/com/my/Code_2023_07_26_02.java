package com.my;
// 2
public class Code_2023_07_26_02 {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode node = new ListNode(-1);
        ListNode curNode = node;
        int t = 0;
        while(l1 != null || l2 != null || t != 0){
            if(l1 != null){
                t += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                t += l2.val;
                l2 = l2.next;
            }
            curNode.next = new ListNode(t%10);
            curNode = curNode.next;
            t = t/10;
        }
        return node.next;
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next;}
    }
}
