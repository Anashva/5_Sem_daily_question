class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums);
        int n=queries.length;
        int[][] arr=new int[n][3];
        for(int i=0;i<n;i++){
            arr[i][0]=queries[i][0];
            arr[i][1]=queries[i][1];
            arr[i][2]=i;
        }
        Arrays.sort(arr,(a,b)->a[1]-b[1]);
        int[] ans=new int[n];
        Trie t=new Trie();
        int j=0;

        for (int[] a:arr){
            while(j<nums.length && nums[j]<=a[1]){
                t.add(nums[j]);
                j++;
            }
            if(j==0){
                ans[a[2]]=-1;
            }
            else{
                ans[a[2]]=t.getMaxXor(a[0]);
            }
        }
        return ans;

    }
    static class Trie{
        class Node{
            Node zero;
            Node one;
        }
        private Node root=new Node();
        public void add(int val){
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
            }
        }
        public int getMaxXor(int x){
            int ans=0;
            Node curr=root;
            for(int i=31;i>=0;i--){
                int bit=x & (1<<i);
                if(bit==0){
                    if(curr.one!=null){
                        ans=ans | (1<<i);
                        curr=curr.one;
                    }
                    else{
                        curr=curr.zero;
                    }
                }
                else{
                    if(curr.zero!=null){
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
    }
}