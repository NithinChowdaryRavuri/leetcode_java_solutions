/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        int sum = 0;
        head = head.next;

        while (head != null) {
            if (head.val == 0) {
                prev.next = new ListNode(sum);
                prev = prev.next;
                sum = 0;
            } else {
                sum += head.val;
            }
            head = head.next;
        }
        return dummy.next;
    }
}