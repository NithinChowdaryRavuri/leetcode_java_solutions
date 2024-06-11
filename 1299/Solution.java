class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length - 1;
        int max = arr[n];
        arr[n] = -1;
        n -= 1;
        while (n >= 0) {
            int curr = arr[n];
            arr[n] = max;
            max = Math.max(max, curr);
            n -= 1;
        }
        return arr;
    }
}