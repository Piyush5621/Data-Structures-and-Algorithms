class Solution {
    public int heightChecker(int[] heights) {
        int freq[] = new int[101];

        for(int x : heights) freq[x]++;

        int mismatch = 0;
        int idx = 0; 

        for(int i=0; i<101; i++){
            while(freq[i]>0){
                if(heights[idx]!=i){
                    mismatch++;
                }
                idx++;
                freq[i]--;
            }
        }
        return mismatch;
    }
}