package FuckingAlgorithm.LinkedList;

/**
 * @author wq
 * @date 2020-03-24 23:21
 * leetcode 21 合并有序链表/23
 */
public class MergeTwoList {



    public static ListNode mergeLists(ListNode[] lists){
        int len = lists.length;
        if(len==0){
            return null;
        }

        while (len>1){
            int i;
            for(i=0;i<len/2;i++){
                //如第0，1个链表合并放入第0个位置。
                //第2，3个链表合并放入第1个位置。
                //第3，4个链表合并放入第2个位置...
                lists[i] = mergeTwoList(lists[2*i],lists[2*i+1]);
            }
            if((len%2)!=0){
                lists[i] = lists[len-1];    //将奇数的最后一个链表放到第i个位置上
                len++;
            }
            len = len/2;
        }

        return lists[0];    //最终合并为一个链表
    }


    /**
     * 合并两个有序链表
     * 暴力法
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode(0);
        ListNode ptr = temp;

        while (l1 != null || l2 != null) {
            if (l1 == null) {
                ptr.next = l2;
                ptr = l2;
                l2 = l2.next;
            } else if (l2 == null) {
                ptr.next = l1;
                ptr = l1;
                l1 = l1.next;
            } else if (l1.val < l2.val) {
                ptr.next = l1;
                ptr = l1;
                l1 = l1.next;
            } else {
                ptr.next = l2;
                ptr = l2;
                l2 = l2.next;
            }
        }
        return temp.next;
    }

    /**
     * 合并两个有序列表
     * 递归法
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null) return l2;
        if(l2==null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {

        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(4);
        a1.next = a2;
        a2.next = a3;
        a3.next = null;

        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(3);
        ListNode b3 = new ListNode(4);
        b1.next = b2;
        b2.next = b3;
        b3.next = null;

        ListNode head = mergeTwoList(a1, b1);
        while (head != null) {
            System.out.println(head);
            head = head.next;
        }
    }
}
