class Solution {
    class pair{
        int row;
        int col;
        int energy;
        int mask;
        pair(int a, int b, int d,int e){
            row = a;
            col = b;
            energy = d;
            mask = e;
        }
    }
    public int minMoves(String[] classroom, int energy) {
        int totalL = 0;
        int n = classroom.length;
        int m = classroom[0].length();
        int Sr = -1;
        int Sc = -1;
        int rr[] = new int[]{-1,0,1,0};
        int cc[] = new int[]{0,1, 0,-1};

        int[][] litterId = new int[n][m];
        for (int[] row : litterId) { 
            Arrays.fill(row, -1); 
        }

        for( int i = 0; i < n ; i++ ){
            for( int j = 0 ; j < m ; j++ ){
                if(classroom[i].charAt(j) == 'L'){
                    litterId[i][j] = totalL;
                    totalL++;
                }
                if(classroom[i].charAt(j) == 'S'){
                    Sr = i;
                    Sc = j;
                }
            }
        } 
        if(totalL == 0 ) return  0;
        int totalMask = 1 << totalL;
        boolean vist[][][][] = new boolean[n][m][energy + 1][totalMask];

        Queue<pair> q = new ArrayDeque<>();

        q.add(new pair(Sr,Sc , energy,0));
        vist[Sr][Sc][energy][0] = true;
        int moves = 0;
        while( !q.isEmpty() ){
            int size = q.size();
            for( int j = 0; j < size; j++){
                pair p = q.poll();
                int or = p.row;
                int oc = p.col;
                int oenergy = p.energy;
                int omask = p.mask;
                
                if (omask == totalMask-1) { 
                    return moves; 
                }
                if (oenergy == 0 && classroom[or].charAt(oc) != 'R') {
                    continue;
                }
                for( int i = 0 ; i < 4; i++ ){
                    int nr = or + rr[i];
                    int nc = oc + cc[i];

                    if( nr >= 0 && nc >= 0 && nr < n && nc < m && classroom[nr].charAt(nc) != 'X'){
                        int currEnergy = oenergy - 1;
                        if(classroom[nr].charAt(nc) == 'R'){
                            currEnergy = energy;
                        }
                        if(currEnergy < 0 ) continue;

                        int currMask = omask;

                        if (classroom[nr].charAt(nc) == 'L') {
                            int id = litterId[nr][nc]; 
                            currMask = omask | (1 << id); 
                        }
                        if( !vist[nr][nc][currEnergy][currMask]){
                            vist[nr][nc][currEnergy][currMask] = true; 
                            q.add(new pair(nr,nc,currEnergy,currMask));
                        }
                    }
                }
            }
            moves++;
        }
        return -1;

    }
}