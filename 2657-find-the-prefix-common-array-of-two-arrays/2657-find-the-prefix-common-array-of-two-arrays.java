class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        HashSet<Integer> set = new HashSet<>();
        int n = A.length;
        int ans[] = new int[A.length];
        int freq[] = new int[n+1];
        int common =0;
        for(int i=0;i<n;i++){
            freq[A[i]]++;
            if(freq[A[i]]==2){
                common++;
            }
            freq[B[i]]++;
            if(freq[B[i]]==2){
                common++;
            }
            ans[i]=common;
        }
        return ans;
    }
}