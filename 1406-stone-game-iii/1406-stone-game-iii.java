class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int memo[] = new int[n];
        Arrays.fill(memo,-1);
        int diff = solve(0, stoneValue, memo ,n);

        if(diff > 0){
            return "Alice";
        }
        else if( diff == 0){
            return "Tie";
        }
        return "Bob";
    }

    private int solve(int i , int[] stoneValue, int memo[], int n){
        if(i >= n){
            return 0;
        }

        if(memo[i]!=-1) return memo[i];
        int ans =Integer.MIN_VALUE;
        int sum =0;
        for(int idx = 0; idx < 3 && idx+i < n ;idx++){
            sum+=stoneValue[idx+i];
            ans =Math.max(ans,sum -solve(i+idx+1,stoneValue,memo,n));
        }

        return memo[i] = ans;


    }
}