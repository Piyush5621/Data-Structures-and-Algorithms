class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int start = 1;
        int end = -1;

        for(int x : piles){
            end = Math.max(end,x);
        }
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            int temp = solve(mid,piles);
            if(temp <= h ){
                ans = mid;
                end = mid-1;
            }
            else{
                start = mid+1;
            }
        }
        return ans;

    }

    int solve(int mid, int nums[] ){
        int n = nums.length;
        int tt =0;
        for(int k =0; k<n; k++ ){
            double a =(double)nums[k]/(double)mid;
            tt+=Math.ceil(a); 
        }
        return tt;
    }
}