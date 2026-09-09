class Solution {
    public int maxProfit(int[] arr) {
        int min = arr[0];
        int sum = 0;

        for(int i=1;i<arr.length;i++){
            if(arr[i] > arr[i-1]){
                sum += arr[i] - arr[i-1];
            }
        }
        return sum;
    }
}