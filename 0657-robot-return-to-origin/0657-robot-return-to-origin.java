class Solution {
    public boolean judgeCircle(String moves) {
        int sx = 0;
        int sy = 0;

        for( char c : moves.toCharArray()){
            if(c =='U'){
                sx--;
            }
            else if(c == 'D'){
                sx++;
            }
            else if( c == 'L'){
                sy--;
            }
            else{
                sy++;
            }
        }

        if(sx == 0 && sy == 0 ) return true;
        return false;
    }
}