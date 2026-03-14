import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

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
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int dis[][]=new int[n][m];
        for(int arr[]: dis) Arrays.fill(arr,Integer.MAX_VALUE);
        Queue<Triple> q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    dis[i][j]=0;
                    q.add(new Triple(i,j,0));
                }
            }
        }
        int rr[]=new int[]{-1,0,1,0};
        int cc[]=new int[]{0,1,0,-1};
        while(!q.isEmpty()){
            Triple t=q.poll();
            int r=t.r;
            int c=t.c;
            int distt=t.dist;
            for(int i=0;i<4;i++){
                int nr=r+rr[i];
                int nc=c+cc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && dis[nr][nc]>dis[r][c]+1){
                    dis[nr][nc]=distt+1;
                    q.add(new  Triple(nr,nc,distt+1));
                }
            }
        }

        return dis;


    }
}