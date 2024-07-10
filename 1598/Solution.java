class Solution {
    public int minOperations(String[] logs) {
        int depth = 0;
        for(String log: logs){
            if(log.equals("./")) continue;
            if(log.equals("../")){
                if(depth > 0) depth -= 1;
            }else{
                depth += 1;
            }
        }

        return depth;
    }
}