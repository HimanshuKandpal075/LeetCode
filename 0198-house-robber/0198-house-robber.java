class Solution {
    public int rob(int[] arr) {
        int n = arr.length; 

        int prev2 = 0;
        int prev = arr[0];

        for(int i=1;i<n;i++){
            int inc = prev2 + arr[i];
            int exc = prev;

            int curr = Math.max(inc, exc);

            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}
