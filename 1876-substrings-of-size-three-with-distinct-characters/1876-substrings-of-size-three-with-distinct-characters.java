class Solution {
    public int countGoodSubstrings(String s) {
        int len = s.length();
        if(len<3) return 0;
        int count = 0;
        for(int i=0; i<len-2; i++){
            if(s.charAt(i) != s.charAt(i+1) && s.charAt(i) != s.charAt(i+2) && s.charAt(i+1) != s.charAt(i+2)){
                count+=1;
            }
        }
        return count;
    }
}