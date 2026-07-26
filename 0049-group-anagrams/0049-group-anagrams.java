class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String str : strs){
            char [] chr = str.toCharArray();
            Arrays.sort(chr);
            String temp = new String(chr);
            if(map.containsKey(temp)){
                map.get(temp).add(str);
            }
            else{
                map.put(temp,new ArrayList<>());
                map.get(temp).add(str);
            }
        }

        List<List<String>> ans = new ArrayList<>();

        for( String temp : map.keySet()){
            ans.add(map.get(temp));
        }
        return ans;
    }
}