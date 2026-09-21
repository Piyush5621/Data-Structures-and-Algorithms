class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<>();
        set.add(n);
        while(true){
            if(n == 1) return true;
            int sum = 0;
            int temp = n;
            while(temp > 0){
                int d = temp%10;
                sum += (d*d);
                temp /=10;
            }
            if(set.contains(sum)){
                break;
            }
            set.add(sum);
            n = sum;
        }
        return false;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna