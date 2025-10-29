class Solution {
    public int smallestNumber(int n) {
        while(true){
            if(check(n)){
                return n;
            }
            n=n+1;
        }
    }
    public boolean check(int n){
        String s=Integer.toBinaryString(n);
        if(s.contains("0")){
            return false;
        }
        return true;
    }
}