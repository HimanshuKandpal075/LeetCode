class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int maxLen = 0;

        for(int key: map.keySet()){
            if(map.containsKey(key + 1)){
                int curLen = map.get(key) + map.get(key+1);
                maxLen = Math.max(maxLen, curLen);
            }
        }
        return maxLen;
    }
}



// public int findLHS(int[] nums) {
//         Arrays.sort(nums);
//         int j = 0;
//         int maxLength = 0;

//         for(int i=0;i<nums.length;i++){
//             while(nums[i] - nums[j] > 1){
//                 j++;
//             }

//             if(nums[i] - nums[j] == 1){
//                 maxLength = Math.max(maxLength, i-j+1);
//             }
//         }
//         return maxLength;
// }