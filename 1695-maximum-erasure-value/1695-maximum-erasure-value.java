class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        boolean visited[] = new boolean[10001];
        int left = 0;
        int maxSum = 0;
        int prefixSum = 0;
        for(int i = 0; i < n; i++){
            while(visited[nums[i]]){
                visited[nums[left]]=false;
                prefixSum -= nums[left];
                left++;
            }
            prefixSum += nums[i];
            visited[nums[i]] = true;

            maxSum = Math.max(maxSum, prefixSum);
        }
        return maxSum;
    }
}