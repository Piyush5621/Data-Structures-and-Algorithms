class Solution {
    int rr[] = new int[]{-1,0,1,0};
    int cc[] = new int[]{0,1,0,-1};
    class TrieNode{
        TrieNode child[];
        boolean isEnd;
        TrieNode(){
            child = new TrieNode[26];
            isEnd=false;
        }
    }

    void insert(TrieNode curr, String str){
        for(int i=0; i<str.length(); i++){
            int idx = str.charAt(i)-'a';
            if(curr.child[idx]==null){
                curr.child[idx]=new TrieNode();
            }
            curr = curr.child[idx];
        }
        curr.isEnd=true;
    }
    public List<String> findWords(char[][] board, String[] words) {
        int n = board.length;
        int m = board[0].length;
        TrieNode root = new TrieNode();
        for(String s : words){
            insert(root,s);
        }
        List<String> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i<n; i++){
            for(int j=0; j<m; j++){
                boolean visited[][] = new boolean[n][m];
                dfs(i,j,board,new StringBuilder(),visited,ans,root,set);
            }
        }
        return ans;

    }
    void dfs(int r, int c , char[][]board,StringBuilder temp, boolean [][]visited, List<String> ans,TrieNode curr,HashSet<String> set){
        int idx = board[r][c]-'a';
        curr = curr.child[idx];
        if(curr==null) return;
        temp.append(board[r][c]);
        visited[r][c] = true;
        if(curr.isEnd==true){
            if(!set.contains(temp.toString())){
                ans.add(temp.toString());
                set.add(temp.toString());
            }
        }
        for(int i=0; i<4; i++){
            int nr = rr[i]+r;
            int nc = cc[i]+c;
            if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length && !visited[nr][nc]){
                dfs(nr,nc,board,temp,visited,ans,curr,set);
            }  
        }
        temp.deleteCharAt(temp.length()-1);
        visited[r][c] = false;
    }


}