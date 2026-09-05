class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int arr[] = new int[n];
        int maxm = nums[0];
        int minm = nums[n-1];
        int ans = -1;
        for( int i = 0; i < n ; i++){
            maxm = Math.max(maxm , nums[i]);
            arr[i] = maxm;
        }
        for( int i = n-1; i >=0 ; i--){
            minm = Math.min(nums[i] , minm);
            arr[i] = arr[i] - minm;
            if(arr[i] <= k){
                ans = i;
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna