class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        Integer memo[][]= new Integer[n][m];

        return solve(0,0,triangle,memo);
    }

    private int solve(int i, int j , List<List<Integer>> tri,Integer memo[][]){
        if(i >= tri.size()) return 0;
        if(memo[i][j]!=null) return memo[i][j];
        int choice1 = solve(i+1,j,tri,memo);
        int choice2 = solve(i+1,j+1,tri,memo);
        memo[i][j] = tri.get(i).get(j)+Math.min(choice1,choice2);
        return memo[i][j];
    }
}