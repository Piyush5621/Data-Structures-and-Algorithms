class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int prefixMin[] = new int[n];
        Arrays.fill(prefixMin, Integer.MAX_VALUE);
        int left = 0;
        int sum = 0;
        int minm = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        for( int i = 0; i < n ; i++ ){
            sum += arr[i];
            while( left <= i && sum > target){
                sum -= arr[left];
                left++;
            }
            if( sum == target ){
                int len = i - left + 1;
                if(left > 0 && prefixMin[left-1] != Integer.MAX_VALUE){
                    ans = Math.min(ans, prefixMin[left-1] + len);
                }
                minm = Math.min(minm, len);
            }

            prefixMin[i] = minm;
            
        }
        return (ans == Integer.MAX_VALUE) ? -1 : ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna