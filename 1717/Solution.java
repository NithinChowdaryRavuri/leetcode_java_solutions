class Solution {
    public int maximumGain(String s, int x, int y) {
        if(x < y){
            return maximumGain(new StringBuilder(s).reverse().toString(), y, x);
        }

        int totalGain = 0;
        Deque<Character> stack1 = new ArrayDeque<>();
        Deque<Character> stack2 = new ArrayDeque<>();

        for(char c: s.toCharArray()){
            if(c != 'b'){
                stack1.push(c);
            } else {
                if(!stack1.isEmpty() && stack1.peek() == 'a'){
                    stack1.pop();
                    totalGain += x;
                } else {
                    stack1.push(c);
                }
            }
        }

        while(!stack1.isEmpty()){
            char c = stack1.pop();
            if(c != 'b'){
                stack2.push(c);
            } else {
                if(!stack2.isEmpty() && stack2.peek() == 'a'){
                    stack2.pop();
                    totalGain += y;
                } else {
                    stack2.push(c);
                }
            }
        }

        return totalGain;
    }
}