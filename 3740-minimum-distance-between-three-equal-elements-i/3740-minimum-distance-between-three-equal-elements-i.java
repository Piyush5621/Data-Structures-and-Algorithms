class Solution {
    public int minimumDistance(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int s=-1;
            int t=-1;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]==nums[i]){
                    if(s==-1){
                        s=j;
                    }
                    else{
                        t=j;
                        break;
                    }
                }
            }
            if(s!=-1 && t!=-1){
                ans = Math.min(ans,(s-i)+(t-s)+(t-i));
            }
        }
        return (ans==Integer.MAX_VALUE)? -1: ans;
    }
}