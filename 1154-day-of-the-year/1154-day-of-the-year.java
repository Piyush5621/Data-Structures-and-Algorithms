class Solution {
    public int dayOfYear(String date) {
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8,date.length()));
        int year = Integer.parseInt(date.substring(0,4));

        boolean leapYear = false;
        if(year%400==0 ||(year%4==0 && year%100!=0)){
            leapYear = true;
        }
        int countday = 0;
        for( int i =1; i<month; i++){
            if(i==2){
                if(leapYear){
                    countday+=29;
                }
                else{
                    countday+=28;
                }
                continue;
            }
            if(i>=0 && i <=7){
                if(i%2!=0){
                    countday+=31;
                }
                else{
                    countday+=30;
                }
            }
            else{
                if(i%2!=0){
                    countday+=30;
                }
                else{
                    countday+=31;
                }
            }
        }
        countday += day;
        return countday;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna