class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;
        int lf[] = new int[n];
        int rt[] = new int[n];
        lf[0] = nums[0];
        rt[n-1] = nums[n-1];
        int maxm =nums[0];
        for(int i=1; i<n; i++){
            if(nums[i]>maxm){
                lf[i] = nums[i];
                maxm =nums[i];
            }
            else{
                lf[i] = -1;
            }
        } 
        maxm = nums[n-1];
        for(int i=n-2; i>=0; i--){
            if(nums[i]>maxm){
                rt[i] = nums[i];
                maxm =nums[i];
            }
            else{
                rt[i] = -1;
            }
        } 
        List<Integer> lt = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(lf[i]!=-1 || rt[i]!=-1){
                lt.add(nums[i]);
            }
        }

        return lt;
    }
}