class Solution {
    public int appendCharacters(String s, String t) {

        int i = 0; 
        int j = 0;

        boolean exist = false;
        while( i < s.length() && j < t.length()){
            if(s.charAt(i)==t.charAt(j)){
                exist = true;
                i++;
                j++;
            }
            else{
                i++;
            }
            
        }

        if(!exist) return t.length();
        return t.length()-j;
    }
}