class Solution {
    public String decodeAtIndex(String s, int k) {
        long length = 0;

        for( char c : s.toCharArray()){
            if(Character.isDigit(c)){
                int num = c - '0';
                length = length * num;
            }
            else{
                length++;
            }
        }

        for( int i = s.length()-1 ; i>=0; i--){
            char ch = s.charAt(i);
            if(Character.isLetter(ch)){
                if( k == length){
                    return String.valueOf(ch);
                }
                length--;
            }
            else{
                int num = ch - '0';
                long prevLength = length/num;
                k = (int)((k-1)%prevLength)+1;
                length = prevLength;
            }
        }
        return "";
    }
}