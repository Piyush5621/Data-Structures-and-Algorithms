class Solution {
    public int furthestDistanceFromOrigin(String moves) {
        int l=0;
        int r=0;
        int d=0;
        int maxmR=0;

        for(int i=0; i<moves.length(); i++){
            char c = moves.charAt(i);
            if(c=='L') l++;
            if(c=='R') r++;
            if(c=='_') d++;
        }
        return Math.abs(l-r)+d;
    }
}