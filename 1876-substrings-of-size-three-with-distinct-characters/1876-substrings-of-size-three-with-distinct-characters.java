class Solution {
    public int countGoodSubstrings(String s) {
        if(s.length() < 3){
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        int count = 0;

        for(int i=0;i<3;i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }
        if(map.size() == 3){
            count++;
        }

        for(int i=3;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
            map.put(s.charAt(i-3), map.get(s.charAt(i-3))-1);

            if(map.get(s.charAt(i-3)) == 0){
                map.remove(s.charAt(i-3));
            }
            
            if(map.size() == 3){
                count++;
            }
        }
        return count;
    }
}