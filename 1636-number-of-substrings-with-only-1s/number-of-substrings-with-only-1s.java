class Solution {
    public int numSub(String s) {
        long ans=0;
        int n=0;
        long MOD = 1000000007;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                n++;
                ans+=n;
            }
            else {
                n=0;
            }
        }
        return (int)(ans%MOD);
    }
}