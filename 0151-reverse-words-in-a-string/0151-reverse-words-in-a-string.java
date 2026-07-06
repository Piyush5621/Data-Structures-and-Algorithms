class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        String str = s.trim();
        int cnt = 0; 
        for(int i= str.length()-1; i >=0; i-- ){
            char c = str.charAt(i);
            if(c!=' '){
                temp.append(c);
                cnt = 0;
            }
            else{
                if(cnt<1){
                    res.append(temp.reverse().toString());
                    res.append(" ");
                    temp = new StringBuilder();
                    cnt++;
                }
                
            }
        }
        res.append(temp.reverse().toString());
        return res.toString();
    }
}