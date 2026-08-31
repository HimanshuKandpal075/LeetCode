class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;
        int maxFreq = 0;

        int countT = 0;
        int countF = 0;

        for(int right = 0;right<answerKey.length();right++){
            char ch = answerKey.charAt(right);

            if(ch == 'T'){
                countT++;
            }
            else{
                countF++;
            }

            maxFreq = Math.max(countT, countF);

            while(right - left + 1 - maxFreq > k){
                if(answerKey.charAt(left) == 'T'){
                    countT--;
                }
                else{
                    countF--;
                }
                left++;
            }
            maxLen = Math.max(right - left + 1, maxLen);
        }
        return maxLen;
    }
}