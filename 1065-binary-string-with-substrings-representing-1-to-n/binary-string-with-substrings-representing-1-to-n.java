class Solution {
    public boolean queryString(String s, int n) {
        for(int i=1;i<=n;i++){
            String t=Integer.toBinaryString(i);
            if(!s.contains(t)){
                return false;
            }
        }
        return true;
    }
}