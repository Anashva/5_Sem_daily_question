class Solution {
    static List<String> ll;
    public List<String> findWords(char[][] maze, String[] words) {
        ll=new ArrayList<>();
        Trie t=new Trie();
        for (String s:words){
            t.insert(s);
        }
        for (int i=0;i<maze.length;i++){
            for (int j=0;j<maze[0].length;j++){
                if(t.root.child.containsKey(maze[i][j])){
                    t.Search(maze,i,j,t.root);
                }
            }
        }
        return ll;

    }
    static class Trie{
        class Node{
            char ch;
            String isTerminal;
            HashMap<Character, Node> child;
            public Node(char ch){
                this.ch=ch;
                child=new HashMap<>();
            }
        }
        private Node root=new Node('*');

        public  void insert(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curr.child.containsKey(ch)) {
                    curr = curr.child.get(ch);
                } else {
                    Trie.Node nn = new Node(ch);
                    curr.child.put(ch, nn);
                    curr = nn;
                }
            }
            curr.isTerminal = word;
        }
        public void Search(char[][] maze, int cr, int cc,Node node ){
            if(cr<0 || cc<0 || cr>= maze.length || cc>=maze[0].length || !node.child.containsKey(maze[cr][cc])){
                return;
            }
            char ch=maze[cr][cc];
            node=node.child.get(ch);
            if(node.isTerminal!=null){
                ll.add(node.isTerminal);
                node.isTerminal=null;
            }
            maze[cr][cc]='*';
            Search(maze,cr+1,cc,node);
            Search(maze,cr-1,cc,node);
            Search(maze,cr,cc+1,node);
            Search(maze,cr,cc-1,node);
            maze[cr][cc]=ch;
        }
    }
}