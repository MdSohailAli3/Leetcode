class Solution {
    public boolean isValid(String s) {
        if((s.length()%2) != 0) return false;
        int top = 0;
        char[] stk = new char[s.length()];

        for(char c: s.toCharArray()){
            if(c=='('){
                stk[top++] = ')';
            }
            else if (c=='{'){
                stk[top++] = '}';
            }
            else if(c=='['){
                stk[top++] = ']';
            }
            else {
                if(top==0 || c != stk[--top]){
                    return false;
                }
            }

        }
        return top == 0;
    }
}