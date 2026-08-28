class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k-1);
    }

    public int atMostK(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0;
        int ans= 0;

        for(int right = 0; right < nums.length;right++){
            int n = nums[right];

            map.put(n, map.getOrDefault(n, 0)+1);

            while(map.size() > k){
                map.put(nums[left], map.get(nums[left])-1);

                if(map.get(nums[left]) == 0){
                    map.remove(nums[left]);
                }

                left++;
            }
            ans += right - left + 1;
        }
        return ans;
    }
}