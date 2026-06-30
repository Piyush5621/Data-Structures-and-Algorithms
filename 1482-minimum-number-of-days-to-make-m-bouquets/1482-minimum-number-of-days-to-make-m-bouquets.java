class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int start = bloomDay[0];
        int end = bloomDay[0];

        for(int x : bloomDay){
            start = Math.min( start, x);
            end = Math.max(end, x);
        }
        int ans = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(canMake(mid, m, k ,bloomDay)){
                ans = mid;
                end = mid -1;
            }
            else{
                start = mid + 1;
            }
        }
        return ans;
    }

    public boolean canMake(int mid, int m, int k, int[] bloomDay){
        int flower = bloomDay[0];
        int last = bloomDay[0];
        int fl = 0;
        int bk =0;
        int n = bloomDay.length;
        for(int i =0 ; i<n ; i++){
            if(bloomDay[i] <= mid){
                fl++;
                if(fl==k){
                    bk++;
                    fl =0;
                    if(bk >= m){
                        return true;
                    }
                }
            }
            else{
                fl = 0;
            }
        }
        return false;
    }
}