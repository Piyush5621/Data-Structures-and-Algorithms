class Solution {
    public boolean areNumbersAscending(String s) {
        int prev = Integer.MIN_VALUE;
        StringBuilder temp = new StringBuilder(); 
        for( char c : s.toCharArray() ){
            if(Character.isDigit(c)){
                temp.append(c);
            }
            else {
                if(temp.length()>0){
                    int num = Integer.parseInt(temp.toString());
                    temp.setLength(0);
                    if(prev >= num){
                        return false;
                    }
                    prev = num;
                }
                
            }
        }
        if(temp.length()>0){
            int num = Integer.parseInt(temp.toString());
            if(prev >= num){
                return false;
            }
        }
        return true;
    }
}