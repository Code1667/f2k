package FuckingAlgorithm.Recursion;

/**
 *
 * leetcode 24
 * 两两交换链表中的节点
 *
 */
public class SwapPairs {
    public static void main(String[] args) {
        ListNode t1 = new ListNode(1);
        ListNode t2 = new ListNode(2);
        ListNode t3 = new ListNode(3);
        ListNode t4 = new ListNode(4);
        t1.next = t2;
        t2.next = t3;
        t3.next = t4;

        ListNode listNode = swapPairs(t1);
        print(listNode);

    }

    public static ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode temp = head;
        head = head.next;
        temp.next = head.next;
        head.next = temp;
        temp.next = swapPairs(temp.next);
        return head;
    }


    /**
     * 打印方法
     * @param listNode
     */
    public static void print(ListNode listNode){
        while (listNode!=null){
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}
