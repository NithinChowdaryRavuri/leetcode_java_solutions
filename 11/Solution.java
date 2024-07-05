class Solution {
    public int maxArea(int[] height) {
        int leftIndex = 0, rightIndex = height.length - 1, result = 0;

        while (leftIndex < rightIndex) {
            int currentArea = Math.min(height[leftIndex], height[rightIndex]) * (rightIndex - leftIndex);

            result = Math.max(currentArea, result);

            if (height[leftIndex] > height[rightIndex]) {
                --rightIndex;
            } else {
                ++leftIndex;
            }
        }

        return result;
    }
}