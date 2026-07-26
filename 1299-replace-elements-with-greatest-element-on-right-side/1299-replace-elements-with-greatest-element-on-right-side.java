class Solution {
    public int[] replaceElements(int[] arr) {
        int n = arr.length;
        int suffix [] = new int[n];
        suffix[n-1] = -1;
        for(int i = n-2; i >=0 ; i--){
            suffix[i] = Math.max(arr[i+1],suffix[i+1]);
        }
        return suffix;
    }
}