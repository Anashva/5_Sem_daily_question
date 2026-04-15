class Solution {
    int ans=0;
    public int maxProduct(String s) {
        prod(s,0,"","");
        return ans;
    }
    public void prod(String s,int idx,String s1,String s2){
        if(idx==s.length()){
            if(pall(s1) && pall(s2)){
                ans=Math.max(ans,s1.length()*s2.length());
            }
            return;
        }
        prod(s,idx+1,s1,s2);
        prod(s,idx+1,s1+s.charAt(idx),s2);
        prod(s,idx+1,s1,s2+s.charAt(idx));
    }
    public boolean pall(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}