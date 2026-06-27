class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder str = new StringBuilder();
        int k =0;
        int i =0;
        int j =0;
        while(i<word1.length() && j<word2.length()){
            if(k%2==0){
                str.append(word1.charAt(i));
                i++;
            }
            else{
                str.append(word2.charAt(j));
                j++;
            }
            k++;
        }

        if(i<word1.length()){
            str.append(word1.substring(i,word1.length()));
        }
        if(j<word2.length()){
            str.append(word2.substring(j,word2.length()));
        }

        return str.toString();
    }
}