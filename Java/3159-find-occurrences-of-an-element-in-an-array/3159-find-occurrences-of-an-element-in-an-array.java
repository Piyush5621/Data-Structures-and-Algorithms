class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int pos[] = new int[nums.length];
        int cnt = 0;
        for(int i= 0; i< nums.length; i++){
            if( nums[i] == x){
                pos[cnt++] = i;
            }
        }
        int ans[] = new int[queries.length];
        int k = 0;
        for( int i=0 ; i < queries.length; i++ ){
            ans[i] = (queries[i] > cnt ) ? -1 : pos[queries[i]-1];
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna