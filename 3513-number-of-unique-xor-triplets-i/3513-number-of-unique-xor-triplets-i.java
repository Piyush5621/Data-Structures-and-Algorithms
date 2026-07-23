class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if(n==1 || n==2) return n;
        int temp =1;
        int c = 1;
        while(temp <= n){
            temp = (int)Math.pow(2,c);
            c++;
        }
        return temp;
    }
}