package FuckingAlgorithm.LinkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wq
 * @date 2020-03-24 10:51
 *
 * leetcode142
 */
public class DetectCycle {


    /**
     * 方法一 添加到集合  在添加之前 查看集合是否包含
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        List<ListNode> nodes = new ArrayList<>();
        while (head != null) {
            if (!nodes.isEmpty() && nodes.contains(head)) {
                return head;
            }
            nodes.add(head);
            head = head.next;
        }
        return null;
    }

    /**
     * 方法二：快慢指针
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle2(ListNode head) {
        ListNode fast = head;   //快指针
        ListNode slow = head;   //慢指针
        ListNode meet = null;   //快慢相遇点（即必有环）

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;   //先个各走一步 目的是判断链表是否为单节点
            if (fast == null) {
                return null;
            }
            fast = fast.next;

            if (fast == slow) {   //找到meet位置
                meet = slow;
                break;
            }
        }

        if (meet == null) {
            return null;
        }
        while (head != null && meet != null) {
            if (head == meet) {
                return head;
            }
            head = head.next;
            meet = meet.next;
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(5);
        ListNode a6 = new ListNode(6);
        ListNode a7 = new ListNode(7);

        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;
        a5.next = a6;
        a6.next = a7;
        a7.next = a3; //测试1->2->3->4->5->6->7  再回到3

//        a1.next = a2;
//        a2.next = a1; //测试1->2 再回到1

        //detectCycle2(a1);
        System.out.println(detectCycle2(a1));
    }
}
