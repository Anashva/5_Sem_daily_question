class Solution {
    public int[] cycleLengthQueries(int n, int[][] queries) {
        int m=queries.length;
        int[] res=new int[m];
        for(int i=0;i<m;i++){
            int a=queries[i][0];
            int b=queries[i][1];
            int ans=1;
            while(a!=b){
                if(a>b){
                    a=a/2;
                }
                else if(b>a){
                    b=b/2;
                    // ans++;
                }
                ans++;
            }
            res[i]=ans;
        }
        return res;
    }
}