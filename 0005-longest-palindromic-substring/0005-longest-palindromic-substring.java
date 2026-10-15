class Solution {
    public String longestPalindrome(String s) {
        int start = 0;
        int maxlen = 0;
        int slen = s.length();
        for(int i=0; i<slen; i++){
            int len1 = expand(s,i,i,slen);// odd len -> aba
            int len2 = expand(s,i,i+1,slen);// even len -> abba

            int templen = Math.max(len1,len2);
            if(templen > maxlen){
                maxlen = templen;
                start = i - (templen-1)/2; // find starting index for both even odd len
            }
        }
        return s.substring(start, start+maxlen);
    }
    private int expand(String s, int left, int right, int len){
        while(left >=0 && right <len && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1; // because both bointers movved
    }
}