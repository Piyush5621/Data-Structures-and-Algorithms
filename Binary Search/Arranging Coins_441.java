class Solution {
    public int arrangeCoins(int n) {
        int l=1;
        int h=n;
        int maxm=0;
        while(l<=h){
            int mid = l+(h-l)/2;
            long coin = (long)mid*(mid+1)/2;
            if(coin>n){
                h=mid-1;
            }
            else{
                l=mid+1;
                maxm = Math.max(maxm,mid);
            }
        }
        return maxm;
    }
}