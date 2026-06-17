class Solution {
    public char processStr(String s, long k) {
        long len = 0;
        for(char c : s.toCharArray()){
            switch(c){
                case '*':
                    if(len>0) len--;
                    break;
                case '#':
                    len*=2;
                    break;
                case '%':
                    break;
                default:
                   len++;
            }
        }

        if(k>=len) return '.';
        for(int i=s.length()-1; i>=0; i--){
            char c = s.charAt(i);
            switch(c){
                case '*':
                    len++;
                    break;
                case '#':
                    long half = len/=2;
                    if(k >= half){
                        k=k-half;
                    }
                    len = half; 
                    break;
                case '%':
                    k = len - k - 1;
                    break;
                default:
                    if(k==len-1){
                        return c;
                    }
                    len--;
            }
        }
        return '.'; 
    }
}