class Solution {
    public int mirrorDistance(int n) {
        int num=0;
        int temp = n;
        while(temp>0){
            num = num*10 + temp%10;
            temp/=10;
        }
        return Math.abs(num-n);
    }
}