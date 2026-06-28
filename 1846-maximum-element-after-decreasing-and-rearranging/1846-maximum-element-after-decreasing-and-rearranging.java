class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for(int i =1;i<arr.length;i++){
            if(Math.abs(arr[i]-arr[i-1])<=1){
                continue;
            }
            else{
                arr[i]=arr[i-1]+1;
            }
        }
        int maxm =arr[0];
        for(int x : arr){
            maxm = Math.max(maxm,x);
        }
        return maxm;
    }
}