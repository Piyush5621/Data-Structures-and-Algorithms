class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int incMax = 1;
        int decMax = 1;
        int n = nums.length;
        int currInc = 1;
        int currDec = 1;
        for( int i = 1; i < n; i++ ){
            if(nums[i] > nums[i-1] ){
                currInc++;
            }
            else{
                incMax = Math.max(incMax, currInc);
                currInc = 1;
            }

            if(nums[i] < nums[i-1]){
                currDec++;
            }
            else{
                decMax = Math.max(decMax, currDec);
                currDec = 1;
            }
        }
        incMax = Math.max(incMax, currInc);
        decMax = Math.max(decMax, currDec);

        return Math.max(incMax, decMax);


    }
}