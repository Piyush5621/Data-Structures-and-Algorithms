class Solution {
    public boolean checkDivisibility(int n) {
        
        int sum = 0;
        int pro = 1;
        int temp =  n;
        while( n > 0 ){

            int d = n % 10;
            sum += d;
            pro *= d;
            n /= 10;

        }
        
        int total = sum + pro;  

        return (temp % total ==0);
    }
}