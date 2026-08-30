class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(b) - map.get(a));

        pq.addAll(map.keySet());

        while(k-- > 0){
            ans.add(pq.poll());
        }

        int[] ans1 = new int[ans.size()];

        for(int i=0;i<ans.size();i++){
            ans1[i] = ans.get(i);
        }
        return ans1;
    }
}