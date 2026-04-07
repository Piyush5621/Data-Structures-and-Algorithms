class Solution {
    public int firstMatchingIndex(String s) {
        int low=0;
        int high=s.length()-1;
        while(low<=high){
            if(s.charAt(low)== s.charAt(high)){
                return low;
            }
            low++;
            high--;
        }
        return -1;
    }
}