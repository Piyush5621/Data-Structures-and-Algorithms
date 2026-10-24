class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {

        int noDays[]= new int[]{
            31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31
        };

        int Aam = Integer.parseInt(arriveAlice.substring(0,2));
        int Lam = Integer.parseInt(leaveAlice.substring(0,2));

        int Abm = Integer.parseInt(arriveBob.substring(0,2));
        int Lbm = Integer.parseInt(leaveBob.substring(0,2));

        int Aad = Integer.parseInt(arriveAlice.substring(3,5));
        int Lad = Integer.parseInt(leaveAlice.substring(3,5));

        int Abd = Integer.parseInt(arriveBob.substring(3,5));
        int Lbd = Integer.parseInt(leaveBob.substring(3,5));
        int common = 0;

        int startMonth  = Math.max(Aam,Abm);
        int endMonth = Math.min(Lam, Lbm);

        if( startMonth > endMonth ) return 0;

        int startDay = (Aam > Abm)? Aad : (Aam < Abm)? Abd : Math.max(Aad,Abd);
        int endDay = (Lam > Lbm)? Lbd : (Lam < Lbm)? Lad : Math.min(Lad,Lbd);

        if( startMonth == endMonth ){
            common += endDay - startDay + 1;
        }
        else{
            common += noDays[startMonth - 1] - startDay + 1;

            for( int i = startMonth + 1; i < endMonth; i++ ){
                common += noDays[i-1];
            }

            common += endDay;
        }

        return Math.max(0, common);

    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna