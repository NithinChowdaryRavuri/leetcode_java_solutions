class Solution {
    public int passThePillow(int n, int time) {
        int turns = time / (n - 1);
        if (turns % 2 == 0) {
            return time % (n - 1) + 1;
        }
        return n - (time % (n - 1));
    }
}