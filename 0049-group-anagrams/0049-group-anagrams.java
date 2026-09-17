class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s: strs){
            int[] f = new int[26];

            for(char ch: s.toCharArray()){
                f[ch - 'a']++;
            }

            StringBuilder sb  = new StringBuilder();

            for(int num: f){
                sb.append(num).append("#");
            }

            String key = sb.toString();

            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
