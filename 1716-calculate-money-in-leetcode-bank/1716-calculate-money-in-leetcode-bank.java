class Solution {
    public int totalMoney(int n) {
        if(n<=7){
            return n*(n+1)/2;
        }

        int a = n/7;
        int rem = n%7;
        int ans = 0;
        int weeksum  = 28;
        for(int i =0; i<a; i++){
            ans+=weeksum;
            weeksum+=7;
        }
        int curr = a+1;
        for(int i=0; i<rem; i++){
            ans+=curr;
            curr++;
        }

        return ans;
    }
}