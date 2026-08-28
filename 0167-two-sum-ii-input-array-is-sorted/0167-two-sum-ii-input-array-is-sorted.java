class Solution {
    public int[] twoSum(int[] arr, int target) {
        int low = 0;
        int high = arr.length-1;

        while(low < high){
            int sum = arr[low] + arr[high];

            if(sum == target){
                return new int[]{low+1, high+1};
            }
            else if(sum > target){
                high--;
            }
            else{
                low++;
            }
        }
        return new int[] {-1, -1};
    }
}