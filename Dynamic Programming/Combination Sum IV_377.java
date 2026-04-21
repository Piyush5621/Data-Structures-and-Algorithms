class Solution {
    public int combinationSum4(int[] nums, int target) {
        int n = nums.length;
        int memo[][]=new int[n][target+1];
        for(int arr[] : memo) Arrays.fill(arr,-1);
        return rec(0,nums,target,memo);
    }

    int rec(int i, int nums[], int target,int memo[][]){
        if(target==0) return 1;
        if(i>= nums.length ||  target<0) return 0;
        if(memo[i][target]!=-1) return memo[i][target];
        int take = rec(0,nums,target-nums[i],memo);
        int reject = rec(i+1,nums,target,memo);
        memo[i][target]=take+reject;
        return memo[i][target];
    }
}