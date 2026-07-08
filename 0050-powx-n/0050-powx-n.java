class Solution {
    public double myPow(double x, int n) {
        int a = n/2;
        long num = n;
        if(num < 0){
            x = 1/x;
            num= -num;
        }
        return solve(x,num);
    }

    double solve(double x, long n){
        if(n==0){
            return 1;
        }

        double half = solve(x,n/2);

        if(n%2==0){
            return half*half;
        }
        return x * half * half;
    }
}