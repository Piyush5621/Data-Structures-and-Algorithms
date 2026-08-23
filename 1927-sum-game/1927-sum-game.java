class Solution {
    public boolean sumGame(String num) {
        int diff = 0 ;
        int hl=0, hr =0;
        int n = num.length();
        for( int i = 0; i < n; i++){
            char ch = num.charAt(i);
            if( i < n/2){
                if( ch == '?') hl++;
                else diff += ch -'0';
            }
            else{
                if( ch == '?') hr++;
                else diff -= ch -'0';
            }
        }
        if( (hr+hl)%2 == 1 ){
          return true;
        }
        return diff != 9 * (hr - hl)/2;

    }
}