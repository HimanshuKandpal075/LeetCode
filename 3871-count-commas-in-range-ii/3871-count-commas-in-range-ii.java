class Solution {
    public long countCommas(long n) {
        if(n < 1000){
            return 0;
        }

        long count = 0;
        long p = 1000;

        while(p <= n){
            count += n-p+1;
            p *= 1000;
        }
        return count;
    }
}