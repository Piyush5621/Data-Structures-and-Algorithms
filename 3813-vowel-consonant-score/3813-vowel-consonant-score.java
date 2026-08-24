class Solution {
    public int vowelConsonantScore(String s) {
        int v = 0;
        int con = 0;
        for( char c : s.toCharArray()){
            if(c =='a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                v++;
            }
            else if(Character.isLetter(c)) con++;
        }
        return con == 0 ? 0 : v / con; 
    }
}