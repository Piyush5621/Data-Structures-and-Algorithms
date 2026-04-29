class Solution {
    public String getHappyString(int n, int k) {
        List<String> list = new ArrayList<>();
        backT(0, n,new StringBuilder(),list);
        return (list.size()<k)? "": list.get(k-1);
    }

    void backT(int idx,int n,StringBuilder str,List<String> list){
        if(str.length()==n){
            list.add(str.toString());
            return;
        }
        for(int i=0;i<3;i++){
            char ch = (char)('a' + i);
            if(str.length()>0 && str.charAt(str.length()-1) ==ch) continue;
            str.append(ch);
            backT(idx+1,n,str,list);
            str.deleteCharAt(str.length()-1);
        }
    }
}