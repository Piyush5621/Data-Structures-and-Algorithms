class Solution {
    int minm=Integer.MAX_VALUE;;
    public int distributeCookies(int[] cookies, int k) {
        int bachee[] = new int[k];
        int n=cookies.length;
        rec(0,n,cookies,bachee,k);
        return minm;
    }

    void rec(int i, int n, int[] cookies, int []bachee, int k){
        if(i == n){
            int maxm = 0;
            for(int q=0; q<k; q++){
                maxm = Math.max(maxm,bachee[q]);
            }
            minm = Math.min(minm, maxm);
            return;
        }

        int cookie = cookies[i];
        for(int p = 0; p < k; p++){
            bachee[p]+=cookie;
            rec(i+1,n, cookies, bachee, k);
            bachee[p]-=cookie;
        }
    }
}