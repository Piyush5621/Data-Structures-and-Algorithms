class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        rec(0,s.length(),s,res,new ArrayList<>());
        return res;
    }

    void rec(int i, int n, String s, List<List<String>> res, List<String> temp){
        if(i==n){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int j=i;j<n;j++){
            String sub = s.substring(i, j+1); 
            if(check(sub)){
                temp.add(sub);
                rec(j+1,n,s,res,temp);
                temp.remove(temp.size()-1);
            }
        }
    }

    boolean check(String s){
        int l = 0;
        int r = s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}

//2nd solution

class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        rec(0,s.length(),s,res,new ArrayList<>());
        return res;
    }

    void rec(int i, int n, String s, List<List<String>> res, List<String> temp){
        if(i==n){
            res.add(new ArrayList<>(temp));
            return;
        }
        StringBuilder str = new StringBuilder();
        for(int j=i;j<n;j++){
            str.append(s.charAt(j));
            if(check(str.toString())){
                temp.add(str.toString());
                rec(j+1,n,s,res,temp);
                temp.remove(temp.size()-1);
            }
        }
    }

    boolean check(String s){
        int l = 0;
        int r = s.length()-1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}