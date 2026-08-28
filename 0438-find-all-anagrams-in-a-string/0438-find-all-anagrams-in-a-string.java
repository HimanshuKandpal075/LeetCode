class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if(p.length() > s.length()){
            return ans;
        }

        int[] f1 = new int[26];
        int[] f2 = new int[26];

        for(int i=0;i<p.length();i++){
            f1[s.charAt(i) - 'a']++;
            f2[p.charAt(i) - 'a']++;
        }

        if(matches(f1, f2)){
            ans.add(0);
        }

        for(int i=p.length();i<s.length();i++){
            f1[s.charAt(i) - 'a']++;
            f1[s.charAt(i - p.length()) - 'a']--;

            if(matches(f1, f2)){
                ans.add(i-p.length()+1);
            }
        }
        return ans;
    }

    static boolean matches(int[] f1, int[] f2){
        for(int i=0;i<26;i++){
            if(f1[i] != f2[i]){
                return false;
            }
        }
        return true;
    }
}