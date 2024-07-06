/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        while (head != null) {
            nums.add(head.val);
            head = head.next;
        }
        int size = nums.size();
        if (size == 0)
            return null;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        for (int i = size - 1; i >= 0; i--) {
            ListNode temp = new ListNode(nums.get(i));
            prev.next = temp;
            prev = prev.next;
        }
        return dummy.next;
    }
}