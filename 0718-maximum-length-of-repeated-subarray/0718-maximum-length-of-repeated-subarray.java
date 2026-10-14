class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        // longest common substring pattern
        int[][] dp = new int[len1+1][len2+1];
        int max = 0;
        for(int i=1; i<len1+1; i++){
            for(int j=1; j<len2+1; j++){
                dp[i][j] = nums1[i-1] == nums2[j-1] ? 1+dp[i-1][j-1] : 0;
                max = Math.max(max,dp[i][j]);
            }
        }

        
        return max;
    }
}