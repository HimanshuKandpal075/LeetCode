class Solution {
    public int numSubarrayProductLessThanK(int[] arr, int k) {
        if(k <= 1){
            return 0;
        }
        int left = 0;
        int prod = 1;
        int count = 0;

        for(int right = 0;right<arr.length;right++){
            prod *= arr[right];

            while(prod >= k){
                prod /= arr[left];
                left++;
            }
            count += right - left + 1;
        }
        return count;
    }

}