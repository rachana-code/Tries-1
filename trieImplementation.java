class Trie {
    class TrieNode{
        TrieNode[] map;
        boolean isWord;
        public TrieNode(){
            map = new TrieNode[26];
            isWord = false;
        }
    }
    
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(node.map[c - 'a'] == null){
                node.map[c-'a'] = new TrieNode();
            }
            node = node.map[c-'a'];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = root;
        for(char c: word.toCharArray()){
            if(node.map[c-'a'] == null){
                return false;
            }
            node = node.map[c-'a'];
        }
        return node.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(char c: prefix.toCharArray()){
            if(node.map[c-'a'] == null){
                return false;
            }
            node = node.map[c-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
