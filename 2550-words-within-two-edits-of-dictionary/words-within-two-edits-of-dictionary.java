class Solution {
    public List<String> twoEditWords(String[] queries, String[] dic) {
        List<String> ans=new ArrayList<>();
        Trie t=new Trie();
        for(String s:dic){
            t.insert(s);
        }
        for(String s:queries){
            if(t.search(s)){
                ans.add(s);
            }
        }
        return ans;
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
        private Node root;
        public Trie(){
            root=new Node('*');
        }
        public void insert(String word){
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
            return find(root,word,0,0);
        }
        public boolean find(Node curr,String word,int idx,int c){
            if(c>2){
                return false;
            }
            if(idx==word.length()){
                return curr.isTerminal;
            }
            
            for(char ch:curr.child.keySet()){
                int count=c+(ch==word.charAt(idx) ? 0 : 1);
                if(find(curr.child.get(ch),word,idx+1,count)){
                    return true;
                }
            }
            return false;
        }
    }
}