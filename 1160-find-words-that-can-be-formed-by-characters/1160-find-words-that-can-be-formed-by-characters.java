class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] f1 = new int[26];
        
        for(char ch: chars.toCharArray()){
            f1[ch - 'a']++;
        }

        int count = 0;
        
        for(String word: words){

            if(canForm(word, f1)){
                count += word.length();
            }
        }
        return count;
    }

    static boolean canForm(String s, int[] f){
        int[] f1 = new int[26];

        for(char ch: s.toCharArray()){
            f1[ch - 'a']++;

            if(f1[ch - 'a'] > f[ch - 'a']){
                return false;
            }
        }
        return true;
    }
}