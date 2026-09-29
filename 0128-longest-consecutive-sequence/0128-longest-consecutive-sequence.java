class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for( int x : nums){
            set.add(x);
        }
        int maxLen = 0;
        for( int num : set ){
            if(!set.contains(num-1)){
                int curr = num;
                int len = 1;

                while(set.contains(curr+1)){
                    len++;
                    curr++;
                }
                maxLen = Math.max(maxLen, len);
            }
        }
        return  maxLen;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna