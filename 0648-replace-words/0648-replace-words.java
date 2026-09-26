class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    public TrieNode(){
        children = new TrieNode[26];
        isEnd = false;
    }
}
class Solution {
    private TrieNode root;
    public Solution(){
        root = new TrieNode();
    }
    
    
    public String replaceWords(List<String> dictionary, String sentence) {
        for(String s : dictionary){
            insert(s);
        }
        
        StringBuilder ans = new StringBuilder();
        String[] arr = sentence.split(" ");
        boolean isFirstComplete = false; // flag to check that is first word is added in ans or not, so that we dont add space in front of first word
        for(String s : arr){
            String temp = search(s); // htis is the replacement of our word
            if(isFirstComplete){
                ans.append(" ");
            }
            ans.append(temp);
            isFirstComplete = true;
        }
        return ans.toString();
    }

    //helpper
    private String search(String word){
        TrieNode current = root;
        int len=word.length();
        for(int i=0; i<len; i++){
            int index = word.charAt(i)-'a';
            if(current.children[index]==null) return word; // if it not exist then we just append the same word in our ansewr
            current = current.children[index];
            if(current.isEnd) return word.substring(0,i+1);// if the prefix is found , we append that
        }
        return word;
    }

    //helpper
    private void insert(String word){
        TrieNode current = root;
        for(char ch : word.toCharArray()){
            int index = ch-'a';
            if(current.children[index]==null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }
}