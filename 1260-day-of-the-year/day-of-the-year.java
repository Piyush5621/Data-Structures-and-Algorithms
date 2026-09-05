class Solution {
    public int dayOfYear(String date) {
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8,date.length()));
        int year = Integer.parseInt(date.substring(0,4));

        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if(year%400==0 ||( year%4==0 && year%100!=0)){
            days[1] = 29;
        }
        int countday = day;
        for( int i = 1; i < month; i++){
            countday += days[i-1]; 
        }
        return countday;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna