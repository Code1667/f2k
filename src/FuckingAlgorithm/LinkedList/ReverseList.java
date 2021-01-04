package FuckingAlgorithm.LinkedList;

/**
 * @author wq
 * @date 2020-03-23 23:48
 * 链表反转
 * leetcode206/92
 */

public class ReverseList {

    /**
     * 就地反转法
     * @param head
     * @return
     */
    public static ListNode reverseListNode(ListNode head){
        ListNode new_head = null;
        ListNode next = null;
        while(head!=null){
            next = head.next;   //备份头节点的指针
            head.next = new_head;   //旧的头节点指向新头节点
            new_head = head;    //新的头节点更新（移动位置）为刚遍历到的节点
            head = next;    //继续遍历原链表

        }
        return new_head;
    }

    /**
     * 头插法
     * @param head
     * @return
     */
    public static ListNode reverseListNode2(ListNode head){
        ListNode temp_head = new ListNode(0);//定义节点
        ListNode next = null;//定义指针变量
        while(head!=null){
            next = head.next;
            head.next = temp_head.next;
            temp_head.next = head;
            head = next;
        }
        return temp_head.next;
    }


    /**
     * 反转链表中的一段
     * @param head
     * @param m  第m个节点
     * @param n  第n个节点
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode pre_head = null;   //反转链表头节点的前驱
        ListNode modifiy_tail = null;   //反转链表的尾节点
        ListNode result = head; //最终转换后的表头节点，非特殊情况下为最开始的head

        int mm = m;
        while(head!=null&&--mm!=0){
            pre_head = head;    //头节点赋值给需要反转的前驱节点
            head = head.next;   //将head指向要反转的开始节点
        }

        modifiy_tail = head;    //尾节点就是没反转的头！

        int count = (n-m+1);    //需要反转的个数
        ListNode new_head = null;
        ListNode next = null;
        while(head!=null && count !=0){
            next = head.next;   //备份头节点的指针
            head.next = new_head;   //旧的头节点指向新头节点
            new_head = head;    //新的头节点更新（移动位置）为刚遍历到的节点
            head = next;    //继续遍历原链表
            count--;
        }

        modifiy_tail.next = head;


        if(pre_head!=null){
            pre_head.next = new_head;
        }else{
            result = new_head;  //如果pre_head为空
        }

        return result;
    }

    public static ListNode reverseBetween2(ListNode head, int m, int n) {
        ListNode result = head;//保存当前头节点
        ListNode pre_head = null;//反转部分开头节点的前驱
        ListNode tail = null;//反转的尾节点

        //先找需要反转的头节点的前驱
        int mm = m;
        while (head!=null && mm!=1){//mm=1代表head已经指向要反转的部分开头了
            pre_head = head;
            head = head.next;
            mm--;
        }
        tail = head;//反转前开头节点就是尾节点
        int count = n-m+1;//需要反转的节点个数

        //开始反转
        ListNode new_head = new ListNode(0);
        ListNode next = null;
        while (head!=null&&count!=0){
            next = head.next;
            head.next = new_head.next;
            new_head.next = head;
            head = next;
            count--;
        }
        tail.next = head;

        if(pre_head!=null){
            pre_head.next = new_head.next;
        }else{
            result = new_head.next;
        }
        return result;
    }

    public static void print_list(ListNode head, String name){
        System.out.print(name +":");
        if(head==null){
            System.out.println("null");
            return;
        }
        while (head!=null){
            System.out.print(head.val);
            head = head.next;
            System.out.print("->");
        }
        System.out.print("null");
        System.out.println();
    }


    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = null;

        ListNode head = n1;
        //ListNode new_head = reverseListNode2(head);
        ListNode new_head = reverseBetween2(head, 5, 5);
        while (new_head != null){
            System.out.println(new_head);
            new_head = new_head.next;
        }

    }
}
