
import java.util.Arrays;

class Solution {
    public int minOperations(String s) {
        int n = s.length();
        char[] ch = s.toCharArray();
        Arrays.sort(ch);

        if (s.equals(new String(ch))) return 0;
        if (n == 2) return -1;

        if (s.charAt(0) == ch[0] ||
            s.charAt(n - 1) == ch[n - 1]) return 1;

        if (s.charAt(0) == ch[n - 1] && s.charAt(n - 1) == ch[0] && ch[0] != ch[1] && ch[n - 1] != ch[n - 2]) {
            return 3;
        }

        return 2;
    }
}


// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna