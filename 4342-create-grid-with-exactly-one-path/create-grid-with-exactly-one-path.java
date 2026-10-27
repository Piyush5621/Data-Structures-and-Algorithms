class Solution {
    public String[] createGrid(int m, int n) {
        String[] ans = new String[m];
        char[][] str =new char[m][n];
        boolean vis[][] = new boolean[m][n];
        for(char [] a: str){
            Arrays.fill(a,'#');
        }
        for(int i=0;i<n;i++){
            str[0][i] ='.';
        }

        for(int i=0;i<m;i++){
            str[i][n-1]='.';
        }

        for(int i=0;i<m;i++){
            StringBuilder temp = new StringBuilder();
            for(int j=0; j<n; j++){
                temp.append(str[i][j]);
            }
            ans[i]=temp.toString();
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna