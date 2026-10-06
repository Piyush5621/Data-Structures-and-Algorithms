class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[] = new int[26];
        int maxFreq = 0;
        for( char c : tasks){
            freq[c -'A']++;
        }

        for( int i = 0; i < 26; i++ ){
            maxFreq = Math.max(maxFreq,freq[i]);
        }
        int countMax =  0;
        for( int i = 0; i < 26 ; i++ ){
            if(freq[i] == maxFreq){
                countMax++;
            }
        }

        int idle = (maxFreq - 1) * (n + 1 - countMax);

        idle -= (tasks.length - (maxFreq * countMax));
        idle = Math.max(0, idle);

        return tasks.length + idle;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna