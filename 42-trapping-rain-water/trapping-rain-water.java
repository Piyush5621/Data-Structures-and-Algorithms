class Solution {
    public int trap(int[] h) {
        int n = h.length; 
        
        int start = 0;
        int end = n-1;

        int leftMax = 0;
        int rightMax = 0;

        int ans = 0;

        while( start < end ){
            leftMax = Math.max(leftMax, h[start]);
            rightMax = Math.max(rightMax,h[end]);

            if( leftMax < rightMax ){
                ans += leftMax - h[start];
                start++;
            }
            else{
                ans += rightMax - h[end];
                end--;

            }
        }
        
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna