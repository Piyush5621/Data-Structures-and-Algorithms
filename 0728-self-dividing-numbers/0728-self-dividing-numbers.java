class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans = new ArrayList<>();

        for(int i=left; i<=right; i++){
            String str = String.valueOf(i);
            boolean flag = true;
            for(int j=0;j<str.length();j++){
                int a =str.charAt(j)-'0';
                if(a==0){
                    flag = false;
                    break;
                }
                if(i%a!=0){
                    flag = false;
                    break; 
                }
            }
            if(flag) ans.add(i);
        }
        return ans;
    }
}