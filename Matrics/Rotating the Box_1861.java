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


//or 
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
            int k=-1;
            int j = m-1;
            while(j>=0){
                boolean flag = true;
                char c = ans[j][i];
                if(c=='*'){
                    k=-1;
                }
                else if(c=='.' && k==-1){
                    k=j;
                }
                else if(c=='#' && k!=-1){
                    char temp = c;
                    ans[j][i] = ans[k][i];
                    ans[k][i] = temp;
                    flag = false;
                }

                if(flag){
                    j--;
                }
                else{
                    j=k;
                    k=-1;
                }
            }
        }


        return ans;
    }
}