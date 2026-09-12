class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int k) {
        int winSum = 0;
        int sum = 0;
        for(int i = 0; i < k; i++) {

            winSum += customers[i];

            if(grumpy[i] == 0) {
                sum += customers[i];
            }
        }   
        int max = winSum;
        int prev = winSum;

        for(int i=k;i<customers.length;i++){
            if(grumpy[i] == 1) {
                winSum += customers[i];
            }

            if(grumpy[i - k] == 1) {
                winSum -= customers[i - k];
            }

            max = Math.max(max, winSum);

            if(grumpy[i] == 0){
                sum += customers[i];
            }
        }

        int idx = 0;
        
        for(int i=k;i<customers.length;i++){
            if(prev == max){
                idx = 0;
                break;
            }
            if(grumpy[i] == 1) {
                prev += customers[i];
            }

            if(grumpy[i - k] == 1) {
                prev -= customers[i - k];
            }

            if(prev == max) {
                idx = i - k + 1;
                break;
            }
        }

        for(int i=idx;i<idx+k;i++){
            if(grumpy[i] == 1){
                sum += customers[i];
            }
        }
        return sum;
    }
}