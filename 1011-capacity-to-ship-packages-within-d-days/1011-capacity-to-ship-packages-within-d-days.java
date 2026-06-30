class Solution {
    public boolean canShip(int mid, int days, int weights[]){
        int cdays = 1;
        int currWeight = 0;
        int n = weights.length;
        for(int i=0; i<n; i++){
            if(currWeight+weights[i]<=mid){
                currWeight += weights[i];
            }
            else{
                cdays++;
                currWeight = weights[i];
            }
        }
        return cdays <= days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int start = weights[0];
        int end = weights[0];
        int n = weights.length;
        for(int i=1; i<n; i++){
            start = Math.max(start,weights[i]);
            end += weights[i];
        }
        int ans = 1;
        while(start <= end){
            int mid = start + (end - start )/2;

            if(canShip(mid, days, weights )){
                ans = mid;
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        } 
        return start;
    }
}