class Solution {
    boolean found =false;
    public int[] constructDistancedSequence(int n) {
        int ans[] = new int[2*n-1];
        boolean used[] = new boolean[n+1];
        solve(0, n, ans,used);
        return ans;
    }
    void solve(int idx, int n, int ans[],boolean []used){
        if(idx == ans.length){
            found = true;
            return;
        }

        if(ans[idx]!=0){
            solve(idx+1, n , ans,used);
            return;
        }
        for(int j=n;j>0; j--){
           if(used[j]) continue;
           if(j==1){
                used[j] = true;
                ans[idx] = j;
                solve(idx+1,n,ans,used);
                if(found) return;
                used[j] = false;
                ans[idx] = 0;
           }
           else{
                if(idx+j < ans.length && ans[idx]==0 && ans[idx+j]==0){
                    used[j] = true;
                    ans[idx] = j;
                    ans[idx+j] = j;
                    solve(idx+1,n,ans,used);
                    if(found) return;
                    ans[idx] = 0;
                    ans[idx+j] = 0;
                    used[j] = false;
                }
           }
        }
    }
}