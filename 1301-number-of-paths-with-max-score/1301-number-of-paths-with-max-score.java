class Solution {
    int mod = 1000000007;
    public int countPath(List<String> board, int i ,int j, int memo[][][],int tar){
        if(i < 0 || j < 0 || tar < 0) return 0;
        if(board.get(i).charAt(j)=='X'){
            return 0;
        }
        if(board.get(i).charAt(j)=='E'){
            if(tar == 0) return 1;
            else return 0; 
        }
        if(memo[i][j][tar]!=-1){
            return memo[i][j][tar];
        }
        int val = 0;
        if(board.get(i).charAt(j)=='S'){
            val = 0;
        }else{
            int a = board.get(i).charAt(j)-'0';
            val = a;
        }
        memo[i][j][tar] = (countPath(board,i-1,j,memo,tar-val)+countPath(board,i,j-1,memo,tar-val)+countPath(board,i-1,j-1,memo,tar-val))%mod ;

        return memo[i][j][tar];
    }
    public int maxSum(List<String> board, int i ,int j, int memo[][]){
        if(i < 0 || j < 0) return Integer.MIN_VALUE;
        if(board.get(i).charAt(j)=='X'){
            return Integer.MIN_VALUE;
        }
        if(board.get(i).charAt(j)=='E'){
            return 0;
        }
        int val = 0; 
        if(board.get(i).charAt(j)=='S'){
            val = 0;
        }
        else{
            int a = board.get(i).charAt(j)-'0';
            val = a;
        }
        if(memo[i][j]!=-1){
            return memo[i][j];
        }

        memo[i][j] = (val + (Math.max(maxSum(board,i-1,j,memo),(Math.max(maxSum(board,i,j-1,memo),maxSum(board,i-1,j-1,memo)))%mod))%mod)%mod;

        return memo[i][j];
    }
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int m = board.get(0).length();

        int memo[][] = new int[n][m];
        for(int arr[] :  memo) Arrays.fill(arr,-1);

        int sumMax = maxSum(board,n-1, m-1,memo);

        int ans[] = new int[2];
        if(sumMax < 0){
            ans[0] = 0;
            sumMax = 0;
        }else{
            ans[0] = sumMax;
            
        }
        int memoo[][][] = new int[n][m][sumMax+1];
        for(int i =0; i<n; i++){
            for(int j= 0; j<m ;j++){
                Arrays.fill(memoo[i][j],-1);
            }
        }
        int path = countPath(board,n-1,m-1,memoo,sumMax);
        ans[1] = (path)%mod;

        return ans;
    }
}