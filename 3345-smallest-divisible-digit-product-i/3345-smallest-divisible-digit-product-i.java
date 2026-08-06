class Solution {
    public int smallestNumber(int n, int t) {
        int start = n;

        while(true){
            String str = String.valueOf(start);
            int pro =1;
            if(str.indexOf('0')!=-1){
                return Integer.parseInt(str);
            }
            else{
                for(int i = 0; i< str.length(); i++){
                    pro *= (int)(str.charAt(i)-'0');
                }

                if(pro % t ==0) return Integer.parseInt(str);
            }
            start++;
        }
    }
}