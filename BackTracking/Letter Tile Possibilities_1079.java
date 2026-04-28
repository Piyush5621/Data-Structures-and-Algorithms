class Solution {
    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        HashSet<String> set = new HashSet<>();
        boolean used[] =new boolean[n];
        backT(0, tiles,set, new StringBuilder(),used);
        return set.size()-1;
    }

    void backT(int idx, String tiles, HashSet<String> set,StringBuilder temp,boolean used[]){
        set.add(temp.toString());

        for(int i=0; i<tiles.length(); i++){
            if(!used[i]){
                temp.append(tiles.charAt(i));
                used[i] = true;
                backT(idx+1,tiles,set,temp,used);
                temp.deleteCharAt(temp.length()-1);
                used[i] = false;
            }
           
        }
    }
    
}