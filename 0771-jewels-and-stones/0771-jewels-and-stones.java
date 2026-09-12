class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] freq = new boolean[128];

        for(char ch: jewels.toCharArray()){
            freq[ch] = true;
        }

        int count = 0;
        for(char ch: stones.toCharArray()){
            if(freq[ch]){
                count++;
            }
        }
        return count;
    }
}