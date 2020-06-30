package org.pc.group_1;

/**
 * 反转链表
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 */
public class Solution_206 {

    public ListNode reverseList(ListNode head) {

        ListNode pre = null;
        ListNode cur = head;

        // ListNode rehead = null;

        //每次循环，都将当前节点指向它前面的节点，然后当前节点和前节点后移
        while(cur!=null){
            ListNode next = cur.next;  //临时节点，暂存当前节点的下一节点，用于后移

            // if(next==null) {
            //     rehead = cur;
            // }
            cur.next = pre;  // 当前节点的下一个节点 指向 前一个 节点

            pre = cur;  // 前一个节点 后移

            cur = next; // 当前节点 后移
        }

        return pre;

    }



      public class ListNode {
          int val;
          ListNode next;
         ListNode(int x) { val = x; }
     }

}
