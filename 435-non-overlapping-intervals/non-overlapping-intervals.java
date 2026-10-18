class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[1] - b[1]);
        int cnt = 0;
        int maxm = Integer.MIN_VALUE;
        for( int i = 0; i < intervals.length; i++ ){
            if( intervals[i][0] < maxm ){
                cnt++;
            }
            else{
                maxm = intervals[i][1];
            }
        }
        return cnt;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna