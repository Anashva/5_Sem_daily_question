class Solution {
    public long removeZeros(long n) {
        String s=Long.toString(n);
        if(s.contains("0")){
            s=s.replace("0","");
        }
        return Long.parseLong(s);
    }
}