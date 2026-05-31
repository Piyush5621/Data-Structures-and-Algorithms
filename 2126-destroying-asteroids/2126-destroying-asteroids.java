class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        long masss = mass;
        Arrays.sort(asteroids);
        for(int x : asteroids){
            if(masss >= x){
                masss += x;
            }
            else{
                return false;
            }
        }
        return true;
    }
}