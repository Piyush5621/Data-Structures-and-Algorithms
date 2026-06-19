class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int prefixSum = 0;
        int res = 0;
        for(int i=0; i<n; i++){
           prefixSum+=gain[i];
           res = Math.max(prefixSum,res);
        }
        return res;
    }
}