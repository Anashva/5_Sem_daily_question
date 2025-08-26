class Solution {
    public String getSmallestString(int n, int k) {
        char [] ans=new char[n];
        Arrays.fill(ans,'a');
        k-=n;
        while (k > 0) {
            int s = Math.min(k, 25);
            ans[--n] =(char)('a' + s); 
            k -= s;
        }
        return new String(ans);
    }
}