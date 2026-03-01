class Triple{
    int a;
    int b;
    int c;
    Triple(int a,int b,int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }
}
class Solution {
    public int minStepToReachTarget(int knightPos[], int targetPos[], int n) {
        // Code here
        int dist[][]=new int[n][n];
        for(int arr[]: dist){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        int rr[]=new int[]{-2,-2,-1,1,2,2,1,-1};
        int cc[]=new int[]{-1,1,2,2,1,-1,-2,-2};
        Queue<Triple> q=new LinkedList<>();
        int r=knightPos[0]-1;
        int c=knightPos[1]-1;
        q.add(new Triple(r,c,0));
        if(knightPos[0]==targetPos[0]&& knightPos[1]==targetPos[1]){
            return 0;
        }
        while(!q.isEmpty()){
            Triple t=q.poll();
            int or=t.a;
            int oc=t.b;
            int od=t.c;
            
            for(int i=0;i<8;i++){
                int nr=or+rr[i];
                int nc=oc+cc[i];
                int nd=od+1;
                if(nr>=0 && nr<n && nc>=0 && nc<n && nd<dist[nr][nc]){
                    dist[nr][nc]=nd;
                    if(nr==targetPos[0]-1 && nc==targetPos[1]-1){
                        return dist[nr][nc];
                    }
                    q.add(new Triple(nr,nc,nd));
                }
                
            }
        }
        return (dist[targetPos[0]-1][targetPos[1]-1]==Integer.MAX_VALUE)? -1: 1;
    }
}