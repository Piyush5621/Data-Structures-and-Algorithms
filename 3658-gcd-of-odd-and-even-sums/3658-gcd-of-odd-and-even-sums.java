class Solution {
    public int gcdOfOddEvenSums(int n) {
        int odd = n*(n+1);
        int even = n*n;
        return gcd(odd, even);
    }

    int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
}