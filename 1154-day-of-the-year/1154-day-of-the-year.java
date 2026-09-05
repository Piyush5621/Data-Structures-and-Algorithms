class Solution {
    public int dayOfYear(String date) {
        int month = Integer.parseInt(date.substring(5,7));
        int day = Integer.parseInt(date.substring(8,date.length()));
        int year = Integer.parseInt(date.substring(0,4));

        int[] daysBeforeMonth = {0, 31, 59, 90, 120, 151,181, 212, 243, 273, 304, 334};

        int result = daysBeforeMonth[month - 1] + day;
        if( month > 2 && (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0))){
            result++;
        }
        return result;

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna