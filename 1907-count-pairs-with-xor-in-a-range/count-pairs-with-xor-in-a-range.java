class Solution {
    public int countPairs(int[] nums, int low, int high) {
        return count(nums,high+1)-count(nums,low);
    }
    public int count(int[] nums,int range){
        Trie t=new Trie();
        int ans=0;
        for(int num:nums){
            ans+=t.xor(num,range);
            t.insert(num);
        }
        return ans;
    }
    static class Trie{
        class Node{
            Node one;
            Node zero;
            int count=0;
        }
        private Node root=new Node();
        public int xor(int num,int limit){
            Node curr=root;
            int ans=0;
            for(int i=15;i>=0;i--){
                int bit=(num >>i) & 1;
                if(curr==null){
                    break;
                }
                int lbit=(limit>>i) & 1;
                if(lbit==1){
                    if(bit==0 && curr.zero!=null){
                        ans+=curr.zero.count;
                    }
                    if(bit==1 && curr.one!=null){
                        ans+=curr.one.count;
                    }
                    curr=(bit==0) ? curr.one : curr.zero;
                }
                else{
                    curr=(bit==0) ? curr.zero : curr.one;
                }
            }
            return ans;
        }
        public void insert(int val){
            Node curr=root;
            for(int i=15;i>=0;i--){
                int bit=val & ( 1<<i);
                if(bit==0){
                    if(curr.zero!=null){
                        curr=curr.zero;
                    }
                    else{
                        Node nn=new Node();
                        curr.zero=nn;
                        curr=nn;
                    }
                }
                else{
                    if(curr.one!=null){
                        curr=curr.one;
                    }
                    else{
                        Node nn=new Node();
                        curr.one=nn;
                        curr=nn;
                    }
                }
                curr.count++;
            }
        }
    }
}