class Solution {
    public String smallestSubsequence(String s) {
        int ans = 1;
        int lastOcc[] = new int[26];
        HashSet<Character> visited = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            lastOcc[s.charAt(i) - 'a'] = i;
        } 

        Stack<Character>  st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(visited.contains(c)){
                continue;
            }
            else{
                while(!st.isEmpty() && st.peek() > c && lastOcc[st.peek()-'a'] > i){
                    char cr = st.pop();
                    visited.remove(cr);
                }
                st.add(c);
                visited.add(c);
            }
            
        }
        StringBuilder str = new StringBuilder();
        while(!st.isEmpty()){
            str.append(st.pop());
        }

        return str.reverse().toString();

    }
}