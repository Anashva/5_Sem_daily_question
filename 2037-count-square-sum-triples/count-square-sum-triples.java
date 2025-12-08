class Solution {
    public int countTriples(int n) {
        int ans=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                int c=(int)Math.sqrt(i*i + j*j);
                int d=i*i + j*j;
                if(c*c== d && c<=n){
                    ans++;
                }
            }
        }
        return ans;
    }
}