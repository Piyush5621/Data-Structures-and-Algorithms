class Solution {
    public String replaceDigits(String s) {
        char arr[] = s.toCharArray();
        char ch =' ';
        for( int i =0; i < s.length(); i++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                int num = c -'0';
                arr[i]=(char)(ch+num);
            }
            else{
                ch = c;
            }
        }
        return new String(arr);
    }
}