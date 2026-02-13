class Solution {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans=new ArrayList<>();
        // for(String s:queries){
        //     int i=0;
        //     int j=0;
        //     boolean flag=true;
        //     while(i<s.length()){
        //         if(j<pattern.length() && s.charAt(i)==pattern.charAt(j)){
        //             i++;
        //             j++;
        //         }
        //         else{
        //             if(Character.isUpperCase(s.charAt(i))){
        //                 flag=false;
        //                 break;
        //             }
        //             i++;
        //         }
        //     }
        //     if(j!=pattern.length()){
        //         flag=false;
        //     }
        //     ans.add(flag);
        // }


        Trie t=new Trie();
        t.insert(pattern);
        for(String s:queries){
            ans.add(t.match(s));
        }
        return ans;
    }

    static class Trie {
        class Node {
            boolean isTerminal;
            char ch;
            HashMap<Character, Node> child;

            public Node(char ch) {
                this.ch = ch;
                child = new HashMap<>();
            }
        }

        private Node root;

        public Trie() {
            root = new Node('*');
        }

        public void insert(String word) {
            Node curr = root;
            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (curr.child.containsKey(ch)) {
                    curr = curr.child.get(ch);
                } else {
                    Node nn = new Node(ch);
                    curr.child.put(ch, nn);
                    curr = nn;
                }
            }
            curr.isTerminal = true;
        }
        public boolean match(String word){
            Node curr=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(curr.child.containsKey(ch)){
                    curr=curr.child.get(ch);
                }
                else {
                    if(Character.isUpperCase(ch)){
                        return false;
                    }
                }
            }
            return curr.isTerminal;
        }
    }
}