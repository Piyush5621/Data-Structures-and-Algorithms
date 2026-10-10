class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long freq[] = new long[100001];

        for( int i = 0; i < nums1.length; i++ ){
            freq[Math.abs(nums1[i]-nums2[i])]++;
        }

        long m =(long) k1+k2;

        for( int i = 100000; i > 0  && m > 0 ; i-- ){
            long currOp = Math.min(m, freq[i]);
            freq[i] -= currOp;
            freq[i - 1] += currOp;
            m = m - currOp;
        }

        long ans = 0;
        for( int i = 0; i < 100001; i++ ){
            if(freq[i] > 0){
                ans += freq[i] * i  *  i;
            }
        }
        return ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna