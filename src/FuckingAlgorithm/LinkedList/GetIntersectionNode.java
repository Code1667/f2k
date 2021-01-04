package FuckingAlgorithm.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wq
 * @date 2020-03-24 9:18
 * 找出链表中相交节点
 * leetcode160
 */
public class GetIntersectionNode {
    /**
     * 方法一：将A链表添加到集合，用contains方法判断节点包含否
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA,ListNode headB){
        List<ListNode> nodes = new ArrayList<>();
        while(headA!=null){
            nodes.add(headA);
            headA = headA.next;
        }
        while(headB!=null){
            if(nodes.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 方法二：比较长度，移动头节点至并列，一起遍历  当头节点相等时候返回
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode2(ListNode headA,ListNode headB){
        int lenA = getLength(headA);
        int lenB = getLength(headB);
        int d = lenA - lenB;
        int absd = Math.abs(d);
        if(d>0){
            while (headA!=null && d!=0){
                headA= headA.next;
                d--;
            }
        }else if(d<0){
            while (headB!=null && absd!=0){
                headB= headB.next;
                absd--;
            }
        }
        while (headA!=null && headB!= null){
            if(headA == headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }


    /**
     * 计算链表长度
     * @param head
     * @return
     */
    public static int getLength(ListNode head){
        int len = 0;
        while(head!=null){
            len++;
            head= head.next;
        }
        return len;
    }



    public static void main(String[] args) {
        ListNode a1 = new ListNode(4);
        ListNode a2 = new ListNode(1);
        ListNode a3 = new ListNode(8);
        ListNode a4 = new ListNode(6);
        ListNode a5 = new ListNode(5);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = null;

        ListNode headA = a1;


        ListNode b1 = new ListNode(5);
        ListNode b2 = new ListNode(0);
        ListNode b3 = new ListNode(1);
        ListNode b4 = a3;
        ListNode b5 = a4;
        ListNode b6 = a5;

        b1.next = b2;
        b2.next = b3;
        b3.next = b4;
        b4.next = b5;
        b5.next = b6;
        b6.next = null;

        ListNode headB = b1;

        System.out.println(getIntersectionNode2(headA, headB));

    }
}
