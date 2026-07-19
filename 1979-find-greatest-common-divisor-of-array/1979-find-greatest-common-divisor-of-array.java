class Solution {
    public int findGCD(int[] nums) {
        int maxm=Integer.MIN_VALUE;
        int minm=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            maxm=Math.max(maxm,nums[i]);
            minm=Math.min(minm,nums[i]);
        }

        return gcd(maxm,minm);
    }
    static int gcd(int a,int b){
        if(b==0){
            return a;
        }
        return gcd(b,a%b);
    }
}