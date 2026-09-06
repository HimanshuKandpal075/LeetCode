class Solution {
    public int longestSubstring(String s, int k) {
        int ans = 0;
        for(int unique = 0;unique <= 26;unique++){
            int[] freq = new int[26];

            int left = 0;
            int uniqueCount = 0;
            int atLeastK = 0;

            for(int right = 0;right < s.length();right++){
                char ch = s.charAt(right);

                if(freq[ch - 'a'] == 0){
                    uniqueCount++;
                }
                freq[ch - 'a']++;

                if(freq[ch - 'a'] == k){
                    atLeastK++;
                }

                while(uniqueCount > unique){
                    int leftIdx = s.charAt(left) - 'a';

                    if(freq[leftIdx] == k){
                        atLeastK--;
                    }

                    freq[leftIdx]--;

                    if(freq[leftIdx] == 0){
                        uniqueCount--;
                    }

                    left++;
                }

                if(uniqueCount == unique && unique == atLeastK){
                    ans = Math.max(ans, right-left+1);
                }
            }
        }
        return ans;
    }
}