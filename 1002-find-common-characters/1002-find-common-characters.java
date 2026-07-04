class Solution {
    public List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();
        int freq[] = new int[26];
        int cnt =0;
        for(String str : words){
            int[] f = new int[26];
            for(int i =0; i < str.length(); i++){
                char c = str.charAt(i);
                f[c-'a']++;
            }
            for(int i=0; i<26; i++){
                if(cnt==0){
                    freq[i] = f[i];
                }
                else{
                    freq[i] =  Math.min(freq[i],f[i]);
                }
                
            }
            cnt++;
        }
        int n = words.length;
        for(int i=0; i<26; i++){
            int len = freq[i];
            
            for(int l=0; l<len; l++){
                String temp ="";
                temp+=(char)(i+'a');
                res.add(temp);
            }
        }
        return res;

    }
}