class Solution {
    public String gcdOfStrings(String str1, String str2) {

        String s1 = str1+str2;
        String s2 = str2+str1;

        if(s1.equals(s2)){
            int idx = Gcd(str1.length(), str2.length());
            return str2.substring(0,idx);
        }

        return "";
    }

    private int Gcd(int a, int b){
        if( b == 0) return a;
        return Gcd(b, a%b);
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna