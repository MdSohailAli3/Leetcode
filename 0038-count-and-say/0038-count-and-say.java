class Solution {
    public String countAndSay(int n) {
        if(n==1) return "1";
        StringBuilder ans = new StringBuilder();
        ans.append("1");
        for(int i=2; i<=n; i++){
            ans = helper(ans);
        }
        return ans.toString();
    }
    private static StringBuilder helper(StringBuilder sb){
       StringBuilder temp = new StringBuilder();
       int len = sb.length();
       int i=0;
       //counting the nums and appending their count and num itself
       while(i<len){
            char ch = sb.charAt(i);
            int count = 0;
            while(i<len && sb.charAt(i)==ch){
                count++;
                i++;
            }
            temp.append(count).append(ch);
       }
       return temp;
    }

}