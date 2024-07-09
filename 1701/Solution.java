class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        long time = customers[0][0] + customers[0][1];
        long wait = customers[0][1];
        if(n == 1) return (double) wait;
        for(int i=1; i<n; i++){
            if(time > customers[i][0]){
                time += customers[i][1];
                wait += time - customers[i][0];
            }else{
                time = customers[i][0] + customers[i][1];
                wait += time - customers[i][0];
            }
        }
        return (double) wait/n;
    }
}