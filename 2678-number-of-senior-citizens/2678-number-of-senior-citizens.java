class Solution {
    public int countSeniors(String[] details) {
        int ans = 0;
        for( String s : details){
            String str = s.substring(s.length()-4,s.length()-2);
            int num = Integer.parseInt(str);
            if(num > 60 ){
                ans++;
            }
        }
        return ans;
    }
}