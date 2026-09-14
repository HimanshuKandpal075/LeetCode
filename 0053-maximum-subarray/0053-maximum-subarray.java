class Solution {
    public int maxSubArray(int[] arr) {
        int n = arr.length;

        int max = arr[0];
        int sum = arr[0];

        for(int i=1;i<n;i++){
            sum = Math.max(sum + arr[i], arr[i]);

            max = Math.max(max, sum);
        }
        return max;
    }
}