class Solution {
    public int minQueenMoves(int[] source, int[] target) {
        int sr = source[0], sc = source[1];
        int tr = target[0], tc = target[1];
        if(sr==tr && sc==tc) return 0; // same target
        if(sr==tr || sc==tc || sr+sc == tr+tc) return 1; // same row or same col or same left diagnoal
        if(sr<tr) { //now only right diagonal check remains
            sr = target[0];
            sc = target[1];
            tr = source[0];
            tc = source[1];
        } 
        if(sr-tr == sc-tc) return 1; // for that we check the diff of distance
        return 2;
    }
}