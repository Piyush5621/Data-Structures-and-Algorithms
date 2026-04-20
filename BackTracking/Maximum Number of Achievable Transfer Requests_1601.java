class Solution {
    int maxm=Integer.MIN_VALUE;
    public int maximumRequests(int n, int[][] requests) {
        int net[] = new int[n];
        rec(0,requests.length,requests,net,0);
        return maxm;
    }

    void rec(int i, int m, int[][] requests, int net[],int count){
        if(i>=m){
            boolean exist=false;
            for(int x : net){
                if(x!=0){
                    exist=true;
                    break;
                }
            }
            if(!exist){
                maxm=Math.max(maxm,count);
            }
            return;
            
        }
        int from=requests[i][0];
        int to=requests[i][1];      
        net[from]--;
        net[to]++;  
        rec(i+1,m,requests,net,count+1);
        net[from]++;
        net[to]--;
        rec(i+1,m,requests,net,count);
    }

}