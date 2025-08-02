class Solution {
    public boolean checkInclusion(String s1, String s2) {
       if(s1.length()>s2.length()){
        return false;
       }
       int[] freq1=new int[26];
       for(int i=0;i<s1.length();i++){
        freq1[s1.charAt(i)-'a']++;
       }
       for(int i=0;i<=s2.length()-s1.length();i++){
        int[] freq=new int[26];
        String s=s2.substring(i,i+s1.length());
        for(int j=0;j<s.length();j++){
            freq[s.charAt(j)-'a']++;
        }
        if(check(freq1,freq)){
            return true;
        }
       }
       return false;
    }
    public boolean check(int[] freq1,int [] freq){
        for(int i=0;i<26;i++){
            if(freq1[i]!=freq[i]){
                return false;
            }
        }
        return true;
    }
}