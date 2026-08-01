class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length-1;
        return solve(0, n, nums,0,0,true);
    }

    private boolean solve(int i, int j , int nums[], int scoreA, int scoreB ,boolean turn ){
        if( i > j){
            if(scoreA >= scoreB){
                return true;
            }
            return false;
        }

        if(turn){
            return solve(i+1, j, nums, scoreA+nums[i],scoreB,false) || solve(i, j-1, nums, scoreA+nums[j],scoreB ,false);
        }
        return solve(i+1, j, nums, scoreA,scoreB+nums[i],true) && solve(i, j-1, nums, scoreA,scoreB+nums[j],true); 
    }
}