class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie t=new Trie();
        for(int i=0;i<arr1.length;i++){
            t.insert(Integer.toString(arr1[i]));
        }
        int ans=0;
        for(int i=0;i<arr2.length;i++){
            int val=t.search(Integer.toString(arr2[i]));
            ans=Math.max(ans,val);
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
        public int search(String word){
            Node curr=root;
            int len=0;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(curr.child.containsKey(ch)){
                    curr=curr.child.get(ch);
                    len++;
                }
                else{
                    break;
                }
            }
            return len;
        }
    }
}