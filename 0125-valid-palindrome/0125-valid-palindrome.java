class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for(char c : s.toCharArray()){
            if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9')){
                str.append(Character.toLowerCase(c));
            }
            
        }
        String temp = str.toString();
        System.out.println(temp);
        return temp.equals(str.reverse().toString());
    }
}