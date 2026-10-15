class Solution {
    public int countGoodNumbers(long n) {
        long MOD = 1000000007L;
        long evenPlaces = (n+1)/2L;
        long oddPlaces = n/2L;

        long evenChoices = power(5,evenPlaces,MOD); // 5 choices 0,2,4,6,8
        long primeChoices = power(4,oddPlaces,MOD); // 4 choices 2.3.5.7

        return (int)((evenChoices*primeChoices)%MOD);
    }
    private long power(long base, long exp, long MOD){
        long ans = 1;
        while(exp > 0){
            if((exp&1) == 1) ans = (ans*base)%MOD; // if exp is odd, then update ans
            base = (base*base)%MOD;
            exp >>= 1;
        }
        return ans;
    }
}