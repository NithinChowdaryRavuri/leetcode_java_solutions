class Solution {
    public int minimumRecolors(String blocks, int k) {
        int whiteColors = 0;
        for(int i=0; i< k; i++) {
            if(blocks.charAt(i) == 'W'){
                whiteColors++;
            }
        }

        int result = whiteColors;
        for(int i=k; i<blocks.length(); i++){
            if(blocks.charAt(i) == 'W'){
                whiteColors++;
            }
            if(blocks.charAt(i-k) == 'W'){
                whiteColors--;
            }
            result = Math.min(result, whiteColors);
        }

        return result;
    }
}