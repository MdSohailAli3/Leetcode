class Solution {
    public boolean backspaceCompare(String s, String t) {
       // plan is to traverse from back and count the #, and remove the skip the amount of characters as the count of #,
        // make sure to check if the skipped char is not the #
        int ptr1 = s.length()-1;
        int ptr2 = t.length()-1;
        int skip1 = 0, skip2 = 0;
         while (ptr1 >= 0 || ptr2 >= 0) {

            // Find next valid character in s
            while (ptr1 >= 0) {
                if (s.charAt(ptr1) == '#') {
                    skip1++;
                    ptr1--;
                } 
                else if (skip1 > 0) {
                    skip1--;
                    ptr1--;
                } 
                else {
                    break; //when normal char apper
                }
            }

            //Find next valid character in t
            while (ptr2 >= 0) {
                if (t.charAt(ptr2) == '#') {
                    skip2++;
                    ptr2--;
                } 
                else if (skip2 > 0) {
                    skip2--;
                    ptr2--;
                } 
                else {
                    break;
                }
            }

            // Both exhausted
            if (ptr1 < 0 && ptr2 < 0) {
                return true;
            }

            // Only one exhausted
            if (ptr1 < 0 || ptr2 < 0) {
                return false;
            }

            // Compare current valid characters
            if (s.charAt(ptr1) != t.charAt(ptr2)) {
                return false;
            }

            ptr1--;
            ptr2--;
        }
        return true;
    }
}