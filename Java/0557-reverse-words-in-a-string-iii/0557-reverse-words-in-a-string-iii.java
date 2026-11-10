class Solution {
    public String reverseWords(String s) {
        StringBuilder ans = new StringBuilder(s);
        int start  = 0;
        for( int i = 0; i < s.length(); i++ ){
            char ch = s.charAt(i);
            if( i > 0 && ch == ' '){
                int end = i-1;
                while(start < end ){
                    char temp = ans.charAt(start);
                    ans.setCharAt(start, ans.charAt(end));
                    ans.setCharAt(end, temp);
                    start++;
                    end--;
                }
                start = i+1;
            }
        }
        int end = s.length()-1;
        while(start < end ){
            char temp = ans.charAt(start);
            ans.setCharAt(start, ans.charAt(end));
            ans.setCharAt(end, temp);
            start++;
            end--;
        }

        return ans.toString();
    }
}