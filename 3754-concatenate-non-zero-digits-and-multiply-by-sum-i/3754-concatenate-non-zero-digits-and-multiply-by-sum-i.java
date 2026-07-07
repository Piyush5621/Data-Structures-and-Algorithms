class Solution {
    public long sumAndMultiply(int n) {
        int x = 0;
        int sum = 0;
        int i = 1; 
        while( n > 0 ){
            int d = n % 10;
            n /= 10;
            if( d == 0 ) continue;
            x = x + (d * i);
            sum += d;
            i *= 10;
        }
        return (long) x * sum;
    }
}