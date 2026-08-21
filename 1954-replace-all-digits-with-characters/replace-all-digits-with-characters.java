class Solution {
    public String replaceDigits(String s) {
        char arr[] = s.toCharArray();
        for( int i =0; i < s.length(); i+=2){
            if(i+1 < s.length()){
                arr[i+1] = (char)(arr[i]+(arr[i+1]-'0'));
            }
        }
        return new String(arr);
    }
}