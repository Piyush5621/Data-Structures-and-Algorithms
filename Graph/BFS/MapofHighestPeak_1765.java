import java.util.*;
class Triple{
    int r;
    int c;
    int dist;
    Triple(int a,int b,int d){
        r=a;
        c=b;
        dist=d;
    }
}
class Solution {
    static int []rr=new int[]{-1,0,1,0};
    static int []cc=new int[]{0,1,0,-1};
    public int[][] highestPeak(int[][] isWater) {
        int n=isWater.length;
        int m=isWater[0].length;
        int dis[][]=new int[n][m];
        for(int arr[]:dis){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        Queue<Triple> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(isWater[i][j]==1){
                    dis[i][j]=0;
                    q.add(new Triple(i,j,0));
                }
            }
        }
        while(!q.isEmpty()){
            Triple t=q.poll();
                int or=t.r;
                int oc=t.c;
                int od=t.dist;
                for(int k=0;k<4;k++){
                    int nr=or+rr[k];
                    int nc=oc+cc[k];
                    if(nr>=0 && nr<n && nc>=0 && nc<m && isWater[nr][nc]==0){
                        if(od+1<dis[nr][nc]){
                            dis[nr][nc]=od+1;
                            q.add(new Triple(nr,nc,od+1));
                        }
                    }
                }
            }
        return dis; 
    }
}