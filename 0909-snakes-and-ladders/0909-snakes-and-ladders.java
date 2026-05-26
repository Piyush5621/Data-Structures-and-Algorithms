class Solution {
    class pair{
        int nn;
        int s;
        boolean prev;
        pair(int nn,int s , boolean p){
            this.nn=nn;
            this.s=s;
            this.prev = p; 
        }
    }
    int getrow(int num,int n){
        int rowfrombot = (num - 1 ) /n ;
        int row = n - 1 - rowfrombot;
        return row;
    }
    int getcol(int num,int n){
        int rowfrombot = (num - 1 ) /n ;
        int col = (num - 1) % n;
        if(rowfrombot%2==1){
            col = n - 1 - col;
        }
        return col;

    }
    public int snakesAndLadders(int[][] board) {
        int sum=0;
        int n = board.length;
        int last = n*n;

        Queue<pair> q = new ArrayDeque<>();
        q.add(new pair(1,0,false));
        boolean visited[] = new boolean[last+1];
        visited[1] = true;
        boolean prev = false;
        while(!q.isEmpty()){
            pair p = q.poll();
            int curr = p.nn;
            int steps = p.s;
            boolean prevv = p.prev;
            if(curr == last){
                return steps;
            }
            for(int i=1;i<=6;i++){
                int next = curr+i;
                if(next<=last){
                    int newR = getrow(next,n);
                    int newC = getcol(next,n);
                    if(board[newR][newC]==-1){
                        if(!visited[next]){
                            q.add(new pair(next,steps+1, false));
                            visited[next]= true;
                        }
                    }
                    else{
                        if(!visited[board[newR][newC]]){
                            if(prev==false){
                                q.add(new pair(board[newR][newC],steps+1,true));
                                visited[board[newR][newC]] = true;
                            }
                            else{
                                q.add(new pair(next,steps+1,false));
                                visited[next] = true;
                            }
                        }
                    }
                }
            }
        } 
        return -1;
    }
}