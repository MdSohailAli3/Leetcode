class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp = new int[coins.length+1][amount+1];
        //initializze 0th row as intmax-1
        //because if size is 0, we need to get mini no. of coins to get sum s, but its not possible mathematically we write this as infinity
        // why -1, because in filling of dp we do +1 in it
        for(int i=1; i<amount+1; i++){
            dp[0][i] = Integer.MAX_VALUE-1;
        }

        
        // in col 0 and from row 0 we need to put 0, because sum 0 with coins>=0 is possible by taking 0 coins
        // but 0 is inititalised already when creating dp, so not to worry


        // now dp process 
        for(int i=1; i<coins.length+1; i++){
            for(int j=1; j<amount+1; j++){
                if(coins[i-1] <= j){
                    dp[i][j] = Math.min(dp[i][j-coins[i-1]] + 1, dp[i-1][j]);// +1 bec we taking a coin
                }
                else dp[i][j] = dp[i-1][j];
            }
        }
        return dp[coins.length][amount]==Integer.MAX_VALUE-1 ? -1 : dp[coins.length][amount];
    }
}