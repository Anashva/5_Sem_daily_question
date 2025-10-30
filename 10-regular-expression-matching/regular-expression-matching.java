class Solution {
    public boolean isMatch(String s, String p) {
        return expr(s,p,0,0);
    }
    public boolean expr(String s,String p,int i,int j){
        if(i==s.length() && j==p.length()){
            return true;
        }
        if(j==p.length()){
            return false;
        }
        if(i==s.length()){
            while(j + 1 < p.length() && p.charAt(j + 1) == '*'){
                j=j+2;
            }
            return j==p.length();
        }
        boolean ans=(s.charAt(i)==p.charAt(j) || p.charAt(j)=='.');
        if(j+1<p.length() && p.charAt(j+1)=='*'){
            return expr(s,p,i,j+2) || (ans && expr(s,p,i+1,j));
        }
        else{
            if(ans){
                return expr(s,p,i+1,j+1);
            }
            else{
                return false;
            }
        }
    }
}