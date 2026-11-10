class Solution {
    public String reverseWords(String s) {
        String str[] = s.split(" ");
        StringBuilder ans = new StringBuilder();
        for( String st : str ){
            if(ans.length() > 0) ans.append(" ");
            ans.append(new StringBuilder(st).reverse().toString());

        }
        return ans.toString();
    }
}