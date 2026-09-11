class Solution {
    public int totalNumbers(int[] digits) {
        int ans = 0;
        int n = digits.length;
        boolean visited[] = new boolean[1000];
        for( int i = 0; i < n; i++){
            if( digits[i]==0 ) continue;
            for( int j = 0 ; j < n; j++){
                if(j ==i ) continue;
                for( int k = 0 ; k < n; k++){
                    if(k==i || k==j ) continue;
                    int num = digits[i]*100+digits[j]*10+digits[k];
                    if(digits[k]%2 == 0 && !visited[num]){
                        visited[num] = true;
                        ans++;
                    }  
                }
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna