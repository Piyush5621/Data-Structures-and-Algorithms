class Solution {
    public long sumAndMultiply(int n) {
        long x = 0;
        int temp = n;
        if(n==0) return 0;
        StringBuilder str = new StringBuilder();
        while( temp > 0 ){
            char c = (char)((temp%10)+'0');
            x+=temp%10;
            if(c>='1' && c<='9'){
                str.append(c);
            }
            temp/=10;
        }
        if(str.length()==0){
            return 1;
        }
        int s = Integer.parseInt(str.reverse().toString());
        return (long)(s*x);
    }
}