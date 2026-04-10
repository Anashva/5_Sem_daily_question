class Solution {
    public String gcdOfStrings(String s1, String s2) {
        if(!(s1+s2).equals(s2+s1)){
            return "";
        }
        int a=s1.length();
        int b=s2.length();
        while(b!=0){
            int t=b;
            b=a%b;
            a=t;
        }
        return s1.substring(0,a);
    }
}