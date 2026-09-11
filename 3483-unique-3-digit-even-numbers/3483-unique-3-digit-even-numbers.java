class Solution {
    public int totalNumbers(int[] digits) {
        int ans = 0;
        int n = digits.length;
        HashSet<String> set = new HashSet<>();
        for( int i = 0; i < n; i++){
            if( digits[i]==0 ) continue;
            for( int j = 0 ; j < n; j++){
                if(j !=i ){
                    for( int k = 0 ; k < n; k++){
                        if(k!=i && k!=j ){
                            if(digits[k]%2 == 0){
                                set.add(digits[i] + " " + digits[j] + " " + digits[k]);
                            }
                        }
                        
                    }
                }
                
            }
        }
        return set.size();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna