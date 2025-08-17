class Solution {
    public int removePalindromeSub(String s) {
        if(pall(s)){
            return 1;
        }
        return 2;
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