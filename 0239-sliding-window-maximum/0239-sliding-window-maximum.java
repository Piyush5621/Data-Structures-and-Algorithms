class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int len = n -  k + 1;
        Deque<Integer> dq = new ArrayDeque<>();
        for( int i = 0; i < k ; i++ ){
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
                dq.pollLast();
            }
            dq.addLast(i);
        }
        int res[] = new int[len];
        int j =  0;
        res[j++] = nums[dq.peekFirst()];

        for( int i = k ; i < n ; i++ ){
            if(dq.peekFirst() <= i - k ){
                dq.pollFirst();
            }
            while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i] ){
                dq.pollLast();
            }
            dq.addLast(i);
            res[j++] = nums[dq.peekFirst()];
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna