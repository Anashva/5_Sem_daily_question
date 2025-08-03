class Solution {
    public int minFlipsMonoIncr(String s) {
        int ans=0;
        int one=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                one++;
            }
            else{
                ans=Math.min(ans+1,one);
            }
        }
        return ans;
    }
}