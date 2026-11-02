class Solution {
    public int minMoves2(int[] nums) {
        int low = nums[0];
        int high = nums[0];

        for( int x : nums ){
            low = Math.min(low, x);
            high = Math.max(high , x);
        }

        while( low < high ){
            int mid = low + (high - low )/2;

            if(check(mid,nums)){
                high = mid;
            }
            else{
                low = mid+1;
            }
        }

        long ans = 0;

        for (int x : nums) {
            ans += Math.abs((long) x - low);
        }

        return (int) ans;
    }

    boolean check(int mid,int[] nums) {

        int left = 0;
        int right = 0;

        for (int num : nums) {
            if (num <= mid) {
                left++;
            } else {
                right++;
            }
        }

        return left >= right;
    }
}