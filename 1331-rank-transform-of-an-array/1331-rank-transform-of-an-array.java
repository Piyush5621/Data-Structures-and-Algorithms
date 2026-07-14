class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length;
        int copy[] = Arrays.copyOf(arr, n);
        Arrays.sort(copy);
        int res[] = new int[n];
        int rank = 1;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0; i < n; i++){
            if(!map.containsKey(copy[i])){
                map.put(copy[i],rank++);
            }
        }

        for(int i = 0; i < n ; i++){
            res[i] = map.get(arr[i]);
        }

        return res;

    }
}