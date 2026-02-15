class WordDictionary {
    Trie t;
    public WordDictionary() {
        t=new Trie();
    }
    
    public void addWord(String word) {
        t.add(word);
    }
    
    public boolean search(String word) {
        return t.search(word);
    }
    static class Trie{
        class Node{
            char ch;
            boolean isTerminal;
            HashMap<Character,Node> child;
            public Node(char ch){
                this.ch=ch;
                child=new HashMap<>();
            }
        }
            private Node root=new Node('*');
            public void add(String word){
                Node curr=root;
                for(int i=0;i<word.length();i++){
                    char ch=word.charAt(i);
                    if(curr.child.containsKey(ch)){
                        curr=curr.child.get(ch);
                    }
                    else{
                        Node nn=new Node(ch);
                        curr.child.put(ch,nn);
                        curr=nn;
                    }
                }
                curr.isTerminal=true;
            }
            public boolean search(String word){
                return find(word,0,root);
            }
            public boolean find(String word,int idx,Node curr){
                if(idx==word.length()){
                    return curr.isTerminal;
                }
                char ch=word.charAt(idx);
                if(ch!='.'){
                    if(!curr.child.containsKey(ch)){
                        return false;
                    }
                    return find(word,idx+1,curr.child.get(ch));
                }
                for(Node next:curr.child.values()){
                    if(find(word,idx+1,next)){
                        return true;
                    }
                }
                return false;
            }
        }
    }


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */