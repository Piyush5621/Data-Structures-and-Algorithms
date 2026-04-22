class Solution {
    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        int n = words.length;
        int scores[] = new int[n];
        int j=0;
        for(String s : words){
            int sr=0;
            for(int i=0; i<s.length();i++){
                sr += score[s.charAt(i)-'a'];
            }
            scores[j++] = sr;
        }
        HashMap<Character,Integer> freq = new HashMap<>();
        for(char c : letters) freq.put(c, freq.getOrDefault(c,0)+1);
        return solve(0, words,freq,scores,0);
    }

    int solve(int idx, String[] words,HashMap<Character,Integer>map ,int[]scores, int currScore){
        if(idx >= words.length){
            return 0;
        }

        String word = words[idx];
        boolean exits = true;
        HashMap<Character,Integer> temp = new HashMap<>();
        for(int i=0; i < word.length(); i++){
            char c = word.charAt(i);
            temp.put(c,temp.getOrDefault(c,0)+1);
            if(!map.containsKey(c) || map.get(c)<temp.get(c)){
                exits=false;
            }
        }
        int notTake=solve(idx+1, words,map,scores,currScore);
        int take = 0;
        if(exits){
            for(char c : temp.keySet()){
                int x=map.get(c) - temp.get(c);
                map.put(c,x);
            }
            take= scores[idx]+solve(idx+1, words,map,scores,currScore);

            for(char c : temp.keySet()){
                int x=map.get(c) + temp.get(c);
                map.put(c,x);
            }
        }

        return Math.max(take,notTake);

    }
}