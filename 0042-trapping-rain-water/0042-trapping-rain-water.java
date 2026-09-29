class Solution {
    public int trap(int[] h) {
        int n = h.length; 
        int start = 0;
        int end = n-1;
        int leftMax = h[start];
        int rightMax = h[end];
        int ans = 0;

        while( start < end ){
            if( leftMax < rightMax ){
                start++;
                leftMax = Math.max(leftMax, h[start]);
                ans += leftMax - h[start];
            }
            else{
                end--;
                rightMax = Math.max(rightMax,h[end]);
                ans += rightMax - h[end];
            }
        }
        
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna