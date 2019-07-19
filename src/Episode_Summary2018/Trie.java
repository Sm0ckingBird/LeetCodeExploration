package Episode_Summary2018;

import java.util.HashMap;
import java.util.Map;

public class Trie {
	
	class TrieNode{
        char val;
        Map<Character, TrieNode> map;
        boolean isWord;
        TrieNode(char val){
            this.val = val;
            this.map = new HashMap<Character,TrieNode>();
            this.isWord = false;
            
        }
    }
	
	TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        this.root = new TrieNode('#');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            if(!cur.map.containsKey(word.charAt(i)))
                cur.map.put(word.charAt(i),new TrieNode(word.charAt(i)));
            cur = cur.map.get(word.charAt(i));
        }
        cur.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode cur = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(!cur.map.containsKey(c))
                return false;
            cur = cur.map.get(c);
        }
        return cur.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode cur = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(!cur.map.containsKey(c))
                return false;
            cur = cur.map.get(c);
        }
        return true;
    }
}
