class Solution {
    public int missingInteger(int[] nums) {
        int sum  = nums[0];
        int n = nums.length;
        int freq[] = new int[102];
        for( int x : nums) freq[x]++;
        for( int i = 1; i < n ; i++){
            if(nums[i-1]+1 !=nums[i]){
                break;
            }
            sum += nums[i];
        }
        if(sum > 50 ) return sum;
        while(freq[sum]!=0){
            sum++;
            if(sum > 50) return sum;
        }

        return sum;
    }
}