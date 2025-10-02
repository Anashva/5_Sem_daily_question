class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int co=0;
        int cz=0;
        int start=0;
        int end=0;
        int ans=0;
        while(end<s.length()){
            if(s.charAt(end)=='0'){
                cz++;
            }
            else{
                co++;
            }
            while(co>k && cz>k){
                if(s.charAt(start)=='0'){
                    cz--;
                }

                else{
                    co--;
                }
                start++;
            }
            ans+=end-start+1;
            end++;
        }
        return ans;
    }
}