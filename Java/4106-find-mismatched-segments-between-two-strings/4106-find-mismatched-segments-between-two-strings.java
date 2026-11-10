class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> ans = new ArrayList<>();

        int i = 0; 
        int n = s1.length();

        while( i < n ){
            if( s1.charAt(i) == s2.charAt(i)){
                i++;
                continue;
            }
            int j = i;
            while( j < n && s1.charAt(j) != s2.charAt(j)){
                j++;
            }
            List<String> list = new ArrayList<>();
            list.add( s1.substring(i,j));
            list.add( s2.substring(i,j));
            ans.add(list);
            i = j+1;
        }

        return ans;
    }
}