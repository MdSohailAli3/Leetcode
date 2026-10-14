class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<m+1; i++){
            for(int j=1; j<n+1; j++){
                dp[i][j] = str1.charAt(i-1)==str2.charAt(j-1)? 1+dp[i-1][j-1] : Math.max(dp[i-1][j],dp[i][j-1]); 
            }
        }
        //now fetching the subsequesnce
        int i=m;
        int j=n;
        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0){
            if(str1.charAt(i-1) == str2.charAt(j-1)){
                sb.append(str1.charAt(i-1));
                i--;
                j--;
            }
            else{
                if(dp[i][j-1] > dp[i-1][j]) {//moves left
                    sb.append(str2.charAt(j-1));
                    j--;
                }
                else {
                    sb.append(str1.charAt(i-1));
                    i--; // moves up in dp
                }
            }
        }
        while(i >0) {
            sb.append(str1.charAt(i-1));
            i--;
            }
        while(j >0) {
            sb.append(str2.charAt(j-1));
            j--;
        }
        sb.reverse();
        return sb.toString();
    }
}