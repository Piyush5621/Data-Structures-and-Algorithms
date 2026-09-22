class Solution {
    public String reverseWords(String s) {
        String str[] = s.split(" ");

        StringBuilder ans = new StringBuilder();
        int initailCount = countVowel(str[0]);
        ans.append(str[0]);
        for( int i = 1 ; i < str.length; i++ ){
            ans.append(" ");
            String st = str[i];
            if(countVowel(st) == initailCount){
                String t = Reverse(new StringBuilder(st));
                ans.append(t);
            }
            else{
                ans.append(st);
            }
        }
        return ans.toString();
    }
    private int countVowel(String st){
        int cnt = 0;
        for( char c : st.toCharArray()){
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                cnt++;
            }
        }

        return cnt;

    }

    private String Reverse(StringBuilder s ){
        int low = 0 ;
        int high = s.length() -1;

        while( low <  high){
            char temp = s.charAt(low);
            s.setCharAt(low,s.charAt(high));
            s.setCharAt(high,temp);
            low++;
            high--;
        }
        return s.toString();
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna