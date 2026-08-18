class Solution {
    public int threeSumClosest(int[] arr, int target) {
        int n = arr.length;
        int ans = arr[0]+arr[1]+arr[2];

        Arrays.sort(arr);

        for(int i=0;i<n-2;i++){
            if(i>0 && arr[i] == arr[i-1]){
                continue;
            }

            int left = i+1;
            int right = n-1;

            while(left < right){
                int sum = arr[i] + arr[left] + arr[right];

                if(Math.abs(sum - target) < Math.abs(ans - target)){
                    ans = sum;
                }

                if(sum < target){
                    left++;
                }
                else if(sum > target){
                    right--;
                }
                else{
                    return sum;
                }
            }
        }
        return ans;
    }
}