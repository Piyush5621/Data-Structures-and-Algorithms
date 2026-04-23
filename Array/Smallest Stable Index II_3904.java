class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int lf []= new int[n];
        int rt[] = new int[n];
        int maxm = -1;
        for(int i=0; i<n; i++){
            maxm = Math.max(maxm,nums[i]);
            lf[i] =maxm;
        }
        int minm = Integer.MAX_VALUE;
        for(int i=n-1; i>=0; i--){
            minm = Math.min(minm,nums[i]);
            rt[i] = minm; 
        }
        
        for(int i=0; i<n; i++){
            int x =lf[i]-rt[i];
            if(x<=k){
                return i;
            }
        }
        return -1;
    }
}