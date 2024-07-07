class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int result = numBottles;
        int empty = numBottles;
        int bottles = 0;
        while (empty >= numExchange) {
            bottles = (int) empty / numExchange;
            empty = empty % numExchange;
            empty += bottles;
            result += bottles;
        }
        return result;
    }
}