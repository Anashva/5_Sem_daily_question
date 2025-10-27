class Solution {
    public int numberOfBeams(String[] bank) {
        int ans=0;
        int a=0;
        for(String s:bank){
            int c=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='1'){
                    c++;
                }
            }
            if(c!=0){
                ans+=a*c;
                a=c;
            }
        }
        return ans;
    }
}