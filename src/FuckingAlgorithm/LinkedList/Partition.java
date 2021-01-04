package FuckingAlgorithm.LinkedList;

/**
 * @author wq
 * @date 2020-03-24 21:46
 * 分隔链表
 * leetcode86
 */
public class Partition {

    /**
     * 用临时头节点
     * 将小于x的放入一个新链表1
     * 将大于x的放入一个新链表2
     * 将1与2相连，2尾部置空
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {
        ListNode less_head = new ListNode(0);
        ListNode more_head = new ListNode(0);
        ListNode less_ptr = less_head;
        ListNode more_ptr = more_head;

        while (head != null) {
            if (head.val < x) {
                less_ptr.next = head;
                less_ptr = head;
            } else {
                more_ptr.next = head;
                more_ptr = head;
            }
            head = head.next;
        }
        less_ptr.next = more_head.next;
        more_ptr.next = null;

        return less_head.next;
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
        ListNode partition = partition(headA, 6);
        while(partition!=null){
            System.out.println(partition);
            partition = partition.next;
        }

    }
}
