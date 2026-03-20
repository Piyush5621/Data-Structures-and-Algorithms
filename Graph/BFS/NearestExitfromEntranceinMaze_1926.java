class Pair{
    int r;
    int c;
    int dis;
    Pair(int a,int b,int d){
        r=a;
        c=b;
        dis=d;
    }
}
class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rr[]=new int[]{-1,0,1,0};
        int cc[]=new int[]{0,1,0,-1};
        int n=maze.length;
        int m=maze[0].length;
        boolean vist[][]=new boolean[n][m];
        Queue<Pair> q=new ArrayDeque<>();
        vist[entrance[0]][entrance[1]]=true;
        q.offer(new Pair(entrance[0],entrance[1],0));
        int minm=Integer.MAX_VALUE;
        while(!q.isEmpty()){
            Pair p=q.poll();
            int or=p.r;
            int oc=p.c;
            int od=p.dis;

            for(int i=0;i<4;i++){
                int nr=or+rr[i];
                int nc=oc+cc[i];

                if(nr>=0 && nr<n && nc>=0 && nc<m && maze[nr][nc]=='.' && !vist[nr][nc]){
                    q.add(new Pair(nr,nc,od+1));
                    vist[nr][nc]=true;
                    if(nr==0 || nc==0 || nr==n-1 || nc==m-1){
                       return od+1;
                    }
                }
            }
        }

        return -1;
    }
}