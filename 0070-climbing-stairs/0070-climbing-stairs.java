class Solution {
    public int climbStairs(int n) {
        return climb(n);
    }

    static int climb(int n){
        int prev2 = 0;
        int prev = 1;

        for(int i=n-1;i>=0;i--){
            int curr = prev2 + prev;

            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}