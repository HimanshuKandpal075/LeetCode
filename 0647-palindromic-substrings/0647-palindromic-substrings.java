class Solution {
    public int countSubstrings(String s) {
        int n = s.length();

        if(n == 0 || s == null){
            return 0;
        }

        int count = 0;

        for(int i=0;i<n;i++){
            count += expand(s, i, i);
            count += expand(s, i, i+1);
        }

        return count;
    }

    static int expand(String s, int l, int h){
        int count = 0;
        while(l >= 0 && h < s.length() && s.charAt(l) == s.charAt(h)){
            count++;
            l--;
            h++;
        }
        return count;
    }
}