class Solution {
    int memo[];
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return solve(0,nums);
    }

    private int solve(int i, int nums[]){
        if( i>= nums.length ) return 0;

        if(memo[i]!=-1){
            return memo[i];
        }

        int res = -1;
        for( int j= i ; j < nums.length; j++){
            int amount = nums[j] + solve(j+2,nums);
            res = Math.max(res, amount);
            // memo[j] = res;
        }
        
        return memo[i] = res;
    }
}