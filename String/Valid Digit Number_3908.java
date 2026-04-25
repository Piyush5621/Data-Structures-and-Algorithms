class Solution {
    public boolean validDigit(int n, int x) {
        String str = String.valueOf(n);
        if(!str.startsWith(String.valueOf(x)) && str.contains(String.valueOf(x))){
            return true;
        }
        return false;
    }
}