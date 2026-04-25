class Solution {
    public int integerReplacement(int n) {
        long temp = n;
        return solve(n);
    }

    int solve(long n){
        if(n<=0) return 0;
        if(n==1) return 0;
        int ans =0;
        if(n%2==0){
            ans+=1+solve(n/2);
        }
        else{
            ans+=1+Math.min(solve(n+1 ), solve(n-1));
        }
        return ans;
    }
}