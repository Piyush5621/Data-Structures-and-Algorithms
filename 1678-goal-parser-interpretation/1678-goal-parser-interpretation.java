class Solution {
    public String interpret(String command) {
        StringBuilder ans = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        for(int i=0; i<command.length(); i++){
            if(command.charAt(i)=='G'){
                ans.append('G');
            }
            else{
                temp.append(command.charAt(i));
                if(temp.toString().equals("()")){
                    ans.append('o');
                    temp.setLength(0);
                }
                else if(temp.toString().equals("(al)")){
                    ans.append("al");
                    temp.setLength(0);
                }
            }
        }

        return ans.toString();
    }
}