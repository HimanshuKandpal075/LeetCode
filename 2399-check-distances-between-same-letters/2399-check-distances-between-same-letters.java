class Solution {
    public boolean checkDistances(String s, int[] distance) {
        HashMap<Character, Integer> map = new HashMap<>();
        int[] freq = new int[26];

        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(!map.containsKey(c)){
                map.put(c, i);
            }
            else{
                freq[c - 'a'] = i - map.get(c) - 1;
            }
        }

        for(char c: s.toCharArray()){
            if(freq[c - 'a'] != distance[c - 'a']){
                return false;
            }
        }
        return true;
    }
}