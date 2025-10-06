class Solution {
    public int findJudge(int n, int[][] trust) {
        if (trust.length == 0) {
            return n == 1 ? 1 : -1;
        }
        HashSet<Integer> st=new HashSet<>();
        for(int i=0;i<trust.length;i++){
            int a=trust[i][0];
            st.add(a);
        }
        int ans=-1;
        for(int i=0;i<trust.length;i++){
            if(!st.contains(trust[i][1])){
                ans=trust[i][1];
                break;
            }
        }
        int c=0;
        for(int i=0;i<trust.length;i++){
            if(trust[i][1]==ans){
                c++;
            }
        }
        if(c==n-1){
            return ans;
        }
        return -1;
    }
}