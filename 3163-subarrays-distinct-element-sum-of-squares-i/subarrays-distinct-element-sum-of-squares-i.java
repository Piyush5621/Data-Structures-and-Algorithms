class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        int n = nums.size();
        for( int i = 0; i < n ; i++ ){
            boolean seen[] = new boolean[101]; 
            int sz = 0;
            for( int j = i; j < n ; j++ ){
                if(!seen[nums.get(j)]){
                    seen[nums.get(j)] = true;
                    sz++;
                }
                ans += (sz*sz);
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna