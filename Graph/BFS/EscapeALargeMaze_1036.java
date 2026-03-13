class Pair{
    int r;
    int c;
    Pair(int a,int b){
        r=a;
        c=b;
    }
}
class Solution {
    static int rr[]=new int[]{-1,0,1,0};
    static int cc[]=new int[]{0,1,0,-1};
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if(blocked.length==0){
            return true;
        }
        HashSet<Long> set=new HashSet<>();
        for(int arr[]: blocked){
            set.add(arr[0]*1000000L+arr[1]);
        }
        return bfs(set,source,target) && bfs(set,target,source);
    }
    static boolean bfs(HashSet<Long> set,int[] source,int []target){
        HashSet<Long> vis=new HashSet<>();
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(source[0],source[1]));
        vis.add(source[0]*1000000L+source[1]);
        while(!q.isEmpty()){
            Pair p=q.poll();
            int or=p.r;
            int oc=p.c;
            if(vis.size()>20000) return true;
            for(int i=0;i<4;i++){
                int nr=or+rr[i];
                int nc=oc+cc[i];
                long key=nr*1000000L+nc;
                if(set.contains(key) || vis.contains(key)) continue;
                if(nr>=0 && nr<1000000 && nc>=0 && nc<1000000 ){
                    if(nr==target[0] && nc==target[1]){
                        return true;
                    }
                    q.add(new Pair(nr,nc));
                    vis.add(key);
                }
            }
        }
        return false;
    }
}