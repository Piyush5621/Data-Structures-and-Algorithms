// class Pair{
//     int r;
//     int c;
//     int dis;
//     Pair(int a,int b,int d){
//         r=a;
//         c=b;
//         dis=d;
//     }
// }

// class Solution {
//     public int nearestExit(char[][] maze, int[] entrance) {
//         int rr[]=new int[]{-1,0,1,0};
//         int cc[]=new int[]{0,1,0,-1};
//         int n=maze.length;
//         int m=maze[0].length;
//         int dist[][]=new int[n][m];
//         for(int a[]: dist) Arrays.fill(a,Integer.MAX_VALUE);
//         Queue<Pair> q=new ArrayDeque<>();
//         dist[entrance[0]][entrance[1]]=0;
//         q.offer(new Pair(entrance[0],entrance[1],0));
//         int minm=Integer.MAX_VALUE;
//         while(!q.isEmpty()){
//             Pair p=q.poll();
//             int or=p.r;
//             int oc=p.c;
//             int od=p.dis;
            
//             for(int i=0;i<4;i++){
//                 int nr=or+rr[i];
//                 int nc=oc+cc[i];

//                 if(nr>=0 && nr<n && nc>=0 && nc<m && maze[nr][nc]=='.' && od+1<dist[nr][nc]){
//                     dist[nr][nc]=od+1;
//                     q.add(new Pair(nr,nc,od+1));

//                     if(nr==0 || nc==0 || nr==n-1 || nc==m-1){
//                         minm=Math.min(minm,dist[nr][nc]);
//                     }
//                 }
//             }
//         }

//         return (minm==Integer.MAX_VALUE)? -1 : minm;
//     }
// }


// 2nd solution more beats

class Pair{
    int r;
    int c;
    Pair(int a,int b){
        r=a;
        c=b;
    }
}

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int rr[]=new int[]{-1,0,1,0};
        int cc[]=new int[]{0,1,0,-1};
        int n=maze.length;
        int m=maze[0].length;
        int dist[][]=new int[n][m];
        for(int a[]: dist) Arrays.fill(a,Integer.MAX_VALUE);
        Queue<Pair> q=new ArrayDeque<>();
        dist[entrance[0]][entrance[1]]=0;
        q.offer(new Pair(entrance[0],entrance[1]));
        while(!q.isEmpty()){
            Pair p=q.poll();
            int or=p.r;
            int oc=p.c;
            for(int i=0;i<4;i++){
                int nr=or+rr[i];
                int nc=oc+cc[i];
                int od=dist[or][oc];
                if(nr>=0 && nr<n && nc>=0 && nc<m && maze[nr][nc]=='.' &&od+1<dist[nr][nc]){
                    if(nr==0 || nc==0 || nr==n-1 || nc==m-1){
                        return od+1;
                    }
                    dist[nr][nc]=od+1;
                    q.add(new Pair(nr,nc));

                }
            }
        }

        return -1;
    }
}