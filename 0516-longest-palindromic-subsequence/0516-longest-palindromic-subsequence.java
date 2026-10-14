class Solution {
    public int longestPalindromeSubseq(String s) {
        // to find palindromic subsequence, find lcs of a string and its reverse
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        int len = s.length();
        int[][] dp = new int[len+1][len+1];
        for(int i=1; i<len+1; i++){
            for(int j=1; j<len+1; j++){
                dp[i][j] = s.charAt(i-1) == sb.charAt(j-1) ? 1 + dp[i-1][j-1] : Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }
        return dp[len][len];
    }
}