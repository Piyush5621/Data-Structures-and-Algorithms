class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> ans = new ArrayList<>();

        int Lt = 0;
        int Et = 0;

        for( int i = 0; i < nums.length; i++ ){
            if( nums[i] == target ){
                Et++;
            }
            else if(nums[i] < target){
                Lt++;
            }
        }

        for( int i = Lt; i < Lt+Et ;i++){
            ans.add(i);
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna