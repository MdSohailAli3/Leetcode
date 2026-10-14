class Solution {
    public int minDistance(String word1, String word2) {
        // find lcs of both string
        // deletion = l1 - lcs
        // insertion = l2 - lcs
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                dp[i][j] = word1.charAt(i-1)==word2.charAt(j-1)? 1+dp[i-1][j-1] : Math.max(dp[i-1][j],dp[i][j-1]);
            }
        }
        int lcs = dp[m][n];
        return m+n-lcs*2;// we need to delete in both strings, m-lcs & n-lcs, add both
        //because we need both to convert to lcs
    }
}