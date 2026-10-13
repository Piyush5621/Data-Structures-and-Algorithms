class Solution {
    public long maxAlternatingSum(int[] nums) {
        long ans = 0;
        int n = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for( int i = 0; i < n; i++ ){
            pq.offer(nums[i]*nums[i]);
        }

        int mid = n/2;
        int cnt = 0;
        while(!pq.isEmpty()){
            if(cnt < mid ){
                ans -= pq.poll();
            }
            else{
                ans += pq.poll();
            }
            cnt ++;
        }

        return ans;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna