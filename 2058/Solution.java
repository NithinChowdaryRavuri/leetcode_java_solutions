class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode previousNode = head;
        ListNode currentNode = head.next;
        int firstIndex = 0, lastIndex = 0, index = 1;

        int[] answer = new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE };

        while (currentNode.next != null) {
            if (currentNode.val < Math.min(previousNode.val, currentNode.next.val)
                    || currentNode.val > Math.max(previousNode.val, currentNode.next.val)) {
                if (lastIndex == 0) {
                    firstIndex = index;
                    lastIndex = index;
                } else {
                    answer[0] = Math.min(answer[0], index - lastIndex);
                    answer[1] = index - firstIndex;
                    lastIndex = index;
                }
            }
            ++index;
            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        return firstIndex == lastIndex ? new int[] { -1, -1 } : answer;
    }
}