class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;
        int maxFreq = 0;

        for(int right = 0;right<answerKey.length();right++){
            char ch = answerKey.charAt(right);

            map.put(ch, map.getOrDefault(ch, 0)+1);

            maxFreq = Math.max(maxFreq, map.get(ch));

            int windowLen = right - left + 1;

            int repl = windowLen - maxFreq;

            while(repl > k){
                char leftC = answerKey.charAt(left);

                map.put(leftC, map.get(leftC) - 1);

                left++;

                windowLen = right - left + 1;

                repl = windowLen - maxFreq;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}