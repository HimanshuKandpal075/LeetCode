class Solution {
    public int trap(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        int leftMax = 0;
        int rightMax = 0;

        int water = 0;

        while(left <= right){
            if(leftMax < rightMax){
                if(arr[left] >= leftMax){
                    leftMax = arr[left];
                }
                else{
                    water += leftMax - arr[left];
                }
                left++;
            }
            else{
                if(arr[right] >= rightMax){
                    rightMax = arr[right];
                }
                else{
                    water += rightMax - arr[right];
                }
                right--;
            }
        }
        return water;
    }
}