class Solution {
    public int minBishopMoves(int[] source, int[] target) {
        int a = source[0], b = source[1];
        int c = target[0] , d = target[1];

        if( (a+b) % 2 ==0 && (c+d)%2!=0 || (a+b) % 2 !=0 && (c+d)%2==0  ) return -1;
        else if( a+b == c+d || b-a == d-c) return 1;
        return 2;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna