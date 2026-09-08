class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];

        int left = 0;
        int maxLen = 0;
        int maxFreq = 0;

        for(int right = 0;right<s.length();right++){
            char ch = s.charAt(right);

            freq[ch - 'A']++;

            maxFreq = Math.max(maxFreq, freq[ch - 'A']);

            int windowLen = right - left + 1;

            int repl = windowLen - maxFreq;

            while(repl > k){
                char leftC = s.charAt(left);

                freq[leftC - 'A']--;

                left++;

                windowLen = right - left + 1;

                repl = windowLen - maxFreq;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}
