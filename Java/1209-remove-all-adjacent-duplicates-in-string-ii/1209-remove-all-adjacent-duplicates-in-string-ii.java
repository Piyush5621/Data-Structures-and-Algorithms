class Solution {
    class pair{
        char c;
        int cnt;
        pair( char a, int b){
            this.c = a;
            this.cnt = b;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<pair> st = new Stack<>();
        int n = s.length();
        for( int i = 0; i < n; i++ ){
            char ch = s.charAt(i);
            if( !st.isEmpty() && ch == st.peek().c ){
                pair p = st.pop();
                int newCount = p.cnt + 1;
                if( newCount < k ){
                    st.push(new pair(p.c ,newCount));
                }
            }
            else{
                st.push(new pair(ch, 1));
            }
        }
        StringBuilder ans = new StringBuilder();
        while(!st.isEmpty()){
            pair p =st.pop();
            for( int i = 0 ; i < p.cnt; i++ ){
                ans.append(p.c);
            }
        }

        return ans.reverse().toString();

    }
}