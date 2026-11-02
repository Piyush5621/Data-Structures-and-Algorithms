class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int mid = 0;
        if( n % 2 == 0){
            mid = (nums[n/2] + nums[(n+1)/2])/2;
        }
        else{
            mid = nums[n/2];
        }

        long ans = 0;

        for (int x : nums) {
            ans += Math.abs((long) x - mid);
        }

        return (int) ans;
    }
}