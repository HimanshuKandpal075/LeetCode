class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n =s.length();
        int maxLen = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;

        for(int right = 0;right<n;right++){
            char ch = s.charAt(right);

            map.put(ch, map.getOrDefault(ch, 0)+1);

            while(map.get(ch) > 1){
                char leftC = s.charAt(left);

                map.put(leftC, map.get(leftC)-1);

                if(map.get(leftC) == 0){
                    map.remove(leftC);
                }                
                left++;
            }
            maxLen = Math.max(maxLen, right - left+1);
        }
        return maxLen;
    }
}