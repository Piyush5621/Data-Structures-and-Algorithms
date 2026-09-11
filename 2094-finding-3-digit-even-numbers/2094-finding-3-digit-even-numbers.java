class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int n = digits.length;
        boolean vist[] = new boolean[1000];
        int size = 0;
        for( int i = 0; i < n ; i++ ){
            if(digits[i] == 0) continue;
            for( int j = 0; j < n; j++ ){
                if( i == j ) continue;
                for( int k = 0; k < n ; k++ ){
                    if( i==k || j == k || digits[k]%2!=0) continue;
                    int num = digits[i]*100 + digits[j]*10 + digits[k];
                    if(!vist[num]){
                        vist[num] = true;
                        size++;
                    }
                }
            }
        }

        int ans[] = new int[size];
        int j = 0;
        for( int i =100; i < 1000; i++){
            if(vist[i]){
                ans[j++] = i;
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna