class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }
        StringBuilder arr[] = new StringBuilder[numRows];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new StringBuilder();
        }
        int j = 0;
        boolean down = true;
        for(int i=0; i<s.length(); i++){
            arr[j].append(s.charAt(i));
            if(down){
                j++;
            }
            else{
                j--;
            }
            if(j==numRows-1){
                down=false;
            }
            else if(j==0){
                down = true;
            }
        }
        StringBuilder ans = new StringBuilder();
        for(StringBuilder ss : arr){
            ans.append(ss);
        }

        return ans.toString();
    }
}