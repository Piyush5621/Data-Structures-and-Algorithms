class Solution {
    int memo[];
    boolean[][] palindrome;

    public int maxPalindromes(String s, int k) {

        int n = s.length();

        memo = new int[n + 1];
        Arrays.fill(memo, -1);

        palindrome = new boolean[n][n];

        // Build palindrome table
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {

                if (s.charAt(i) == s.charAt(j) &&
                    (j - i <= 2 || palindrome[i + 1][j - 1])) {

                    palindrome[i][j] = true;
                }
            }
        }

        return solve(0, s, k);
    }

    private int solve(int idx, String s, int k) {

        if (idx >= s.length())
            return 0;

        if (memo[idx] != -1)
            return memo[idx];

        int ans = 0;

        // TAKE first
        for (int end = idx + k - 1; end < s.length(); end++) {

            if (palindrome[idx][end]) {

                ans = Math.max(
                    ans,
                    1 + solve(end + 1, s, k)
                );
            }
        }

        // SKIP later
        ans = Math.max(
            ans,
            solve(idx + 1, s, k)
        );

        return memo[idx] = ans;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna