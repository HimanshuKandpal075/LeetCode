class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int count = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int num: nums){
            sum += num;

            int div = ((sum % k) + k) % k;

            if(map.containsKey(div)){
                count += map.get(div);
            }

            map.put(div, map.getOrDefault(div, 0)+1);
        }
        return count;
    }
}