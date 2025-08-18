class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int i=0;
        int j=0;
        while(i<str1.length() && j<str2.length()){
            int ch=str1.charAt(i)-'a';
            ch=(ch+1)%26;
            char c=(char)(ch+'a');
            if(str1.charAt(i)==str2.charAt(j) || c==str2.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        if(j==str2.length()){
            return true;
        }
        return false;
    }
}