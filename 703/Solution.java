class KthLargest {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    public int limit;

    public KthLargest(int k, int[] nums) {
        limit = k;
        for (int num : nums) {
            minHeap.add(num);
        }
        while (minHeap.size() > k) {
            minHeap.remove();
        }
    }

    public int add(int val) {
        minHeap.add(val);
        while (minHeap.size() > limit) {
            minHeap.remove();
        }
        return minHeap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */