class Solution {
    public String restoreString(String s, int[] indices) {
        StringBuilder temp = new StringBuilder(s);
        for(int i=0; i<indices.length; i++){
            temp.setCharAt(indices[i],s.charAt(i));
        }
        return temp.toString();
    }
}