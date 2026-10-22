class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();

        for( int i = 0; i < numRows; i++ ){
            List<Integer> list = new ArrayList<>();
            for( int j = 0; j <= i; j++ ){
                if( j == 0 || j == i ){
                    list.add(1);
                }
                else{
                    list.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
                }
            }
            ans.add(list);
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna