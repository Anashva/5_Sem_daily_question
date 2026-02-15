class Solution {
    public int maxXor(int[] nums, int k) {
        TreeMap<Integer,Integer> mp=new TreeMap<>();
        int start=0;
        int end=0;
        int ans=0;
        int[] pref=new int[nums.length+1];
        pref[0]=0;
        for(int i=0;i<nums.length;i++){
            pref[i+1]=pref[i] ^ nums[i];
        }
        Trie t=new Trie();
        t.insert(pref[0]);
        while(end<nums.length){
            mp.put(nums[end],mp.getOrDefault(nums[end],0)+1);
            while(start<=end && mp.lastKey()-mp.firstKey()>k){
                int val=nums[start];
                mp.put(val,mp.get(val)-1);
                if(mp.get(val)==0){
                    mp.remove(val);
                }
                t.remove(pref[start]);
                start++;
            }
            ans=Math.max(ans,t.XOR(pref[end+1]));
            t.insert(pref[end+1]);
            end++;

        }
        return ans;
    }
    static class Trie{
        class Node{
            Node zero;
            Node one;
            int count=0;
        }
        private Node root=new Node();
        public void insert(int val){
            Node curr=root;
            for(int i=31;i>=0;i--){
                int bit=val & (1<<i);
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
        public int XOR(int val){
            Node curr=root;
            int ans=0;
            for(int i=31;i>=0;i--){
                int bit=val & (1<<i);
                if(bit==0){
                    if(curr.one!=null && curr.one.count>0){
                        ans=ans | (1<<i);
                        curr=curr.one;
                    }
                    else{
                        curr=curr.zero;
                    }
                }
                else{
                    if(curr.zero!=null && curr.zero.count>0){
                        ans= ans | (1<<i);
                        curr=curr.zero;
                    }
                    else{
                        curr=curr.one;
                    }
                }
            }
            return ans;

        }
        public void remove(int val){
            Node curr=root;
            for(int i=31;i>=0;i--){
                int bit=val & (1<<i);
                if(bit==0){
                    curr=curr.zero;
                }
                else{
                    curr=curr.one;
                }
                curr.count--;
            }
        }
    }
}