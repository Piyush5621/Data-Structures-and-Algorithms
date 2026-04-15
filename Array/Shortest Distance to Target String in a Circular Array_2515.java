package Array;

class Solution {
    public int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minm = n+1;
        for(int i=0; i<n; i++){
            if(words[i].equals(target)){
                if(i<startIndex){
                    int x = n - startIndex + i;
                    minm=Math.min(minm,Math.abs(i-startIndex));
                    minm=Math.min(minm,x);
                }
                else{
                    int x = n - i + startIndex;
                    minm=Math.min(minm,Math.abs(i-startIndex));
                    minm=Math.min(minm,x); 
                }
            }
        }
        return (minm==n+1)? -1: minm;
    }
}