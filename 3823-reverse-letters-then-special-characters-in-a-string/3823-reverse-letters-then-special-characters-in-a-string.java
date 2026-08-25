class Solution {
    public String reverseByType(String s) {
        int n = s.length();
        char []arr = s.toCharArray();
        int idxChar = n-1;
        int idxSplChar = n-1;

        for( int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(Character.isLetter(ch)){
                while(  idxChar >=0 &&!Character.isLetter(s.charAt(idxChar)) ){
                    idxChar--;
                }
                arr[i] = s.charAt(idxChar--);
            }
            else{
                while(idxSplChar >=0 &&Character.isLetter(s.charAt(idxSplChar))){
                    idxSplChar--;
                }
                arr[i] = s.charAt(idxSplChar--);
            }
        }

        return new String(arr);

    }
}