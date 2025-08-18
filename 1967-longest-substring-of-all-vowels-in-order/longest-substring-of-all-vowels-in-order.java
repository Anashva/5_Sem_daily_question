class Solution {
    public int longestBeautifulSubstring(String s) {
        int ans=0;
        int c=1;
        int vowel=1;
        for(int i=1;i<s.length();i++){
            if(s.charAt(i)==s.charAt(i-1)){
                c++;
            }
            else if(s.charAt(i-1)<s.charAt(i)){
                c++;
                vowel++;
            }
            else{
                c=1;
                vowel=1;
            }
            if(vowel==5){
                ans=Math.max(ans,c);
            }
        }
        return ans;
    }
}