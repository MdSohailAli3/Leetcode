class Solution {
    public String reverseVowels(String s) {
        char[] st = s.toCharArray();
        int n = st.length;
        int left = 0;
        int right = n-1;
        while(left<right){
           while(left<right && !isVowel(st[left])) left++; //skipping until vowel is not found
           
           while(left<right && !isVowel(st[right])) right--;
            //swapping both the vowels
           char temp = st[left];
           st[left] = st[right];
           st[right] = temp; 
           left++;
           right--;
        }

        return new String(st);


    }
    private static boolean isVowel(char ch){
        return (
            ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' ||
            ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'
        );
    }
}