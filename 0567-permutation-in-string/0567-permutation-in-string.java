class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) {
            return false;
        }
        HashMap<Character,Integer> map = new HashMap<>();

        for(int i =0; i<s1.length(); i++){
            map.put(s1.charAt(i),map.getOrDefault(s1.charAt(i),0)+1);
        }

        int count = map.size();
        int k = s1.length();
        for(int i =0; i < k; i++){
            if(map.containsKey(s2.charAt(i))){
                map.put(s2.charAt(i),map.get(s2.charAt(i))-1);
                if(map.get(s2.charAt(i))==0){
                    count--;
                }
                else if(map.get(s2.charAt(i))==-1){
                    count++;
                }
            }
        }
        if(count==0) return true;

        for(int i = k; i<s2.length(); i++){
            char left = s2.charAt(i-k);
            char right = s2.charAt(i);
            if (map.containsKey(left)) {
                map.put(left, map.get(left) + 1);
                if (map.get(left) == 0) {
                    count--;
                }
                else if (map.get(left) == 1) {
                    count++;
                }
            }
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);

                if (map.get(right) == 0) {
                    count--;
                }
                else if (map.get(right) == -1) {
                    count++;
                }
            }

            if(count==0) return true;
        }
        return false;
    }
}