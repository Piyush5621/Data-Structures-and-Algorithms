class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int n = boxGrid.length;
        int m = boxGrid[0].length;
        char [][] ans = new char[m][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                ans[j][n-i-1] = boxGrid[i][j];
            }
        }
        for(int i=0;i<n;i++){
            int k=m-1;
            for(int j = m-1;j>=0;j--){
                if(ans[j][i]=='*'){
                    k=j-1;
                }
                else if(ans[j][i]=='#'){
                    ans[j][i]='.';
                    ans[k][i]='#';
                    k=k-1;
                }
            }
        }
        return ans;
    }
}