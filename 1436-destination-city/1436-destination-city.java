class Solution {
    public String destCity(List<List<String>> paths) {
        HashSet<String> set = new HashSet<>();

        for(List<String> list : paths){
            set.add(list.get(0));
        }
        String ans ="";
        for(List<String> list : paths){
            if(!set.contains(list.get(1))) ans = list.get(1);
        }
        return ans;
    }
}