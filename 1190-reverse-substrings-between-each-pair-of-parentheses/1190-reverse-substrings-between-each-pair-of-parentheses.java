class Solution {
    public String reverseParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();

        int len = s.length();
        for(int i=0; i<len; i++){
            if(s.charAt(i) == ')'){
                StringBuilder temp = new StringBuilder();
                while(!st.isEmpty() && st.peek() != '('){
                    temp.append(st.pop());
                }
                if(!st.isEmpty()) st.pop(); //removes "("
                int n = temp.length();
                for(int j=0; j<n;j++){
                    st.push(temp.charAt(j));
                }
            }
            else st.push(s.charAt(i));
        }

        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}