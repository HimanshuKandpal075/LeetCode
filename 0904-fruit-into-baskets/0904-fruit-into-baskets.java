class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for(int right = 0;right<fruits.length;right++){
            int num = fruits[right];

            map.put(num, map.getOrDefault(num, 0)+1);

            while(map.size() > 2){
                int leftN = fruits[left];

                map.put(leftN, map.get(leftN)-1);

                if(map.get(leftN) == 0){
                    map.remove(leftN);
                }
                left++;
            }
            maxLen = Math.max(maxLen, right - left +1);
        }
        return maxLen;
    }
}