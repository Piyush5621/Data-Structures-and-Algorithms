class Solution {
    public int sumCounts(List<Integer> nums) {
        int ans = 0;
        for( int i = 0; i < nums.size(); i++ ){
            HashSet<Integer> set = new HashSet<>();
            for( int j = i; j < nums.size(); j++ ){
                set.add(nums.get(j));
                int sz = set.size();
                ans += (sz*sz);
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna