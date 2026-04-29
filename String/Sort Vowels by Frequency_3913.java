class Solution {
    public String sortVowels(String s) {
        int freq[] = new int[26];
        List<Character>list =  new ArrayList<>();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(isVowel(c)){
                freq[c-'a']++;
                if(freq[c-'a']==1) list.add(c);
            }
        }
        Collections.sort(list,(a,b)->freq[b-'a']-freq[a-'a']);
        StringBuilder ans = new StringBuilder();
        int j=0;
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(isVowel(c)){
                ans.append(list.get(j));
                freq[list.get(j)-'a']--;
                if(freq[list.get(j)-'a']==0){
                    j++;
                }
            }
            else{
                ans.append(c);
            }
        }

        return ans.toString();

    }

    boolean isVowel(char a){
        return "aeiou".indexOf(a)!=-1;
    }
}