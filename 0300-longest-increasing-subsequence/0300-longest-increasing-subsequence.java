class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int memo[][] = new int[n+1][n+1];
        for( int arr[] : memo ) Arrays.fill(arr, -1);

        return solve(0,nums,memo,-1);
    }

    private int solve( int i , int nums[], int memo[][] , int prev){
        if( i >= nums.length) return 0;

        if(memo[i][prev+1] != -1) return memo[i][prev+1];

        int take=0;
        if(prev==-1 || nums[prev] < nums[i] ){
            take = 1 + solve(i+1,nums,memo,i);
        } 

        int skip = solve(i+1,nums,memo,prev);

        memo[i][prev+1] = Math.max(take,skip);
        return memo[i][prev+1];   
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna