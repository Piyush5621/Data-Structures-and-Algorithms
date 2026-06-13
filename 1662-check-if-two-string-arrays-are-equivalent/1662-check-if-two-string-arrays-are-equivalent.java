class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder str1 = new StringBuilder();

        for(int i=0; i<word1.length; i++){
            str1.append(word1[i]);
        }

        int n = str1.length();
        for(int i=0; i<word2.length; i++){
            str1.append(word2[i]);
        }


        return (str1.substring(0,n).equals(str1.substring(n,str1.length())));
    }
}