class Solution {
    public int[] scoreValidator(String[] events) {
        int n = events.length;
        int score = 0;
        int counter = 0;
        for(int i=0; i<n; i++){
            String str = events[i];
            if(counter==10){
                break;
            }
            if(str.charAt(0)>= '0' && str.charAt(0)<='6'){
                score+=(str.charAt(0)-'0');
            }
            else if(str.equals("W")){
                counter++;
            }
            else if(str.equals("WD")){
                score++;
            }
            else if(str.equals("NB")){
                score++;
            }
        }

        return new int[]{score,counter};
    }
}