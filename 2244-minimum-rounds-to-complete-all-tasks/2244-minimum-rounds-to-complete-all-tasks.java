class Solution {
    public int minimumRounds(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int count = 0;
        for(int val: map.values()){
            if(val == 1){
                return -1;
            }

            if(val % 3 == 0){
                count += val/3;
            }
            else if(val % 3 == 1){
                count += (val - 4)/3 + 2;
            }
            else{
                count += val/3+1;
            }
        }
        return count;
    }
}