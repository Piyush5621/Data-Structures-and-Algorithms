class Solution {
    static final int MOD = 1000000007;

    public int[] sumAndMultiply(String s, int[][] queries) {
        int n = s.length();

        int[] digitSum = new int[n + 1];
        int[] nonZeroCnt = new int[n + 1];
        long[] prefixNum = new long[n + 1];
        long[] pow10 = new long[n + 1];
        pow10[0] = 1;

        for (int i = 1; i <= n; i++) {
            pow10[i] = (pow10[i - 1] * 10) % MOD;
        }

        for (int i = 1; i <= n; i++) {
            int d = s.charAt(i - 1) - '0';

            digitSum[i] = digitSum[i - 1] + d;
            nonZeroCnt[i] = nonZeroCnt[i - 1];

            if (d == 0) {
                prefixNum[i] = prefixNum[i - 1];
            } else {
                nonZeroCnt[i]++;
                prefixNum[i] = (prefixNum[i - 1] * 10 + d) % MOD;
            }
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            int sum = digitSum[r + 1] - digitSum[l];

            int cnt = nonZeroCnt[r + 1] - nonZeroCnt[l];

            long num = (prefixNum[r + 1] - (prefixNum[l] * pow10[cnt]) % MOD + MOD) % MOD;

            ans[i] = (int) ((num * sum) % MOD);
        }

        return ans;
    }
}