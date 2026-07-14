class Solution {
    public String reversePrefix(String word, char ch) {
        boolean onces = false;
        int j = -1;
        for(int i = 0 ; i < word.length(); i++ ){
            char c = word.charAt(i);
            if( c == ch ){
                j = i;
                break;
            }
        }
        if( j == -1) return word;
        int i = 0;
        char[] arr = word.toCharArray();
        while ( i < j){
            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return new String(arr);
    }
}