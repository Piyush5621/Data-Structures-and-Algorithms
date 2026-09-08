class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        long[] prefix = new long[n];

        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        long totalSum = prefix[n-1];
        int ans = 0;
        int mid = n / 2;

        for (int i = 0; i < n; i++) {
            long firstSum = 0;
            if( i + mid <= n ){
                firstSum = prefix[i+mid-1] -( (i == 0)? 0 : prefix[i-1]);
            }
            else{
                firstSum = prefix[n-1] -  prefix[i-1] ;
                int rem = (i + mid) % n; 
                if (rem > 0) { 
                    firstSum += prefix[rem - 1]; 
                } 
            }
            if (firstSum < totalSum - firstSum) {
                ans++;
            }
        }

        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna