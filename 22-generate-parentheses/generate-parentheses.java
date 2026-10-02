class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(n, new StringBuilder(),ans,0,0);
        return ans;
    }

    private void solve(int n, StringBuilder str , List<String> ans,int op, int cl){
        if(str.length() == 2*n ){
            ans.add(str.toString());
            return ;
        }

        if(op < n ){
            str.append('(');
            solve(n,str,ans,op+1,cl);
            str.deleteCharAt(str.length() - 1);
        }
        if(cl < op ){
            str.append(')');
            solve(n,str,ans,op,cl+1);
            str.deleteCharAt(str.length() - 1);
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna