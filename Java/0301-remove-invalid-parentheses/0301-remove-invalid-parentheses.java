class Solution {
    List<String> ans;
    HashSet<String> set;
    public List<String> removeInvalidParentheses(String s) {
        int mR = 0;
        int open = 0;
        for( int i = 0; i < s.length(); i++ ){
            if(s.charAt(i) == '('){
                open++;
            }
            else if(s.charAt(i) == ')'){
                open--;
            }
            if(open < 0){
                mR++;
                open = 0;
            }
        }

        mR = open + mR;
        System.out.println(mR);
        ans = new ArrayList<>();
        set = new HashSet<>();
        solve(s,0,0,mR, new StringBuilder());
        return ans;
    }

    private void solve(String s,int idx,int open, int mR, StringBuilder str){
        if(idx >= s.length()){
            if(mR == 0 && open == 0){
                if(!set.contains(str.toString())) {
                    ans.add(str.toString());
                    set.add(str.toString());
                }

            }
            return;
        }

        char ch = s.charAt(idx);

        if(Character.isLetter(ch)){
            str.append(ch);
            solve(s,idx+1,open,mR,str);
            str.deleteCharAt(str.length()-1);
        }
        else if(ch == '('){
            str.append(ch);
            solve(s,idx+1, open+1,mR,str);
            str.deleteCharAt(str.length()-1);
            if(mR > 0){
                solve(s,idx+1,open,mR-1,str);
            }
        }
        else{
            if(open > 0){
                str.append(ch);
                solve(s,idx+1, open-1,mR,str);
                str.deleteCharAt(str.length()-1);
            }
            if(mR > 0 ){
                solve(s,idx+1,open,mR-1,str);
            } 
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna