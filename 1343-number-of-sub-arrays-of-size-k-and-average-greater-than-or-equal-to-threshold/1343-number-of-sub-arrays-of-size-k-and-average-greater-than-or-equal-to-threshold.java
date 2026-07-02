class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int Avg = 0;
        int sum = 0;
        int n = arr.length;
        for(int i =0; i < k ; i++){
            sum += arr[i];
        }
        Avg = sum/k;
        int ans = 0;
        if(Avg >= threshold) ans++;
        for(int i =k ; i < n ; i++){
            sum = sum - arr[i-k] + arr[i];
            Avg =sum/k;
            if(Avg >= threshold) ans++;
        }

        return ans;
    }
}