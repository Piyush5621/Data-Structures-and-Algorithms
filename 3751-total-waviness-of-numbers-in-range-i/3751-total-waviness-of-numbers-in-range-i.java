class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans = 0;
        for(int i=num1; i<=num2; i++){
            String str = String.valueOf(i);
            for(int j=1; j<str.length()-1; j++){
                int a = str.charAt(j);
                int b = str.charAt(j-1);
                int c = str.charAt(j+1);
                if(b<a && c<a) ans++;
                if((b>a && c>a)) ans++;
            }
        }
        return ans;
    }
}