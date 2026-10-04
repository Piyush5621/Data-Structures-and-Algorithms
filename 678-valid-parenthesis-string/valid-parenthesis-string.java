class Solution {
    Boolean memo[][];
    public boolean checkValidString(String s) {
        int n = s.length();
        memo = new Boolean[n][n+1];
        return solve(s, 0, 0);
    }

    private boolean solve(String s, int i, int op){

        if( op < 0 ) return false;

        if( i >= s.length() ){
            return op == 0;
        }

        if(memo[i][op]!= null) return memo[i][op];

        char ch = s.charAt(i);
        boolean ans = false;
        if( ch == '('){
            ans |=  solve(s,i+1,op+1);
        }
        else if( ch == ')'){
            ans |= solve(s, i+1, op-1);
        }
        else{
            ans |= solve(s, i+1, op+1) || solve(s, i+1, op-1) || solve(s, i+1, op);
        }

        return memo[i][op] = ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna