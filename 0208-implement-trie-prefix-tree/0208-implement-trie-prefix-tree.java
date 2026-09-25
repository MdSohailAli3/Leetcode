class Trie {
    // Each node represents one character
    static class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode current = root;

        for(char ch : word.toCharArray()){
            int index = getIndex(ch);
            if(current.children[index]==null){
                current.children[index] = new TrieNode();
            }
            current = current.children[index];
        }
        current.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode current = root;

        for(char ch : word.toCharArray()){
            int index = getIndex(ch);

            if(current.children[index]==null) return false;

            current = current.children[index];
        }
        return current.isEnd;// we need to ensure that the word ends
    }
    
    public boolean startsWith(String prefix) {
        TrieNode current = root;

        for(char ch : prefix.toCharArray()){
            int index = getIndex(ch);

            if(current.children[index]==null) return false;

            current = current.children[index];
        }
        return true;// we dont need to check that word is ending
    }
    private static int getIndex(char ch){
        return ch-'a';
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */