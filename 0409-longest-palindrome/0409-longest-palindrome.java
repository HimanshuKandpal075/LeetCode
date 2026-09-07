class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        boolean isOdd = false;
        int ans = 0;
        for(char key: map.keySet()){
           ans += map.get(key) / 2 * 2;

            if(map.get(key) % 2 == 1){
                isOdd = true;
            }
        }
        if(isOdd){
            ans += 1;
        }
        return ans;
    }
}