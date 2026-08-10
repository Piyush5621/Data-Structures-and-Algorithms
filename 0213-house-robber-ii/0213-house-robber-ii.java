class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n <= 1) return nums[n-1];
        int memo[] = new int[n];
        Arrays.fill(memo,-1);
        int case1 = solve(0,n-1,nums,memo);
        Arrays.fill(memo,-1);
        int case2 = solve(1,n,nums,memo);

        return Math.max(case1,case2);
    }

    private int solve( int i , int n , int nums[], int memo[]){
        if(i >= n ) return 0;
        if(memo[i]!=-1){
            return memo[i];
        }

        memo[i] = Math.max(nums[i]+solve(i+2,n, nums,memo),solve(i+1,n,nums,memo));
        return memo[i];
    }
}