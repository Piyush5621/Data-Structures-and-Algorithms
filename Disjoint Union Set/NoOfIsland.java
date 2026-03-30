import java.util.*;
public class Solution {
    static int par[];
    static int rank[];
    boolean exist=true;
    static class Union{
        Union(int n){
            par=new int[n];
            rank=new int[n];
            for(int i=0;i<n;i++) par[i]=i;
        }

        int find(int x){
            if(par[x]==x) return x;
            return par[x]=find(par[x]);
        }

        void union(int a,int b){
            int x_ref=find(a);
            int y_ref=find(b);

            if(rank[x_ref]<rank[y_ref]){
               
                par[x_ref]=y_ref;
            }
            else if(rank[x_ref]> rank[y_ref]){
                par[y_ref]=x_ref;
            }
            else{
                par[y_ref]=x_ref;
                rank[x_ref]++;
            }
        }
    }
    public static int[] numOfIslandsII(int n, int m, int[][] q) {
        // Write your code here.

        Union u=new Union(n*m);
        boolean vist[][]=new boolean[n][m];
        int ans[]=new int[q.length];
        int i=0;
        int rr[]=new int[]{-1,0,1,0};
        int cc[]=new int[]{0,1,0,-1};
        int count=0;
        for(int arr[]: q){
            int or=arr[0];
            int oc=arr[1];
            int node=or*m+oc;
            if(vist[or][oc]){
                ans[i++]=count;
                continue;
            }
            vist[or][oc]=true;
            count++;
            for(int j=0;j<4;j++){
                int nr=or+rr[j];
                int nc=oc+cc[j];
                if(nr>=0 && nr<n && nc>=0 && nc<m && vist[nr][nc]){
                    int newnode=nr*m+nc;
                    if(u.find(node)!=u.find(newnode)){
                        u.union(node,newnode);
                        count--;
                    }
                }
            }
            ans[i++]=count;
        }
        return ans;

    }
}