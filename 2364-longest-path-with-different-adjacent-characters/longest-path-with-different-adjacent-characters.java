class Solution {
    List<Integer>[] ll;
    int ans=1;
    public int longestPath(int[] parent, String s) {
        int n=parent.length;
        ll=new ArrayList[n];
        for(int i=0;i<n;i++){
            ll[i]=new ArrayList<>();
        }
        for(int i=1;i<n;i++){
            ll[parent[i]].add(i);
        }
        longest(0,s);
        return ans;
    }
    public int longest(int u,String s){
        int max1=0;
        int max2=0;
        // int len=0;
        for(int nbr:ll[u]){
            int len=longest(nbr,s);
            if(s.charAt(u)==s.charAt(nbr)){
                continue;
            }
            if(len>max1){
                max2=max1;
                max1=len;
            }
            else if(len>max2){
                max2=len;
            }
        }
        ans=Math.max(ans,max1+max2+1);//complete path child1+root+child2
        return max1+1;//maximum of two extend to upward
    }
}