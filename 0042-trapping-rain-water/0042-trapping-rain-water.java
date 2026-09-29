class Solution {
    public int trap(int[] h) {
        int lm[]=new int[h.length];  
        int rm[]=new int[h.length];
        
        lm[0]=h[0];
        for(int i = 1; i < h.length; i++){
            lm[i]=Math.max(lm[i-1],h[i]);
        }
        rm[h.length-1] = h[h.length-1];
        for(int i=h.length-2;i>=0;i--){
            rm[i]=Math.max(rm[i+1],h[i]);
        }
        int res=0;
        for(int i = 0;i<h.length;i++){
            int minm=Math.min(lm[i],rm[i]);
            res+=minm-h[i];
        }
        return res;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna