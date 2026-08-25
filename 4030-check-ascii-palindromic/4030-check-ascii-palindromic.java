class Solution {
    public boolean isPalindromic(String s) {

        StringBuilder str = new StringBuilder();

        for( char ch : s.toCharArray()){
            String binary = Integer.toBinaryString(ch);
            while(binary.length() < 8){
                binary = '0'+binary;
            }
            str.append(binary);
        }

        int st = 0; 
        int end = str.length()-1;
        while(st < end){
            if(str.charAt(st)!=str.charAt(end)){
                return false;
            }
            st++;
            end--;
        }
        return true;

    }
}